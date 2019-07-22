public class AbstractTest2 {
	public static void main(String[] args) throws Exception	{

		//3. 외부클래스 참조
		Runtime r = Runtime.getRuntime();//Runtime의 생성자는 private이라 new로 호출 불가하므로 static method 이용함
		Process p = r.exec("calc");

	}
}
