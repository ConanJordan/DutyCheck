package com.jp.co.netwisdom.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * 写入Workbook文件的Util类
 */
public class WorkBookUtil {
	
	private static final String NAME = "氏名";
	private static final String WEEK = "曜日";
	private static final String DAY = "日";
	private static final String SUNDAY = "日";
	private static final String MONDAY = "月";
	private static final String TUESDAY = "火";
	private static final String WEDNESDAY = "水";
	private static final String THURSDAY = "木";
	private static final String FRIDAY = "金";
	private static final String SATURDAY = "土";
	private static final String DAYS = "天数";
	private static final String TIME = "時間";
	private static final String COUNTS = "次数";
	private static final String DUTY_TIMES = "出勤\n時間";  // 「出勤時間」换行显示
	private static final String PREDICT_DAYS = "予定出勤";
	private static final String REAL_DAYS = "実際出勤";
	private static final String DUTY_TIME = "出勤時間";
	private static final String LATE_EARLY = "迟到早退";

	/**
	 * 工作簿
	 */
	private HSSFWorkbook book;	
	/**
	 * 工作表
	 */
	private HSSFSheet sheet;	
	/**
	 * 工作表的行
	 */
	private HSSFRow row;
	/**
	 * 单元格
	 */
	private HSSFCell cell;
	/**
	 * 单元格式样
	 */
	private HSSFCellStyle cellStyle;
	/**
	 * 年份
	 */
	private int year;
	/**
	 * 月份
	 */
	private int month;
	
	public WorkBookUtil (String sheetName, int year, int month) {
		this.book = new HSSFWorkbook();
		this.sheet = this.book.createSheet(sheetName);
		this.year = year;
		this.month = month;
	}
	
	/**
	 * 初始化工作表
	 */
	public void initSheet () {
		// 工作表标题：xxx勤务表
		// 合并最上方单元格
		// 设置2,3两行单元格
		
		this.setLayout();
	}
	
	/**
	 * 获取单元格,单元格不存在的话就生成一个并返回
	 * @param rowNum
	 * @param collumnNum
	 * @return
	 */
	private HSSFCell getCell (int rowNum, int collumnNum) {
		HSSFCell cell = null;
		
		// 获取行
		HSSFRow row = this.sheet.getRow(rowNum) == null ?
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// 获取列
		cell = row.getCell(collumnNum) == null ?
				row.createCell(rowNum) : row.getCell(rowNum);
				
		return cell;
	}
	
	/**
	 * 合并单元格
	 * @param startRow
	 * @param startCollumn
	 * @param endRow
	 * @param endCollumn
	 */
	private void combine (int firstRow, int lastRow, int firstCollumn, int lastCollumn) {
			
		// 获取需要合并的单元格
		for (int rowNum = firstRow; rowNum <= lastRow; rowNum ++) {
			for (int collumnNum = firstCollumn; collumnNum <= lastCollumn; collumnNum ++) {
				this.getCell(rowNum, collumnNum);
			}
		}
					
		// 合并单元格
		CellRangeAddress region = new CellRangeAddress (firstRow,lastRow,firstCollumn,lastCollumn);		
		this.sheet.addMergedRegion(region);
	}
	
	/**
	 * 向单元格里写入内容
	 * @param value
	 * @param row
	 * @param collumn
	 */
	private void write (String value, int rowNum, int collumnNum) {
		// 获取单元格
		HSSFCell cell = this.getCell(rowNum, collumnNum);
		// 写入内容
		cell.setCellValue(value);
	}
	
	/**
	 * 把工作簿的内容写入文件中
	 * @param fos
	 * @throws IOException 
	 */
	public void write (FileOutputStream fos) throws IOException {
		this.book.write(fos);
	}
	
	/**
	 * 设置单元格式样
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setStyle (int rowNum, int collumnNum) {
		// 获取单元格
		this.cell = this.getCell(rowNum, collumnNum);
		// 设置单元格式样
		this.cell.setCellStyle(this.cellStyle);
	}

	/**
	 * 设置单元格竖向文字
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setVertical (int rowNum, int collumnNum) {
		// 获取单元格
		this.cell = this.getCell(rowNum, collumnNum);
		// 设置单元格式样:竖向文字
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setRotation((short) 0xff);
		this.setStyle(rowNum, collumnNum);
	}
	
	/**
	 * 红色背景填充
	 * @param rowNum
	 * @param collumnNum
	 */
	private void fillRed (int rowNum, int collumnNum) {
		// 获取单元格
		this.cell = this.getCell(rowNum, collumnNum);
		// 设置单元格式样:红色背景
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		this.cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.setStyle(rowNum, collumnNum);
	}
	
	/**
	 * 黄色背景填充
	 * @param rowNum
	 * @param collumnNum
	 */
	private void fillYellow (int rowNum, int collumnNum) {
		// 获取单元格
		this.cell = this.getCell(rowNum, collumnNum);
		// 设置单元格式样:红色背景
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		this.cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.setStyle(rowNum, collumnNum);
	}
	
	/**
	 * 设置行高
	 * @param rowNum
	 * @param height
	 */
	private void setHeight (int rowNum, short height) {
		// 获取行
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// 设置行高
		this.row.setHeight(height);
	}
	
	// 设置工作表整体布局
	private void setLayout () {
		// 获取目标月的天数
		int days = CalendarUtil.getDaysOfMonth(year, month);
		
		// 设置前三行的单元格宽高
		// 前两列宽2000，后面的宽1000
		// 第二行高1500
		this.sheet.setColumnWidth(0, 2000);
		this.sheet.setColumnWidth(1, 2000);
		for (int i = 2; i < 2 + days + 4; i ++) {  // 前面的2代表前两列，后面的4代表最后4列
			this.sheet.setColumnWidth(i, 1000);
		}
		this.setHeight(1, (short) 1500);
		
		// 合并第一行的单元格
		this.combine(0,0,0,2 + days + 4 - 1);
		
		// 合并第一列的2,3行单元格
		this.combine(1,2,0,0);
		
		// 设置前三行全部水平居中
		this.setAlignmentCenter(0, 0);
		this.setAlignmentCenter(1, 0);
		for (int i = 1; i < 2 + days + 4; i ++) {
			this.setAlignmentCenter(1, i);
			this.setAlignmentCenter(2, i);
		}
		
		// 写入前三行的内容
		this.write(this.sheet.getSheetName(), 
				0, 0);  // 第一行
		
		this.write(NAME, 1, 0);  // 第二行第一列
		this.write(WEEK, 1, 1);  // 第二行第二列
		this.write(DAY, 1, 2);  // 第二行第三列
		
		// 写入最后四列的内容:注意竖直排列
		this.setVertical(1, 2 + days);
		this.write(PREDICT_DAYS, 1, 2 + days);
		this.setVertical(1, 2 + days + 1);
		this.write(REAL_DAYS, 1, 2 + days + 1);
		this.setVertical(1, 2 + days + 2);
		this.write(DUTY_TIME, 1, 2 + days + 2);
		this.setVertical(1, 2 + days + 3);
		this.write(LATE_EARLY, 1, 2 + days + 3);
		
		this.write(DAYS, 2, 2 + days);
		this.write(DAYS, 2, 2 + days + 1);
		this.write(TIME, 2, 2 + days + 2);
		this.write(COUNTS, 2, 2 + days + 3);
		
		// 写入中间列的星期和日：星期在上，日在下
		for (int i = 1; i <= days; i ++) {
			this.write(this.getWeek(i), 1,  2 + i - 1);
			this.write(String.valueOf(i), 2, 2 + i - 1);
		}
		
	}
	
	/**
	 * 设置单元格内容水平居中
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setAlignmentCenter (int rowNum, int collumnNum) {
		// 获取行
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// 获取单元格
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setAlignment(HorizontalAlignment.CENTER);
		this.setStyle(rowNum, collumnNum);
	}
	
	/**
	 * 获取星期
	 * @param day
	 * @return
	 */
	private String getWeek (int date) {
		
		String week = "";
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, this.year);
		calendar.set(Calendar.MONTH, this.month - 1);
		calendar.set(Calendar.DATE, date);
		
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SUNDAY :
				week = SUNDAY;
				break;
			case Calendar.MONDAY :
				week = MONDAY;
				break;
			case Calendar.TUESDAY :
				week = TUESDAY;
				break;
			case Calendar.WEDNESDAY :
				week = WEDNESDAY;
				break;
			case Calendar.THURSDAY :
				week = THURSDAY;
				break;
			case Calendar.FRIDAY :
				week = FRIDAY;
				break;
			case Calendar.SATURDAY :
				week = SATURDAY;
				break;
		}
		
		return week;
	}
	
}
