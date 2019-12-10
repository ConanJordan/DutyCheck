package com.jp.co.netwisdom.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jp.co.netwisdom.entity.EmployeeEntity;
import com.jp.co.netwisdom.entity.NoteTableEntity;
import com.jp.co.netwisdom.entity.OutputResultEntity;

/**
 * 数据调整
 */
public class AdaptService {
 
	public OutputResultEntity adapt (
			EmployeeEntity employee, 
			List<NoteTableEntity> noteTables,
			int year,
			int month) {
		
		// 初始化返回值
		OutputResultEntity outputResult = new OutputResultEntity();
		
		List<NoteTableEntity> tempNoteTables = new ArrayList<NoteTableEntity>();
		
		// 获得当前月的实例化对象
		Calendar currentCal = Calendar.getInstance();
		
		// 设置当前年月
		currentCal.set(Calendar.YEAR, year);
		currentCal.set(Calendar.MONTH, month);
		
		currentCal.get(Calendar.SUNDAY);
		
		return null;
	}
	
}
