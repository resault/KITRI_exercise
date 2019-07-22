package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class StringTokenizerTest {

	public static void main(String[] args) {
		String str = "hello java !!!";
		StringTokenizer st = new StringTokenizer(str);
		int cnt = st.countTokens();
		System.out.println("토큰수 : " + cnt);
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		str = "TO|안효인|안녕하세요 오늘 머해요???";
		StringTokenizer st2 = new StringTokenizer(str, "|");
		String protocol = st2.nextToken();
		String to = st2.nextToken();
		String msg = st2.nextToken();
		System.out.println("기능 : " + protocol);
		System.out.println("누구에게 : " + to);
		System.out.println("보내는 메세지 : " + msg);
		
		System.out.println(UUID.randomUUID());
	}
	
}
