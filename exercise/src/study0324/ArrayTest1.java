package study0324;

public class ArrayTest1 {
	
	public static void main(String[] args) {
		//�⺻DT �迭
		int a[];
		a = new int[5];
		a[0] = 3;
		System.out.println(a[0]);
		
		int b[] = new int[4];
		System.out.println(b[3]);
		b[0] = 3;
		
		int c[] = {3};
		
		String d[] = new String[5];
		System.out.println(d[0]);

		//����
		boolean abb[];
		//����
		abb = new boolean[3];
		//���
		abb[0] = true;
		abb[1] = true;
		abb[2] = false;
		
		//���� �� ����
		char s[] = new char[2];
		
		System.out.println(s.length);
		
		int bb[] = new int[3];
		bb[0] = 50;
		bb[1] = 60;
		bb[2] = 70;

		System.out.println(bb.length); //3
	}
}
