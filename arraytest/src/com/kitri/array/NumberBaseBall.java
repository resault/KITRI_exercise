package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
0. com, my 3�ڸ� �迭.
1. com ���ڸ� ���� �߻�. >>comRandom()
2. 1�� ���ڴ� �ߺ�����X
           0���� ����X
3. ���� �Է��� 3�ڸ� ���ڸ� my �迭�� �ֱ�
4. com�� my�� ���ڿ� �ڸ� ��
5. ���ڰ� ���ٸ� 
   5-1. �ڸ����� ���ٸ� strike ����
   5-2. �ڸ����� �ٸ��ٸ� ball ����
6. 5�� ���
   6-1.strike�� 3 : 
      xxx�� x��° ���� �����Դϴ�.
      ���(1),����(0) :
   6-2.strike�� 3�� �ƴ϶��:
       1. xxx�� x��Ʈ����ũ x�� �Դϴ�. >> 3������ ���ư���
       

*/
public class NumberBaseBall {
	
	//field
	private int my[] = new int[3];
	private int com[] = new int[3];
	private int count;
	BufferedReader in; // �����Է�

	//constructor
	public NumberBaseBall() {
		comRandom();
		in = new BufferedReader(new InputStreamReader(System.in));// �����Է�
	}

	//method
	private void comRandom() { // ���� �߻�
//		int com0;
//		int com1;
//		int com2;
		com[0] = (int) (Math.random() * 9) + 1;// ù��° �ڸ��� 0 �Ұ�
//		com0 = com[0];
		
		do {
			com[1] = (int) (Math.random() * 10);
//			com1 = com[1];
		} while (my[0] == com[1]);

		do {
			com[2] = (int) (Math.random() * 10);
//			com2 = com[2];
		} while (com[0] == com[2] || com[1] == com[2]);
	}

	private void game() {
      while(true) {
    	 System.out.println("" +com[0] + com[1] + com[2]);
    	 System.out.print("�����Է� : ");
         int myNum = getNumber();//�����Է� �޼ҵ�
         count++;
//         System.out.println(my[0] = myNum /100);
//         System.out.println(my[1] = (myNum %100)/10);
//         System.out.println(my[2] = myNum %10);
         my[0] = myNum /100; // �Է��� �� �迭�� �ֱ�
         my[1] = (myNum %100)/10;
         my[2] = myNum %10;         
         
         //���ڿ� �ڸ��� ��
         int strike = 0;
         int ball = 0;
         
         int len = my.length;
         for (int i = 0; i < len; i++) {
        	 for (int x = 0; x < len; x++) {
//        		 int ni = my[i];
//        		 int nx = com[x];
        		 if(my[i] == com[x]) { //equals ��� ���� �ʳ�?
        			 if(i==x)
        				 strike++;
        			 else
        				 ball++;
        		 }
        	 }
         }
         
         //���
         if (strike != 3) {
            System.out.println(count + ". "+ myNum +"�� "+ strike +"��Ʈ����ũ "+ ball +"�� �Դϴ�.");
            break;
         }else {
        	 System.out.println(myNum +"�� "+count+"��° ���� �����Դϴ�.\n���(1),����(0) :");
        	 if(getNumber() == 0)
        		 exit();
         }
      }
	}
	
	
	private void exit() {
		System.out.println("������ �����մϴ�!!");
		System.exit(0);
	}

	private int getNumber() {// ���� �Է��ϴ� �ڵ�
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

	//main
	public static void main(String[] args) {
		NumberBaseBall nbb = new NumberBaseBall();
		while(true) {
			nbb.game();
			
		}
	}
}