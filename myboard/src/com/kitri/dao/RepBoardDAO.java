package com.kitri.dao;

import java.sql.*;

import com.kitri.dto.RepBoardDto;
import com.kitri.exception.AddException;

public class RepBoardDAO {

	////////// SingleTone ////////////
	private static RepBoardDAO repBoardDAO;
	
	static {
		repBoardDAO = new RepBoardDAO();
	}
	
	private RepBoardDAO() {}
	
	public static RepBoardDAO getRepBoardDAO() {
		return repBoardDAO;
	}

	
	
	////////// method ////////////

	public void insert(RepBoardDto repBoardDto) throws AddException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "resault", "resault");
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into repboard (BOARD_SEQ, PARENT_SEQ, BOARD_SUBJECT, BOARD_WRITER, BOARD_CONTENTS, BOARD_DATE, BOARD_PASSWORD, BOARD_VIEWCOUNT) \n");
			sql.append("values(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, systimestamp, ?, 0) \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, repBoardDto.getParent_seq());
			pstmt.setString(2, repBoardDto.getBoard_subject());
			pstmt.setString(3, repBoardDto.getBoard_writer());
			pstmt.setString(4, repBoardDto.getBoard_contents());
			pstmt.setString(5, repBoardDto.getBoard_password());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
