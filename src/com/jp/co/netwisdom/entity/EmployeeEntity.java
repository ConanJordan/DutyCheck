package com.jp.co.netwisdom.entity;

import java.sql.Date;

/**
 * 员工表实体类
 *
 */
public class EmployeeEntity {
	
	private String id;
	private String name;
	private String dept;
	private String cardNo;
	private String sex;
	private String marry;
	private String nation;
	private String home;
	private Date birthday;
	private String idCard;
	private String educat;
	private String post;
	private String addr;
	private String tel;
	private Date sDate;
	private Date eDate;
	private String photo;
	private String remark;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMarry() {
		return marry;
	}
	public void setMarry(String marry) {
		this.marry = marry;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEducat() {
		return educat;
	}
	public void setEducat(String educat) {
		this.educat = educat;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	public Date geteDate() {
		return eDate;
	}
	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public EmployeeEntity(String id, String name, String dept, String cardNo,
			String sex, String marry, String nation, String home,
			Date birthday, String idCard, String educat, String post,
			String addr, String tel, Date sDate, Date eDate, String photo,
			String remark) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.cardNo = cardNo;
		this.sex = sex;
		this.marry = marry;
		this.nation = nation;
		this.home = home;
		this.birthday = birthday;
		this.idCard = idCard;
		this.educat = educat;
		this.post = post;
		this.addr = addr;
		this.tel = tel;
		this.sDate = sDate;
		this.eDate = eDate;
		this.photo = photo;
		this.remark = remark;
	}
	public EmployeeEntity() {
		super();
	}
	
}
