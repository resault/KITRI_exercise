package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/singleparam")
public class SingleParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
//		2. logic
		String color = age == 10 ? "pink" : "cyan";
		
		
//		3. response page : name()님 안녕하세요.
//			10대 이하 : id 빨간색
//			20대 이상 : id 파랑색
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("	<body>");
		
		out.print(name + "<font color=\""+ color +"\"> (" + id + ")</font> ");
		
		out.print("	님 안녕하세요.");
		out.print("	</body>");
		out.print("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		1. data get
		request.setCharacterEncoding("UTF-8");	// post에서만 가능!
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
//		2. logic
		String color = age == 10 ? "pink" : "cyan";
		
		
//		3. response page : name()님 안녕하세요.
//			10대 이하 : id 빨간색
//			20대 이상 : id 파랑색
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("	<body>");
		
		out.print(name + "<font color=\""+ color +"\"> (" + id + ")</font> ");
		
		out.print("	님 안녕하세요.");
		out.print("	</body>");
		out.print("</html>");
		
	}

}
