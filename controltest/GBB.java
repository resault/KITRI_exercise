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
	public static void main(String[] args) {
		int my = 1;
		int com = (int) (Math.random() * 3);

		String myStr;
		String comStr;
		String resultStr;
		
		int result = (my - com + 2) % 3;
		if(result == 0) {
			resultStr = "�̰��.";
		} else if(result == 1) {
			resultStr = "����.";
		} else {
			resultStr = "����.";
		}

		switch(my) {
			case 0 : myStr = "����"; break;
			case 1 : myStr = "����"; break;
			default : myStr = "��"; break;
		}

		switch(com) {
			case 0 : comStr = "����"; break;
			case 1 : comStr = "����"; break;
			default : comStr = "��"; break;
		}

		System.out.println("�� : " + myStr + ", �� : " + comStr + " ��� : " + resultStr);
		
	}
}
