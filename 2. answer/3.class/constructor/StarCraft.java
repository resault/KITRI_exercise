public class StarCraft {
	public static void main(String[] args) {
		Marine my = new Marine();
		Marine com = new Marine();
		
		//��ü�� : 100  ��ü�� : 100
		System.out.println("��ü�� : " + my.getStatus() + "  ��ü�� : " + com.getStatus());
		
		int count = 2;
		System.out.println("���� ���� " + count + "ȸ ����!!!!");
		//��ü�� : 100  ��ü�� : 80
		my.attack(com, count);
		System.out.println("��ü�� : " + my.getStatus() + "  ��ü�� : " + com.getStatus());

		count = 4;
		System.out.println("���� ���� " + count + "ȸ ����!!!!");
		com.attack(my, count);
		//��ü�� : 60  ��ü�� : 80
		System.out.println("��ü�� : " + my.getStatus() + "  ��ü�� : " + com.getStatus());

		System.out.println("�� ��� ����!!!!");
		my.changeMode();
		//��ü�� : 35  ��ü�� : 80
		System.out.println("��ü�� : " + my.getStatus() + "  ��ü�� : " + com.getStatus());

		count = 3;
		System.out.println("���� ���� " + count + "ȸ ����!!!!");
		my.attack(com, count);
		//��ü�� : 35  ��ü�� : 35
		System.out.println("��ü�� : " + my.getStatus() + "  ��ü�� : " + com.getStatus());

		//�ð��� ������ �ڵ����� �Ϲ����� ���ƿ´�.
		my.changeMode();

		System.out.println("�� ��� ����!!!!");
		my.changeMode();
		//��� : ��� ���� �Ұ�~!!!!!
		//��ü�� : 35  ��ü�� : 35
		System.out.println("��ü�� : " + my.getStatus() + "  ��ü�� : " + com.getStatus());

		count = 3;
		System.out.println("���� ���� " + count + "ȸ ����!!!!");
		my.attack(com, count);
		//��ü�� : 35  ��ü�� : die
		System.out.println("��ü�� : " + my.getStatus() + "  ��ü�� : " + com.getStatus());

	}
}
