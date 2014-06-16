
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletContext;
/**
 *
 * @author Akash
 */
public class Configuration {
    private Properties config;
    private ServletContext context;
    
    // Lucene related parameters
    private String luceneLocation;
    
    // Mongo related parameters
    private String mongoHost;
    private int mongoPort;
    private String mongoDB;
    private String mongoCollection;
    
    // Sentiment analyser trained thing
    private String sentimentModelFile;

    public Configuration(ServletContext _context) throws IOException {
        this.context = _context;
        config = new Properties();
        config.load(context.getResourceAsStream("/conf/config.properties"));
        mongoHost = config.getProperty("mongoHost");
        mongoPort = Integer.parseInt( config.getProperty("mongoPort") );
        mongoDB = config.getProperty("mongoDB");
        mongoCollection = config.getProperty("mongoCollection");
        luceneLocation = config.getProperty("indexLocation");
        sentimentModelFile = config.getProperty("sentimentModel");
    }

    public String getSentimentModelFile() {
        return sentimentModelFile;
    }

    public String getLuceneLocation() {
        return luceneLocation;
    }

    public String getMongoHost() {
        return mongoHost;
    }

    public int getMongoPort() {
        return mongoPort;
    }

    public String getMongoDB() {
        return mongoDB;
    }

    public String getMongoCollection() {
        return mongoCollection;
    }
    
}
