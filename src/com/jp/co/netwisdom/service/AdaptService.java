package com.jp.co.netwisdom.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jp.co.netwisdom.entity.EmployeeEntity;
import com.jp.co.netwisdom.entity.NoteTableEntity;
import com.jp.co.netwisdom.entity.OutputResultEntity;

/**
 * ���ݵ���
 */
public class AdaptService {
 
	public OutputResultEntity adapt (
			EmployeeEntity employee, 
			List<NoteTableEntity> noteTables,
			int year,
			int month) {
		
		// ��ʼ������ֵ
		OutputResultEntity outputResult = new OutputResultEntity();
		
		List<NoteTableEntity> tempNoteTables = new ArrayList<NoteTableEntity>();
		
		// ��õ�ǰ�µ�ʵ��������
		Calendar currentCal = Calendar.getInstance();
		
		// ���õ�ǰ����
		currentCal.set(Calendar.YEAR, year);
		currentCal.set(Calendar.MONTH, month);
		
		currentCal.get(Calendar.SUNDAY);
		
		return null;
	}
	
}
