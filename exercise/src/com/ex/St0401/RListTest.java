package com.ex.St0401;

import java.util.ArrayList;
import java.util.List;

/*
list�� ũ�� : 0
list�� ũ�� : 4
-- �λ��� Ÿ�� --
1�� Ÿ�� :����
2�� Ÿ�� :������
3�� Ÿ�� :�ڰǿ�
4�� Ÿ�� :����ȯ

�������� 2�� Ÿ���Դϴ�.
�������� ��������� ��ü

1�� Ÿ�� :����
2�� Ÿ�� :�����
3�� Ÿ�� :�ڰǿ�
4�� Ÿ�� :����ȯ
*/
public class RListTest {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		System.out.println(list.size());
		list.add("����");
		list.add("������");
		list.add("�ڰǿ�");
		list.add("����ȯ");
		System.out.println(list.size());

		System.out.println("-- �λ��� Ÿ�� --");
//		String[] str = list.toArray(new String[0]);
		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(i+1 + "�� Ÿ�� : " + list.get(i));
		}
		
		String name = "������";
		
		len = list.size();
		for (int i = 0; i < len; i++) {
			if(list.get(i).equals(name)) {
				System.out.println(name + "�� " + (i+1) + "�� Ÿ���Դϴ�.");
			}
		}
		
		String name2 = "�����";
		System.out.println(name + "�� " + name2 +"���� ��ü");
	
		for(int i = 0;i<len;i++) {
			if(list.get(i).equals(name)) {
				list.set(i, name2);
			}
			System.out.println(i+1 + "�� Ÿ�� : " + list.get(i));
		}
		
	}
}
