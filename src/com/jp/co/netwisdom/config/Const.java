package com.jp.co.netwisdom.config;

import com.jp.co.netwisdom.util.ReadUtil;

public final class Const {
	public static final String ADMINIST = "����";
	public static final String BUSINESS = "Ӫҵ";
	public static final String TRAIN = "��ѵ��";
	public static final String STUDY = "ѧϰ��";
	public static final String MALE = "��";
	public static final String FEMALE = "Ů";
	public static final String MARRIED = "�ѻ�";
	public static final String UNMARRIED = "δ��";
	
	public static final String JDBC_DRIVER = ReadUtil.getProperty("JDBC_DRIVER");
	public static final String URL = ReadUtil.getProperty("URL");
	public static final String USERNAME = ReadUtil.getProperty("USERNAME");
	public static final String PASSWORD = ReadUtil.getProperty("PASSWORD");
	
	public static final String SQL_SELECT_ALL_EMPLYEES = ""
			+ "SELECT ID, NAME, DEPT, CARDNO "
			+ "FROM EMPLOYEE";
	
	public static final String SQL_SELECT_NOTE_TABLE = ""
			+ "SELECT CARDNO, CTI, CDT "
			+ "FROM NOTETABLE ";
	
	public static final String PLEASE_INPUT_YEAR_MONTH = ""
			+ "��������Ҫ��ѯ�����¡���ʽΪYYYYMM.";
	
	public static final String YYYYMMDD_FORMAT = "yyyy-MM-dd";
	
	public static final String TIME_STAMP_FORMAT = "yyyyMMddHHmmSS";
	
	public static final Object[][] HOLLIDAYS = new Object[][]{
		// �N�e, ��, ��or�L, �_ʼ��, �K����, ף����
		{"fixed",   1,  1, 1949, 9999, "Ԫ��"},
        {"fixed",   1, 15, 1949, 1999, "���ˤ���"},
        {"happy",   1,  2, 2000, 9999, "���ˤ���"},
        {"fixed",   2, 11, 1967, 9999, "����ӛ�����"},
        {"fixed",   2, 23, 2020, 9999, "����Q����"},
        {"spring",  3,  22, 1949, 9999, "���֤���"},
        {"fixed",   4, 29, 1949, 1989, "����Q����"},
        {"fixed",   4, 29, 1990, 2006, "�ߤɤ����"},
        {"fixed",   4, 29, 2007, 9999, "�Ѻͤ���"},
        {"fixed",   5,  3, 1949, 9999, "����ӛ����"},
        {"fixed",   5,  4, 1988, 2006, "���������"},
        {"fixed",   5,  4, 2007, 9999, "�ߤɤ����"},
        {"fixed",   5,  5, 1949, 9999, "���ɤ����"},
        {"happy",   7,  3, 2021, 9999, "������"},
        {"fixed",   7, 23, 2020, 2020, "������"},
        {"happy",   7,  3, 2003, 2019, "������"},
        {"fixed",   7, 20, 1996, 2002, "������"},
        {"fixed",   8, 11, 2021, 9999, "ɽ����"},
        {"fixed",   8, 10, 2020, 2020, "ɽ����"},
        {"fixed",   8, 11, 2016, 2019, "ɽ����"},
        {"autumn",  9,  22, 1948, 9999, "��֤���"},
        {"fixed",   9, 15, 1966, 2002, "���Ϥ���"},
        {"happy",   9,  3, 2003, 9999, "���Ϥ���"},
        {"fixed",  10, 10, 1966, 1999, "��������"},
        {"happy",  10,  2, 2000, 2019, "��������"},
        {"fixed",   7, 24, 2020, 2020, "���ݩ`�Ĥ���"},
        {"happy",  10,  2, 2021, 9999, "���ݩ`�Ĥ���"},
        {"fixed",  11,  3, 1948, 9999, "�Ļ�����"},
        {"fixed",  11, 23, 1948, 9999, "�ڄ����x����"},
        {"fixed",  12, 23, 1989, 2018, "����Q����"},
        //���¡�1�������ף��
        {"fixed",   4, 10, 1959, 1959, "��̫�������H���νY��΃x"},
        {"fixed",   2, 24, 1989, 1989, "�Ѻ���ʤδ�ʤ���"},
        {"fixed",  11, 12, 1990, 1990, "��λ������΃x"},
        {"fixed",   6,  9, 1993, 1993, "��̫�ӏ����H���νY��΃x"},
        {"fixed",   5,  1, 2019, 2019, "��ʤμ�λ����"},
        {"fixed",  10, 22, 2019, 2019, "��λ������΃x"}
	};
	
}
