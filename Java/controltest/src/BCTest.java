public class BCTest {
	public static void main(String[] args)	{
		int count = 0;
		while(count <10) {
			count++;
			int number = (int) (Math.random() * 10);
			if (number == 0 ) {
				System.out.println("number가 0이 나왔습니다.\n프로그램 종료합니다.");
				break;
			}
			System.out.println("number ==" + number );
			
		}
		
		
		System.out.println("-----------------------------------------");


		count = 0;
		while(count <10) {
			count++;
			int number = (int) (Math.random() * 10);
			if (number == 0 ) {
				System.out.println("number가 0이 나왔습니다.\n다음으로 진행합니다.");
				continue;
			}
			System.out.println(count + ".number ==" + number );
		}
		

		count = 0;
		while(count <10) {
			count++;
			int number = (int) (Math.random() * 10);
			if (number == 0 ) {
				System.out.println("number가 0이 나왔습니다. 호출로 복귀합니다.");
				return;
			}
			System.out.println(count + ".number ==" + number );
		}


		System.out.println("프로그램 종료합니다!!!");
	}
}
