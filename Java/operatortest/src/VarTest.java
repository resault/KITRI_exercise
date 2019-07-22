public class VarTest 
{
	public static void main(String[] args) 
	{
		int age;
		age = 25;
		System.out.println("당신의 나이는 " + age + "입니다.");

		//String carName;
		//carName1 = "쏘나타";
		String carName;
		carName = "쏘나타";
		System.out.println("당신의 차이름은 " + carName + "입니다.");
		
		/*char gender;
		gender = '여';
		System.out.println("당신의 성별은 " + gender + "입니다.");
		이거 주석 해제하면 에러 발생함. 
		*/
		char gender;
		gender = '여';
		System.out.println("당신의 성별은 " + gender + "입니다.");


		// 변수를 두번이상 쓰더라도 선언은 한번밖에 없는 경우에는 에러 발생 없음. 변수 값이 그냥 바뀌게 됨
		char gender1;
		gender1 = '남';
		System.out.println("당신의 성별은 " + gender1 + "입니다.");
		
		gender1 = '여';
		System.out.println("당신의 성별은 " + gender1 + "입니다.");
		
	}
}
