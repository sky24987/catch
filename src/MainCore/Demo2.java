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
        pm.addParameter("NaviField", "ר������Ŀ����"); 
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
        pm.addParameter("strNavigatorName", ",��A(��ѧ������ѧ�����),��B(��ѧ����ұ�𻷾���ҵ),��C(���纽�ս�ͨˮ��������Դ),ũҵ,ҽҩ����,��ʷ��,���ξ����뷨��,����������ѧ�ۺ�,���Ӽ�������Ϣ��ѧ,���������"); 
        pm.addParameter("singleleafcode", ""); 
        pm.addParameter("searchAttachCondition", ""); 
        pm.addParameter("SearchQueryID", ""); 
        pm.addParameter("SearchFieldRelationDirectory", "����/[],ƪ��/[],����/[],����&Ӣ������/[SYS_Author_Relevant],�ؼ���[],��һ������/[SYS_Author_Relevant],����/[SYS_Organization_Relevant],ժҪ/[],����/[],����/[SYS_Fund_Relevant],ȫ��/[]"); 
        pm.addParameter("updateTempDB", "CJFDTEMP,CJFDYTMP"); 
        pm.addParameter("bCurYearTempDB", "1"); 
        pm.addParameter("fieldnowordfrequency", "�ؼ���,����,��һ������,����,���Ŀ���&Ӣ�Ŀ���,��',��',����,�����',ISSN',CN',DOI'"); 
        pm.addParameter("fieldtips", "ƪ��/[�����ױ����м������Ըü�����ļ����ǰ��ʽ��еģ��뾡�������������Ĵʣ��Ա���©�졣],�ؼ���/[�������׵Ĺؼ���������������������ס��Ըü�����ļ����ǰ��ʽ��еģ��뾡�������������Ĵʣ��Ա���©�졣],��һ������/[��ѡ������ָ����Ӧ�ļ����ʣ�ѡ������ʽ��ƥ��ģʽ������ʱ����޶�������Ȼ��������������],����/[����������������������ֻ����������һ���֡�],����/[�����������Ļ������ƣ���ֻ����������һ���֡�],����ժҪ/[�Ըü�����ļ����ǰ��ʽ��еģ��뾡�������������Ĵʣ��Ա���©�졣],����/[��ѡ������ָ����Ӧ�ļ����ʣ�ѡ������ʽ��ƥ��ģʽ������ʱ����޶�������Ȼ��������������],ȫ��/��ѡ������ָ����Ӧ�ļ����ʣ�ѡ������ʽ��ƥ��ģʽ������ʱ����޶�������Ȼ��������������],����/[���������������Ļ������������ס�],���Ŀ���/[�����벿�ֻ�ȫ��������],ISSN/[������������ISSN�š�],��/[������λ���ֵ���ݡ�],��/[�����ڿ����ںţ����������λ���֣�����ǰ�油��0�����硰08����],����/[�������ƪ�����ؼ��ʡ�����ժҪ���ɼ���������������һ����������ָ���������������ס��������ǰ��ʼ����ģ��뾡�������������Ĵʣ��Ա���©�졣]"); 
        pm.addParameter("advancedfield1", "����&Ӣ������"); 
        pm.addParameter("advancedvalue1", "����ǿ"); 
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
        pm.addParameter("View", "�й��ڿ�ȫ�����ݿ�"); 
        pm.addParameter("yearFieldName", "��"); 
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
