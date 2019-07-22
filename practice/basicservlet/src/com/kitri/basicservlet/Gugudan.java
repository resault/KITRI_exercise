package com.kitri.basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ggd")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("	<head>");
		out.print("		<style type=\"text/CSS\">");
		out.print("			div {");
		out.print("				text-align: center;");
		out.print("				border-width: thin;");
		out.print("				border-style: solid;");
		out.print("			}");
		out.print("			#content {");
		out.print("				width: 900;");
		out.print("				height: 600;");
		out.print("				margin: auto;");
		out.print("				display: grid;");
		out.print("				grid-template-columns: repeat(9, 1fr);");
		out.print("			}");
		out.print("			#head {");
		out.print("				grid-column-start: 1;");
		out.print("				grid-column-end: 10;");
		out.print("			}");
		out.print("		</style>");
		out.print("	</head>");

		out.print("	<body>");
		out.print("		<div id=\"content\">");
		out.print("		<div id=\"head\">*** 구구단 ***</div>");
		
		for(int dan=2;dan<10;dan++) {
			String color = dan%2==0 ? "lightsalmon" : "skyblue";
			for(int i=1;i<10;i++) {
				out.print("<div style=\"background-color:" + color + "\">" + dan + " * " + i + " = " + dan*i + "</div>");
			}
		}
		
		out.print("		</div>");
		out.print("	</body>");
		out.print("</html>");
		
	}

}
