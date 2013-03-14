package MainCore;
import java.net.*;
import java.io.*;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.beans.LinkBean;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.NodeVisitor;


public class CheckURL {
     
     /**
     *
     * @param urlvalue
     *
     * @return 获取url内容
     */
  public static String check(String urlvalue ) {
	 
	 
	  String inputLine="";
	  String line2 = "";
	  
		try{
				URL url = new URL(urlvalue);
				
				HttpURLConnection urlConnection  = (HttpURLConnection)url.openConnection();
				
				BufferedReader in  = new BufferedReader(
			            new InputStreamReader(
			            		urlConnection.getInputStream()));
				while ((line2 = in.readLine()) != null) { 
				inputLine+=line2;
				}
		}
				catch(Exception e){
					e.printStackTrace();
				}
			System.out.println(inputLine);  //系统打印出抓取得验证结果
			
	    return inputLine;
  }

  public void test1(){
	  try { 

		    NodeFilter filter = new NodeClassFilter(LinkTag.class);

		    Parser parser = new Parser();

		    parser.setURL("http://www.jmpj.gov.cn/ShowNews.aspx?guid=200508111117974032&type=51");

		    parser.setEncoding("UTF-8");

		    NodeList list = parser.extractAllNodesThatMatch(filter);

		    for (int i = 0; i < list.size(); i++) {

		        LinkTag node = (LinkTag) list.elementAt(i);

		        System.out.println("testLinkTag() Link is :"+ node.extractLink());
		     //   System.out.println("testLinkTag() Link is :"+ node.getLinkText());

		    }

		} catch (Exception e) {

		    e.printStackTrace();

		} 

  }
  public void test2(){
	  Parser parser = new Parser(); 

	  LinkBean linkBean = new LinkBean();

	  linkBean.setURL("http://www.google.com");

	  URL[] urls = linkBean.getLinks(); 

	  for (int i = 0; i < urls.length; i++) {

	      URL url = urls[i];

	      System.out.println ("testLinkBean() -url  is :" + url);

	  } 

  }
  	public void test3(){
  		try {

  		    Parser parser = new Parser();

  		    parser.setURL("http://www.google.com");

  		    parser.setEncoding(parser.getEncoding());

  		    NodeVisitor visitor = new NodeVisitor() {

  		        public void visitTag(Tag tag) {

  		            System.out.println ("testVisitorAll()  Tag name is :"

  		                    + tag.getTagName() + " \n Class is :"

  		                    + tag.getClass());

  		        } 

  		    }; 

  		    parser.visitAllNodesWith(visitor);

  		} catch (ParserException e) {

  		    e.printStackTrace();

  		} 

  	}
  
  public static void main(String a[]){
	System.out.println(check("http://www.jmpj.gov.cn/ShowNews.aspx?guid=200508111117974032&type=51"));
	CheckURL ch = new CheckURL();
	ch.test1();
	ch.test2();
	ch.test3();
  }


  }