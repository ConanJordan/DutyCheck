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
		// TODO Auto-generated method stub
		
		List<NoteTableEntity> resultList = new ArrayList<NoteTableEntity>();
		
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		conn = DataBaseFactory.CreateConnection();
		
		prst = conn.prepareStatement(Const.SQL_SELECT_NOTE_TABLE);
		prst.setLong(1, Long.parseLong(cardNo));  // 设置卡号
		
		// 设置查询月份
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.YEAR, year);  // 设置年
		
		calendar.set(Calendar.MONTH, month + 1);  //设置月
		calendar.set(Calendar.DAY_OF_MONTH, 1);  // 设置日		
		java.util.Date startDate = calendar.getTime();
		java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());  // 设置查询月的开始日
		
		calendar.set(Calendar.MONTH, month + 2);  //设置月
		calendar.set(Calendar.DAY_OF_MONTH, 0);  // 设置日		
		java.util.Date endDate = calendar.getTime();
		java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());  // 设置查询月的结束日
		
		prst.setDate(2, sqlStartDate);
		prst.setDate(3, sqlEndDate);
		
		rs = prst.executeQuery();
		
		while (rs.next()) {
			NoteTableEntity note = new NoteTableEntity();
			note.setCardNo(rs.getLong(1));
			note.setCti(rs.getString(2));
			note.setIdt(rs.getDate(3));
			
			resultList.add(note);
		}
		
		return null;
	}

	@Override
	public List<EmployeeEntity> queryAllEmployee() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
