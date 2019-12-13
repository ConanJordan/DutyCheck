package com.jp.co.netwisdom.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jp.co.netwisdom.config.Const;
import com.jp.co.netwisdom.db.DataBaseFactory;
import com.jp.co.netwisdom.dto.DutyNoteDto;
import com.jp.co.netwisdom.interfaces.QueryIF;
import com.jp.co.netwisdom.util.CalendarUtil;

public class DutyNoteDao implements QueryIF {

	@Override
	public List<DutyNoteDto> queryDutyNote(int year, int month) throws SQLException {
		
		// ��ʼ��Ҫ���صļ���
		List<DutyNoteDto> resultList = new ArrayList<DutyNoteDto>();
		
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		conn = DataBaseFactory.CreateConnection();
		try {
			prst = conn.prepareStatement(Const.SQL_QUERY_DUTY_NOTE_INFO);
			prst.setString(1, CalendarUtil.getFirstDay(year, month));  // ����Ŀ���µ�һ��
			prst.setString(2, CalendarUtil.getLastDay(year, month));  // ����Ŀ�������һ��
			
			rs = prst.executeQuery();  // ִ�м���
			
			while (rs.next()) {
				DutyNoteDto dutyNote = new DutyNoteDto();
				dutyNote.setCardNo(rs.getString("CARDNO"));  // ����
				dutyNote.setName(rs.getString("NAME")); // ����
				dutyNote.setDept(rs.getString("DEPT")); // ����
				dutyNote.setCdt(
						new java.sql.Date(
								CalendarUtil.strToDate(rs.getString("CDT"), Const.YYYYMMDD_FORMAT).getTime())
						); // ������
				dutyNote.setCti(rs.getString("CTI"));// ��ʱ��
				
				resultList.add(dutyNote);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;	
		} finally {
			// �ͷ����ݿ���Դ
			DataBaseFactory.close(conn, prst, rs);
		}
		
		// ���ؽ��
		return resultList;
	}

}
