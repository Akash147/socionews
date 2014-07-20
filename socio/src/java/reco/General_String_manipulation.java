/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import reco.CallbackServlet;
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
        if(str.contains("@")) {
            str = str.substring(0, str.indexOf("@"));
        }
        if(str.startsWith("RT")){
            str = str.substring(str.indexOf(":")+1);
        }
        if(str.startsWith(" ")){
            str = str.substring(str.indexOf(" ")+1);
        }
        return str;
    }
    
    public String separateHyperlink(String status)
    {
        String str = status;
        if(str.contains("http")){
//            str = str.substring(0, str.indexOf("http"));
            str = str.replaceAll("http?://\\S+\\s?", "");
            str = str.replaceAll("https?://\\S+\\s?", "");
        }
        if(str.contains("@")) {
            str = str.replace("@", "");
        }
        if(str.startsWith("RT")){
            str = str.substring(str.indexOf(":")+1);
        }
        if(str.startsWith(" ")){
            str = str.substring(str.indexOf(" ")+1);
        }
        return str;
    }
    
    public ArrayList<String> ret_finalkeyword(ArrayList<String> key){
        ArrayList<String> temp_twits = new ArrayList<String>();
         ArrayList<Integer> twit_count = new ArrayList<Integer>();
        for(String tweet_Keywords: key){
            tweet_Keywords=tweet_Keywords.toLowerCase();
             if (!temp_twits.contains(tweet_Keywords)) {
                   temp_twits.add(tweet_Keywords);
                    }
        }
        for(String temp_twit1:temp_twits){
            int count =0;
            for (String temp_twit2:key){
               if (temp_twit1.equalsIgnoreCase(temp_twit2)){
                   count ++;
               }
            }
            twit_count.add(count);
        }
        Map<String, Integer> twit_sort = new HashMap<String, Integer>();
            for(int j = 0; j < temp_twits.size(); j++)
                twit_sort.put(temp_twits.get(j), twit_count.get(j));
        Map<String, Integer> sortByValues_count = sortByValues(twit_sort);
//        System.out.println(sortByValues_chi);
        int count_keywordnum=0;
        ArrayList<String> tweet_key = new ArrayList<String>();
        
        for (String twit_key :sortByValues_count.keySet()) {
            tweet_key.add(twit_key);
            count_keywordnum++;
            if(count_keywordnum>9){
                break;
            }
        }
        return tweet_key;
    }
    
    public static<K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map){
        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return o2.getValue().compareTo(o1.getValue());
                }
            });
            Map<K,V> sortedMap = new LinkedHashMap<K,V>();     
        for(Map.Entry<K,V> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }     
        return sortedMap;
    }
    
}
