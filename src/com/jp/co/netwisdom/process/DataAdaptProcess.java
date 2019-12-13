package com.jp.co.netwisdom.process;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jp.co.netwisdom.dto.DutyDto;
import com.jp.co.netwisdom.dto.DutyNoteDto;
import com.jp.co.netwisdom.dto.DutyStatisDto;
import com.jp.co.netwisdom.dto.OutputResultDto;
import com.jp.co.netwisdom.util.CalendarUtil;

/**
 * 数据调整
 * 1.用CardNo将数据分组
 * 2.根据步骤1的分类结果，按照日期进行再次分组并处理
 * 3.依照List<OutputResultDto>的形式，将集合返回
 */
public class DataAdaptProcess {

	/**
	 * 年
	 */
	private int year;
	
	/**
	 * 月
	 */
	private int month;
	
	/**
	 * 考勤结果DTO
	 */
	private List<DutyNoteDto> dutyNotes;

	/**
	 * 要打印的结果数据集合
	 */
	private List<OutputResultDto> outputResults;
	
	/**
	 * 根据CardNo分组的Map
	 * String:CardNo
	 * List<DutyNoteDto>
	 */
	private Map<String, List<DutyNoteDto>> cardNoMap = new HashMap<String, List<DutyNoteDto>>();
	
	/**
	 * 根据CardNo分组
	 */
	private void groupByCardNo () {
		for (DutyNoteDto dutyNote : this.dutyNotes) {
			if (this.cardNoMap.get(dutyNote.getName()) != null) {  // cardNoMap里有该社员考勤信息的话
				this.cardNoMap.get(dutyNote.getName()).add(dutyNote);
			} else {  // cardNoMap里没有该社员考勤信息的话
				List<DutyNoteDto> dutyNoteList = new ArrayList<DutyNoteDto>();
				dutyNoteList.add(dutyNote);
			}
		}
	}
	
	/**
	 * 根据打卡时间调整数据
	 */
	private void adaptByCdt () {
		
		// 遍历cardNoMap
		for (String key : this.cardNoMap.keySet()) {
			List<DutyNoteDto> dutyNoteList = this.cardNoMap.get(key);
			
			this.outputResults.add(this.createOutputResult(dutyNoteList));
			
		}
	}
	
	/**
	 * 根据分组好的DutyNoteDto集合，生成对应的OutputResultDto
	 * @param dutyNoteList
	 * @return
	 */
	private OutputResultDto createOutputResult (List<DutyNoteDto> dutyNoteList) {
		
		// 初始化返回值
		OutputResultDto outputResult = new OutputResultDto();
		
		// 设置姓名，部门
		outputResult.setName(dutyNoteList.get(0).getName());
		outputResult.setDept(dutyNoteList.get(0).getDept());
		
		boolean isLoopable = true;
		int day = 1;  // 用于循环的天数
		int days = CalendarUtil.getDaysOfMonth(this.year, this.month);  // 目标月天数
		Calendar tempCal = Calendar.getInstance();  // 临时Calendar对象，用来匹配日期
		List<DutyNoteDto> tempDutyNotes = new ArrayList<DutyNoteDto>();  // 临时集合，用来存储同一天打卡的DutyNoteDto对象
		
		while (isLoopable) {
			DutyDto duty = new DutyDto();  // 新建当天考勤对象
			
			for (int i = 0; i < dutyNoteList.size(); i ++) {
				DutyNoteDto dutyNote = dutyNoteList.get(i);
				tempCal.setTime(dutyNote.getCdt());
				if (tempCal.get(Calendar.DATE) == day) {  // 日期与当天一致
					tempDutyNotes.add(dutyNote);
				}
			}  // for循环结束
			
			if (tempDutyNotes.size() == 0) {  // 没有打卡记录
				duty.setAbsent(true);  // 缺席
				duty.setException(true);  // 异常
			} else if (tempDutyNotes.size() == 1) {  // 只有一次打卡记录
				duty.setException(true);  // 异常
			} else {  // 打卡两次及以上
				// 设置当天考勤结果
				this.setDuty(tempDutyNotes, duty);
			} 
			
			outputResult.getDuties().add(duty);
			tempDutyNotes.clear();  // 清空临时集合
			
			// 设置考勤统计
			this.setDutyStatis(outputResult);
			
			day ++;
			
			if (day > days) {  // 循环天数超过当月天数的时候
				isLoopable = false;  // while循环结束
			}
		}
		
		return outputResult;
	}
	
	/**
	 * 设置当天考勤结果
	 * @param dutyNoteList:当天的打卡对象集合
	 * @param duty:当天考勤对象
	 */
	private void setDuty (List<DutyNoteDto> dutyNoteList, DutyDto duty) {
		
		String startTime = dutyNoteList.get(0).getCti();
		String endTime = dutyNoteList.get(dutyNoteList.size() - 1).getCti();
		
		// 迟到判断
		duty.setLate(CalendarUtil.isLate(startTime));
		
		// 早退判断
		duty.setEarly(CalendarUtil.isEarly(endTime));
		
		// 设置当日的考勤时间
		duty.setDutyTime(CalendarUtil.timeDiffrence(startTime, endTime));
		
	}
	
	/**
	 * 设置考勤统计
	 * @param outputResult
	 */
	private void setDutyStatis (OutputResultDto outputResult) {

		DutyStatisDto dutyStatis = outputResult.getDutyStatis();
		
		for (DutyDto duty : outputResult.getDuties()) {
			// 出勤时间统计
			dutyStatis.setDutyTime(dutyStatis.getDutyTime() + duty.getDutyTime());
			// 出勤天数统计
			if (duty.isAbsent() == false) {
				dutyStatis.setRealDay(dutyStatis.getRealDay() + 1);
			}
			// 迟到早退统计
			if (duty.isLate() || duty.isEarly()) {
				dutyStatis.setLateEarlyException(dutyStatis.getRealDay() + 1);
			}
		}
	}
	
	/**
	 * 调整数据
	 * @return
	 */
	public void adapt (){		
		this.groupByCardNo();
		this.adaptByCdt();
	}
	
}
