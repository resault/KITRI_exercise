public class IfElseTest1 {
	public static void main(String[] args)	{
		int x = 60;
		int y = 50;
		/*
		if (x > y) {
			System.out.println(x + "는" + y + "보다 크다.");
		} else {
			System.out.println(x + "는" + y + "보다 작다.");
		}
		*/

		
		
		/*
		String a;
		if (x > y) {
			a = "크다.";
		} else {
			a = "작다.";
		}
		System.out.println(x + "는 " + y + "보다 " + a );
		*/


		String b;
		if (x == y) {
			b = "같다.";
		} else {
			if (x < y){
				b = "작다.";
			} else {
				b = "크다.";
			}
		}
		System.out.println(x + "는 " + y + "보다 " + b );


		// 남자,여자 if로 만들어볼것


		System.out.println("프로그램 종료!!!!");
	}
}
