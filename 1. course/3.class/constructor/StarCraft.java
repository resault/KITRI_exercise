public class StarCraft {
	public static void main(String[] args)	{
		Marine my = new Marine();//my에는 생성된 객체의 주소값이 대입됨
		Marine com = new Marine();

		//내체력: 100	적체력: 100
		
		System.out.println("내체력: "+ my.hp + "/ 적체력: " + com.hp + '\n');


		int count = 2;
		System.out.println("내가 적을 " + count + "회 공격!!!");		
		
		my.attack(com, count);
		System.out.println("내체력: "+ my.hp + "/ 적체력: " + com.hp + '\n');
		//내체력: 100	적체력: 80


		count = 4;
		System.out.println("적이 나를 " + count + "회 공격!!!");	
		com.attack(my, count);
		System.out.println("내체력: "+ my.hp + "/ 적체력: " + com.hp + '\n');
		//내체력: 60	적체력: 80


		my.changeMode();
		System.out.println("모드 변경!!!");		
		System.out.println("내체력: "+ my.hp + "/ 적체력: " + com.hp + '\n');
		//내체력: 35	적체력: 80


		count = 3;
		System.out.println("내가 적을 " + count + "회 공격!!!");	
		int enemy = com.hp;
		my.attack(com, count);
		System.out.println("내체력: "+ my.hp + "/ 적체력: " + com.hp + '\n');
		//내체력: 35	적체력: 35


		System.out.println("모드 변경!!!");
		my.changeMode();
		System.out.println("내체력: "+ my.hp + "/ 적체력: " + com.hp + '\n');		//경고: 모드 변경 불가~!!!
		//내체력: 35	적체력: 35


		count = 3;
		System.out.println("내가 적을 " + count + "회 공격!!!");
		my.attack(com, count);
		String die = 
		System.out.println("내체력: "+ my.hp + "/ 적체력: " + com.hp + '\n');
		//내체력: 35	적체력: die
		

	}
}
