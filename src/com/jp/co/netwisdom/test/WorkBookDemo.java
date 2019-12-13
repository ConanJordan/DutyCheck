package com.jp.co.netwisdom.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.jp.co.netwisdom.util.WorkBookUtil;

public class WorkBookDemo {

	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		
		WorkBookUtil bookUtil = new WorkBookUtil("令和元年１２月分勤務表",2019,12);
		
		bookUtil.initSheet();
		
		try {
			fos = new FileOutputStream("d:/output/MyExcel.xls");
			bookUtil.write(fos);
			System.out.println("The file has been created.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
