package com.ex.St0401;

import java.util.*;
/*
set�� ũ�� : 4
������
Ȳ����
�ڹ̷�
������
-----------------------------
������
Ȳ����
�ڹ̷�
������
*/
public class RSetTest {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		System.out.println(set.size());
		set.add("������");
		set.add("Ȳ����");
		set.add("�ڹ̷�");
		set.add("������");
		System.out.println(set.size());
		
//		String[] str = set.toArray(new String[0]);
//		int len = str.length;
//		for(int i =0;i<len;i++) {
//			System.out.println(str[i]);
//		}

		Iterator<String> iterate = set.iterator();
		while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}
		
		
	}
}
