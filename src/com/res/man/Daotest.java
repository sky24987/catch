package com.res.man;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Daotest {
	private String sql;
	public Connection conn = null;
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	public void initConnection(){//��ʼ����ݿ�����
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost/chinaweal","sa","123456");
			
		}
		catch(Exception ex){ex.printStackTrace();}
	}
	
	public void closeConnection(){
		try{
			if(conn!=null){
				conn.close();
				conn = null;
			}
		}catch(Exception ex){ex.printStackTrace();}
	}
	public static void main(String a[]) throws SQLException{
		Daotest  dm  = new Daotest();
		dm.initConnection();
		Statement st=dm.conn.createStatement();
		ResultSet rs=st.executeQuery("select * from tb_SMS");
		while(rs.next()){
			System.out.println(rs.getString(4));
		}
		dm.closeConnection();
		
	}
		
}
