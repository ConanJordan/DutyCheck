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
			+ "SELECT CARDNO, CTI, CDT "
			+ "FROM NOTETABLE "
			+ "WHERE CARDNO = ? "
			+ "AND CDT BETWEEN ? AND ?";
	
	public static final String PLEASE_INPUT_YEAR_MONTH = ""
			+ "请输入想要查询的年月。格式为YYYYMM.";
	
}
