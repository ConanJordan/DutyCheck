package com.jp.co.netwisdom.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.jp.co.netwisdom.config.Const;

public class CalendarUtil {
	
	/**
	 * 获取给定年月的天数
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDaysOfMonth (int year, int month) {
		
		int days = 0;
		
		// 获得目标月的实例化对象
		Calendar currentCal = Calendar.getInstance();				
		// 设置目标年月
		currentCal.set(Calendar.YEAR, year);
		currentCal.set(Calendar.MONTH, month - 1);
		
		switch (currentCal.get(Calendar.MONTH)) {
			case Calendar.JANUARY :
				days = 31;
				break;
			case Calendar.FEBRUARY :
			if (year % 400 == 0) {
				days = 29;
			} else if (year % 4 == 0 && year % 100 != 0) {
				days = 29;
			} else {
				days = 28;
			}
				days = 31;
				break;
			case Calendar.MARCH :
				days = 31;
				break;
			case Calendar.APRIL :
				days = 30;
				break;
			case Calendar.MAY :
				days = 31;
				break;
			case Calendar.JUNE :
				days = 30;
				break;
			case Calendar.JULY :
				days = 31;
				break;
			case Calendar.AUGUST :
				days = 31;
				break;
			case Calendar.SEPTEMBER :
				days = 30;
				break;
			case Calendar.OCTOBER :
				days = 31;
				break;
			case Calendar.NOVEMBER :
				days = 30;
				break;
			case Calendar.DECEMBER :
				days = 31;
				break;
		}
		
		return days;
	}
	
	public static double timeDiffrence (String start, String end) {
		// 获得第一次打开时间的时分秒
		int startHour = Integer.parseInt(start.substring(0, 2));
		int startMinute = Integer.parseInt(start.substring(3, 5));
		int startSecond = Integer.parseInt(start.substring(6, 8));
		
		// 获得最后一次打卡时间的时分秒
		int endHour = Integer.parseInt(end.substring(0, 2));
		int endMinute = Integer.parseInt(end.substring(3, 5));
		int endSecond = Integer.parseInt(end.substring(6, 8));
		
		Date today = new Date();
		
		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		
		startCal.setTime(today);
		endCal.setTime(today);
		
		// 把第一次打卡和最后一次打卡的时分秒设置给各自的Calendar
		startCal.set(Calendar.HOUR, startHour);
		startCal.set(Calendar.MINUTE, startMinute);
		startCal.set(Calendar.SECOND, startSecond);
		endCal.set(Calendar.HOUR, endHour);
		endCal.set(Calendar.MINUTE, endMinute);
		endCal.set(Calendar.SECOND, endSecond);
		
		// 计算第一次和最后一次打卡相差的秒数
		long seconds = (endCal.getTimeInMillis() - startCal.getTimeInMillis()) / 1000;
		
		// 计算相差的小时数
		double hours = seconds / 60 / 60;
		
		if (startHour < 12 && hours > 1) {  // 12点之前来且相差的小时数大于1
			hours = hours - 1;  // 减去午餐时间
		}
		
		return hours;
	}
	
	/**
	 * 迟到判断
	 * @param time
	 * @return
	 */
	public static boolean isLate (String time) {
		// 获得小时数
		int hour = Integer.parseInt(time.substring(0, 2));
		return hour >= 10;  // 10点以后到算迟到
	}
	
	/**
	 * 早退判断
	 * @param time
	 * @return
	 */
	public static boolean isEarly (String time) {
		// 获得小时数
		int hour = Integer.parseInt(time.substring(0, 2));
		return hour < 18;  // 18点以前离开算早退
	}
	
	/**
	 * 祝日を判断する
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public static boolean isHolliday (int year, int month, int date) {
		
		boolean result = false;
		
		Object[] holliday;  // 祝日
		
		for (int i = 0; i <= Const.HOLLIDAYS.length; i ++) {
			holliday = Const.HOLLIDAYS[i];
			if (holliday[1].equals(month)
				&& holliday[2].equals(date)
				&& (int)holliday[3] <= year
				&& (int)holliday[4] >= year) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * 土日を判断する
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public static boolean isWeekend (int year, int month, int date) {
		boolean result = false;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, date);
		switch (calendar.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.MONDAY :
			case Calendar.TUESDAY :
			case Calendar.WEDNESDAY :
			case Calendar.THURSDAY :
			case Calendar.FRIDAY :
				break;
			case Calendar.SATURDAY :
			case Calendar.SUNDAY :
				result = true;
				
		}
		return result;
	}
	
	/**
	 * 根据年和月返回该月第一天的字符串
	 * 格式：YYYY-MM-DD
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDay (int year, int month) {
		
		StringBuilder result = new StringBuilder("");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);  // 设置年
		calendar.set(Calendar.MONTH, month - 1);  // 设置月
		
		result.append(calendar.get(Calendar.YEAR));
		result.append("-");
		result.append(
				calendar.get(Calendar.MONTH) >= 9 ?
				(calendar.get(Calendar.MONTH) + 1) :
				"0" + (calendar.get(Calendar.MONTH) + 1)
				);
		result.append("-");
		result.append("01");
		
		return result.toString();  // 返回结果字符串
	}
	
	/**
	 * 根据年和月返回该月最后一天的字符串
	 * 格式：YYYY-MM-DD
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDay (int year, int month) {
		
		StringBuilder result = new StringBuilder("");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);  // 设置年
		calendar.set(Calendar.MONTH, month);  // 设置月
		calendar.set(Calendar.DATE, 0);  // 设置日
		
		result.append(calendar.get(Calendar.YEAR));
		result.append("-");
		result.append(
				calendar.get(Calendar.MONTH) >= 9 ?
				(calendar.get(Calendar.MONTH) + 1) :
				"0" + (calendar.get(Calendar.MONTH) + 1)
				);
		result.append("-");
		result.append(calendar.get(Calendar.DATE));
		
		return result.toString();  // 返回结果字符串
	}
	
	/**
	 * 根据日期格式的字符串和格式类型返回日期对象
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static Date strToDate (String strDate, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}
	
	/**
	 * 获取时间戳：精确到秒
	 * @return
	 */
	public static String timeStamp () {
		
		SimpleDateFormat sdf = new SimpleDateFormat(Const.TIME_STAMP_FORMAT);
		
		Date now = new Date();
		
		return sdf.format(now);
		
	}
	
}
