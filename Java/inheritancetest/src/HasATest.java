import java.awt.*;

public class HasATest {

	Frame f = new Frame("Has A Test!!!");
	Button b = new Button("@눌러봐@");//생성자에서 라벨붙이기

	public HasATest() {
		//f.setTitle("Has A Test!!!");
		f.setLayout(new FlowLayout());
		//b.setLabel("눌러봐!!!"); //method에서 라벨붙이기
		f.add(b);
		f.setSize(400, 300);
		f.setLocation(300, 200);
		f.setVisible(true);

	}
	
	public static void main(String[] args)	{
		HasATest hat = new HasATest();
	}
}
