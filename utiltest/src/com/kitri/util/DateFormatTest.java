package com.kitri.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {

	public static void main(String[] args) {
		// 2019.03.26 14:25:30
		Date date = new Date();
		System.out.println(date);
//		System.out.println(date.toString()); // 위에는 toString 생략된거지?
		
		Format f = new SimpleDateFormat("yyyy.MM.dd HH:m:s");
//		Format f = new SimpleDateFormat("yyyy/MM/dd HH:m:s");
//		Format f = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
//		Format f = new SimpleDateFormat("yyyy MM dd HH:m:s");
//		Format f = new SimpleDateFormat("yyyy년 MM월 dd일 HH:m:s"); //but 웹상에서는 한글로 잘 안함
		
		String today = f.format(date);
		System.out.println(today);
		
		
	}
}
