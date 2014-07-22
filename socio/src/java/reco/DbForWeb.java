/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reco;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Prabesh
 */
public class DbForWeb {
    private String fullName;
    private String screenName;
    private String token;
    private String tokenSecret;
    private String profileImage;
    private String userDescription;
    private Date createdDate;
    private long userID;
    private String location;
    private int following;
    public String temp;
    private MongoClient mongo;
    public DbForWeb(){}
    
    public DBCollection userMongoStart(String tableName) throws UnknownHostException {
        mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("userDB");
        DBCollection table = db.getCollection(tableName);
        return table;  
    }
    
    public ArrayList<String> getKeywordsFromMongo(long id) {
        ArrayList<String> keywords = new ArrayList<String>();
        try {
            DBCollection table = this.userMongoStart("tweetKeywords");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("userID", id);

            DBCursor cursor = table.find(searchQuery);

            while (cursor.hasNext()) {
                keywords = (ArrayList<String>)cursor.next().get("keywords");
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return keywords;
    }
    
    public String makeSearchString(ArrayList<String> keywords) {
        StringBuilder searchString = new StringBuilder();
        ArrayList<String> remove_dot_at_last = new ArrayList<String>();
        for(String fine_string : keywords){
            if(fine_string.endsWith(".")){
                fine_string = fine_string.substring(0,fine_string.lastIndexOf("."));
            }
            remove_dot_at_last.add(fine_string);
        }
        keywords.clear();
        for(String str : remove_dot_at_last){
            searchString.append(str+"+");
        }
        return searchString.toString().substring(0, searchString.lastIndexOf("+"));
    }
    
    public void fetchAll(long user_id) {
        try {
            
            DBCollection table = this.userMongoStart("userProfileInfo");
            BasicDBObject searchQuery = new BasicDBObject();
            //searching parameter set to accessToken
            searchQuery.put("userID", user_id);
            DBObject dbobj = table.findOne(searchQuery);
            //get all property values from db
            this.fullName = dbobj.get("fullName").toString();
            this.screenName = dbobj.get("screenName").toString();
            this.location = dbobj.get("location").toString();
            this.userDescription = dbobj.get("userDescription").toString();
            this.profileImage = dbobj.get("profileImage").toString();
            this.token = dbobj.get("token").toString();
            this.tokenSecret = dbobj.get("tokenSecret").toString();
            this.following = Integer.parseInt(dbobj.get("following").toString());
            this.userID = Long.parseLong(dbobj.get("userID").toString());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            temp = df.format((Date)dbobj.get("createdDate"));
            this.createdDate = (Date)dbobj.get("createdDate");
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void storeNewsToBeRead(String newsID, String newsHead, String newsMeta){
        try {
            DBCollection table = this.userMongoStart("newsToBeRead");
            BasicDBObject newsToBe = new BasicDBObject();
            if(!this.checkReapeatedNews(newsID)){
                newsToBe.put("newsID", newsID);
                newsToBe.put("newsHead", newsHead);
                newsToBe.put("newsShort", newsMeta);
                table.insert(newsToBe); 
            }
            mongo.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(DbForWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean checkReapeatedNews(String newsId) {
        boolean flag = false;
        try {
            DBCollection table = this.userMongoStart("newsToBeRead");
            BasicDBObject newsObj = new BasicDBObject();
            newsObj.put("newsID", newsId);
            DBCursor cursor = table.find(newsObj);
            while(cursor.hasNext()){
                flag = true;
                break;
            }
            mongo.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(DbForWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public String[] getSentimentTweet(long Uid, int count){
        String[] result = new String[2];
        try {
            DBCollection table = this.userMongoStart("userTweets");
            BasicDBObject dbObj = new BasicDBObject();
            dbObj.put("userID", Uid);
            DBCursor cursor = table.find(dbObj);
            for(int x = 1; x <= count; x++){
                result[0] = cursor.next().get("tweet").toString();
                result[1] = cursor.next().get("sentiment").toString();
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(DbForWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public String getFullName() {
        return this.fullName;
    }
    public String getScreenName() {
        return this.screenName;
    }
    public String getStringDate() {
        return temp;
    }
    public String getImageURL() {
        return this.profileImage;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    public String getToken() {
        return this.token;
    }
    public String getTokenSecret() {
        return this.tokenSecret;
    }
    public int getFollowingNum() {
        return this.following;
    }
    public String getUserDescription() {
        return this.userDescription;
    }
    public String getLocation() {
        return this.location;
    }
    
    
}
