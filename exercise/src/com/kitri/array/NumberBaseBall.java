package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
0. com, my 3�ڸ� �迭
1. com ���ڸ� ���� �߻� >> comRandom()
2. 1�� ���ڴ� �ߺ� �Ұ�, 0���� ���� �Ұ�
3. ���� �Է��� 3�ڸ� ���ڸ� my �迭�� �ֱ�
4. com�� my�� ���ڿ� �ڸ���
5. ���ڰ� ���ٸ� 
	- �ڸ��� ���ٸ� strike ����
	- �ڸ��� �ٸ��ٸ� ball ����
6. 5�� ���
	6-1 strike�� 3 :
		xxx�� x��°���� �����Դϴ�.
		���(1), ����(0) :
	6-2 strike�� 3�� �ƴ϶��
		1. xxx�� x��Ʈ����ũ x���Դϴ�. >> 3������!
*/

public class NumberBaseBall {

	// field
	private int com[] = new int[3];
	private int my[] = new int[3];
	BufferedReader in;

	// constructor
	public NumberBaseBall() {
		comRandom();// com���� �߻�
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
			System.out.println("���ڸ� �Է� : ");
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
		NumberBaseBall nbb = new NumberBaseBall();// NBB��ü ����
		nbb.game();
	}

}
