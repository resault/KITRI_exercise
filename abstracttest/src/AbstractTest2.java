public class AbstractTest2 {
	public static void main(String[] args) throws Exception	{

		//3. �ܺ�Ŭ���� ����
		Runtime r = Runtime.getRuntime();//Runtime�� �����ڴ� private�̶� new�� ȣ�� �Ұ��ϹǷ� static method �̿���
		Process p = r.exec("calc");

	}
}
