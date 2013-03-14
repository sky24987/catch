package MainCore;

import com.res.man.DaoManager;
import com.service.doneTask.DoneTaskBean;
import com.topevery.www.DUMServiceSoapProxy;
import com.topevery.www.SZCGEvent;
import com.topevery.www.SZCGEventFile;
import com.topevery.www.SZCGEventTask;
import com.topevery.www.WSGetTasksParameter;
import com.topevery.www.WSProcessSZCGEventParameter;
import com.topevery.www.WSProcessSZCGEventResult;
import com.topevery.www.WSRollbackSZCGEventParameter;
import com.topevery.www.WSRollbackSZCGEventResult;
import com.wfbean.TWFActivityIns;
import com.wfbean.TWFActivityInsHandler;
import com.wfbean.TWFProcessInsHandler;
import com.wfbean.TWFProcessInstance;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimerTask;
import java.util.UUID;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import org.apache.log4j.Logger;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;

import util.DateUtil;
import watij.elements.Button;
import watij.elements.HtmlElement;
import watij.elements.HtmlElements;
import watij.elements.Option;
import watij.elements.SelectList;
import watij.elements.Span;
import watij.elements.TextField;
import watij.finders.SymbolFactory;
import watij.runtime.ie.IE;

public class catch12345ForAll {
	private static IE ie8 = null;
	public static Logger logger = Logger.getLogger(catch12345ForAll.class
			.getName());
	private final Action action = new SwingAction_1();
	private final Action action_1 = new SwingAction_2();
	static DaoManager dm = new DaoManager();
	static DUMServiceSoapProxy dms = new DUMServiceSoapProxy();
	static WSGetTasksParameter wp = new WSGetTasksParameter();
	private final Action action_2 = new SwingAction_3();
	private final Action action_3 = new SwingAction_4();
	static TimerTask s12345Task;//市12345数据抓取
	private static boolean isExcption=false;
	public static IE getIe() {
		try {
			if (isExcption||ie8 == null) {
				ie8 = new IE();

				ie8.start("http://12345.jiangmen.gov.cn/");
				//
				ie8.textField(SymbolFactory.name, "userid").set("");

				ie8.textField(SymbolFactory.name, "password").set("");
				
				//之前有select

/*				ie8.selectList(SymbolFactory.name, "type")
						.option(SymbolFactory.value, "1").select();
*/
				ie8.button(SymbolFactory.src, "images/login.jpg").click();

				ie8.waitUntilReady();
				ie8.waitUntilReady();
			} else {
				ie8.goTo("http://12345.jiangmen.gov.cn:9000/Default.aspx");
				ie8.waitUntilReady();
			}
		} catch (Exception e) {
			e.printStackTrace();
			processException();
		}
		return ie8;
	}

	/**
	 * 
	 * @category 处理跨越工作日的时间
	 * @param d
	 *            需要处理的时间
	 * @param m
	 *            需要加成的时间
	 * @return 处理后的时间
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
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			c.add(Calendar.DAY_OF_MONTH, m);
		} else if (c.get(Calendar.DAY_OF_WEEK) == 2) {
			c.add(Calendar.DAY_OF_MONTH, m - 1);
		} else {
			c.add(Calendar.DAY_OF_MONTH, m + 1);
		}
		String mDateTime = formatter.format(c.getTime());
		System.out.println(mDateTime);
		return mDateTime;
	}
	
 
	

   public static void processException(){
	    System.out.println("处理异常");
	    try {
			ie8.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ie8=null;
	    
		TaskEngine.getInstance().cancelScheduledTask(s12345Task);
		TaskEngine.getInstance().schedule(s12345Task, 1000L, 300000L);
   }
	
	/**
	 * 获取页面所有的ID号
	 */
	public static void getContentID()  {
		try {
		ie8 = getIe();
		
		ie8.goTo("http://12345.jiangmen.gov.cn:9000/findevents.aspx");

		ie8.button(SymbolFactory.name, "ctl00$ContentPlaceHolder1$Button3")
				.click();
		ie8.waitUntilReady();
		HtmlElements hm = ie8.htmlElements(SymbolFactory.tag, "span");
		String[] str = new String[30];
		int m = 0;

		for (int j = 0; j < hm.length(); j++) {
			if ((!"事项编号：".equals(((HtmlElement) hm.get(j)).text().trim()))
					|| (!"呈送时间：".equals(((HtmlElement) hm.get(j + 2)).text()
							.trim())))
				continue;
			System.out.println(((HtmlElement) hm.get(j + 1)).text());
			str[m] = ((HtmlElement) hm.get(j + 1)).text().trim();
			m++;
		}

		for (int i = str.length - 1; i >= 0; i--) {
			if (isGuidExitF(str[i].trim())) {
				myBeanAll mb = getMaicontent(str[i].trim());
				ie8.waitUntilReady();
				insertForm(mb, "12345政府服务热线");
			} else {
				System.out
						.println("该办件已经生成，不必再添加：——————————————————————————————————>");
			}
		}
		System.out.println("待办生成完毕，系统将在两分钟后自动检测");

		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.MINUTE));
		if ((cal.get(Calendar.MINUTE) == 21)
				|| ((cal.get(Calendar.MINUTE) == 1))
				|| ((cal.get(Calendar.MINUTE) == 41))) {
			ie8.close();
			ie8 = null;
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("获取ID发生错误");
			e.printStackTrace();
			processException();
		}
	}

	public static void insert12345(String id){
		ie8 = getIe();
		try {
			ie8.goTo("http://12345.jiangmen.gov.cn:9000/findevents.aspx");

		ie8.button(SymbolFactory.name, "ctl00$ContentPlaceHolder1$Button3")
				.click();
		ie8.waitUntilReady();
		if (isGuidExitF(id)) {
			myBeanAll mb = getMaicontent(id);
			ie8.waitUntilReady();
			insertForm(mb, "12345政府服务热线");
		} else {
			System.out
					.println("该办件已经生成，不必再添加：——————————————————————————————————>");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			processException();
		}
	}

	public static myBeanAll getMaicontent(String ids) throws Exception {
		System.out.println(ids);
		myBeanAll bl = new myBeanAll();
		ie8.goTo("http://12345.jiangmen.gov.cn:9000/replyevent.aspx?id=" + ids);
		ie8.waitUntilReady();
		bl.setLbName(ie8.span(SymbolFactory.id, "lbName").text());
		bl.setLbDate(ie8.span(SymbolFactory.id, "lbDate").text());
		bl.setLbCommingPhone(ie8.span(SymbolFactory.id, "lbCommingPhone")
				.text());
		bl.setLbPhone1(ie8.span(SymbolFactory.id, "lbPhone1").text());
		bl.setLbPhone2(ie8.span(SymbolFactory.id, "lbPhone2").text());
		bl.setLbPhone3(ie8.span(SymbolFactory.id, "lbPhone3").text());
		bl.setLbEventID(ie8.span(SymbolFactory.id, "lbEventID").text());
		bl.setLbAgentID(ie8.span(SymbolFactory.id, "lbAgentID").text());
		bl.setLbTitle(ie8.span(SymbolFactory.id, "lbTitle").text());

		bl.setLbContent(ie8.span(SymbolFactory.id, "lbContent").text());
		bl.setEventtype("事件");
		bl.setBigType("大件废弃物");
		bl.setSmallType("施工废弃料");
		bl.setAddressdesc(bl.getLbTitle());
		System.out.println(bl.getLbAgentID());
		System.out.println(bl.getLbName());
		System.out.println(bl.getLbContent());
		ie8.waitUntilReady();
		ie8.goTo("http://12345.jiangmen.gov.cn:9000/Default.aspx");
		return bl;
	}

	public static void insertForm(myBeanAll mb, String type)
			throws SQLException, NumberFormatException, ParseException {
		mb.setActivityInstanceId("");
		insertForm(mb, type, mb.getLbEventID(), 0, null);
	}

	public static void insertForm(myBeanAll mb, String type, String id,
			int hasfile, SZCGEventFile[] sfile) throws SQLException,
			NumberFormatException, ParseException {
		DaoManager dm = new DaoManager();
		dm.initConnection();
		Statement st = dm.conn.createStatement();
		boolean isinrollback=isexistInT_SSZCG_ROLLBACK(mb.getLbEventID());
		int timeelipse=DateUtil.compareDate(mb.getLbDate().trim(), null, 0);
		if ((isGuidExitF(mb.getLbEventID()))
				&& (!isinrollback)&&timeelipse<50) {
			Calendar ca = Calendar.getInstance();
			int year = ca.get(Calendar.YEAR);// 获取年份

			if (mb.getPosx() == null) {
				mb.setPosx("");
			}
			if (mb.getPosy() == null) {
				mb.setPosy("");
			}
			String sql3 = "insert into ASFormszcg1 (fId,fUser,fDept,fPos,fOrg,fTime,f2,f3,f4,f5,f17,f18,f72,f77,f78,f82,f115,f89,f99,f108,f109,f110,position_x,position_y,activityInstanceId) values('"
					+ mb.getLbEventID()
					+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
					+ mb.getLbDate()
					+ "'"
					+ ",'美景社区','任务["
					+ year
					+ "]"
					+ Integer.parseInt(id)
					+ "号','5063875d-012d-1000-e000-4a52137f0969','"
					+ mb.getLbDate().trim()
					+ "','"
					+ mb.getAddressdesc().trim()
					+ "','"
					+ mb.getLbContent()
					+ " 联系人："
					+ mb.getLbName()
					+ "  联系电话1:"
					+ mb.getLbPhone1()
					+ "  联系电话2："
					+ mb.getLbPhone2()
					+ "   联系电话3："
					+ mb.getLbPhone3()
					+ "',"
					+ hasfile
					+ ",'"
					+ type
					+ "','23493356-0120-1000-e000-0d1fc0a80169','23493356-0120-1000-e000-00c9c0a80169','"
					+ "蓬江区城管局"
					+ "','"
					+ getDateAfter(mb.getLbDate().trim(), 5)
					+ "','"
					+ mb.getEventtype()
					+ "','"
					+ mb.getBigType()
					+ "','"
					+ mb.getSmallType()
					+ "','','"
					+ mb.getPosx()
					+ "','"
					+ mb.getPosy()
					+ "','"
					+ mb.getActivityInstanceId()
					+ "')";
			System.out.println(sql3);
			st.execute(sql3);
			newWf(mb.getLbEventID(), mb.getLbTitle());

			if (!isGuidExit(mb.getLbEventID())) {
				if ("12345政府服务热线".equals(type)) {
					insertK123456(copyMyBeanToBean12345(mb), mb.getLbEventID());
				} else if ("市数字城管".equals(type)) {
					insertK123456(copyMyBeanToBean12345(mb), mb.getLbTitle());
				}
			}
			if (sfile != null) {
				System.out.println("加入文件");
				inserFile(sfile, mb.getLbEventID());
			}
			System.out.println("添加成功");
			
		} else if((isGuidExitF(mb.getLbEventID()))//处理市数字城管中回传了再传回来的数据
				&& (isinrollback)&&type.equals("市数字城管")&&timeelipse<30){
			Calendar ca = Calendar.getInstance();
			int year = ca.get(Calendar.YEAR);// 获取年份

			if (mb.getPosx() == null) {
				mb.setPosx("");
			}
			if (mb.getPosy() == null) {
				mb.setPosy("");
			}
			
			System.out.println();
			//先删除掉数据
			String deletesql="delete from ASFormszcg1 where fid='"+mb.getLbEventID()+"'";
			st.execute(deletesql);
			//再将数据插入
			String sql3 = "insert into ASFormszcg1 (fId,fUser,fDept,fPos,fOrg,fTime,f2,f3,f4,f5,f17,f18,f72,f77,f78,f82,f115,f89,f99,f108,f109,f110,position_x,position_y,activityInstanceId) values('"
					+ mb.getLbEventID()
					+ "','c29732f2-011f-1000-e000-008c137f0902','47f3818d-011d-1000-e000-0004ac16507f','a47d6ad0-0121-1000-e000-12ce137f0902','47f3818d-011d-1000-e000-0000ac16507f','"
					+ mb.getLbDate()
					+ "'"
					+ ",'美景社区','任务["
					+ year
					+ "]"
					+ Integer.parseInt(id)
					+ "号','5063875d-012d-1000-e000-4a52137f0969','"
					+ mb.getLbDate().trim()
					+ "','"
					+ mb.getAddressdesc().trim()
					+ "','"
					+ mb.getLbContent()
					+ " 联系人："
					+ mb.getLbName()
					+ "  联系电话1:"
					+ mb.getLbPhone1()
					+ "  联系电话2："
					+ mb.getLbPhone2()
					+ "   联系电话3："
					+ mb.getLbPhone3()
					+ "',"
					+ hasfile
					+ ",'"
					+ type
					+ "','23493356-0120-1000-e000-0d1fc0a80169','23493356-0120-1000-e000-00c9c0a80169','"
					+ "蓬江区城管局"
					+ "','"
					+ getDateAfter(mb.getLbDate().trim(), 5)
					+ "','"
					+ mb.getEventtype()
					+ "','"
					+ mb.getBigType()
					+ "','"
					+ mb.getSmallType()
					+ "','','"
					+ mb.getPosx()
					+ "','"
					+ mb.getPosy()
					+ "','"
					+ mb.getActivityInstanceId()
					+ "')";
			System.out.println(sql3);
			st.execute(sql3);
			newWf(mb.getLbEventID(), mb.getLbTitle());
			if (sfile != null) {
				System.out.println("加入文件");
				inserFile(sfile, mb.getLbEventID());
			}
			System.out.println("添加成功");
			System.out.println("回退后的案件");
		}else{
			System.out.println("已经添加过该案件");
			
		}

		st.close();
		dm.closeConnection();
	}

	public static void CreateTWFProcessInstance(TWFProcessInstance twf) {
		DaoManager dm = new DaoManager();
		dm.initConnection();

		String sql2 = "INSERT INTO TWFProcessInstance ( fsprocinsid,fsparentprocinsid,fsactivityinsid,fscreateuserid,fscurrentuserid,fscurrentdeptid,fdcreatetime,fiorder,fsprocname,fsprocid,fscaseid,fscateid,fscatename,fcactivestate,fsurgentextent,fsapplication,fsorgid,fsformid )  VALUES  ( '"
				+ twf.getFsprocinsid()
				+ "',"
				+ "'"
				+ twf.getFsparentprocinsid()
				+ "',"
				+ "'"
				+ twf.getFsactivityinsid()
				+ "',"
				+ "'"
				+ twf.getFsactivityinsid()
				+ "'"
				+ ",'"
				+ twf.getFscreateuserid()
				+ "',"
				+ "'"
				+ twf.getFscurrentuserid()
				+ "',"
				+ "'"
				+ twf.getFdcreatetime()
				+ "',"
				+ twf.getFiorder()
				+ ","
				+ "'"
				+ twf.getFsprocname()
				+ "',"
				+ "'"
				+ twf.getFsprocid()
				+ "',"
				+ "'"
				+ twf.getFscaseid()
				+ "',"
				+ "'"
				+ twf.getFscateid()
				+ "',"
				+ "'"
				+ twf.getFscatename()
				+ "'"
				+ ",'"
				+ twf.getFcactivestate()
				+ "'"
				+ ",'"
				+ twf.getFsurgentextent()
				+ "'"
				+ ","
				+ "'"
				+ twf.getFsapplication()
				+ "',"
				+ "'"
				+ twf.getFsorgid()
				+ "'"
				+ ","
				+ "'"
				+ twf.getFsformid()
				+ "' )";
		System.out.println(sql2);
		try {
			Statement st = dm.conn.createStatement();
			st.execute(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dm.closeConnection();
		}
	}
	/**
	 * 延迟发送
	 * @param time
	 */
	public static void doSleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void CreateTWFActivityIns(TWFActivityIns twfins) {
		DaoManager dm = new DaoManager();
		dm.initConnection();

		if (twfins.getFcisurgency() == null) {
			twfins.setFcisurgency("");
		}

		String sql2 = "INSERT INTO TWFActivityIns ( fsactinsid,fspassroute,fsactid,fsactname,fiorder,fsprevactid,fsinitactivityinsid,fcactivestate,fsprocinsid,fscaseid,fscateid,fshints,fcright,fscreateuserid,fsoriginalhandler,fshandlerid,fsflowkind,fdcreatetime,fcisurgency,fsmemo,fsinnersubflow,fcevent,fstag)  VALUES  ( '"
				+ twfins.getFsactinsid()
				+ "',"
				+ "'"
				+ twfins.getFspassroute()
				+ "',"
				+ "'"
				+ twfins.getFsactid()
				+ "',"
				+ "'"
				+ twfins.getFsactname()
				+ "'"
				+ ","
				+ twfins.getFiorder()
				+ ","
				+ "'"
				+ twfins.getFsprevactid()
				+ "',"
				+ "'"
				+ twfins.getFsinitactivityinsid()
				+ "',"
				+ "'"
				+ twfins.getFcactivestate()
				+ "',"
				+ "'"
				+ twfins.getFsprocinsid()
				+ "',"
				+ "'"
				+ twfins.getFscaseid()
				+ "',"
				+ "'"
				+ twfins.getFscateid()
				+ "',"
				+ "'"
				+ twfins.getFshints()
				+ "','"
				+ twfins.getFcright()
				+ "',"
				+ "'"
				+ twfins.getFscreateuserid()
				+ "',"
				+ "'"
				+ twfins.getFsoriginalhandler()
				+ "',"
				+ "'"
				+ twfins.getFshandlerid()
				+ "',"
				+ "'"
				+ twfins.getFsflowkind()
				+ "','"
				+ twfins.getFdcreatetime()
				+ "','"
				+ twfins.getFcisurgency()
				+ "','"
				+ twfins.getFsmemo()
				+ "',"
				+ "'"
				+ twfins.getFsinnersubflow()
				+ "' ,"
				+ "'"
				+ twfins.getFcevent() + "'," + "'" + twfins.getFstag() + "') ";
		try {
			System.out.println(sql2);
			Statement st = dm.conn.createStatement();
			st.execute(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dm.closeConnection();
		}
	}

	public static void CteateTWFActivityInsHandler(
			TWFActivityInsHandler twfhandler) {
		DaoManager dm = new DaoManager();
		dm.initConnection();

		String sql4 = "INSERT INTO TWFActivityInsHandler ( fsid,fsprocinsid,fsactivityinsid,fccategory,fsflowkind,fcactivestate,fshandlerid,fsmemo )  VALUES  ( '"
				+ twfhandler.getFsid()
				+ "','"
				+ twfhandler.getFsprocinsid()
				+ "','"
				+ twfhandler.getFsactivityinsid()
				+ "','"
				+ twfhandler.getFccategory()
				+ "','"
				+ twfhandler.getFsflowkind()
				+ "','"
				+ twfhandler.getFcactivestate()
				+ "','"
				+ twfhandler.getFshandlerid()
				+ "','"
				+ twfhandler.getFsmemo()
				+ "' )";
		try {
			Statement st = dm.conn.createStatement();
			System.out.println(sql4);
			st.execute(sql4);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dm.closeConnection();
		}
	}

	public static void CreateTWFProcessInsHandler(
			TWFProcessInsHandler twfphandler) {
		DaoManager dm = new DaoManager();
		dm.initConnection();

		String sql5 = "INSERT INTO TWFProcessInsHandler ( fsid,fsprocinsid,fsactinsid,fccategory,fcactivestate,fsmemo,fshandlerid,fsdeptid,fsorgid )  VALUES  ( '"
				+ twfphandler.getFsid()
				+ "','"
				+ twfphandler.getFsprocinsid()
				+ "','"
				+ twfphandler.getFsactinsid()
				+ "','"
				+ twfphandler.getFccategory()
				+ "','"
				+ twfphandler.getFcactivestate()
				+ "','"
				+ twfphandler.getFsmemo()
				+ "','"
				+ twfphandler.getFshandlerid()
				+ "',"
				+ "'"
				+ twfphandler.getFsdeptid()
				+ "','"
				+ twfphandler.getFsorgid()
				+ "' ) ";
		try {
			Statement st = dm.conn.createStatement();
			st.execute(sql5);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dm.closeConnection();
		}
	}
	
	/**
	 * 建立工作流
	 * @param uuid
	 * @param title
	 * @throws SQLException
	 */
	public static void newWf(String uuid,  String title)
			throws SQLException {
		DaoManager dm = new DaoManager();
		dm.initConnection();
		Statement st = dm.conn.createStatement();

		Date dt = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dt);
		System.out.println(dateString);

		UUID uid = UUID.randomUUID();

		TWFProcessInstance twf = new TWFProcessInstance();
		twf.setFsprocinsid(uid.toString());
		twf.setFsparentprocinsid("MAIN");
		twf.setFsactivityinsid("MAIN");
		twf.setFscreateuserid("23493356-0120-1000-e000-0d1fc0a80169");
		twf.setFscurrentuserid("23493356-0120-1000-e000-0d1fc0a80169");
		twf.setFscurrentdeptid("ba6e5292-0128-1000-e000-342d137f0969");
		twf.setFdcreatetime(dateString);
		twf.setFiorder("1");
		twf.setFsprocname("数字城管工单流程");
		twf.setFsprocid("5063875d-012d-1000-e000-4a52137f0969");
		twf.setFscaseid(uuid);
		twf.setFscateid("63eaf009-0126-1000-e000-14b9137f0969");
		twf.setFscatename("数字城管");
		twf.setFcactivestate("A");
		twf.setFsurgentextent("0");
		twf.setFsapplication(title);
		twf.setFsorgid("1049");
		twf.setFsformid("63eaf009-0126-1000-e000-0311137f0969");

		CreateTWFProcessInstance(twf);

		doSleep(1000L);
		Date dt1 = new Date();
		String dateString1 = formatter.format(dt1);
		UUID uid1 = UUID.randomUUID();
		TWFActivityIns twfins = new TWFActivityIns();
		twfins.setFsactinsid(uid1.toString());
		twfins.setFspassroute("5063875d-012d-1000-e000-4a58137f0969");
		twfins.setFsactid("5063875d-012d-1000-e000-4a8c137f0969");
		twfins.setFsactname("工单录入");
		twfins.setFiorder("1");
		twfins.setFsprevactid("0");
		twfins.setFsinitactivityinsid("0");
		twfins.setFcactivestate("U");
		twfins.setFsprocinsid(twf.getFsprocinsid());
		twfins.setFscaseid(uuid);
		twfins.setFscateid("63eaf009-0126-1000-e000-14b9137f0969");
		twfins.setFshints("录入工单");
		twfins.setFcright("R");
		twfins.setFscreateuserid("23493356-0120-1000-e000-0d1fc0a80169");
		twfins.setFsoriginalhandler("23493356-0120-1000-e000-0d1fc0a80169");
		twfins.setFshandlerid("23493356-0120-1000-e000-0d1fc0a80169");
		twfins.setFsflowkind("E");
		twfins.setFdcreatetime(dateString1);
		twfins.setFcisurgency("N");
		twfins.setFsmemo("新建流程活动");
		twfins.setFsinnersubflow(twf.getFsprocinsid());
		twfins.setFcevent("");
		CreateTWFActivityIns(twfins);

		TWFActivityInsHandler twfhandler = new TWFActivityInsHandler();
		twfhandler.setFsid(UUID.randomUUID().toString());
		twfhandler.setFsprocinsid(twf.getFsprocinsid());
		twfhandler.setFsactivityinsid(twfins.getFsactinsid());
		twfhandler.setFccategory("H");
		twfhandler.setFsflowkind("E");
		twfhandler.setFcactivestate("U");
		twfhandler.setFshandlerid("23493356-0120-1000-e000-0d1fc0a80169");
		twfhandler.setFsmemo("新建经办人");
		CteateTWFActivityInsHandler(twfhandler);

		String sql_sugess2 = "INSERT INTO TWFProcInsComments ( fsprocinsid,fscommentid,fscommentname,fiorder,fsprocid )  VALUES  ( '"
				+ uid
				+ "','4aa3d0fd-0129-1000-e000-4d45137f0969','领导意见',1,'5063875d-012d-1000-e000-4a52137f0969' )";
		String sql_sugess1 = "INSERT INTO TWFProcInsComments ( fsprocinsid,fscommentid,fscommentname,fiorder,fsprocid )  VALUES  ( '"
				+ uid
				+ "','98182049-0127-1000-e000-01bc137f0969','办理情况',2,'5063875d-012d-1000-e000-4a52137f0969' )";
		String sql_sugess4 = "INSERT INTO TWFProcInsComments ( fsprocinsid,fscommentid,fscommentname,fiorder,fsprocid )  VALUES  ( '"
				+ uid
				+ "','98182049-0127-1000-e000-01ba137f0969','审核意见',3,'5063875d-012d-1000-e000-4a52137f0969' )";
		st.execute(sql_sugess2);
		st.execute(sql_sugess1);
		st.execute(sql_sugess4);

		System.out.println("添加成功");
		System.out.println("成功进行下一步");

		UUID uid2 = UUID.randomUUID();
		doSleep(1000L);
		Date dt2 = new Date();
		String dateString2 = formatter.format(dt2);
		TWFActivityIns twfins1 = new TWFActivityIns();
		twfins1.setFsactinsid(uid2.toString());
		twfins1.setFspassroute("5063875d-012d-1000-e000-4a89137f0969");
		twfins1.setFsactid("5063875d-012d-1000-e000-4a90137f0969");
		twfins1.setFsactname("立案");
		twfins1.setFiorder("1");
		twfins1.setFsprevactid(twfins.getFsactinsid());
		twfins1.setFsinitactivityinsid("0");
		twfins1.setFcactivestate("U");
		twfins1.setFsprocinsid(twf.getFsprocinsid());
		twfins1.setFscaseid(uuid);
		twfins1.setFscateid("63eaf009-0126-1000-e000-14b9137f0969");
		twfins1.setFshints("审核立案");
		twfins1.setFcright("W");
		twfins1.setFscreateuserid("23493356-0120-1000-e000-0d1fc0a80169");
		twfins1.setFsoriginalhandler("23493356-0120-1000-e000-0d1fc0a80169");
		twfins1.setFshandlerid("23493356-0120-1000-e000-0d1fc0a80169");
		twfins1.setFsflowkind("E");
		twfins1.setFdcreatetime(dateString2);
		twfins1.setFcisurgency("N");
		twfins1.setFsmemo("审核立案");
		twfins1.setFsinnersubflow(twf.getFsprocinsid());
		twfins1.setFcevent("A");
		CreateTWFActivityIns(twfins1);

		String sql7 = " UPDATE TWFProcessInstance SET fscurrentuserid = '23493356-0120-1000-e000-0d1fc0a80169' WHERE fsprocinsid = '"
				+ twf.getFsprocinsid() + "'";
		st.execute(sql7);
		System.out.println(sql7);

		String sql8 = " UPDATE TWFActivityIns SET fcactivestate = 'C',fdendtime = '"
				+ dateString2
				+ "'"
				+ "WHERE fsactinsid = '"
				+ twfins.getFsactinsid() + "'";

		st.execute(sql8);
		System.out.println(sql8);

		UUID uid3 = UUID.randomUUID();
		TWFActivityInsHandler twfhandler1 = new TWFActivityInsHandler();
		twfhandler1.setFsid(uid3.toString());
		twfhandler1.setFsprocinsid(twf.getFsprocinsid());
		twfhandler1.setFsactivityinsid(twfins1.getFsactinsid());
		twfhandler1.setFccategory("H");
		twfhandler1.setFsflowkind("T");
		twfhandler1.setFcactivestate("U");
		twfhandler1.setFshandlerid("23493356-0120-1000-e000-0d1fc0a80169");
		twfhandler1.setFsmemo("新建经办人");
		CteateTWFActivityInsHandler(twfhandler1);

		String sql10 = "DELETE FROM TWFActivityInsHandler WHERE  fsactivityinsid='"
				+ twfins.getFsactinsid()
				+ "'"
				+ " AND fshandlerid='23493356-0120-1000-e000-0d1fc0a80169' AND fsprocinsid='"
				+ twf.getFsprocinsid() + "'";
		st.execute(sql10);
		System.out.println(sql10);

		System.out.println("添加成功");
		System.out.println("成功进行下一步");

		UUID uid12 = UUID.randomUUID();
		doSleep(1000L);
		Date dt3 = new Date();
		String dateString3 = formatter.format(dt3);

		TWFActivityIns twfins2 = new TWFActivityIns();
		twfins2.setFsactinsid(uid12.toString());
		twfins2.setFiorder("1");
		twfins2.setFcactivestate("U");
		twfins2.setFsprocinsid(twf.getFsprocinsid());
		twfins2.setFspassroute("5063875d-012d-1000-e000-4a8d137f0969");
		twfins2.setFsactid("5063875d-012d-1000-e000-4a84137f0969");
		twfins2.setFsactname("派发");
		twfins2.setFshints("待派发");
		twfins2.setFsmemo("派发工单");
		twfins2.setFscaseid(uuid);
		twfins2.setFscateid("63eaf009-0126-1000-e000-14b9137f0969");
		twfins2.setFscreateuserid("23493356-0120-1000-e000-0d1fc0a80169");
		twfins2.setFdcreatetime(dateString3);
		twfins2.setFsprevactid(twfins1.getFsactinsid());
		twfins2.setFsinitactivityinsid("0");
		twfins2.setFsflowkind("T");
		twfins2.setFcevent("B,A");
		twfins2.setFcright("W");
		twfins2.setFsinnersubflow(twf.getFsprocinsid());
		twfins2.setFshandlerid("23493356-0120-1000-e000-0e2cc0a80169");
		twfins2.setFsoriginalhandler("23493356-0120-1000-e000-0d1fc0a80169");
		twfins2.setFstag("B");
		CreateTWFActivityIns(twfins2);

		String sql17 = " UPDATE TWFProcessInstance SET fscurrentuserid = '23493356-0120-1000-e000-0e2cc0a80169' WHERE fsprocinsid = '"
				+ uid + "'";
		st.execute(sql17);
		System.out.println(sql17);

		UUID uid13 = UUID.randomUUID();
		TWFActivityInsHandler twfhandler2 = new TWFActivityInsHandler();
		twfhandler2.setFsid(uid13.toString());
		twfhandler2.setFsprocinsid(twf.getFsprocinsid());
		twfhandler2.setFsactivityinsid(twfins2.getFsactinsid());
		twfhandler2.setFccategory("H");
		twfhandler2.setFsflowkind("T");
		twfhandler2.setFcactivestate("U");
		twfhandler2.setFshandlerid("23493356-0120-1000-e000-0e2cc0a80169");
		twfhandler2.setFsmemo("新建经办人");
		CteateTWFActivityInsHandler(twfhandler2);

		String sql18 = " UPDATE TWFActivityIns SET fcactivestate = 'C',fdendtime = '"
				+ dateString3
				+ "'"
				+ "WHERE fsactinsid = '"
				+ twfins1.getFsactinsid() + "'";
		st.execute(sql18);
		System.out.println(sql18);

		String sql101 = "DELETE FROM TWFActivityInsHandler WHERE  fsactivityinsid='"
				+ twfins1.getFsactinsid()
				+ "'"
				+ " AND fshandlerid='23493356-0120-1000-e000-0d1fc0a80169' AND fsprocinsid='"
				+ twf.getFsprocinsid() + "'";
		st.execute(sql101);
		System.out.println(sql101);

		String sql110 = "DELETE FROM TWFActivityInsHandler WHERE  fsactivityinsid='"
				+ twfhandler1.getFsid()
				+ "'"
				+ " AND fshandlerid='23493356-0120-1000-e000-0d1fc0a80169' AND fsprocinsid='"
				+ uid + "'";
		st.execute(sql110);
		System.out.println(sql110);

		String sql1101 = "DELETE FROM TWFActivityInsHandler WHERE  fsactivityinsid='"
				+ twfhandler2.getFsid()
				+ "'"
				+ " AND fshandlerid='23493356-0120-1000-e000-0d1fc0a80169' AND fsprocinsid='"
				+ uid + "'";
		st.execute(sql1101);
		System.out.println(sql1101);

		doSleep(1000L);
		Date dt4 = new Date();
		String dateString4 = formatter.format(dt4);
		UUID uid21 = UUID.randomUUID();
		TWFActivityIns twfins3 = new TWFActivityIns();
		twfins3.setFsactinsid(uid21.toString());
		twfins3.setFiorder("1");
		twfins3.setFcactivestate("U");
		twfins3.setFsprocinsid(twf.getFsprocinsid());
		twfins3.setFspassroute("5063875d-012d-1000-e000-4a8d137f0969");
		twfins3.setFsactid("5063875d-012d-1000-e000-4a84137f0969");
		twfins3.setFsactname("派发");
		twfins3.setFshints("待派发");
		twfins3.setFsmemo("派发工单");
		twfins3.setFscaseid(uuid);
		twfins3.setFscateid("63eaf009-0126-1000-e000-14b9137f0969");
		twfins3.setFscreateuserid("23493356-0120-1000-e000-0d1fc0a80169");
		twfins3.setFdcreatetime(dateString4);
		twfins3.setFsprevactid(twfins1.getFsactinsid());
		twfins3.setFsinitactivityinsid("0");
		twfins3.setFsflowkind("T");
		twfins3.setFcevent("B,A");
		twfins3.setFcright("W");
		twfins3.setFsinnersubflow(twf.getFsprocinsid());
		twfins3.setFshandlerid("f77ba228-012b-1000-e000-9fd4137f0969");
		twfins3.setFsoriginalhandler("23493356-0120-1000-e000-0d1fc0a80169");
		twfins3.setFstag("B");
		CreateTWFActivityIns(twfins3);

		String sql2117 = " UPDATE TWFProcessInstance SET fscurrentuserid = '23493356-0120-1000-e000-0d1fc0a80169' WHERE fsprocinsid = '"
				+ uid + "'";
		st.execute(sql2117);
		System.out.println(sql2117);

		UUID uid2113 = UUID.randomUUID();
		String sql2119 = "INSERT INTO TWFActivityInsHandler ( fsid,fsprocinsid,fsactivityinsid,fccategory,fsflowkind,fcactivestate,fshandlerid,fsmemo )  VALUES  ( '"
				+ uid2113
				+ "','"
				+ twf.getFsprocinsid()
				+ "','"
				+ twfins3.getFsactinsid()
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

		doSleep(1000L);
		Date dt5 = new Date();
		String dateString5 = formatter.format(dt5);
		UUID uid22 = UUID.randomUUID();
		TWFActivityIns twfins4 = new TWFActivityIns();
		twfins4.setFsactinsid(uid22.toString());
		twfins4.setFiorder("1");
		twfins4.setFcactivestate("U");
		twfins4.setFsprocinsid(twf.getFsprocinsid());
		twfins4.setFspassroute("5063875d-012d-1000-e000-4a8d137f0969");
		twfins4.setFsactid("5063875d-012d-1000-e000-4a84137f0969");
		twfins4.setFsactname("派发");
		twfins4.setFshints("待派发");
		twfins4.setFsmemo("派发工单");
		twfins4.setFscaseid(uuid);
		twfins4.setFscateid("63eaf009-0126-1000-e000-14b9137f0969");
		twfins4.setFscreateuserid("23493356-0120-1000-e000-0d1fc0a80169");
		twfins4.setFdcreatetime(dateString5);
		twfins4.setFsprevactid(twfins1.getFsactinsid());
		twfins4.setFsinitactivityinsid("0");
		twfins4.setFsflowkind("T");
		twfins4.setFcevent("B,A");
		twfins4.setFcright("W");
		twfins4.setFsinnersubflow(twf.getFsprocinsid());
		twfins4.setFshandlerid("5ef659df-012a-1000-e000-35eb137f0969");
		twfins4.setFsoriginalhandler("23493356-0120-1000-e000-0d1fc0a80169");
		twfins4.setFstag("B");
		CreateTWFActivityIns(twfins4);

		String sql2218 = " UPDATE TWFActivityIns SET fcactivestate = 'C',fdendtime = '"
				+ dateString + "'" + "WHERE fsactinsid = '" + uid2 + "'";

		st.execute(sql2218);
		System.out.println(sql2218);
		UUID uid2213 = UUID.randomUUID();
		String sql2219 = "INSERT INTO TWFActivityInsHandler ( fsid,fsprocinsid,fsactivityinsid,fccategory,fsflowkind,fcactivestate,fshandlerid,fsmemo )  VALUES  ( '"
				+ uid2213
				+ "','"
				+ twf.getFsprocinsid()
				+ "','"
				+ twfins4.getFsactinsid()
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

		doSleep(1000L);
		UUID uid23 = UUID.randomUUID();
		Date dt6 = new Date();
		String dateString6 = formatter.format(dt6);
		TWFActivityIns twfins5 = new TWFActivityIns();
		twfins5.setFsactinsid(uid23.toString());
		twfins5.setFiorder("1");
		twfins5.setFcactivestate("U");
		twfins5.setFsprocinsid(twf.getFsprocinsid());
		twfins5.setFspassroute("5063875d-012d-1000-e000-4a8d137f0969");
		twfins5.setFsactid("5063875d-012d-1000-e000-4a84137f0969");
		twfins5.setFsactname("派发");
		twfins5.setFshints("待派发");
		twfins5.setFsmemo("派发工单");
		twfins5.setFscaseid(uuid);
		twfins5.setFscateid("63eaf009-0126-1000-e000-14b9137f0969");
		twfins5.setFscreateuserid("23493356-0120-1000-e000-0d1fc0a80169");
		twfins5.setFdcreatetime(dateString6);
		twfins5.setFsprevactid(twfins1.getFsactinsid());
		twfins5.setFsinitactivityinsid("0");
		twfins5.setFsflowkind("T");
		twfins5.setFcevent("B,A");
		twfins5.setFcright("W");
		twfins5.setFsinnersubflow(twf.getFsprocinsid());
		twfins5.setFshandlerid("23493356-0120-1000-e000-0d1fc0a80169");
		twfins5.setFsoriginalhandler("23493356-0120-1000-e000-0d1fc0a80169");
		twfins5.setFstag("B");
		CreateTWFActivityIns(twfins5);

		String sql2318 = " UPDATE TWFActivityIns SET fcactivestate = 'C',fdendtime = '"
				+ dateString + "'" + "WHERE fsactinsid = '" + uid2 + "'";

		st.execute(sql2318);
		System.out.println(sql2318);
		UUID uid2313 = UUID.randomUUID();
		String sql2319 = "INSERT INTO TWFActivityInsHandler ( fsid,fsprocinsid,fsactivityinsid,fccategory,fsflowkind,fcactivestate,fshandlerid,fsmemo )  VALUES  ( '"
				+ uid2313
				+ "','"
				+ twf.getFsprocinsid()
				+ "','"
				+ twfins5.getFsactinsid()
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

		String comments = "UPDATE TWFActivityIns SET fscomments = ' ',fssecretcomments = '',fdcommenttime = '"
				+ dateString
				+ "',fscommenttypeid = '4aa3d0fd-0129-1000-e000-4d45137f0969' WHERE fsactinsid = '"
				+ uid12 + "'";
		String comments1 = "UPDATE TWFActivityIns SET fscomments = ' ',fssecretcomments = '',fdcommenttime = '"
				+ dateString1
				+ "',fscommenttypeid = '4aa3d0fd-0129-1000-e000-4d45137f0969' WHERE fsactinsid = '"
				+ uid21 + "'";
		String comments2 = "UPDATE TWFActivityIns SET fscomments = ' ',fssecretcomments = '',fdcommenttime = '"
				+ dateString2
				+ "',fscommenttypeid = '4aa3d0fd-0129-1000-e000-4d45137f0969' WHERE fsactinsid = '"
				+ uid22 + "'";
		String comments3 = "UPDATE TWFActivityIns SET fscomments = ' ',fssecretcomments = '',fdcommenttime = '"
				+ dateString3
				+ "',fscommenttypeid = '4aa3d0fd-0129-1000-e000-4d45137f0969' WHERE fsactinsid = '"
				+ uid23 + "'";

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
		if ((strFrom == null) || (strFrom.equals("")))
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
			t = t + st.nextElement();
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

		Parser parser = Parser.createParser(new String(inputHtml.getBytes(),
				"GBK"), "GBK");

		NodeList nodes = parser.extractAllNodesThatMatch(new NodeFilter() {
			private static final long serialVersionUID = 1L;

			public boolean accept(Node node) {
				return true;
			}
		});
		System.out.println(nodes.size());
		for (int i = 0; i < nodes.size(); i++) {
			Node nodet = nodes.elementAt(i);

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
		content.trim();
		content = content.replaceAll("<p .*?>", "\n");

		content = content.replaceAll("<br\\s*/?>", "\n");

		content = content.replaceAll("\\<.*?>", "");
		content = content.replaceAll("\\{.*?}", "");
		content = content.replaceAll("'", "’");

		content.trim();

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

	public static int MaxId_szcg1() throws SQLException {
		DaoManager dm = new DaoManager();
		int id = 0;
		dm.initConnection();
		String sql = "select max(id) from ASFormszcg1";
		System.out.println(sql);
		Statement st = dm.conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			id = rs.getInt(1);
		}
		dm.closeConnection();
		return id;
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
			if (id == null)
				id = "0";
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
	
	/**
	 * 市数字城管数据
	 */
	public static void startRunsszcg() {
		TimerTask registerTask = new SwingTimerTask() {
			public void doRun() {
				try {
					SwingWorker sw = new SwingWorker() {
						public Object construct() {
							try {
								catch12345ForAll.getSzcgFromCity();
							} catch (SQLException e) {
								e.printStackTrace();
							} catch (Exception e) {
								e.printStackTrace();
							}

							return null;
						}
					};
					sw.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		TaskEngine.getInstance().schedule(registerTask, 1000L, 300000L);
	}
	/**
	 * 市12345
	 */
	public static void startRuns12345() {
		    s12345Task = new SwingTimerTask() {
			public void doRun() {
				try {
					SwingWorker sw = new SwingWorker() {
						public Object construct() {
						   catch12345ForAll.getContentID();
							return null;
						}
					};
					sw.start();
				} catch (Exception e) {
					e.printStackTrace();
					processException();
				}
			}
		};
		TaskEngine.getInstance().schedule(s12345Task, 1000L, 300000L);
	}
	/**
	 * 市12345静态表单
	 */
	public static void startRunsyn12345() {
		TimerTask registerTask = new SwingTimerTask() {
			public void doRun() {
				try {
					SwingWorker sw = new SwingWorker() {
						public Object construct() {
							try {
								catch12345.getHtmlUpCity12345();
								catch12345.DoneTaskHandler();
							} catch (IOException e) {
								e.printStackTrace();
							} catch (SQLException e) {
								e.printStackTrace();
							}

							return null;
						}
					};
					sw.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		TaskEngine.getInstance().schedule(registerTask, 1000L, 300000L);
	}
	/**
	 * 市数字城管回传
	 */
	public static void startRunHandlersszcg() {
		TimerTask registerTask = new SwingTimerTask() {
			public void doRun() {
				try {
					SwingWorker sw = new SwingWorker() {
						public Object construct() {
							try {
								catch12345ForAll.HandlerSSZCGEvent();
							} catch (SQLException e) {
								e.printStackTrace();
							}

							return null;
						}
					};
					sw.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		TaskEngine.getInstance().schedule(registerTask, 1000L, 300000L);
	}

	/**
	 * 信息回传
	 */
	public static void startRunRollback() {
		TimerTask registerTask = new SwingTimerTask() {
			public void doRun() {
				try {
					SwingWorker sw = new SwingWorker() {
						public Object construct() {
							catch12345ForAll.HandlerSszcgRollBack();
							return null;
						}
					};
					sw.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		TaskEngine.getInstance().schedule(registerTask, 1000L, 300000L);
	}

	/**
	 * 从市城管局获取工单
	 */
	public static void getSzcgFromCity() throws RemoteException,
			NumberFormatException, SQLException, ParseException {
		wp.setLoginName("pjqcgj");
		wp.setLoginPass("12345678");
		wp.setDepartId("f47d5d71-535d-4050-a268-fce4efe538f5");
		SZCGEventTask st = dms.getTasks(wp);
		SZCGEvent[] sevent = st.getEvents();
		myBeanAll mybean = null;
		int hasfile = 0;
		for (SZCGEvent e : sevent) {
			logger.warn("id:" + e.getEventId());
			logger.warn("desc:" + e.getDesc());
			logger.warn("time:" + e.getTaskDate());
			logger.warn("opinin:" + e.getTaskOpinion());
			logger.warn("streetname" + e.getStreetName());
			System.out.println(e.getAbsX());
			System.out.println(e.getAbsY());
			System.out.println(e.getActivityInstanceId());
			System.out.println(e.getAddress());
			System.out.println(e.getCommunityName());
			System.out.println(e.getDistrictName());
			System.out.println(e.getStreetName());
			System.out.println(e.getReporter());
			System.out.println(e.getReplyWay());
			System.out.println(e.getTitle());

			mybean = new myBeanAll();
			mybean.setLbEventID(e.getEventId());
			mybean.setLbName(e.getReporter());
			mybean.setLbDate(e.getTaskDate());
			mybean.setLbCommingPhone("");
			mybean.setLbPhone1(e.getReplyWay());
			mybean.setLbPhone2("");
			mybean.setLbPhone3("");
			mybean.setLbAgentID("");
			mybean.setLbTitle(e.getTitle());
			mybean.setLbContent("标题：" + e.getTitle() + " 来源：" + e.getSrcName()
					+ " 内容：" + e.getDesc()+" 操作员："+e.getObName()+" 操作员电话: "+e.getObPhone()+"   ");
			mybean.setEventtype(e.getTypeName());
			mybean.setBigType(e.getBigClassName());
			mybean.setSmallType(e.getSmallClassName());
			mybean.setPosx(e.getAbsX());
			mybean.setPosy(e.getAbsY());
			mybean.setAddressdesc("  " + e.getDistrictName() + " "
					+ e.getAddress());
			mybean.setActivityInstanceId(e.getActivityInstanceId());
			SZCGEventFile[] sfile = e.getFiles();
			if ((sfile != null) && (sfile.length > 0)) {
				hasfile = sfile.length;
			}
			insertForm(mybean, "市数字城管", String.valueOf(MaxId_szcg1() + 1),
					hasfile, sfile);
		}
	}

	public static void insertFileinfoToTable(String fileuid, String filepath,
			String filetype, long length, String fileName, String formid) {
		Date dt = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dt);

		dm.initConnection();
		String sql = "insert into TAttachmentDetail ( fsid,fskey,fsphysical,fspostfix,fsuploadtime,fivcount,fifilesize,fsstatus,fsfilename,fsuser )  VALUES (?,?,?,?,?,?,?,?,?,?)";

		String sql2 = "INSERT INTO TAttachmentRefer ( fsattachmentid,fscaseid )  VALUES (?,?)";
		
		String dsql = "delete from TAttachmentRefer where fscaseid='"+formid+"'";
		
		String dsql2 = "delete from TAttachmentDetail where fsid=";
		
		String sSql = "select fsattachmentid from TAttachmentRefer where fscaseid='"+formid+"'";
		
		try {
			PreparedStatement st = dm.conn.prepareStatement(sql);
			st.setString(1, fileuid);
			st.setString(2, "form.attachments");
			st.setString(3, filepath);
			st.setString(4, filetype);
			st.setString(5, dateString);
			st.setInt(6, 0);
			st.setLong(7, length);
			st.setString(8, "0");
			st.setString(9, fileName);
			st.setString(10, "23493356-0120-1000-e000-0d1fc0a80169");
			st.execute();
			st.close();
			st = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		try {
			Statement sst = dm.conn.createStatement();
			
			ResultSet rs = sst.executeQuery(sSql);
			while(rs.next()){
				String tmpsql= dsql2+" '"+rs.getString("fsattachmentid")+"'";
				Statement dst = dm.conn.createStatement();
				dst.execute(tmpsql);
				dst.close();
			}
			sst.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PreparedStatement st1 = dm.conn.prepareStatement(sql2);
			st1.setString(1, fileuid);
			st1.setString(2, formid);
			st1.execute();
			st1.close();
			st1 = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dm.closeConnection();
	}

	public static String getFileType(String fileName) {
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1,
				fileName.length());
		return fileType;
	}

	public static void inserFile(SZCGEventFile[] file, String casid) {
		if (file == null) {
			return;
		}
		Calendar cal = Calendar.getInstance();

		int year = cal.get(1);

		int month = cal.get(2) + 1;

		int day_of_month = cal.get(5);

		File f = new File("D://exioa//bin//upload//forms//" + year + "//"
				+ month + "//" + day_of_month + "//");
		if (!f.exists()) {
			f.mkdirs();
		}

		SZCGEventFile[] arrayOfSZCGEventFile = file;
		int j = file.length;
		for (int i = 0; i < j; i++) {
			SZCGEventFile szf = arrayOfSZCGEventFile[i];
			System.out.println(szf.getName());
			System.out.println(szf.getDownLoadUrl());
			System.out.println(szf.getType());
			String fileName = szf.getName().substring(
					szf.getName().lastIndexOf("\\") + 1);
			String fileType = getFileType(fileName);
			String fileUid = UUID.randomUUID().toString();

			downloadFilefromUrl(szf.getDownLoadUrl().toString(),
					f.getAbsolutePath() + "\\", fileUid + "." + fileType);
			String filePath = year + "//" + month + "//" + day_of_month + "//"
					+ fileUid + "." + fileType;
			File newfile = new File(f.getAbsolutePath() + fileUid + "."
					+ fileType);
			insertFileinfoToTable(fileUid, filePath, "." + fileType,
					newfile.length(), fileName, casid);
		}
	}

	/**
	 * 从链接下载文件
	 * @param httpUrl
	 * @param filePath
	 * @param fileName
	 */
	public static void downloadFilefromUrl(String httpUrl, String filePath,
			String fileName) {
		try {
			URL url = new URL(httpUrl);

			BufferedInputStream in = new BufferedInputStream(url.openStream());

			FileOutputStream file = new FileOutputStream(new File(filePath
					+ fileName));
			int t;
			while ((t = in.read()) != -1) {
				file.write(t);
			}

			file.close();

			in.close();

			System.out.println("图片获取成功");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			doSleep(1000L);
		}
	}

	public static ArrayList<DoneTaskBean> getDoneTasks() {
		dm.initConnection();
		Connection connection = dm.conn;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DoneTaskBean td = null;
		ArrayList al = new ArrayList();
		String sql = "SELECT DISTINCT  CaseID as id FROM TCDoneTask WHERE ProInsActiveState='C'";
		try {
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				td = new DoneTaskBean();
				td.setId(rs.getString("id"));
				al.add(td);
				System.out.println(td.getId());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			rs = null;
			stmt = null;
			connection = null;
			dm.closeConnection();
		}

		return al;
	}

	public static void insertT_SSZCG_REPLYID(String id) {
		Date dt = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dt);

		dm.initConnection();

		String sql2 = "insert into T_SSZCG_REPLYID (ID,REPLY_TIME) values ('"
				+ id + "','" + dateString + "')";
		try {
			System.out.println(sql2);
			PreparedStatement st = dm.conn.prepareStatement(sql2);
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean isexistInT_SSZCG_REPLYID(String guid)
			throws SQLException {
		DaoManager dm = new DaoManager();
		boolean type = false;
		dm.initConnection();
		String sql = "select count(*) from T_SSZCG_REPLYID where id='" + guid
				+ "'";
		System.out.println(sql);
		Statement st = dm.conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			String is = rs.getString(1);
			if ("0".equals(is)) {
				type = false;
			} else {
				type = true;
			}
		}

		dm.closeConnection();
		return type;
	}

	public static boolean isexistInT_SSZCG_ROLLBACK(String guid)
			throws SQLException {
		DaoManager dm = new DaoManager();
		boolean type = false;
		dm.initConnection();
		String sql = "select count(*) from T_SSZCG_ROLLBACK where id='" + guid
				+ "'";
		System.out.println(sql);
		Statement st = dm.conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			String is = rs.getString(1);
			if ("0".equals(is)) {
				type = false;
			} else {
				type = true;
			}
		}

		dm.closeConnection();
		return type;
	}

	public static DoneTaskBean getDoneTask(String caseId) {
		ArrayList al = new ArrayList();
		dm.initConnection();
		Connection connection = dm.conn;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String cateId = null;
		DoneTaskBean td = null;
		Map mp = null;
		try {
			stmt = connection
					.prepareStatement("SELECT DISTINCT TOP 1 CateID FROM TCDoneTask WHERE CaseID='"
							+ caseId + "'");
			rs = stmt.executeQuery();
			System.out
					.println("SELECT DISTINCT TOP 1 CateID FROM TCDoneTask WHERE CaseID='"
							+ caseId + "'");
			if (rs.next()) {
				cateId = rs.getString("CateID");
				System.out.println(cateId);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			rs = null;
			stmt = null;
		}
		StringBuffer content = new StringBuffer();
		String sql = "SELECT DISTINCT A.FSACTINSID AS FSACTINSID,A.FSCommentTypeID AS FSCommentTypeID,A.FSReplaceSigner AS FSReplaceSigner,T.FSCommentsAliasName AS FSCommentsAliasName,A.FSComments AS FSComments,A.FSSecretComments AS FSSecretComments,A.FDCommentTime AS FDCommentTime,A.FDCREATETIME As FDCREATETIME,A.FSHandlerID AS FSHandlerID, A.FSFlowKind AS FSFlowKind FROM TWFActivityInsBak A,TWFCommentsTypeAlias T WHERE A.FSCommentTypeID<>'' AND A.FSCateID='"
				+ cateId
				+ "' AND A.FSCaseID='"
				+ caseId
				+ "' AND A.FCActiveState<>'T' AND A.FSCommentTypeID=T.FSCommentsAliasID ORDER BY A.FDCommentTime,A.FDCREATETIME";
		try {
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			td = new DoneTaskBean();
			while (rs.next()) {
				mp = new HashMap();
				mp.put(rs.getString("FSCommentsAliasName"),
						rs.getString("FSComments"));
				content.append(rs.getString("FSCommentsAliasName")).append(":")
						.append(rs.getString("FSComments")).append("\n");
			}

			td.setId(caseId);

			td.setComment(mp);

			td.setContent(content.toString());
			al.add(td);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			rs = null;
			stmt = null;
			connection = null;
			dm.closeConnection();
		}
		return td;
	}

	public static String getAcidfromForm(String id) {
		dm.initConnection();
		Connection connection = dm.conn;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String cateId = null;
		try {
			stmt = connection
					.prepareStatement("SELECT DISTINCT TOP 1 activityInstanceId FROM ASFormszcg1 WHERE fId='"
							+ id.trim() + "'");
			rs = stmt.executeQuery();

			if (rs.next()) {
				cateId = rs.getString("activityInstanceId");
				System.out.println(cateId);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			rs = null;
			stmt = null;
			connection = null;
			dm.closeConnection();
		}

		return cateId;
	}

	public static void HandlerSSZCGEvent() throws SQLException {
		wp.setLoginName("pjqcgj");
		wp.setLoginPass("12345678");
		wp.setDepartId("f47d5d71-535d-4050-a268-fce4efe538f5");

		String caseid = null;
		for (DoneTaskBean al : getDoneTasks()) {
			if (al == null) {
				return;
			}

			DoneTaskBean dt = getDoneTask(al.getId());
			caseid = getAcidfromForm(dt.getId());
			System.out.println(caseid);
			if ((isexistInT_SSZCG_REPLYID(dt.getId())) || (caseid == null)||caseid=="null") {
				System.out.println("已经执行过回传");
			} else {
				WSProcessSZCGEventParameter wsp = new WSProcessSZCGEventParameter();
				wsp.setLoginName("pjqcgj");
				wsp.setLoginPass("12345678");
				wsp.setDepartId("f47d5d71-535d-4050-a268-fce4efe538f5");
				wsp.setContent(dt.getContent());

				wsp.setCurActInstId(getAcidfromForm(dt.getId()));

				System.out.println(dt.getContent());
				try {
					WSProcessSZCGEventResult ws = dms.processSZCGEvent(wsp);
					System.out.println(ws.isSuccess());
					System.out.println(ws.getErrorMsg());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				insertT_SSZCG_REPLYID(dt.getId());
			}
		}
	}

	public static void updateRollBackSZCG(String id) {
		DaoManager dm = new DaoManager();
		dm.initConnection();
		String sql = "update T_SSZCG_ROLLBACK set state='已回退' where (id='" + id
				+ "')";
		System.out.println(sql);
		try {
			Statement st = dm.conn.createStatement();
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dm.closeConnection();
	}
	/**
	 * 回退处理
	 */
	public static void HandlerSszcgRollBack() {
		dm.initConnection();
		Connection connection = dm.conn;
		String acid;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String cateId = null;
		wp.setLoginName("pjqcgj");
		wp.setLoginPass("12345678");
		wp.setDepartId("f47d5d71-535d-4050-a268-fce4efe538f5");
		try {
			stmt = connection
					.prepareStatement("SELECT *  FROM T_SSZCG_ROLLBACK WHERE STATE='未回退'");
			rs = stmt.executeQuery();
			WSRollbackSZCGEventParameter wsp = new WSRollbackSZCGEventParameter();
			wsp.setLoginName("pjqcgj");
			wsp.setLoginPass("12345678");
			wsp.setDepartId("f47d5d71-535d-4050-a268-fce4efe538f5");
			System.out.println("回退案件处理中");
			while (rs.next()) {
				cateId = rs.getString("ID");
				wsp.setContent(rs.getString("REPLYCONTENT"));
				wsp.setCurActInstId(rs.getString("activityInstanceId"));
			    acid=rs.getString("activityInstanceId");
			    System.out.println(acid);
				if(acid!=null&&acid!=""&&acid.length()==36){
					System.out.println(dms.rollBackSZCGEvent(wsp).getErrorMsg());
					updateRollBackSZCG(cateId);
					System.out.println("已经回退案件：" + cateId);
				}
				else{
					System.out.println("案件暂未退回：" + cateId);
				}
				
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			rs = null;
			stmt = null;
			connection = null;
			dm.closeConnection();
		}
	}

	public static void main(String[] a) throws RemoteException {
		
	    catch12345ForAll  c1 = new catch12345ForAll();
	    c1.initui();
		try {
			
			
			
			//插入单条工单
			//insert12345("602647");
			//insert12345("602652");
			//insert12345("602716");
			
			
			
			
			//insert12345("636139");
			//insert12345("636276");
			//insert12345("636295");
			//insert12345("636310");
			//insert12345("636341");
			insert12345("700912");
			
			
			
			//重建工作流
			//newWf("D966577F-0D30-4501-9DC8-1A79F3375751","标题：江城管2011字第583号");
			//newWf("2F9B1067-F5C6-44B9-872D-4FFC413FB33E","标题：江城管2011字第582号");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertK123456(Bean12345 b12345, String guid) {
		Date dt = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dt);
		DaoManager dm = new DaoManager();
		dm.initConnection();

		String sql2 = "INSERT INTO [chinaweal].[dbo].[ASFormk123456]([fId],[fUser],[fDept],[fPos] ,[fOrg],[fTime],[f17],[f18],[f107],[f108],[f109],[f110],[f112],[f123],[f114],[f115],[f120])VALUES('"
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
				+ b12345.getTaskType()
				+ "',0,'"
				+ guid + "')";
		try {
			PreparedStatement st = dm.conn.prepareStatement(sql2);
			st.execute(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Bean12345 copyMyBeanToBean12345(myBeanAll mybean) {
		Bean12345 bean12345 = new Bean12345();
		bean12345.setCaseId(mybean.getLbEventID());
		bean12345.setGovArea(mybean.getAddressdesc());
		bean12345.setClDept("蓬江区城管局");
		bean12345.setClResult("处理中");
		bean12345.setTaskTime(mybean.getLbDate());
		bean12345.setTaskContent(mybean.getLbContent());
		return bean12345;
	}

	
	public static void runall(){
		SwingWorker sw = new SwingWorker() {
			public Object construct() {
				catch12345ForAll.startRunsszcg();
				catch12345ForAll.startRuns12345();
				catch12345ForAll.startRunsyn12345();
				catch12345ForAll.startRunHandlersszcg();
				catch12345ForAll.startRunRollback();
				return null;
			}
		};
		sw.start();
		
	}
	
	

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initui() {
		JFrame f = new JFrame();
		f.setLocation(100, 100);
		f.setDefaultCloseOperation(3);
		JButton jb = new JButton("执行市12345同步任务");
		jb.setBounds(45, 10, 147, 23);
		f.setTitle("同步程序---批量发送流程");
		f.getContentPane().setLayout(null);
		f.getContentPane().add(jb);

		JButton sszcg = new JButton("执行市数字城管同步");
		sszcg.setBounds(45, 43, 147, 23);
		sszcg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sszcg.setAction(new SwingAction());
		f.getContentPane().add(sszcg);

		JButton s12345jt = new JButton("市12345静态表单");
		s12345jt.setBounds(202, 10, 155, 23);
		s12345jt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		s12345jt.setAction(this.action);
		f.getContentPane().add(s12345jt);

		JButton runall = new JButton("全部执行");
		runall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		runall.setBounds(141, 101, 155, 23);
		runall.setAction(this.action_1);
		f.getContentPane().add(runall);

		JTextPane textPane = new JTextPane();
		textPane.setText("1. 执行市12345同步任务是只执行从市12345的工单\r\n2. 市12345静态表单是城管要求将工单复制一份放入12345\r\n3. 市数字城管同步，要求从市数字城管同步数据，这里会有文件下载，坐标标注，工单同步等。\r\n4.全部执行，就是将上面所有的任务进行运行。\r\n5.市数字城管数据回传，把区数字城管的办理意见回复到市数字城管。\r\n5.执行全部执行按钮");
		textPane.setEditable(false);
		textPane.setBounds(10, 134, 377, 282);
		f.getContentPane().add(textPane);

		JButton btnNewButton = new JButton("市数字城管回传");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setAction(this.action_2);
		btnNewButton.setBounds(202, 43, 155, 23);
		f.getContentPane().add(btnNewButton);

		JButton rollback = new JButton("回退处理");
		rollback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rollback.setAction(this.action_3);
		rollback.setBounds(45, 76, 147, 23);
		f.getContentPane().add(rollback);
		f.setSize(413, 464);
		f.setVisible(true);
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingWorker sw = new SwingWorker() {
					public Object construct() {
						catch12345ForAll.startRuns12345();
						return null;
					}
				};
				sw.start();
			}
		});
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue("Name", "执行市数字城管同步");
			putValue("ShortDescription", "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			SwingWorker sw = new SwingWorker() {
				public Object construct() {
					catch12345ForAll.startRunsszcg();
					return null;
				}
			};
			sw.start();
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue("Name", "市12345静态表单");
			putValue("ShortDescription", "市12345静态表单");
		}

		public void actionPerformed(ActionEvent e) {
			SwingWorker sw = new SwingWorker() {
				public Object construct() {
					catch12345ForAll.startRunsyn12345();
					return null;
				}
			};
			sw.start();
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue("Name", "全部执行");
			putValue("ShortDescription", "runall");
		}

		public void actionPerformed(ActionEvent e) {
			runall();
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue("Name", "市数字城管数据回传");
			putValue("ShortDescription", "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			SwingWorker sw = new SwingWorker() {
				public Object construct() {
					catch12345ForAll.startRunHandlersszcg();
					return null;
				}
			};
			sw.start();
		}
	}

	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue("Name", "回退处理");
			putValue("ShortDescription", "处理回退事件");
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("回退处理开始执行");
			catch12345ForAll.startRunRollback();
		}
	}
}