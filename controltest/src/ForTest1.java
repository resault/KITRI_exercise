public class ForTest1 {
	public static void main(String[] args)	{
		System.out.println("1 ~ 10���� ���.");
		for(int i=1;i<11;i++) {
			System.out.print(i + "  ");
		}

		System.out.println();

		System.out.println("\n1 ~ 10���� ���(Ȧ����).");
		for(int i=1;i<11;i=i+2) {	// i+=2
			System.out.print(i + "  ");
		}

		System.out.println("\n1 ~ 100���� ���(10������ �ٹٲ�).");
		for(int i=1;i<101;i++) {
			System.out.print((int)i + "  ");
			if(i %10 == 0){
				System.out.println();
			}

		}

		System.out.println("\n���α׷� ����!!!");
	}
}
