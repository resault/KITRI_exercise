public class ForTest1 {
	public static void main(String[] args)	{
		System.out.println("1 ~ 10까지 출력.");
		for(int i=1;i<11;i++) {
			System.out.print(i + "  ");
		}

		System.out.println();

		System.out.println("\n1 ~ 10까지 출력(홀수만).");
		for(int i=1;i<11;i=i+2) {	// i+=2
			System.out.print(i + "  ");
		}

		System.out.println("\n1 ~ 100까지 출력(10개단위 줄바꿈).");
		for(int i=1;i<101;i++) {
			System.out.print((int)i + "  ");
			if(i %10 == 0){
				System.out.println();
			}

		}

		System.out.println("\n프로그램 종료!!!");
	}
}
