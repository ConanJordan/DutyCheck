package com.jp.co.netwisdom.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jp.co.netwisdom.config.Const;
import com.jp.co.netwisdom.entity.OutputResultEntity;
import com.jp.co.netwisdom.util.CalendarUtil;

/**
 * ����Excel�ļ�
 */
public class CreateExcel {
	
	private int year;
	private int month;
	private List<OutputResultEntity> outputResults;


	public CreateExcel(int year, int month,
			List<OutputResultEntity> outputResults) {
		super();
		this.year = year;
		this.month = month;
		this.outputResults = outputResults;
	}

	public HSSFWorkbook edit (){
		
		String sheetName = this.year + "��" + this.month + "�·��ڄձ�";
		
		WorkBook book = new WorkBook (sheetName, this.year, this.month, this.outputResults);
		
		book.initSheet();  // ��ʼ��Excel������
		
		book.edit();  // �༭Excel���������������
		
		return book.getBook();
	}
	
	public String create () throws IOException {
		String fileName = CalendarUtil.timeStamp() + "_" + this.year + "��" + this.month + "�·��ڄձ�.xls";
		File file = null;
		File directory = null;
		file = new File(Const.PATH_OUTPUT + fileName);
		directory = new File(Const.PATH_OUTPUT);
		if (directory.exists() == false) {
			directory.mkdirs();
		}
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			throw e;
		}
		
		return fileName;
	}
	
	public boolean save (String fileName, HSSFWorkbook book) throws IOException {
		boolean result = false;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(Const.PATH_OUTPUT + fileName);
			book.write(fos);
			result = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}
