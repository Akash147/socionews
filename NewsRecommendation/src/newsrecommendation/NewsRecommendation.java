/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newsrecommendation;

import java.io.IOException;

/**
 *
 * @author ravi
 */
public class NewsRecommendation {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        XmlReader e = new XmlReader();
        e.readXml();
    }
    
}
