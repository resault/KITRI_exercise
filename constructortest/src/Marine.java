/*
1. �Ӽ� : ü�� hp 100, ��� mode 0 (0: �Ϲ�, 1: ���)
2. ���
- ���� attack()
	1ȸ ���ݴ� ��ü�� ���� (0: -10, 1: -15)
- ��庯�� changeMode()
	��ü�� -25;
	��ü�� 40������ ���� ���� �Ұ�
*/
public class Marine {

	int hp;
	int mode;
	int damage;
	
	//������
	public Marine() {
		this(100, 0, 10);
	}

	public Marine(int hp, int mode, int damage) {
		this.hp = hp;
		this.mode = mode;
		this.damage = damage;
	}




/*
	Marine a = new Marine();
	Marine b = new Marine();

	a.attack2(b);

*/	//method
	public void attack(Marine a, int count) {
		a.hp -= count*damage;
		if (a.hp <= 0)	{
			System.out.println("die");
		} 

	}


	public void changeMode() {
		if (hp > 40) {
			hp -= 25;
			damage = 15;
		} else {
			System.out.println("���: ��� ���� �Ұ�~!!!");	
		}
	}


}
