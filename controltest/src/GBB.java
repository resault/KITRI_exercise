/*
* ���� ���� �� ����
1. 0 (����), 1 (����), 2 (��)
2. �� : ���� (0, 1, 2)
3. ��� Logic (��, ��, ��)
4. ��� ���
	�� : ��, �� : ����, ��� : ����.
	�� : ��, �� : ����, ��� : �̰��.
	�� : ��, �� : ��, ��� : ����.
*/ 
public class GBB {
	public static void main(String[] args)	{
		int my = 2;
		int com = (int) (Math.random() * 3);
		String resultStr;
		int result = (my - com +2) %3;

		if (result == 0) {
			resultStr = "�̰��.";
		} else if (result == 1) {
			resultStr = "����.";
		} else {
			resultStr = "����.";
		}
		String a;
		switch (my)	{
			case 0 : a = "����"; break;
			case 1 : a = "����"; break;
			default : a = "��";
		}
		String b;
		switch (com) {
			case 0 : b = "����"; break;
			case 1 : b = "����"; break;
			default : b = "��";
		}
		System.out.println("�� : " + a + ", �� : " + b + ", ��� : " + resultStr); 


		/* Ȯ��
		//�ʱ�ȭ ���1
		String b;
		switch (com) {
			case 0 : b = "����"; break;
			case 1 : b = "����"; break;
			default : b = "��";

		//�ʱ�ȭ ���1
		String b= " ";
		switch (com/3) {
			case 0 : b = "����"; break;
			case 1 : b = "����"; break;
			case 2 : b = "��"; break;

				//�ʱ�ȭ ���1
		String b;
		switch (com %3) {
			case 0 : b = "����"; break;
			case 1 : b = "����"; break;
			case 2 : b = "��";
		}
		*/
	}
}
