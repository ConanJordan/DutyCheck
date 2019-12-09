package com.jp.co.netwisdom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jp.co.netwisdom.config.Const;
import com.jp.co.netwisdom.db.DataBaseFactory;
import com.jp.co.netwisdom.entity.EmployeeEntity;
import com.jp.co.netwisdom.entity.NoteTableEntity;
import com.jp.co.netwisdom.interfaces.QueryIF;

public class EmployeeDao implements QueryIF {

	@Override
	public List<EmployeeEntity> queryAllEmployee() throws SQLException {
		
		List<EmployeeEntity> resultList = new ArrayList<EmployeeEntity>();
		
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		conn = DataBaseFactory.CreateConnection();
		prst =conn.prepareStatement(Const.SQL_SELECT_ALL_EMPLYEES);
		rs = prst.executeQuery();  // ÷¥––≤È—Ø
		
		while (rs.next()) {
			EmployeeEntity employee = new EmployeeEntity();
			
			employee.setId(rs.getString(1));  // ID
			employee.setName(rs.getString(2));  // name
			employee.setDept(rs.getString(3));  // dept
			employee.setCardNo(rs.getString(4));  // cardNo
			
			resultList.add(employee);
		}

		return resultList;
	}

	@Override
	public List<NoteTableEntity> queryNoteTable(String cardNo, int year,
			int month) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
