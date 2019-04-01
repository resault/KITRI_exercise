package com.ex.st0324;

public class ObjectTest {

	public static void main(String[] args) {
		
//		int[] intArray = null; //선언만 한 거나 다름 없는 상태?!
////		intArray[0] = 10;	//그럼 이건 어디에 대입된거지..?
//		
//		intArray = new int[5]; //생성
////		intArray[0] = 10;
//		System.out.println(intArray[0]); //0 출력됨
//		
//		String[] strArray;
//		strArray = new String[5];
//		System.out.println(strArray);
//		System.out.println(strArray[0]);
//		String str = "0";
//		System.out.println(str.length());
//		
		String str1 = "객체가 뭐임..";
		String str2 = "객체가 뭐임..";
		System.out.println(str1 == str2);
		
		str1 = new String("객체가 뭐임..");
		System.out.println(str1 == str2);
		
		System.out.println(str1.equals(str2));
		
		int a[] = new int[3];
		System.out.println(a[2]);
		String b[] = new String[2];
		System.out.println(b[1]);
	}
}
