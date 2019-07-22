package com.kitri.cafe.board.model;

public class ReboardDto extends BoardDto {

	private int raseq;
	private int ref;
	private int lev;
	private int step;
	private int pseq;
	private int reply;

	public int getRaseq() {
		return raseq;
	}

	public void setRaseq(int raseq) {
		this.raseq = raseq;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getPseq() {
		return pseq;
	}

	public void setPseq(int pseq) {
		this.pseq = pseq;
	}

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}

}
