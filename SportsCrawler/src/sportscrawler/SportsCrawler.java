/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sportscrawler;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 

/**
 *
 * @author noones
 */
public class SportsCrawler {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) throws IOException {
                
//		
//                Document doc = Jsoup.connect("http://edition.cnn.com/SPORT/archive").get();
//		Elements Divs = doc.select("div[id^=archive-display-page]");    
//                Elements Links = Divs.select("a[class^=cnn-social]");
//                 //System.out.println(Links);  
//                  for(Element e: Links){
//                      //Element link = e.first();
//                        String url = e.attr("abs:href");
//                        System.out.println("url = " + url);
//		}
// 
            
            Document doc = Jsoup.connect("http://edition.cnn.com/2014/05/08/sport/waisale-serevi-rugby-sevens-hong-kong/index.html").get();
            Elements newsContainer = doc.select("div[class^=cnn_strycntntlft]");
            //Elements filterScript = newsContainer.removeAttr("script");
            //Elements filterStyle = filterScript.removeAttr("styls");
            
            System.out.print(newsContainer.text());
	}
    
}
