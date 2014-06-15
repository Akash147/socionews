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
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *
 * @author Prabesh
 */
public class UserTimeline {
    Twitter twitter;
    private AccessToken at;
    private long userID;
    private String token;
    private String tokenSecret;
    private User user;
    
    List<Status> statuses = null;
    ArrayList<String> userTweets = new ArrayList<String>();
    ArrayList<String> hashTags = new ArrayList<String>();
        
    private UserTimeline(String AccessToken,String access_token_secret) throws TwitterException{
        twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer("vJ3dChUEdLKrK7ciMdtbcXPjz", "XnbW32jqk9jTTY5ZtLHMh0FY9UNC1Wb1ohC0ehIaWUXfpJereQ");
        at = new AccessToken(AccessToken,access_token_secret);
        twitter.setOAuthAccessToken(at);
        user = twitter.verifyCredentials();
    }
<<<<<<< HEAD
public void getUserTweets()
=======
    public UserTimeline(Twitter twitter, RequestToken requestToken, String verifier)
>>>>>>> 5a478220fe8133ae2b734a89123722631a8264e1
    {
        try {
            at = twitter.getOAuthAccessToken(requestToken, verifier);
        } catch (TwitterException ex) {
            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public List<Status> getNormalTweets()
    {
        // returns only 20 tweets
        try {
            statuses = twitter.getUserTimeline();
        } catch (TwitterException ex) {
            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statuses;
    }
    public List<Status> getPagedTweets(int i)
    {
        // returns tweets of i pages
        Paging page = new Paging(i,200);
        try {
            statuses = twitter.getUserTimeline(page);
        } catch (TwitterException ex) {
            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statuses;
    }
    public List<Status> getTimedTweets(Date date1, Date date2)
    {
        try {
            statuses = twitter.getFavorites();
        } catch (TwitterException ex) {
            Logger.getLogger(UserTimeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statuses;
    }
}
