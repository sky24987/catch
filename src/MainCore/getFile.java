package MainCore;
/**
 *部署说明：在c盘建立如下目录：userMarkAll  存放统计后的考试成绩。   文件自动生成
 *							 userMark     存放从局域网获取的考试成绩。  文件自动生成
 *							 usercongig    用户设置，从远程计算机共享文档那个中复制的文件目录地址。建立config.txt文件，内容格式为
 *							 smb://zh:123456@10.1.3.2//msg//log.txt
 *                           MyMark        （共享文档目录）用于截图抓取文字，服务器会自动获取该目录的的地址，并复制文件到服务器。
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
			System.out.println("共享文件不存在");   
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
	
	
	//读取用户列表并进行文件拷贝
	
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
			if(m1[i].startsWith("总分(约)：")){
				String tt=m1[i].split("：")[1];
				tt=replace(tt,"总分(约)","");
				System.out.println("个人成绩是：："+tt);
				temp[0]=tt;
			}
			else{
				System.out.println("个人准考证是："+m1[i]);
				temp[1]=m1[i];
			}
		}
		return temp;
	}
	
	/**
	 * 取出一个字符串中的两个参数之间的内容
	 * 
	 * @param source
	 *            ，源字符串
	 * @param para1
	 *            ，第一个参数
	 * @param para2
	 *            ， 第二个参数
	 * @return 返回中间字符串
	 */
	public static String getBetween(String source, String para1, String para2) {
		String[] result = source.split(para1);
		// System.out.println(result[0]);
		String tmp = result[1];
		result = tmp.split(para2);
		return result[0].trim();
	}
	
	
	/**
	 * 替换一个字符串中的内容
	 * 
	 * @author: 张涵
	 * @param: strSource 目标字符串
	 * @param: strFrom 所要替换的字符串
	 * @param: strFrom 替换成目标字符串
	 * @return 返回替换后的字符串
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

	
//生成数据
	
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
		//读考生信息列表并复制文件
		File dir = new File("C:\\userMark");
		getFile gf = new getFile();
		gf.readUserList("C:\\userconfig\\config.txt");
	//	gf.getAllfiles(dir);
		gf.writeCsv(gf.getAllfiles(dir));
		//进行数据的获取		
	}
}
