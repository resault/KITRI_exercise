import java.util.*;

public class AbstractTest1 {
	public static void main(String[] args) {
		//1. ���� Ŭ���� ����
		//Calendar cal = new GregorianCalendar();
		
		//2. �ڽ��� ��ü�� return �ϴ� static method.
		Calendar cal = Calendar.getInstance();
	
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DATE);
		int h = cal.get(Calendar.HOUR_OF_DAY);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		System.out.println(y + "�� " + m + "�� " + d + "�� " + 
			h + "�� " + mi + "�� " + s + "��");
	}
}
