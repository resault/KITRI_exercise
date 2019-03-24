package com.kitri.array;

public class PlayerDto {

	private int number;// 등번호는 중복 없음, 모든 선수는 등번호를 가짐
	private String name;
	private int position;
	private double grade;// 성적 // 타자일때는 타율(높을수록), 투수일때는 방어율(낮을수록)
	String[] positionName = { "지명타자", "투수", "포수", "1루수", "2루수", "3루수", "유격수", "좌익수", "중견수", "우익수" };

	public PlayerDto(int number, String name, int position, double grade) {
		super();
		this.number = number;
		this.name = name;
		this.position = position;
		this.grade = grade;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "PlayerDto [등번호=" + number + "\t이름=" + name + "\t포지션=" + positionName[position] + "\t타율="
				+ (grade != 1 ? "타율" : "방어율") + "]";
	}

}
