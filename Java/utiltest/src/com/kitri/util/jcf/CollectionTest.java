package com.kitri.util.jcf;

import java.util.*;

public class CollectionTest {

	public static void main(String[] args) {
		
//		1. ArrayList를 Collection 형으로 생성(generic 생략)
//		Collection coll = new ArrayList(); //Collection은 interface이므로 구현체로 생성
//		coll.add("홍길동");
//		coll.add("이순신");
//		coll.add("강감찬");
//		coll.add("윤봉길");
//		
////		String s = coll.get(); //Collection 형으로 생성했기 때문에 ArrayList의 get은 사용할 수 없음 
//		Object ob[] = coll.toArray();
//		int len = ob.length;
//		for (int i = 0; i < len; i++) {
//			System.out.println((String)ob[i]);//ArrayList를 참조했기 때문에 순서가 있음
//		}
		
//		2. HashSet을 Collection 형으로 생성(generic 생략)
		Collection coll = new HashSet();
		System.out.println("초기 크기 : " + coll.size());
		coll.add("홍길동");
		coll.add("이순신");
		coll.add("강감찬");
		coll.add("윤봉길");
//		coll.add(new Integer(10)); //저장할때는 에러X, 컴파일 하면 아래에서 형변환이 안된다고 에러 발생함
		System.out.println("마지막 크기 : " + coll.size()); //자동으로 값이 늘어남
		
		Object ob[] = coll.toArray();
		int len = ob.length;
		for (int i = 0; i < len; i++) {
			System.out.println((String)ob[i]);//HashSet을 참조했기 때문에 순서가 없음
		}
		
		
	}
}
