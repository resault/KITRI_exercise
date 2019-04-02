package com.kitri.util;

import java.util.Calendar;
import java.util.Date;


public class CalendarTest {

	public static void main(String[] args) {
		// 1. ���� Ŭ���� ����
		// Calendar cal = new GregorianCalendar();

		// 2. �ڽ��� ��ü�� return �ϴ� static method.
		Calendar cal = Calendar.getInstance();

		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DATE);
		int apm = cal.get(Calendar.AM_PM);
		int h = cal.get(Calendar.HOUR);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		System.out.println(y + "�� " + zeroPlus(m) + "�� " + 
				zeroPlus(d) + "�� " + (apm == 0 ? "���� " : "���� ") + 
				zeroPlus(h) + "�� " + zeroPlus(mi) + "�� " + zeroPlus(s) + "��");

		// 2019�� 03�� 06�� ���� 01�� 07�� 05��
		
		Date date = new Date();
		System.out.println(date.toString());
	}
	
	private static String zeroPlus(int num) {
		return num < 10 ? "0" + num : "" + num;
	}

}
