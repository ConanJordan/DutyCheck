package com.jp.co.netwisdom.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 显示每一行的打印结果
 */
public class OutputResultEntity {

	private String name;
	private List<DutyEntity> duties = new ArrayList<DutyEntity>();
	private DutyStatisEntity dutyStatis = new DutyStatisEntity();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DutyStatisEntity getDutyStatis() {
		return dutyStatis;
	}
	public void setDutyStatis(DutyStatisEntity dutyStatis) {
		this.dutyStatis = dutyStatis;
	}
	public List<DutyEntity> getDuties() {
		return duties;
	}
	public void setDuties(List<DutyEntity> duties) {
		this.duties = duties;
	}
}
