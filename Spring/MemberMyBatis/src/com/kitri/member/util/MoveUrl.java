package com.kitri.member.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoveUrl {
	
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		
		response.sendRedirect(request.getContextPath() + path);	//redirect는 URL을 가져감
		
	}
	
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws IOException, ServletException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);	//forward는 path이므로 해당 프로젝트 안의 경로
		dispatcher.forward(request, response);
	}
	
	
}
