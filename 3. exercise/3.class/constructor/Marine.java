/*
1. 체력 hp 100, 모드 ( 0 : 일반, 1 : 흥분 )
2. 공격 attack()
     1회 공격당 적체력 (0 : -10, 1 : -15)
   모드변경 changeMode()
     내체력 -25;
	 내체력 40이하일 경우는 변경 불가.
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
			System.out.println("경고 : 모드 변경 불가~!!!!!");
			mode = 0;
		}
	}
	/* //모드 전환 후 모드가 다시 초기화 되는 형태로 만드려면 if문을 중첩해서 사용하는 것이 좋음
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
		System.out.println("경고 : 모드 변경 불가~!!!!!");
	}
	*/

	public void attack(Marine enemy, int count) {
		enemy.hp -= damage * count;
	}
	
	public void getStatus(Marine enemy) {
		System.out.println("내체력 : " + (hp < 0 ? "die" : hp) + "/ 적체력 : " + (enemy.hp < 0 ? "die" : enemy.hp));
	}
}
