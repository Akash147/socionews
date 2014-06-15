/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newsrecommendation;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.regex.Pattern;

/**
 *
 * @author ravi
 */
public class XmlReader {
    public void readXml() {
 
    try {
 
	File fXmlFile = new File("/home/ravi/reut2-001.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
 
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("TEXT");
 
	System.out.println("----------------------------");
    String title= new String();
    String text= new String();
	for (int temp = 0; temp < nList.getLength(); temp++) {
       
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			try{
                Element eElement = (Element) nNode;
                title=eElement.getElementsByTagName("TITLE").item(0).getTextContent();
            
                text=eElement.getElementsByTagName("BODY").item(0).getTextContent();
            }catch(NullPointerException e){
                System.out.println(e);
                text = title;
            }
		}
        System.out.println("title: "+ title);
//        System.out.println("text: "+ text);
        title=squeezeWhitespace(title);
        text=squeezeWhitespace(text);
        WordExtraction e= new WordExtraction();
        e.parseFile(text,title);
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
    Pattern Whitespace = Pattern.compile("[\\s\\p{Zs}]+");
    /** "foo   bar " => "foo bar" */
    public String squeezeWhitespace (String input){
        return Whitespace.matcher(input).replaceAll(" ").trim();
    }
}
