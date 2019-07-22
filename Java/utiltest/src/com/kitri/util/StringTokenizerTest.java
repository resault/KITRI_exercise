package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class StringTokenizerTest {

	public static void main(String[] args) {
		
		String str = "hello java !!!";
		
		//1) StringTokenizer(String str) ������ (delim�� default�� ���������)
		StringTokenizer st = new StringTokenizer(str);
		
		
		//2) countTokens()
		int cnt = st.countTokens();
		System.out.println("��ū�� : " + cnt);
		
		//3) hasMoreElements() | hasMoreTokens()
		//4) nextElement() | nextToken()
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		
		str = "TO|��ȿ��|�ȳ��ϼ���";
		StringTokenizer st2 = new StringTokenizer(str, "|");
		String protocol = st2.nextToken();
		String to = st2.nextToken();
		String msg = st2.nextToken();
		System.out.println("��� : "+ protocol);
		System.out.println("�������� : "+ to);
		System.out.println("������ �޼��� : " + msg);
		
		
		System.out.println(UUID.randomUUID());
		
	}
}
