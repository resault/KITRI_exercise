package com.kitri.exception.runtime;

public class IndexBoundsTest {

	public static void main(String[] args) {
		
		String[] s = {"1", "2", "3", "4"};
		
//		for (int i = 0; i <= 4; i++) { //ArrayIndexOutOfBoundsException: 4
//			System.out.println(s[i]);
//		}
		
		int len = s.length;
		for (int i = 0; i < len; i++) {//�迭�� ���̰� �޶����� ���� �߻����� ����
			System.out.println(s[i]);
		}
		
		System.out.println("-----------------------------------------------------------");
		
		String str = "Hello";
//		for(int i = 0; i < 5;i++) { //���ڿ� ���̸� �ٲٸ� ���� �߻���
//			System.out.println(str.charAt(i));
//		}

		len = str.length();
		for(int i = 0; i < len;i++) {
			System.out.println(str.charAt(i));
		}
		
		
	}
}
