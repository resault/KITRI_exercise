package com.kitri.exception.runtime;

public class NumberFormatTest {

	public static void main(String[] args) {
		
//		1.
//		String s = "12 3";
//		try {
//		int x = Integer.parseInt(s);//api로 보면, parsInt()는 throws NumberFormatException함
//		System.out.println(x + 100);
//		} catch(NumberFormatException e) {
//			System.out.println("숫자가 아닙니다.");
//		}
		//but, NumberFormatException는 Runtime Exception 이므로 Logic으로 처리할 것!!!

		String s = "12 3";
		if(isNumber(s)) {
			int x = Integer.parseInt(s);
			System.out.println(x + 100);
		} else
			System.out.println("숫자가 아닙니다.");
	}

	
	private static boolean isNumber(String str) {
		boolean flag = true;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			int num = str.charAt(i) - 48;
			if(num < 0 || num > 9) {
				flag = false;
				break;
			}
		}	
		return flag;
	}

		
}
