package MainCore;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.UUID;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;

import com.res.man.DaoManager;

/**
 * <br>
 * 标题:徒手抓12345 <br>
 * <br>
 * 
 * @author
 * @version 1.1
 */
public class catch12345 {
	/**
	 * 解析网页
	 * 
	 * @param guid
	 *            12345序号
	 * @return 解析后的内容
	 * @throws IOException
	 */
	static Logger logger = Logger.getLogger(catch12345.class.getName());

	public static String getContent(String guid) throws IOException {

		String sCurrentLine = "";
		String sTotalString = "";
		java.io.InputStream l_urlStream;
		java.net.URL l_url;
		java.io.BufferedReader l_reader;
		l_url = new java.net.URL(
				"http://12345.jiangmen.gov.cn/event_view.aspx?ID=" + guid);
		// System.out.println(l_url);
		java.net.HttpURLConnection l_connection = (java.net.HttpURLConnection) l_url
				.openConnection();
	//	l_connection.set
		l_connection.connect();
		l_urlStream = l_connection.getInputStream();
		/**
		 * 这里设置很重要，如果在eclise中能正常运行，脱离环境就会出现乱码，脱离环境会自动按照GBK读取，这样也会出现乱码，所以要加上编码
		 */
		l_reader = new java.io.BufferedReader(new java.io.InputStreamReader(
				l_urlStream,"UTF-8"));
		while ((sCurrentLine = l_reader.readLine()) != null) {
			sTotalString = sTotalString.trim();

			if ("".equals(sTotalString)) {
				sTotalString += sCurrentLine + "\r\n";
			} else {
				sTotalString += sCurrentLine + "\r\n";
			}
		}
		return sTotalString;
		
		//return new String(sTotalString.getBytes("utf-8"),"gb2312");
	}

	public static String getContent(URL url) throws IOException {
		String sCurrentLine = "";
		String sTotalString = "";
		java.io.InputStream l_urlStream;
		java.io.BufferedReader l_reader;
		// System.out.println(l_url);
		java.net.HttpURLConnection l_connection = (HttpURLConnection) url
				.openConnection();
		// l_connection.setFollowRedirects(false);
		l_connection.setUseCaches(true);
		// l_connection.setRequestProperty("Proxy-Connection", "Keep-Alive");
		// l_connection.setDoOutput(true);
		// l_connection.setDoInput(true);
		l_connection.connect();

		l_urlStream = l_connection.getInputStream();
		l_reader = new java.io.BufferedReader(new java.io.InputStreamReader(
				l_urlStream));
		while ((sCurrentLine = l_reader.readLine()) != null) {
			sTotalString = sTotalString.trim();
			if ("".equals(sTotalString)) {
				sTotalString += sCurrentLine + "\n";
			} else {
				sTotalString += sCurrentLine + "\n";
			}
		}
		l_urlStream.close();
		// l_connection.disconnect();
		System.out.println(sTotalString);
		return sTotalString;
	}

	/**
	 * 降序抓取
	 * 
	 * @return 降序抓取的集合对象
	 * @throws IOException
	 * @throws SQLException
	 */
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
					b12345.setViewTime(getBetween(testText,
							b12345.getTaskTitle(), "事项主题"));
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

					Date dt = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					String dateString = formatter.format(dt);
					System.out.println(dateString);

					String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f123],[f114],[f115])"
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

	/**
	 * 对升序获取的12345内容进行抓取
	 * 
	 * @return 返回抓取后的集合对像
	 * @throws IOException
	 * @throws SQLException
	 */
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
					b12345.setTaskContent(getBetween(testText, "事项内容:", "处理结果:"));
					b12345.setClResult(replace(
							getBetween(testText, "处理结果:", "主办：江门市市委、市政府"), "[",
							""));

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
						String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f123],[f114],[f115])"
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
						String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f123],[f114],[f115])"
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
						String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f123],[f114],[f115])"
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

	public static void updateHtmlUpCity12345(String id) throws IOException,
			SQLException {
		String temp = null;
		String guid;
		String testText;
		DaoManager dm = new DaoManager();
		guid = String.valueOf(id);
		System.out.println("_____________处理_________________________" + id);

		temp = getContent(guid);
		dm.initConnection();
		Statement st = dm.conn.createStatement();
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
			testText = replace(testText, " ", "");
			testText = testText.replaceAll("\\s+", "\n");
			// System.out.println(testText);
			Bean12345 b12345 = new Bean12345();

			b12345.setTaskTitle(getBetween(testText, "事项主题:", "行政区域:"));
			b12345.setGovArea(getBetween(testText, "行政区域:", "处理部门:"));
			b12345.setClDept(getBetween(testText, "处理部门:", "呼叫类别:"));
			b12345.setHjType(getBetween(testText, "呼叫类别:", "处理状态:"));
			b12345.setClState(getBetween(testText, "处理状态:", "事项时间:"));
			b12345.setTaskTime(getBetween(testText, "事项时间:", "事项类别:"));
			b12345.setTaskType(getBetween(testText, "事项类别:", "事项地点:"));
			b12345.setTaskAdd(getBetween(testText, "事项地点:", "事项内容:"));
			b12345.setTaskContent(getBetween(testText, "事项内容:", "处理结果:"));
			b12345.setClResult(replace(
					getBetween(testText, "处理结果:", "主办：江门市市委、市政府"), "[", ""));

			System.out.println("***************处理同步中未办结的任务***********start");
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
			System.out.println("////////////////////////////////////////end");
			// insert(b12345);
			if (b12345.getClDept() == null || "".equals(b12345.getClDept())) {
				// System.out.println("error对不起，没有此条新闻,系统回退。");
				// return;

			} else {

				String sql2 = "update [chinaweal].[dbo].[ASFormk123456] set f18='"
						+ b12345.getClResult().trim()
						+ "',f112='"
						+ b12345.getClState().trim()
						+ "',f123='"
						+ b12345.getTaskTime()
						+ "'  where fid like '%"
						+ guid
						+ "%'";
				System.out.println(sql2);
				st.execute(sql2);
			}
		}
		dm.closeConnection();

	}

	public static void getHtmlUpCity12345() throws IOException, SQLException {
		String temp = null;
		String guid;
		String testText;
		DaoManager dm = new DaoManager();
		int f = 23;
		f = Integer.parseInt(MaxIdM());
		int flag = 0;
		for (int i = f;; i++) {
			guid = String.valueOf(i);
			if (isGuidExit(guid)) {
				temp = getContent(guid);
				String[] result = temp.split("事项主题");
				if ("对不起，没有此条新闻。".equals(temp) || result.length < 1) {
					System.out.println("error对不起，没有此条新闻。");
					break;
				}
				dm.initConnection();
				Statement st = dm.conn.createStatement();
				if (result.length > 1) {
					testText = stripHtml(temp);

					testText = removeSpaces(testText);
					testText = replace(testText, ":&nbsp;", "");
					testText = replace(testText, ";&nbsp;", "");
					testText = replace(testText, "&nbsp;", "");
					testText = replace(testText, " ", "");
					testText = testText.replaceAll("\\s+", "\n");
					// System.out.println(testText);
					Bean12345 b12345 = new Bean12345();

					b12345.setTaskTitle(getBetween(testText, "事项主题:", "行政区域:"));
					b12345.setGovArea(getBetween(testText, "行政区域:", "处理部门:"));
					b12345.setClDept(getBetween(testText, "处理部门:", "呼叫类别:"));
					b12345.setHjType(getBetween(testText, "呼叫类别:", "处理状态:"));
					b12345.setClState(getBetween(testText, "处理状态:", "事项时间:"));
					b12345.setTaskTime(getBetween(testText, "事项时间:", "事项类别:"));
					b12345.setTaskType(getBetween(testText, "事项类别:", "事项地点:"));
					b12345.setTaskAdd(getBetween(testText, "事项地点:", "事项内容:"));
					b12345.setTaskContent(getBetween(testText, "事项内容:", "处理结果:"));
					b12345.setClResult(replace(
							getBetween(testText, "处理结果:", "主办：江门市市委、市政府"), "[",
							""));

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
							break;
						}

					} else {

						Date dt = new Date();
						SimpleDateFormat formatter = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						String dateString = formatter.format(dt);
						System.out.println(dateString);
						String ttime = b12345.getTaskTime().substring(0, 4);
						System.out.println("字符串处理结果" + ttime);

						if (b12345.getClDept().startsWith("蓬江区城管")) {
							String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f123],[f114],[f115],[f120])"
									+ "VALUES('"
									+ guid
									+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
									+ b12345.getTaskTime()
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
									+ b12345.getTaskType()
									+ "',0,'"
									+ guid
									+ "')";
							System.out.println(sql2);
							st.execute(sql2);
							// st.close();

						}

						UpdateMaxIdM(i);
					}
				}
				dm.closeConnection();
			}

		}

	}

	/**
	 * if (b12345.getClDept().startsWith("蓬江区城管") &&
	 * "已办理".equals(b12345.getClState().trim())) { String sql2 =
	 * "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f123],[f114],[f115])"
	 * + "VALUES('" + guid +
	 * "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
	 * + dateString + "','" + b12345.getTaskContent() + "','" +
	 * b12345.getClResult() + "','" + b12345.getTaskTitle() + "','" +
	 * b12345.getGovArea() + "'," + "'" + b12345.getClDept() + "','" +
	 * b12345.getHjType() + "','" + b12345.getClState() + "','" +
	 * b12345.getTaskTime() + "','" + b12345.getTaskType() + "',0,'" + guid +
	 * "')"; System.out.println(sql2); st.execute(sql2);
	 * 
	 * }
	 * 
	 * if (b12345.getClDept().startsWith("蓬江区城管") &&
	 * "处理中".equals(b12345.getClState())) { String sql2 =
	 * "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f123],[f114],[f115])"
	 * + "VALUES('" + guid +
	 * "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
	 * + dateString + "','" + b12345.getTaskContent() + "','" +
	 * b12345.getClResult() + "','" + b12345.getTaskTitle() + "','" +
	 * b12345.getGovArea() + "'," + "'" + b12345.getClDept() + "','" +
	 * b12345.getHjType() + "','" + b12345.getClState() + "','" +
	 * b12345.getTaskTime() + "','" + b12345.getTaskType()
	 * 
	 * + "',0,'"
	 * 
	 * + guid + "')"; System.out.println(sql2); st.execute(sql2); }
	 */

	/**
	 * 对升序获取的12345内容进行抓取
	 * 
	 * @return 返回抓取后的集合对像
	 * @throws IOException
	 * @throws SQLException
	 */
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
				Uuid uid = Uuid.create();
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

				String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormoldszcg]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f2],[f5],[f17],[f18],[f72],[f77],[f78],[f82],[f85],[f89],[f99],[f108],[f109],[f110],position_x,position_y)"
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

	}

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
				+ "',1,'数字城管工单流程',"
				+ "'b04d5023-3e0e-5e74-1638-e19f3668813a'," + // 不变的流程号
				"'" + uuid + "'," + // 关联的表单号
				"'63eaf009-0126-1000-e000-14b9137f0969'," + // 不变的编号
				"'数字城管','A','0'," + "'数字城管工单流程--" + title + "'," + // 标题
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
				+ "'b054006b-256a-8816-2db5-82ba45ef8261',"
				+ "'b04ec6f4-c7f2-5404-f4d5-caa6b5e28e31',"
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
		//
		// String
		// sql6="UPDATE TWFActivityIns SET fdsigntime = '"+dateString+"',fshandlerid = '"
		// +
		// "23493356-0120-1000-e000-0d1fc0a80169',fcactivestate = 'A' WHERE fsactinsid = '"+uid1+"'";
		//
		// st.execute(sql6);
		// System.out.println(sql6);
		//
		// String
		// sql7="UPDATE TWFActivityInsHandler SET fcactivestate = 'A' WHERE fsactivityinsid='"+uid1+"' "
		// +
		// "AND fshandlerid='23493356-0120-1000-e000-0d1fc0a80169'";
		//
		// st.execute(sql7);
		//
		// System.out.println(sql7);
		dm.closeConnection();
		System.out.println("添加成功");

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

		// content = content.replaceAll("\\{.*?}", "");
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
		String sql = "select count(*) from ASFormk123456 where fid='" + guid
				+ "'";
		System.out.println(sql);
		Statement st = dm.conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			String is = rs.getString(1);
			if ("0".equals(is.trim())) {
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

	public static void DoneTaskHandler() throws IOException {
		String sql = "select * from ASFormk123456 where f112='处理中' and Year(getDate())=Year(f123)";
		// String update = "update ASFormk123456 set f112='处理完毕' where fid=";
		DaoManager dm = new DaoManager();
		dm.initConnection();
		Statement st;
		String caseid;
		try {
			st = dm.conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				caseid = rs.getString("fid").trim();
				catch12345.updateHtmlUpCity12345(caseid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static void main(String[] args){
	//	PropertyConfigurator.configure(".\\log4j.properties");
	//	catch12345ForAll.logger.setLevel((Level) Level.WARN);
	    catch12345ForAll  c1 = new catch12345ForAll();
	    c1.initui();
	    catch12345ForAll.runall();
	   
	}	
//	public static void main(String[] args) throws Exception {
//		/*
//		 * PropertyConfigurator.configure ("log4j.properties") ;
//		 * logger.setLevel( ( Level ) Level.WARN ) ; DUMServiceSoapProxy dm =
//		 * new DUMServiceSoapProxy(); WSGetTasksParameter wp = new
//		 * WSGetTasksParameter(); wp.setLoginName("pjqcgj");
//		 * wp.setLoginPass("12345678");
//		 * wp.setDepartId("f47d5d71-535d-4050-a268-fce4efe538f5"); SZCGEventTask
//		 * st= dm.getTasks(wp); SZCGEvent[] sevent = st.getEvents();
//		 * for(SZCGEvent e:sevent){ logger.warn("id:"+e.getEventId());
//		 * logger.warn("desc:"+e.getDesc());
//		 * logger.warn("time:"+e.getTaskDate());
//		 * logger.warn("opinin:"+e.getTaskOpinion());
//		 * logger.warn("streetname"+e.getStreetName()); }
//		 */
//	//	DoneTaskHandler();
//		getHtmlUpCity12345();
//
//		// DoneTaskServiceLocator td = new DoneTaskServiceLocator();
//		// DoneTask dt = td.getDoneTask();
//		// DoneTaskBean dtb=
//		// dt.getDoneTask("04da34c1-012f-1000-e000-0045c0a84101");
//		// HashMap plmm = dtb.getComment();
//		// Set s = plmm.keySet();
//		// for(Iterator<String> ls=s.iterator();ls.hasNext();){
//		// String ss = ls.next();
//		// System.out.println(ss);
//		// }
//
//	}
}
