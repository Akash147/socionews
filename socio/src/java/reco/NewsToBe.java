/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reco;

/**
 *
 * @author Prabesh
 */
public class NewsToBe {
    public String newsID;
    public String newsHead;
    public String newsShort;
    public long userID;
    NewsToBe(String a, String b, String c, long d){
        userID = d;
        newsID = a;
        newsHead = b;
        newsShort = c;
    }
}
