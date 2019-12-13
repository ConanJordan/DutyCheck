package com.jp.co.netwisdom.dto;

import java.sql.Date;

/**
 * Ա����Ϣ�ʹ���Ϣ���Ӳ�ѯ��DTO
 */
public class DutyNoteDto {
	/**
	 * ����
	 */
	private String name;
	
	/**
	 * ����
	 */
	private String cardNo;
	
	/**
	 * ������
	 */
	private java.sql.Date cdt;
	
	/**
	 * ��ʱ��
	 */
	private String cti;

	/**
	 * ����
	 */
	private String dept;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public java.sql.Date getCdt() {
		return cdt;
	}

	public void setCdt(java.sql.Date cdt) {
		this.cdt = cdt;
	}

	public String getCti() {
		return cti;
	}

	public void setCti(String cti) {
		this.cti = cti;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public DutyNoteDto(String name, String cardNo, Date cdt, String cti,
			String dept) {
		super();
		this.name = name;
		this.cardNo = cardNo;
		this.cdt = cdt;
		this.cti = cti;
		this.dept = dept;
	}

	public DutyNoteDto() {
		super();
	}

}
