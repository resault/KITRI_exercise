public class WhileGugudan {
	public static void main(String[] args) {
		System.out.println(" ** ±¸±¸´Ü **");
		int dan = 2;
		while(dan < 10) {
			int i = 1;
			while(i < 10) {
				System.out.print(dan + " * " + i + " = " + dan * i + "  ");
				i++;
			}
			dan++;
			System.out.print("\n");
		}
	}
}
