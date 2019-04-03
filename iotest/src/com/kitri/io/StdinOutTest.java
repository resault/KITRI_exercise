package com.kitri.io;

import java.io.IOException;

//stn : standard
//StdOut : System.out
//StdIn : System.in

public class StdinOutTest {

	public static void main(String[] args) {
		
		try {
//			System.out.print("입력1 : ");
//			int x = System.in.read();//'첫번째' 글자의 아스키코드값을 받아옴
//			System.out.println("1. x == "+ x);
//			System.out.println("2. x == "+ (char)x);//입력받은 첫번째 글자의 아스키 코드값을 강제형변환, 한글 깨짐
			
			System.out.print("입력2 : ");
			byte b[] = new byte[100];//배열은 생성시에 크기를 지정해야 하는데, 몇개의 문자가 입력될지는 모르기에 무조건 크게 지정하게 됨
			int x = System.in.read(b);//입력된 문자를 바이트 단위로 쪼개어 바이트 배열에 저장하고, 입력된 문자의 바이트 크기를 반환함
			System.out.println("2. x == "+ x);
			int len = b.length;
			for (int i = 0; i < 2; i++) {
				System.out.println(b[i]);
			}
			String s = new String(b, 0, x - 2);//엔터(\n)는 2byte로 잡히기에 마지막 2개는 빼줘야 함
			System.out.println("s == "+ s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
