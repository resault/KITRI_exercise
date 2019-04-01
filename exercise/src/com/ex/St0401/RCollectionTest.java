package com.ex.St0401;

import java.util.*;

/*
- Collection	ArrayList/HashSet
초기 크기 : 0
마지막 크기 : 4
윤봉길
홍길동
강감찬
이순신
*/
public class RCollectionTest {

	public static void main(String[] args) {
		
		Collection col = new ArrayList();
//		Collection col = new HashSet();
		System.out.println(col.size());
		
		col.add("홍길동");
		col.add("이순신");
		col.add("강감찬");
		col.add("윤봉길");
		col.add("이순신");
		
		System.out.println(col.size());
		
		Object[] ob = col.toArray();
		int len = ob.length;
		for (int i = 0; i < len; i++) {
			System.out.println((String)ob[i]);
		}
	}
}
