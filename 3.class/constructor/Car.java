public class Car {

	String carName;
	String color;
	String maker;
	int speed;

	//�����ڸ� �ϳ��� ����� default �����ڴ� �����. ���� '��� �����ڴ� default�����ڰ� �ִ�'��� ������ faulse
	public Car() {	//��ü�� ������ ��, ��ü�� �ʱ�ȭ ��Ŵ (default�����ڴ� class�� �޸𸮿� �ø��� ���Ҹ� ��)
		/*
		carName = "�Ÿ";
		color = "������";
		maker = "����";
		*/
		
		this("�Ÿ", "������", "����");
	}

	public Car(String color) {
		/*
		carName = "�Ÿ";
		this.color = color;
		maker = "����";
		*/
		this("�Ÿ", color, "����");
	}

	public Car(String carName, String color) {
		/*
		this.carName = carName;
		this.color = color;
		maker = "����";
		*/
		this(carName, color, "����");
	}

	public Car(String carName, String color, String maker) {
		this.carName = carName;
		this.color = color;
		this.maker = maker;
	}

	public void speedUp() {//void�� ���, return�� �����ϰų� return; �̷��� ���� ��
		speed += 10;
	}

	public int speedUp(int speed) { //return type�� �����ϰ� �޼ҵ� �ȿ��� return���� ������ ���� �߻���
		this.speed += speed; // !! this�� ������� �ʾ��� ��� �����غ���
		return this.speed;
	}

	public void speedDown() {
		speed -= 10;
		if(speed < 0)
			stop();
	}

	public int speedDown(int speed) { 
		this.speed -= speed;
		if(this.speed < 0)
			stop();
		return this.speed;
	}

	public void stop()	{
		speed = 0;	
	}

	
	public String info() {
	return "���̸� : " + carName + " ���� : " + color + " ������ : " + maker ;
	}

}
