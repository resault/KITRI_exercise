public class IfElseIfTest1 {
	public static void main(String[] args) {
		int x = 210;
		int y = 110;
		String ds;
		if(x == y) {
			ds = "����";
		} else if(x > y) {
			ds = "ũ��";
		} else {
			ds = "�۴�";
		}

		//ds = x == y ? "����" : (x > y ? "ũ��" : "�۴�");

		System.out.println(x + "�� " + y + "���� " + ds);
	}
}
