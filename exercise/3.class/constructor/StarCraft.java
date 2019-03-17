public class StarCraft {
	public static void main(String[] args) {
		Marine my = new Marine();
		Marine com = new Marine();
		
		int count;

		//내체력 : 100  적체력 : 100
		count = 0;
		my.getStatus(com);
		
		count = 2;
		System.out.println('\n'+"내가 적을 " + count + "회 공격!!!!");
		//내체력 : 100  적체력 : 80
		my.attack(com, count);
		my.getStatus(com);

		count = 4;
		System.out.println('\n'+"적이 나를 " + count + "회 공격!!!!");
		//내체력 : 60  적체력 : 80
		com.attack(my, count);
		my.getStatus(com);

		System.out.println('\n'+"내 모드 변경!!!!");
		//내체력 : 35  적체력 : 80
		my.changeMode();
		my.getStatus(com);

		count = 3;
		System.out.println('\n'+"내가 적을 " + count + "회 공격!!!!");
		//내체력 : 35  적체력 : 35
		my.attack(com, count);
		my.getStatus(com);		

		System.out.println('\n'+"내 모드 변경!!!!");
		//경고 : 모드 변경 불가~!!!!!
		//내체력 : 35  적체력 : 35
		my.changeMode();
		my.getStatus(com);

		count = 3;
		System.out.println('\n'+"내가 적을 " + count + "회 공격!!!!");
		//내체력 : 35  적체력 : die
		my.attack(com, count);
		my.getStatus(com);
	}
}
