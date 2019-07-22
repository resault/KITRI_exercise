import java.util.*;

public class AbstractTest1 {
	public static void main(String[] args)	{
		//1. 하위 클래스 참조
		//Calendar cal = new Calendar(); //api확인해보면, Calendar는 추상클래스이므로 생성 불가
		Calendar cal1 = new GregorianCalendar(); //Calendar의 하위클래스를 참조하여 객체 생성

		//2. 자신의 객체를 return하는 static method 사용
		Calendar cal2 = Calendar.getInstance();
		
		int y = cal2.get(Calendar.YEAR);
		int m = cal2.get(Calendar.MONTH)+1;//java는 0부터 시작하기에 0이 january임
		int d = cal2.get(Calendar.DATE);
		int h = cal2.get(Calendar.HOUR_OF_DAY);
		int mi = cal2.get(Calendar.MINUTE);
		int s = cal2.get(Calendar.SECOND);
		System.out.println(y + "년 " + m + "월 " + d + "일 " + h +"시 " + mi +"분 "+ s + "초 ");

		

	}
}
