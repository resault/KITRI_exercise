public class Car {

	String carName;
	String color;
	String maker;
	int speed;

	//public Car() {} >> default ������

	public void speedUp() {
		speed += 10;
	}

	public void speedDown() {
		speed -= 10;
		if(speed < 0)
			stop();//���� Ŭ���� ���� �޼ҵ带 ȣ���� ������ �޼ҵ� �տ� "��ü." ���� ���� >> �̰� ���������ΰ� �ƴ� �����ؾ����ΰ�?
	}

	public void stop() {
		speed = 0;
	}
}
