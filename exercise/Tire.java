/*
1. field
- �ִ�ȸ����(maxRotation) : Ÿ�̾� ����. �ִ�ȸ������ �����ϸ� ��ũ��
- ����ȸ����(accumulatedRotation) : 1�� ȸ���Ҷ����� 1�� ����
- Ÿ�̾� ��ġ(location)

2. method
- boolean roll() : Ÿ�̾ 1ȸ�� ��Ŵ. true/false(��ũ)
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
			System.out.println("*** " + location + " Tire ��ũ ***");
			return false;
		} else {
			System.out.println(location + " Tire ���� ����: " + (maxRotation - accumulatedRotation) + "ȸ");
			return true;
		}
	}
}
