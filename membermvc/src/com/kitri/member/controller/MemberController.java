package com.kitri.member.controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.service.MemberService;
import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.member.util.SiteConstance;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String root = request.getContextPath();
		
		if("mvjoin".equals(act)) {
			response.sendRedirect(root + "/user/member/member.jsp");
		} else if("mvlogin".equals(act)) {
			response.sendRedirect(root + "/user/login/login.jsp");
		} else if("idcheck".equals(act)) {
			String sid = request.getParameter("sid");
			String resultXML = MemberServiceImpl.getMemberService().idCheck(sid);

			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(resultXML);
		} else if("zipsearch".equals(act)) {
			String doro = request.getParameter("doro");
			String resultXML = MemberServiceImpl.getMemberService().zipSearch(doro);
			
			response.setContentType("text/xml; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(resultXML);
		} else if("register".equals(act)) {
			
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
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.ENCODE);
		doGet(request, response);
	}

}
