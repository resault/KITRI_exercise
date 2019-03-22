package com.kitri.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 다시 볼것!
0. com, my 3자리 배열
1. com 세자리 난수 발생 >> comRandom()
2. 1의 숫자는 중복 불가, 0으로 시작 불가
3. 내가 입력한 3자리 숫자를 my 배열에 넣기
4. com과 my의 숫자와 자리비교
5. 숫자가 같다면 
	- 자리수 같다면 strike 증가
	- 자리수 다르다면 ball 증가
6. 5의 결과
	6-1 strike가 3 :
		xxx는 x번째만에 정답입니다.
		계속(1), 종료(0) :
	6-2 strike가 3이 아니라면
		1. xxx는 x스트라이크 x볼입니다. >> 3번으로
*/

public class EENumberBaseBall {

	private int my[] = new int[3];
	private int com[] = new int[3];
	BufferedReader in;


	public NumberBaseBall() {
		comRandom();
		in = new BufferedReader(new InputStreamReader(System.in));
//		game(); //이렇게 하면 무한루프 돌렸을때 객체 생성이 끝나지 않음.. 응?
		
	}

	private void comRandom() {
		com[0] = ;
		com[0] = ;
		com[0] = ;
	}

	private void game()  {
		while(true) {
			System.out.print("숫자입력 : ");
			int myNum = 
		}
	}
	
	private int getNumber() {
		int num = 0;
		num = Integer.
		return num;
	}
	
	public static void main(String[] args) {
		NumberBaseBall nbb = new NumberBaseBall();
		nbb.game();
	}
}
