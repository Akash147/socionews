/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newsrecommendation;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
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
public class POs_tagger {
    private static POSModel model = new POSModelLoader()
                .load(new File("en-pos-maxent.bin"));
    public static List<String> POSTag(String input) throws IOException {
         List <String> allWords =new ArrayList<>();

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
            for(int i=0;i<tags.length;i++){
//            System.out.println(tags[i]);
//            System.out.println(whitespaceTokenizerLine[i]);
            if("NN".equals(tags[i]) || "FW".equals(tags[i]) || "NNP".equals(tags[i]) || "VB".equals(tags[i])){
                allWords.add(whitespaceTokenizerLine[i]);
            }
        }
//            System.out.println(sample.toString());

//            perfMon.incrementCounter();
        }
//        perfMon.stopAndPrintFinalResult();
        return allWords;
    }

    
}
