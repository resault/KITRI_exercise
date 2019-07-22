package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
0. com, my 3�ڸ� �迭.
1. com ���ڸ� ���� �߻�. >> comRandom()
2. 1�� ���ڴ� �ߺ� ���� X
          0���� ���� X
3. ���� �Է��� 3�ڸ����ڸ� my �迭�� �ֱ�
4. com�� my�� ���ڿ� �ڸ���
5. ���ڰ� ���ٸ�
5-1. �ڸ��� ���ٸ� strike ����
5-2. �ڸ��� �ٸ��ٸ� ball ����.
6. 5�� ���
6-1. strike�� 3 : 
	xxx�� x��°���� �����Դϴ�. 
	���(1), ����(0) : 
6-2. strike�� 3�� �ƴ϶��
 1. xxx�� x��Ʈ����ũ x���Դϴ�. >> 3������
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
	private void comRandom() { // ���� �߻�
		com[0] = (int) (Math.random() * 9) + 1; // 0���� ����x

		do {
			com[1] = (int) (Math.random() * 10); // �ߺ�x
		} while (com[0] == com[1]);

		do {
			com[2] = (int) (Math.random() * 10);
		} while (com[0] == com[2] || com[1] == com[2]);
	}

	private int getNumber() { // �Է°� �޾ƿ���
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
		System.out.println("������ �����մϴ�!!");
		System.exit(0);
	}

	private void game() {
		while (true) {
			System.out.println("" + com[0] + com[1] + com[2]);
			System.out.print("�����Է� : ");
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
				System.out.println(count + ". " + myNum + "�� " + strike + "��Ʈ����ũ " + ball + "���Դϴ�.");
			} else {
				System.out.print(myNum + "�� " + count + "��°���� �����Դϴ�.\n���(1), ����(0) : ");
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
