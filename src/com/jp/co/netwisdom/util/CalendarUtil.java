package com.jp.co.netwisdom.util;

import java.util.Calendar;
import java.util.Date;

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
		int startSecond = Integer.parseInt(start.substring(6));
		
		// ������һ�δ�ʱ���ʱ����
		int endHour = Integer.parseInt(end.substring(0, 2));
		int endMinute = Integer.parseInt(end.substring(3, 5));
		int endSecond = Integer.parseInt(end.substring(6));
		
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
		
		if (!isLate(start) && hours > 1) {  // û�гٵ�������Сʱ������1
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
		return hour >= 12;  // 12���Ժ���ٵ�
	}
	
	/**
	 * �����ж�
	 * @param time
	 * @return
	 */
	public static boolean isEarly (String time) {
		// ���Сʱ��
		int hour = Integer.parseInt(time.substring(0, 2));
		return hour < 19;  // 19����ǰ�뿪������
	}
	
}
