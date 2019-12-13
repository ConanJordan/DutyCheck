package com.jp.co.netwisdom.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

public class TestDemo {

	public static void main(String[] args) {
	
		POIFSFileSystem fs = null;  // Excel文件流对象
		HSSFWorkbook wb = null;  // Excel工作簿对象
		HSSFSheet sheet = null;  // Excel工作表对象
		FileOutputStream fos = null;
		File targetExcel = null;
		
		try {
			
			targetExcel = new File("d:/output/MyExcel.xls");
			
			if (targetExcel.exists() == false) {
				targetExcel.createNewFile();
			}
			
			fos = new FileOutputStream(targetExcel);
			
			// fs = new POIFSFileSystem(new FileInputStream(targetExcel));
			
			wb = new HSSFWorkbook();
			
			sheet = wb.createSheet();
			
			HSSFRow row = sheet.createRow(2);
			HSSFCell cell = row.createCell(3);
			cell.setCellValue("同学请坐，学姐上课。");

			
			HSSFCellStyle cellStyle2 = wb.createCellStyle();
			HSSFFont font =wb.createFont();
			font.setFontName("楷体");
			cellStyle2.setFont(font);
			cell.setCellStyle(cellStyle2);
			
			HSSFCellStyle cellStyle1 = wb.createCellStyle();
			cellStyle1.setAlignment(HorizontalAlignment.CENTER);	
			cell.setCellStyle(cellStyle1);
			
			// 设置列宽和行高
			/*sheet.setColumnWidth(1, 1000);
			HSSFRow row = sheet.createRow(0);
			row.setHeight((short) 800);*/
			
			/*// 合并单元格
			CellRangeAddress region = new CellRangeAddress (0,0,0,36);		
			sheet.addMergedRegion(region);
			
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell(0);
			
			HSSFCellStyle cellStyle = wb.createCellStyle();
			
			cell.setCellValue("令和元年１２月分\n勤務表");
			
			// 设置水平居中
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			
			//cellStyle.setRotation((short) 0xff);
			cellStyle.setWrapText(true);
			
			// 设置背景色
			cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			// 设置字体
			HSSFFont font = wb.createFont();
			font.setBold(true);  // 字体加粗
			font.setFontHeightInPoints((short) 12);  // 设置字号
			font.setColor(HSSFFont.COLOR_RED);  // 红色
			font.setFontName("楷体");
			
			cellStyle.setFont(font);
			
			cell.setCellStyle(cellStyle);
			
			HSSFRow row2 = sheet.createRow(1);
			HSSFCell cell2 = row2.createCell(2);
			
			
			cellStyle = wb.createCellStyle();
			cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell2.setCellStyle(cellStyle);*/
			
			wb.write(fos);
			
			System.out.println("The file has been saved.");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//fs.close();
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
