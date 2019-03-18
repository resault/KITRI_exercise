import java.io.*;

public class Test {

	BufferedReader in;

	public Test() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public void game() throws Exception {
		System.out.print("0 1 2 ют╥б");
		int my = Integer.parseInt(in.readLine());
		System.out.println("my === " + my);
	}

	public static void main(String[] args) throws Exception {
	
		Test t = new Test();
		t.game();
		

	}
}
