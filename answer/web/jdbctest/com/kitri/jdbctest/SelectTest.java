package com.kitri.jdbctest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectTest {

	public SelectTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!!!!!!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println("DB Connection Success!!!!!!");
		return conn;
	}
	
	public List<MemberDto> memberList(String searchName) {
		List<MemberDto> list = new ArrayList<MemberDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = makeConnection();
			String sql = "";
			sql += "select no, name, id, joindate \n";
			sql += "from jdbctest \n";
			if(searchName != null)
				sql += "where name = '" + searchName + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
//			MemberDto memberDto = new MemberDto();
			while(rs.next()) {
				MemberDto memberDto = new MemberDto();
//				memberDto.setNo(rs.getInt(1));
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setJoindate(rs.getString("joindate"));
				
				list.add(memberDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public MemberDto memberSearch(int no) {
		MemberDto memberDto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = makeConnection();
			String sql = "";
			sql += "select no, id, name, ";
			sql += "		decode(to_char(joindate, 'yymmdd'), to_char(sysdate, 'yymmdd'), to_char(joindate, 'hh24:mi:ss'), to_char(joindate, 'yy.mm.dd')) joindate \n";
			sql += "from jdbctest \n";
			sql += "where no = " + no;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setJoindate(rs.getString("joindate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDto;
	}
	
	public static void main(String[] args) {
		SelectTest st = new SelectTest();
//		String searchName = null;
		String searchName = "안효인";
		List<MemberDto> list = st.memberList(searchName);
		System.out.println("회원번호\t이름\t아이디\t가입일");
		System.out.println("-------------------------------");
		for(MemberDto memberDto : list) {
			System.out.println(memberDto.getNo() + "\t" + memberDto.getName() + "\t" + 
					memberDto.getId() + "\t" + memberDto.getJoindate());
		}
		
//		int no = 10;
		int no = 122;
		System.out.println("회원 번호가 " + no + "인 회원 검색!!!!");
		MemberDto memberDto = st.memberSearch(no);
		
		if(memberDto != null) {
//		이름 : 홍길동
//		id : hong
//		가입일 : 10:27:24 (오늘)
//		가입일 : 19.04.25 (오늘X)
			System.out.println("이름 : " + memberDto.getName());
			System.out.println("아이디 : " + memberDto.getId());
			System.out.println("가입일 : " + memberDto.getJoindate());
		} else {
//		10번 회원은 존재하지 않습니다.
			System.out.println(no + "번 회원은 존재하지 않습니다.");
		}
	}
}















