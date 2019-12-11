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
			prst.setLong(1, Long.parseLong(cardNo));  // ���ÿ���
			
			// ���ò�ѯ�·�
			Calendar calendar = Calendar.getInstance();
			
			calendar.set(Calendar.YEAR, year);  // ������
			
			calendar.set(Calendar.MONTH, month + 1);  //������
			calendar.set(Calendar.DAY_OF_MONTH, 1);  // ������		
			java.util.Date startDate = calendar.getTime();
			java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());  // ���ò�ѯ�µĿ�ʼ��
			
			calendar.set(Calendar.MONTH, month + 2);  //������
			calendar.set(Calendar.DAY_OF_MONTH, 0);  // ������		
			java.util.Date endDate = calendar.getTime();
			java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());  // ���ò�ѯ�µĽ�����
			
			prst.setDate(2, sqlStartDate);
			prst.setDate(3, sqlEndDate);
			
			rs = prst.executeQuery();
			
			while (rs.next()) {
				NoteTableEntity note = new NoteTableEntity();
				note.setCardNo(rs.getLong(1));  // ����
				note.setCti(rs.getString(2));  // ��ʱ��
				note.setCdt(rs.getDate(3));  // ������
				
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
