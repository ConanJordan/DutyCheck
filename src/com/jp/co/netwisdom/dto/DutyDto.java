package com.jp.co.netwisdom.dto;

/**
 * 当天考勤信息的DTO类
 */
public class DutyDto {
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 出勤时间
	 */
	private double dutyTime;
	
	/**
	 * 是否迟到
	 */
	private boolean isLate;
	
	/**
	 * 是否早退
	 */
	private boolean isEarly;
	
	/**
	 * 是否缺席
	 */
	private boolean isAbsent;
	
	/**
	 * 是否异常
	 */
	private boolean isException;
	
	public boolean isException() {
		return isException;
	}
	public void setException(boolean isException) {
		this.isException = isException;
	}
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

	public boolean isEarly() {
		return isEarly;
	}
	public void setEarly(boolean isEarly) {
		this.isEarly = isEarly;
	}

}
