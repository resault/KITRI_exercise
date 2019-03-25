package com.kitri.lang;

public class StringTest5 {
	
	public static void main(String[] args) {

		// 10) 	indexOf(int ch)
		String str = "hello java !!!";
		int x = str.indexOf('a');
		System.out.println(str + "���� a�� " + (x+1) + "��° �ִ�.");
		
		x = str.indexOf("java");
		System.out.println(str + "���� java�� " + (x+1) + "��° �ִ�."); // ������ġ�� ��ȯ��
		
		
		// 11) 	indexOf(int ch, int fromIndex)		(fromindext�� �� �Ⱦ�)
		x = str.indexOf('a', 8);
		System.out.println(str + "���� 8��°���� a�� " + (x+1) + "��° �ִ�.");
		
		
		// 12)	lastIndexOf(int ch) : ���ڿ��� ������ ���� ã��
		x = str.lastIndexOf('a');
		System.out.println(str + "���� ������ ���� ã���� ��, ó������ ������ a�� " + (x+1) + "��° �ִ�."); //��ȯ�Ǵ� index�� �տ������� ���� �ű����
		
		
		// 13) isEmpty() : ���ڿ� ���̰� 0�̸� true ��ȯ
		String str2 = "";
		System.out.println(str2 + "�� ���� : " + str2.length());
		if(str2.isEmpty())
			System.out.println("���ڿ��̴�.");
		else
			System.out.println("str2 == " + str2);
		
		
		// 14) trim() : �յ� ���� ����	(���ڿ� ������ ������ ���ŵ��� ����)
		String str3 = "  hello     ";
		System.out.println(str3 + "�� ���� : " + str3.length());
		System.out.println(str3 + "�� ������ ������ �� ���� : " + str3.trim().length());
		
		str3 = "  hello     .";
		System.out.println("str3.trim() == " + str3.trim());
		System.out.println(str3 + "�� ������ ������ �� ���� : " + str3.trim().length());
		
		
		// 15) 	replace(char oldChar, char newChar)
		String str4 = "jaba";
		System.out.println(str4 + " >>> " +str4.replace('b', 'v'));
		
		
		// 16) 	replace(CharSequence target, CharSequence replacement) : CharSequence�� interface >>> ������ String Ŭ������ �����Ǿ� ����
		System.out.println(str4 + " >>> " +str4.replace("jaba", "java"));
		
		
		// 17) 	replaceAll(String regex, String replacement)
		System.out.println(str4 + " >>> " +str4.replaceAll("jaba", "java"));
		
		
		// �߿�! 18) split(String regex) : regex - ����ǥ����
		String str5 = "hello java !!!";
		String[] s = str5.split(" ");
		int len = s.length;
		for (int i = 0; i < len; i++) {
			System.out.println("s[" + i + "] == " + s[i]);
		}
		
		
		// 19) 	substring(int beginIndex) : ����Ŭ�� ��� ��ü�� ����. �ٸ� 0���� ����. 
		System.out.println(str5.substring(6));
		
		
		// 20) 	substring(int beginIndex, int endIndex) : endIndex ������!!
		System.out.println(str5.substring(6, 9));
		
		
		//���ڿ��� ��ȯ!	(3���� ���!!)
		// 21) 	valueOf()	: �Ű������� String���� ��ȯ. static�̹Ƿ� ��ü �������� Ŭ���� �̸����� ��밡��
		int num = 100;
		String sn1 = num + "";
		System.out.println(sn1 + sn1);
		
		String sn2 = String.valueOf(num);
		System.out.println(sn2 + sn2);
		
		String sn3 = Integer.toString(num);
		System.out.println(sn3 + 100);
		
		
		//���ڿ��� ���ڷ� ��ȯ!		(1���� ����ۿ� ����)
		String ns = "100";
		num = Integer.parseInt(ns);
		System.out.println(num + 100);
		
		
		
		
		
		
	}
}
