public class OperTest5 {
	public static void main(String[] args)	{

		//0의 나눗셈
		int z = 0 / 15;
		System.out.println("z = " + z);

		z = 15 / 0;
		System.out.println("z = " + z);//컴파일 에러는 나지 않지만, 실행하면 논리 에러 발생함
	}
}
