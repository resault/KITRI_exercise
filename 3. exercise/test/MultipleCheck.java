/*
- �Է°� �޾ƿ���
*/
import java.io.*;

public class MultipleCheck {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int num1;
		int num2 = 0;
		int num3 = 0;
		int num5 = 0;
		
		System.out.println("--------------------------");
		System.out.print("�ݺ� Ƚ���� �Է��ϼ��� : ");
		num1 = Integer.parseInt(in.readLine());

		for(int i=1;i<=num1;i++) {
			System.out.print(i + ".");
			if(i %2 == 0) {
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
