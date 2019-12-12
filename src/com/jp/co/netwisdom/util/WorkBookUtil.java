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
	 * ʽ����ˮƽ��ֱ����
	 */
	private static HSSFCellStyle CELL_STYLE_CENTER;

	/**
	 * ʽ����ˮƽ��ֱ���в���ֱ��������
	 */
	private static HSSFCellStyle CELL_STYLE_CENTER_VERTICAL;

	/**
	 * ʽ����ˮƽ���������ֿ��Ի���
	 */
	private static HSSFCellStyle CELL_STYLE_CENTER_RETURN;
	
	/**
	 * ʽ����(������)ˮƽ��ֱ���У��Ӵ֣�18��
	 */
	private static HSSFCellStyle CELL_STYLE_TITLE;
	
	/**
	 * ʽ����ˮƽ��ֱ���У���ɫ���
	 */
	private static HSSFCellStyle CELL_STYLE_RED;
	
	/**
	 * ʽ����ˮƽ��ֱ���У���ɫ���
	 */
	private static HSSFCellStyle CELL_STYLE_YELLOW;

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
		
		// ��ʼ����Ԫ��ʽ��
		this.initCellStyle();
		
		this.setLayout();
	}
	
	/**
	 * ��ʼ��ʽ��
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
				row.createCell(collumnNum) : row.getCell(collumnNum);
				
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
	 * ��Ԫ����д�����ݲ�����ʽ��
	 * @param value
	 * @param rowNum
	 * @param collumnNum
	 * @param cellStyle
	 */
	private void write (String value, int rowNum, int collumnNum, HSSFCellStyle cellStyle) {
		// ��ȡ��Ԫ��
		HSSFCell cell = this.getCell(rowNum, collumnNum);
		// ���õ�Ԫ��ʽ��
		cell.setCellStyle(cellStyle);
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
	private void setStyle (int rowNum, int collumnNum, HSSFCellStyle cellStyle) {
		// ��ȡ��Ԫ��
		this.cell = this.getCell(rowNum, collumnNum);
		// ���õ�Ԫ��ʽ��
		this.cell.setCellStyle(cellStyle);
	}

	/**
	 * ���õ�Ԫ����������
	 * @param rowNum
	 * @param collumnNum
	 */
	private void setVertical (int rowNum, int collumnNum) {
		// ���õ�Ԫ��ʽ��:��������
		HSSFCellStyle cellStyle = this.getCellStyle(rowNum, collumnNum);
		cellStyle.setRotation((short) 0xff);
		this.setStyle(rowNum, collumnNum, cellStyle);
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
		HSSFCellStyle cellStyle = this.getCellStyle(rowNum, collumnNum);
		cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.setStyle(rowNum, collumnNum, cellStyle);
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
		HSSFCellStyle cellStyle = this.getCellStyle(rowNum, collumnNum);
		cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		this.setStyle(rowNum, collumnNum, cellStyle);
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
		// ǰ���п�2000������Ŀ�1200
		// �ڶ��и�1500
		this.sheet.setColumnWidth(0, 2000);
		this.sheet.setColumnWidth(1, 2000);
		for (int i = 2; i < 2 + days + 4; i ++) {  // ǰ���2����ǰ���У������4�������4��
			this.sheet.setColumnWidth(i, 1200);
		}
		this.setHeight(1, (short) 1500);
		
		// �ϲ���һ�еĵ�Ԫ��
		this.combine(0,0,0,2 + days + 4 - 1);
		
		// �ϲ���һ�е�2,3�е�Ԫ��
		this.combine(1,2,0,0);
		
		// ����ǰ����ȫ��ˮƽ��ֱ����
		/*this.setAlignmentCenter(0, 0);
		this.setAlignmentCenter(1, 0);
		for (int i = 1; i < 2 + days + 4; i ++) {
			this.setAlignmentCenter(1, i);
			this.setAlignmentCenter(2, i);
		}*/
		
		// д��ǰ���е�����
		this.write(this.sheet.getSheetName(), 
				0, 0, CELL_STYLE_TITLE);  // ��һ��
		
		this.write(NAME, 1, 0, CELL_STYLE_CENTER);  // �ڶ��е�һ��
		this.write(WEEK, 1, 1, CELL_STYLE_CENTER);  // �ڶ��еڶ���
		this.write(DAY, 2, 1, CELL_STYLE_CENTER);  // �����еڶ���
		
		// д��������е�����:ע����ֱ����
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
		
		// д���м��е����ں��գ��������ϣ�������
		for (int i = 1; i <= days; i ++) {
			this.write(this.getWeek(i), 1,  2 + i - 1, CELL_STYLE_CENTER);
			this.write(String.valueOf(i), 2, 2 + i - 1, CELL_STYLE_CENTER);
		}
		
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
	
	private HSSFCellStyle getCellStyle (int rowNum, int collumnNum) {
		HSSFCell cell = this.getCell(rowNum, collumnNum);
		HSSFCellStyle cellStyle = cell.getCellStyle();
		return cellStyle;
	}
	
}
