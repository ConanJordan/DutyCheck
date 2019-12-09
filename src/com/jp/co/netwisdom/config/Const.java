package com.jp.co.netwisdom.config;

public final class Const {
	public static final String ADMINIST = "管理部";
	public static final String BUSINESS = "营业";
	public static final String TRAIN = "培训部";
	public static final String STUDY = "学习部";
	public static final String MALE = "男";
	public static final String FEMALE = "女";
	public static final String MARRIED = "已婚";
	public static final String UNMARRIED = "未婚";
	
	public static final String SQL_SELECT_ALL_EMPLYEES = ""
			+ "SELECT ID, NAME, DETP, CARDNO "
			+ "FROM EMPLOYEE";
	
	public static final String SQL_SELECT_NOTE_TABLE = ""
			+ "SELECT CARDNO, CTI, IDT "
			+ "FROM NOTETABLE "
			+ "WHERE CARDNO = ? "
			+ "AND IDT BETWEEN ? AND ?";
}
