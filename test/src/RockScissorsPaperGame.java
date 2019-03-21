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
			System.out.print("����(0), ����(1), ��(2) �����ϼ���. : ");
			my = Integer.parseInt(in.readLine());
			if(my==0 || my==1 || my==2) {
				break;
			} else
				System.out.println("0-2�� �ϳ��� �Է� �����մϴ�.");
		}
	}



	private void game(int my) throws Exception {
		
		if((my-com)* == 2)//���� ���� 
			result = "����.";
		else if(my-com == 1)
			result = "�̰��.";
		else
			result = "����.";

		System.out.println("�� : " + (my==0 ? "����" : (my==1 ? "����" : "��")) +
			"       ��ǻ�� : " + (com==0 ? "����" : (com==1 ? "����" : "��")) + "    ����� : " + result);

		System.out.print("���� ���(1), ����(0)�� �Է��ϼ���");
		int i = Integer.parseInt(in.readLine());
		if (i==0)
			exit();
	}




	private void exit() {
		System.out.println("������ �����մϴ�!!");
		System.exit(0);
	}




	//main
	public static void main(String[] args) throws Exception {
	
		RockScissorsPaperGame rspGame = new RockScissorsPaperGame();
		
		System.out.println("==== ��ǻ�Ϳ� ���������� ����!!! =====");
		
		for(;;) {//while�� ����
			rspGame.menu();
			rspGame.comRandom();
			rspGame.game(rspGame.my);
		}
	}
}
