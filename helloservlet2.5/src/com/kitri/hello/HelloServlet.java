package com.kitri.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//servlet이 실행되는 곳은 WAS, 아래 html이 실행되는 곳은 client의 browser >>> 출력 필요
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
//		response.setContentType("text/html; charset=UTF-8"); //out을 잡아놓고 charset을 지정하면 한글이 여전히 깨짐
		out.println("<html>");
		out.println("	<body>");
		out.println("	Hello Servlet!!!<br>");
		out.println("	안녕 서블릿!!!"); //소스상의 개행은 html의 공백한칸이므로 <br>써야 함
		out.println("	</body>");
		out.println("</html>");
	}

}
