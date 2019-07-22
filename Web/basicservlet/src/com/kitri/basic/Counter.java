package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int cnt;
	int totalLen;
	
	@Override
	public void init() throws ServletException {
		cnt = 0;
		totalLen = 8;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		cnt++;
		String cntStr = cnt+"";
		int len = cntStr.length();
		int zeroLen = totalLen - len;
		
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("	<body>");
		out.print("	당신은");
		
		for(int i=0;i<zeroLen;i++)
			out.print("<img src=\"img/0.PNG\" height=\"30\">");
		for(int i=0;i<len;i++)
			out.print("<img src=\"/basicservlet/img/"+ cntStr.charAt(i) +".PNG\" height=\"30\">");
		
		out.print("	번째 방문자입니다.");
		out.print("	</body>");
		out.print("</html>");
	}

}
