package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest4 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "abcdef";
		
		// 6) 	getBytes() : ���ڸ� byte �迭�� ��ȯ
		byte[] b = str.getBytes();
		int len = b.length;
		for (int i = 0; i < len; i++) {
			System.out.println("b["+i+"] == " + b[i]);
		}
		
//		String str2 = "�ȳ��ϼ���.";
//		byte[] b2 = str2.getBytes(); // default�� �ü���� charset
//		int len2 = b2.length;
//		for (int i = 0; i < len2; i++) {
//			System.out.println("b2["+i+"] == " + b2[i]);	//2byte�� �ɰ���
//		}
		
		// 7) getBytes(String charsetName) : ex. win949�� utf-8��		(* win949�� euc-kr�� ����) 
		String str2 = "�ȳ��ϼ���.";
		byte[] b2 = str2.getBytes("utf-8");
		int len2 = b2.length; //�迭�� length�� Ű����
		for (int i = 0; i < len2; i++) {
			System.out.println("b2["+i+"] == " + b2[i]); // 3byte�� �ɰ���
		}

		// 8) 	toCharArray()
//		len2 = str2.length(); //String�� length�� method
		len2 = str2.length();
		char[] c = str2.toCharArray();
		for (int i = 0; i < len2; i++) {
			System.out.println("c["+ i +"] == " + c[i]); // ���� ������ 
		}
		
		
		// 9) 	hashCode()
		
		
		
	}
}
