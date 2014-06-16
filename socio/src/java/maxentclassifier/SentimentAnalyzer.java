/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maxentclassifier;

import cc.mallet.classify.Classifier;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

/**
 *
 * @author Akash
 */
public class SentimentAnalyzer {
    private Classifier classifier;
    private ServletContext context;

    public SentimentAnalyzer(ServletContext context) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.context = context;
        classifier = getSavedKnowledgeBase();
        if(classifier==null)
            System.out.println("whats is this");
        
    }
    
    private Classifier getSavedKnowledgeBase() throws FileNotFoundException, IOException, ClassNotFoundException {
//        ObjectInputStream ois = new ObjectInputStream(context.getResourceAsStream("/resources/maxentClassifier.bin"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/siranami/NetBeansProjects/MaxEntClassifier/maxentClassifier.bin"));
        return (cc.mallet.classify.Classifier) ois.readObject();

    }
    
    public String classify(String tweet){
        return classifier.classify(tweet).getLabeling().getBestLabel().toString();
    }
    
    public List<String> filterPositiveTweets(List<String> input){
        List<String> res = new ArrayList<String>();
        for (String each : input){
            if (this.classify(each).equals("4"))
                res.add(each);
        }
        return res;
    }
    

}