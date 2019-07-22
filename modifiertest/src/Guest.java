public class Guest {
	static int cnt;//Class 변수 (클래스를 참조해야 함)
	String name;//instance 변수 (객체를 참조해야 함)

	public Guest(String name) {
		this.name = name;
	}
	
	public static int visit() {
		return ++cnt; //static method에서는 non-static 변수를 호출할 수 없기에, 여기서 cnt의 static을 지우면 에러 발생함
	}
}
