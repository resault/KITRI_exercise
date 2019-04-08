package com.kitri.haksa.service.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import com.kitri.haksa.data.db.HaksaDto;

public class HaksaDao {

	public HaksaDao() {
		try {
			Connection conn = DriverManager.getConnection("", "kitri", "kitri");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void register(HaksaDto haksa) {
		
	}
	
	public HaksaDto findName(String name) {
		
		
		return null;
	}
	
	public int delete(String name) {
		
		return 0;
	}

	public ArrayList<HaksaDto> selecArrayList() {
		
		return null;
	}
}
