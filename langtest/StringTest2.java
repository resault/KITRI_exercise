package com.kitri.lang;

public class StringTest2 {
	
	public static void main(String[] args) {
//		String str = null; //heap�� �ö��� ���� ����
		String str = new String(); //heap�� �ö�����, ���� ""
		System.out.println("���ڿ� ���� : " + str.length());//NullPoint Exception �߻�
		
	}
	
}
