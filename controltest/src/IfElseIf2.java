/*
score(����)��
	90�̻��̸� ������ A
	80�̻��̸� ������ B
	70�̻��̸� ������ C
	60�̻��̸� ������ D
	60�̸��̸� ������ F

X5�̻��̸� x+����

��� : ������ xx���̹Ƿ� x�����Դϴ�.
*/

public class IfElseIf2 {
	public static void main(String[] args)	{
		int score = 58;
			
		String r;
		
		if (score > 100 || score < 0) {
			System.out.println("���� �߸� �Է��Ͽ����ϴ�.");
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
		
			if (score >= 60 && (score == 100 || score % 10 >= 5)) { //&&�� ||���� �켱������ ���⿡ ��ȣ ������� ��
				r += "+";
			}
			

		System.out.println("������ " + score + "���̹Ƿ� " + r + "�����Դϴ�.");
		}
	
	}
}
