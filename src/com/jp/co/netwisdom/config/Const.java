package com.jp.co.netwisdom.config;

public final class Const {
	public static final String ADMINIST = "����";
	public static final String BUSINESS = "Ӫҵ";
	public static final String TRAIN = "��ѵ��";
	public static final String STUDY = "ѧϰ��";
	public static final String MALE = "��";
	public static final String FEMALE = "Ů";
	public static final String MARRIED = "�ѻ�";
	public static final String UNMARRIED = "δ��";
	
	public static final String SQL_SELECT_ALL_EMPLYEES = ""
			+ "SELECT ID, NAME, DETP, CARDNO "
			+ "FROM EMPLOYEE";
	
	public static final String SQL_SELECT_NOTE_TABLE = ""
			+ "SELECT CARDNO, CTI, CDT "
			+ "FROM NOTETABLE "
			+ "WHERE CARDNO = ? "
			+ "AND CDT BETWEEN ? AND ?";
	
	public static final String PLEASE_INPUT_YEAR_MONTH = ""
			+ "��������Ҫ��ѯ�����¡���ʽΪYYYYMM.";
	
}
