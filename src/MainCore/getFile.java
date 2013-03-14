package MainCore;
/**
 *����˵������c�̽�������Ŀ¼��userMarkAll  ���ͳ�ƺ�Ŀ��Գɼ���   �ļ��Զ�����
 *							 userMark     ��ŴӾ�������ȡ�Ŀ��Գɼ���  �ļ��Զ�����
 *							 usercongig    �û����ã���Զ�̼���������ĵ��Ǹ��и��Ƶ��ļ�Ŀ¼��ַ������config.txt�ļ������ݸ�ʽΪ
 *							 smb://zh:123456@10.1.3.2//msg//log.txt
 *                           MyMark        �������ĵ�Ŀ¼�����ڽ�ͼץȡ���֣����������Զ���ȡ��Ŀ¼�ĵĵ�ַ���������ļ�����������
 *
 *
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import au.com.bytecode.opencsv.CSVWriter;

public class getFile {
	
	
	public static void smbGet(String remoteUrl,String localDir) {   
		InputStream in = null;   
		OutputStream out = null;   
		try {   
		SmbFile remoteFile = new SmbFile(remoteUrl);   
		if(remoteFile==null){   
			System.out.println("�����ļ�������");   
			return;   
		}   
		String fileName = remoteFile.getName();   
		File localFile = new File(localDir+File.separator+remoteFile.getServer()+"@"+fileName);   
		in = new BufferedInputStream(new SmbFileInputStream(remoteFile));   
			out = new BufferedOutputStream(new FileOutputStream(localFile));   
		byte[] buffer = new byte[1024];   
		while(in.read(buffer)!=-1){   
			out.write(buffer);   
			buffer = new byte[1024];   
			}   
			} catch (Exception e) {
			e.printStackTrace();   
		} 
		finally {   
			try {   
				out.close();   
				in.close();   
			} catch (IOException e) {   
				e.printStackTrace();   
			}   
		} 
	}    
	
	
	//��ȡ�û��б������ļ�����
	
	public  void readUserList(String path){
		  try {
		   BufferedReader br = new BufferedReader(new FileReader(path)); 
		   String temp = "";
		   while((temp=br.readLine()) != null) {
		    smbGet(temp,"C:\\userMark");
		   }
		   br.close(); 
		  } catch (FileNotFoundException e1) {
		   e1.printStackTrace();
		  } catch (IOException e1) {
		   e1.printStackTrace();
		  }
		  
	}
	
	public  String readuserMark(String filePath){
		 String alltext="";
		  try {
			   BufferedReader br = new BufferedReader(new FileReader(filePath)); 
			  
			   String temp = "";
			   while((temp=br.readLine()) != null) {
				   temp.trim();
				   if("".equals(temp)){
					   
					  
				   }
				   else{
					   alltext+=temp.trim()+"@";
				   }
			   }
			   br.close(); 
			  } catch (FileNotFoundException e1) {
				  e1.printStackTrace();
			  } catch (IOException e1) {
				  e1.printStackTrace();
			  }
			  
			  return alltext;
	}
	
	
	
	
	public  String[] splitMark(String s){
		String m=replace(s,"@@","");
		String[] m1=m.split("@");
		String[] temp = {"","",""};
		for(int i=0;i<m1.length;i++){
			if(m1[i].startsWith("�ܷ�(Լ)��")){
				String tt=m1[i].split("��")[1];
				tt=replace(tt,"�ܷ�(Լ)","");
				System.out.println("���˳ɼ��ǣ���"+tt);
				temp[0]=tt;
			}
			else{
				System.out.println("����׼��֤�ǣ�"+m1[i]);
				temp[1]=m1[i];
			}
		}
		return temp;
	}
	
	/**
	 * ȡ��һ���ַ����е���������֮�������
	 * 
	 * @param source
	 *            ��Դ�ַ���
	 * @param para1
	 *            ����һ������
	 * @param para2
	 *            �� �ڶ�������
	 * @return �����м��ַ���
	 */
	public static String getBetween(String source, String para1, String para2) {
		String[] result = source.split(para1);
		// System.out.println(result[0]);
		String tmp = result[1];
		result = tmp.split(para2);
		return result[0].trim();
	}
	
	
	/**
	 * �滻һ���ַ����е�����
	 * 
	 * @author: �ź�
	 * @param: strSource Ŀ���ַ���
	 * @param: strFrom ��Ҫ�滻���ַ���
	 * @param: strFrom �滻��Ŀ���ַ���
	 * @return �����滻����ַ���
	 */
	public static String replace(String strSource, String strFrom, String strTo) {
		if (strFrom == null || strFrom.equals(""))
			return strSource;
		String strDest = "";
		int intFromLen = strFrom.length();
		int intPos;
		while ((intPos = strSource.indexOf(strFrom)) != -1) {
			strDest = strDest + strSource.substring(0, intPos);
			strDest = strDest + strTo;
			strSource = strSource.substring(intPos + intFromLen);
		}
		strDest = strDest + strSource;
		return strDest;
	}

	
//��������
	
	public  List<String []> getAllfiles(File dir){
		 File[] fs = dir.listFiles();
		 List<String[]> ls = new ArrayList<String []>() ;
		  for(int i=0; i<fs.length; i++){
		   System.out.println(fs[i].getAbsolutePath());
		   if(!fs[i].isDirectory()){
			   String mark=readuserMark(fs[i].getAbsolutePath()); 
			   System.out.println(fs[i].getName());
			   String[] temp=splitMark(mark);
			   temp[2]=fs[i].getName();
			   ls.add(temp);
		   }
		  }
		  return ls;
	}
	
	
	public void writeCsv(List<String []> ls){
		CSVWriter writer;
		try {
			writer = new CSVWriter(new FileWriter("C:\\userMarkAll\\mark.csv"));
			writer.writeAll(ls);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("\n\nGenerated CSV File:\n\n");
	//	System.out.println(sw.toString());
	}

	
	public static void main(String a[]){
		//��������Ϣ�б������ļ�
		File dir = new File("C:\\userMark");
		getFile gf = new getFile();
		gf.readUserList("C:\\userconfig\\config.txt");
	//	gf.getAllfiles(dir);
		gf.writeCsv(gf.getAllfiles(dir));
		//�������ݵĻ�ȡ		
	}
}
