package com.jp.co.netwisdom.entity;

public class DutyStatisEntity {
	
	private String name;
	private int predictDay;
	private int realDay;
	private double dutyTime;
	private int lateEarly;
	
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
	public int getLateEarly() {
		return lateEarly;
	}
	public void setLateEarly(int lateEarly) {
		this.lateEarly = lateEarly;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
