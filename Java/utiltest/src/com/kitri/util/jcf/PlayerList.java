package com.kitri.util.jcf;

//ex. add()�� a, b, c �� ������� �Է��Ѵٰ� ���� ��,
//Vector�� ����ȭ�Ǿ��ֱ� ������ ������ ��������� �ӵ��� ����
//ArrayList�� ����ȭ�Ǿ����� �ʱ� ������ ������ �Ϻ��ϰ� ���������(but, 100%�� �����) ������ �ӵ��� ����
// >> ArrayList�� �� ���� ��

import java.util.*;

public class PlayerList {
	
//	List<PlayerDto> list = new ArrayList<PlayerDto>();
	List<PlayerDto> list = new Vector<PlayerDto>();// ArrayList�� ����� ����

	
	private void playerRegister(PlayerDto playerDto) { //���� ���
		list.add(playerDto);
	}
	
	private void playerList() {//���� ��ü ���
		
		System.out.println("== �λ� ��� ����� ==");
		System.out.println("-----------------------------------------------------------------");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
	}
	
	private PlayerDto playerSearch(int number) { //���ȣ�� ���� �˻�
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

	private void playerInfo(PlayerDto playerDto) { //��ġ�ϴ� ���� �˻�
		if(playerDto != null) 
			System.out.println(playerDto);
		else
			System.out.println("��ġ�ϴ� ������ �����ϴ�.");
	}
	
	public static void main(String[] args) {
		
		PlayerList pl = new PlayerList();
		
		pl.playerRegister(new PlayerDto(24, "�����", 4, 0.321));
		pl.playerRegister(new PlayerDto(13, "����", 5, 0.351));
		pl.playerRegister(new PlayerDto(34, "�����", 1, 0.001));
		pl.playerRegister(new PlayerDto(9, "�丣������", 3, 0.421));
		pl.playerRegister(new PlayerDto(38, "�����", 7, 0.384));
		
		pl.playerList();
		
		
		int number = 38;
		System.out.println(number + "�� ���� ����!!");
		PlayerDto playerDto = pl.playerSearch(number);
		
		pl.playerInfo(playerDto);
		
		number = 13;
		double score = 0.357; 
		System.out.println(number + "�� ������ ��Ÿ!!! Ÿ���� " + score + "�� ����");

		playerDto = pl.playerSearch(number);
		playerDto.setGrade(score);//Collection Frame�� �ּҰ��� ����ǹǷ� �ٽ� list�� �־��� �ʿ� ����
		pl.playerInfo(playerDto);
		
		pl.playerList();
		
		
	}
}
