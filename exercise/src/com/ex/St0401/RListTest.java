package com.ex.St0401;

import java.util.ArrayList;
import java.util.List;

/*
list의 크기 : 0
list의 크기 : 4
-- 두산의 타순 --
1번 타자 :허경민
2번 타자 :정수빈
3번 타자 :박건우
4번 타자 :김재환

정수빈은 2번 타자입니다.
정수빈을 오재원으로 교체

1번 타자 :허경민
2번 타자 :오재원
3번 타자 :박건우
4번 타자 :김재환
*/
public class RListTest {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		System.out.println(list.size());
		list.add("허경민");
		list.add("정수빈");
		list.add("박건우");
		list.add("김재환");
		System.out.println(list.size());

		System.out.println("-- 두산의 타순 --");
//		String[] str = list.toArray(new String[0]);
		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(i+1 + "번 타자 : " + list.get(i));
		}
		
		String name = "정수빈";
		
		len = list.size();
		for (int i = 0; i < len; i++) {
			if(list.get(i).equals(name)) {
				System.out.println(name + "은 " + (i+1) + "번 타자입니다.");
			}
		}
		
		String name2 = "오재원";
		System.out.println(name + "을 " + name2 +"으로 교체");
	
		for(int i = 0;i<len;i++) {
			if(list.get(i).equals(name)) {
				list.set(i, name2);
			}
			System.out.println(i+1 + "번 타자 : " + list.get(i));
		}
		
	}
}
