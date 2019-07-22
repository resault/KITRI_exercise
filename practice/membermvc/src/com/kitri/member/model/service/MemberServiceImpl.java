package com.kitri.member.model.service;

import java.util.*;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService{

	private static MemberService memberService;
	
	static {
		memberService = new MemberServiceImpl(); 
	}
	
	private MemberServiceImpl() {}
	
	public static MemberService getMemberService() {
		return memberService;
	}



	@Override
	public String idCheck(String id) {
		int cnt = MemberDaoImpl.getMemberDao().idCheck(id);
		
		String result = "";
		result += "<idcount>\n";
		result += "	<cnt>" + cnt + "</cnt>\n";
		result += "</idcount>";
		
		return result;
	}

	@Override
	public String zipSearch(String doro) {
		List<ZipcodeDto> list = MemberDaoImpl.getMemberDao().zipSearch(doro);
		
		String result = "";
		result += "<ziplist>\n";
		for(ZipcodeDto zipDto : list) {
			result += "<zip>\n";
			result += "		<zipcode>" + zipDto.getZipcode() + "</zipcode>\n";
			result += "		<address><![CDATA[" + zipDto.getSido() + " " + zipDto.getGugun() + " " + zipDto.getUpmyon() + " " + zipDto.getDoro() + " " + zipDto.getBuildingNumber() + " " + zipDto.getSigugunBuildingName() + "]]></address>" + "\n";
			result += "</zip>\n";
		}
		result += "</ziplist>\n";
		
		return result;
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		int cnt = 0;
		
		cnt = MemberDaoImpl.getMemberDao().registerMember(memberDetailDto);
		
		return cnt;
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", id);
		map.put("pass", pass);
		
		return MemberDaoImpl.getMemberDao().loginMember(map);
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
