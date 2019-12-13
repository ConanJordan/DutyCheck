package com.jp.co.netwisdom.dto;

import java.util.List;

/**
 * 输出该社员当月考勤信息的DTO类
 */
public class OutputResultDto {
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 部门
	 */
	private String dept;
	
	/**
	 * 当天考勤信息集合
	 */
	private List<DutyDto> duties;
	
	/**
	 * 当月考勤统计集合
	 */
	private DutyStatisDto dutyStatis;

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
