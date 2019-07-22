package com.kitri.io;

import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;

public class Notepad extends JFrame implements ActionListener, ItemListener {

	JScrollPane sp = new JScrollPane();
	JTextArea editor = new JTextArea();
	Integer fsize[] = {9, 11, 13, 15, 17, 19, 21};
	JComboBox<Integer> fs = new JComboBox<Integer>();
	
	JMenuBar mb = new JMenuBar();
	JMenu file = new JMenu("파일");
	JMenu edit = new JMenu("편집");
	JMenu help = new JMenu("도움말");
	JMenuItem open = new JMenuItem("열기");
	JMenuItem save = new JMenuItem("저장");
	JMenuItem exit = new JMenuItem("종료");
	
	public Notepad() {
		super("메모장");
		
		file.add(open);
		file.add(save);
		file.addSeparator();
		file.add(exit);
		
		Vector<Integer> vector = new Vector<Integer>();
		int len = fsize.length;
		for (int i = 0; i < len; i++) {
			vector.add(fsize[i]);
		}
		ComboBoxModel<Integer> model = new DefaultComboBoxModel<Integer>(vector);
		fs.setModel(model);
		edit.add(fs);
		
		mb.add(file);
		mb.add(edit);
		mb.add(help);
		
		this.setJMenuBar(mb);
		
		sp.setViewportView(editor);
		getContentPane().add(sp, "Center");
//		getContentPane().add(fs, "South");
		
		setBounds(300, 200, 600, 500);
		setVisible(true);
		
		open.addActionListener(this);
		save.addActionListener(this);
		
		fs.addItemListener(this);

	}
	
	public static void main(String[] args) {
		new Notepad();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == open) {
			JFileChooser jfc = new JFileChooser();
			jfc.setCurrentDirectory(new File("d:\\javadata\\javasource"));
			jfc.showOpenDialog(this);
			
			BufferedReader fin = null;
			File file = jfc.getSelectedFile();
			if(file != null) {
				String infile = file.getPath();
				try {
					fin = new BufferedReader(new InputStreamReader(new FileInputStream(new File(infile))));
					editor.setText("");
					String str = null;
					while((str = fin.readLine()) != null) {
						editor.append(str + "\n");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if(fin != null)
							fin.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		} else if(ob == save ) {
			JFileChooser jfc = new JFileChooser();
			jfc.setCurrentDirectory(new File("d:\\javadata\\javasource"));
			jfc.showSaveDialog(this);
			
			String data = editor.getText();
			System.out.println(data);
			FileWriter fw = null;
			File file = jfc.getSelectedFile();
			String outfile = file.getPath();
			try {
				fw = new FileWriter(new File(outfile));
				fw.write(data.replace("\n", "\r\n"));
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if(fw != null)
						fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("1111111111111111111111111111111");
	}

	
}
