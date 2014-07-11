/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reco;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.ArrayList;
import twitter4j.JSONObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

/**
 *
 * @author Prabesh
 */
public class test {
     public static void main(String[] args) {
        
         
//         try {
//            // gets Twitter instance with default credentials
//            Twitter twitter = new TwitterFactory().getInstance();
//            twitter.setOAuthConsumer("vJ3dChUEdLKrK7ciMdtbcXPjz", "XnbW32jqk9jTTY5ZtLHMh0FY9UNC1Wb1ohC0ehIaWUXfpJereQ");
//            AccessToken aT = new AccessToken("1491849084-9cHPaMX5xgmM8KxobpngNOe6KhcybY6KSivHGyi","d5FSuYaZ8FEcaLFDaI2pt4bLGobWd3f2qIZX3KCT7Ikix");
//            twitter.setOAuthAccessToken(aT);
//            User user = twitter.verifyCredentials();
//            Paging page;
//            page = new Paging(1,200);
//            List<Status> statuses = twitter.getHomeTimeline(page);
//            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
//            for (Status status : statuses) {
////                System.out.println("the since id is:"+page.getSinceId());
////                System.out.println("the max id is:"+page.getMaxId());
////                System.out.println("the count is:"+page.getCount());
////                System.out.println("the status id is:"+status.getId());
//                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
//            }
//        } catch (TwitterException te) {
//            te.printStackTrace();
//            System.exit(-1);
//        }
         
         
         
         
         
         
//         ArrayList<String> tags = new ArrayList<String>();
//         tags.add("hero");
//         tags.add("zero");
//         ArrayList<Tweets> twet = new ArrayList<Tweets>();
//         twet.add(new Tweets("Prabesh", "now or never", "4", tags));
//         twet.add(new Tweets("hero", "hero never dies in film", "0", tags));
//         for(Tweets twt : twet)
//         {
//             System.out.println(twt.cleanTweets);
//             System.out.println(twt.hashTags);
//             System.out.println(twt.sentiment);
//             System.out.println();
//         }
//         System.out.println(new JSONObject(twet));
         
         
         
         
         
//         int document_count = 0;
//            //check access token already exists
//        try {
//            MongoClient mongo = new MongoClient("localhost", 27017);
//            DB db = mongo.getDB("userDB");
//            DBCollection table = db.getCollection("userProfileInfo");
//            BasicDBObject searchQuery = new BasicDBObject();
//            //searching parameter set to accessToken
//            searchQuery.put("token", "1491849084-9cHPaMX5xgmM8KxobpngNOe6KhcybY6KSivHGyi");
//            DBCursor cursor = table.find(searchQuery);
//        
//            while (cursor.hasNext()) {
//                cursor.next();
//                document_count++;
//            }
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         System.out.println("the count of same document is "+document_count);
         
//         DbForWeb hero = new DbForWeb();
//         hero.fetchAll(1491849084);
//         System.out.println("the full name is : "+hero.getFullName());
//         System.out.println("the screen name is : "+hero.getScreenName());
//         System.out.println("the ISO date is : "+hero.getStringDate());
         
         General_String_manipulation gsm2 = new General_String_manipulation();
        ArrayList<String> final_keywords = new ArrayList<String>();
        ArrayList<String> final_key = new ArrayList<String>();
        ArrayList<String> tweet_key = new ArrayList<String>();
        final_keywords.add("ram");
        final_keywords.add("shyam");
        final_keywords.add("hai");
        final_keywords.add("hari");
        final_keywords.add("hari");
        final_keywords.add("rawwm");
        final_keywords.add("hari");
        final_keywords.add("radf");
        final_keywords.add("#3");
        final_keywords.add("#23232");
        final_keywords.add("#1223");
        final_keywords.add("ram");
        final_keywords.add("#djafjds;fja;");
        final_keywords.add("dfasdasdfdsafasdf");
        final_key.add("dfadfadfad");
        final_key.add("ram");
        final_key.add("ram");
        ArrayList<String> keywords = new ArrayList<String>();
        keywords.addAll(final_keywords);
        keywords.addAll(final_key);
        ArrayList<String> fs = new ArrayList<String>();
        for(String kw : keywords){
            if(!kw.startsWith("#")){
                fs.add(kw);
            }
        }
        
        tweet_key= gsm2.ret_finalkeyword(keywords);
         System.out.println(fs);
    }
}
