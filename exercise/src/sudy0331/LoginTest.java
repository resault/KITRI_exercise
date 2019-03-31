package sudy0331;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginTest extends JFrame implements ActionListener{
	
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JLabel idL = new JLabel("ID : ");
	JLabel idL2 = new JLabel("ID를 다시 입력하세요");
	JTextField id = new JTextField(10);
	JLabel pwL = new JLabel("Password : ");
	JPasswordField pw = new JPasswordField(10);
	JButton btn = new JButton("login");
	
	public LoginTest() {
		
		panel.add(idL);
		panel.add(id);
		panel2.add(idL2);
		
		panel.add(pwL);
		panel.add(pw);
		panel.add(btn);
		
		setLayout(new BorderLayout());
		add(panel, "Center");
		add(panel2, "South");
		
		panel2.setVisible(false);
		
		setSize(500, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = "Dan";
		char[] pw = {'1', '2', '3', '4'};
		char[] pw1 = this.pw.getPassword();
		if(id.equals(this.id.getText()) && pw[1] == pw1[1]) {
			panel2.setVisible(true);
		}
	}

	public static void main(String[] args) {
		new LoginTest();
	}

	
}
