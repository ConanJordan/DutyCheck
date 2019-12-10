package com.jp.co.netwisdom.util;

import java.util.Calendar;
import java.util.Date;

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
		int startSecond = Integer.parseInt(start.substring(6));
		
		// 获得最后一次打卡时间的时分秒
		int endHour = Integer.parseInt(end.substring(0, 2));
		int endMinute = Integer.parseInt(end.substring(3, 5));
		int endSecond = Integer.parseInt(end.substring(6));
		
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
		
		if (!isLate(start) && hours > 1) {  // 没有迟到且相差的小时数大于1
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
		return hour >= 12;  // 12点以后到算迟到
	}
	
	/**
	 * 早退判断
	 * @param time
	 * @return
	 */
	public static boolean isEarly (String time) {
		// 获得小时数
		int hour = Integer.parseInt(time.substring(0, 2));
		return hour < 19;  // 19点以前离开算早退
	}
	
}
