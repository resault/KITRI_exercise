public class OperTest4 {
	public static void main(String[] args)	{
		//���׿�����

		//�ֹι�ȣ�� X�� ����� XX�Դϴ�.
		int jumin = 2;
		String gender = jumin == 1 ? "����" : "����";
		System.out.println("�ֹι�ȣ�� " + jumin + "�� ����� " + gender + "�Դϴ�.");//��� ����

		//������ 80 �̻��̸� �հ�, 80�̸��̸� ���հ�
		//����� ������ xx�̹Ƿ� xx�Դϴ�.
		int score = 98;
		String result = score >= 80 ? "�հ�" : "���հ�";
		System.out.println("����� ������ " + score + "�̹Ƿ� " + result + "�Դϴ�.");//��Һ� ����

		//������ XX�� ����� �ֹι�ȣ�� X�Դϴ�.
		gender = "����";
		jumin = gender == "����" ? 1 : 2;
		System.out.println("������ " + gender + "�� ����� �ֹι�ȣ�� " + jumin + "�Դϴ�.");//���ڿ� �� ����

	}
}
