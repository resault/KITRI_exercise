package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiparam")
public class MultiParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
//		byte b[] = name.getBytes("iso-8859-1");	// WAS의 인코딩 (예시는 톰켓7기준임)
//		name = new String(b, "UTF-8");	// html문서의 meta charset의 인코딩
		
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		String[] fruit = request.getParameterValues("fruit");
		
		String color = age==10 ? "pink" : "cyan";
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("	<body>");
		out.print(name + "(<font color=\"" + color + "\">" + id + "</font>)님 안녕하세요.<br/>");
		out.print("	당신이 좋아하는 과일은 ");

		if(fruit != null) { // 선택된 체크박스 있는 경우
			int len = fruit.length;	// fruit가 null인 경우 NllPointException 발생하므로, if문 내부에 있어야 함
			if(len>1) {	//선택된 체크박스가 2개 이상인 경우
				for(int i=0;i<len-1;i++)
					out.print(fruit[i]+", ");
			}
			out.print(fruit[len-1]+"입니다.");	// 배열의 마지막 인덱스는 length-1이므로
			
//		answer
//			int len = fruit.length;
//			for(int i=0;i<len;i++) {
//				out.print(fruit[i]);
//				if(i != len-1)
//					out.print(", ");
//			}
//			out.print("입니다.");
			
		} else	// 선택된 체크박스가 없는 경우(fruit가 null인 경우)
			out.print("없습니다.");
		
		out.print("	</body>");
		out.print("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
