import java.awt.*;
import java.awt.event.*;

public class AbstractTest3 extends Frame {
		
	//4. 자신의 생성자를 이용	>> new 하고 body에 override하면 됨
	Button b1 = new Button("@눌러봐1@");
	Button b2 = new Button("@눌러봐2@");
	Button b3 = new Button("@눌러봐3@");
	Checkbox c = new Checkbox("선택");
	

	public AbstractTest3() {
		super("Is A Test!!!");
		//setTitle("Is A Test!!!");
		setLayout(new FlowLayout());
		//b.setLabel("눌러봐!!!");
		b1.setBackground(new Color(210, 255, 210));
		c.setBackground(new Color(210, 210, 255));
		add(b1);
		add(b2);
		add(b3);
		add(c);
		setBackground(new Color(255, 210, 210));
		setSize(400, 300);
		setLocation(300, 200);
		setVisible(true);

		WindowListener wl = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}	
		};
		addWindowListener(wl);
	}
	
	public static void main(String[] args) throws Exception {
		AbstractTest3 iat = new AbstractTest3();	
	}
}
