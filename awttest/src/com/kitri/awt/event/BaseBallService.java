package com.kitri.awt.event;

import java.awt.Color;
import java.io.BufferedReader;
import java.util.Random;

public class BaseBallService {//if문 안에 들어갈 logic을 method로!

	BaseBallController baseBallController;
	private BaseBall bb;
	private FontColorChooser fcc;
	
	private int my[];
	private int com[];
	int gameLength;
	Random random = new Random();
//	BufferedReader in; //이건 이제 필요 없음... 확인!
	int count;
	
	int r;
	int g;
	int b;
	
	public BaseBallService(BaseBallController baseBallController) {
		this.baseBallController = baseBallController;
		bb = baseBallController.baseBall;
		fcc = bb.fontColorChooser;
		gameLength = 3;
		my = new int[gameLength];
		com = new int[gameLength];
		newG();
	}
	
	public void newG() {
		com[0] = random.nextInt(9) + 1;	//math.random 대신 random 클래스 사용
		do {
			com[1] = random.nextInt(10);
		}while (com[0] == com[1]);
		do {
			com[2] = random.nextInt(10);
		}while (com[0] == com[2] || com[1] == com[2]);	
		bb.tf.setEnabled(true);;
		clear();
		viewResult("새로운 게임을 시작합니다.");
		count = 0;
		System.out.println("컴터 : " + com[0] + com[1] + com[2]);
		
	}

	public void clear() {
		bb.ta.setText(" ");
	}

	public void showDap() {
		viewResult("정답은 " + com[0]+ com[1]+ com[2]+ "입니다.");
		viewResult("새게임 또는 종료를 누르세요!!!");
		bb.tf.setEnabled(false);;
	}

	public void fontColorChange() {
		fcc.setVisible(true);
		changeColor();
	}

	public void exit() {
		System.exit(0);
	}

	public void game() {
		int strike = 0;
		int ball = 0;
		String myNumStr = bb.tf.getText().trim();
		bb.tf.setText("");
		
		if (myNumStr.length() != gameLength) {//null이 아님
			viewResult("3자리 숫자를 입력하세요!!!");
			return;
		}
		
		if(!isNumber(myNumStr)) {
			viewResult("숫자만 입력하세요!!!");
			return;
		}
		
		for(int i = 0;i < gameLength; i++) {
			my[i] = myNumStr.charAt(i)-48; //이거 확인
		}
		for (int m = 0; m < gameLength; m++) {
			for (int c = 0; c < gameLength; c++) {
				if(my[m] == com[c]) { //같은 숫자라면..
					if(m == c)//자리수 같다면...
						strike++;
					else
						ball++;
				}
			}
		}
		count++;
		if(strike != gameLength) {
			viewResult(count + ". " + myNumStr + "은 " + strike + "스트라이크 " + ball + "볼입니다.");
		} else {
			viewResult(myNumStr + "은 " + count + "번만에 정답입니다.");
			viewResult("새게임 또는 종료를 누르세요!!!");
			bb.tf.setEnabled(false);;
		}
	}

	
	private void viewResult(String msg) {
		bb.ta.append(msg+"\n");
	}

	private boolean isNumber(String str) {
		boolean flag = true;
		for (int i = 0; i < gameLength; i++) {
			int num = str.charAt(i) - 48;
			if(num < 0 || num > 9) {
				flag = false;
				break;
			}
		}		
		return flag;
	}
	
	public void changeColor() {
		r = fcc.sbR.getValue();
		g = fcc.sbG.getValue();
		b = fcc.sbB.getValue();
		
		fcc.colorP.setBackground(new Color(r, g, b));
		fcc.colorL.setText("r = " + r + "\tg = " + g + "\tb = " + b);
	}

	public void selectColor() {
		bb.ta.setForeground(new Color(r, g, b));//새로 getValue안해도 현재 값 받아오는 거 확인
		fcc.setVisible(false);
	}
}
