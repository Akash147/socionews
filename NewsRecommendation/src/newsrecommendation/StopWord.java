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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ravi
 */
public class StopWord {
    private final List<String> allStopWords=new ArrayList<>();; //to hold all stopwords
    void extractStopWords() throws FileNotFoundException, IOException{
         FileReader readFile= new FileReader(File.separator+"home"+File.separator+"ravi"+File.separator+"output.txt");
        BufferedReader textReader = new BufferedReader(readFile);
        String aline;        
        while((aline=textReader.readLine())!=null){
            allStopWords.addAll(Arrays.asList(aline.replaceAll("[\\W&&[^\\s]]", "").split(" ")));   //to get individual terms
        }
    }
    
    boolean isStopWord(String word) throws FileNotFoundException, IOException{       
//        boolean flag=false;
        for(String eachStopWord:allStopWords){
           if(eachStopWord.equalsIgnoreCase(word)){
               return true;
           }
        }
       return false; 
    }           
}
