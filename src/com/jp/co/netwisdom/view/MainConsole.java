package com.jp.co.netwisdom.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jp.co.netwisdom.config.Const;
import com.jp.co.netwisdom.entity.OutputResultEntity;
import com.jp.co.netwisdom.io.CreateExcel;

public class MainConsole {
	
	private static Scanner INPUT = new Scanner(System.in);
	
	private static MainConsole CONSOLE = new MainConsole();

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
		 * 输出内容集合
		 */
		List<OutputResultEntity> outputResultList = new ArrayList<OutputResultEntity>();
		
		System.out.println(Const.PLEASE_INPUT_YEAR_MONTH);
		
		inputYearMonth = INPUT.nextInt();  // 获取查询年月
		
		inputYear = inputYearMonth / 100;  // 获取查询年
		
		inputMonth = inputYearMonth % 100;  // 获取查询月
		
		try {	
			
			// 在控制台输出结果内容
			//CONSOLE.showDutyResult(outputResultList);
			
			/*
			 * 写入Excel文件
			 */
			if (CONSOLE.outputFile(inputYear, inputMonth, outputResultList)) {
				System.out.println("写入Excel文件成功。存储的文件路径为：" + Const.PATH_OUTPUT);
			} else {
				System.out.println("写入Excel文件失败。");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	// 输出到excel文件
	private boolean outputFile (int year, int month, List<OutputResultEntity> outputResultList) throws IOException{
		CreateExcel ce = new CreateExcel (year, month, outputResultList);
		HSSFWorkbook book = ce.edit();
		String fileName = ce.create();
		return ce.save(fileName, book);
	}

}
