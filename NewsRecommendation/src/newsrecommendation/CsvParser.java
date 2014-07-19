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
public class CsvParser {
    public void csvparse() throws FileNotFoundException, IOException{
    FileReader readFile= new FileReader(File.separator+"home"+File.separator+"ravi"+File.separator+"newsEve.csv");
        BufferedReader textReader = new BufferedReader(readFile);
        String aline;
//        List<String> news = new ArrayList<String>();
         String[] news;
        String news1 = new String();
         String title1 = new String();
        boolean flag;
       
        while((aline=textReader.readLine())!=null){            
//            allWords.addAll(Arrays.asList(aline.replaceAll("[\\W&&[^\\s]]", "").split(" ")));  //to get individual terms
            List<String> words= new ArrayList<>();
            words.addAll(Arrays.asList(aline.split(",")));
            System.out.println(words);
            news1= words.get(1);
            title1 = words.get(0);
//            news=news1.split(" ");
//            title1=title1.split(" ").toString();
//            news1=news.toString();
          WordExtraction e= new WordExtraction();    
        e.parseFile(news1,title1);
             
        }
}
}
