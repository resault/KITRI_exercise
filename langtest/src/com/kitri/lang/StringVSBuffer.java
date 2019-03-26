package com.kitri.lang;

public class StringVSBuffer {

	public static void main(String[] args) {
		//����
		
		long st = System.nanoTime();
		String str = "hello ";
		for(int i = 0; i <50000; i++) {
			str += i;
		}
		System.out.println(System.nanoTime() - st);
		
		
		st = System.nanoTime();
		StringBuffer sb = new StringBuffer("hello");
		for(int i = 0; i <50000; i++) {
			sb.append(i);
		}
		System.out.println(System.nanoTime() - st);
		
		
		// ��� : ���ڿ��� ���Ҷ��� StringBuffer��!
	
	}
}
