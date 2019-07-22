package com.kitri.util;

import java.text.DecimalFormat;

public class NumberFormatTest {

	public static void main(String[] args) {
		
		double number = 563242365453.126;
		
		//double number = 34,563,242,365,453.13
		
		DecimalFormat num = new DecimalFormat("###,###,###,###,###.##");
		String str = num.format(number);
		System.out.println(str);
		
	}
}
