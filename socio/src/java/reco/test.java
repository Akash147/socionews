/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reco;

import java.util.ArrayList;
import twitter4j.JSONObject;
import java.util.List;
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
        try {
            // gets Twitter instance with default credentials
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer("vJ3dChUEdLKrK7ciMdtbcXPjz", "XnbW32jqk9jTTY5ZtLHMh0FY9UNC1Wb1ohC0ehIaWUXfpJereQ");
            AccessToken aT = new AccessToken("1491849084-9cHPaMX5xgmM8KxobpngNOe6KhcybY6KSivHGyi","d5FSuYaZ8FEcaLFDaI2pt4bLGobWd3f2qIZX3KCT7Ikix");
            twitter.setOAuthAccessToken(aT);
            User user = twitter.verifyCredentials();
            Paging page;
            page = new Paging(1,200);
            List<Status> statuses = twitter.getHomeTimeline(page);
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            for (Status status : statuses) {
//                System.out.println("the since id is:"+page.getSinceId());
//                System.out.println("the max id is:"+page.getMaxId());
//                System.out.println("the count is:"+page.getCount());
//                System.out.println("the status id is:"+status.getId());
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.exit(-1);
        }
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
    }
}
