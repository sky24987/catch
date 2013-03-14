package MainCore;

import java.io.*;

public class ReadFile12345 {
	public String fileReader(String filename) throws IOException{
		String s= null ;
		String m =null;
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("E:\\12345log"+filename)));
		while((s=br.readLine())!=null){
			m+=s;
			System.out.println(s);
			System.out.println(m);
		}
		return m;
	}
}
