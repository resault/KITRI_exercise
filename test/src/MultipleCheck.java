import java.io.*;

public class MultipleCheck {

	BufferedReader in;

		int num1;
		int num2;
		int num3;
		int num5;

	public MultipleCheck() {
		in = new BufferedReader(new InputStreamReader(System.in));
		int num2 = 0;
		int num3 = 0;
		int num5 = 0;

	}

	public void run() throws Exception {
	
		System.out.println("----------------------------");
		
		System.out.print("반복 횟수를 입력하세요 : ");
		num1 = Integer.parseInt(in.readLine());
	
		for(int i=1;i<(num1+1);i++) {
			System.out.print(i + ".");
			if(i %2 == 0){
				System.out.print(" 2의배수");
				num2++;
			} 
			if(i %3 == 0) {
				System.out.print(" 3의배수");
				num3++;
			}
			if(i %5 == 0) {
				System.out.print(" 5의배수");
				num5++;
			}
			System.out.println();
		}

		System.out.println("==== 출력 횟수 ====");
		System.out.println("2의 배수 : " + num2);
		System.out.println("3의 배수 : " + num3);
		System.out.println("5의 배수 : " + num5);
	}

	public static void main(String[] args) throws Exception {

		MultipleCheck app = new MultipleCheck();
		app.run();
		
	}
}
