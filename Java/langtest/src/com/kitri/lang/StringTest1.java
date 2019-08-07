package com.kitri.lang;

public class StringTest1 {
	public static void main(String[] args) {
		//String의 객체 생성 방법 2가지 : "", new
		String s1 = "java";//리터럴 방식
		String s2 = "java";
		String s3 = new String("java");
		String s4 = new String("java");
		
		if(s1 == s2 )
			System.out.println("s1 s2는 주소값이 같다");//o
		if(s1 == s3 )
			System.out.println("s1 s3는 주소값이 같다");//x
		if(s1 == s4 )
			System.out.println("s1 s4는 주소값이 같다");//x
		if(s2 == s3 )
			System.out.println("s2 s3는 주소값이 같다");//x
		if(s2 == s4 )
			System.out.println("s2 s4는 주소값이 같다");//x
		if(s3 == s4 )
			System.out.println("s3 s4는 주소값이 같다");//x

		
		if(s1.equals(s2))
			System.out.println("s1 s2는 문자열의 값이 같다");//o
		if(s1.equals(s3))
			System.out.println("s1 s3는 문자열의 값이 같다");//o
		if(s1.equals(s4))
			System.out.println("s1 s4는 문자열의 값이 같다");//o
		if(s2.equals(s3))
			System.out.println("s2 s3는 문자열의 값이 같다");//o
		if(s2.equals(s4))
			System.out.println("s2 s4는 문자열의 값이 같다");//o
		if(s3.equals(s4))
			System.out.println("s3 s4는 문자열의 값이 같다");//o
		//대소문자 구별해서 비교됨!
		
	}
}
