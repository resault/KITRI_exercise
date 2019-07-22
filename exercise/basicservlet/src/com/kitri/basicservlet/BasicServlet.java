package com.kitri.basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basic")
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String name;
	int age;
	
	@Override
	public void init() throws ServletException {
		name = "정현정";
		age = 15;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String color = age>18 ? "blue" : "red";
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("	<body>");
		out.print("	" + name + "(" + "<font color=\""+ color +"\">" + age + "</font>)님 안녕하세요!!!");
		out.print("	</body>");
		out.print("</html>");
	}

}
