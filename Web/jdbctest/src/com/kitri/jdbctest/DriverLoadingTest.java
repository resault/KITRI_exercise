package com.kitri.jdbctest;

public class DriverLoadingTest {

	public DriverLoadingTest() {//driver는 객체 생성시에 한번
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DriverLoadingTest();
	}
}
