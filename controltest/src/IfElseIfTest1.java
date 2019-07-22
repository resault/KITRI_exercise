public class IfElseIfTest1 {
	public static void main(String[] args)	{
		int x = 10;
		int y = 5;


		String a, b = "보다 ";
		if (x == y)	{
			a = "같다.";
			b = "와 ";
		} else if(x > y) {
			a = "크다.";
		} else {
			a = "작다.";
		}
		System.out.println(x + "는 " + y + b + a); //삼항연산자로도 풀 수는 있지만 가독성이 떨어짐

		

		String c = "ㅇㅇ", d = "ㅋㅋ";
		System.out.println(c + d);
	}
}
