package com.kitri.util.jcf;

import java.util.*;

public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("황선혜");
		set.add("박미래");
		set.add("이혜린");
		set.add("조윤영");
		set.add("박미래");
		System.out.println("set의 크기 : " + set.size());
		
//		Object[] ob = set.toArray();
//		int len = ob.length;
//		for (int i = 0; i < len; i++) {
//			System.out.println((String)ob[i]);
//		}
		
		String[] str = set.toArray(new String[0]);
		int len = str.length;
		for (int i = 0; i < len; i++) {
			System.out.println(str[i]);
		}
		
		System.out.println("-----------------------------");
		Iterator<String> iterate = set.iterator();
		while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}
		
		
	}
}
