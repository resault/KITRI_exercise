/*
score(����)��
	90�̻��̸� ������ A
	80�̻��̸� ������ B
	70�̻��̸� ������ C
	60�̻��̸� ������ D
	60�̸��̸� ������ F

X5�̻��̸� X+����.

��� : ������ xx���̹Ƿ� X�����Դϴ�.
*/
public class IfElseIfTest2 {
	public static void main(String[] args)	{
		
		//int score = (int) Math.random() * 99 +1; //�켱���� ������ casting�ϰ� *99 +1�� ����Ǿ� 1�ۿ� �ȳ���
		int score = (int) (Math.random() * 99) + 1;
		String grade;

		if(score >= 90 || score == 100) 
			grade = "A";
		else if(score >= 80)
			grade = "B";
		else if(score >= 70)
			grade = "C";
		else if(score >= 60)
			grade = "D";
		else
			grade = "F";

		if(score > 60 && (score %10 > 4 || score == 100))
			grade += "+";

		System.out.println("������ " + score + "���̹Ƿ� " + grade + "�����Դϴ�.");
	}
}
