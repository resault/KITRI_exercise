package com.kitri.haksa.data.db;

//학사관리 Entity

public class HaksaDto {

	private int age;
	private String name;
	private int key;
	private String keyName;
	private String value;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\t나이 : " + age + "\t" + (key==1 ? "학번 : " : (key==2 ? "과목 : " : "부서 : ") + keyName);
	}
	
	

}
