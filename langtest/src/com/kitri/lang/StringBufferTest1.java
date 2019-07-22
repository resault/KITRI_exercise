package com.kitri.lang;

public class StringBufferTest1 {
	
	public static void main(String[] args) {
		
		// 1. ������
		// StringBuffer() : default ������
		StringBuffer sb1 = new StringBuffer();//16���� ���ڰ� �� �� �ִ� �� �ӽ����� ���� ����
		
			// capacity() : �ʱ� ũ��
		int cap = sb1.capacity();
		System.out.println(cap); //16
		
			// length() : ����� ������ ũ��
		System.out.println("���ڿ� �� : " + sb1.length()); //0
		
		
		// StringBuffer(int capacity) : ���ڰ���ŭ�� �ӽ����� ���� ����(��� 8�� ����� �����)
		//�ٵ� ���ڷ� �����ص� ���ڼ����� ū ������ �����⶧���� �� �ǹ� ����
		
		// StringBuffer(CharSequence seq) | StringBuffer(String str) : ���ڿ��� ������ �ӽ����� ���� ����
		// CharSequence�� interface 
		sb1 = new StringBuffer("hello");
		cap = sb1.capacity();
		System.out.println("1. sb1 == " + sb1);
		System.out.println("ũ��" + sb1.capacity() + "���ڿ� �� : " + sb1.length());
		

		
		//append() : String�� concat�� �޸� ���ڿ� ��ü�� �ٲ�
		sb1.append(" java");
		System.out.println("2. sb1 == " + sb1);//hello java
		
			//cf.
		String s = "hello";
		s.concat("java");
		System.out.println(s);//hello

		sb1.append(" !!!!!");
		System.out.println("3. sb1 == " + sb1);//hello java !!!!!
		cap = sb1.capacity();
		System.out.println("ũ�� : " +cap + "\t���ڿ� �� : " + sb1.length());
		
		sb1.append(" !!!!!!");
		System.out.println("4. sb1 == " + sb1);//hello java !!!!! !!!!!!
		cap = sb1.capacity();
		System.out.println("ũ�� : " +cap + "\t���ڿ� �� : " + sb1.length()); //������ �Ѿ�� �ڵ����� �þ

		
		// 2. method
		
		// 1) charAt(int index)
		
		
		// 2) insert(int offset, �Է��� data) : ���� ��ġ�� ���ڰ� �Է�
		sb1.insert(10, "@@@");
		System.out.println("5. sb1 == " + sb1);

		
		// 3) delete(int start, int end) : start���� end ��ġ ������ ����
		sb1.delete(10, 12);
		System.out.println("6. sb1 == " + sb1);
		
		
		// 4) deleteCharAt(int index) : index ��ġ�� �� ����
		sb1.deleteCharAt(10);
		System.out.println("7. sb1 == " + sb1);
		
		
		// 5) indexOf(String str)
		
		
		// 6) replace(int start, int end, String str) : start���� end������ str�� ��ü (cf. String�� replace)
		sb1.replace(6, 10, "�ڹ�");
		System.out.println("8. sb1 == " + sb1);
		
		
		// 7) reverse()
		sb1.reverse();
		System.out.println("9. sb1 == " + sb1);
		sb1.reverse();
		
		
		// 8) setCharAt(int index, char ch) : index�� ���� char�� ����
		sb1.setCharAt(9, '@');
		System.out.println("10. sb1 == " + sb1);
		
		
		// 9) substring(int start)
		
		
		// ���������� sb1���� StringBuffer�� ��������Ƿ� String���� �ٲ���� �� (2���� ���)
		// String ������ �̿�
		String s1 = new String(sb1);
		// StringBuffer�� toString()�̿�
		String s2 = sb1.toString();

		
		// ����
		String str = "hello �ڹ� !!!";
		String findstr = "�ڹ�";
//		String findstr = "����Ŭ";
		String restr = "java";
		
		//hello java !!!
		//����Ŭ�� �����ϴ�.
		int start = str.indexOf(findstr);
		
		if(start != 0) {
			StringBuffer sb = new StringBuffer(str);
			int end = start + findstr.length();
//			System.out.println(start + restr.length() -1);
			sb.replace(start, end, restr);
			System.out.println(sb.toString());
		} else {
			System.out.println(findstr + "�� �����ϴ�.");
		}
		
		
		// ���� �ٽ�!!
		
		

	}
}
