package com.kitri.array;

public class arraytest1 {

	public static void main(String[] args) {
		int x1 = 10;
		int x2 = 20;
		int x3 = 30;
		System.out.println("x1 = " + x1 + " x2 = " + x2 + " x3 = " + x3);
		
		int x[];
		x = new int[3];
		x[0] = 10;
		x[1] = 20;
		x[2] = 30;
		System.out.println("x1 =" + x[0] + " x2 =" + x[1] +" x3 =" + x[2]);
		
		int len = x.length;
		for(int i=0;i<len;i++)
			System.out.print("x" + (i+1) +" = "+ x[i] + "\t\t");
		
		System.out.println("배열의 길이 : " + len);
	}
}
