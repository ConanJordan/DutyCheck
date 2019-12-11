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
		
		outputResult.setName(employee.getName());  // 设置社员name
		
		/*if (noteTables.isEmpty()) {  // 打卡记录集合为空的时候
			return outputResult;
		}*/
		
		List<NoteTableEntity> tempNoteTables = new ArrayList<NoteTableEntity>();
		Calendar tempCal = Calendar.getInstance();
		
		// 第一次打卡时间
		String startTime;
		// 最后一次打卡时间
		String endTime;
		
		// 获得目标年月的天数
		int days = CalendarUtil.getDaysOfMonth(year, month);
		
		// 用于noteTables的下标
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
					// 获取第一次和最后一次打卡的时间
					startTime = tempNoteTables.get(0).getCti();
					endTime = tempNoteTables.get(tempNoteTables.size() - 1).getCti();
					duty.setDutyTime(CalendarUtil.timeDiffrence(startTime, endTime));
				}
				outputResult.getDuties();
			}
		}*/
		
		boolean isLoopable = true;
		// 日数计数器
		int i = 1;
		// tempNoteTables集合下标计数器
		//int j = 0;
		// 考勤时间
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
					// 获取第一次和最后一次打卡的时间
					startTime = tempNoteTables.get(0).getCti();
					endTime = tempNoteTables.get(tempNoteTables.size() - 1).getCti();
					hours = CalendarUtil.timeDiffrence(startTime, endTime);
					duty.setDutyTime(hours);
					// 迟到判断
					duty.setLate(CalendarUtil.isLate(startTime));
					// 早退判断
					duty.setEarly(CalendarUtil.isEarly(endTime));
				}				
				// 把考勤对象放入要返回的结果集中
				outputResult.getDuties().add(duty);
				
				tempNoteTables.clear();  // 清空临时集合
				i ++;
			}
			if (i > days || j > noteTables.size()) {
				isLoopable = false;  // 循环结束
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
				// 获取第一次和最后一次打卡的时间
				startTime = tempNoteTables.get(0).getCti();
				endTime = tempNoteTables.get(tempNoteTables.size() - 1).getCti();
				hours = CalendarUtil.timeDiffrence(startTime, endTime);
				duty.setDutyTime(hours);
				// 迟到判断
				duty.setLate(CalendarUtil.isLate(startTime));
				// 早退判断
				duty.setEarly(CalendarUtil.isEarly(endTime));
			}
			
			outputResult.getDuties().add(duty);  // 把考勤对象放入要返回的结果集中	
			tempNoteTables.clear();  // 清空临时集合
			i ++;  // 天数递增
			
			if (i > days) {
				isLoopable = false;
			}
		}
		
		// 设置考勤统计
		setDutyStatis(outputResult);
		
		return outputResult;
	}
	
	/**
	 * 设置考勤统计
	 * @param outputResult
	 */
	private void setDutyStatis (OutputResultEntity outputResult) {
		DutyStatisEntity dutyStatis = outputResult.getDutyStatis();
		for (DutyEntity duty : outputResult.getDuties()) {  // 迟到早退或异常的情况
			if (duty.isException() || duty.isLate() || duty.isEarly()) {
				dutyStatis.setLateEarly(dutyStatis.getLateEarly() + 1);
			}
			// 出勤时间累计
			dutyStatis.setDutyTime(dutyStatis.getDutyTime() + duty.getDutyTime());
		}
	}

}
