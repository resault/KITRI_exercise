import java.awt.*;
import java.awt.event.*;

public class InterfaceTest extends Frame {	
	

	Button b = new Button("@������@");//�����ڿ��� �󺧺��̱�

	public InterfaceTest() {
		super("Is A Test!!!");
		//f.setTitle("Has A Test!!!");
		setLayout(new FlowLayout());
		//b.setLabel("������!!!"); //method���� �󺧺��̱�
		add(b);
		setBackground(new Color(210, 250, 210));
		setSize(400, 300);
		setLocation(300, 200);
		setVisible(true);

		//1.�ڽ��� �����ڸ� �̿��Ͽ� ��ü ����
		WindowListener wl = new WindowListener() {
		
		
		
		}
		addWindowListener(wl);//
		
	}
	
	public static void main(String[] args)	{
		InterfaceTest ift = new InterfaceTest();
	}
}
