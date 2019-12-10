package com.jp.co.netwisdom.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jp.co.netwisdom.config.Const;

public class DataBaseFactory {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		conn = CreateConnection();
		
		try {
			//prst = conn.prepareStatement(Const.SQL_SELECT_ALL_EMPLYEES);
			prst = conn.prepareStatement(Const.SQL_SELECT_ALL_EMPLYEES);
			rs = prst.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString(1) + " ");
				System.out.print(rs.getString(2) + " ");
				System.out.print(rs.getString(3) + " ");
				System.out.print(rs.getString(4) + " ");
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			DataBaseFactory.close(conn, prst, rs);
		}
	}
	
	/**
	 * 获取数据库的链接
	 * @return
	 */
	public static Connection CreateConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(Const.JDBC_DRIVER);
			conn = DriverManager.getConnection(Const.URL);
			//System.out.println("Opened database successfully");
			//System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close (Connection conn, PreparedStatement prst, ResultSet rs) {
		
		try {
			if (conn != null) {
				conn.close();
			}
			if (prst != null) {
				prst.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
