package com.kitri.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		
		//Calendar Class
		//get()
		//2019년 03월 26일 오후 01시 07분 35초
		
//		GregorianCalendar today = new GregorianCalendar();
//		int yyyy = today.get(today.YEAR);
//		int mm = today.get(today.MONTH)+1;
//		int dd = today.get(today.DAY_OF_MONTH);
//		int amNPm = today.get(today.AM_PM);
//		int h = today.get(today.HOUR);
//		int mi = today.get(today.MINUTE);
//		int ss = today.get(today.SECOND);
		
		Calendar cal = Calendar.getInstance();
		int y = cal.get(cal.YEAR);
		int m = cal.get(cal.MONTH)+1;
		int d = cal.get(cal.DAY_OF_MONTH);
		int apm = cal.get(cal.AM_PM);
		int h = cal.get(cal.HOUR);
		int mi = cal.get(cal.MINUTE);
		int s = cal.get(cal.SECOND);
				
		System.out.println(y + "년 " + zero(m) + "월 " + zero(d) + "일 " + 
				(apm == 0 ? "오전" : "오후") + " "+ zero(h) + "시 "+ zero(mi) + "분 " + zero(s) + "초");

		//처음부터 다시 해볼것

		
		
		
	}
	
	private static String zero(int num) {
		return num < 10 ? "0" + num : "" + num;
	}
	
	
	
	
	
}
