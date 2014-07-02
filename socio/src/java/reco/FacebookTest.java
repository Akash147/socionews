/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reco;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import facebook4j.auth.OAuthSupport;


/**
 *
 * @author Prabesh
 */
public class FacebookTest {
   
    public static void main(String[] argv) throws FacebookException {
        Facebook facebook = new FacebookFactory().getInstance();
//        request.getSession().setAttribute("facebook", facebook);
//        Facebook facebookClient = facebookFactory.getInstance();
        facebook.setOAuthAppId("1435702100030020", "5e890283f9a69e5bbd7babebf9b2da68");
        facebook.setOAuthPermissions("public_profile,email,user_status");
        AccessToken accessToken = null;
        String accessTokenString = "CAAUZAw3Gs8kQBANjR7v42DnS0IPei64UZAoN6xerF4iFYutl3RPZBOvXWOMARHBsqgZC9uEAPWaSTYHIN4QH2myTdQguXaPkcQwQxZAHfpWOMO7y7B3OSvO6TmLHiY9dVYiAQ87kjyxv8RcimttuMOUYkL7LItR3kk8hXlq0QhOJw2LlW8aX2QkHaybOJVFIZD";
        AccessToken at = new AccessToken(accessTokenString);
        // Set access token.
        facebook.setOAuthAccessToken(at);    //results in an error says {An active access token must be used to query information about the current user}
        System.out.println("the fdad" + facebook.getGroupPictureURL(accessTokenString).toString());
    }
}
