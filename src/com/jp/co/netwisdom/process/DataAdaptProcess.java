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
 * ���ݵ���
 * 1.��CardNo�����ݷ���
 * 2.���ݲ���1�ķ��������������ڽ����ٴη��鲢����
 * 3.����List<OutputResultDto>����ʽ�������Ϸ���
 */
public class DataAdaptProcess {

	/**
	 * ��
	 */
	private int year;
	
	/**
	 * ��
	 */
	private int month;
	
	/**
	 * ���ڽ��DTO
	 */
	private List<DutyNoteDto> dutyNotes;

	/**
	 * Ҫ��ӡ�Ľ�����ݼ���
	 */
	private List<OutputResultDto> outputResults;
	
	/**
	 * ����CardNo�����Map
	 * String:CardNo
	 * List<DutyNoteDto>
	 */
	private Map<String, List<DutyNoteDto>> cardNoMap = new HashMap<String, List<DutyNoteDto>>();
	
	/**
	 * ����CardNo����
	 */
	private void groupByCardNo () {
		for (DutyNoteDto dutyNote : this.dutyNotes) {
			if (this.cardNoMap.get(dutyNote.getName()) != null) {  // cardNoMap���и���Ա������Ϣ�Ļ�
				this.cardNoMap.get(dutyNote.getName()).add(dutyNote);
			} else {  // cardNoMap��û�и���Ա������Ϣ�Ļ�
				List<DutyNoteDto> dutyNoteList = new ArrayList<DutyNoteDto>();
				dutyNoteList.add(dutyNote);
			}
		}
	}
	
	/**
	 * ���ݴ�ʱ���������
	 */
	private void adaptByCdt () {
		
		// ����cardNoMap
		for (String key : this.cardNoMap.keySet()) {
			List<DutyNoteDto> dutyNoteList = this.cardNoMap.get(key);
			
			this.outputResults.add(this.createOutputResult(dutyNoteList));
			
		}
	}
	
	/**
	 * ���ݷ���õ�DutyNoteDto���ϣ����ɶ�Ӧ��OutputResultDto
	 * @param dutyNoteList
	 * @return
	 */
	private OutputResultDto createOutputResult (List<DutyNoteDto> dutyNoteList) {
		
		// ��ʼ������ֵ
		OutputResultDto outputResult = new OutputResultDto();
		
		// ��������������
		outputResult.setName(dutyNoteList.get(0).getName());
		outputResult.setDept(dutyNoteList.get(0).getDept());
		
		boolean isLoopable = true;
		int day = 1;  // ����ѭ��������
		int days = CalendarUtil.getDaysOfMonth(this.year, this.month);  // Ŀ��������
		Calendar tempCal = Calendar.getInstance();  // ��ʱCalendar��������ƥ������
		List<DutyNoteDto> tempDutyNotes = new ArrayList<DutyNoteDto>();  // ��ʱ���ϣ������洢ͬһ��򿨵�DutyNoteDto����
		
		while (isLoopable) {
			DutyDto duty = new DutyDto();  // �½����쿼�ڶ���
			
			for (int i = 0; i < dutyNoteList.size(); i ++) {
				DutyNoteDto dutyNote = dutyNoteList.get(i);
				tempCal.setTime(dutyNote.getCdt());
				if (tempCal.get(Calendar.DATE) == day) {  // �����뵱��һ��
					tempDutyNotes.add(dutyNote);
				}
			}  // forѭ������
			
			if (tempDutyNotes.size() == 0) {  // û�д򿨼�¼
				duty.setAbsent(true);  // ȱϯ
				duty.setException(true);  // �쳣
			} else if (tempDutyNotes.size() == 1) {  // ֻ��һ�δ򿨼�¼
				duty.setException(true);  // �쳣
			} else {  // �����μ�����
				// ���õ��쿼�ڽ��
				this.setDuty(tempDutyNotes, duty);
			} 
			
			outputResult.getDuties().add(duty);
			tempDutyNotes.clear();  // �����ʱ����
			
			// ���ÿ���ͳ��
			this.setDutyStatis(outputResult);
			
			day ++;
			
			if (day > days) {  // ѭ��������������������ʱ��
				isLoopable = false;  // whileѭ������
			}
		}
		
		return outputResult;
	}
	
	/**
	 * ���õ��쿼�ڽ��
	 * @param dutyNoteList:����Ĵ򿨶��󼯺�
	 * @param duty:���쿼�ڶ���
	 */
	private void setDuty (List<DutyNoteDto> dutyNoteList, DutyDto duty) {
		
		String startTime = dutyNoteList.get(0).getCti();
		String endTime = dutyNoteList.get(dutyNoteList.size() - 1).getCti();
		
		// �ٵ��ж�
		duty.setLate(CalendarUtil.isLate(startTime));
		
		// �����ж�
		duty.setEarly(CalendarUtil.isEarly(endTime));
		
		// ���õ��յĿ���ʱ��
		duty.setDutyTime(CalendarUtil.timeDiffrence(startTime, endTime));
		
	}
	
	/**
	 * ���ÿ���ͳ��
	 * @param outputResult
	 */
	private void setDutyStatis (OutputResultDto outputResult) {

		DutyStatisDto dutyStatis = outputResult.getDutyStatis();
		
		for (DutyDto duty : outputResult.getDuties()) {
			// ����ʱ��ͳ��
			dutyStatis.setDutyTime(dutyStatis.getDutyTime() + duty.getDutyTime());
			// ��������ͳ��
			if (duty.isAbsent() == false) {
				dutyStatis.setRealDay(dutyStatis.getRealDay() + 1);
			}
			// �ٵ�����ͳ��
			if (duty.isLate() || duty.isEarly()) {
				dutyStatis.setLateEarlyException(dutyStatis.getRealDay() + 1);
			}
		}
	}
	
	/**
	 * ��������
	 * @return
	 */
	public void adapt (){		
		this.groupByCardNo();
		this.adaptByCdt();
	}
	
}
