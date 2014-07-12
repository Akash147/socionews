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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    public DbForWeb(){}
    
    public DbForWeb(String collection_name){
        
    }
    
    public void fetchAll(long user_id) {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("userDB");
            DBCollection table = db.getCollection("userProfileInfo");
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
