package com.kitri.util.jcf;

import java.util.*;

public class CollectionTest {

	public static void main(String[] args) {
		Collection coll = new ArrayList();
//		Collection coll = new HashSet();
		System.out.println("�ʱ� ũ�� : " + coll.size());
		coll.add("ȫ�浿");
		coll.add("�̼���");
		coll.add("������");
		coll.add("������");
		coll.add("�̼���");
//		coll.add(new Integer(10));
		System.out.println("������ ũ�� : " + coll.size());
		
		Object ob[] = coll.toArray();
		int len = ob.length;
		for (int i = 0; i < len; i++) {
			System.out.println((String) ob[i]);
		}
	}
	
}
