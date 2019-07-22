package com.kitri.util.jcf;

//HashMap은 동기화X, key값은 중복 불가. key값이 동일한 값을 입력하면 덮어쓰기 됨
//Hashtable은 동기화 O
// >> HashMap을 더 많이 씀

import java.util.*;

public class MapTest {

	public static void main(String[] args) {
//		Map<String, PlayerDto> map = new HashMap<String, PlayerDto>();//generic m 은 일반적으로 String을 사용. object 이기만 하면 뭐든 가능
		Map<String, PlayerDto> map = new Hashtable<String, PlayerDto>();
		map.put("DS24", new PlayerDto(24, "오재원", 4, 0.321));
		map.put("DS9", new PlayerDto(9, "페르난데스", 3, 0.421));
		map.put("KW24", new PlayerDto(24, "박병호", 3, 0.431));
		map.put("HH9", new PlayerDto(9, "정근우", 7, 0.321));
		
		int size = map.size();
		System.out.println("등록 인원 : "+ size);
		
		int number = 24;
		System.out.println("두산의 " + number+ "번의 정보!!");
		PlayerDto playerDto = map.get("DS" + number);
		System.out.println(playerDto);
		System.out.println(map.values());//순서가 없기에 collection로 반환됨
		System.out.println(map.keySet());//key 값을 Set으로 반환함
		
	}
}
