package com.kitri.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.member.util.MoveUrl;
import com.kitri.member.util.SiteConstance;

@WebServlet("/user")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";
		
		if("mvjoin".equals(act)) {	//act.equals("mvjoin")으로 쓸 경우, act값이 없으면 NullPointException 나버리므로 추가로 if문이 더 필요함
			MoveUrl.redirect(request, response, "/user/member/member.jsp");
		} else if("mvlogin".equals(act)) {
			MoveUrl.redirect(request, response, "/user/login/login.jsp");
		} else if("idcheck".equals(act)) {
			String sid = request.getParameter("sid");
			String resultXML = MemberServiceImpl.getMemberService().idCheck(sid);
			
			response.setContentType("text/xml; charset=UTF-8");		// 보내는 방식 3가지 : String | html | xml		>> String 일때는 contenttype에 plain 	(jason도 String임)
			PrintWriter out = response.getWriter();
			out.print(resultXML);
		} else if("zipsearch".equals(act)) {
			String doro = request.getParameter("doro");
			String resultXML = MemberServiceImpl.getMemberService().zipSearch(doro);
			response.setContentType("text/xml; charset=UTF-8");	//xml은 무조건 UTF-8이라 굳이 상수 안써도 됨
			PrintWriter out = response.getWriter();
			out.print(resultXML);
		} else if("register".equals(act)) {
			path = MemberController.getMemberController().register(request, response);
			MoveUrl.forward(request, response, path);
		} else if("login".equals(act)) {
			path = MemberController.getMemberController().login(request, response);
			MoveUrl.forward(request, response, path);	// 이거 sendRedirect해도 상관 없음. forward했을때 유지되는건 request와 response임. request에 담은게 있다면 forward를 해야겠지만, 지금은 session에 담았으므로
		} else if("logout".equals(act)) {
			path = MemberController.getMemberController().logout(request, response);
			MoveUrl.redirect(request, response, path);	// 이거 sendRedirect해도 상관 없음. forward했을때 유지되는건 request와 response임. request에 담은게 있다면 forward를 해야겠지만, 지금은 session에 담았으므로 
		} else if("deletemember".equals(act)) {
			int result = MemberController.getMemberController().deleteMember(request, response);
			PrintWriter out = response.getWriter();
			out.print(result);
		} else if("modify".equals(act)) {
			path = MemberController.getMemberController().modify(request, response);
			MoveUrl.forward(request, response, path);
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.ENCODE);
		doGet(request, response);
	}
}
