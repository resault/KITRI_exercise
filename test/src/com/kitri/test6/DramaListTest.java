package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {

	public static void main(String[] args) {
		
		Drama d1 = new Drama("�� �ܿ�, �ٶ��� �д�.", "SBS", "�����", "���μ�", "������");
		Drama d2 = new Drama("����� ����", "MBC", "�ּ���", "", "");
		Drama d3 = new Drama("���̸���2", "KBS", "ǥ�μ�", "����", "�̴���");
		Drama d4 = new Drama("�ְ�� �̼���", "KBS", "������", "", "������");
		
		List<Drama> dramaInfo = new ArrayList<Drama>();
		dramaInfo.add(d1);
		dramaInfo.add(d2);
		dramaInfo.add(d3);
		dramaInfo.add(d4);
		
		System.out.println("<< ArrayList>>�� �̿��� ������� >>");
		for(int i = 0; i < dramaInfo.size(); i++) {
			System.out.println(i+1 + ". " + dramaInfo.get(i).toString());
		}
	}
}
