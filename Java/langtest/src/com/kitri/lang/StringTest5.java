package com.kitri.lang;

public class StringTest5 {
	
	public static void main(String[] args) {

		// 10) 	indexOf(int ch)
		String str = "hello java !!!";
		int x = str.indexOf('a');
		System.out.println(str + "에서 a는 " + (x+1) + "번째 있다.");
		
		x = str.indexOf("java");
		System.out.println(str + "에서 java는 " + (x+1) + "번째 있다."); // 시작위치를 반환함
		
		
		// 11) 	indexOf(int ch, int fromIndex)		(fromindext는 잘 안씀)
		x = str.indexOf('a', 8);
		System.out.println(str + "에서 8번째부터 a는 " + (x+1) + "번째 있다.");
		
		
		// 12)	lastIndexOf(int ch) : 문자열의 끝에서 부터 찾음
		x = str.lastIndexOf('a');
		System.out.println(str + "에서 끝에서 부터 찾았을 때, 처음으로 나오는 a는 " + (x+1) + "번째 있다."); //반환되는 index는 앞에서부터 값을 매긴거임
		
		
		// 13) isEmpty() : 문자열 길이가 0이면 true 반환
		String str2 = "";
		System.out.println(str2 + "의 길이 : " + str2.length());
		if(str2.isEmpty())
			System.out.println("빈문자열이다.");
		else
			System.out.println("str2 == " + str2);
		
		
		// 14) trim() : 앞뒤 공백 제거	(문자열 사이의 공백은 제거되지 않음)
		String str3 = "  hello     ";
		System.out.println(str3 + "의 길이 : " + str3.length());
		System.out.println(str3 + "의 공백을 제거한 후 길이 : " + str3.trim().length());
		
		str3 = "  hello     .";
		System.out.println("str3.trim() == " + str3.trim());
		System.out.println(str3 + "의 공백을 제거한 후 길이 : " + str3.trim().length());
		
		
		// 15) 	replace(char oldChar, char newChar)
		String str4 = "jaba";
		System.out.println(str4 + " >>> " +str4.replace('b', 'v'));
		
		
		// 16) 	replace(CharSequence target, CharSequence replacement) : CharSequence는 interface >>> 가보면 String 클래스로 구현되어 있음
		System.out.println(str4 + " >>> " +str4.replace("jaba", "java"));
		
		
		// 17) 	replaceAll(String regex, String replacement)
		System.out.println(str4 + " >>> " +str4.replaceAll("jaba", "java"));
		
		
		// 중요! 18) split(String regex) : regex - 정규표현식
		String str5 = "hello java !!!";
		String[] s = str5.split(" ");
		int len = s.length;
		for (int i = 0; i < len; i++) {
			System.out.println("s[" + i + "] == " + s[i]);
		}
		
		
		// 19) 	substring(int beginIndex) : 오라클과 기능 자체는 동일. 다만 0부터 시작. 
		System.out.println(str5.substring(6));
		
		
		// 20) 	substring(int beginIndex, int endIndex) : endIndex 전까지!!
		System.out.println(str5.substring(6, 9));
		
		
		//문자열로 변환!	(3가지 방법!!)
		// 21) 	valueOf()	: 매개변수를 String으로 변환. static이므로 객체 생성없이 클래스 이름으로 사용가능
		int num = 100;
		String sn1 = num + "";
		System.out.println(sn1 + sn1);
		
		String sn2 = String.valueOf(num);
		System.out.println(sn2 + sn2);
		
		String sn3 = Integer.toString(num);
		System.out.println(sn3 + 100);
		
		
		//문자열을 숫자로 변환!		(1가지 방법밖에 없음)
		String ns = "100";
		num = Integer.parseInt(ns);
		System.out.println(num + 100);
		
		
		
		
		
		
	}
}
