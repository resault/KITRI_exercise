package com.kitri.io;

//엔터 : \n\r
import java.io.*;

public class ReaderTest {
	
	public static void main(String[] args) {
		Reader in = null;
		try {
			in = new InputStreamReader(System.in);
			System.out.print("입력 : ");
			char[] c = new char[100];
			int x = in.read(c);
			System.out.println("x == " + x);
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
