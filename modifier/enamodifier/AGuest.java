public class Guest {

	static int cnt;//Class ����
	String name;//instance ����

	public Guest(String name) {
		this.name = name;
	}
	
	public static int visit() {
		cnt++;
		return cnt;
	}

	
}
