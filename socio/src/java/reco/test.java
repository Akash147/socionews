/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reco;

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
            Paging page = new Paging(1,200);
            List<Status> statuses = twitter.getUserTimeline(page);
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            for (Status status : statuses) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.exit(-1);
        }
    }
}
