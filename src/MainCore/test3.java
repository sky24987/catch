package MainCore;


import org.htmlparser.Node; 
import org.htmlparser.NodeFilter; 
import org.htmlparser.Parser; 
import org.htmlparser.PrototypicalNodeFactory; 
import org.htmlparser.filters.HasAttributeFilter; 
import org.htmlparser.filters.NodeClassFilter; 
import org.htmlparser.filters.NotFilter; 
import org.htmlparser.tags.ImageTag; 
import org.htmlparser.tags.LinkTag; 
import org.htmlparser.util.NodeList; 
import org.htmlparser.util.ParserException; 
 
public class test3 { 
 
    /** 
     * @author rrong_m 
     * @throws ParserException 
     */ 
    public static void getALlLinks(String url) throws ParserException { 
        Parser parser = new Parser(url); 
        NodeFilter filter = new HasAttributeFilter("id", "finance"); 
        NodeList nodelist = parser.extractAllNodesThatMatch(filter); 
        filter = new NodeClassFilter(LinkTag.class); 
        nodelist = nodelist.extractAllNodesThatMatch(filter, true); 
        for (Node node : nodelist.toNodeArray()) { 
            if (node instanceof LinkTag) { 
                LinkTag link = (LinkTag) node; 
                String l = link.getLink(); 
                getNewsContent(l); 
                getNewsTitle(l); 
            } 
        } 
    } 
 
    public static void getNewsContent(String url) throws ParserException { 
        String newsContent = null; 
        Parser parser = new Parser(url); 
        PrototypicalNodeFactory p = new PrototypicalNodeFactory(); 
        p.registerTag(new ImageTag()); 
        parser.setNodeFactory(p); 
        parser.setEncoding("gb2312"); 
        NodeFilter filter = new HasAttributeFilter("class","blkContainerSblkCon"); 
        NodeList nodelist = parser.extractAllNodesThatMatch(filter); 
        getImageUrl(nodelist); 
        filter = new NodeClassFilter(ImageTag.class); 
        nodelist = nodelist.extractAllNodesThatMatch(filter, true); 
        if (nodelist.size() > 0) { 
            for (int i = 1; i < nodelist.size() - 1; i++) { 
                newsContent=nodelist.elementAt(i).toPlainTextString(); 
                System.out.println(newsContent); 
            } 
        } 
    } 
    public static void getNewsTitle(String url) throws ParserException { 
        String title = null; 
        Parser parser = new Parser(url); 
        parser.setEncoding("gb2312"); 
        NodeFilter filter = new HasAttributeFilter("id","artibodyTitle"); 
        NodeList nodelist = parser.extractAllNodesThatMatch(filter); 
        if(nodelist.size()>0) 
        { 
            title=nodelist.elementAt(0).toPlainTextString(); 
        } 
        System.out.println(title); 
    } 
    public static void getImageUrl(NodeList nodelist) 
    { 
        NodeFilter filter=new NodeClassFilter(ImageTag.class); 
        nodelist=nodelist.extractAllNodesThatMatch(filter, true); 
        for(Node node:nodelist.toNodeArray()) 
        { 
            if(node instanceof ImageTag) 
            { 
                ImageTag img=(ImageTag) node; 
                System.out.println(img.getImageURL()); 
            } 
        } 
    } 
    public static void main(String[] args) throws ParserException { 
        getALlLinks("http://sina.com.cn"); 
} 
 
}
