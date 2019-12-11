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
 * д��Workbook�ļ���Util��
 */
public class WorkBookUtil {
	
	private static final String WEEK = "����";
	private static final String DAY = "��";
	private static final String SUNDAY = "��";
	private static final String MONDAY = "��";
	private static final String TUESDAY = "��";
	private static final String WENSDAY = "ˮ";
	private static final String THURSDAY = "ľ";
	private static final String FRIDAY = "��";
	private static final String SATURDAY = "��";
	private static final String DAYS = "����";
	private static final String TIME = "�r�g";
	private static final String COUNTS = "����";
	private static final String DUTY_TIME = "����\n�r�g";  // �����ڕr�g��������ʾ

	/**
	 * ������
	 */
	private HSSFWorkbook book;	
	/**
	 * ������
	 */
	private HSSFSheet sheet;	
	/**
	 * ���������
	 */
	private HSSFRow row;
	/**
	 * ��Ԫ��
	 */
	private HSSFCell cell;
	/**
	 * ��Ԫ��ʽ��
	 */
	private HSSFCellStyle cellStyle;
	
	public WorkBookUtil (String sheetName, int year, int month) {
		this.book = new HSSFWorkbook();
		this.sheet = this.book.createSheet(sheetName);
		
	}
	
	/**
	 * ��ʼ��������
	 * @param year
	 * @param month
	 */
	private void initSheet (int year, int month) {
		// ��������⣺xxx�����
		// �ϲ����Ϸ���Ԫ��
		// ����2,3���е�Ԫ��
	}
	
	/**
	 * �ϲ���Ԫ��
	 * @param startRow
	 * @param startCollumn
	 * @param endRow
	 * @param endCollumn
	 */
	private void combine (int startRow, int startCollumn, int endRow, int endCollumn) {
		// �ϲ���Ԫ��
		CellRangeAddress region = new CellRangeAddress (0,0,0,36);		
		this.sheet.addMergedRegion(region);
	}
	
	/**
	 * ��Ԫ����д������
	 * @param value
	 * @param row
	 * @param collumn
	 */
	private void write (String value, int rowNum, int collumnNum) {
		// ��ȡ��
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// ��ȡ��Ԫ��
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		// д������
		this.cell.setCellValue(value);
	}
	
	/**
	 * ���õ�Ԫ��ʽ��
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setStyle (int rowNum, int collumnNum) {
		// ��ȡ��
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// ��ȡ��Ԫ��
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		// ���õ�Ԫ��ʽ��
		this.cell.setCellStyle(this.cellStyle);
	}

	/**
	 * ���õ�Ԫ����������
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setVertical (int rowNum, int collumnNum) {
		// ��ȡ��
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// ��ȡ��Ԫ��
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		// ���õ�Ԫ��ʽ��:��������
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setRotation((short) 0xff);
		this.cell.setCellStyle(this.cellStyle);
	}
	
	/**
	 * ��ɫ�������
	 * @param rowNum
	 * @param collumnNum
	 */
	private void fillRed (int rowNum, int collumnNum) {
		// ��ȡ��
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// ��ȡ��Ԫ��
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		// ���õ�Ԫ��ʽ��:��ɫ����
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		this.cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.cell.setCellStyle(this.cellStyle);
	}
	
	/**
	 * ��ɫ�������
	 * @param rowNum
	 * @param collumnNum
	 */
	private void fillYellow (int rowNum, int collumnNum) {
		// ��ȡ��
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// ��ȡ��Ԫ��
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		// ���õ�Ԫ��ʽ��:��ɫ����
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		this.cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.cell.setCellStyle(this.cellStyle);
	}
	
}
