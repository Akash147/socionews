package newscrawl.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noones
 */
public class CSVWorker {
    private PrintWriter out;
    public CSVWorker(){
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("myfile.tsv", true)));
        } catch (IOException ex) {
            Logger.getLogger(CSVWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void indexThis(String content, String title, String clas){
        out.println(title + "\t" + content + "\t" + clas);
        out.flush();
    }
}
