package com.kitri.table;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

	String[] colName = {"ÀÌ¸§", "°¡°Ý", "¼ö·®"};
	String[][] rowData = {{"²¿ºÏÄ¨", "1000","5"},
						{"»õ¿ì±ø", "800","3"}};
	
	public JTable table;
	
	public TableModel() {
		this.setDataVector(rowData, colName);
		table = new JTable(this);
		
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	
	
}
