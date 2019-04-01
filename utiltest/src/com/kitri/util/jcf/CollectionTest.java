package com.kitri.util.jcf;

import java.util.*;

public class CollectionTest {

	public static void main(String[] args) {
		
//		1. ArrayList�� Collection ������ ����(generic ����)
//		Collection coll = new ArrayList(); //Collection�� interface�̹Ƿ� ����ü�� ����
//		coll.add("ȫ�浿");
//		coll.add("�̼���");
//		coll.add("������");
//		coll.add("������");
//		
////		String s = coll.get(); //Collection ������ �����߱� ������ ArrayList�� get�� ����� �� ���� 
//		Object ob[] = coll.toArray();
//		int len = ob.length;
//		for (int i = 0; i < len; i++) {
//			System.out.println((String)ob[i]);//ArrayList�� �����߱� ������ ������ ����
//		}
		
//		2. HashSet�� Collection ������ ����(generic ����)
		Collection coll = new HashSet();
		System.out.println("�ʱ� ũ�� : " + coll.size());
		coll.add("ȫ�浿");
		coll.add("�̼���");
		coll.add("������");
		coll.add("������");
//		coll.add(new Integer(10)); //�����Ҷ��� ����X, ������ �ϸ� �Ʒ����� ����ȯ�� �ȵȴٰ� ���� �߻���
		System.out.println("������ ũ�� : " + coll.size()); //�ڵ����� ���� �þ
		
		Object ob[] = coll.toArray();
		int len = ob.length;
		for (int i = 0; i < len; i++) {
			System.out.println((String)ob[i]);//HashSet�� �����߱� ������ ������ ����
		}
		
		
	}
}
