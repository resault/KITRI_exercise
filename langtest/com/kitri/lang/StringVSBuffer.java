package com.kitri.lang;

public class StringVSBuffer {

	public static void main(String[] args) {
		long st = System.nanoTime();
		
		String str = "hello ";
		for(int i=0;i<5000;i++) {
			str += i;
		}
		
//		StringBuffer sb = new StringBuffer("hello ");
//		for(int i=0;i<5000;i++) {
//			sb.append(i);
//		}
		
		System.out.println(System.nanoTime() - st);
		
		
		System.out.println(Math.abs(-5));
		System.out.println(Math.max(3, 5));
		System.out.println(Math.min(3, 5));
		System.out.println(Math.sin(60));
	}
	
}

//500
//1231946	1084087	865024	1096916
//236382	193724	267172	202385

//5000
//85422178	43911603	43677466	43602092
//1126744	1061956		1082804		1100445
