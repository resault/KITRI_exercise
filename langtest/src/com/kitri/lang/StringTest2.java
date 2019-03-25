package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest2 {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
//		String str = null; //heap�� �ö��� ���� ����

		//1. String Class constructor
		
		
		//1) ���ڰ����� >> String() ������ : ����ִ� ���ڿ�
//		String str = null;// heap�� �ö��� ���� ����
//		System.out.println("���ڿ� ���� : " + str.length());//NullPoint Exception �߻�
		String str = new String(); //heap�� �ö�����, ���� ""
		System.out.println("���ڿ� ���� : " + str.length());//0

		//2) byte�� �迭�� ���ڰ����� >> String(byte[] bytes) : �ƽ�Ű �ڵ尪
//		byte[] b = {97, 98, 99, 100};
//		String str2 = new String(b);
//		System.out.println("str2 == " + str2); //abcd
		
		
		//3) charsetName >> String(byte[] bytes, String charsetName) // String(byte[] bytes, Charset charset)�̰Ŷ� �� Ȯ��!!
		
			//(1) �ϼ��� �ѱ� : 2byte
		byte[] b = {-66, -56, -77, -25, -57, -49, -68, -68, -65, -28, 46};//2byte�� �ɰ�
//		byte[] b = {46, 48, 65, 97}; // . 0 A a �ϱ��Ұ�!!
//		String str2 = new String(b, "euc-kr");
		String str2 = new String(b);//default�� "euc-kr
		System.out.println("str2 == " + str2); //�ȳ��ϼ���.
		
			//(2) �ѱ��� ������?! >> utf-8
		byte[] b2 = {-20, -107, -120, -21, -123, -107, -19, -107, -104, -20, -124, -72, -20, -102, -108, 46};//(utf-8) 3byte�� �ɰ�
		String str3 = new String(b2, "utf-8");//utf-8: ������ ��� ���ڸ� 3byte�� ó����(���ڸ� �׷���)
		System.out.println("str3 == " + str3);//�ȳ��ϼ���.
	
		
		//4) ���ڿ� �ɰ��� >> String(byte[] bytes, int offset, int length) offset ���� length��
		byte[] b3 = {97, 98, 99, 100, 101, 102, 103, 104};
		String str4 = new String(b3, 2, 4);
		System.out.println("str4 == " + str4);//cdef
		
		
		//5) String(byte[] bytes, int offset, int length, Charset charset)
		//6) String(byte[] bytes, int offset, int length, String charsetName)
		
		
		//�ѱ� ���� ���� �� �����Ƿ� byte ���ٴ� char!
		
		//7) String(char[] value, int offset, int count) // length�� �ƴ϶� count!
//		char[] c = {'a', 'b', 'c', 'd', 'e','f'};
//		String str5 = new String(c);
//		System.out.println("str5 == " + str5);
		
		char[] c = {'��', '��', '��', '��', '��','.'};
		String str6 = new String(c, 2, 4); //�ѱ��� 2����Ʈ ���̹Ƿ�, length�� ������ ����ؾ� ��. �ٵ� count�ϱ� �� ���ڼ� ����
		System.out.println("str6 == " + str6);
		
		//8) String(String original) : ���ͷ� ����� ���ڿ�
		String x = "�ȳ��ϼ���.";
		System.out.println("x == " + x);
		
		
		

	}
	
}
