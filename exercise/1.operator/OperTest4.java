public class OperTest4 {
	public static void main(String[] args)	{
		//삼항연산자

		//주민번호가 X인 당신은 XX입니다.
		int jumin = 2;
		String gender = jumin == 1 ? "남자" : "여자";
		System.out.println("주민번호가 " + jumin + "인 당신은 " + gender + "입니다.");//등가비교 가능

		//점수가 80 이상이면 합격, 80미만이면 불합격
		//당신의 점수는 xx이므로 xx입니다.
		int score = 98;
		String result = score >= 80 ? "합격" : "불합격";
		System.out.println("당신의 점수는 " + score + "이므로 " + result + "입니다.");//대소비교 가능

		//성별이 XX인 당신의 주민번호는 X입니다.
		gender = "여자";
		jumin = gender == "남자" ? 1 : 2;
		System.out.println("성별이 " + gender + "인 당신의 주민번호는 " + jumin + "입니다.");//문자열 비교 가능

	}
}
