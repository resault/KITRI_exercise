package com.kitri.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		
		//Calendar Class
		//get()
		//2019�� 03�� 26�� ���� 01�� 07�� 35��
		
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
				
		System.out.println(y + "�� " + zero(m) + "�� " + zero(d) + "�� " + 
				(apm == 0 ? "����" : "����") + " "+ zero(h) + "�� "+ zero(mi) + "�� " + zero(s) + "��");

		//ó������ �ٽ� �غ���

		
		
		
	}
	
	private static String zero(int num) {
		return num < 10 ? "0" + num : "" + num;
	}
	
	
	
	
	
}
