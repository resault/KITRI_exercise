package sudy0331;

import java.awt.*;

import javax.swing.*;

public class JTableTest extends JFrame{

	JLabel lable = new JLabel("table");
	JPanel panel = new JPanel();
	String[] title = new String[] {"a", "b", "c"};
	Object [] [] data = new Object[] [] {
		{"1" , "2", "3"},
		{"4", "5", "6"},
		{"7", "8", "9"}
	};
	JTable table = new JTable(data, title);

	JPanel image = new JPanel();
	
	public JTableTest() {
		
		panel.setLayout(new FlowLayout());
		table.setPreferredScrollableViewportSize(new Dimension(500, 400)); //table size 지정
		table.setVerifyInputWhenFocusTarget(true); //setvisible과 비슷
		panel.add(new JScrollPane(table)); // scroll까지 지정해줘야 변경된 크기가 표현됨

		setLayout(new BorderLayout());
		add(lable, "North");
		add(panel, "Center");
		
		setBounds(400, 400, 700, 600);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new JTableTest();
	}
}
