/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tfidfmain;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ivar
 */
    public class DocumentParser {

    //This variable will hold all terms of each document in an array.
    private List<String[]> termsDocsArray = new ArrayList<String[]>();
    private List<String> allTerms = new ArrayList<String>(); //to hold all terms
    private List<double[]> tfidfDocsVector = new ArrayList<double[]>();
    private List<String> tokenizedTerms = new ArrayList<String>();
    private final List<String> keyword = new ArrayList<String>();
    StopWord stop=new StopWord();
    
    /**
     * Method to read files and store in array.
     * @param filePath : source file path
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void parseFiles(String filePath) throws FileNotFoundException, IOException {
        stop.extractStopWords();
        FileReader readFile= new FileReader(File.separator+"home"+File.separator+"ravi"+File.separator+"test.txt");
        BufferedReader textReader = new BufferedReader(readFile);
        String aline;
        boolean flag;
        while((aline=textReader.readLine())!=null){            
            tokenizedTerms.addAll(Arrays.asList(aline.replaceAll("[\\W&&[^\\s]]", "").toLowerCase().split(" ")));  //to get individual terms
        }
        for (String eachWord : tokenizedTerms) {
//            stemmedWord = stem.stripAffixes(eachWord);
            if (!allTerms.contains(eachWord)) {
                if (!this.stop.isStopWord(eachWord)) {
                    allTerms.add(eachWord);
                }
            }
//           allWords.add(eachWord);
        }
        File[] allfiles = new File(filePath).listFiles();
        BufferedReader in = null;
        for (File f : allfiles) {
            if (f.getName().endsWith(".txt")) {
                in = new BufferedReader(new FileReader(f));
                StringBuilder sb = new StringBuilder();
                String s = null;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                }
                String[] tokenizedTerms = sb.toString().replaceAll("[\\W&&[^\\s]]", "").split("\\W+");   //to get individual terms
                
                termsDocsArray.add(tokenizedTerms);
            }
        }
        System.out.println("term of test   :"+allTerms);
        for (String[] arr :termsDocsArray) {
            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * Method to create termVector according to its tfidf score.
     */
    public void tfIdfCalculator() {
        double tf; //term frequency
        double idf; //inverse document frequency
        double tfidf; //term requency inverse document frequency  
        double[] tfidfvectors = new double[allTerms.size()];
        for (String[] docTermsArray : termsDocsArray){
            
            int count = 0;
           for (String terms : allTerms)   {
                tf = new TfIdf().tfCalculator(docTermsArray, terms);
                idf = new TfIdf().idfCalculator(termsDocsArray, terms);
//                System.out.println(terms+"tf"+tf);
//                System.out.println(terms+"idf"+idf);
                tfidf = tf * idf;
                System.out.println(terms+"tfidf"+tfidf);
                tfidfvectors[count] = tfidf;
//                System.out.println(terms+"="+tfidf);
                count++;
            }
            
        }
        Map<String, Double> m_chi = new HashMap<>();
            for(int j = 0; j < allTerms.size(); j++)
                m_chi.put(allTerms.get(j), tfidfvectors[j]);
        Map<String, Double> sortByValues_chi = sortByValues(m_chi);
//        System.out.println(sortByValues_chi);
        int count_keywordnum=0;
        for (String key : sortByValues_chi.keySet()) {
            keyword.add(key);
            count_keywordnum++;
            if(count_keywordnum>4){
                break;
            }
            
        }
        System.out.println("keyword "+keyword);
        
    }
    public static<K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map){
        List<Map.Entry<K,V>> entries = new LinkedList<>(map.entrySet());
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
