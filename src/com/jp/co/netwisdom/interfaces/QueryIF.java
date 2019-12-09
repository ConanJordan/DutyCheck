package com.jp.co.netwisdom.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.jp.co.netwisdom.entity.EmployeeEntity;
import com.jp.co.netwisdom.entity.NoteTableEntity;

public interface QueryIF {
	
	public List<EmployeeEntity> queryAllEmployee() throws SQLException;
	
	public List<NoteTableEntity> queryNoteTable(String cardNo, int year, int month) throws SQLException;
	
}
