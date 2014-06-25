/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noones
 */
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import java.util.Arrays;


public class Dash {
private String category;
private String miniContent;
private String domain;
private String link;
private String headLine;
private String time;
private String userName;
private String fullName;

private final String host;
    private final int port;
    private final String dbName;
    private final String collectionName;
    private MongoClient mongoClient;
    private DBCollection collection;

    public Dash(String host, int port, String dbName, String collectionName){
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.collectionName = collectionName;
        this.establishConnection();
    } 
    
    public static void main(String[] args) {
    Dash dashb = new Dash("localhost", 27017, "mydb", "testData");
    
}

    Dash() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCategory() {
        return "football";
    }

    public void setCategory(String category) {
        
        this.category = category;
    }

    public String getMiniContent() {
        return miniContent;
    }

    public void setMiniContent(String miniContent) {
        this.miniContent = miniContent;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserName() {
        return "noones";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private boolean establishConnection() {
     try {
            mongoClient = new MongoClient( host , port );
            DB db = mongoClient.getDB(dbName);
            collection = db.getCollection(collectionName);
        } catch (UnknownHostException ex) {
            return false;
        }
        return true;
        
    }
    
    public void close(){
        mongoClient.close();
    }
    
}
