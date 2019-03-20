import java.awt.*;
import java.awt.event.*;

public class InterfaceTest extends Frame {	
	

	Button b = new Button("@눌러봐@");//생성자에서 라벨붙이기

	public InterfaceTest() {
		super("Is A Test!!!");
		//f.setTitle("Has A Test!!!");
		setLayout(new FlowLayout());
		//b.setLabel("눌러봐!!!"); //method에서 라벨붙이기
		add(b);
		setBackground(new Color(210, 250, 210));
		setSize(400, 300);
		setLocation(300, 200);
		setVisible(true);

		//1.자신의 생성자를 이용하여 객체 생성
		WindowListener wl = new WindowListener() {
		
		
		
		}
		addWindowListener(wl);//
		
	}
	
	public static void main(String[] args)	{
		InterfaceTest ift = new InterfaceTest();
	}
}
