/*
1. field
- 최대회전수(maxRotation) : 타이어 수명. 최대회전수에 도달하면 펑크남
- 누적회전수(accumulatedRotation) : 1번 회전할때마다 1씩 증가
- 타이어 위치(location)

2. method
- boolean roll() : 타이어를 1회전 시킴. true/false(펑크)
*/
public class Tire {

	int maxRotation;
	int accumulatedRotation;
	String location;

	public Tire(String location, int maxRotation) {
		this.maxRotation = maxRotation;
		this.location = location;
	}

	public boolean roll() {
		accumulatedRotation++;
		if(accumulatedRotation >= maxRotation) {
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false;
		} else {
			System.out.println(location + " Tire 남은 수명: " + (maxRotation - accumulatedRotation) + "회");
			return true;
		}
	}
}
