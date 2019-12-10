package com.jp.co.netwisdom.entity;

/**
 * 显示每一行的打印结果
 */
public class OutputResultEntity {

	private String name;
	private DutyEntity[] duties;
	private DutyStatisEntity dutyStatis;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DutyEntity[] getDuties() {
		return duties;
	}
	public void setDuties(DutyEntity[] duties) {
		this.duties = duties;
	}
	public DutyStatisEntity getDutyStatis() {
		return dutyStatis;
	}
	public void setDutyStatis(DutyStatisEntity dutyStatis) {
		this.dutyStatis = dutyStatis;
	}
	
	
}
