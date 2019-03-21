package com.kitri.lang;

public class StringTest2 {
	
	public static void main(String[] args) {
//		String str = null; //heap에 올라가지 않은 상태
		String str = new String(); //heap에 올라갔지만, 값이 ""
		System.out.println("문자열 길이 : " + str.length());//NullPoint Exception 발생
		
	}
	
}
