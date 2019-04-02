package com.kitri.exception.runtime;

public class NumberFormatTest {

	public static void main(String[] args) {
		
//		1.
//		String s = "12 3";
//		try {
//		int x = Integer.parseInt(s);//api�� ����, parsInt()�� throws NumberFormatException��
//		System.out.println(x + 100);
//		} catch(NumberFormatException e) {
//			System.out.println("���ڰ� �ƴմϴ�.");
//		}
		//but, NumberFormatException�� Runtime Exception �̹Ƿ� Logic���� ó���� ��!!!

		String s = "12 3";
		if(isNumber(s)) {
			int x = Integer.parseInt(s);
			System.out.println(x + 100);
		} else
			System.out.println("���ڰ� �ƴմϴ�.");
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
