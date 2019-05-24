package com.kitri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

	public List<RepBoardDto> selectByRows(int startRow, int endRow) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RepBoardDto> list = new ArrayList<RepBoardDto>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "resault", "resault");
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * \n");
			sql.append("FROM	(SELECT rownum r, repboard.* \n");
			sql.append("	FROM repboard \n");
			sql.append("	START WITH parent_seq = 0 \n");
			sql.append("	CONNECT BY PRIOR board_seq = parent_seq \n");
			sql.append("	ORDER SIBLINGS BY board_seq DESC \n");
			sql.append("	) \n");
			sql.append("WHERE r BETWEEN ? AND ? \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RepBoardDto r = new RepBoardDto();
				
				r.setBoard_seq(rs.getInt("board_seq"));
				r.setParent_seq(rs.getInt("parent_seq"));
				r.setBoard_subject(rs.getString("board_subject"));
				r.setBoard_writer(rs.getString("board_writer"));
				r.setBoard_contents(rs.getString("board_contents"));
				r.setBoard_date(rs.getTimestamp("board_date"));		// getTimestamp : 밀리세컨드 단위로 시간정보를 받아옴
				r.setBoard_password(rs.getString("board_password"));
				r.setBoard_viewcount(rs.getInt("board_viewcount"));

				list.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return list;
	}

	public int selectTotalCnt() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCnt = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "resault", "resault");
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT count(*) \n");
			sql.append("FROM repboard \n");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			rs.next();
			totalCnt = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return totalCnt;
	}


}
