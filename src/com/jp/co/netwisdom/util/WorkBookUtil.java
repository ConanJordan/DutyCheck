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
 * д��Workbook�ļ���Util��
 */
public class WorkBookUtil {
	
	private static final String NAME = "����";
	private static final String WEEK = "����";
	private static final String DAY = "��";
	private static final String SUNDAY = "��";
	private static final String MONDAY = "��";
	private static final String TUESDAY = "��";
	private static final String WEDNESDAY = "ˮ";
	private static final String THURSDAY = "ľ";
	private static final String FRIDAY = "��";
	private static final String SATURDAY = "��";
	private static final String DAYS = "����";
	private static final String TIME = "�r�g";
	private static final String COUNTS = "����";
	private static final String DUTY_TIMES = "����\n�r�g";  // �����ڕr�g��������ʾ
	private static final String PREDICT_DAYS = "�趨����";
	private static final String REAL_DAYS = "�g�H����";
	private static final String DUTY_TIME = "���ڕr�g";
	private static final String LATE_EARLY = "�ٵ�����";

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
	/**
	 * ���
	 */
	private int year;
	/**
	 * �·�
	 */
	private int month;
	
	public WorkBookUtil (String sheetName, int year, int month) {
		this.book = new HSSFWorkbook();
		this.sheet = this.book.createSheet(sheetName);
		this.year = year;
		this.month = month;
	}
	
	/**
	 * ��ʼ��������
	 */
	public void initSheet () {
		// ��������⣺xxx�����
		// �ϲ����Ϸ���Ԫ��
		// ����2,3���е�Ԫ��
		
		this.setLayout();
	}
	
	/**
	 * ��ȡ��Ԫ��,��Ԫ�񲻴��ڵĻ�������һ��������
	 * @param rowNum
	 * @param collumnNum
	 * @return
	 */
	private HSSFCell getCell (int rowNum, int collumnNum) {
		HSSFCell cell = null;
		
		// ��ȡ��
		HSSFRow row = this.sheet.getRow(rowNum) == null ?
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// ��ȡ��
		cell = row.getCell(collumnNum) == null ?
				row.createCell(rowNum) : row.getCell(rowNum);
				
		return cell;
	}
	
	/**
	 * �ϲ���Ԫ��
	 * @param startRow
	 * @param startCollumn
	 * @param endRow
	 * @param endCollumn
	 */
	private void combine (int firstRow, int lastRow, int firstCollumn, int lastCollumn) {
			
		// ��ȡ��Ҫ�ϲ��ĵ�Ԫ��
		for (int rowNum = firstRow; rowNum <= lastRow; rowNum ++) {
			for (int collumnNum = firstCollumn; collumnNum <= lastCollumn; collumnNum ++) {
				this.getCell(rowNum, collumnNum);
			}
		}
					
		// �ϲ���Ԫ��
		CellRangeAddress region = new CellRangeAddress (firstRow,lastRow,firstCollumn,lastCollumn);		
		this.sheet.addMergedRegion(region);
	}
	
	/**
	 * ��Ԫ����д������
	 * @param value
	 * @param row
	 * @param collumn
	 */
	private void write (String value, int rowNum, int collumnNum) {
		// ��ȡ��Ԫ��
		HSSFCell cell = this.getCell(rowNum, collumnNum);
		// д������
		cell.setCellValue(value);
	}
	
	/**
	 * �ѹ�����������д���ļ���
	 * @param fos
	 * @throws IOException 
	 */
	public void write (FileOutputStream fos) throws IOException {
		this.book.write(fos);
	}
	
	/**
	 * ���õ�Ԫ��ʽ��
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setStyle (int rowNum, int collumnNum) {
		// ��ȡ��Ԫ��
		this.cell = this.getCell(rowNum, collumnNum);
		// ���õ�Ԫ��ʽ��
		this.cell.setCellStyle(this.cellStyle);
	}

	/**
	 * ���õ�Ԫ����������
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setVertical (int rowNum, int collumnNum) {
		// ��ȡ��Ԫ��
		this.cell = this.getCell(rowNum, collumnNum);
		// ���õ�Ԫ��ʽ��:��������
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setRotation((short) 0xff);
		this.setStyle(rowNum, collumnNum);
	}
	
	/**
	 * ��ɫ�������
	 * @param rowNum
	 * @param collumnNum
	 */
	private void fillRed (int rowNum, int collumnNum) {
		// ��ȡ��Ԫ��
		this.cell = this.getCell(rowNum, collumnNum);
		// ���õ�Ԫ��ʽ��:��ɫ����
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		this.cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.setStyle(rowNum, collumnNum);
	}
	
	/**
	 * ��ɫ�������
	 * @param rowNum
	 * @param collumnNum
	 */
	private void fillYellow (int rowNum, int collumnNum) {
		// ��ȡ��Ԫ��
		this.cell = this.getCell(rowNum, collumnNum);
		// ���õ�Ԫ��ʽ��:��ɫ����
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		this.cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.setStyle(rowNum, collumnNum);
	}
	
	/**
	 * �����и�
	 * @param rowNum
	 * @param height
	 */
	private void setHeight (int rowNum, short height) {
		// ��ȡ��
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// �����и�
		this.row.setHeight(height);
	}
	
	// ���ù��������岼��
	private void setLayout () {
		// ��ȡĿ���µ�����
		int days = CalendarUtil.getDaysOfMonth(year, month);
		
		// ����ǰ���еĵ�Ԫ����
		// ǰ���п�2000������Ŀ�1000
		// �ڶ��и�1500
		this.sheet.setColumnWidth(0, 2000);
		this.sheet.setColumnWidth(1, 2000);
		for (int i = 2; i < 2 + days + 4; i ++) {  // ǰ���2����ǰ���У������4�������4��
			this.sheet.setColumnWidth(i, 1000);
		}
		this.setHeight(1, (short) 1500);
		
		// �ϲ���һ�еĵ�Ԫ��
		this.combine(0,0,0,2 + days + 4 - 1);
		
		// �ϲ���һ�е�2,3�е�Ԫ��
		this.combine(1,2,0,0);
		
		// ����ǰ����ȫ��ˮƽ����
		this.setAlignmentCenter(0, 0);
		this.setAlignmentCenter(1, 0);
		for (int i = 1; i < 2 + days + 4; i ++) {
			this.setAlignmentCenter(1, i);
			this.setAlignmentCenter(2, i);
		}
		
		// д��ǰ���е�����
		this.write(this.sheet.getSheetName(), 
				0, 0);  // ��һ��
		
		this.write(NAME, 1, 0);  // �ڶ��е�һ��
		this.write(WEEK, 1, 1);  // �ڶ��еڶ���
		this.write(DAY, 1, 2);  // �ڶ��е�����
		
		// д��������е�����:ע����ֱ����
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
		
		// д���м��е����ں��գ��������ϣ�������
		for (int i = 1; i <= days; i ++) {
			this.write(this.getWeek(i), 1,  2 + i - 1);
			this.write(String.valueOf(i), 2, 2 + i - 1);
		}
		
	}
	
	/**
	 * ���õ�Ԫ������ˮƽ����
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setAlignmentCenter (int rowNum, int collumnNum) {
		// ��ȡ��
		this.row = this.sheet.getRow(rowNum) == null ? 
				this.sheet.createRow(rowNum) : this.sheet.getRow(rowNum);
		// ��ȡ��Ԫ��
		this.cell = this.row.getCell(collumnNum) == null ?
				this.row.createCell(collumnNum) : this.row.createCell(collumnNum);
		this.cellStyle = this.book.createCellStyle();
		this.cellStyle.setAlignment(HorizontalAlignment.CENTER);
		this.setStyle(rowNum, collumnNum);
	}
	
	/**
	 * ��ȡ����
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
