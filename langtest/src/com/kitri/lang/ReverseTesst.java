package com.kitri.lang;

public class ReverseTesst {

	public static void main(String[] args) {
		String str = "!!! avaJ olleH";
		
//		Hello Java !!! (최소 3가지 방법이상)
		
//		1. charAt()
		int len = str.length();
		
//		char[] temp1 = new char[len];
//		for (int i = 0; i < len; i++) {
//			temp1[i] = str.charAt(len-1-i);
//		}
		
//		String str1 = "";
//		for (int i = 0; i < len; i ++)
//			str1 += temp1[i];
//		System.out.println(str1);

		String str1 = "";
		for (int i = len-1; i >= 0; i--) {
			str1 += str.charAt(i);
		}
		System.out.println(str1);
		
		
//		2. substring()
		String str2 = "";
		for(int i = len-1; i >= 0; i--) {
			str2 += str.substring(i, i+1);
		}
		System.out.println(str2);
		
		
//		3. toCharArray()
		char[] temp2 = str.toCharArray();
		String str3 = "";
		for(int i = len-1; i >= 0; i--) {
			str3 += temp2[i];
		}
		System.out.println(str3);
		
//		4. getbyte()
		byte[] temp3 = str.getBytes();
		len = temp3.length;
		String str4 = "";
		for (int i = len-1; i >= 0; i--) {
			str4 += (char)temp3[i];
		}
		System.out.println("str4 == " + str4);
		
		
//		e는 2번째에 있습니다.
		
//		1. indexOf()
		System.out.println("e는 " + (str1.indexOf('e')+1) + "번째에 있습니다.");

		
//		2. substring()
		len = str2.length();
		int num = 0;
		for (int i = 0; i < len; i++) {
			if(str2.substring(i, i+1).contentEquals("e")) {
				num = i+1;
				break;
			}
		}
		System.out.println("e는 " + num + "번째에 있습니다.");

		
		System.out.println("e는 " + (str3.indexOf('e')+1) + "번째에 있습니다.");
		
		
		char a1 = '1';
		int x = a1 - 48; // 49-48 >> 1
		System.out.println("x == " + x);
		
	}
}
