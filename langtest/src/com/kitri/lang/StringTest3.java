package com.kitri.lang;

public class StringTest3 {

	public static void main(String[] args) {

		String str = "Hello Java !!!";

		// 2. String Class method

		// 1) charAt(int index) : index ��° char
		char c = str.charAt(4);
		System.out.println("c == " + c);

		str = "123";
		System.out.println(str.charAt(0));
//		int x = str.charAt(0); //str.charAt(0)�� char ��ȯ >> ��������ȯ >> 49
		int x = str.charAt(0) - 48; // 49-48 >> 1
		System.out.println("x == " + x);

			// ex. ���ڿ��� �������� �ƴ��� �Ǻ�
//		������ Ǯ���� �ڵ� (����.. str�� int �迭�� ���, ���� for�� ������ ����/���� Ȯ����..)
//		str = "1a2";
//		int len = str.length();
//		int[] checkStr = new int[len];
//		for (int i = 0; i < len; i++) {
//		      checkStr[i] = str.charAt(i) - 48;
//		      System.out.println("for�� " + checkStr[i]);
//		}
//		            // ���ڸ� false ��ȯ
//		boolean result = false;
//		for (int i = 0; i < len; i++) {
//		      if (checkStr[i] >= 0 && checkStr[i] < 10) {
//		            result = true;
//		      } else {
//		            result = false;
//		            break;
//		      }
//		}
//		if (result)
//		      System.out.println(str + "�� �����Դϴ�.");
//		else
//		      System.out.println(str + "�� ���ڰ� �ƴմϴ�.");
		
		
		str = "1a2";
		int len = str.length();
		System.out.println("length == " + len);
		
		String result = "�����Դϴ�.";
		for (int i = 0; i < len; i++) {
			int num = str.charAt(i) - 48;
			if(num < 0 || num > 9) {
				result = "���ڰ� �ƴմϴ�.";
				break;
			}
		}
		System.out.println(str + "�� " + result);
		

		
		
		
		
		// 2)  concat(String str)
		String str1 = "hello ";
		String str2 = "java";
		System.out.println(str1 + str2);//������ �ٲ��� ����
		System.out.println(str1.concat(str2));//������ �ٲ��� ����
		
		
		// 3) endsWith(String suffix) |	startsWith(String prefix) : suffix ���̾�, prefix ���ξ�
		str = "Hell java !!!";
		if(str.startsWith("h"))
			System.out.println(str + "�� h�� �����Ѵ�.");
		if(str.startsWith("H"))
			System.out.println(str + "�� H�� �����Ѵ�.");
		if(str.startsWith("He"))
			System.out.println(str + "�� He�� �����Ѵ�.");
		
		if(str.endsWith("!!"))
			System.out.println(str + "�� !!�� ������.");
	
		
		// 4)  	equals(Object anObject)
		String s1 = "jAva";
		String s2 = "JavA";
		System.out.println("s1.toUpperCase() == " + s1.toUpperCase());
		System.out.println("s2.toLowerCase() == " + s2.toLowerCase());
		
		if(s1.equals(s2))
			System.out.println(s1 + "�� " + s2 + "�� ���� ���ڿ��̴�.");
		else
			System.out.println(s1 + "�� " + s2 + "�� �ٸ� ���ڿ��̴�.");
			
		if((s1.toUpperCase()).equals(s2.toUpperCase())) // ?? .equals ���� int�� �����̸� ��������?
			System.out.println(s1 + "�� " + s2 + "�� ��ҹ��� ���о��� ���� ���ڿ��̴�.");
		else
			System.out.println(s1 + "�� " + s2 + "�� ��ҹ��� ���о��� �ٸ� ���ڿ��̴�.");
		
		// 5) 	equalsIgnoreCase(String anotherString)
		if(s1.equalsIgnoreCase(s2))
			System.out.println(s1 + "�� " + s2 + "�� ��ҹ��� ���о��� ���� ���ڿ��̴�.");
		else
			System.out.println(s1 + "�� " + s2 + "�� ��ҹ��� ���о��� �ٸ� ���ڿ��̴�.");
		
		
		
	}
}
