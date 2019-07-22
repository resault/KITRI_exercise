package com.kitri.io;

//���� : \n\r
import java.io.*;

public class ReaderTest {
	
	public static void main(String[] args) {
		Reader in = null; //Reader : ���� ���� �Է��� ���� �ֻ��� Ŭ����
		try {
			in = new InputStreamReader(System.in);// Reader�� �߻�Ŭ�����̹Ƿ�, ����Ŭ������ �̿��ؼ� ����
			System.out.print("�Է� : ");
			char[] c = new char[100];// �迭�� �����ÿ� ũ�⸦ �����ؾ� ��
			int x = in.read(c); // char ������ �о���� ������ int�� ��ȯ��
			System.out.println("x == " + x); // ���ʹ� 2byte�̹Ƿ� �Է��� ���ڼ� + 2�� ��ȯ�� (��/�� ����)
			String str = new String(c, 0, x-2);
			System.out.println(str);
			
			int len = c.length;
			for (int i = 0; i < len; i++) {
				System.out.println(c[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
