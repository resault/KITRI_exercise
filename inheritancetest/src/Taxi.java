/*
1. ���
	�⺻���(basicPrice)
		- �Ϲ�: 3800, �ɾ�: 5000
	�����(totalPrice)
		- �������
	���(price)
		- �Ϲ�: 100/km, �ɾ�: 150/km
2. ��� ���(calcPrice())
3. �ɾ����� : 0�� ~ 6��
*/
import java.util.*;

public class Taxi extends Car {

	int basicPrice;
	int totalPrice; 
	int price;
	int dprice;
	//int speed;

	public Taxi() {
		//super();�� �����Ǿ� ���� - default �����ڸ� ȣ���� �Ż���class�� default�����ڰ� ������ ���� �߻���
		basicPrice = 3800;
		dprice = 100;
	}

	public Taxi(String carName, String color, String maker) {
		/*
		super();--->�����Ǿ� ����
		this.carName = carName;
		this.color = color;
		this.maker = maker; >> �ᱹ, ����class�� ȣ���ؼ� ���� �޾ƿ���, �� ���ڰ��� �����ϹǷ� ��ȿ������
		*/

		super(carName, color, maker);
		basicPrice = 3800;
	}



	//method

	public void initPrice(int km) {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		
		if (hour >= 0 && hour < 6) {
			basicPrice = 5000;
			dprice = 150;
			System.out.println("�ɾ������� ����˴ϴ�.");
		}
		this.calcPrice(km);
		price = basicPrice;
	}


	public int calcPrice(int km ) {
		for (int i=0;i<km;i++)	{
			price += dprice;
		}
		return price;
	}


	public int sumPrice() {
		totalPrice += price;
		return totalPrice;
	}


	/*
	@override//method�� �̸��� �޶� ���� �߻���
	int speedup(int speed) { //method�� �̸��� �ٸ��� ������ overriding ���� ����
		this.speed += speed;
		if(this.speed > 150)
			this.speed = 150;
		return this.speed;
	
	
	@Override
	int speedUp(int speed) {//����class���� ���� �ǹ��� ���������ڴ� ����� �� ����
		this.speed += speed;
		if(this.speed > 150)
			this.speed = 150;
		return this.speed;
	
	
	@Override
	public int speedUp(int speed) {
		this.speed += speed;
		if(this.speed > 150)
			this.speed = 150;
		return this.speed;
	}
	

	@Override
	public int speedUp(int speed) {
		speedUp(speed);//taxi class�� speedUp�� ȣ��Ǿ� ���ѷ��� ���ٰ� ��������
		if(this.speed > 150)
			this.speed = 150;
		return this.speed;
	}
	

	@Override
	public int speedUp(int speed) {
		speed = super.speedUp(speed);//int speed�� ���ڷ� �Ͽ� ����class�� speedUp method ȣ���ϰ�, ��ȯ���� ������
		if(this.speed > 150)
			this.speed = 150;
		return this.speed;
	}

	
	@Override
	public int speedUp(int speed) {
		speed = super.speedUp(speed);
		if(speed > 150)
			speed = 150;//�ʵ尪�� ���ڷ� �޾ƿͼ� ���������� ���� �� �� �Ŀ�, ���������� �����ع���
		return speed;
	}


	*/

	@Override
	public int speedUp(int speed) {
		speed = super.speedUp(speed);
		if(speed > 150)
			this.speed = 150;
		return this.speed;
	}

/*	
	@Override
	public String toString() {
	return maker + "���� ���� " + color + " " + carName + "�ý�";
	}
	
*/
	@Override
	public String toString() {
		return super.toString() + "�ý�";
	}
/*
	@Override
	public boolean equals(Object obj) { //�̰�.. ���ڰ� ����..?
		Car car = obj;//������ ������ �����Ϸ��� �ؼ� ���� �߻�
		if(carName == car.carName)
		return true;
	}

*/

	@Override
	public boolean equals(Object obj) { //�̰�.. ���ڰ� ����..?
		Car car = (Car) obj;//taxiguest���� �ýø� �޾ƿ��⶧���� car�� ��������ȯ ����
		//if(carName == car.carName)//""�� ���� true, new String("")�� ���� false
		if(carName.equals(car.carName))
			return true;
		return false;	//String�� object�� == �� �ȵǴµ�.. �ǰ� ����... String���� equlas override �̰�.. ==�� equals Ȯ��
	}

// �� ��ü�� ���� ����, == ���� ���� equals ���!


/*
	//Car car = new Car();
	Car car = new Taxi();
	Taxi t = new Taxi();
	t = (Taxi)car;
*/





}

/*
- �ð��� ������ �ڵ�
Calendar calendar = Calendar.getInstance();
int hour = calendar.get(Calendar.HOUR_OF_DAY);
*/