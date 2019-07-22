package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ggd")
public class GGDTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("	<head>");
		
		out.print("		<style type=\"text/css\">");
		
		out.print("			#wrapper {");
		out.print("				width: 800;");
		out.print("				height: 700;");
		out.print("				display: grid;");
		out.print("    			grid-template-columns: repeat(8, 1fr);");
		out.print("			}");
		
		out.print("			#head {");
		out.print("				text-align: center;");
		out.print("				grid-column-start: 1;");
		out.print("				grid-column-end: 9;");
		out.print("			}");

		out.print("			.lightcoral {");
		out.print("				background-color: lightcoral ;");
		out.print("			}");

		out.print("			.skyblue {");
		out.print("				background-color: skyblue;");
		out.print("			}");
		
		out.print("		</style>");
		out.print("	</head>");
		out.print("	<body>");
		out.print("		<div id=\"wrapper\">");
		out.print("			<div id=\"head\">*** 구구단 ***</div>");
		
		String color;
		for(int i=1;i<10;i++) {
			for(int x=2;x<10;x++) {
				color = x%2==0 ? "lightcoral" : "skyblue";
				out.print("<div class=\"" + color + "\">" + x + " * " + i + " = " + x*i + "</div>");
			}
		}
		
		out.print("		</div>");
		out.print("	</body>");
		out.print("</html>");
		out.print("");
		out.print("");
		out.print("");
	}


}
