public class IfElseIfTest1 {
	public static void main(String[] args) {
		int x = 210;
		int y = 110;
		String ds;
		if(x == y) {
			ds = "같다";
		} else if(x > y) {
			ds = "크다";
		} else {
			ds = "작다";
		}

		//ds = x == y ? "같다" : (x > y ? "크다" : "작다");

		System.out.println(x + "는 " + y + "보다 " + ds);
	}
}
