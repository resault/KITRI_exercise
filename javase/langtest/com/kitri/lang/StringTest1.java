package com.kitri.lang;

public class StringTest1 {

	public static void main(String[] args) {
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		String s4 = new String("java");
		
		if(s1 == s2)
			System.out.println("s1 s2�� �ּҰ��� ����.");//O
		if(s1 == s3)
			System.out.println("s1 s3�� �ּҰ��� ����.");//X
		if(s1 == s4)
			System.out.println("s1 s4�� �ּҰ��� ����.");//x
		if(s2 == s3)
			System.out.println("s2 s3�� �ּҰ��� ����.");//x
		if(s2 == s4)
			System.out.println("s2 s4�� �ּҰ��� ����.");//x
		if(s3 == s4)
			System.out.println("s3 s4�� �ּҰ��� ����.");//X
		
		System.out.println("---------------------------------");
		
		if(s1.equals(s2))
			System.out.println("s1 s2�� ���ڿ����� ����.");//O
		if(s1.equals(s3))
			System.out.println("s1 s3�� ���ڿ����� ����.");//O
		if(s1.equals(s4))
			System.out.println("s1 s4�� ���ڿ����� ����.");//O
		if(s2.equals(s3))
			System.out.println("s2 s3�� ���ڿ����� ����.");//O
		if(s2.equals(s4))
			System.out.println("s2 s4�� ���ڿ����� ����.");//O
		if(s3.equals(s4))
			System.out.println("s3 s4�� ���ڿ����� ����.");//O
	
	}
	
}
