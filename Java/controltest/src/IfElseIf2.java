/*
score(점수)가
	90이상이면 학점은 A
	80이상이면 학점은 B
	70이상이면 학점은 C
	60이상이면 학점은 D
	60미만이면 학점은 F

X5이상이면 x+학점

결과 : 점수가 xx점이므로 x학점입니다.
*/

public class IfElseIf2 {
	public static void main(String[] args)	{
		int score = 58;
			
		String r;
		
		if (score > 100 || score < 0) {
			System.out.println("값을 잘못 입력하였습니다.");
		} else {

			if (score < 60)	{
				r = "F";
			} else if (score < 70) {
				r = "D";
			} else if (score < 80) {
				r = "C";
			} else if (score < 90) {
				r = "B";
			} else{
				r = "A";
			} 
		
			if (score >= 60 && (score == 100 || score % 10 >= 5)) { //&&가 ||보다 우선순위를 갖기에 괄호 입혀줘야 함
				r += "+";
			}
			

		System.out.println("점수가 " + score + "점이므로 " + r + "학점입니다.");
		}
	
	}
}
