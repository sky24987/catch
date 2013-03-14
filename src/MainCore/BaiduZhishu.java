package MainCore;

 
import org.htmlparser.Node; 
import org.htmlparser.NodeFilter; 
import org.htmlparser.Parser; 
import org.htmlparser.filters.HasAttributeFilter; 
import org.htmlparser.tags.Span; 
import org.htmlparser.tags.TableColumn; 
import org.htmlparser.tags.TableRow; 
import org.htmlparser.tags.TableTag; 
import org.htmlparser.util.NodeList; 
import org.htmlparser.util.ParserException; 
 
public class BaiduZhishu { 
 
    /** 
     * @author rrong_m 
     * @param args 
     * @throws ParserException  
     */ 
    public static void getXiangguan(String url) throws ParserException//相关检索词 
    { 
        Parser parser=new Parser(url); 
        parser.setEncoding("gb2312"); 
        NodeFilter filter=new HasAttributeFilter("style","margin-left:10px; float:left"); 
        NodeList nodelist=parser.extractAllNodesThatMatch(filter); 
        NodeList n1=P(nodelist.elementAt(0).getChildren(),"class","tdkeyr"); 
        NodeList n2=P(nodelist.elementAt(0).getChildren(),"class","bar"); 
        for(int i=0;i<n1.size();i++) 
        { 
            System.out.print(n1.elementAt(i).toPlainTextString()+"||||"); 
            Node node=n2.elementAt(i); 
            if(node instanceof Span) 
            { 
                Span s=(Span) node; 
                String temp=s.getAttribute("style"); 
                System.out.println(temp.split("%")[0].split(":")[1]); 
            }
            }
            //获得百分比。。        } 
    } 
    public static NodeList P(NodeList nodelist,String a,String b) 
    { 
        NodeFilter filter=new HasAttributeFilter(a,b); 
        nodelist=nodelist.extractAllNodesThatMatch(filter, true); 
        return nodelist; 
    } 
    public static void getShangSheng(String url) throws ParserException//上升最快的检索词 
    { 
        Parser parser=new Parser(url); 
        parser.setEncoding("gb2312"); 
        NodeFilter filter=new HasAttributeFilter("style","margin-left:10px; float:right"); 
        NodeList nodelist=parser.extractAllNodesThatMatch(filter); 
        if(nodelist.size()>0) 
        { 
            Node node=nodelist.elementAt(0); 
            if(node instanceof TableTag) 
            { 
                TableTag table=(TableTag) node; 
                for(TableRow tr:table.getRows()) 
                { 
                    String temp=""; 
                    for(TableColumn tc:tr.getColumns()) 
                    { 
                        temp=temp+tc.toPlainTextString(); 
                    } 
                    System.out.println(temp); 
                } 
            } 
        } 
    } 
    public static void main(String[] args) throws ParserException { 
        getXiangguan("http://index.baidu.com/main/word.php?word=java"); 
        getShangSheng("http://index.baidu.com/main/word.php?word=java"); 
 
    } 
 
} 

