package com.kitri.lang;

public class ReverseTest {

	public static void main(String[] args) {
//		String str = "!!! avaJ olleH";
		String str = "!!! 바자 녕안";
//		Hello Java !!!
		String result = "";
		int len = str.length();
		for (int i = len-1; i >= 0; i--) {
			System.out.print(str.charAt(i));
			result += str.charAt(i);
		}
		
//		e는 2번째있습니다.
		System.out.println("\ne는 " + (result.indexOf('e') + 1) + "번째있습니다.");
		
		
		byte b1[] = str.getBytes();
		len = b1.length;
		byte b2[] = new byte[len];
		int x = 0;
		for (int i = len-1; i >= 0; i--) {
			b2[x++] = b1[i];
		}
		result = new String(b2);
		System.out.println(result);
		System.out.println("e는 " + (result.indexOf('e') + 1) + "번째있습니다.");
		
		char c1[] = str.toCharArray();
		len = c1.length;
		char c2[] = new char[len];
		x = 0;
		for (int i = len-1; i >= 0; i--) {
			c2[x++] = c1[i];
		}
		result = new String(c2);
		System.out.println(result);
		System.out.println("e는 " + (result.indexOf('e') + 1) + "번째있습니다.");
		
		
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());
		
	}
	
}
