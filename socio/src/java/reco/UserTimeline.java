/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class UserTimeline {
    Twitter twitter;
    AccessToken at;
    User user;
    private UserTimeline(String AccessToken,String access_token_secret) throws TwitterException{
        twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer("vJ3dChUEdLKrK7ciMdtbcXPjz", "XnbW32jqk9jTTY5ZtLHMh0FY9UNC1Wb1ohC0ehIaWUXfpJereQ");
        at = new AccessToken(AccessToken,access_token_secret);
        twitter.setOAuthAccessToken(at);
        user = twitter.verifyCredentials();
    }
public void getUserTweets()
    {
        
    }
}
