package com.kitri.cafe.board.model;

public class BbsDto extends BoardDto {

	private int baseq;
	private String originFile;
	private String saveFile;
	private long fileSize;
	private String saveFolder;

	public int getBaseq() {
		return baseq;
	}

	public void setBaseq(int baseq) {
		this.baseq = baseq;
	}

	public String getOriginFile() {
		return originFile;
	}

	public void setOriginFile(String originFile) {
		this.originFile = originFile;
	}

	public String getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getSaveFolder() {
		return saveFolder;
	}

	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}

}
