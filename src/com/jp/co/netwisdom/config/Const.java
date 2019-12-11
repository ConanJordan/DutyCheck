package com.jp.co.netwisdom.config;

import com.jp.co.netwisdom.util.ReadUtil;

public final class Const {
	public static final String ADMINIST = "管理部";
	public static final String BUSINESS = "营业";
	public static final String TRAIN = "培训部";
	public static final String STUDY = "学习部";
	public static final String MALE = "男";
	public static final String FEMALE = "女";
	public static final String MARRIED = "已婚";
	public static final String UNMARRIED = "未婚";
	
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
			+ "请输入想要查询的年月。格式为YYYYMM.";
	
	public static final String YYYYMMDD_FORMAT = "yyyy-MM-dd";
	
	public static final String TIME_STAMP_FORMAT = "yyyyMMddHHmmSS";
	
	public static final Object[][] HOLLIDAYS = new Object[][]{
		// 種別, 月, 日or週, 開始年, 終了年, 祝日名
		{"fixed",   1,  1, 1949, 9999, "元日"},
        {"fixed",   1, 15, 1949, 1999, "成人の日"},
        {"happy",   1,  2, 2000, 9999, "成人の日"},
        {"fixed",   2, 11, 1967, 9999, "建国記念の日"},
        {"fixed",   2, 23, 2020, 9999, "天皇誕生日"},
        {"spring",  3,  22, 1949, 9999, "春分の日"},
        {"fixed",   4, 29, 1949, 1989, "天皇誕生日"},
        {"fixed",   4, 29, 1990, 2006, "みどりの日"},
        {"fixed",   4, 29, 2007, 9999, "昭和の日"},
        {"fixed",   5,  3, 1949, 9999, "憲法記念日"},
        {"fixed",   5,  4, 1988, 2006, "国民の休日"},
        {"fixed",   5,  4, 2007, 9999, "みどりの日"},
        {"fixed",   5,  5, 1949, 9999, "こどもの日"},
        {"happy",   7,  3, 2021, 9999, "海の日"},
        {"fixed",   7, 23, 2020, 2020, "海の日"},
        {"happy",   7,  3, 2003, 2019, "海の日"},
        {"fixed",   7, 20, 1996, 2002, "海の日"},
        {"fixed",   8, 11, 2021, 9999, "山の日"},
        {"fixed",   8, 10, 2020, 2020, "山の日"},
        {"fixed",   8, 11, 2016, 2019, "山の日"},
        {"autumn",  9,  22, 1948, 9999, "秋分の日"},
        {"fixed",   9, 15, 1966, 2002, "敬老の日"},
        {"happy",   9,  3, 2003, 9999, "敬老の日"},
        {"fixed",  10, 10, 1966, 1999, "体育の日"},
        {"happy",  10,  2, 2000, 2019, "体育の日"},
        {"fixed",   7, 24, 2020, 2020, "スポーツの日"},
        {"happy",  10,  2, 2021, 9999, "スポーツの日"},
        {"fixed",  11,  3, 1948, 9999, "文化の日"},
        {"fixed",  11, 23, 1948, 9999, "勤労感謝の日"},
        {"fixed",  12, 23, 1989, 2018, "天皇誕生日"},
        //以下、1年だけの祝日
        {"fixed",   4, 10, 1959, 1959, "皇太子明仁親王の結婚の儀"},
        {"fixed",   2, 24, 1989, 1989, "昭和天皇の大喪の礼"},
        {"fixed",  11, 12, 1990, 1990, "即位礼正殿の儀"},
        {"fixed",   6,  9, 1993, 1993, "皇太子徳仁親王の結婚の儀"},
        {"fixed",   5,  1, 2019, 2019, "天皇の即位の日"},
        {"fixed",  10, 22, 2019, 2019, "即位礼正殿の儀"}
	};
	
}
