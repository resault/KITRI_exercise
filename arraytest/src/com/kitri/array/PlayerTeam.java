//지명타자 0, 투수, 포수, 1루수, 2루수, 3루수, 유격수, 좌익수, 중견수, 우익수
//타율, 방어율
package com.kitri.array;

public class PlayerTeam {

	public static void main(String[] args) {
		PlayerDto player[] = new PlayerDto[5];
		
		PlayerDto p1 = new PlayerDto(24, "오재원", 4, 0.321);
		PlayerDto p2 = new PlayerDto(13, "허경민", 5, 0.351);
		PlayerDto p3 = new PlayerDto(34, "린드블럼", 1, 0.001);
		PlayerDto p4 = new PlayerDto(9, "페르난데스", 3, 0.421);
		PlayerDto p5 = new PlayerDto(38, "김대한", 7, 0.384);
		
		player[0] = p1;
		player[1] = p2;
		player[2] = p3;
		player[3] = p4;
		player[4] = p5;
		

		int len = player.length;
		for (int i = 0; i < len; i++) {	//len을 player.length로 하면 player를 여러번 참조하기 때문에 비효율적
			System.out.print(player[i]);
		}
		
	}
}
//포지션 한글화, 타율/방어율 나오도록 바꿔볼 것