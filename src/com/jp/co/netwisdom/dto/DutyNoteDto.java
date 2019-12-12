package com.jp.co.netwisdom.dto;

/**
 * 员工信息和打卡信息连接查询的DTO
 */
public class DutyNoteDto {
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 卡号
	 */
	private String cardNo;
	
	/**
	 * 打卡日期
	 */
	private java.sql.Date cdt;
	
	/**
	 * 打卡时间
	 */
	private String cti;

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

}
