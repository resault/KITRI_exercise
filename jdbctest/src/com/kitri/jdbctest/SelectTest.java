package com.kitri.jdbctest;

import java.sql.*;
import java.text.DateFormat;
import java.util.*;
import java.util.Date;

public class SelectTest {

	public SelectTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("jdbc loading success!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println("DB connect success!!!");
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
			sql += "select no, name, id, joindate \n";//쿼리문이 여러줄일때는 고치기 어려우므로 항상 개행할 것
			sql += "from jdbctest \n";
			if(searchName != null)
				sql += "where name = '" + searchName + "'\n";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
//			MemberDto memberDto = new MemberDto();
			while(rs.next()) { //최초로 호출된 ResultSet의 next()는 first()의 성격을 가짐
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
			try { //원칙적으로는 아래 if문을 각각 try하는게 맞지만, close에서 에러가 발생할지라도 할 수 있는 방법이 없으므로 같이 쓴거임
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public MemberDto memberSerch(int no) { // 다시 만들기
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
		try {
			String sql = "";
			sql += "select name, id, \n";
			sql += "decode(to_char(joindate, 'yymmdd'), to_char(sysdate, 'yymmdd'), to_char(joindate, 'hh24:mi:ss'), to_char(joindate, 'yy.mm.dd')) joindate \n";
			sql += "from jdbctest \n";
			sql += "where no = '" + no + "' \n";
			
			conn = makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setName(rs.getString("name"));
				memberDto.setId(rs.getString("id"));
				memberDto.setJoindate(rs.getString("joindate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { //원칙적으로는 아래 if문을 각각 try하는게 맞지만, close에서 에러가 발생할지라도 할 수 있는 방법이 없으므로 같이 쓴거임
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDto;
	}
	
	public static void main(String[] args) {
		SelectTest st = new SelectTest();
		Connection conn = null;
		String searchName = null;
		List<MemberDto> list = st.memberList(searchName);
		System.out.println("회원번호\t이름\t아이디\t가입일");
		System.out.println("------------------------------");
		for(MemberDto memberDto : list) {
			System.out.println(memberDto.getNo() + "\t" + memberDto.getName() + "\t" + memberDto.getId() + "\t" + memberDto.getJoindate());
		}
		
		
//		int no = 10;
		int no = 201;
		MemberDto memberDto = null;
		memberDto = st.memberSerch(no);
		System.out.println("\n회원 번호가 " + no + "인 회원 검색!!!");
		if(memberDto != null) {
//			이름 : 홍길동
//			id : hong
//			가입일 : 10:27:24
//			가입일 : 19.04.29
			System.out.println("이름 : " + memberDto.getName());
			System.out.println("id : " + memberDto.getId());
			System.out.println("가입일 : " + memberDto.getJoindate());
		}
		else
			System.out.println(no + "번 회원은 없습니다.");
	}


}
