package com.kitri.member.model.dao;

import java.sql.*;
import java.util.*;

import com.kitri.member.model.*;
import com.kitri.member.util.DBClose;
import com.kitri.member.util.DBConnection;

public class MemberDaoImpl implements MemberDao{

	private static MemberDao memberDao;
	
	static {
		memberDao = new MemberDaoImpl();
	}
	
	private MemberDaoImpl() {}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}



	@Override
	public int idCheck(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 1;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(id) \n");
			sql.append("from member \n");
			sql.append("where id = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			cnt = rs.getInt(1);
		} catch (SQLException e) {
			cnt = 1;
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public List<ZipcodeDto> zipSearch(String doro) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ZipcodeDto> list = new ArrayList<ZipcodeDto>();
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select 	decode(length(new_post_code), 4, '0'||new_post_code, new_post_code) zipcode, sido_kor sido, gugun_kor gugun, \n");
			sql.append("		nvl(upmyon_kor, ' ') upmyon, doro_kor doro, \n");
			sql.append("		case when building_refer_number != '0'\n");
			sql.append("			then building_origin_number||'-'||building_refer_number \n");
			sql.append("			else trim(to_char(building_origin_number, '99999'))\n");
			sql.append("		end building_number, sigugun_building_name\n");
			sql.append("from 	postcode\n");
			sql.append("where 	doro_kor like '%'||?||'%'\n");
			sql.append("or sigugun_building_name like '%'||?||'%'\n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, doro);
			pstmt.setString(2, doro);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipcodeDto zipDto = new ZipcodeDto();
				zipDto.setZipcode(rs.getString("zipcode"));
				zipDto.setSido(rs.getString("sido"));
				zipDto.setGugun(rs.getString("gugun"));
				zipDto.setUpmyon(rs.getString("upmyon"));
				zipDto.setDoro(rs.getString("doro"));
				zipDto.setBuildingNumber(rs.getString("building_number"));
				zipDto.setSigugunBuildingName(rs.getString("sigugun_building_name"));
				list.add(zipDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert all\n");
			sql.append("	into member (id, name, pass, emailid, emaildomain, joindate)\n");
			sql.append("	values (?, ?, ?, ?, ?, sysdate)\n");
			sql.append("	into member_detail (id, zipcode, address, address_detail, tel1, tel2, tel3)\n");
			sql.append("	values (?, ?, ?, ?, ?, ?, ?)\n");
			sql.append("select * from dual\n");
			pstmt = conn.prepareStatement(sql.toString());	// 메모리에 있는지 검사함
			
			int idx = 0;	// insert문의 values 값을 추가하거나 삭제하는 경우 인덱스를 자동으로 잡아주게 됨
			pstmt.setString(++idx, memberDetailDto.getId());
			pstmt.setString(++idx, memberDetailDto.getName());
			pstmt.setString(++idx, memberDetailDto.getPass());
			pstmt.setString(++idx, memberDetailDto.getEmailid());
			pstmt.setString(++idx, memberDetailDto.getEmaildomain());
			pstmt.setString(++idx, memberDetailDto.getId());
			pstmt.setString(++idx, memberDetailDto.getZipcode());
			pstmt.setString(++idx, memberDetailDto.getAddress());
			pstmt.setString(++idx, memberDetailDto.getAddressDetail());
			pstmt.setString(++idx, memberDetailDto.getTel1());
			pstmt.setString(++idx, memberDetailDto.getTel2());
			pstmt.setString(++idx, memberDetailDto.getTel3());
			
			cnt = pstmt.executeUpdate();	// cf. stmt는 executeUpdate에서 sql가져감 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
		return cnt;
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDetailDto getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
