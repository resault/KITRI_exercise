public class MultipleCheck {
	public static void main(String[] args)	{
		int num1 = 20;
		int num2 = 0;
		int num3 = 0;
		int num5 = 0;

		
		System.out.println("----------------------------");
		System.out.println("�ݺ� Ƚ���� �Է��ϼ��� : " + num1);
		
		for(int i=1;i<(num1+1);i++) {
			System.out.print(i + ".");
			if(i %2 == 0){
				System.out.print(" 2�ǹ��");
				num2++;
			} 
			if(i %3 == 0) {
				System.out.print(" 3�ǹ��");
				num3++;
			}
			if(i %5 == 0) {
				System.out.print(" 5�ǹ��");
				num5++;
			}
			System.out.println();
		}

		System.out.println("==== ��� Ƚ�� ====");
		System.out.println("2�� ��� : " + num2);
		System.out.println("3�� ��� : " + num3);
		System.out.println("5�� ��� : " + num5);
	}
}
