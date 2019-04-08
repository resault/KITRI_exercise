package com.kitri.haksa.test;

import com.kitri.haksa.service.db.HaksaService;
import com.kitri.haksa.service.db.HaksaServiceImpl;

//Project ½ÇÇà class
public class HaksaMain {

	public static void main(String[] args) {
		HaksaService haksa = new HaksaServiceImpl();
		while(true)
			haksa.menu();
	}
}
