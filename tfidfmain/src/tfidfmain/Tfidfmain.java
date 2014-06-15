/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tfidfmain;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Ivar
 */
public class Tfidfmain {

    /**
     * @param args the command line arguments
     */
    /**
     * Main method
     * @param args
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        DocumentParser dp = new DocumentParser();
        dp.parseFiles("/home/ravi/NetBeansProjects/socionews/document");
        dp.tfIdfCalculator(); //calculates tfidf
//        dp.getCosineSimilarity(); //calculated cosine similarity   
    }
}
