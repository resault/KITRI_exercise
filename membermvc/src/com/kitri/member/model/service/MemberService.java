package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.*;

public interface MemberService {
	
	String idCheck(String id);	//id 받아오고 int 리턴
	String zipSearch(String doro);	//동이름 받아오고 zipcodeDto 타입의 list 리턴
	int registerMember(MemberDetailDto memberDetailDto);	// memberDetailDto 받아오고 int 리턴
	MemberDto loginMember(String id, String pass);	//id, pass 받아오고 memberDto 리턴
	
	//아래 만들어올것
	MemberDetailDto getMember(String id);	// id 받아오고 memberDetailDto리턴 >> 이거 회원정보 수정시에 쓸 메소드임
	int modifyMember(MemberDetailDto memberDetailDto);	// memberDetailDto 받아오고 int 리턴
	int deleteMember(String id);	// id 받아오고 int 리턴
}
