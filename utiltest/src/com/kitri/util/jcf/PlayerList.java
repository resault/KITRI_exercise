package com.kitri.util.jcf;

//ex. add()로 a, b, c 를 순서대로 입력한다고 했을 때,
//Vector는 동기화되어있기 때문에 순서는 보장되지만 속도는 느림
//ArrayList는 동기화되어있지 않기 때문에 순서가 완벽하게 보장되지는(but, 100%에 가까움) 않지만 속도는 빠름
// >> ArrayList를 더 많이 씀

import java.util.*;

public class PlayerList {
	
//	List<PlayerDto> list = new ArrayList<PlayerDto>();
	List<PlayerDto> list = new Vector<PlayerDto>();// ArrayList와 결과는 동일

	
	private void playerRegister(PlayerDto playerDto) { //선수 등록
		list.add(playerDto);
	}
	
	private void playerList() {//선수 전체 명단
		
		System.out.println("== 두산 베어스 팀명단 ==");
		System.out.println("-----------------------------------------------------------------");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
	}
	
	private PlayerDto playerSearch(int number) { //등번호로 선수 검색
		PlayerDto playerDto = null;
		int size = list.size();
		for(int i = 0; i<size ; i++) {
			PlayerDto dto = list.get(i);
			if(dto.getNumber() == number) {
				playerDto = dto;
				break;
			}
		}
		return playerDto; 
	}

	private void playerInfo(PlayerDto playerDto) { //일치하는 선수 검색
		if(playerDto != null) 
			System.out.println(playerDto);
		else
			System.out.println("일치하는 선수가 없습니다.");
	}
	
	public static void main(String[] args) {
		
		PlayerList pl = new PlayerList();
		
		pl.playerRegister(new PlayerDto(24, "오재원", 4, 0.321));
		pl.playerRegister(new PlayerDto(13, "허경민", 5, 0.351));
		pl.playerRegister(new PlayerDto(34, "린드블럼", 1, 0.001));
		pl.playerRegister(new PlayerDto(9, "페르난데스", 3, 0.421));
		pl.playerRegister(new PlayerDto(38, "김대한", 7, 0.384));
		
		pl.playerList();
		
		
		int number = 38;
		System.out.println(number + "번 선수 정보!!");
		PlayerDto playerDto = pl.playerSearch(number);
		
		pl.playerInfo(playerDto);
		
		number = 13;
		double score = 0.357; 
		System.out.println(number + "번 선수가 안타!!! 타율이 " + score + "로 변경");

		playerDto = pl.playerSearch(number);
		playerDto.setGrade(score);//Collection Frame는 주소값이 저장되므로 다시 list에 넣어줄 필요 없음
		pl.playerInfo(playerDto);
		
		pl.playerList();
		
		
	}
}
