package com.kitri.util.jcf;

public class TvProgram {

	private String title;
	private String broadcast;
	
	public TvProgram(String title, String broadcast) {
		super();
		this.title = title;
		this.broadcast = broadcast;
	}

	@Override
	public String toString() {
		return title + "\t" + broadcast;
	}
	
}
