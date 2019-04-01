package com.kitri.util.jcf;

import java.util.*;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

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
