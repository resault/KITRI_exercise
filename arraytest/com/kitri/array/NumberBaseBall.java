package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0. com, my 3�ڸ� �迭.
//1. com ���ڸ� ���� �߻�. >> comRandom()
//2. 1�� ���ڴ� �ߺ� ���� X
//            0���� ���� X
//3. ���� �Է��� 3�ڸ����ڸ� my �迭�� �ֱ�
//4. com�� my�� ���ڿ� �ڸ���
//5. ���ڰ� ���ٸ�
//  5-1. �ڸ��� ���ٸ� strike ����
//  5-2. �ڸ��� �ٸ��ٸ� ball ����.
//6. 5�� ���
//  6-1. strike�� 3 : 
//	xxx�� x��°���� �����Դϴ�. 
//	���(1), ����(0) : 
//  6-2. strike�� 3�� �ƴ϶��
//   1. xxx�� x��Ʈ����ũ x���Դϴ�. >> 3������


public class NumberBaseBall {
	
	private int my[] = new int[3];
	private int com[] = new int[3];
	BufferedReader in;
	
	public NumberBaseBall() {
		comRandom();
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	private void comRandom() {
		com[0] = ;		
		com[1] = ;		
		com[2] = ;		
	}
	
	private void game() {
		while(true) {
			System.out.print("�����Է� : ");
			int myNum = getNumber();//149
			my[0] = ;//1
			my[1] = ;//4
			my[2] = ;//9
			
			//���ڿ� �ڸ��� ��
			
			
			//���
			if(strike != 3) {
				
			} else {
				
			}
		}
	}
	
	private int getNumber() {
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

	public static void main(String[] args) {
		NumberBaseBall nbb = new NumberBaseBall();
		nbb.game();
	}
}
















