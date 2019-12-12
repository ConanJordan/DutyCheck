package com.jp.co.netwisdom.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
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
	 * 式样：水平垂直居中
	 */
	private static HSSFCellStyle CELL_STYLE_CENTER;

	/**
	 * 式样：水平垂直居中并竖直排列文字
	 */
	private static HSSFCellStyle CELL_STYLE_CENTER_VERTICAL;

	/**
	 * 式样：水平居中且文字可以换行
	 */
	private static HSSFCellStyle CELL_STYLE_CENTER_RETURN;
	
	/**
	 * 式样：(标题用)水平垂直居中，加粗，18号
	 */
	private static HSSFCellStyle CELL_STYLE_TITLE;
	
	/**
	 * 式样：水平垂直居中，红色填充
	 */
	private static HSSFCellStyle CELL_STYLE_RED;
	
	/**
	 * 式样：水平垂直居中，黄色填充
	 */
	private static HSSFCellStyle CELL_STYLE_YELLOW;

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
		
		// 初始化单元格式样
		this.initCellStyle();
		
		this.setLayout();
	}
	
	/**
	 * 初始化式样
	 */
	private void initCellStyle () {
		
		CELL_STYLE_CENTER = this.book.createCellStyle();
		CELL_STYLE_CENTER.setAlignment(HorizontalAlignment.CENTER);
		CELL_STYLE_CENTER.setVerticalAlignment(VerticalAlignment.CENTER);
		
		CELL_STYLE_CENTER_VERTICAL = this.book.createCellStyle();
		CELL_STYLE_CENTER_VERTICAL.setAlignment(HorizontalAlignment.CENTER);
		CELL_STYLE_CENTER_VERTICAL.setVerticalAlignment(VerticalAlignment.CENTER);
		CELL_STYLE_CENTER_VERTICAL.setRotation((short) 0xff);
		
		CELL_STYLE_CENTER_RETURN = this.book.createCellStyle();
		CELL_STYLE_CENTER_RETURN.setAlignment(HorizontalAlignment.CENTER);
		CELL_STYLE_CENTER_RETURN.setVerticalAlignment(VerticalAlignment.CENTER);
		CELL_STYLE_CENTER_RETURN.setWrapText(true);
		
		CELL_STYLE_TITLE = this.book.createCellStyle();
		CELL_STYLE_TITLE.setAlignment(HorizontalAlignment.CENTER);
		CELL_STYLE_TITLE.setVerticalAlignment(VerticalAlignment.CENTER);
		HSSFFont font = this.book.createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short) 18);
		CELL_STYLE_TITLE.setFont(font);
		
		CELL_STYLE_RED = this.book.createCellStyle();
		CELL_STYLE_RED.setAlignment(HorizontalAlignment.CENTER);
		CELL_STYLE_RED.setVerticalAlignment(VerticalAlignment.CENTER);
		CELL_STYLE_RED.setFillForegroundColor(IndexedColors.RED.getIndex());
		CELL_STYLE_RED.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		CELL_STYLE_YELLOW = this.book.createCellStyle();
		CELL_STYLE_YELLOW.setAlignment(HorizontalAlignment.CENTER);
		CELL_STYLE_YELLOW.setVerticalAlignment(VerticalAlignment.CENTER);
		CELL_STYLE_YELLOW.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		CELL_STYLE_YELLOW.setFillPattern(FillPatternType.SOLID_FOREGROUND);
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
				row.createCell(collumnNum) : row.getCell(collumnNum);
				
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
	 * 向单元格里写入内容并设置式样
	 * @param value
	 * @param rowNum
	 * @param collumnNum
	 * @param cellStyle
	 */
	private void write (String value, int rowNum, int collumnNum, HSSFCellStyle cellStyle) {
		// 获取单元格
		HSSFCell cell = this.getCell(rowNum, collumnNum);
		// 设置单元格式样
		cell.setCellStyle(cellStyle);
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
	private void setStyle (int rowNum, int collumnNum, HSSFCellStyle cellStyle) {
		// 获取单元格
		this.cell = this.getCell(rowNum, collumnNum);
		// 设置单元格式样
		this.cell.setCellStyle(cellStyle);
	}

	/**
	 * 设置单元格竖向文字
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setVertical (int rowNum, int collumnNum) {
		// 设置单元格式样:竖向文字
		HSSFCellStyle cellStyle = this.getCellStyle(rowNum, collumnNum);
		cellStyle.setRotation((short) 0xff);
		this.setStyle(rowNum, collumnNum, cellStyle);
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
		HSSFCellStyle cellStyle = this.getCellStyle(rowNum, collumnNum);
		cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.setStyle(rowNum, collumnNum, cellStyle);
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
		HSSFCellStyle cellStyle = this.getCellStyle(rowNum, collumnNum);
		cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.setStyle(rowNum, collumnNum, cellStyle);
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
		// 前两列宽2000，后面的宽1200
		// 第二行高1500
		this.sheet.setColumnWidth(0, 2000);
		this.sheet.setColumnWidth(1, 2000);
		for (int i = 2; i < 2 + days + 4; i ++) {  // 前面的2代表前两列，后面的4代表最后4列
			this.sheet.setColumnWidth(i, 1200);
		}
		this.setHeight(1, (short) 1500);
		
		// 合并第一行的单元格
		this.combine(0,0,0,2 + days + 4 - 1);
		
		// 合并第一列的2,3行单元格
		this.combine(1,2,0,0);
		
		// 设置前三行全部水平垂直居中
		/*this.setAlignmentCenter(0, 0);
		this.setAlignmentCenter(1, 0);
		for (int i = 1; i < 2 + days + 4; i ++) {
			this.setAlignmentCenter(1, i);
			this.setAlignmentCenter(2, i);
		}*/
		
		// 写入前三行的内容
		this.write(this.sheet.getSheetName(), 
				0, 0, CELL_STYLE_TITLE);  // 第一行
		
		this.write(NAME, 1, 0, CELL_STYLE_CENTER);  // 第二行第一列
		this.write(WEEK, 1, 1, CELL_STYLE_CENTER);  // 第二行第二列
		this.write(DAY, 2, 1, CELL_STYLE_CENTER);  // 第三行第二列
		
		// 写入最后四列的内容:注意竖直排列
		this.setVertical(1, 2 + days);
		this.write(PREDICT_DAYS, 1, 2 + days, CELL_STYLE_CENTER_VERTICAL);
		this.setVertical(1, 2 + days + 1);
		this.write(REAL_DAYS, 1, 2 + days + 1, CELL_STYLE_CENTER_VERTICAL);
		this.setVertical(1, 2 + days + 2);
		this.write(DUTY_TIME, 1, 2 + days + 2, CELL_STYLE_CENTER_VERTICAL);
		this.setVertical(1, 2 + days + 3);
		this.write(LATE_EARLY, 1, 2 + days + 3, CELL_STYLE_CENTER_VERTICAL);
		
		this.write(DAYS, 2, 2 + days, CELL_STYLE_CENTER);
		this.write(DAYS, 2, 2 + days + 1, CELL_STYLE_CENTER);
		this.write(TIME, 2, 2 + days + 2, CELL_STYLE_CENTER);
		this.write(COUNTS, 2, 2 + days + 3, CELL_STYLE_CENTER);
		
		// 写入中间列的星期和日：星期在上，日在下
		for (int i = 1; i <= days; i ++) {
			this.write(this.getWeek(i), 1,  2 + i - 1, CELL_STYLE_CENTER);
			this.write(String.valueOf(i), 2, 2 + i - 1, CELL_STYLE_CENTER);
		}
		
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
	
	private HSSFCellStyle getCellStyle (int rowNum, int collumnNum) {
		HSSFCell cell = this.getCell(rowNum, collumnNum);
		HSSFCellStyle cellStyle = cell.getCellStyle();
		return cellStyle;
	}
	
}
