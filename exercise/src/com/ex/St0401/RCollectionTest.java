package com.ex.St0401;

import java.util.*;

/*
- Collection	ArrayList/HashSet
�ʱ� ũ�� : 0
������ ũ�� : 4
������
ȫ�浿
������
�̼���
*/
public class RCollectionTest {

	public static void main(String[] args) {
		
		Collection col = new ArrayList();
//		Collection col = new HashSet();
		System.out.println(col.size());
		
		col.add("ȫ�浿");
		col.add("�̼���");
		col.add("������");
		col.add("������");
		col.add("�̼���");
		
		System.out.println(col.size());
		
		Object[] ob = col.toArray();
		int len = ob.length;
		for (int i = 0; i < len; i++) {
			System.out.println((String)ob[i]);
		}
	}
}
