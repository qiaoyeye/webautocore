package com.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** 
* ����������sql��
* @ClassName: OptionSQL 
* @Description: TODO(������һ�仰��������������) 
* @author qiaojiafei 
* @date 2016��2��29�� ����11:59:41 
*  
*/
public class OptionSQL {

	public static String connectSql(String sql,String userNum, String col) {
		String url = "jdbc:mysql://172.16.30.209:3306/a_test";
		String name = "gmsd";
		Connection con = null;
		ResultSet rs = null;
		String rssql = null;
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url,name,"dlnu1234");
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userNum);

			rs = pst.executeQuery();
			while(rs.next()) {
				rssql = rs.getString(col);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		 return rssql;
		 
	}
	
	public static List<String> connectSqlList(String sql,String userNum, String col) {
		String url = "jdbc:mysql://172.16.30.209:3306/a_test";
		String name = "gmsd";
		Connection con = null;
		ResultSet rs = null;
		String rssql = null;
		
		List<String> list = new ArrayList<String>();
		
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url,name,"dlnu1234");
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userNum);

			rs = pst.executeQuery();
			while(rs.next()) {
				rssql = rs.getString(col);
				list.add(rssql);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		 return list;
		 
	}
}
