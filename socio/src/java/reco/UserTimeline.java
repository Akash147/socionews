/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.IDs;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.net.UnknownHostException;

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
        
//    private UserTimeline(String AccessToken,String access_token_secret) throws TwitterException{
//        twitter = new TwitterFactory().getInstance();
//        twitter.setOAuthConsumer("vJ3dChUEdLKrK7ciMdtbcXPjz", "XnbW32jqk9jTTY5ZtLHMh0FY9UNC1Wb1ohC0ehIaWUXfpJereQ");
//        at = new AccessToken(AccessToken,access_token_secret);
//        twitter.setOAuthAccessToken(at);
//        user = twitter.verifyCredentials();
//    }
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
    
    public boolean checkRepeatOnMongoDB(Twitter twitter) {
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
//                    System.out.println("Found 1 "+ cursor.next().get("name"));
                document_count++;
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public String getProfileImage(Twitter twitter){
        String addr = new String();
        addr = ""+this.getUser().getFriendsCount();
        return addr;
    }
    
}
