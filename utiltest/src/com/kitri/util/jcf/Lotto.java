package com.kitri.util.jcf;

import java.util.*;

public class Lotto {

	public static void main(String[] args) {
		Random random = new Random();
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(random.nextInt(45)+1);
		set.add(random.nextInt(45)+1);
		set.add(random.nextInt(45)+1);
		Integer num[] = set.toArray(new Integer[0]);
		int len = num.length;
		for (int i = 0; i < len; i++) {
			System.out.println(num[i]);
		}
		
	
	}
}
