package com.jp.co.netwisdom.dto;

/**
 * ���¿���ͳ�Ƶ�DTO��
 */
public class DutyStatisDto {
	
	/**
	 * ����
	 */
	private String name;
	
	/**
	 * Ԥ�Ƴ�������
	 */
	private int predictDay;
	
	/**
	 * ʵ�ʳ�������
	 */
	private int realDay;
	
	/**
	 * �ۼƳ���ʱ��
	 */
	private double dutyTime;
	
	/**
	 * �ٵ����˻��쳣�Ĵ���
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
