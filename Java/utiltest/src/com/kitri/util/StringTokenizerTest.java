package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class StringTokenizerTest {

	public static void main(String[] args) {
		
String str = "hello java !!!";
		
		//1) StringTokenizer(String str) 생성자 (delim의 default는 공백기준임)
		StringTokenizer st = new StringTokenizer(str);
		
		
		//2) countTokens()
		int cnt = st.countTokens();
		System.out.println("토큰수 : " + cnt);
		
		//3) hasMoreElements() | hasMoreTokens()
		//4) nextElement() | nextToken()
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		str = "TO|안효인|안녕하세요";
		StringTokenizer st2 = new StringTokenizer(str, "|");
		String protocol = st2.nextToken();
		String to = st2.nextToken();
		String msg = st2.nextToken();
		System.out.println("기능 : "+ protocol);
		System.out.println("누구에게 : "+ to);
		System.out.println("보내는 메세지 : " + msg);
		
		
		System.out.println(UUID.randomUUID());
		
	}
}
