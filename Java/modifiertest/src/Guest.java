public class Guest {
	static int cnt;//Class ���� (Ŭ������ �����ؾ� ��)
	String name;//instance ���� (��ü�� �����ؾ� ��)

	public Guest(String name) {
		this.name = name;
	}
	
	public static int visit() {
		return ++cnt; //static method������ non-static ������ ȣ���� �� ���⿡, ���⼭ cnt�� static�� ����� ���� �߻���
	}
}
