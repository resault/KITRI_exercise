package com.ex.St0401;

import java.util.*;
/*
setÀÇ Å©±â : 4
Á¶À±¿µ
È²¼±Çý
¹Ú¹Ì·¡
ÀÌÇý¸°
-----------------------------
Á¶À±¿µ
È²¼±Çý
¹Ú¹Ì·¡
ÀÌÇý¸°
*/
public class RSetTest {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		System.out.println(set.size());
		set.add("Á¶À±¿µ");
		set.add("È²¼±Çý");
		set.add("¹Ú¹Ì·¡");
		set.add("ÀÌÇý¸°");
		System.out.println(set.size());
		
//		String[] str = set.toArray(new String[0]);
//		int len = str.length;
//		for(int i =0;i<len;i++) {
//			System.out.println(str[i]);
//		}

		Iterator<String> iterate = set.iterator();
		while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}
		
		
	}
}
