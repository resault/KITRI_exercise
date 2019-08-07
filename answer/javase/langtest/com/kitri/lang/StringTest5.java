package com.kitri.lang;

public class StringTest5 {

	public static void main(String[] args) {
		String str = "hello java !!!";
		int x = str.indexOf('a');
		System.out.println(str + "에서 a는 " + (x + 1) + "번째 있다.");
		x = str.indexOf('a', 8);
		System.out.println(str + "에서 8번째부터 a는 " + (x + 1) + "번째 있다.");
		x = str.indexOf("java");
		System.out.println(str + "에서 java는 " + (x + 1) + "번째 있다.");
		
		x = str.lastIndexOf('a');
		System.out.println(str + "에서 끝에서 부터 a는 " + (x + 1) + "번째 있다.");
		
		String str2 = "";
		System.out.println(str2 + "의 길이 : " + str2.length());
		if(str2.isEmpty())
			System.out.println("빈문자열이다.");
		else
			System.out.println("str == " + str2);
		
		String str3 = "  hello     .";
		System.out.println(str3 + "의 길이 : " + str3.length());
		System.out.println(str3.trim() + "의 공백 제거 후 길이 : " + str3.trim().length());
		
		
		String str4 = "jaba";
		System.out.println(str4 + " :::: " + str4.replace('b', 'v'));
		System.out.println(str4 + " :::: " + str4.replace("jaba", "java"));
		System.out.println(str4 + " :::: " + str4.replaceAll("jaba", "java"));
		
		String str5 = "hello java !!!";
		String s[] = str5.split(" ");
		int len = s.length;
		for (int i = 0; i < len; i++) {
			System.out.println("s[" + i + "] == " + s[i]);
		}
		
		System.out.println(str5.substring(6));
		System.out.println(str5.substring(6, 9));
		
		
//		숫자 >> 문자열
		int num = 100;
		String sn1 = num + "";
		System.out.println(sn1 + 100);
		String sn2 = String.valueOf(num);
		System.out.println(sn2 + 100);
		String sn3 = Integer.toString(num);
		System.out.println(sn3 + 100);
		
//		문자열 >> 숫자
		String ns = "100";
		num = Integer.parseInt(ns);
		System.out.println(num + 100);
	}
	
}




