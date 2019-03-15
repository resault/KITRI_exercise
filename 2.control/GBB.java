/*
* 가위 바위 보 게임
1. 0 (가위), 1 (바위), 2 (보)
2. 컴 : 난수 (0, 1, 2)
3. 결과 Logic (이, 지, 비)
4. 결과 출력
	나 : 보, 컴 : 가위, 결과 : 졌다.
	나 : 보, 컴 : 바위, 결과 : 이겼다.
	나 : 보, 컴 : 보, 결과 : 비겼다.
*/ 
public class GBB {
	public static void main(String[] args)	{
		int my = 2;
		int com = (int) (Math.random() * 3);
		String resultStr;
		int result = (my - com +2) %3;

		if (result == 0) {
			resultStr = "이겼다.";
		} else if (result == 1) {
			resultStr = "졌다.";
		} else {
			resultStr = "비겼다.";
		}
		String a;
		switch (my)	{
			case 0 : a = "가위"; break;
			case 1 : a = "바위"; break;
			default : a = "보";
		}
		String b;
		switch (com) {
			case 0 : b = "가위"; break;
			case 1 : b = "바위"; break;
			default : b = "보";
		}
		System.out.println("나 : " + a + ", 컴 : " + b + ", 결과 : " + resultStr); 


		/* 확인
		//초기화 방법1
		String b;
		switch (com) {
			case 0 : b = "가위"; break;
			case 1 : b = "바위"; break;
			default : b = "보";

		//초기화 방법1
		String b= " ";
		switch (com/3) {
			case 0 : b = "가위"; break;
			case 1 : b = "바위"; break;
			case 2 : b = "보"; break;

				//초기화 방법1
		String b;
		switch (com %3) {
			case 0 : b = "가위"; break;
			case 1 : b = "바위"; break;
			case 2 : b = "보";
		}
		*/
	}
}
