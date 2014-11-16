/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reco;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import twitter4j.HashtagEntity;
import twitter4j.Status;


/**
 *
 * @author Prabesh
 */
public final class Tweets{
    public String cleanTweets;
    public String userName;
    public ArrayList<String> hashTags;
    public ArrayList<String> keywords;
    public int temp;
    public String sentiment;
    public Tweets(String user, String twits, String senti, ArrayList<String> tags, ArrayList<String> keys){
        userName = user;
        cleanTweets = twits;
        sentiment = senti;
        hashTags = tags;
        if(keys != null){
            keywords = keys;
        }else{
            keywords.add("EPL");
            keywords.add("Manchester city");
            keywords.add("Liverpool");
            keywords.add("Gerard");
            keywords.add("Chelsea FC");
        }
    }
   
    public void setTweets(Status status, ServletContext context){
        this.setUserName(status);
        
    }
    public void setUserName(Status status){
        userName = status.getUser().getScreenName();
    }
    public void getHash_Tags(Status status){
        if(status.getHashtagEntities() != null){
            for(HashtagEntity hash : status.getHashtagEntities())
            {
                hashTags.add(hash.getText());
            }
        }
        
    }
    public void separateHyperlink(Status status)
    {
        String str = status.getText();
        if(str.contains("http")){
            str = str.substring(0, str.indexOf("http"));
        }
        
        if(str.startsWith("RT")){
            str = str.substring(str.indexOf(":")+1);
        }
        if(str.startsWith(" ")){
            str = str.substring(str.indexOf(" ")+1);
        }
        cleanTweets = str;
    }
//    public void analyseSentiment(Status status, ServletContext context) throws IOException{
//        maxentclassifier.SentimentAnalyzer analyzer = null ;
//        try {
//            analyzer = new maxentclassifier.SentimentAnalyzer(context);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(CallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        separateHyperlink(status);
//        this.sentiment = analyzer.classify(this.cleanTweets);
//    }
}
