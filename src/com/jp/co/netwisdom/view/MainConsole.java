package com.jp.co.netwisdom.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jp.co.netwisdom.config.Const;
import com.jp.co.netwisdom.entity.EmployeeEntity;
import com.jp.co.netwisdom.entity.NoteTableEntity;
import com.jp.co.netwisdom.entity.OutputResultEntity;
import com.jp.co.netwisdom.service.AdaptService;
import com.jp.co.netwisdom.service.EmployeeService;
import com.jp.co.netwisdom.service.NoteTableService;

public class MainConsole {
	
	private static Scanner INPUT = new Scanner(System.in);
	
	private EmployeeService employeeSer = new EmployeeService();
	private NoteTableService noteTableSer = new NoteTableService();
	
	private static MainConsole CONSOLE = new MainConsole();
	
	private static AdaptService APDAT_SERVICE = new AdaptService();


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
		
		/**
		 * 员工集合
		 */
		List<EmployeeEntity> employeeList;
		
		/**
		 * 打卡记录集合
		 */
		List<NoteTableEntity> noteTableList;
		
		/**
		 * 输出内容集合
		 */
		List<OutputResultEntity> outputResultList = new ArrayList<OutputResultEntity>();
		
		System.out.println(Const.PLEASE_INPUT_YEAR_MONTH);
		
		inputYearMonth = INPUT.nextInt();  // 获取查询年月
		
		inputYear = inputYearMonth / 100;  // 获取查询年
		
		inputMonth = inputYearMonth % 100;  // 获取查询月
		
		try {	
			
			employeeList = CONSOLE.getEmployees();
			
			for (int i = 0; i < employeeList.size(); i ++) {
				noteTableList = CONSOLE.getNoteTables(
						employeeList.get(i).getCardNo(), inputYear, inputMonth);
				
				outputResultList.add(APDAT_SERVICE.adapt(employeeList.get(i), noteTableList, inputYear, inputMonth));
			}
			
			// 在控制台输出结果内容
			CONSOLE.showDutyResult(outputResultList);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	private void showDutyResult (List<OutputResultEntity> outputResultList) {
	
		for (OutputResultEntity outputResult : outputResultList) {
			System.out.println(outputResult);
		}
		
	}
	
	// 输出到excel文件
	private boolean outputFile (){
		// TODO
		return true;
	}

}
