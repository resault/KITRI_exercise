package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
0. com, my 3자리 배열.
1. com 세자리 난수 발생. >> comRandom()
2. 1의 숫자는 중복 숫자 X
          0으로 시작 X
3. 내가 입력한 3자리숫자를 my 배열에 넣기
4. com과 my의 숫자와 자리비교
5. 숫자가 같다면
5-1. 자리수 같다면 strike 증가
5-2. 자리수 다르다면 ball 증가.
6. 5의 결과
6-1. strike가 3 : 
	xxx는 x번째만에 정답입니다. 
	계속(1), 종료(0) : 
6-2. strike가 3이 아니라면
 1. xxx는 x스트라이크 x볼입니다. >> 3번으로
*/

public class NumberBaseBall {

	// field
	private int my[] = new int[3];
	private int com[] = new int[3];
	private int count;
	BufferedReader in;

	// constructor
	public NumberBaseBall() {
		comRandom();
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	// method
	private void comRandom() { // 난수 발생
		com[0] = (int) (Math.random() * 9) + 1; // 0으로 시작x

		do {
			com[1] = (int) (Math.random() * 10); // 중복x
		} while (com[0] == com[1]);

		do {
			com[2] = (int) (Math.random() * 10);
		} while (com[0] == com[2] || com[1] == com[2]);
	}

	private int getNumber() { // 입력값 받아오기
		int num = 0;
		try {
			num = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}

	private void exit() {
		System.out.println("게임을 종료합니다!!");
		System.exit(0);
	}

	private void game() {
		while (true) {
			System.out.println("" + com[0] + com[1] + com[2]);
			System.out.print("숫자입력 : ");
			int myNum = getNumber();
			count++;

			my[0] = myNum / 100;
			my[1] = (myNum % 100) / 10;
			my[2] = myNum % 10;

			int strike = 0;
			int ball = 0;

			int len = my.length;
			for (int i = 0; i < len; i++) {
				for (int x = 0; x < len; x++) {
					if (my[i] == com[x]) {
						if (i == x) {
							strike++;
							break;
						} else {
							ball++;
							break;
						}

					}
				}
			}

			if (strike != 3) {
				System.out.println(count + ". " + myNum + "는 " + strike + "스트라이크 " + ball + "볼입니다.");
			} else {
				System.out.print(myNum + "는 " + count + "번째만에 정답입니다.\n계속(1), 종료(0) : ");
				if (getNumber() == 0)
					exit();
				else {
					comRandom();
					count = 0;
				}
			}
		}
	}

	// main
	public static void main(String[] args) {
		NumberBaseBall nbb = new NumberBaseBall();
		nbb.game();
	}

}
