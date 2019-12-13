package com.jp.co.netwisdom.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * �������Ա���¿�����Ϣ��DTO��
 */
public class OutputResultDto {
	
	/**
	 * ����
	 */
	private String name;
	
	/**
	 * ����
	 */
	private String dept;
	
	/**
	 * ���쿼����Ϣ����
	 */
	private List<DutyDto> duties = new ArrayList<DutyDto>();
	
	/**
	 * ���¿���ͳ�Ƽ���
	 */
	private DutyStatisDto dutyStatis = new DutyStatisDto();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public List<DutyDto> getDuties() {
		return duties;
	}

	public void setDuties(List<DutyDto> duties) {
		this.duties = duties;
	}

	public DutyStatisDto getDutyStatis() {
		return dutyStatis;
	}

	public void setDutyStatis(DutyStatisDto dutyStatis) {
		this.dutyStatis = dutyStatis;
	}
	
}
