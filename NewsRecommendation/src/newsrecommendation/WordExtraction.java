/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newsrecommendation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author ravi
 */
public class WordExtraction {
    private final List<String> tokenizedTerms; //to hold all words after removing stop words
    private List<String> allWords; //to hold all words after stemming
//    private final List<String> beforeStemAllWords; //to hold all words before stemming
    private final List<String> keyword; //to hold all keyword
    private List<String> permAllWords; //to hold all permuted terms of the all words
    private List<String> posTerm;
    List<Integer> termCount = new ArrayList<>(); // to hold the frequency of the word
    List<String> titleWord = new ArrayList<>();
    List<Double> value_Chi = new ArrayList<>(); // to hold the chisquare value of the word
    List<Double> count = new ArrayList<>();
    String[] tokewords;
    StopWord stop=new StopWord();
   
        
    public WordExtraction() throws IOException {
        this.permAllWords = new ArrayList<>();
        this.allWords = new ArrayList<>();
        this.tokenizedTerms = new ArrayList<>();
        this.posTerm= new ArrayList<>();
//        this.beforeStemAllWords = new ArrayList<>();
        this.keyword = new ArrayList<>();
        this.stop.extractStopWords();
       
    }
    public void parseFile(String aline ,String title) throws FileNotFoundException, IOException{
//        FileReader readFile= new FileReader(File.separator+"home"+File.separator+"ravi"+File.separator+"test.txt");
//        BufferedReader textReader = new BufferedReader(readFile);
//        String aline;
//        boolean flag;
//        while((aline=textReader.readLine())!=null){            
//            allWords.addAll(Arrays.asList(aline.replaceAll("[\\W&&[^\\s]]", "").split(" ")));  //to get individual terms
//        }
//        allWords= POs_tagger.POSTag(aline);  //to get individual terms
//        System.out.println("allwords "+allWords);
        allWords.addAll(Arrays.asList(aline.toLowerCase().replaceAll("[\\W&&[^\\s]]", "").split(" ")));
        titleWord.addAll(Arrays.asList(title.toLowerCase().replaceAll("[\\W&&[^\\s]]", "").split(" ")));  //to get title word
//        Stemming stem = new Stemming();
//        String stemmedWord= new String();
        posTerm= POs_tagger.POSTag(aline.toLowerCase());
        for (String eachWord : posTerm) {
//            stemmedWord = stem.stripAffixes(eachWord);
            if (!tokenizedTerms.contains(eachWord)) {
                if (!this.stop.isStopWord(eachWord)) {
                    tokenizedTerms.add(eachWord);
                }
            }
//           allWords.add(eachWord);
        }
        tokewords = new String[tokenizedTerms.size()];
        tokewords= (String[]) tokenizedTerms.toArray(tokewords);
        Combination <String> all=new Combination<>(allWords);
        permAllWords= all.getCombAllWords();
//        System.out.println(tokenizedTerms);
//        System.out.println("before"+tokenizedTerms);
//        Map<String, Integer> maxCountWord = new HashMap<>();
//            for(int j = 0; j < tokenizedTerms.size(); j++)
//                maxCountWord.put(tokenizedTerms.get(j), termCount.get(j));
//        Map<String, Integer> sortByValues = sortByValues(maxCountWord);
//        System.out.println(sortByValues);
        calculateChi();
        Map<String, Double> m_chi = new HashMap<>();
         Map<String, Double> num_word = new HashMap<>();
            for(int j = 0; j < tokenizedTerms.size(); j++)
                m_chi.put(tokenizedTerms.get(j), value_Chi.get(j));
            for(int j = 0; j < tokenizedTerms.size(); j++)
                num_word.put(tokenizedTerms.get(j), count.get(j));
        Map<String, Double> sortByValues_chi = sortByValues(m_chi);
        Map<String, Double> sortByCount = sortByValues(num_word);
//        System.out.println(sortByValues_chi);
         FileWriter writer = new FileWriter("/home/ravi/utput.csv");
//         Iterator it =sortByValues_chi.entrySet().iterator();
//    while (it.hasNext()) {
//        Map.Entry pairs = (Map.Entry)it.next();
//        System.out.println(pairs.getKey() + " = " + pairs.getValue());
//        writer.write(pairs.getKey()+","+pairs.getValue()+"\n");
////        it.remove(); // avoids a ConcurrentModificationException
//    }
//    Iterator it1 =sortByCount.entrySet().iterator();
//    while (it1.hasNext()) {
//        Map.Entry pairs = (Map.Entry)it1.next();
//        System.out.println(pairs.getKey() + " = " + pairs.getValue());
//        writer.write(pairs.getKey()+" "+pairs.getValue()+"\n");
////        it.remove(); // avoids a ConcurrentModificationException
//    }
//        for (String key : sortByValues_chi.keySet()) {
//            System.out.println(sortByValues_chi.values());
//        
//        writer.write(key+" ");
////        writer.write(val);
//        }
       writer.write(title +",");
        int count_keywordnum=0;
        for (String key : sortByValues_chi.keySet()) {
            keyword.add(key);
            writer.write(" "+key);
            count_keywordnum++;
            if(count_keywordnum>4){
                break;
            }
            
        }
        writer.write("\n");
        writer.close();
        
        System.out.println(keyword);
        calculatePrecision();
//        System.out.println("after"+tokenizedTerms);
    }
     
    
    /////// used for descending ordering of the term according to the chisquare value of the term////////////////////
    public static<K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map){
        List<Map.Entry<K,V>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {
            @Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o2.getValue().compareTo(o1.getValue());
                }
            });
            Map<K,V> sortedMap = new LinkedHashMap<K,V>();     
        for(Map.Entry<K,V> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }     
        return sortedMap;
    }
    
    public void calculateChi(){
        double pg = 0;
        for(int i=0;i<tokewords.length;i++){
            String eachterm = tokewords[i];
            String nextterm = "";
            if(i<tokewords.length-2){nextterm = tokewords[i+1];}
            else{
               nextterm= tokewords[i];
            }
            double chi=0;
            double nw=1;
           for(String eachWord:allWords){
               if(eachWord.equalsIgnoreCase(eachterm)){
                   nw++;
               }
               
        }
           count.add(nw);
        for(String term:tokenizedTerms){
            double freq=0;
            
            pg=0;
            String word=null;
            String words=null;
            word= eachterm + term;
            words=term + eachterm;
            for(String xyz: permAllWords){
                if(word.equalsIgnoreCase(xyz)||words.equalsIgnoreCase(xyz)){
                freq++;
                }
            }
            for(String ravi:allWords){
               if(ravi.equalsIgnoreCase(nextterm)){
                   pg++;
               }
            }
            pg=pg/allWords.size();
            chi=chi+ (Math.pow((freq-(nw*pg)),2))/(nw*pg);
            if(Double.isNaN(chi)){
                chi=0;
            }
//            chi1.add(chi);
        }
        value_Chi.add(chi);
        }
        
//        System.out.println("ravi"+value_Chi);
    }
    float precision=0;
public void calculatePrecision(){
    float  count=0;
    
    for(String Title:titleWord){
        for(String Keyword:keyword){
            if(Title.equals(Keyword)){
                count++;
            }
        }
    }
//    precision=count/(float)keyword.size();
    System.out.println("count"+count);
    System.out.println("key tot"+titleWord.size());
    precision=count/(float)keyword.size();
    System.out.println("title word"+titleWord);
    System.out.println("pre is"+precision);
}
           
}

