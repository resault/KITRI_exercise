package com.ex.st0324;

public class ObjectTest {

	public static void main(String[] args) {
		
//		int[] intArray = null; //���� �� �ų� �ٸ� ���� ����?!
////		intArray[0] = 10;	//�׷� �̰� ��� ���ԵȰ���..?
//		
//		intArray = new int[5]; //����
////		intArray[0] = 10;
//		System.out.println(intArray[0]); //0 ��µ�
//		
//		String[] strArray;
//		strArray = new String[5];
//		System.out.println(strArray);
//		System.out.println(strArray[0]);
//		String str = "0";
//		System.out.println(str.length());
//		
		String str1 = "��ü�� ����..";
		String str2 = "��ü�� ����..";
		System.out.println(str1 == str2);
		
		str1 = new String("��ü�� ����..");
		System.out.println(str1 == str2);
		
		System.out.println(str1.equals(str2));
		
		int a[] = new int[3];
		System.out.println(a[2]);
		String b[] = new String[2];
		System.out.println(b[1]);
	}
}
