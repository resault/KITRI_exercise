import java.io.*;

public class RockScissorsPaperGame {

	private int com;
	BufferedReader in;

	public RockScissorsPaperGame() {
		in = new BufferedReader(new InputStreamReader(System.in));
		comRandom();
	}

	public void comRandom() {
		com = (int)(Math.random() * 3);
	}

	public void menu() throws Exception {
		System.out.print("한판더(1), 종료(0) : ");
		int exit = Integer.parseInt(in.readLine());
		if(exit == 0)
			exit();
		else
			comRandom();
	}

	public void game(int my) throws Exception {
		int result = (my - com + 2) % 3;
		String resultStr = "";
		if(result == 0) {//이
			resultStr = "이겼다.";
		} else if(result == 1) {//졌
			resultStr = "졌다.";
		} else {//비
			resultStr = "비겼다.";
		}

		System.out.println("나 : " + gbb(my) + "\t컴 : " + gbb(com) + "\t결과 : " + resultStr);
		menu();
	}

	public String gbb(int num) {
		String gbb = "";
		if(num == 0) {
			gbb = "가위";
		} else if(num == 1){ 
			gbb = "바위";
		} else {
			gbb = "보";
		}
		return gbb;
	}

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) throws Exception {
		RockScissorsPaperGame gbb = new RockScissorsPaperGame();
		System.out.println("============ 컴퓨터와 가위 바위 보 한판 !!! ============");
		while(true) {
			System.out.print("가위(0) 바위(1) 보(2) 입력하세요 : ");
			int my = Integer.parseInt(gbb.in.readLine());
			if(my > 2) {
				System.out.println("가위(0) 바위(1) 보(2)만 입력 가능합니다.");	
				continue;
			}
			gbb.game(my);
		}
	}
}
