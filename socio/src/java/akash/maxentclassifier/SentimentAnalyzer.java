/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package akash.maxentclassifier;

import cc.mallet.classify.Classifier;
import cc.mallet.classify.MaxEnt;
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
    private MaxEnt classifier;
    private String sentimentModelLocation;

    public SentimentAnalyzer(String _sentimentModelLocation) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.sentimentModelLocation = _sentimentModelLocation;
        classifier = getSavedKnowledgeBase();
    }
    
    private MaxEnt getSavedKnowledgeBase() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.sentimentModelLocation));
        return (MaxEnt) ois.readObject();

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
