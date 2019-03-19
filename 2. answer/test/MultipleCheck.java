public class MultipleCheck {
	public static void main(String[] args) {
		int number = 30;
		int b2 = 0;
		int b3 = 0;
		int b5 = 0;
		for(int i=1;i<=number;i++) {
			System.out.print(i + ". ");
			if(i % 2 == 0) {
				System.out.print("2의 배수 ");
				b2++;
			}
			if(i % 3 == 0) {
				System.out.print("3의 배수 ");
				b3++;
			}
			if(i % 5 == 0) {
				System.out.print("5의 배수 ");
				b5++;
			}
			System.out.println();
		}
		System.out.println("==== 출력횟수 ====");
		System.out.println("2의배수 : " + b2);
		System.out.println("3의배수 : " + b3);
		System.out.println("5의배수 : " + b5);

	}
}
