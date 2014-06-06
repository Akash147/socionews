/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reco;

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
        } catch (TwitterException e) {
            throw new ServletException(e);
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
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                               status.getText());
            userTweets.add(status.getText());
            for(HashtagEntity hash : status.getHashtagEntities())
            {
                hashTags.add(hash.getText());
            }
        }
        response.setContentType("text/html");
        request.setAttribute("todo", userTweets);
        request.setAttribute("hast_tags",hashTags);
        request.setAttribute("accessToken",accessToken.getToken());
        request.setAttribute("accessTokenSecret",accessToken.getTokenSecret());
//        request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
       // response.sendRedirect(request.getContextPath() + "/userInfo.jsp?user="+userTweets);
    }
}