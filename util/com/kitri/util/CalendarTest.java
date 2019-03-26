package com.kitri.util;

import java.util.Calendar;
import java.util.Date;


public class CalendarTest {

	public static void main(String[] args) {
		// 1. 하위 클래스 참조
		// Calendar cal = new GregorianCalendar();

		// 2. 자신의 객체를 return 하는 static method.
		Calendar cal = Calendar.getInstance();

		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DATE);
		int apm = cal.get(Calendar.AM_PM);
		int h = cal.get(Calendar.HOUR);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		System.out.println(y + "년 " + zeroPlus(m) + "월 " + 
				zeroPlus(d) + "일 " + (apm == 0 ? "오전 " : "오후 ") + 
				zeroPlus(h) + "시 " + zeroPlus(mi) + "분 " + zeroPlus(s) + "초");

		// 2019년 03월 06일 오후 01시 07분 05초
		
		Date date = new Date();
		System.out.println(date.toString());
	}
	
	private static String zeroPlus(int num) {
		return num < 10 ? "0" + num : "" + num;
	}

}
