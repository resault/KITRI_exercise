public class Store extends String {
	
	public static void main(String[] args) {
		PointCard p1 = new PointCard("�ڹ̷�");
		PointCard p2 = new PointCard("Ȳ����");
		System.out.println(p1.name + "�� ���� ����");
		int point = p1.visit();
		System.out.println(p1.name + "���� ����Ʈ�� " + point + "�Դϴ�.");

		System.out.println(p2.name + "�� ���� ����");
		point = p2.visit();
		System.out.println(p2.name + "���� ����Ʈ�� " + point + "�Դϴ�.");

		System.out.println(p2.name + "�� ���� ����");
		point = p2.visit();
		System.out.println(p2.name + "���� ����Ʈ�� " + point + "�Դϴ�.");
		System.out.println("------------------------------------------------");
		
		

		Guest g1 = new Guest("�ڹ̷�");
		Guest g2 = new Guest("Ȳ����");
		System.out.println(g1.name + "�� �湮!!!");
		int count = Guest.visit();
		System.out.println(g1.name + "���� " + Guest.cnt + "��° �湮���Դϴ�.");

		System.out.println(g2.name + "�� �湮!!!");
		count = Guest.visit();
		System.out.println(g2.name + "���� " + Guest.cnt + "��° �湮���Դϴ�.");

		System.out.println(g2.name + "�� �湮!!!");
		count = Guest.visit();
		System.out.println(g2.name + "���� " + Guest.cnt + "��° �湮���Դϴ�.");

	}

}
