public class FinalVariable {
	
	final int x = 10;

	public void a() {
		x = 20;//final variable는 값변경 불가능 (상수화)
	}

}
