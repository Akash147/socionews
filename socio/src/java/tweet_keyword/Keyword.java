/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tweet_keyword;

import akash.configuration.Configuration;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

/**
 *
 * @author ravi
 */
public class Keyword {
    

    public static ArrayList<String> POSTag(String input) throws IOException {
        String filelocation;
        Configuration config = new Configuration();
        filelocation=config.getKeyLocation();
        
        ArrayList <String> keywords = new ArrayList<String>();
        POSModel model = new POSModelLoader()
                .load(new File("en-pos-maxent.bin"));
        PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
        POSTaggerME tagger = new POSTaggerME(model);

//        String input = "Hi. How are you? This is Mike.";
        ObjectStream<String> lineStream = new PlainTextByLineStream(
                new StringReader(input));

        perfMon.start();
        String line;
        while ((line = lineStream.read()) != null) {

            String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE
                    .tokenize(line);
            String[] tags = tagger.tag(whitespaceTokenizerLine);

            POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
//            System.out.println(sample.toString());
            for(int i=0;i<tags.length;i++){
//            System.out.println(tags[i]);
//            System.out.println(whitespaceTokenizerLine[i]);
            if(("NN".equals(tags[i]) || "FW".equals(tags[i]) || "VB".equals(tags[i])) && !keywords.contains(whitespaceTokenizerLine[i])){
                keywords.add(whitespaceTokenizerLine[i]);
            }
        }

            perfMon.incrementCounter();
        }
        perfMon.stopAndPrintFinalResult();
        return keywords;
    }

}
