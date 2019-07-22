package com.kitri.io;

//엔터 : \n\r
import java.io.*;

public class ReaderTest {
	
	public static void main(String[] args) {
		Reader in = null; //Reader : 문자 단위 입력을 위한 최상위 클래스
		try {
			in = new InputStreamReader(System.in);// Reader가 추상클래스이므로, 하위클래스를 이용해서 생성
			System.out.print("입력 : ");
			char[] c = new char[100];// 배열은 생성시에 크기를 지정해야 함
			int x = in.read(c); // char 단위로 읽어들인 개수를 int로 반환함
			System.out.println("x == " + x); // 엔터는 2byte이므로 입력한 글자수 + 2가 반환됨 (한/영 동일)
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
