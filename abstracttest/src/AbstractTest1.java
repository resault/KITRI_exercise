import java.util.*;

public class AbstractTest1 {
	public static void main(String[] args)	{
		//1. ���� Ŭ���� ����
		//Calendar cal = new Calendar(); //apiȮ���غ���, Calendar�� �߻�Ŭ�����̹Ƿ� ���� �Ұ�
		Calendar cal1 = new GregorianCalendar(); //Calendar�� ����Ŭ������ �����Ͽ� ��ü ����

		//2. �ڽ��� ��ü�� return�ϴ� static method ���
		Calendar cal2 = Calendar.getInstance();
		
		int y = cal2.get(Calendar.YEAR);
		int m = cal2.get(Calendar.MONTH)+1;//java�� 0���� �����ϱ⿡ 0�� january��
		int d = cal2.get(Calendar.DATE);
		int h = cal2.get(Calendar.HOUR_OF_DAY);
		int mi = cal2.get(Calendar.MINUTE);
		int s = cal2.get(Calendar.SECOND);
		System.out.println(y + "�� " + m + "�� " + d + "�� " + h +"�� " + mi +"�� "+ s + "�� ");

		

	}
}
