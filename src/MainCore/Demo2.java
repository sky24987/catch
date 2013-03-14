package MainCore;

import java.io.IOException; 

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

 
public class Demo2 { 
 
    /** 
     * @author rrong_m 
     * @throws IOException  
     * @throws HttpException  
     */ 
    public static void getHtml() throws HttpException, IOException 
    { 
        HttpClient hc=new HttpClient(); 
        hc.getParams().setContentCharset("UTF-8"); 
        PostMethod pm=new PostMethod("http://lsg.cnki.net/grid20/Brief.aspx?ID=1&classtype=&systemno=&NaviDatabaseName=&NaviField="); 
        pm.addParameter("ID", ""); 
        pm.addParameter("hdnSearchType", ""); 
        pm.addParameter("hdnIsAll", "true"); 
        pm.addParameter("NaviField", "专题子栏目代码"); 
        pm.addParameter("NaviDatabaseName", "ZJCLS"); 
        pm.addParameter("systemno", ""); 
        pm.addParameter("hdnFathorCode", "sysAll"); 
        pm.addParameter("selectbox", "A"); 
        pm.addParameter("selectbox", "B"); 
        pm.addParameter("selectbox", "C"); 
        pm.addParameter("selectbox", "D"); 
        pm.addParameter("selectbox", "E"); 
        pm.addParameter("selectbox", "F"); 
        pm.addParameter("selectbox", "G"); 
        pm.addParameter("selectbox", "H"); 
        pm.addParameter("selectbox", "I"); 
        pm.addParameter("selectbox", "J"); 
        pm.addParameter("strNavigatorValue", ",A,B,C,D,E,F,G,H,I,J"); 
        pm.addParameter("strNavigatorName", ",理工A(数学物理力学天地生),理工B(化学化工冶金环境矿业),理工C(机电航空交通水利建筑能源),农业,医药卫生,文史哲,政治军事与法律,教育与社会科学综合,电子技术及信息科学,经济与管理"); 
        pm.addParameter("singleleafcode", ""); 
        pm.addParameter("searchAttachCondition", ""); 
        pm.addParameter("SearchQueryID", ""); 
        pm.addParameter("SearchFieldRelationDirectory", "主题/[],篇名/[],题名/[],作者&英文作者/[SYS_Author_Relevant],关键词[],第一责任人/[SYS_Author_Relevant],机构/[SYS_Organization_Relevant],摘要/[],引文/[],基金/[SYS_Fund_Relevant],全文/[]"); 
        pm.addParameter("updateTempDB", "CJFDTEMP,CJFDYTMP"); 
        pm.addParameter("bCurYearTempDB", "1"); 
        pm.addParameter("fieldnowordfrequency", "关键词,作者,第一责任人,机构,中文刊名&英文刊名,年',期',基金,分类号',ISSN',CN',DOI'"); 
        pm.addParameter("fieldtips", "篇名/[在文献标题中检索。对该检索项的检索是按词进行的，请尽可能输入完整的词，以避免漏检。],关键词/[检索文献的关键词中满足检索条件的文献。对该检索项的检索是按词进行的，请尽可能输入完整的词，以避免漏检。],第一责任人/[请选择检索项并指定相应的检索词，选择排序方式、匹配模式、文献时间等限定条件，然后点击“检索”。],作者/[可输入作者完整姓名，或只输入连续的一部分。],机构/[可输入完整的机构名称，或只输入连续的一部分。],中文摘要/[对该检索项的检索是按词进行的，请尽可能输入完整的词，以避免漏检。],引文/[请选择检索项并指定相应的检索词，选择排序方式、匹配模式、文献时间等限定条件，然后点击“检索”。],全文/请选择检索项并指定相应的检索词，选择排序方式、匹配模式、文献时间等限定条件，然后点击“检索”。],基金/[检索受满足条件的基金资助的文献。],中文刊名/[请输入部分或全部刊名。],ISSN/[请输入完整的ISSN号。],年/[输入四位数字的年份。],期/[输入期刊的期号，如果不足两位数字，请在前面补“0”，如“08”。],主题/[主题包括篇名、关键词、中文摘要。可检索出这三项中任一项或多项满足指定检索条件的文献。对主题是按词检索的，请尽可能输入完整的词，以避免漏检。]"); 
        pm.addParameter("advancedfield1", "作者&英文作者"); 
        pm.addParameter("advancedvalue1", "韩国强"); 
        pm.addParameter("advancedfrequency1", ""); 
        pm.addParameter("yearstart", "1999"); 
        pm.addParameter("yearend", "2010"); 
        pm.addParameter("PublicationDate", ""); 
        pm.addParameter("SearchRange", "All"); 
        pm.addParameter("searchmatch", "0"); 
        pm.addParameter("order", "dec"); 
        pm.addParameter("RecordsPerPage", "20"); 
        pm.addParameter("TableType", "PY"); 
        pm.addParameter("display", "chinese"); 
        pm.addParameter("encode", "gb"); 
        pm.addParameter("TablePrefix", "CJFD"); 
        pm.addParameter("View", "中国期刊全文数据库"); 
        pm.addParameter("yearFieldName", "年"); 
        pm.addParameter("userright", ""); 
        pm.addParameter("VarNum", "1"); 
        pm.addParameter("imageField.x", "16"); 
        pm.addParameter("imageField.y", "2"); 
        pm.addRequestHeader("Referer", "http://lsg.cnki.net/grid20/Brief.aspx?ID=1&classtype=&systemno=&NaviDatabaseName=&NaviField="); 
        hc.executeMethod(pm); 
        System.out.println(pm.getResponseBodyAsString()); 
    } 
    public static void main(String[] args) throws HttpException, IOException { 
        getHtml(); 
        //String a="%2c%3f%3f%3f"; 
        //System.out.println(java.net.URLDecoder.decode(a, "UTF-8")); 
    } 
 
} 
