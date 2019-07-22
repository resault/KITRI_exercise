package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {

	public static void main(String[] args) {
		
		List<Drama> list = new ArrayList<Drama>();
		list.add(new Drama("그 겨울, 바람이 분다.", "SBS", "김규태", "조인성", "송혜교")); //Drama d1 ~ d4를 생성하고 add할 필요 없이 바로 생성해서 대입
		list.add(new Drama("백년의 유산", "MBC", "주성우"));
		list.add(new Drama("아이리스2", "KBS", "표민수", "장혁", "이다해"));
		list.add(new Drama("최고다 이순신", "KBS", "윤성식", null, "아이유"));
		
		System.out.println("<< ArrayList>>를 이용한 드라마정보 >>");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + ". " + list.get(i).toString());
		}
	}
}
