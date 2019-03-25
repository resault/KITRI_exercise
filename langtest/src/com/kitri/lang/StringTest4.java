package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest4 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "abcdef";
		
		// 6) 	getBytes() : 문자를 byte 배열로 변환
		byte[] b = str.getBytes();
		int len = b.length;
		for (int i = 0; i < len; i++) {
			System.out.println("b["+i+"] == " + b[i]);
		}
		
//		String str2 = "안녕하세요.";
//		byte[] b2 = str2.getBytes(); // default는 운영체제의 charset
//		int len2 = b2.length;
//		for (int i = 0; i < len2; i++) {
//			System.out.println("b2["+i+"] == " + b2[i]);	//2byte로 쪼개짐
//		}
		
		// 7) getBytes(String charsetName) : ex. win949를 utf-8로		(* win949는 euc-kr과 같음) 
		String str2 = "안녕하세요.";
		byte[] b2 = str2.getBytes("utf-8");
		int len2 = b2.length; //배열의 length는 키워드
		for (int i = 0; i < len2; i++) {
			System.out.println("b2["+i+"] == " + b2[i]); // 3byte로 쪼개짐
		}

		// 8) 	toCharArray()
//		len2 = str2.length(); //String의 length는 method
		len2 = str2.length();
		char[] c = str2.toCharArray();
		for (int i = 0; i < len2; i++) {
			System.out.println("c["+ i +"] == " + c[i]); // 에러 잡을것 
		}
		
		
		// 9) 	hashCode()
		
		
		
	}
}
