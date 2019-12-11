package com.jp.co.netwisdom.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jp.co.netwisdom.entity.DutyEntity;
import com.jp.co.netwisdom.entity.DutyStatisEntity;
import com.jp.co.netwisdom.entity.EmployeeEntity;
import com.jp.co.netwisdom.entity.NoteTableEntity;
import com.jp.co.netwisdom.entity.OutputResultEntity;
import com.jp.co.netwisdom.util.CalendarUtil;

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
		
		outputResult.setName(employee.getName());  // ������Աname
		
		/*if (noteTables.isEmpty()) {  // �򿨼�¼����Ϊ�յ�ʱ��
			return outputResult;
		}*/
		
		List<NoteTableEntity> tempNoteTables = new ArrayList<NoteTableEntity>();
		Calendar tempCal = Calendar.getInstance();
		
		// ��һ�δ�ʱ��
		String startTime;
		// ���һ�δ�ʱ��
		String endTime;
		
		// ���Ŀ�����µ�����
		int days = CalendarUtil.getDaysOfMonth(year, month);
		
		// ����noteTables���±�
		/*int j = 0;
		for (int i = 1; i <= days; i ++) {
			tempCal.setTime(noteTables.get(j).getCdt());
			if (tempCal.get(Calendar.DATE) == i) {
				tempNoteTables.add(noteTables.get(i));
				j ++;
			} else {
				DutyEntity duty = new DutyEntity();
				if (tempNoteTables.size() <= 1) {	
					duty.setException(true);
				} else {
					// ��ȡ��һ�κ����һ�δ򿨵�ʱ��
					startTime = tempNoteTables.get(0).getCti();
					endTime = tempNoteTables.get(tempNoteTables.size() - 1).getCti();
					duty.setDutyTime(CalendarUtil.timeDiffrence(startTime, endTime));
				}
				outputResult.getDuties();
			}
		}*/
		
		boolean isLoopable = true;
		// ����������
		int i = 1;
		// tempNoteTables�����±������
		//int j = 0;
		// ����ʱ��
		double hours;
		/*while (isLoopable) {
			DutyEntity duty = new DutyEntity();
			tempCal.setTime(noteTables.get(j).getCdt());
			if (tempCal.get(Calendar.DATE) == i) {
				tempNoteTables.add(noteTables.get(j));
				j ++;
			} else {
				if (tempNoteTables.size() <= 1) {	
					duty.setException(true);
				} else {
					// ��ȡ��һ�κ����һ�δ򿨵�ʱ��
					startTime = tempNoteTables.get(0).getCti();
					endTime = tempNoteTables.get(tempNoteTables.size() - 1).getCti();
					hours = CalendarUtil.timeDiffrence(startTime, endTime);
					duty.setDutyTime(hours);
					// �ٵ��ж�
					duty.setLate(CalendarUtil.isLate(startTime));
					// �����ж�
					duty.setEarly(CalendarUtil.isEarly(endTime));
				}				
				// �ѿ��ڶ������Ҫ���صĽ������
				outputResult.getDuties().add(duty);
				
				tempNoteTables.clear();  // �����ʱ����
				i ++;
			}
			if (i > days || j > noteTables.size()) {
				isLoopable = false;  // ѭ������
			}
		}*/
		
		while (isLoopable){
			DutyEntity duty = new DutyEntity();
			for (int k = 0; k < noteTables.size(); k ++) {
				tempCal.setTime(noteTables.get(k).getCdt());
				if (tempCal.get(Calendar.DATE) == i) {
					tempNoteTables.add(noteTables.get(k));
				}
			}
			if (tempNoteTables.size() <= 1) {	
				duty.setException(true);
			} else {
				// ��ȡ��һ�κ����һ�δ򿨵�ʱ��
				startTime = tempNoteTables.get(0).getCti();
				endTime = tempNoteTables.get(tempNoteTables.size() - 1).getCti();
				hours = CalendarUtil.timeDiffrence(startTime, endTime);
				duty.setDutyTime(hours);
				// �ٵ��ж�
				duty.setLate(CalendarUtil.isLate(startTime));
				// �����ж�
				duty.setEarly(CalendarUtil.isEarly(endTime));
			}
			
			outputResult.getDuties().add(duty);  // �ѿ��ڶ������Ҫ���صĽ������	
			tempNoteTables.clear();  // �����ʱ����
			i ++;  // ��������
			
			if (i > days) {
				isLoopable = false;
			}
		}
		
		// ���ÿ���ͳ��
		setDutyStatis(outputResult);
		
		return outputResult;
	}
	
	/**
	 * ���ÿ���ͳ��
	 * @param outputResult
	 */
	private void setDutyStatis (OutputResultEntity outputResult) {
		DutyStatisEntity dutyStatis = outputResult.getDutyStatis();
		for (DutyEntity duty : outputResult.getDuties()) {  // �ٵ����˻��쳣�����
			if (duty.isException() || duty.isLate() || duty.isEarly()) {
				dutyStatis.setLateEarly(dutyStatis.getLateEarly() + 1);
			}
			// ����ʱ���ۼ�
			dutyStatis.setDutyTime(dutyStatis.getDutyTime() + duty.getDutyTime());
		}
	}

}
