/*
1. ü�� hp 100, ��� ( 0 : �Ϲ�, 1 : ��� )
2. ���� attack()
     1ȸ ���ݴ� ��ü�� (0 : -10, 1 : -15)
   ��庯�� changeMode()
     ��ü�� -25;
	 ��ü�� 40������ ���� ���� �Ұ�.
*/
public class Marine {
	//field
	int hp;
	int mode;
	int damage;

	//constructor
	public Marine() {
		hp = 100;
		mode = 0;
		damage = 10;
	}

	//method
	public void changeMode() {
		if(hp > 40) {
			hp -= 25;
			mode = 1;
			damage = 15;
		} else {
			System.out.println("��� : ��� ���� �Ұ�~!!!!!");
			mode = 0;
		}
	}
	/* //��� ��ȯ �� ��尡 �ٽ� �ʱ�ȭ �Ǵ� ���·� ������� if���� ��ø�ؼ� ����ϴ� ���� ����
	if(hp < 40) {
		if(mode==0) {
			hp -= 25;
			mode = 1;
			damage = 15;
		} else {
			mode = 0;
			damage = 10;
		}
	} else {
		System.out.println("��� : ��� ���� �Ұ�~!!!!!");
	}
	*/

	public void attack(Marine enemy, int count) {
		enemy.hp -= damage * count;
	}
	
	public void getStatus(Marine enemy) {
		System.out.println("��ü�� : " + (hp < 0 ? "die" : hp) + "/ ��ü�� : " + (enemy.hp < 0 ? "die" : enemy.hp));
	}
}
