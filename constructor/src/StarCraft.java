public class StarCraft {
	public static void main(String[] args)	{
		Marine my = new Marine();//my���� ������ ��ü�� �ּҰ��� ���Ե�
		Marine com = new Marine();

		//��ü��: 100	��ü��: 100
		
		System.out.println("��ü��: "+ my.hp + "/ ��ü��: " + com.hp + '\n');


		int count = 2;
		System.out.println("���� ���� " + count + "ȸ ����!!!");		
		
		my.attack(com, count);
		System.out.println("��ü��: "+ my.hp + "/ ��ü��: " + com.hp + '\n');
		//��ü��: 100	��ü��: 80


		count = 4;
		System.out.println("���� ���� " + count + "ȸ ����!!!");	
		com.attack(my, count);
		System.out.println("��ü��: "+ my.hp + "/ ��ü��: " + com.hp + '\n');
		//��ü��: 60	��ü��: 80


		my.changeMode();
		System.out.println("��� ����!!!");		
		System.out.println("��ü��: "+ my.hp + "/ ��ü��: " + com.hp + '\n');
		//��ü��: 35	��ü��: 80


		count = 3;
		System.out.println("���� ���� " + count + "ȸ ����!!!");	
		int enemy = com.hp;
		my.attack(com, count);
		System.out.println("��ü��: "+ my.hp + "/ ��ü��: " + com.hp + '\n');
		//��ü��: 35	��ü��: 35


		System.out.println("��� ����!!!");
		my.changeMode();
		System.out.println("��ü��: "+ my.hp + "/ ��ü��: " + com.hp + '\n');		//���: ��� ���� �Ұ�~!!!
		//��ü��: 35	��ü��: 35


		count = 3;
		System.out.println("���� ���� " + count + "ȸ ����!!!");
		my.attack(com, count);
		String die = 
		System.out.println("��ü��: "+ my.hp + "/ ��ü��: " + com.hp + '\n');
		//��ü��: 35	��ü��: die
		

	}
}
