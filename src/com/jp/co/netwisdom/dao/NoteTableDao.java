package com.jp.co.netwisdom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jp.co.netwisdom.config.Const;
import com.jp.co.netwisdom.db.DataBaseFactory;
import com.jp.co.netwisdom.entity.EmployeeEntity;
import com.jp.co.netwisdom.entity.NoteTableEntity;
import com.jp.co.netwisdom.interfaces.QueryIF;

public class NoteTableDao implements QueryIF {

	@Override
	public List<NoteTableEntity> queryNoteTable(String cardNo, int year,
			int month) throws SQLException {
		
		List<NoteTableEntity> resultList = new ArrayList<NoteTableEntity>();
		
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		conn = DataBaseFactory.CreateConnection();
		
		try {
			prst = conn.prepareStatement(Const.SQL_SELECT_NOTE_TABLE);
			prst.setLong(1, Long.parseLong(cardNo));  // ï¿½ï¿½ï¿½Ã¿ï¿½ï¿½ï¿½
			
			// ï¿½ï¿½ï¿½Ã²ï¿½Ñ¯ï¿½Â·ï¿½
			Calendar calendar = Calendar.getInstance();
			
			calendar.set(Calendar.YEAR, year);  // ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
			
			calendar.set(Calendar.MONTH, month + 1);  //ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
			calendar.set(Calendar.DAY_OF_MONTH, 1);  // ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½		
			java.util.Date startDate = calendar.getTime();
			java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());  // ï¿½ï¿½ï¿½Ã²ï¿½Ñ¯ï¿½ÂµÄ¿ï¿½Ê¼ï¿½ï¿½
			
			calendar.set(Calendar.MONTH, month + 2);  //ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
			calendar.set(Calendar.DAY_OF_MONTH, 0);  // ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½		
			java.util.Date endDate = calendar.getTime();
			java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());  // ï¿½ï¿½ï¿½Ã²ï¿½Ñ¯ï¿½ÂµÄ½ï¿½ï¿½ï¿½ï¿½ï¿½
			
			prst.setDate(2, sqlStartDate);
			prst.setDate(3, sqlEndDate);
			
			rs = prst.executeQuery();
			
			while (rs.next()) {
				NoteTableEntity note = new NoteTableEntity();
				note.setCardNo(rs.getLong(1));  // ¿¨ºÅ
				note.setCti(rs.getString(2));  // ´ò¿¨Ê±¼ä
				note.setCdt(rs.getDate(3));  // ´ò¿¨ÈÕÆÚ
				
				resultList.add(note);
			}
		} catch (NumberFormatException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} finally {
			DataBaseFactory.close(conn, prst, rs);
		}
		
		return null;
	}

	@Override
	public List<EmployeeEntity> queryAllEmployee() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
