/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Profile;

import java.util.List;

/**
 *
 * @author noones
 */
public abstract class DisplayProfile {
    private int userId;
    private int userProgress; // %
    private int userType; //0 1 2
    private boolean facebookLinked;
    private boolean twitterLinked;
    private String userName;
    private String fullName;
    private String joinedDate;
    private String avatar;
    private List newsList; // newsID
    
    //constructor
    public DisplayProfile(){
        avatar = "default."+"png";
    }
    
    public boolean isFacebook(){
        return this.facebookLinked==true;
    }
    
    public boolean isTwitter(){
        return this.twitterLinked==true;
    }

    public List getNewsList() {
        return newsList;
    }

    public void setNewsList(List newsList) {
        this.newsList = newsList;
    }
    
    
    
    
    
    
    
    
    
    
}
