package com.kitri.lang;

public class StringVSBuffer {

	public static void main(String[] args) {
		//예제
		
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
		
		
		// 결론 : 문자열을 더할때는 StringBuffer로!
	
	}
}
