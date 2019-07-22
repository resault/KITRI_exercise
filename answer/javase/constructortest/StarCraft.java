public class StarCraft {
	public static void main(String[] args) {
		Marine my = new Marine();
		Marine com = new Marine();
		
		//내체력 : 100  적체력 : 100
		System.out.println("내체력 : " + my.getStatus() + "  적체력 : " + com.getStatus());
		
		int count = 2;
		System.out.println("내가 적을 " + count + "회 공격!!!!");
		//내체력 : 100  적체력 : 80
		my.attack(com, count);
		System.out.println("내체력 : " + my.getStatus() + "  적체력 : " + com.getStatus());

		count = 4;
		System.out.println("적이 나를 " + count + "회 공격!!!!");
		com.attack(my, count);
		//내체력 : 60  적체력 : 80
		System.out.println("내체력 : " + my.getStatus() + "  적체력 : " + com.getStatus());

		System.out.println("내 모드 변경!!!!");
		my.changeMode();
		//내체력 : 35  적체력 : 80
		System.out.println("내체력 : " + my.getStatus() + "  적체력 : " + com.getStatus());

		count = 3;
		System.out.println("내가 적을 " + count + "회 공격!!!!");
		my.attack(com, count);
		//내체력 : 35  적체력 : 35
		System.out.println("내체력 : " + my.getStatus() + "  적체력 : " + com.getStatus());

		//시간이 지나면 자동으로 일반으로 돌아온다.
		my.changeMode();

		System.out.println("내 모드 변경!!!!");
		my.changeMode();
		//경고 : 모드 변경 불가~!!!!!
		//내체력 : 35  적체력 : 35
		System.out.println("내체력 : " + my.getStatus() + "  적체력 : " + com.getStatus());

		count = 3;
		System.out.println("내가 적을 " + count + "회 공격!!!!");
		my.attack(com, count);
		//내체력 : 35  적체력 : die
		System.out.println("내체력 : " + my.getStatus() + "  적체력 : " + com.getStatus());

	}
}
