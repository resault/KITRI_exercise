package com.kitri.member.model.service;

import java.util.*;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService{

	//Singleton Pattern
	
	private static MemberService memberService;
	
	static {	//클래스가 로딩될때 단 한번 호출됨
		memberService = new MemberServiceImpl();
	}
	
	private MemberServiceImpl() {}	//service 객체는 controller에서 단 하나 만들어져야 하기에
	
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

		String result = "";
		List<ZipcodeDto> list = MemberDaoImpl.getMemberDao().zipSearch(doro);
		
		result += "<ziplist>\n";
		for(ZipcodeDto zipDto : list) {
			result += "	<zip>\n";
			result += "		<zipcode>" + zipDto.getZipcode() + "</zipcode>\n";
			result += "		<address><![CDATA[" + zipDto.getSido() + " " + zipDto.getGugun() + " " + zipDto.getUpmyon() + " " + zipDto.getDoro() + " " + zipDto.getBuildingNumber() + " " + zipDto.getSigugunBuildingName() + "]]></address>" + "\n";
			result += "	</zip>\n";
		}
		result += "</ziplist>";
		
		return result;
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		return MemberDaoImpl.getMemberDao().registerMember(memberDetailDto);
	}

	@Override
	public MemberDto loginMember(String id, String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		return MemberDaoImpl.getMemberDao().loginMember(map);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		return MemberDaoImpl.getMemberDao().getMember(id);
	}

	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String id) {
		return MemberDaoImpl.getMemberDao().deleteMember(id);
	}

}
