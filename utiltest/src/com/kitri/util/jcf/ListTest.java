package com.kitri.util.jcf;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		System.out.println("list�� ũ�� : " + list.size());
		
		list.add("����");
		list.add("������");
		list.add("�ڰǿ�");
		list.add("����ȯ");
		System.out.println("list�� ũ�� : " + list.size());
		
		System.out.println("-- �λ��� Ÿ�� --");
		
//		String[] str = list.toArray(new String[0]);
//		int len = str.length;
//		for (int i = 0; i < len; i++) {
//			System.out.println(i+1 + "�� Ÿ�� :" + str[i]);
//		}
		
		int size = list.size();
		for(int i = 0; i <size; i++) {
			System.out.println(i+1 + "�� Ÿ�� :" + list.get(i) );
		}
		
		String name = "������";
		int num = list.indexOf(name); //�ٵ� �Ϲ������δ� indexOf�� �� ������� ����
		System.out.println('\n' +name + "�� " + (num+1) + "�� Ÿ���Դϴ�.");
		
		String name2 = "�����";
		System.out.println(name + "�� " + name2 + "���� ��ü"+'\n');

		list.set(num, name2);

		size = list.size();
		for(int i = 0; i <size; i++) {
			System.out.println(i+1 + "�� Ÿ�� :" + list.get(i));
		}
	}
}
