package com.kitri.test6;

public class Drama extends TVProgram {

	private String director;
	private String actor;
	private String actress;
	
//	public Drama(String director, String actor, String actress) {
//		this("", "", director, actor, actress);
//	}

	public Drama(String title, String broadcast, String director) {
		super(title, broadcast);
		this.director = director;
	}


	public Drama(String title, String broadcast, String director, String actor, String actress) {
		super(title, broadcast);
		this.director = director;
		this.actor = actor;
		this.actress = actress;
	}

	@Override
	public String toString() {
		if(actor.equals("")) {
			if(actress.equals("")) {
				return super.toString() + 
						"\n\t - 감독 : " + director + "\n";
			} else {
				return super.toString() + 
						"\n\t - 감독 : " + director +
						"\n\t - 여자배우 : " + actress+ "\n";
			}
		}
		return super.toString() + 
				"\n\t - 감독 : " + director +
				"\n\t - 남자배우 : " + actor +
				"\n\t - 여자배우 : " + actress+ "\n";
	}
	
	
}
