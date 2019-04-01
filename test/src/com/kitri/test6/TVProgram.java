package com.kitri.test6;

public class TVProgram {

	private String title;
	private String broadcast;
	
	public TVProgram(String title, String broadcast) {
		this.title = title;
		this.broadcast = broadcast;
	}

	@Override
	public String toString() {
		return title + " (" + broadcast + ")" ;
	}
	
	
}
