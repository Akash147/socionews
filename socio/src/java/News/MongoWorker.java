/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package News;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Akash
 */
public class MongoWorker {
    private final String host;
    private final int port;
    private final String dbName;
    private final String collectionName;
    private MongoClient mongoClient;
    private DBCollection collection;
    
    public MongoWorker(String host, int port, String dbName, String collectionName) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.collectionName = collectionName;
        this.establishConnection();
    }
    
    private boolean establishConnection(){
        try {
            mongoClient = new MongoClient( host , port );
            DB db = mongoClient.getDB(dbName);
            collection = db.getCollection(collectionName);
        } catch (UnknownHostException ex) {
            return false;
        }
        return true;
    }
    
    public DisplayNews findDocumentById(String id) throws URISyntaxException { // test
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));
        DBObject dbObj = collection.findOne(query);
        DisplayNews news = new DisplayNews();
        news.setHeadLine( dbObj.get("Title").toString() );
        Document doc = Jsoup.parse( dbObj.get("Content").toString() ); 
        news.setNewsContent( doc.toString() );
        news.setMetaDescription( doc.text().substring(0, 100)+"..." );
        news.setNewsTime( dbObj.get("Date").toString() );
        news.setSourceLink( dbObj.get("URL").toString() );
        news.setNewsId( dbObj.get("_id").toString() );
        news.setSourceDomain( getDomainName(dbObj.get("URL").toString()) );
        return news;
    }
    
    public List<DisplayNews> findAllDocumentByID(String[] ids) throws URISyntaxException{
        List<DisplayNews> resultList = new ArrayList<DisplayNews>();
        for(String id : ids)
            resultList.add( this.findDocumentById(id) );
        return resultList;
    }
    
    public static String getDomainName(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }
}
