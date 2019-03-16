public class Gugudan {
	public static void main(String[] args) {
		//for문으로 구구단 만들기

		//2*1=2 2*2=4...
		System.out.println("***구구단1***");
		for(int dan=2;dan<10;dan++) {
			System.out.println();
			for(int i=1;i<10;i++) {
				System.out.print(dan + " * " + i + " = " + dan*i + " ");
			}
		}
		
		System.out.println('\n');

		//2*1=2 3*1=3...
		System.out.println("***구구단2***");
		for(int i=1;i<10;i++) {
			System.out.println();
			for(int dan=2;dan<10;dan++) {
				System.out.print(dan + " * " + i + " = " + dan*i + " ");
			}
		
		}
	}
}
