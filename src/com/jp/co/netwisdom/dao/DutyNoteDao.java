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
		
		// 初始化要返回的集合
		List<DutyNoteDto> resultList = new ArrayList<DutyNoteDto>();
		
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		conn = DataBaseFactory.CreateConnection();
		try {
			prst = conn.prepareStatement(Const.SQL_QUERY_DUTY_NOTE_INFO);
			prst.setString(1, CalendarUtil.getFirstDay(year, month));  // 设置目标月第一天
			prst.setString(2, CalendarUtil.getLastDay(year, month));  // 设置目标月最后一天
			
			rs = prst.executeQuery();  // 执行检索
			
			while (rs.next()) {
				DutyNoteDto dutyNote = new DutyNoteDto();
				dutyNote.setCardNo(rs.getString("CARDNO"));  // 卡号
				dutyNote.setName(rs.getString("NAME")); // 姓名
				dutyNote.setDept(rs.getString("DEPT")); // 部门
				dutyNote.setCdt(
						new java.sql.Date(
								CalendarUtil.strToDate(rs.getString("CDT"), Const.YYYYMMDD_FORMAT).getTime())
						); // 打卡日期
				dutyNote.setCti(rs.getString("CTI"));// 打卡时刻
				
				resultList.add(dutyNote);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;	
		} finally {
			// 释放数据库资源
			DataBaseFactory.close(conn, prst, rs);
		}
		
		// 返回结果
		return resultList;
	}

}
