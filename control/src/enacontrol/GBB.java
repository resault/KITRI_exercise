/*
* ���� ���� �� ����.
1. 0 (����), 1 (����), 2 (��)
2. �� : ���� (0, 1, 2)
3. ��� Logic (��, ��, ��)
4. ��� ���
    �� : ��, �� : ���� ��� : �̰��.
	�� : ��, �� : �� ��� : ����.
	�� : ��, �� : ���� ��� : ����.
*/
public class GBB {
	public static void main(String[] args)	{
		
		int my = (int) (Math.random() * 2);
		int com = (int) (Math.random() * 2);
		String result;

		if(my == com) {
			result = "����.";
		} else if( ((my - com) +2 ) %3 == 0) {
			result = "�̰��.";
		} else {
			result = "����.";
		}


		String myR = my == 0 ? "����" : (my == 1 ? "����" : "��");
		String comR = com == 0 ? "����" : (com == 1 ? "����" : "��");

		System.out.println("�� : " + myR + ", �� : " + comR + ", ��� : " + result);
		
	}
}
