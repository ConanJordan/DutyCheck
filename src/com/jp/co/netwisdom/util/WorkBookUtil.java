package com.jp.co.netwisdom.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * 写入Workbook文件的Util类
 */
public class WorkBookUtil {
	
	private static final String WEEK = "曜日";
	private static final String DAY = "日";
	private static final String SUNDAY = "日";
	private static final String MONDAY = "月";
	private static final String TUESDAY = "火";
	private static final String WENSDAY = "水";
	private static final String THURSDAY = "木";
	private static final String FRIDAY = "金";
	private static final String SATURDAY = "土";
	private static final String DAYS = "天数";
	private static final String TIME = "時間";
	private static final String COUNTS = "次数";
	private static final String DUTY_TIME = "出勤\n時間";  // 「出勤時間」换行显示

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
	
	public WorkBookUtil (String sheetName, int year, int month) {
		this.book = new HSSFWorkbook();
		this.sheet = this.book.createSheet(sheetName);
		
	}
	
	/**
	 * 初始化工作表
	 * @param year
	 * @param month
	 */
	private void initSheet (int year, int month) {
		// 工作表标题：xxx勤务表
		// 合并最上方单元格
		// 设置2,3两行单元格
	}
	
	/**
	 * 合并单元格
	 * @param startRow
	 * @param startCollumn
	 * @param endRow
	 * @param endCollumn
	 */
	private void combine (int startRow, int startCollumn, int endRow, int endCollumn) {
		// 合并单元格
		CellRangeAddress region = new CellRangeAddress (0,0,0,36);		
		this.sheet.addMergedRegion(region);
	}
	
	/**
	 * 向单元格里写入内容
	 * @param value
	 * @param row
	 * @param collumn
	 */
	private void write (String value, int rowNum, int collumnNum) {
		// 获取行
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// 获取单元格
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		// 写入内容
		this.cell.setCellValue(value);
	}
	
	/**
	 * 设置单元格式样
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setStyle (int rowNum, int collumnNum) {
		// 获取行
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// 获取单元格
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		// 设置单元格式样
		this.cell.setCellStyle(this.cellStyle);
	}

	/**
	 * 设置单元格竖向文字
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setVertical (int rowNum, int collumnNum) {
		// 获取行
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// 获取单元格
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		// 设置单元格式样:竖向文字
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setRotation((short) 0xff);
		this.cell.setCellStyle(this.cellStyle);
	}
	
	/**
	 * 红色背景填充
	 * @param rowNum
	 * @param collumnNum
	 */
	private void fillRed (int rowNum, int collumnNum) {
		// 获取行
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// 获取单元格
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		// 设置单元格式样:红色背景
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		this.cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.cell.setCellStyle(this.cellStyle);
	}
	
	/**
	 * 黄色背景填充
	 * @param rowNum
	 * @param collumnNum
	 */
	private void fillYellow (int rowNum, int collumnNum) {
		// 获取行
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// 获取单元格
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		// 设置单元格式样:红色背景
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		this.cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.cell.setCellStyle(this.cellStyle);
	}
	
}
