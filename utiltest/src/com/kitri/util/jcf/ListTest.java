package com.kitri.util.jcf;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		System.out.println("list의 크기 : " + list.size());
		
		list.add("허경민");
		list.add("정수빈");
		list.add("박건우");
		list.add("김재환");
		System.out.println("list의 크기 : " + list.size());
		
		System.out.println("-- 두산의 타순 --");
		
//		String[] str = list.toArray(new String[0]);
//		int len = str.length;
//		for (int i = 0; i < len; i++) {
//			System.out.println(i+1 + "번 타자 :" + str[i]);
//		}
		
		int size = list.size();
		for(int i = 0; i <size; i++) {
			System.out.println(i+1 + "번 타자 :" + list.get(i) );
		}
		
		String name = "정수빈";
		int num = list.indexOf(name); //근데 일반적으로는 indexOf는 잘 사용하지 않음
		System.out.println('\n' +name + "은 " + (num+1) + "번 타자입니다.");
		
		String name2 = "오재원";
		System.out.println(name + "을 " + name2 + "으로 교체"+'\n');

		list.set(num, name2);

		size = list.size();
		for(int i = 0; i <size; i++) {
			System.out.println(i+1 + "번 타자 :" + list.get(i));
		}
	}
}
