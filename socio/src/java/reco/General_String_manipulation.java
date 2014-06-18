/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reco;

import twitter4j.Status;

/**
 *
 * @author Prabesh
 */
public class General_String_manipulation {
    public String get_separateHyperlink(Status status)
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
        return str;
    }
}
