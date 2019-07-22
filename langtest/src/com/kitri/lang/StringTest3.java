package com.kitri.lang;

public class StringTest3 {

	public static void main(String[] args) {

		String str = "Hello Java !!!";

		// 2. String Class method

		// 1) charAt(int index) : index 번째 char
		char c = str.charAt(4);
		System.out.println("c == " + c);

		str = "123";
		System.out.println(str.charAt(0));
//		int x = str.charAt(0); //str.charAt(0)는 char 반환 >> 강제형변환 >> 49
		int x = str.charAt(0) - 48; // 49-48 >> 1
		System.out.println("x == " + x);

			// ex. 문자열이 숫자인지 아닌지 판별
//		수업때 풀었던 코드 (굳이.. str을 int 배열에 담고, 새로 for문 돌려서 문자/숫자 확인함..)
//		str = "1a2";
//		int len = str.length();
//		int[] checkStr = new int[len];
//		for (int i = 0; i < len; i++) {
//		      checkStr[i] = str.charAt(i) - 48;
//		      System.out.println("for문 " + checkStr[i]);
//		}
//		            // 문자면 false 반환
//		boolean result = false;
//		for (int i = 0; i < len; i++) {
//		      if (checkStr[i] >= 0 && checkStr[i] < 10) {
//		            result = true;
//		      } else {
//		            result = false;
//		            break;
//		      }
//		}
//		if (result)
//		      System.out.println(str + "은 숫자입니다.");
//		else
//		      System.out.println(str + "은 숫자가 아닙니다.");
		
		
		str = "1a2";
		int len = str.length();
		System.out.println("length == " + len);
		
		String result = "숫자입니다.";
		for (int i = 0; i < len; i++) {
			int num = str.charAt(i) - 48;
			if(num < 0 || num > 9) {
				result = "숫자가 아닙니다.";
				break;
			}
		}
		System.out.println(str + "은 " + result);
		

		
		
		
		
		// 2)  concat(String str)
		String str1 = "hello ";
		String str2 = "java";
		System.out.println(str1 + str2);//원본은 바뀌지 않음
		System.out.println(str1.concat(str2));//원본은 바뀌지 않음
		
		
		// 3) endsWith(String suffix) |	startsWith(String prefix) : suffix 접미어, prefix 접두어
		str = "Hell java !!!";
		if(str.startsWith("h"))
			System.out.println(str + "은 h로 시작한다.");
		if(str.startsWith("H"))
			System.out.println(str + "은 H로 시작한다.");
		if(str.startsWith("He"))
			System.out.println(str + "은 He로 시작한다.");
		
		if(str.endsWith("!!"))
			System.out.println(str + "은 !!로 끝난다.");
	
		
		// 4)  	equals(Object anObject)
		String s1 = "jAva";
		String s2 = "JavA";
		System.out.println("s1.toUpperCase() == " + s1.toUpperCase());
		System.out.println("s2.toLowerCase() == " + s2.toLowerCase());
		
		if(s1.equals(s2))
			System.out.println(s1 + "과 " + s2 + "는 같은 문자열이다.");
		else
			System.out.println(s1 + "과 " + s2 + "는 다른 문자열이다.");
			
		if((s1.toUpperCase()).equals(s2.toUpperCase())) // ?? .equals 앞이 int형 변수이면 에러날까?
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 같은 문자열이다.");
		else
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 다른 문자열이다.");
		
		// 5) 	equalsIgnoreCase(String anotherString)
		if(s1.equalsIgnoreCase(s2))
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 같은 문자열이다.");
		else
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 다른 문자열이다.");
		
		
		
	}
}
