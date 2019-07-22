package com.kitri.util.jcf;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {

	public static void main(String[] args) {
		List<Drama> list = new ArrayList<Drama>();
				
		list.add(new Drama("그", "SBS", "김규태", "조인성", "송혜교"));
		list.add(new Drama("백", "MBC", "주성우"));
		list.add(new Drama("아", "KBS", "표민수", "장혁", "이다혜"));
		list.add(new Drama("최", "KBS", "윤성식", null, "아이유"));
		
		System.out.println("제목\t방송사\t감독\t남주\t여주");
		System.out.println("--------------------------------------");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
	}
	
}

















