/*
1. 속성 : 체력 hp 100, 모드 mode 0 (0: 일반, 1: 흥분)
2. 기능
- 공격 attack()
	1회 공격당 적체력 감소 (0: -10, 1: -15)
- 모드변경 changeMode()
	내체력 -25;
	내체력 40이하일 경우는 변경 불가
*/
public class Marine {

	int hp;
	int mode;
	int damage;
	
	//생성자
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
			System.out.println("경고: 모드 변경 불가~!!!");	
		}
	}


}
