package com.kitri.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * �ٽ� ����!
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
		1. xxx�� x��Ʈ����ũ x���Դϴ�. >> 3������
*/

public class EENumberBaseBall {

	private int my[] = new int[3];
	private int com[] = new int[3];
	BufferedReader in;


	public NumberBaseBall() {
		comRandom();
		in = new BufferedReader(new InputStreamReader(System.in));
//		game(); //�̷��� �ϸ� ���ѷ��� �������� ��ü ������ ������ ����.. ��?
		
	}

	private void comRandom() {
		com[0] = ;
		com[0] = ;
		com[0] = ;
	}

	private void game()  {
		while(true) {
			System.out.print("�����Է� : ");
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
