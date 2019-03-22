package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
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
		1. xxx는 x스트라이크 x볼입니다. >> 3번으로!
*/

public class NumberBaseBall {

	// field
	private int com[] = new int[3];
	private int my[] = new int[3];
	BufferedReader in;

	// constructor
	public NumberBaseBall() {
		comRandom();// com난수 발생
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	// method
	private void comRandom() {
		com[0] = ;
		com[1] = ;
		com[2] = ;
	}

	private int getNumber() {
		int num = 0;
		try {
			num = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	private void game() {
		while (true) {
			System.out.println("숫자를 입력 : ");
			int myNum = getNumber();
			my[0] = ;
			my[1] = ;
			my[2] = ;
			
			if(strike != 3) {
				
			}else {
				
			}
		}
	}

	public static void main(String[] args) {
		NumberBaseBall nbb = new NumberBaseBall();// NBB객체 생성
		nbb.game();
	}

}
