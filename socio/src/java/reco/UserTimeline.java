/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reco;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.IDs;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *
 * @author Prabesh
 */
public class UserTimeline {
   // public Twitter twitter;
    private AccessToken at;
    private long userID;
    private String token;
    private String tokenSecret;
    private User user;
    public Integer count;
    
    List<Status> statuses = null;
    ArrayList<String> userTweets = new ArrayList<String>();
    ArrayList<String> hashTags = new ArrayList<String>();
        
    public UserTimeline(Twitter twitter, RequestToken requestToken, String verifier)
    {
        count = 0;
        try {
            at = twitter.getOAuthAccessToken(requestToken, verifier);
        } catch (TwitterException ex) {
            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getAccessToken()
    {
        return token;
    }
    public AccessToken returnAccessToken()
    {
        return at;
    }
    public void setUser(Twitter twitter)
    {
        //gives every information about user access through getUserID and accessToken
        userID = returnAccessToken().getUserId();
        token = returnAccessToken().getToken();
        tokenSecret = returnAccessToken().getTokenSecret();
        try {
            user = twitter.showUser(this.getUserID());
        } catch (TwitterException ex) {
            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public long getUserID()
    {
        return userID;
    }
    public String getToken()
    {
        return token;
    }
    public String getTokenSecret()
    {
        return tokenSecret;
    }
    public User getUser()
    {
        return user;
    }
    
    public List<Status> getNormalTweets(Twitter twitter)
    {
        // returns only 20 tweets
        try {
            statuses = twitter.getUserTimeline();
        } catch (TwitterException ex) {
            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statuses;
    }
    public List<Status> getPagedTweets(int i, Twitter twitter)
    {
        // returns tweets of i pages
        Paging page = new Paging(i,200);
        try {
            this.statuses = twitter.getUserTimeline(page);
        } catch (TwitterException ex) {
            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statuses;
    }
    public List<Status> getTimedTweets(Twitter twitter, Date date1, Date date2)
    {
        try {
            statuses = twitter.getFavorites();
        } catch (TwitterException ex) {
            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statuses;
    }
    public void storeUserDetailsInMongoDB(Twitter twitter) throws UnknownHostException
    {
        if(!this.checkRepeatOnMongoDB()){
            //start mongoDB
            try{
                MongoClient mongo = new MongoClient("localhost", 27017);
                DB db = mongo.getDB("userDB");
                DBCollection table = db.getCollection("userProfileInfo");
                BasicDBObject document = new BasicDBObject();
                document.put("fullName", this.getUser().getName());
                document.put("userID", this.getUserID());
                document.put("createdDate", this.getUser().getCreatedAt());
                document.put("screenName", this.getUser().getScreenName());
                document.put("token", this.getAccessToken());
                document.put("tokenSecret", this.getTokenSecret());
                document.put("userDescription", this.getUser().getDescription());
                document.put("location", this.getUser().getLocation());
                document.put("following", this.getUser().getFriendsCount());
                document.put("profileImage", this.getUser().getOriginalProfileImageURL());
                table.insert(document);
            }catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public boolean checkRepeatOnMongoDB() {
        boolean flag = false;
        Integer document_count = 0;
            //check access token already exists
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("userDB");
            DBCollection table = db.getCollection("userProfileInfo");
            BasicDBObject searchQuery = new BasicDBObject();
            //searching parameter set to accessToken
            searchQuery.put("token", this.getAccessToken());
            DBCursor cursor = table.find(searchQuery);
        
            while (cursor.hasNext()) {
                cursor.next();
                document_count++;
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //make logic for check
        if(document_count == 1 || document_count >= 1){
            return true;
        }else{
            return false;
        }
    }
    
    public String getProfileImage(Twitter twitter){
        String addr = new String();
        addr = ""+this.getUser().getFriendsCount();
        return addr;
    }
    
    public ArrayList<String> mergeKeywords(ArrayList<Tweets> T) {
        ArrayList<String> temp = new ArrayList<String>();
        for(Tweets twt : T) {
            temp.addAll(twt.hashTags);
            temp.addAll(twt.keywords);
        }
        return temp;
    }
    
    public void storeKeywords(ArrayList<Tweets> T) {
        ArrayList<String> keywords = new ArrayList<String>();
        keywords = this.mergeKeywords(T);
        try {
            DBCollection table = this.userMongoStart("tweetKeywords");
            BasicDBObject document = new BasicDBObject();
            document.put("userID", this.getUserID());
            document.put("keywords", keywords);
            table.insert(document);
        } catch (UnknownHostException ex) {
            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public DBCollection userMongoStart(String tableName) throws UnknownHostException {
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("userDB");
        DBCollection table = db.getCollection(tableName);
        return table;  
    }
    
    public ArrayList<String> getKeywordsFromMongo() {
        ArrayList<String> keywords = new ArrayList<String>();
        try {
            DBCollection table = this.userMongoStart("tweetKeywords");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("userID", this.getUserID());

            DBCursor cursor = table.find(searchQuery);

            while (cursor.hasNext()) {
                keywords = (ArrayList<String>)cursor.next().get("keywords");
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return keywords;
    }
}
