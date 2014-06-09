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
import java.util.List;

/**
 *
 * @author Ivar
 */
    public class DocumentParser {

    //This variable will hold all terms of each document in an array.
    private List<String[]> termsDocsArray = new ArrayList<String[]>();
    private List<String> allTerms = new ArrayList<String>(); //to hold all terms
    private List<double[]> tfidfDocsVector = new ArrayList<double[]>();

    /**
     * Method to read files and store in array.
     * @param filePath : source file path
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void parseFiles(String filePath) throws FileNotFoundException, IOException {
        FileReader readFile= new FileReader(File.separator+"home"+File.separator+"ravi"+File.separator+"test.txt");
        BufferedReader textReader = new BufferedReader(readFile);
        String aline;
        boolean flag;
        while((aline=textReader.readLine())!=null){            
            allTerms.addAll(Arrays.asList(aline.replaceAll("[\\W&&[^\\s]]", "").split(" ")));  //to get individual terms
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
        for (String[] docTermsArray : termsDocsArray){
            double[] tfidfvectors = new double[allTerms.size()];
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
        
    }
    
}
