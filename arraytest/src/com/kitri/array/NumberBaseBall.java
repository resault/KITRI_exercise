package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
0. com, my 3자리 배열.
1. com 세자리 난수 발생. >>comRandom()
2. 1의 숫자는 중복숫자X
           0으로 시작X
3. 내가 입력한 3자리 숫자를 my 배열에 넣기
4. com과 my의 숫자와 자리 비교
5. 숫자가 같다면 
   5-1. 자리수가 같다면 strike 증가
   5-2. 자리수가 다르다면 ball 증가
6. 5의 결과
   6-1.strike가 3 : 
      xxx는 x번째 만에 정답입니다.
      계속(1),종료(0) :
   6-2.strike가 3이 아니라면:
       1. xxx는 x스트라이크 x볼 입니다. >> 3번으로 돌아가기
       

*/
public class NumberBaseBall {
	
	//field
	private int my[] = new int[3];
	private int com[] = new int[3];
	private int count;
	BufferedReader in; // 숫자입력

	//constructor
	public NumberBaseBall() {
		comRandom();
		in = new BufferedReader(new InputStreamReader(System.in));// 숫자입력
	}

	//method
	private void comRandom() { // 난수 발생
//		int com0;
//		int com1;
//		int com2;
		com[0] = (int) (Math.random() * 9) + 1;// 첫번째 자리는 0 불가
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
    	 System.out.print("숫자입력 : ");
         int myNum = getNumber();//숫자입력 메소드
         count++;
//         System.out.println(my[0] = myNum /100);
//         System.out.println(my[1] = (myNum %100)/10);
//         System.out.println(my[2] = myNum %10);
         my[0] = myNum /100; // 입력한 수 배열에 넣기
         my[1] = (myNum %100)/10;
         my[2] = myNum %10;         
         
         //숫자와 자리수 비교
         int strike = 0;
         int ball = 0;
         
         int len = my.length;
         for (int i = 0; i < len; i++) {
        	 for (int x = 0; x < len; x++) {
//        		 int ni = my[i];
//        		 int nx = com[x];
        		 if(my[i] == com[x]) { //equals 써야 하지 않나?
        			 if(i==x)
        				 strike++;
        			 else
        				 ball++;
        		 }
        	 }
         }
         
         //결과
         if (strike != 3) {
            System.out.println(count + ". "+ myNum +"는 "+ strike +"스트라이크 "+ ball +"볼 입니다.");
            break;
         }else {
        	 System.out.println(myNum +"는 "+count+"번째 만에 정답입니다.\n계속(1),종료(0) :");
        	 if(getNumber() == 0)
        		 exit();
         }
      }
	}
	
	
	private void exit() {
		System.out.println("게임을 종료합니다!!");
		System.exit(0);
	}

	private int getNumber() {// 숫자 입력하는 코드
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