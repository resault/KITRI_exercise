import java.awt.*;

public class IsATest extends Frame {	
	

	Button b = new Button("@눌러봐@");//생성자에서 라벨붙이기

	public IsATest() {
		super("Is A Test!!!");
		//f.setTitle("Has A Test!!!");
		setLayout(new FlowLayout());
		//b.setLabel("눌러봐!!!"); //method에서 라벨붙이기
		add(b);
		setBackground(new Color(210, 250, 210));
		setSize(400, 300);
		setLocation(300, 200);
		setVisible(true);

	}
	
	public static void main(String[] args)	{
		HasATest hat = new HasATest();
	}
}
