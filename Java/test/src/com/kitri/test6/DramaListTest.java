package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {

	public static void main(String[] args) {
		
		List<Drama> list = new ArrayList<Drama>();
		list.add(new Drama("�� �ܿ�, �ٶ��� �д�.", "SBS", "�����", "���μ�", "������")); //Drama d1 ~ d4�� �����ϰ� add�� �ʿ� ���� �ٷ� �����ؼ� ����
		list.add(new Drama("����� ����", "MBC", "�ּ���"));
		list.add(new Drama("���̸���2", "KBS", "ǥ�μ�", "����", "�̴���"));
		list.add(new Drama("�ְ�� �̼���", "KBS", "������", null, "������"));
		
		System.out.println("<< ArrayList>>�� �̿��� ������� >>");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + ". " + list.get(i).toString());
		}
	}
}
