package com.jp.co.netwisdom.dto;

/**
 * ���쿼����Ϣ��DTO��
 */
public class DutyDto {
	
	/**
	 * ����
	 */
	private String name;
	
	/**
	 * ����ʱ��
	 */
	private double dutyTime;
	
	/**
	 * �Ƿ�ٵ�
	 */
	private boolean isLate;
	
	/**
	 * �Ƿ�����
	 */
	private boolean isEarly;
	
	/**
	 * �Ƿ�ȱϯ
	 */
	private boolean isAbsent;
	
	/**
	 * �Ƿ��쳣
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
