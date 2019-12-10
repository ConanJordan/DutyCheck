package com.jp.co.netwisdom.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jp.co.netwisdom.config.Const;
import com.jp.co.netwisdom.entity.EmployeeEntity;
import com.jp.co.netwisdom.entity.NoteTableEntity;
import com.jp.co.netwisdom.service.EmployeeService;
import com.jp.co.netwisdom.service.NoteTableService;

public class MainConsole {
	
	private static Scanner INPUT = new Scanner(System.in);
	
	private EmployeeService employeeSer;
	private NoteTableService noteTableSer;


	public static void main(String[] args) {
		
		/**
		 * 查询年月
		 */
		int inputYearMonth;
		
		/**
		 * 查询年
		 */
		int inputYear;
		/**
		 * 查询月
		 */
		int inputMonth;
		
		System.out.println(Const.PLEASE_INPUT_YEAR_MONTH);
		
		inputYearMonth = INPUT.nextInt();  // 获取查询年月
		
		inputYear = inputYearMonth / 100;  // 获取查询年
		
		inputMonth = inputYearMonth % 100;  // 获取查询月
		
	}
	
	private List<EmployeeEntity> getEmployees() throws SQLException {
		return this.employeeSer.queryEmployees();
	}
	
	private List<NoteTableEntity> getNoteTables 
		(String cardNo, int year, int month) throws SQLException {
		return this.noteTableSer.queryNoteTables(cardNo, year, month);
	}
	
	/**
	 * 显示查询出来的考勤结果
	 * Demo用
	 */
	private void showDutyResult () {
		// TODO
	}
	
	// 输出到excel文件
	private boolean outputFile (){
		// TODO
		return true;
	}

}
