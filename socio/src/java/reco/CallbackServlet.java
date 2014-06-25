/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reco;

import akash.configuration.Configuration;
import java.io.FileNotFoundException;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.URLEntity;
import twitter4j.HashtagEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.servlet.http.HttpSession;
import akash.maxentclassifier.SentimentAnalyzer;
import tweet_keyword.Keyword;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;

public class CallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1657390011452788111L;
    private long userId;
    private User user;
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
        RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
        String verifier = request.getParameter("oauth_verifier");
        
        // use of UserTimeline.java
        
        UserTimeline userTimeline = new UserTimeline(twitter, requestToken, verifier);
        request.getSession().removeAttribute("requestToken");
        userTimeline.setUser(twitter);
        
        //declaring List variable to store tweets
        List<Status> statuses = null;
        ArrayList<Tweets> twit = new ArrayList<Tweets>();
        String temp_user,temp_tweets,temp_sent;
        
        //collect status from twitter
        statuses = userTimeline.getPagedTweets(1,twitter);
        
        //sentiment calculation
        Configuration config = new Configuration(getServletContext());
        akash.maxentclassifier.SentimentAnalyzer analyzer = null ;
        try {
            analyzer = new akash.maxentclassifier.SentimentAnalyzer(config.getSentimentModelFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //create Tweets objects
//        Keyword key= new Keyword();
        for(Status status : statuses){
            ArrayList<String> temp_hash_tags = new ArrayList<String>();
            if(status.getHashtagEntities() != null){
                for(HashtagEntity hash : status.getHashtagEntities())
                {
                    temp_hash_tags.add(hash.getText());
                }
            }
            temp_user = status.getUser().getScreenName();
            temp_sent = analyzer.classify(status.getText());
            General_String_manipulation gsm = new General_String_manipulation();
            temp_tweets = gsm.get_separateHyperlink(status);
            
            
            Keyword keyword = new Keyword(getServletContext());
            twit.add(new Tweets(temp_user, temp_tweets, temp_sent, temp_hash_tags, keyword.POSTag(temp_tweets)));
        }
        //get keywords here
        
        //store keyworkd in tweetKeyword collection here
        //includes userID(long) and keywords(String[])
        

        //store in MongoDB
        userTimeline.storeUserDetailsInMongoDB(twitter);
        
        //send data to userInfo.JSP
        response.setContentType("text/html");
        request.setAttribute("todo",twit);
        
        request.setAttribute("prof", userTimeline.getProfileImage(twitter));
        request.setAttribute("accessToken",userTimeline.getAccessToken());
        request.setAttribute("accessTokenSecret",userTimeline.getTokenSecret());
        request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
//        response.sendRedirect(request.getContextPath() + "/dashboard/index.jsp?user="+userTimeline.getUserID());
    }
}
