package com.jp.co.netwisdom.entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 签到表实体类
 *
 */
public class NoteTableEntity {
	
	private int mid;
	private long cardNo;
	private Date cdt;
	private String cti;
	private int nid;
	private Date idt;
	private BigDecimal money1;
	private BigDecimal money2;
	private String cid;
	private EmployeeEntity employee;
	
	public EmployeeEntity getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public Date getCdt() {
		return cdt;
	}
	public void setCdt(Date cdt) {
		this.cdt = cdt;
	}
	public String getCti() {
		return cti;
	}
	public void setCti(String cti) {
		this.cti = cti;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public Date getIdt() {
		return idt;
	}
	public void setIdt(Date idt) {
		this.idt = idt;
	}
	public BigDecimal getMoney1() {
		return money1;
	}
	public void setMoney1(BigDecimal money1) {
		this.money1 = money1;
	}
	public BigDecimal getMoney2() {
		return money2;
	}
	public void setMoney2(BigDecimal money2) {
		this.money2 = money2;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public NoteTableEntity(int mid, long cardNo, Date cdt, String cti, int nid,
			Date idt, BigDecimal money1, BigDecimal money2, String cid,
			EmployeeEntity employee) {
		super();
		this.mid = mid;
		this.cardNo = cardNo;
		this.cdt = cdt;
		this.cti = cti;
		this.nid = nid;
		this.idt = idt;
		this.money1 = money1;
		this.money2 = money2;
		this.cid = cid;
		this.employee = employee;
	}
	public NoteTableEntity() {
		super();
	}

}
