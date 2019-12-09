package com.jp.co.netwisdom.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseFactory {
	
	/**
	 * 获取数据库的链接
	 * @return
	 */
	public static Connection CreateConnection() {
		// TODO
		return null;
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
