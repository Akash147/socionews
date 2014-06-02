/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twitter;
import java.util.List;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
        

/**
 *
 * @author noones
 */
public class SocioTwitter {
    
    public static void main(String[] args) throws TwitterException {

    Twitter twtter = TwitterFactory.getSingleton();
    List<Status> statuses = twtter.getHomeTimeline();
    System.out.println("Showing home timeline.");
    for (Status status : statuses) {
        System.out.println(status.getUser().getName() + ":" +
                           status.getText());
    }
        
    }
        
}
    

