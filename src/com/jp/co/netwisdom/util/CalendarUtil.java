package com.jp.co.netwisdom.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.jp.co.netwisdom.config.Const;

public class CalendarUtil {
	
	/**
	 * ��ȡ�������µ�����
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDaysOfMonth (int year, int month) {
		
		int days = 0;
		
		// ���Ŀ���µ�ʵ��������
		Calendar currentCal = Calendar.getInstance();				
		// ����Ŀ������
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
		// ��õ�һ�δ�ʱ���ʱ����
		int startHour = Integer.parseInt(start.substring(0, 2));
		int startMinute = Integer.parseInt(start.substring(3, 5));
		int startSecond = Integer.parseInt(start.substring(6, 8));
		
		// ������һ�δ�ʱ���ʱ����
		int endHour = Integer.parseInt(end.substring(0, 2));
		int endMinute = Integer.parseInt(end.substring(3, 5));
		int endSecond = Integer.parseInt(end.substring(6, 8));
		
		Date today = new Date();
		
		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		
		startCal.setTime(today);
		endCal.setTime(today);
		
		// �ѵ�һ�δ򿨺����һ�δ򿨵�ʱ�������ø����Ե�Calendar
		startCal.set(Calendar.HOUR, startHour);
		startCal.set(Calendar.MINUTE, startMinute);
		startCal.set(Calendar.SECOND, startSecond);
		endCal.set(Calendar.HOUR, endHour);
		endCal.set(Calendar.MINUTE, endMinute);
		endCal.set(Calendar.SECOND, endSecond);
		
		// �����һ�κ����һ�δ���������
		long seconds = (endCal.getTimeInMillis() - startCal.getTimeInMillis()) / 1000;
		
		// ��������Сʱ��
		double hours = seconds / 60 / 60;
		
		if (startHour < 12 && hours > 1) {  // 12��֮ǰ��������Сʱ������1
			hours = hours - 1;  // ��ȥ���ʱ��
		}
		
		return hours;
	}
	
	/**
	 * �ٵ��ж�
	 * @param time
	 * @return
	 */
	public static boolean isLate (String time) {
		// ���Сʱ��
		int hour = Integer.parseInt(time.substring(0, 2));
		return hour >= 10;  // 10���Ժ���ٵ�
	}
	
	/**
	 * �����ж�
	 * @param time
	 * @return
	 */
	public static boolean isEarly (String time) {
		// ���Сʱ��
		int hour = Integer.parseInt(time.substring(0, 2));
		return hour < 18;  // 18����ǰ�뿪������
	}
	
	/**
	 * ף�դ��жϤ���
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public static boolean isHolliday (int year, int month, int date) {
		
		boolean result = false;
		
		Object[] holliday;  // ף��
		
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
	 * ���դ��жϤ���
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
	 * ��������·��ظ��µ�һ����ַ���
	 * ��ʽ��YYYY-MM-DD
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDay (int year, int month) {
		
		StringBuilder result = new StringBuilder("");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);  // ������
		calendar.set(Calendar.MONTH, month - 1);  // ������
		
		result.append(calendar.get(Calendar.YEAR));
		result.append("-");
		result.append(
				calendar.get(Calendar.MONTH) >= 9 ?
				(calendar.get(Calendar.MONTH) + 1) :
				"0" + (calendar.get(Calendar.MONTH) + 1)
				);
		result.append("-");
		result.append("01");
		
		return result.toString();  // ���ؽ���ַ���
	}
	
	/**
	 * ��������·��ظ������һ����ַ���
	 * ��ʽ��YYYY-MM-DD
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDay (int year, int month) {
		
		StringBuilder result = new StringBuilder("");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);  // ������
		calendar.set(Calendar.MONTH, month);  // ������
		calendar.set(Calendar.DATE, 0);  // ������
		
		result.append(calendar.get(Calendar.YEAR));
		result.append("-");
		result.append(
				calendar.get(Calendar.MONTH) >= 9 ?
				(calendar.get(Calendar.MONTH) + 1) :
				"0" + (calendar.get(Calendar.MONTH) + 1)
				);
		result.append("-");
		result.append(calendar.get(Calendar.DATE));
		
		return result.toString();  // ���ؽ���ַ���
	}
	
	/**
	 * �������ڸ�ʽ���ַ����͸�ʽ���ͷ������ڶ���
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
	 * ��ȡʱ�������ȷ����
	 * @return
	 */
	public static String timeStamp () {
		
		SimpleDateFormat sdf = new SimpleDateFormat(Const.TIME_STAMP_FORMAT);
		
		Date now = new Date();
		
		return sdf.format(now);
		
	}
	
}
