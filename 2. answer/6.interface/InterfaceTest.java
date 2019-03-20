import java.awt.*;
import java.awt.event.*;

public class InterfaceTest extends Frame implements WindowListener, ActionListener {

	Button b1 = new Button("@´­·¯ºÁ1@");

	public InterfaceTest() {
		super("Interface Test!!!");
		setLayout(new FlowLayout());
		b1.setBackground(new Color(210, 255, 210));
		add(b1);
		setBackground(new Color(255, 210, 210));
		setSize(400, 300);
		setLocation(300, 200);
		setVisible(true);

		//WindowListener wl = new InterfaceTest();
		/*
		WindowListener wl = new WindowListener() {
			public void windowDeactivated(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {System.exit(0);}
			public void windowOpened(WindowEvent e) {}
		};
		*/
		//addWindowListener(wl);
		addWindowListener(this);
		b1.addActionListener(this);
	}

	public void windowDeactivated(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {System.exit(0);}
	public void windowOpened(WindowEvent e) {}

	public void actionPerformed(ActionEvent e) {
		int r = (int)(Math.random() * 256);
		int g = (int)(Math.random() * 256);
		int b = (int)(Math.random() * 256);
		setBackground(new Color(r, g, b));
	}
	
	public static void main(String[] args) throws Exception {
		InterfaceTest iat = new InterfaceTest();
	}
}
