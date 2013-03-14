

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;


public class upload {
	public static void main(String a[]) {
		String url = null;
		String myoa = "http://10.250.1.6:9099/oa/gosso/%s";
		String encodeSSo = null;
		String Link = "/oa/common/components/action/upload_refer.jsp";
		long time = System.currentTimeMillis();
		
		
		encodeSSo = PasswordVerify.EncodePassword("common/remind.jsp|" + "张涵"
				+ "|" + "1234560" + "|" + time);
	    url = String.format(myoa, encodeSSo);
		File f = new File("E:\\license.txt");
		System.out.println(url);
		postImg(url,f);

	}

	public static boolean postImg(String url, File file) {
		System.out.println(file.exists());

		PostMethod postMethod = new PostMethod(url);

		Part[] part = new Part[6];
		part[0] = new StringPart("attachmentType", "form.attachments");
		part[1] = new StringPart("attachmentCaseId", "79191374-0130-1000-e001-1ed0137f0969");
		part[2] = new StringPart("79191374-0130-1000-e001-1ed0137f0969elForm", "szcg1");
		part[3] = new StringPart("79191374-0130-1000-e001-1ed0137f0969elUuid", "72");
		part[4] = new StringPart("79191374-0130-1000-e001-1ed0137f0969edit", "false");
		try {
			part[5] = new FilePart("domAttFile", file);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("file exception"+ ex.getMessage());
		}
		

		MultipartRequestEntity mrp = new MultipartRequestEntity(part,postMethod.getParams());
		postMethod.setRequestEntity(mrp);
		org.apache.commons.httpclient.HttpClient client = new org.apache.commons.httpclient.HttpClient();
		client.getParams().setContentCharset("GBK");
		try {
			int status=client.executeMethod(postMethod);
			if ("false".equals(postMethod.getRequestEntity().toString())) {
				return false;
			}
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					postMethod.getResponseBodyAsStream(), "GBK"));
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println("接受到的流是:"+stringBuffer.toString()+"—-"+status);
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (client != null) {
				client = null;
			}
			if (postMethod != null) {
				postMethod = null;
			}
		}
		return true;
	}

}
