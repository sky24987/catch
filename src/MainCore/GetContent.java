package MainCore;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import org.htmlparser.Parser;
import org.htmlparser.beans.StringBean;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.parserapplications.StringExtractor;
import org.htmlparser.tags.BodyTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
 
public class GetContent { 
    
	public void getContentUsingStringBean(String url) { 
        StringBean sb = new StringBean(); 
        sb.setLinks(true);           
        sb.setCollapse(true);  
        sb.setReplaceNonBreakingSpaces(true);// If true regular space 
        sb.setURL("http://www.blogjava.net/51AOP/archive/2006/07/19/59064.html"); 
        System.out.println("The Content is :\n" + sb.getStrings()); 
 
    } 
    
    public void getContentUsingStringExtractor(String url, boolean link) throws UnsupportedEncodingException { 
        StringExtractor se = new StringExtractor(url); 

        String text = null; 
        try { 
            text = se.extractStrings(link); 
            System.out.println("The content is :\n" + text); 
        } catch (ParserException e) { 
            e.printStackTrace(); 
        } 
    } 
 
    public void getContentUsingParser(String url) throws IOException { 
        NodeList nl; 
        try { 
        	String sCurrentLine;
			String sTotalString;
			sCurrentLine = "";
			sTotalString = "";
			java.io.InputStream l_urlStream;
			java.net.URL l_url = new java.net.URL("http://www.jmpj.gov.cn/ShowNews.aspx?guid=200508111117974032&type=51");
			java.net.HttpURLConnection l_connection = (java.net.HttpURLConnection) l_url
					.openConnection();
			l_connection.connect();
			l_urlStream = l_connection.getInputStream();
			java.io.BufferedReader l_reader = new java.io.BufferedReader(
					new java.io.InputStreamReader(l_urlStream));
			while ((sCurrentLine = l_reader.readLine()) != null) {
				sTotalString += sCurrentLine + "\r\n";
			}
			System.out.println(sTotalString);
            Parser p = new Parser(sTotalString); 
            p.setEncoding("utf-8");
            nl = p.parse(new NodeClassFilter(BodyTag.class)); 
            BodyTag bt = (BodyTag) nl.elementAt(0); 
            System.out.println(new String(bt.toPlainTextString().getBytes("utf-8"),"gbk")); 
            } catch (ParserException e) { 
            e.printStackTrace(); 
        } 
    } 
    
    public static void main(String[] args) throws IOException {
    	GetContent g = new GetContent();
//    	g.getContentUsingStringBean("");
//    	g.getContentUsingParser("http://www.blogjava.net/51AOP/archive/2006/07/19/59064.html");
    	
    	g.getContentUsingStringExtractor("http://www.jmpj.gov.cn/ShowNews.aspx?guid=200508111117974032&type=51",false);
	}
    }