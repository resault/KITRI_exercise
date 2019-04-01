package com.ex.st0324;

public class TextBook152 {
	public static void main(String[] args) {
		int[] scores = {83, 90, 87};
		
		System.out.println("scores[0] : " + scores[0]);
		System.out.println("scores[1] : " + scores[1]);
		System.out.println("scores[2] : " + scores[2]);

		int sum = 0;
		int len = scores.length;
		for (int i = 0; i < len; i++) {
			sum += scores[i];
		}
		System.out.println("ÃÑÇÕ : " + sum);
		
		double avg = (double)sum/len;
		System.out.println("Æò±Õ : " + avg);
			
		int num[] = {1, 2, 3};
	}
}
