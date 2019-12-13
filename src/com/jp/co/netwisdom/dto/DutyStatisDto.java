package com.jp.co.netwisdom.dto;

/**
 * 当月考勤统计的DTO类
 */
public class DutyStatisDto {
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 预计出勤天数
	 */
	private int predictDay;
	
	/**
	 * 实际出勤天数
	 */
	private int realDay;
	
	/**
	 * 累计出勤时长
	 */
	private double dutyTime;
	
	/**
	 * 迟到早退或异常的次数
	 */
	private int lateEarlyException;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPredictDay() {
		return predictDay;
	}

	public void setPredictDay(int predictDay) {
		this.predictDay = predictDay;
	}

	public int getRealDay() {
		return realDay;
	}

	public void setRealDay(int realDay) {
		this.realDay = realDay;
	}

	public double getDutyTime() {
		return dutyTime;
	}

	public void setDutyTime(double dutyTime) {
		this.dutyTime = dutyTime;
	}

	public int getLateEarlyException() {
		return lateEarlyException;
	}

	public void setLateEarlyException(int lateEarlyException) {
		this.lateEarlyException = lateEarlyException;
	}
	
	
}
