public class MultipleCheck {
	public static void main(String[] args) {
			int number = 30;
		for(int i=1;i<=number;i++) {
			System.out.print(i + ". ");
			
			int b2 = 0;
			int b3 = 0;
			int b5 = 0;
			if(i % 2 == 0) {
				System.out.print("2�� ��� ");
				b2++;
			}
			if(i % 3 == 0) {
				System.out.print("3�� ��� ");
				b3++;
			}
			if(i % 5 == 0) {
				System.out.print("5�� ��� ");
				b5++;
			}
			System.out.println();
		}
			System.out.println();

		System.out.println("==== ���Ƚ�� ====");
		System.out.println("2�ǹ�� : " + b2);
		System.out.println("3�ǹ�� : " + b3);
		System.out.println("5�ǹ�� : " + b5);

	}
}
