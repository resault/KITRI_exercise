public class PointCard {
	int cnt;
	String name;

	public PointCard(String name) {
		this.name = name;
	}
	
	public int visit() {
		return ++cnt; //방문자수
	}
}
