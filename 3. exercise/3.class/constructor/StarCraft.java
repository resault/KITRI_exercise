public class StarCraft {
	public static void main(String[] args) {
		Marine my = new Marine();
		Marine com = new Marine();
		
		int count;

		//��ü�� : 100  ��ü�� : 100
		count = 0;
		my.getStatus(com);
		
		count = 2;
		System.out.println('\n'+"���� ���� " + count + "ȸ ����!!!!");
		//��ü�� : 100  ��ü�� : 80
		my.attack(com, count);
		my.getStatus(com);

		count = 4;
		System.out.println('\n'+"���� ���� " + count + "ȸ ����!!!!");
		//��ü�� : 60  ��ü�� : 80
		com.attack(my, count);
		my.getStatus(com);

		System.out.println('\n'+"�� ��� ����!!!!");
		//��ü�� : 35  ��ü�� : 80
		my.changeMode();
		my.getStatus(com);

		count = 3;
		System.out.println('\n'+"���� ���� " + count + "ȸ ����!!!!");
		//��ü�� : 35  ��ü�� : 35
		my.attack(com, count);
		my.getStatus(com);		

		System.out.println('\n'+"�� ��� ����!!!!");
		//��� : ��� ���� �Ұ�~!!!!!
		//��ü�� : 35  ��ü�� : 35
		my.changeMode();
		my.getStatus(com);

		count = 3;
		System.out.println('\n'+"���� ���� " + count + "ȸ ����!!!!");
		//��ü�� : 35  ��ü�� : die
		my.attack(com, count);
		my.getStatus(com);
	}
}
