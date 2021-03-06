package MainCore;

import  org.htmlparser.Node;
import  org.htmlparser.NodeFilter;
import  org.htmlparser.Parser;
import  org.htmlparser.filters.TagNameFilter;
import  org.htmlparser.tags.TableTag;
import  org.htmlparser.util.NodeList;

/** 
 * <br>
 * 标题: <br>
 * 功能概要: <br>
 * 公司: 明阳OA<br>
 *  @author  张涵
 *  @version  1.0
  */ 
public   class  TestYahoo {
     public   static   void  testHtml() {
         try  {
            String sCurrentLine;
            String sTotalString;
            sCurrentLine  =   "" ;
            sTotalString  =   "" ;
            java.io.InputStream l_urlStream;
            java.net.URL l_url  =   new  java.net.URL(
                     "http://www.jmpj.gov.cn/ShowNews.aspx?guid=200508111117974032&type=51" );
            java.net.HttpURLConnection l_connection  =  (java.net.HttpURLConnection) l_url
                    .openConnection();
            l_connection.connect();
            l_urlStream  =  l_connection.getInputStream();
            java.io.BufferedReader l_reader  =   new  java.io.BufferedReader(
                     new  java.io.InputStreamReader(l_urlStream));
             while  ((sCurrentLine  =  l_reader.readLine())  !=   null ) {
                sTotalString  +=  sCurrentLine;
            }
            System.out.println(sTotalString);

            System.out.println( " ==================== " );
            String testText  =  extractText(sTotalString);
            System.out.println(testText);
        }  catch  (Exception e) {
            e.printStackTrace();
        }

    }

     /** 
     * 抽取纯文本信息
     * 
     *  @param  inputHtml
     *  @return 
      */ 
     public   static  String extractText(String inputHtml)  throws  Exception {
        StringBuffer text  =   new  StringBuffer();

        Parser parser  =  Parser.createParser( new  String(inputHtml.getBytes(),
                 "ISO8859_1" ),  "ISO8859-1" );
         //  遍历所有的节点 
        NodeList nodes  =  parser.extractAllNodesThatMatch( new  NodeFilter() {
             public   boolean  accept(Node node) {
                 return   true ;
            }
        });
        Node node  =  nodes.elementAt( 0 );
        text.append( new  String(node.toPlainTextString().getBytes( "8859_1" )));
         return  text.toString();
    }

     /** 
     * 读取文件的方式来分析内容. filePath也可以是一个Url.
     * 
     *  @param  resource
     *            文件/Url
      */ 
     public   static   void  main(String[] args)  throws  Exception {
    	 testHtml();
       // test5( "http://www.jmpj.gov.cn/ShowNews.aspx?guid=200508111117974032&type=51" );
    }
} 