public class Gugudan {
	public static void main(String[] args) {
		//for������ ������ �����

		//2*1=2 2*2=4...
		System.out.println("***������1***");
		for(int dan=2;dan<10;dan++) {
			System.out.println();
			for(int i=1;i<10;i++) {
				System.out.print(dan + " * " + i + " = " + dan*i + " ");
			}
		}
		
		System.out.println('\n');

		//2*1=2 3*1=3...
		System.out.println("***������2***");
		for(int i=1;i<10;i++) {
			System.out.println();
			for(int dan=2;dan<10;dan++) {
				System.out.print(dan + " * " + i + " = " + dan*i + " ");
			}
		
		}
	}
}
