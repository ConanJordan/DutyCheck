package com.jp.co.netwisdom.entity;

public class DutyEntity {
	
	private String name;
	private double dutyTime;
	private boolean isLate;
	private boolean isAbsent;
	private boolean isHoliday;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDutyTime() {
		return dutyTime;
	}
	public void setDutyTime(double dutyTime) {
		this.dutyTime = dutyTime;
	}
	public boolean isLate() {
		return isLate;
	}
	public void setLate(boolean isLate) {
		this.isLate = isLate;
	}
	public boolean isAbsent() {
		return isAbsent;
	}
	public void setAbsent(boolean isAbsent) {
		this.isAbsent = isAbsent;
	}
	public boolean isHoliday() {
		return isHoliday;
	}
	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

}
