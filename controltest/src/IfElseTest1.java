public class IfElseTest1 {
	public static void main(String[] args)	{
		int x = 60;
		int y = 50;
		/*
		if (x > y) {
			System.out.println(x + "��" + y + "���� ũ��.");
		} else {
			System.out.println(x + "��" + y + "���� �۴�.");
		}
		*/

		
		
		/*
		String a;
		if (x > y) {
			a = "ũ��.";
		} else {
			a = "�۴�.";
		}
		System.out.println(x + "�� " + y + "���� " + a );
		*/


		String b;
		if (x == y) {
			b = "����.";
		} else {
			if (x < y){
				b = "�۴�.";
			} else {
				b = "ũ��.";
			}
		}
		System.out.println(x + "�� " + y + "���� " + b );


		// ����,���� if�� ������


		System.out.println("���α׷� ����!!!!");
	}
}
