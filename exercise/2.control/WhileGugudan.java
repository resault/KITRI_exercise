public class WhileGugudan {
	public static void main(String[] args) {
		//***구구단***
		//2*1=2 3*1=3...
		System.out.println("***구구단***");
		for(int i=1;i<10;i++) {
			System.out.println();
			for(int dan=2;dan<10;dan++) {
				System.out.print(dan + " * " + i + " = " + dan*i + " ");
			}
		}
	}
}
