import java.io.*;

public class RockScissorsPaperGame {

	BufferedReader in;
	
	//field
	private int com;
	private int my;
	private String result;

	//constructor
	public RockScissorsPaperGame() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	//method
	private void comRandom() {
		com = (int)(Math.random() *3);//*3
	}



	private void menu() throws Exception {
		for(;;) {
			System.out.print("가위(0), 바위(1), 보(2) 선택하세요. : ");
			my = Integer.parseInt(in.readLine());
			if(my==0 || my==1 || my==2) {
				break;
			} else
				System.out.println("0-2중 하나만 입력 가능합니다.");
		}
	}



	private void game(int my) throws Exception {
		
		if((my-com)* == 2)//수식 수정 
			result = "비겼다.";
		else if(my-com == 1)
			result = "이겼다.";
		else
			result = "졌다.";

		System.out.println("나 : " + (my==0 ? "가위" : (my==1 ? "바위" : "보")) +
			"       컴퓨터 : " + (com==0 ? "가위" : (com==1 ? "바위" : "보")) + "    결과는 : " + result);

		System.out.print("게임 계속(1), 종료(0)을 입력하세요");
		int i = Integer.parseInt(in.readLine());
		if (i==0)
			exit();
	}




	private void exit() {
		System.out.println("게임을 종료합니다!!");
		System.exit(0);
	}




	//main
	public static void main(String[] args) throws Exception {
	
		RockScissorsPaperGame rspGame = new RockScissorsPaperGame();
		
		System.out.println("==== 컴퓨터와 가위바위보 한판!!! =====");
		
		for(;;) {//while로 변경
			rspGame.menu();
			rspGame.comRandom();
			rspGame.game(rspGame.my);
		}
	}
}
