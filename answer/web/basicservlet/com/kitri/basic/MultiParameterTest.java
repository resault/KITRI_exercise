package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiparam")
public class MultiParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get
		String name = request.getParameter("name");//��ȿ��
//		System.out.println("1 name ==== " + name);
//		byte b[] = name.getBytes("iso-8859-1");//%BE%C8%C8%BF%C0%CE
//		name = new String(b, "euc-kr");
//		
//		System.out.println("2 name ==== " + name);
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		String fruit[] = request.getParameterValues("fruit");
		
//		2. logic
		String color = age == 10 ? "pink" : "cyan";
		
//		3. response page : 
//		안효인(java2)님 안녕하세요.
//		당신이 좋아하는 과일은 사과입니다.
//		당신이 좋아하는 과일은 사과, 수박입니다.
//		당신이 좋아하는 과일은 없습니다.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println(name + "(<font color=\"" + color + "\">" + id + "</font>)님 안녕하세요.<br>");
		out.print("당신이 좋아하는 과일은 ");
		if(fruit != null) {
			int len = fruit.length;
			for(int i=0;i<len;i++) {
				out.print(fruit[i]);
				if(i != len - 1)
					out.print(", ");
			}
			out.println("입니다.");
		} else {		
			out.println("없습니다.");
		}
		out.println("	</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}









//http://localhost/basicservlet/multiparam?name=%EC%95%88%ED%9A%A8%EC%9D%B8&id=java2&age=30



//     euc-kr				     utf-8
//안효인		%BE%C8%C8%BF%C0%CE	 		��ȿ��

	



