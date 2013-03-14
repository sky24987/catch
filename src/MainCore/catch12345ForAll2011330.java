package MainCore;

import static watij.finders.SymbolFactory.id;
import static watij.finders.SymbolFactory.name;
import static watij.finders.SymbolFactory.src;
import static watij.finders.SymbolFactory.tag;
import static watij.finders.SymbolFactory.value;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TimerTask;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;

import watij.elements.HtmlElements;
import watij.runtime.ie.IE;

import com.res.man.DaoManager;
import com.topevery.www.DUMServiceSoapProxy;
import com.topevery.www.SZCGEvent;
import com.topevery.www.SZCGEventTask;
import com.topevery.www.WSGetTasksParameter;

/**
 * <br>
 * 标题:徒手抓12345 <br>
 * <br>
 * 
 * @author
 * @version 1.1
 */
public class catch12345ForAll2011330 
{
	/**
	 * 解析网页
	 * 
	 * @param guid
	 *            12345序号
	 * @return 解析后的内容
	 * @throws IOException
	 */
	private static IE ie8 = null;
	static Logger logger = Logger.getLogger 
	( catch12345ForAll2011330.class.getName () ) ;
	/*
	public static String getContent(String guid) throws IOException {
		String sCurrentLine = "";
		String sTotalString = "";
		java.io.InputStream l_urlStream;
		java.net.URL l_url;
		java.io.BufferedReader l_reader;
		l_url = new java.net.URL("http://12345.jiangmen.gov.cn/event_view.aspx?ID=" + guid);
		// System.out.println(l_url);
		java.net.HttpURLConnection l_connection = (java.net.HttpURLConnection) l_url
				.openConnection();
		l_connection.connect();
		l_urlStream = l_connection.getInputStream();
		l_reader = new java.io.BufferedReader(new java.io.InputStreamReader(
				l_urlStream));
		while ((sCurrentLine = l_reader.readLine()) != null) {
			sTotalString = sTotalString.trim();

			if ("".equals(sTotalString)) {
				sTotalString += sCurrentLine + "\r\n";
			} else {
				sTotalString += sCurrentLine + "\r\n";
			}
		}
		return sTotalString;
	}*/

	public static IE getIe(){
		try {
		if (ie8 == null) {
			ie8 = new IE();

		
				ie8.start("http://12345.jiangmen.gov.cn/");

				ie8.textField(name, "userid").set("");

				ie8.textField(name, "password").set("");

				ie8.selectList(name, "type").option(value, "1").select();

				ie8.button(src, "images/login.jpg").click();

				ie8.waitUntilReady();
				ie8.waitUntilReady();
	
			

		} else {
			ie8.goTo("http://12345.jiangmen.gov.cn:9000/Default.aspx");
			ie8.waitUntilReady();
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ie8 = new IE();
			try {
				ie8.start("http://12345.jiangmen.gov.cn/");
				ie8.textField(name, "userid").set("");

				ie8.textField(name, "password").set("");

				ie8.selectList(name, "type").option(value, "1").select();

				ie8.button(src, "images/login.jpg").click();

				ie8.waitUntilReady();
				ie8.waitUntilReady();
				return ie8;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return ie8;
	}
	/**
	 * 
	 * @category 处理跨越工作日的时间
	 * @param d 需要处理的时间
	 * @param m 需要加成的时间
	 * @return  处理后的时间
	 * @throws ParseException
	 */

	@SuppressWarnings("deprecation")
	public static String getDateAfter(String d, int m) throws ParseException {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = formatter.parse(d);
		dt.setHours(18);
		dt.setMinutes(0);
		dt.setSeconds(0);
		c.setTime(dt);
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		if(c.get(Calendar.DAY_OF_WEEK)==1){
			c.add(Calendar.DAY_OF_MONTH, m);
		}
		else if(c.get(Calendar.DAY_OF_WEEK)==2)
		{
			c.add(Calendar.DAY_OF_MONTH, m-1);
		}
		else{
			c.add(Calendar.DAY_OF_MONTH, m+1);
		}
		String mDateTime = formatter.format(c.getTime());
		System.out.println(mDateTime);
		return mDateTime;
	}

//	public static void getContentID() throws Exception {
//		ie8 = getIe();
//		ie8.goTo("http://12345.jiangmen.gov.cn:9000/Default.aspx");
//		ie8.waitUntilReady();
//		ie8.refresh();
//		ie8.waitUntilReady();
//		HtmlElements hm = ie8.htmlElements(tag, "li");
//		String str[] = new String[15];
//
//
//		for (int j = 21, m = 0; j < 36; j++, m++) {
//			String id = hm.get(j).text().substring(0, 12);
//			id = id.substring(4).trim();
//			str[m] = id;
//		}
//
//
//		for (int i = str.length-1; i>=0; i--) {
//			if (isGuidExitF(str[i].trim())) {
//				myBeanAll mb = getMaicontent(str[i].trim());
//				ie8.waitUntilReady();
//				insertForm(mb);
//			} else {
//				System.out
//						.println("该办件已经生成，不必再添加：——————————————————————————————————>");
//			}
//		}
//		System.out.println("待办生成完毕，系统将在两分钟后自动检测");
//		// ie8.goTo("http://12345.jiangmen.gov.cn:9000/replyevent.aspx?id=" +
//		// 510332);
//		Calendar cal = Calendar.getInstance();
//		System.out.println(cal.get(Calendar.MINUTE));
//		if ((cal.get(Calendar.MINUTE) == 21)
//				|| ((cal.get(Calendar.MINUTE) == 1))
//				|| ((cal.get(Calendar.MINUTE) == 41))) {
//			ie8.close();
//			ie8 = null;
//		}
//	}
	
	
	public static void getContentID() throws Exception {
		ie8 = getIe();
		ie8.goTo("http://12345.jiangmen.gov.cn:9000/findevents.aspx");
		ie8.button(name,"ctl00$ContentPlaceHolder1$Button3").click();
		ie8.waitUntilReady();
		HtmlElements hm = ie8.htmlElements(tag, "span");
		String str[] = new String[30];
		int m = 0;
		//
		for (int j = 0; j <hm.length(); j++) {
			if("事项编号：".equals(hm.get(j).text().trim())){
				if("呈送时间：".equals(hm.get(j+2).text().trim())){
					System.out.println(hm.get(j+1).text());	
					str[m]=hm.get(j+1).text().trim();
					m++;
				}		
				
			}

		}


		for (int i = str.length-1; i>=0; i--) {
			if (isGuidExitF(str[i].trim())) {
				myBeanAll mb = getMaicontent(str[i].trim());
				ie8.waitUntilReady();
				insertForm(mb,"'12345政府服务热线'");
			} else {
				System.out
						.println("该办件已经生成，不必再添加：——————————————————————————————————>");
			}
		}
		System.out.println("待办生成完毕，系统将在两分钟后自动检测");
		// ie8.goTo("http://12345.jiangmen.gov.cn:9000/replyevent.aspx?id=" +
		// 510332);
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.MINUTE));
		if ((cal.get(Calendar.MINUTE) == 21)
				|| ((cal.get(Calendar.MINUTE) == 1))
				|| ((cal.get(Calendar.MINUTE) == 41))) {
			ie8.close();
			ie8 = null;
		}
	}

	public static myBeanAll getMaicontent(String ids) throws Exception {
		System.out.println(ids);
		myBeanAll bl = new myBeanAll();
		ie8.goTo("http://12345.jiangmen.gov.cn:9000/replyevent.aspx?id=" + ids);
		ie8.waitUntilReady();
		bl.setLbName(ie8.span(id, "lbName").text());
		bl.setLbDate(ie8.span(id, "lbDate").text());
		bl.setLbCommingPhone(ie8.span(id, "lbCommingPhone").text());
		bl.setLbPhone1(ie8.span(id, "lbPhone1").text());
		bl.setLbPhone2(ie8.span(id, "lbPhone2").text());
		bl.setLbPhone3(ie8.span(id, "lbPhone3").text());
		bl.setLbEventID(ie8.span(id, "lbEventID").text());
		bl.setLbAgentID(ie8.span(id, "lbAgentID").text());
		bl.setLbTitle(ie8.span(id, "lbTitle").text());
		bl.setLbContent(ie8.span(id, "lbContent").text());
		bl.setEventtype("事件");
		bl.setBigType("大件废弃物");
		bl.setSmallType("施工废弃料");
		System.out.println(bl.getLbAgentID());
		System.out.println(bl.getLbName());
		System.out.println(bl.getLbContent());
		ie8.waitUntilReady();
		ie8.goTo("http://12345.jiangmen.gov.cn:9000/Default.aspx");
		return bl;

	}

	public static void insertForm(myBeanAll mb,String type) throws SQLException,
			NumberFormatException, ParseException {
		DaoManager dm = new DaoManager();
		dm.initConnection();
		Statement st = dm.conn.createStatement();
		if (isGuidExitF(mb.getLbEventID())) {
			Calendar ca = Calendar.getInstance();
			int year = ca.get(Calendar.YEAR);// 获取年份
			String forder = null;
			String sqlm = "select f3 from ASFormszcg1 order by f3 desc";
			ResultSet rs = st.executeQuery(sqlm);
			if (rs.next()) {
				forder = rs.getString(1);
				System.out.println(forder);
				forder = replace(forder, "任务", "");
				forder = replace(forder, "号", "");
			}
			System.out.println(forder);
			String sql3 = "insert into ASFormszcg1 (fId,fUser,fDept,fPos,fOrg,fTime,f2,f3,f4,f5,f17,f18,f72,f77,f78,f82,f115,f89,f99,f108,f109,f110) values('"
					+ mb.getLbEventID()
					+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
					+ mb.getLbDate()
					+ "'"
					+ ",'美景社区','任务["
					+ year
					+ "]"
					+ (Integer.parseInt(mb.getLbEventID()))
					+ "号','5063875d-012d-1000-e000-4a52137f0969','"
					+ mb.getLbDate().trim()
					+ "','"
					+ mb.getLbTitle().trim()
					+ "','"
					+ (mb.getLbContent() + "联系人：" + mb.getLbName() + "  联系电话1:"
							+ mb.getLbPhone1() + "  联系电话2：" + mb.getLbPhone2()
							+ " 联系电话3：" + mb.getLbPhone3())
					+ "',0,'"+type+"','23493356-0120-1000-e000-0d1fc0a80169','23493356-0120-1000-e000-00c9c0a80169','"
					+ "蓬江区城管局"
					+ "','"
					+ getDateAfter(mb.getLbDate().trim(), 5)
					+ "','"+mb.getEventtype()+"','"+mb.getBigType()+"','"+mb.getSmallType()+"','')";
			System.out.println(sql3);
			st.execute(sql3);
			newWf(mb.getLbEventID(), 1, mb.getLbTitle());

		} else {

			System.out.println("添加过该案例");
		}
		System.out.println("添加成功");
		st.close();
		dm.closeConnection();

	}

	public static void nextstep(String sUserID, String procInsID) {

	}

	/**
	 * 降序抓取
	 * 
	 * @return 降序抓取的集合对象
	 * @throws IOException
	 * @throws SQLException
	 */
	/*
	public static void testHtml() throws IOException, SQLException {
		// ArrayList<Bean12345> al = new ArrayList<Bean12345>();
		String temp = null;
		String guid;
		String testText;
		DaoManager dm = new DaoManager();
		dm.initConnection();
		Statement st = dm.conn.createStatement();
		for (int i = Integer.parseInt(MinId().trim()); i > 0; i--) {
			guid = "2005081111179" + i;
			if (isGuidExit(guid)) {
				temp = getContent(guid);
				// System.out.println(temp);
				String[] result = temp.split("事项主题");
				if ("对不起，没有此条新闻。".equals(temp) || result.length < 1) {
					System.out.println("error对不起，没有此条新闻。");
				}
				if (result.length > 1) {
					testText = stripHtml(temp);
					testText = removeSpaces(testText);
					testText = replace(testText, ":&nbsp;", "");
					testText = replace(testText, ";&nbsp;", "");
					testText = replace(testText, "&nbsp;", "");

					Bean12345 b12345 = new Bean12345();

					b12345.setTaskTitle(getBetween(testText, "事项主题", "行政区域"));
					b12345.setViewTime(getBetween(testText, b12345
							.getTaskTitle(), "事项主题"));
					b12345.setGovArea(getBetween(testText, "行政区域", "处理部门"));
					b12345.setClDept(getBetween(testText, "处理部门", "呼叫类别"));
					b12345.setHjType(getBetween(testText, "呼叫类别", "处理状态"));
					b12345.setClState(getBetween(testText, "处理状态", "事项时间"));
					b12345.setTaskTime(getBetween(testText, "事项时间", "事项类别"));
					b12345.setTaskType(getBetween(testText, "事项类别", "事项地点"));
					b12345.setTaskAdd(getBetween(testText, "事项地点", "事项内容"));
					b12345.setTaskContent(getBetween(testText, "事项内容", "处理结果"));
					b12345.setClResult(replace(getBetween(testText, "处理结果",
							"打印本页"), "[", ""));

					System.out.println("**************************************start");
					System.out.println(b12345.getClDept());
					System.out.println(b12345.getClState());
					System.out.println(b12345.getGovArea());
					System.out.println(b12345.getClResult());
					System.out.println(b12345.getHjType());
					System.out.println(b12345.getTaskAdd());
					System.out.println(b12345.getTaskContent());
					System.out.println(b12345.getTaskTime());
					System.out.println(b12345.getTaskTitle());
					System.out.println(b12345.getViewTime());
					System.out
							.println("////////////////////////////////////////end");
					// insert(b12345);

					Date dt = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					String dateString = formatter.format(dt);
					System.out.println(dateString);

					String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f113],[f114],[f115])"
							+ "VALUES('"
							+ guid
							+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
							+ dateString
							+ "','"
							+ b12345.getTaskContent()
							+ "','"
							+ b12345.getClResult()
							+ "','"
							+ b12345.getTaskTitle()
							+ "','"
							+ b12345.getGovArea()
							+ "',"
							+ "'"
							+ b12345.getClDept()
							+ "','"
							+ b12345.getHjType()
							+ "','"
							+ b12345.getClState()
							+ "','"
							+ b12345.getTaskTime()
							+ "','"
							+ b12345.getTaskType() + "',0)";
					System.out.println(sql2);
					st.execute(sql2);
					System.out.println("添加成功");
				}

				// al.add(b12345);
			}

		}
		dm.closeConnection();
		// return al;

	}
*/
	/**
	 * 对升序获取的12345内容进行抓取
	 * 
	 * @return 返回抓取后的集合对像
	 * @throws IOException
	 * @throws SQLException
	 */
	/*
	public static ArrayList<Bean12345> testHtmlUp() throws IOException,
			SQLException {
		ArrayList<Bean12345> al = new ArrayList<Bean12345>();
		String temp = null;
		String guid;
		String testText;
		DaoManager dm = new DaoManager();
		dm.initConnection();
		Statement st = dm.conn.createStatement();
		String max1 = MaxId();
		String max2 = MaxIdF();
		int f = 23;
		if (Integer.parseInt(max1) > Integer.parseInt(max2)) {
			f = Integer.parseInt(max1);
		} else {

			f = Integer.parseInt(max2);
		}

		// for (int i
		// =Integer.parseInt(getFirstID("200508111117939623","2005081111179").trim());
		// i<99999; i++) {
		for (int i = f; i < 999999; i++) {
			guid = String.valueOf(i);
			UpdateMaxIdM(i);
			if (isGuidExit(guid)) {
				temp = getContent(guid);
				System.out.println(temp);
				String[] result = temp.split("事项主题");
				if ("对不起，没有此条新闻。".equals(temp) || result.length < 1) {
					System.out.println("error对不起，没有此条新闻。");
				}
				if (result.length > 1) {
					testText = stripHtml(temp);
					testText = removeSpaces(testText);
					testText = replace(testText, ":&nbsp;", "");
					testText = replace(testText, ";&nbsp;", "");
					testText = replace(testText, "&nbsp;", "");

					Bean12345 b12345 = new Bean12345();

					b12345.setTaskTitle(getBetween(testText, "事项主题:", "行政区域:"));
					// b12345.setViewTime(getBetween(testText,
					// b12345.getTaskTitle(),"事项主题"));
					b12345.setGovArea(getBetween(testText, "行政区域:", "处理部门:"));
					b12345.setClDept(getBetween(testText, "处理部门:", "呼叫类别:"));
					b12345.setHjType(getBetween(testText, "呼叫类别:", "处理状态:"));
					b12345.setClState(getBetween(testText, "处理状态:", "事项时间:"));
					b12345.setTaskTime(getBetween(testText, "事项时间:", "事项类别:"));
					b12345.setTaskType(getBetween(testText, "事项类别:", "事项地点:"));
					b12345.setTaskAdd(getBetween(testText, "事项地点:", "事项内容:"));
					b12345
							.setTaskContent(getBetween(testText, "事项内容:",
									"处理结果:"));
					b12345.setClResult(replace(getBetween(testText, "处理结果:",
							"主办：江门市市委、市政府"), "[", ""));

					System.out
							.println("**************************************start");
					System.out.println(b12345.getClDept());
					System.out.println(b12345.getClState());
					System.out.println(b12345.getGovArea());
					System.out.println(b12345.getClResult());
					System.out.println(b12345.getHjType());
					System.out.println(b12345.getTaskAdd());
					System.out.println(b12345.getTaskContent());
					System.out.println(b12345.getTaskTime());
					System.out.println(b12345.getTaskTitle());
					System.out.println(b12345.getViewTime());
					System.out
							.println("////////////////////////////////////////end");
					// insert(b12345);

					Date dt = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					String dateString = formatter.format(dt);
					System.out.println(dateString);
					if ("蓬江区".equals(b12345.getGovArea())
							&& "处理完毕".equals(b12345.getClState())) {
						String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f113],[f114],[f115])"
								+ "VALUES('"
								+ guid
								+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
								+ dateString
								+ "','"
								+ b12345.getTaskContent()
								+ "','"
								+ b12345.getClResult()
								+ "','"
								+ b12345.getTaskTitle()
								+ "','"
								+ b12345.getGovArea()
								+ "',"
								+ "'"
								+ b12345.getClDept()
								+ "','"
								+ b12345.getHjType()
								+ "','"
								+ b12345.getClState()
								+ "','"
								+ b12345.getTaskTime()
								+ "','"
								+ b12345.getTaskType() + "',0)";
						System.out.println(sql2);
						st.execute(sql2);
					}

					if ("蓬江区".equals(b12345.getGovArea())
							&& "已办理".equals(b12345.getClState())) {
						String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f113],[f114],[f115])"
								+ "VALUES('"
								+ guid
								+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
								+ dateString
								+ "','"
								+ b12345.getTaskContent()
								+ "','"
								+ b12345.getClResult()
								+ "','"
								+ b12345.getTaskTitle()
								+ "','"
								+ b12345.getGovArea()
								+ "',"
								+ "'"
								+ b12345.getClDept()
								+ "','"
								+ b12345.getHjType()
								+ "','"
								+ b12345.getClState()
								+ "','"
								+ b12345.getTaskTime()
								+ "','"
								+ b12345.getTaskType() + "',0)";
						System.out.println(sql2);
						st.execute(sql2);
					}

					if ("蓬江区".equals(b12345.getGovArea())
							&& "处理中".equals(b12345.getClState())) {
						String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f113],[f114],[f115])"
								+ "VALUES('"
								+ guid
								+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
								+ dateString
								+ "','"
								+ b12345.getTaskContent()
								+ "','"
								+ b12345.getClResult()
								+ "','"
								+ b12345.getTaskTitle()
								+ "','"
								+ b12345.getGovArea()
								+ "',"
								+ "'"
								+ b12345.getClDept()
								+ "','"
								+ b12345.getHjType()
								+ "','"
								+ b12345.getClState()
								+ "','"
								+ b12345.getTaskTime()
								+ "','"
								+ b12345.getTaskType() + "',0)";
						System.out.println(sql2);
						st.execute(sql2);
					}

					System.out.println("添加成功");
				}

				// al.add(b12345);
			}

		}
		dm.closeConnection();
		return al;

	}
	*/
/*
	public static void testHtmlUpCity12345() throws IOException, SQLException {
		String temp = null;
		String guid;
		String testText;
		DaoManager dm = new DaoManager();
		UUID uidfid = UUID.randomUUID();

		// for (int i
		// =Integer.parseInt(getFirstID("200508111117939623","2005081111179").trim());
		// i<99999; i++) {
		// String max1=MaxId();
		// String max2=MaxIdF();
		int f = 23;
		// System.out.println(max1+"----->"+max2);
		f = Integer.parseInt(MaxIdM());
		int flag = 0;
		for (int i = f;; i++) {

			dm.initConnection();
			Statement st = dm.conn.createStatement();
			guid = String.valueOf(i);

			if (isGuidExit(guid)) {
				temp = getContent(guid);
				// System.out.println(temp);
				String[] result = temp.split("事项主题");
				if ("对不起，没有此条新闻。".equals(temp) || result.length < 1) {
					System.out.println("error对不起，没有此条新闻。");
				}
				if (result.length > 1) {
					testText = stripHtml(temp);
					testText = removeSpaces(testText);
					testText = replace(testText, ":&nbsp;", "");
					testText = replace(testText, ";&nbsp;", "");
					testText = replace(testText, "&nbsp;", "");

					Bean12345 b12345 = new Bean12345();

					b12345.setTaskTitle(getBetween(testText, "事项主题:", "行政区域:"));
					b12345.setGovArea(getBetween(testText, "行政区域:", "处理部门:"));
					b12345.setClDept(getBetween(testText, "处理部门:", "呼叫类别:"));
					b12345.setHjType(getBetween(testText, "呼叫类别:", "处理状态:"));
					b12345.setClState(getBetween(testText, "处理状态:", "事项时间:"));
					b12345.setTaskTime(getBetween(testText, "事项时间:", "事项类别:"));
					b12345.setTaskType(getBetween(testText, "事项类别:", "事项地点:"));
					b12345.setTaskAdd(getBetween(testText, "事项地点:", "事项内容:"));
					b12345
							.setTaskContent(getBetween(testText, "事项内容:",
									"处理结果:"));
					b12345.setClResult(replace(getBetween(testText, "处理结果:",
							"主办：江门市市委、市政府"), "[", ""));

					System.out
							.println("**************************************start");
					System.out.println(b12345.getClDept());
					System.out.println(b12345.getClState());
					System.out.println(b12345.getGovArea());
					System.out.println(b12345.getClResult());
					System.out.println(b12345.getHjType());
					System.out.println(b12345.getTaskAdd());
					System.out.println(b12345.getTaskContent());
					System.out.println(b12345.getTaskTime());
					System.out.println(b12345.getTaskTitle());
					System.out.println(b12345.getViewTime());
					System.out
							.println("////////////////////////////////////////end");
					// insert(b12345);
					if (b12345.getClDept() == null
							|| "".equals(b12345.getClDept())) {
						// System.out.println("error对不起，没有此条新闻,系统回退。");
						flag++;
						if (flag >= 30) {
							flag = 0;
							i = i - 30;
							System.out.println("连续30条记录为空，系统暂时回退");
							continue;
						}

					} else {

						Date dt = new Date();
						SimpleDateFormat formatter = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						String dateString = formatter.format(dt);
						System.out.println(dateString);
						String ttime = b12345.getTaskTime().substring(0, 4);
						System.out.println("字符串处理结果" + ttime);
						UpdateMaxIdM(i);
						if (b12345.getClDept().startsWith("蓬江区城管")
								&& "处理完毕".equals(b12345.getClState().trim())) {
							String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f113],[f114],[f115])"
									+ "VALUES('"
									+ guid
									+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
									+ dateString
									+ "','"
									+ b12345.getTaskContent()
									+ "','"
									+ b12345.getClResult()
									+ "','"
									+ b12345.getTaskTitle()
									+ "','"
									+ b12345.getGovArea()
									+ "',"
									+ "'"
									+ b12345.getClDept()
									+ "','"
									+ b12345.getHjType()
									+ "','"
									+ b12345.getClState()
									+ "','"
									+ b12345.getTaskTime()
									+ "','"
									+ b12345.getTaskType() + "',0)";
							System.out.println(sql2);
							st.execute(sql2);
							// st.close();

						}

						if (b12345.getClDept().startsWith("蓬江区城管")
								&& "已办理".equals(b12345.getClState().trim())) {
							String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f113],[f114],[f115])"
									+ "VALUES('"
									+ guid
									+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
									+ dateString
									+ "','"
									+ b12345.getTaskContent()
									+ "','"
									+ b12345.getClResult()
									+ "','"
									+ b12345.getTaskTitle()
									+ "','"
									+ b12345.getGovArea()
									+ "',"
									+ "'"
									+ b12345.getClDept()
									+ "','"
									+ b12345.getHjType()
									+ "','"
									+ b12345.getClState()
									+ "','"
									+ b12345.getTaskTime()
									+ "','"
									+ b12345.getTaskType() + "',0)";
							System.out.println(sql2);
							st.execute(sql2);

						}

						if (b12345.getClDept().startsWith("蓬江区城管")
								&& "处理中".equals(b12345.getClState().trim())) {
							System.out
									.println("进入待办处理：——————————————————————————————————>");
							Calendar ca = Calendar.getInstance();
							int year = ca.get(Calendar.YEAR);// 获取年份
							int month = ca.get(Calendar.MONTH);// 获取月份
							int day = ca.get(Calendar.DATE);// 获取日
							int minute = ca.get(Calendar.MINUTE);// 分
							int hour = ca.get(Calendar.HOUR_OF_DAY);// 小时
							int second = ca.get(Calendar.SECOND);// 秒
							int WeekOfYear = ca.get(Calendar.DAY_OF_WEEK);
							if (Integer.parseInt(ttime) >= year) {

								String forder = null;
								String sqlm = "select f3 from ASFormszcg1 order by f3 desc";
								ResultSet rs = st.executeQuery(sqlm);
								if (rs.next()) {
									forder = rs.getString(1);
									System.out.println(forder);
									forder = replace(forder, "任务", "");
									forder = replace(forder, "号", "");
								}
								System.out.println(forder);
								String sql3 = "insert into ASFormszcg1 (fId,fUser,fDept,fPos,fOrg,fTime,f2,f3,f4,f5,f17,f18,f72,f77,f78,f82,f115,f89,f99,f108,f109,f110) values('"
										+ guid
										+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
										+ dateString
										+ "'"
										+ ",'美景社区','任务["
										+ year
										+ "]"
										+ (Integer.parseInt(guid) + 1)
										+ "号','5063875d-012d-1000-e000-4a52137f0969','"
										+ b12345.getTaskTime()
										+ "','"
										+ b12345.getTaskTitle()
										+ "','"
										+ b12345.getTaskContent()
										+ "',0,'12345政府服务热线','23493356-0120-1000-e000-0d1fc0a80169','23493356-0120-1000-e000-00c9c0a80169','"
										+ b12345.getClDept()
										+ "','"
										+ dateString
										+ "','事件','大件废弃物','施工废弃料','')";
								System.out.println(sql3);
								if (isGuidExitF(guid)) {
									st.execute(sql3);
									newWf(guid, 1, b12345.getTaskTitle());

								} else {

									System.out.println("添加过该案例");
								}
								System.out.println("添加成功");

							} else {
								String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f113],[f114],[f115])"
										+ "VALUES('"
										+ guid
										+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
										+ dateString
										+ "','"
										+ b12345.getTaskContent()
										+ "','"
										+ b12345.getClResult()
										+ "','"
										+ b12345.getTaskTitle()
										+ "','"
										+ b12345.getGovArea()
										+ "',"
										+ "'"
										+ b12345.getClDept()
										+ "','"
										+ b12345.getHjType()
										+ "','"
										+ b12345.getClState()
										+ "','"
										+ b12345.getTaskTime()
										+ "','"
										+ b12345.getTaskType() + "',0)";
								System.out.println(sql2);
								st.execute(sql2);

							}

						}
						
						System.out.println("添加成功");

					}
				}

			}
		
			dm.closeConnection();
		}

	}*/

	/**
	 * 对升序获取的12345内容进行抓取
	 * 
	 * @return 返回抓取后的集合对像
	 * @throws IOException
	 * @throws SQLException
	 */
	/*
	public static ArrayList<Bean12345> importData() throws IOException,
			SQLException {
		ArrayList<Bean12345> al = new ArrayList<Bean12345>();
		String temp = null;
		String guid;
		String testText;
		DaoManager dm = new DaoManager();
		dm.initConnection();
		Statement st = dm.conn.createStatement();
		for (int i = Integer.parseInt(getFirstID("200508111117939623",
				"2005081111179").trim()); i < 99999; i++) {
			guid = "2005081111179" + i;
			// if(isGuidExit(guid)){
			temp = getContent(guid);
			// System.out.println(temp);
			String[] result = temp.split("事项主题");
			if ("对不起，没有此条新闻。".equals(temp) || result.length < 1) {
				System.out.println("error对不起，没有此条新闻。");
			}
			if (result.length > 1) {
				testText = stripHtml(temp);
				testText = removeSpaces(testText);
				testText = replace(testText, ":&nbsp;", "");
				testText = replace(testText, ";&nbsp;", "");
				testText = replace(testText, "&nbsp;", "");
				testText = replace(testText, ":", "");
				// Uuid uid = Uuid.create();
				Bean12345 b12345 = new Bean12345();

				b12345.setTaskTitle(getBetween(testText, "事项主题", "行政区域"));
				b12345.setViewTime(getBetween(testText, b12345.getTaskTitle(),
						"事项主题").substring(0, 10));
				b12345.setGovArea(getBetween(testText, "行政区域", "处理部门"));
				b12345.setClDept(getBetween(testText, "处理部门", "呼叫类别"));
				b12345.setHjType(getBetween(testText, "呼叫类别", "处理状态"));
				b12345.setClState(getBetween(testText, "处理状态", "事项时间"));
				b12345.setTaskTime(getBetween(testText, "事项时间", "事项类别"));
				b12345.setTaskType(getBetween(testText, "事项类别", "事项地点"));
				b12345.setTaskAdd(getBetween(testText, "事项地点", "事项内容"));
				b12345.setTaskContent(getBetween(testText, "事项内容", "处理结果"));
				b12345.setClResult(replace(
						getBetween(testText, "处理结果", "打印本页"), "[", ""));

				System.out
						.println("**************************************start");
				System.out.println(b12345.getClDept());
				System.out.println(b12345.getClState());
				System.out.println(b12345.getGovArea());
				System.out.println(b12345.getClResult());
				System.out.println(b12345.getHjType());
				System.out.println(b12345.getTaskAdd());
				System.out.println(b12345.getTaskContent());
				System.out.println(b12345.getTaskTime());
				System.out.println(b12345.getTaskTitle());
				System.out.println(b12345.getViewTime());
				System.out
						.println("////////////////////////////////////////end");
				// insert(b12345);
				if ("".equals(b12345.getViewTime())) {

					b12345.setViewTime(b12345.getTaskTime());
				}
				;
				Date dt = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				String dateString = formatter.format(dt);
				System.out.println(dateString);

				String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormoldszcg]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f2],[f5],[f17],[f18],[f72],[f77],[f78],[f82],[f115],[f89],[f99],[f108],[f109],[f110],position_x,position_y)"
						+ "VALUES('"
						+ guid
						+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
						+ dateString
						+ "','所有模块',"
						+ "'"
						+ b12345.getTaskTime()
						+ "','"
						+ b12345.getGovArea()
						+ "','"
						+ b12345.getTaskContent()
						+ "',0,'"
						+ b12345.getTaskType()
						+ "','23493356-0120-1000-e000-00c9c0a80169','23493356-0120-1000-e000-00c9c0a80169','所有职能部门','"
						+ b12345.getViewTime()
						+ "','事件','大件废弃物','施工废弃料','','','')";
				System.out.println(sql2);
				st.execute(sql2);
				System.out.println("添加成功");
			}

			// al.add(b12345);
			// }

		}
		dm.closeConnection();
		return al;

	}*/
	
	
	

	public static void newWf(String uuid, int i, String title)
			throws SQLException {

		DaoManager dm = new DaoManager();
		dm.initConnection();
		Statement st = dm.conn.createStatement();

		Date dt = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dt);
		System.out.println(dateString);

		UUID uid = UUID.randomUUID();
		UUID uid1 = UUID.randomUUID();

		String sql2 = "INSERT INTO TWFProcessInstance ( fsprocinsid,fsparentprocinsid,fsactivityinsid,fscreateuserid,"
				+ "fscurrentuserid,fscurrentdeptid,fdcreatetime,fiorder,fsprocname,"
				+ "fsprocid,fscaseid,fscateid,fscatename,fcactivestate,fsurgentextent,fsapplication,fsorgid,fsformid )"
				+ "  VALUES  ( '"
				+ uid
				+ "',"
				+ "'MAIN',"
				+ "'MAIN',"
				+ "'23493356-0120-1000-e000-0d1fc0a80169'"
				+ // fscreateuserid
				",'23493356-0120-1000-e000-0d1fc0a80169',"
				+ // 编号
				/* 流程编号 */"'23493356-0120-1000-e000-00c9c0a80169',"
				+ // 不变的编号
				"'"
				+ dateString
				+ "',1,'数字城管工单流程--批量测试',"
				+ "'5063875d-012d-1000-e000-4a52137f0969'," + // 不变的流程号
				"'" + uuid + "'," + // 关联的表单号
				"'63eaf009-0126-1000-e000-14b9137f0969'," + // 不变的编号
				"'数字城管','A','0'," + "'" + title + "'," + // 标题
				"'1049'," + "'63eaf009-0126-1000-e000-0311137f0969' )";
		System.out.println(sql2);

		st.execute(sql2);

		String sql3 = "INSERT INTO TWFActivityIns ( fsactinsid,fspassroute,fsactid,fsactname,fiorder,"
				+ "fsprevactid,fsinitactivityinsid,fcactivestate,fsprocinsid,fscaseid,fscateid,fshints,"
				+ "fcright,fscreateuserid,fsoriginalhandler,fshandlerid,"
				+ "fsflowkind,fdcreatetime,fcisurgency,fsmemo,fsinnersubflow )  VALUES  ( "
				+ "'"
				+ uid1
				+ "',"
				+ "'5063875d-012d-1000-e000-4a58137f0969',"
				+ "'5063875d-012d-1000-e000-4a8c137f0969',"
				+ "'工单录入',1,'0','0','U','"
				+ uid
				+ "',"
				+ "'"
				+ uuid
				+ "',"
				+ "'63eaf009-0126-1000-e000-14b9137f0969',"
				+ "'录入工单','R','23493356-0120-1000-e000-0d1fc0a80169',"
				+ "'23493356-0120-1000-e000-0d1fc0a80169',"
				+ "'23493356-0120-1000-e000-0d1fc0a80169',"
				+ "'E','"
				+ dateString + "','N','新建流程活动'," + "'" + uid + "' ) ";

		System.out.println(sql3);

		st.execute(sql3);

		String sql4 = "INSERT INTO TWFActivityInsHandler "
				+ "( fsid,fsprocinsid,fsactivityinsid,fccategory,fsflowkind,fcactivestate,fshandlerid,fsmemo )  VALUES  "
				+ "( '"
				+ UUID.randomUUID()
				+ "','"
				+ uid
				+ "','"
				+ uid1
				+ "','H','E','U','23493356-0120-1000-e000-0d1fc0a80169','新建经办人' )";

		st.execute(sql4);

		System.out.println(sql4);
		String sql5 = "INSERT INTO TWFProcessInsHandler ( fsid,fsprocinsid,fsactinsid,fccategory,fcactivestate,fsmemo,fshandlerid,fsdeptid,fsorgid )  VALUES  "
				+ "( '"
				+ UUID.randomUUID()
				+ "','"
				+ uid
				+ "','"
				+ uid1
				+ "','H','A','原处理人','23493356-0120-1000-e000-0d1fc0a80169',"
				+ "'dc21f7ae-0123-1000-e006-2bfc137f0902','47f3818d-011d-1000-e000-0000ac16507f' ) ";

		st.execute(sql5);
		System.out.println(sql5);
		
		
		String sql_sugess2="INSERT INTO TWFProcInsComments ( fsprocinsid,fscommentid,fscommentname,fiorder,fsprocid )  VALUES  ( '"+uid+"','4aa3d0fd-0129-1000-e000-4d45137f0969','领导意见',1,'5063875d-012d-1000-e000-4a52137f0969' )";
		String sql_sugess1="INSERT INTO TWFProcInsComments ( fsprocinsid,fscommentid,fscommentname,fiorder,fsprocid )  VALUES  ( '"+uid+"','98182049-0127-1000-e000-01bc137f0969','办理情况',2,'5063875d-012d-1000-e000-4a52137f0969' )";
		String sql_sugess4="INSERT INTO TWFProcInsComments ( fsprocinsid,fscommentid,fscommentname,fiorder,fsprocid )  VALUES  ( '"+uid+"','98182049-0127-1000-e000-01ba137f0969','审核意见',3,'5063875d-012d-1000-e000-4a52137f0969' )";
		st.execute(sql_sugess2);
		st.execute(sql_sugess1);
		
//		st.execute(sql_sugess3);
		st.execute(sql_sugess4);
		

		System.out.println("添加成功");
		System.out.println("成功进行下一步");
		UUID uid2 = UUID.randomUUID();
		String sql6 = "INSERT INTO TWFActivityIns ( fsactinsid,fiorder,"
				+ "fcactivestate,fsprocinsid,fspassroute,fsactid,fsactname,"
				+ "fshints,fscaseid,fscateid,fscreateuserid,fdcreatetime,fsprevactid,"
				+ "fsinitactivityinsid,fsflowkind,fcevent,fcright,fsinnersubflow,"
				+ "fshandlerid,fsoriginalhandler )  VALUES "
				+ " ( '"
				+ uid2
				+ "',1,'U',"
				+ "'"
				+ uid
				+ "','5063875d-012d-1000-e000-4a89137f0969',"
				+ "'5063875d-012d-1000-e000-4a90137f0969','立案','审核立案','"
				+ uuid
				+ "','63eaf009-0126-1000-e000-14b9137f0969',"
				+ "'23493356-0120-1000-e000-0d1fc0a80169','"
				+ dateString
				+ "',"
				+ "'"
				+ uid1
				+ "','0','E','A','W','"
				+ uid
				+ "',"
				+ "'23493356-0120-1000-e000-0d1fc0a80169','23493356-0120-1000-e000-0d1fc0a80169' )";
		st.execute(sql6);
		System.out.println(sql6);
		String sql7 = " UPDATE TWFProcessInstance SET fscurrentuserid = '23493356-0120-1000-e000-0d1fc0a80169'"
				+ " WHERE fsprocinsid = '" + uid + "'";
		st.execute(sql7);
		System.out.println(sql7);

		String sql8 = " UPDATE TWFActivityIns SET fcactivestate = 'C',fdendtime = '"
				+ dateString + "'" + "WHERE fsactinsid = '" + uid1 + "'";
		UUID uid3 = UUID.randomUUID();
		st.execute(sql8);
		System.out.println(sql8);
		String sql9 = "INSERT INTO TWFActivityInsHandler ( fsid,fsprocinsid,fsactivityinsid,fccategory"
				+ ",fsflowkind,fcactivestate,fshandlerid,fsmemo )  VALUES  "
				+ "( '"
				+ uid3
				+ "','"
				+ uid
				+ "','"
				+ uid2
				+ "',"
				+ "'H','E','U','23493356-0120-1000-e000-0d1fc0a80169','新建经办人' )";
		st.execute(sql9);
		System.out.println(sql9);
		String sql10 = "DELETE FROM TWFActivityInsHandler WHERE  fsactivityinsid='"
				+ uid1
				+ "'"
				+ " AND fshandlerid='23493356-0120-1000-e000-0d1fc0a80169' AND fsprocinsid='"
				+ uid + "'";
		st.execute(sql10);
		System.out.println(sql10);

		System.out.println("添加成功");
		System.out.println("成功进行下一步");
		UUID uid12 = UUID.randomUUID();
		
		
		//并发
		String sql16 = "INSERT INTO TWFActivityIns ( fsactinsid,fiorder,"
				+ "fcactivestate,fsprocinsid,fspassroute,fsactid,fsactname,"
				+ "fshints,fscaseid,fscateid,fscreateuserid,fdcreatetime,fsprevactid,"
				+ "fsinitactivityinsid,fsflowkind,fcevent,fcright,fsinnersubflow,"
				+ "fshandlerid,fsoriginalhandler,fstag)  VALUES "
				+ " ( '"
				+ uid12
				+ "',1,'U',"
				+ "'"
				+ uid
				+ "','5063875d-012d-1000-e000-4a8d137f0969',"
				+ "'5063875d-012d-1000-e000-4a84137f0969','派发','待派发','"
				+ uuid
				+ "','63eaf009-0126-1000-e000-14b9137f0969',"
				+ "'23493356-0120-1000-e000-0d1fc0a80169','"
				+ dateString
				+ "',"
				+ "'"
				+ uid1
				+ "','0','T','B,A','W','"
				+ uid
				+ "',"
				+ "'23493356-0120-1000-e000-0e2cc0a80169','23493356-0120-1000-e000-0d1fc0a80169','B')";//吴琪琪
		System.out.println(sql16);
		st.execute(sql16);
		String sql17 = " UPDATE TWFProcessInstance SET fscurrentuserid = '23493356-0120-1000-e000-0d1fc0a80169'"
			+ " WHERE fsprocinsid = '" + uid + "'";
		st.execute(sql17);
		System.out.println(sql17);

		UUID uid13 = UUID.randomUUID();
		String sql19 = "INSERT INTO TWFActivityInsHandler ( fsid,fsprocinsid,fsactivityinsid,fccategory"
				+ ",fsflowkind,fcactivestate,fshandlerid,fsmemo )  VALUES  "
				+ "( '"
				+ uid13
				+ "','"
				+ uid
				+ "','"
				+ uid12
				+ "',"
				+ "'H','T','U','23493356-0120-1000-e000-0e2cc0a80169','新建经办人' )";
		st.execute(sql19);
		System.out.println(sql19);
		String sql110 = "DELETE FROM TWFActivityInsHandler WHERE  fsactivityinsid='"
				+ uid3
				+ "'"
				+ " AND fshandlerid='23493356-0120-1000-e000-0d1fc0a80169' AND fsprocinsid='"
				+ uid + "'";
		st.execute(sql110);
		System.out.println(sql110);
		
		//////////////////////////
		
		UUID uid21 = UUID.randomUUID();
		String sql21 = "INSERT INTO TWFActivityIns ( fsactinsid,fiorder,"
			+ "fcactivestate,fsprocinsid,fspassroute,fsactid,fsactname,"
			+ "fshints,fscaseid,fscateid,fscreateuserid,fdcreatetime,fsprevactid,"
			+ "fsinitactivityinsid,fsflowkind,fcevent,fcright,fsinnersubflow,"
			+ "fshandlerid,fsoriginalhandler,fstag)  VALUES "
			+ " ( '"
			+ uid21
			+ "',1,'U',"
			+ "'"
			+ uid
			+ "','5063875d-012d-1000-e000-4a8d137f0969',"
			+ "'5063875d-012d-1000-e000-4a84137f0969','派发','待派发','"
			+ uuid
			+ "','63eaf009-0126-1000-e000-14b9137f0969',"
			+ "'23493356-0120-1000-e000-0d1fc0a80169','"
			+ dateString
			+ "',"
			+ "'"
			+ uid1
			+ "','0','T','B,A','W','"
			+ uid
			+ "',"
			+ "'f77ba228-012b-1000-e000-9fd4137f0969','23493356-0120-1000-e000-0d1fc0a80169','B')"; //周艳芬
			System.out.println(sql21);
			st.execute(sql21);
			
			String sql2117 = " UPDATE TWFProcessInstance SET fscurrentuserid = '23493356-0120-1000-e000-0d1fc0a80169'"
				+ " WHERE fsprocinsid = '" + uid + "'";
			st.execute(sql2117);
			System.out.println(sql2117);

		
		UUID uid2113 = UUID.randomUUID();
		String sql2119 = "INSERT INTO TWFActivityInsHandler ( fsid,fsprocinsid,fsactivityinsid,fccategory"
				+ ",fsflowkind,fcactivestate,fshandlerid,fsmemo )  VALUES  "
				+ "( '"
				+ uid2113
				+ "','"
				+ uid
				+ "','"
				+ uid21
				+ "',"
				+ "'H','T','U','f77ba228-012b-1000-e000-9fd4137f0969','新建经办人' )";
		st.execute(sql2119);
		System.out.println(sql2119);
		
		String sql21110 = "DELETE FROM TWFActivityInsHandler WHERE  fsactivityinsid='"
			+ uid3
			+ "'"
			+ " AND fshandlerid='23493356-0120-1000-e000-0d1fc0a80169' AND fsprocinsid='"
			+ uid + "'";
		st.execute(sql21110);
		System.out.println(sql21110);

		
		
		
		///////
		UUID uid22 = UUID.randomUUID();
		String sql22 = "INSERT INTO TWFActivityIns ( fsactinsid,fiorder,"
			+ "fcactivestate,fsprocinsid,fspassroute,fsactid,fsactname,"
			+ "fshints,fscaseid,fscateid,fscreateuserid,fdcreatetime,fsprevactid,"
			+ "fsinitactivityinsid,fsflowkind,fcevent,fcright,fsinnersubflow,"
			+ "fshandlerid,fsoriginalhandler,fstag)  VALUES "
			+ " ( '"
			+ uid22
			+ "',1,'U',"
			+ "'"
			+ uid
			+ "','5063875d-012d-1000-e000-4a8d137f0969',"
			+ "'5063875d-012d-1000-e000-4a84137f0969','派发','待派发','"
			+ uuid
			+ "','63eaf009-0126-1000-e000-14b9137f0969',"
			+ "'23493356-0120-1000-e000-0d1fc0a80169','"
			+ dateString
			+ "',"
			+ "'"
			+ uid1
			+ "','0','T','B,A','W','"
			+ uid
			+ "',"
			+ "'5ef659df-012a-1000-e000-35eb137f0969','23493356-0120-1000-e000-0d1fc0a80169','B')";//吴小娜
		System.out.println(sql22);
		st.execute(sql22);

	
		String sql2218 = " UPDATE TWFActivityIns SET fcactivestate = 'C',fdendtime = '"
				+ dateString + "'" + "WHERE fsactinsid = '" + uid2 + "'";
		UUID uid2213 = UUID.randomUUID();
		st.execute(sql2218);
		System.out.println(sql2218);
		String sql2219 = "INSERT INTO TWFActivityInsHandler ( fsid,fsprocinsid,fsactivityinsid,fccategory"
				+ ",fsflowkind,fcactivestate,fshandlerid,fsmemo )  VALUES  "
				+ "( '"
				+ uid2213
				+ "','"
				+ uid
				+ "','"
				+ uid22
				+ "',"
				+ "'H','T','U','5ef659df-012a-1000-e000-35eb137f0969','新建经办人' )";
		st.execute(sql2219);
		System.out.println(sql2219);
		String sql22110 = "DELETE FROM TWFActivityInsHandler WHERE  fsactivityinsid='"
			+ uid3
			+ "'"
			+ " AND fshandlerid='23493356-0120-1000-e000-0d1fc0a80169' AND fsprocinsid='"
			+ uid + "'";
		st.execute(sql22110);
		System.out.println(sql22110);
		
		
		
		///////// 指挥中心
		UUID uid23 = UUID.randomUUID();
		String sql23 = "INSERT INTO TWFActivityIns ( fsactinsid,fiorder,"
			+ "fcactivestate,fsprocinsid,fspassroute,fsactid,fsactname,"
			+ "fshints,fscaseid,fscateid,fscreateuserid,fdcreatetime,fsprevactid,"
			+ "fsinitactivityinsid,fsflowkind,fcevent,fcright,fsinnersubflow,"
			+ "fshandlerid,fsoriginalhandler,fstag)  VALUES "
			+ " ( '"
			+ uid23
			+ "',1,'U',"
			+ "'"
			+ uid
			+ "','5063875d-012d-1000-e000-4a8d137f0969',"
			+ "'5063875d-012d-1000-e000-4a84137f0969','派发','待派发','"
			+ uuid
			+ "','63eaf009-0126-1000-e000-14b9137f0969',"
			+ "'23493356-0120-1000-e000-0d1fc0a80169','"
			+ dateString
			+ "',"
			+ "'"
			+ uid1
			+ "','0','T','B,A','W','"
			+ uid
			+ "',"
			+ "'23493356-0120-1000-e000-0d1fc0a80169','23493356-0120-1000-e000-0d1fc0a80169','B')";//指挥中心
		System.out.println(sql23);
		st.execute(sql23);

	
		String sql2318 = " UPDATE TWFActivityIns SET fcactivestate = 'C',fdendtime = '"
				+ dateString + "'" + "WHERE fsactinsid = '" + uid2 + "'";
		UUID uid2313 = UUID.randomUUID();
		st.execute(sql2318);
		System.out.println(sql2318);
		String sql2319 = "INSERT INTO TWFActivityInsHandler ( fsid,fsprocinsid,fsactivityinsid,fccategory"
				+ ",fsflowkind,fcactivestate,fshandlerid,fsmemo )  VALUES  "
				+ "( '"
				+ uid2313
				+ "','"
				+ uid
				+ "','"
				+ uid23
				+ "',"
				+ "'H','T','U','23493356-0120-1000-e000-0d1fc0a80169','新建经办人' )";
		st.execute(sql2319);
		System.out.println(sql2319);
		String sql23110 = "DELETE FROM TWFActivityInsHandler WHERE  fsactivityinsid='"
			+ uid3
			+ "'"
			+ " AND fshandlerid='23493356-0120-1000-e000-0d1fc0a80169' AND fsprocinsid='"
			+ uid + "'";
		st.execute(sql23110);
		System.out.println(sql23110);
		


		String  comments="UPDATE TWFActivityIns SET fscomments = ' ',fssecretcomments = '',fdcommenttime = '"+dateString+"',fscommenttypeid = '4aa3d0fd-0129-1000-e000-4d45137f0969' WHERE fsactinsid = '"+uid12+"'";
		String  comments1="UPDATE TWFActivityIns SET fscomments = ' ',fssecretcomments = '',fdcommenttime = '"+dateString+"',fscommenttypeid = '4aa3d0fd-0129-1000-e000-4d45137f0969' WHERE fsactinsid = '"+uid21+"'";
		String  comments2="UPDATE TWFActivityIns SET fscomments = ' ',fssecretcomments = '',fdcommenttime = '"+dateString+"',fscommenttypeid = '4aa3d0fd-0129-1000-e000-4d45137f0969' WHERE fsactinsid = '"+uid22+"'";
		String  comments3="UPDATE TWFActivityIns SET fscomments = ' ',fssecretcomments = '',fdcommenttime = '"+dateString+"',fscommenttypeid = '4aa3d0fd-0129-1000-e000-4d45137f0969' WHERE fsactinsid = '"+uid23+"'";

		st.execute(comments);
		st.execute(comments1);
		st.execute(comments2);
		st.execute(comments3);
	
		dm.closeConnection();
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

	public static String getFirstID(String source, String para1) {
		String[] result = source.split(para1);
		return result[1];
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

	/**
	 * 取出空格
	 * 
	 * @param s
	 *            需要替换的字符串
	 */
	public static String removeSpaces(String s) {
		StringTokenizer st = new StringTokenizer(s, " ", false);
		String t = "";
		while (st.hasMoreElements()) {
			t += st.nextElement();
		}
		return t;
	}

	/**
	 * 抽取纯文本信息
	 * 
	 * @param inputHtml
	 *            输入的网页文本信息
	 * @return 文本信息
	 */
	public static String extractText(String inputHtml) throws Exception {
		StringBuffer text = new StringBuffer();
		// System.out.println(inputHtml);
		Parser parser = Parser.createParser(new String(inputHtml.getBytes(),
				"GBK"), "GBK");
		// 遍历所有的节点
		NodeList nodes = parser.extractAllNodesThatMatch(new NodeFilter() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean accept(Node node) {
				return true;
			}
		});

		System.out.println(nodes.size());
		for (int i = 0; i < nodes.size(); i++) {
			Node nodet = nodes.elementAt(i);
			// System.out.println("NODES["+i+"]:"+new
			// String(nodet.toPlainTextString().getBytes("GBK")));
			text.append(new String(nodet.toPlainTextString().getBytes("GBK"))
					+ "\r\n");
		}
		System.out.println(text.toString());
		return text.toString();
	}

	/**
	 * 读取文件的方式来分析内容. filePath也可以是一个Url.
	 * 
	 * @param resource
	 *            文件/Url
	 */
	public static void test5(String resource) throws Exception {
		Parser myParser = new Parser(resource);

		// 设置编码
		myParser.setEncoding("GBK");
		String filterStr = "table";
		NodeFilter filter = new TagNameFilter(filterStr);
		NodeList nodeList = myParser.extractAllNodesThatMatch(filter);
		TableTag tabletag = (TableTag) nodeList.elementAt(11);

		System.out.println(tabletag.toHtml());
		System.out.println("==============");

	}

	/**
	 * 
	 * @param content
	 *            需要转换的内容
	 * @return 转换后的内容
	 */
	public static String stripHtml(String content) {
		// <p>段落替换为换行
		content.trim();
		content = content.replaceAll("<p .*?>", "\n");
		// <br><br/>替换为换行
		content = content.replaceAll("<br\\s*/?>", "\n");
		// 去掉其它的<>之间的东西
		content = content.replaceAll("\\<.*?>", "");
		content = content.replaceAll("\\{.*?}", "");
		content = content.replaceAll("'", "’");
		// content = content.replaceAll("\\(.*?)", "");
		content.trim();
		// 还原HTML
		// content = HTMLDecoder.decode(content);dbbd
		return content;
	}

	public static void insert(Bean12345 b12345) throws SQLException {

	}

	public static boolean isGuidExit(String guid) throws SQLException {
		DaoManager dm = new DaoManager();
		boolean type = false;
		dm.initConnection();
		String sql = "select count(*) from ASFormk123456 where fid=" + guid;
		System.out.println(sql);
		Statement st = dm.conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			String is = rs.getString(1);
			if ("0".equals(is)) {
				type = true;
			}

		}
		dm.closeConnection();
		return type;
	}

	public static boolean isGuidExitF(String guid) throws SQLException {
		DaoManager dm = new DaoManager();
		boolean type = false;
		dm.initConnection();
		String sql = "select count(*) from ASFormszcg1 where fid='" + guid
				+ "'";
		System.out.println(sql);
		Statement st = dm.conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			String is = rs.getString(1);
			if ("0".equals(is)) {
				type = true;
			}

		}
		dm.closeConnection();
		return type;
	}

	/*
	 * 获取最大ID
	 */
	public static String MaxId() throws SQLException {
		DaoManager dm = new DaoManager();
		String id = null;
		dm.initConnection();
		String sql = "select max(fId) from ASFormk123456";
		System.out.println(sql);
		Statement st = dm.conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			id = rs.getString(1);

		}
		dm.closeConnection();
		return id.trim();
	}

	public static String MaxIdM() throws SQLException {
		DaoManager dm = new DaoManager();
		String id = null;
		dm.initConnection();
		String sql = "select max(maxid) from my_maxid";
		System.out.println(sql);
		Statement st = dm.conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			id = rs.getString(1);

		}
		dm.closeConnection();
		return id.trim();
	}

	public static void UpdateMaxIdM(int m) throws SQLException {
		DaoManager dm = new DaoManager();
		String id = null;
		dm.initConnection();
		String sql = "update my_maxid set maxid=" + m + " where (id=1)";
		System.out.println(sql);
		Statement st = dm.conn.createStatement();
		st.execute(sql);
		dm.closeConnection();
	}

	public static String MaxIdF() throws SQLException {
		DaoManager dm = new DaoManager();
		String id = null;
		dm.initConnection();
		String sql = "select max(fId) from ASFormszcg1";
		System.out.println(sql);
		Statement st = dm.conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			id = rs.getString(1);
			if (id == null) {
				id = "0";
			}
		} else {
			id = "0";
		}
		dm.closeConnection();
		return id.trim();
	}

	/*
	 * 获取最小ID
	 */
	public static String MinId() throws SQLException {
		DaoManager dm = new DaoManager();
		String id = null;
		dm.initConnection();
		String sql = "select min(fId) from ASFormk123456";
		System.out.println(sql);
		Statement st = dm.conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			id = rs.getString(1);
			id = getFirstID(id, "2005081111179");
		}
		dm.closeConnection();
		return id;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 */
	
	
	
	
	
	public static Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	public static void startRun(){
		final TimerTask registerTask = new SwingTimerTask() {
			public void doRun() {
				try {
					getContentID();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
		};
		TaskEngine.getInstance().schedule(registerTask, 1000,300000);
	}
	
	public static void getSzcgFromCity() throws RemoteException, NumberFormatException, SQLException, ParseException{
		PropertyConfigurator.configure ("log4j.properties") ;
		logger.setLevel( ( Level ) Level.WARN ) ;
		DUMServiceSoapProxy dm = new DUMServiceSoapProxy();
		WSGetTasksParameter wp = new WSGetTasksParameter();
		wp.setLoginName("pjqcgj");
		wp.setLoginPass("12345678");
		wp.setDepartId("f47d5d71-535d-4050-a268-fce4efe538f5");
		SZCGEventTask st= dm.getTasks(wp);
		SZCGEvent[] sevent = st.getEvents();
		myBeanAll mybean=null;
		for(SZCGEvent e:sevent){
			logger.warn("id:"+e.getEventId());
			logger.warn("desc:"+e.getDesc());
			logger.warn("time:"+e.getTaskDate());
			logger.warn("opinin:"+e.getTaskOpinion());
			logger.warn("streetname"+e.getStreetName());
			mybean  = new myBeanAll();
			mybean.setLbEventID(e.getEventId());
			mybean.setLbName(e.getTitle());
			mybean.setLbDate(e.getTaskDate());
			mybean.setLbCommingPhone("");
			mybean.setLbPhone1("");
			mybean.setLbPhone2("");
			mybean.setLbPhone3("");
			mybean.setLbAgentID("");
			mybean.setLbTitle(e.getTitle());
			mybean.setLbContent(e.getDesc());
			mybean.setEventtype(e.getTypeName());
			mybean.setBigType(e.getBigClassName());
			mybean.setSmallType(e.getSmallClassName());
			 
			insertForm(mybean,"市数字城管");
		}
	}
	
	public static void main(String[] args) throws Exception {
		JFrame f = new JFrame();
		JButton jb  =new JButton("执行同步任务");
		f.setTitle("同步程序---批量发送流程");
		f.getContentPane().add(jb);
		f.setSize(300,200);
		f.setVisible(true);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				startRun();			
			}
			
		});
		
		
	}

}
