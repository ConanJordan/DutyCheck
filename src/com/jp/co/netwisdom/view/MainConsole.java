package com.jp.co.netwisdom.view;

import java.sql.SQLException;
import java.util.List;

import com.jp.co.netwisdom.entity.EmployeeEntity;
import com.jp.co.netwisdom.entity.NoteTableEntity;
import com.jp.co.netwisdom.service.EmployeeService;
import com.jp.co.netwisdom.service.NoteTableService;

public class MainConsole {
	
	private EmployeeService employeeSer;
	private NoteTableService noteTableSer;

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	private List<EmployeeEntity> getEmployees() throws SQLException {
		return this.employeeSer.queryEmployees();
	}
	
	private List<NoteTableEntity> getNoteTables 
		(String cardNo, int year, int month) throws SQLException {
		return this.noteTableSer.queryNoteTables(cardNo, year, month);
	}

}
