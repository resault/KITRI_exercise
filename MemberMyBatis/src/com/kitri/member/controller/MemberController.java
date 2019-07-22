package com.kitri.member.controller;

import javax.servlet.http.*;

import org.apache.catalina.connector.Request;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberServiceImpl;

// frontcontroller에서는 요구분석, 보내는 역할만. 나머지는 다 여기서
public class MemberController {

	//singletone
	private static MemberController memberController;
	
	static {
		memberController = new MemberController();
	}
	
	private MemberController() {}

	public static MemberController getMemberController() {
		return memberController;
	}
	
	
	public String register(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
		MemberDetailDto memberDetailDto = new MemberDetailDto();
		memberDetailDto.setName(request.getParameter("name"));
		memberDetailDto.setId(request.getParameter("id"));
		memberDetailDto.setPass(request.getParameter("pass"));
		memberDetailDto.setEmailid(request.getParameter("emailid"));
		memberDetailDto.setEmaildomain(request.getParameter("emaildomain"));
		memberDetailDto.setTel1(request.getParameter("tel1"));
		memberDetailDto.setTel2(request.getParameter("tel2"));
		memberDetailDto.setTel3(request.getParameter("tel3"));
		memberDetailDto.setZipcode(request.getParameter("zipcode"));
		memberDetailDto.setAddress(request.getParameter("address"));
		memberDetailDto.setAddressDetail(request.getParameter("address_detail"));
		
		int cnt = MemberServiceImpl.getMemberService().registerMember(memberDetailDto);
		
		if(cnt != 0) {
			request.setAttribute("userInfo", memberDetailDto);
			path = "/user/member/registerok.jsp";
		} else {
			path = "/user/member/registerfail.jsp";
		}
		return path;
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDto memberDto = MemberServiceImpl.getMemberService().loginMember(id, pass);
		if(memberDto != null) {
			/////////////// cookie ////////////////////////
			String idsv = request.getParameter("idsv");
			if("idsv".equals(idsv)) {
				Cookie cookie = new Cookie("kid_info", id);
				cookie.setDomain("localhost");
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60*60*24*365*50);
	
				response.addCookie(cookie);	//쿠키는 서버에서 만든것이므로 addCookie안하면 클라이언트한테 안 보내짐
			} else {
				Cookie[] cookie = request.getCookies();
				if(cookie != null) {
					for(Cookie c : cookie) {
						if("kid_info".equals(c.getName())) {
							//쿠키를 지워야 하는데, API 상 remove 메소드가 없으므로 만료일자를 0으로 해줌 (쿠키 이름이 같으면 덮어씌워 저장됨) 
							c.setDomain("localhost");
							c.setPath(request.getContextPath());
							c.setMaxAge(0);
							response.addCookie(c);
							break;
						}
					}
				}
			}
			
			/////////////// session ///////////////////////
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", memberDto);
			path = "/user/login/loginok.jsp";
		} else {
			path = "/user/login/loginfail.jsp";
		}
		return path;
	}

	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.setAttribute("userInfo", null);
//		session.removeAttribute("userInfo");	// 세선의 해당 이름을 날림
		session.invalidate();	//세션 안에 있는걸 전부 날림
		//세션 날릴때는 일반적으로 remove나 invalidate를 사용함
		return "/user/login/login.jsp";
	}

	public int deleteMember(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		int result = MemberServiceImpl.getMemberService().deleteMember(memberDto.getId());
		if(result != 0)
			session.invalidate();
		return result;
	}

	public String modify(HttpServletRequest request, HttpServletResponse response) {
		String path = "/index.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto  = (MemberDto) session.getAttribute("userInfo");
		
		MemberDetailDto memberDetailDto = MemberServiceImpl.getMemberService().getMember(memberDto.getId());
		if(memberDetailDto != null) {
			System.out.println(memberDetailDto.getId());
			request.setAttribute("user", memberDetailDto);
			path = "/user/member/member.jsp";
		}
		
		return path;
	}

	
}
