package study0325;

import java.io.UnsupportedEncodingException;

public class StringTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//String()
		String str1 = new String();
		System.out.println(str1.length());
		
		//String(byte[] bytes)
		byte[] byteArr = {-20, -107, -120, 97, 98, 99};
		str1 = new String(byteArr);
		System.out.println(str1);
		
		//String(byte[] bytes, String charsetName)
		str1 = new String(byteArr, "utf-8");
		System.out.println(str1);
		
		String str2 = new String("안녕하세요");
		byte[] byteArr1 = str2.getBytes("utf-8");
		int len = byteArr1.length;
		for (int i = 0; i < len; i++) {
			System.out.println(byteArr1[i]);
		}
		
		//바이트 배열을 문자열로 변환
		byte[] byteArr2 = {-20, -107, -120, 72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		String str3 = new String(byteArr2, "utf-8");
		System.out.println(str3);
		
		str3 = new String(byteArr2, 1, 5);
		System.out.println(str3);
		str3 = new String(byteArr2, 3, 5);
		System.out.println(str3);
		
		
		
		// String 객체의 생성
		// byte 배열, char 배열, literal 문자열
		
		// byte 배열
		
		char a = 'a';
		System.out.println("char a == " + a);
		int bb = a;
		System.out.println("(int)a == " + bb);
		
	}
}
