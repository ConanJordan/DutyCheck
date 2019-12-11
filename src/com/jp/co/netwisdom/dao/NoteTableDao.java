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
import com.jp.co.netwisdom.util.CalendarUtil;

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
			
			StringBuilder sqlBuilder = new StringBuilder(Const.SQL_SELECT_NOTE_TABLE);
			
			// 编辑sql语句
			sqlBuilder.append(" WHERE CARDNO = " + cardNo);  // CardNo
			sqlBuilder.append(" AND CDT >= DATE('" + CalendarUtil.getFirstDay(year, month) + "')");  // 该月第一天
			sqlBuilder.append(" AND CDT <= DATE('" + CalendarUtil.getLastDay(year, month) + "')");  // 该月最后一天
			
			prst = conn.prepareStatement(sqlBuilder.toString());
			
			rs = prst.executeQuery();
			
			while (rs.next()) {
				NoteTableEntity note = new NoteTableEntity();
				note.setCardNo(rs.getLong(1));
				note.setCti(rs.getString(2));
				note.setCdt(
						new java.sql.Date(
						CalendarUtil.strToDate(rs.getString(3), Const.YYYYMMDD_FORMAT).getTime()		
						));
				
				//note.setCdt(rs.getDate(3));
				
				resultList.add(note);
			}
		} catch (NumberFormatException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} finally {
			DataBaseFactory.close(conn, prst, rs);
		}
		
		return resultList;
	}

	@Override
	public List<EmployeeEntity> queryAllEmployee() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
