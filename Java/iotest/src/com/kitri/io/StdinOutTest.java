package com.kitri.io;

import java.io.IOException;

//stn : standard
//StdOut : System.out
//StdIn : System.in

public class StdinOutTest {

	public static void main(String[] args) {
		
		try {
//			System.out.print("�Է�1 : ");
//			int x = System.in.read();//'ù��°' ������ �ƽ�Ű�ڵ尪�� �޾ƿ�
//			System.out.println("1. x == "+ x);
//			System.out.println("2. x == "+ (char)x);//�Է¹��� ù��° ������ �ƽ�Ű �ڵ尪�� ��������ȯ, �ѱ� ����
			
			System.out.print("�Է�2 : ");
			byte b[] = new byte[100];//�迭�� �����ÿ� ũ�⸦ �����ؾ� �ϴµ�, ��� ���ڰ� �Էµ����� �𸣱⿡ ������ ũ�� �����ϰ� ��
			int x = System.in.read(b);//�Էµ� ���ڸ� ����Ʈ ������ �ɰ��� ����Ʈ �迭�� �����ϰ�, �Էµ� ������ ����Ʈ ũ�⸦ ��ȯ��
			System.out.println("2. x == "+ x);
			int len = b.length;
			for (int i = 0; i < 2; i++) {
				System.out.println(b[i]);
			}
			String s = new String(b, 0, x - 2);//����(\n)�� 2byte�� �����⿡ ������ 2���� ����� ��
			System.out.println("s == "+ s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
