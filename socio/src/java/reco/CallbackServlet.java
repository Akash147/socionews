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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import tweet_keyword.Keyword;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;

public class CallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1657390011452788111L;
    private long userId;
    private User user;
    private Tweets key;
   
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
        Keyword keyword = new Keyword(getServletContext());
        
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
            
            twit.add(new Tweets(temp_user, temp_tweets, temp_sent, temp_hash_tags, keyword.POSTag(temp_tweets)));
        }
        //get keywords here
         ArrayList<Tweets> temp_twits = new ArrayList<Tweets>();
         ArrayList<Integer> twit_count = new ArrayList<Integer>();
        for(Tweets tweet_Keywords: twit){
             if (!temp_twits.contains(tweet_Keywords)) {
                   temp_twits.add(tweet_Keywords);
                    }
        }
        for(Tweets temp_twit1:temp_twits){
            int count =0;
            for (Tweets temp_twit2:twit){
               if (temp_twit1.equals(temp_twit2)){
                   count ++;
               }
            }
            twit_count.add(count);
        }
        Map<Tweets, Integer> twit_sort = new HashMap<Tweets, Integer>();
            for(int j = 0; j < temp_twits.size(); j++)
                twit_sort.put(temp_twits.get(j), twit_count.get(j));
        Map<Tweets, Integer> sortByValues_count = sortByValues(twit_sort);
//        System.out.println(sortByValues_chi);
        int count_keywordnum=0;
        ArrayList<Tweets> tweet_key = new ArrayList<Tweets>();
        
        for (Iterator<Tweets> it = sortByValues_count.keySet().iterator(); it.hasNext();) {
            key = it.next();
            tweet_key.add(key);
            count_keywordnum++;
            if(count_keywordnum>9){
                break;
            }
        }

        //store in MongoDB
        userTimeline.storeUserDetailsInMongoDB(twitter);
        userTimeline.storeKeywords(tweet_key);
        
        //send data to userInfo.JSP
        response.setContentType("text/html");
//        request.setAttribute("doto",userTimeline.mergeKeywords(twit));
//        request.setAttribute("mongo", userTimeline.getKeywordsFromMongo());
//        request.setAttribute("todo",twit);
        request.setAttribute("prof", userTimeline.getProfileImage(twitter));
        request.setAttribute("accessToken",userTimeline.getAccessToken());
        request.setAttribute("accessTokenSecret",userTimeline.getTokenSecret());
//        request.setAttribute("userid", userTimeline.getUserID());
//        request.getRequestDispatcher("/userInfo.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/dashboard/index?user="+userTimeline.getUserID());
    }
     /////// used for descending ordering of the term according to the chisquare value of the term////////////////////
    public static<Tweets,V extends Comparable> Map<Tweets,V> sortByValues(Map<Tweets,V> map){
        List<Map.Entry<Tweets,V>> entries = new LinkedList<Map.Entry<Tweets,V>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Tweets,V>>() {
            @Override
            public int compare(Map.Entry<Tweets, V> o1, Map.Entry<Tweets, V> o2) {
                return o2.getValue().compareTo(o1.getValue());
                }
            });
            Map<Tweets,V> sortedMap = new LinkedHashMap<Tweets,V>();     
        for(Map.Entry<Tweets,V> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }     
        return sortedMap;
    }
}
