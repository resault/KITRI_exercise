/*
* 가위 바위 보 게임.
1. 0 (가위), 1 (바위), 2 (보)
2. 컴 : 난수 (0, 1, 2)
3. 결과 Logic (이, 지, 비)
4. 결과 출력
    나 : 보, 컴 : 바위 결과 : 이겼다.
	나 : 보, 컴 : 보 결과 : 비겼다.
	나 : 보, 컴 : 가위 결과 : 졌다.
*/
public class GBB {
	public static void main(String[] args)	{
		
		int my = (int) (Math.random() * 2);
		int com = (int) (Math.random() * 2);
		String result;

		if(my == com) {
			result = "비겼다.";
		} else if( ((my - com) +2 ) %3 == 0) {
			result = "이겼다.";
		} else {
			result = "졌다.";
		}


		String myR = my == 0 ? "가위" : (my == 1 ? "바위" : "보");
		String comR = com == 0 ? "가위" : (com == 1 ? "바위" : "보");

		System.out.println("나 : " + myR + ", 컴 : " + comR + ", 결과 : " + result);
		
	}
}
