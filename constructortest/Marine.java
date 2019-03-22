/*
1. 체력 hp 100, 모드 ( 0 : 일반, 1 : 흥분 )
2. 공격 attack()
     1회 공격당 적체력 (0 : -10, 1 : -15)
   모드변경 changeMode()
     내체력 -25;
	 내체력 40이하일 경우는 변경 불가.

	 call by value
	 call by reference
*/
public class Marine {

	int hp;
	int mode;
	int power; //내가 공격했을 때 감소되는 적의 피

	public Marine() {
		hp = 100;
		power = 10;
	}
	
	void attack(Marine enemy, int count) {
		for(int i=0;i<count;i++)
			enemy.hp -= power*count;
	}

	void changeMode() {
		if(hp > 40) {
			if(mode == 0) {
				mode = 1;
				hp -= 25;
				power = 15;
			} else {
				mode = 0;
				power = 10;
			}
		} else {
			System.out.println("경고 : 모드 변경 불가~!!!!!");
		}
	}

	String getStatus() {
		return hp < 0 ? "die" : hp + "";
	}

}
