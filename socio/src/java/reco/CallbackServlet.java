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
        AccessToken accessToken = null;
        try {
            accessToken = twitter.getOAuthAccessToken(requestToken, verifier);
            request.getSession().removeAttribute("requestToken");
//            request.getSession().setAttribute("access_token", accessToken);
        } catch (TwitterException e) {
            throw new ServletException(e);
//            accessToken = (AccessToken) request.getSession().getAttribute("access_token");
        }
        userId = accessToken.getUserId();
        try {
            user = twitter.showUser(userId);
        } catch (TwitterException ex) {
            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //testing passing the list
        List<Status> statuses = null;
        try {
            //        try {
//            Query query = new Query("football");
//            QueryResult result = twitter.search(query);
//            statuses = result.getTweets();
//            for (Status status : result.getTweets()) {
//                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
//            }
//        } catch (TwitterException ex) {
//            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
            statuses = twitter.getUserTimeline();
        } catch (TwitterException ex) {
            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Showing home timeline.");
        ArrayList<String> userTweets = new ArrayList<String>();
        ArrayList<String> hashTags = new ArrayList<String>();
        
        
        /* Sentiment processing things... Will load via config file */
        // These steps shouldnot be here...... Just for demo... IDK where it should be
        
        Configuration config = new Configuration(getServletContext());
        akash.maxentclassifier.SentimentAnalyzer analyzer = null ;
        try {
            analyzer = new akash.maxentclassifier.SentimentAnalyzer(config.getSentimentModelFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<String> stringified = new ArrayList<String>(); // @TODO
        for (Status status : statuses) {
            stringified.add(status.getText()); // @TODO
            
            System.out.println(status.getUser().getName() + ":" +
                               status.getText());
            String sentiment = analyzer.classify(status.getText());
            userTweets.add(status.getText() + " <b>" + sentiment + "</b><br />");
            for(HashtagEntity hash : status.getHashtagEntities())
            {
                hashTags.add(hash.getText());
            }
        }
        List<String> positiveOnlyTweets = analyzer.filterPositiveTweets(stringified); // @TODO
        userTweets.add( "<br /><br /><b>Positive Only tweets</b><br />");
        for(String eachPositive : positiveOnlyTweets){
            userTweets.add(eachPositive + "<br />");
        }
        
        /* End of sentiment processing thing */
        
        response.setContentType("text/html");
        request.setAttribute("todo", userTweets);
        request.setAttribute("hast_tags",hashTags);
        request.setAttribute("accessToken",accessToken.getToken());
        request.setAttribute("accessTokenSecret",accessToken.getTokenSecret());
        request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
       // response.sendRedirect(request.getContextPath() + "/userInfo.jsp?user="+userTweets);
    }
}
