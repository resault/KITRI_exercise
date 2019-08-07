package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest2 {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
//		String str = null; //heap에 올라가지 않은 상태

		//1. String Class constructor
		
		
		//1) 인자값없이 >> String() 생성자 : 비어있는 문자열
//		String str = null;// heap에 올라가지 않은 상태
//		System.out.println("문자열 길이 : " + str.length());//NullPoint Exception 발생
		String str = new String(); //heap에 올라갔지만, 값이 ""
		System.out.println("문자열 길이 : " + str.length());//0

		//2) byte의 배열을 인자값으로 >> String(byte[] bytes) : 아스키 코드값
//		byte[] b = {97, 98, 99, 100};
//		String str2 = new String(b);
//		System.out.println("str2 == " + str2); //abcd
		
		
		//3) charsetName >> String(byte[] bytes, String charsetName) // String(byte[] bytes, Charset charset)이거랑 비교 확인!!
		
			//(1) 완성형 한글 : 2byte
		byte[] b = {-66, -56, -77, -25, -57, -49, -68, -68, -65, -28, 46};//2byte로 쪼갬
//		byte[] b = {46, 48, 65, 97}; // . 0 A a 암기할것!!
//		String str2 = new String(b, "euc-kr");
		String str2 = new String(b);//default는 "euc-kr
		System.out.println("str2 == " + str2); //안녕하세요.
		
			//(2) 한글이 깨질때?! >> utf-8
		byte[] b2 = {-20, -107, -120, -21, -123, -107, -19, -107, -104, -20, -124, -72, -20, -102, -108, 46};//(utf-8) 3byte로 쪼갬
		String str3 = new String(b2, "utf-8");//utf-8: 전세계 모든 글자를 3byte로 처리함(글자를 그려냄)
		System.out.println("str3 == " + str3);//안녕하세요.
	
		
		//4) 문자열 쪼개기 >> String(byte[] bytes, int offset, int length) offset 부터 length개
		byte[] b3 = {97, 98, 99, 100, 101, 102, 103, 104};
		String str4 = new String(b3, 2, 4);
		System.out.println("str4 == " + str4);//cdef
		
		
		//5) String(byte[] bytes, int offset, int length, Charset charset)
		//6) String(byte[] bytes, int offset, int length, String charsetName)
		
		
		//한글 등은 깨질 수 있으므로 byte 보다는 char!
		
		//7) String(char[] value, int offset, int count) // length가 아니라 count!
//		char[] c = {'a', 'b', 'c', 'd', 'e','f'};
//		String str5 = new String(c);
//		System.out.println("str5 == " + str5);
		
		char[] c = {'안', '녕', '하', '세', '요','.'};
		String str6 = new String(c, 2, 4); //한글은 2바이트 씩이므로, length면 일일히 계산해야 함. 근데 count니까 걍 글자수 ㄱㄱ
		System.out.println("str6 == " + str6);
		
		//8) String(String original) : 리터럴 방식의 문자열
		String x = "안녕하세요.";
		System.out.println("x == " + x);
		
		
		

	}
	
}
