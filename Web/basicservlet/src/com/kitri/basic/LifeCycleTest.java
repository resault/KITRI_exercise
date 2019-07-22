package com.kitri.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/life")
public class LifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifeCycleTest() {
		System.out.println("생성자() 호출!!!!"); //서버가 실행될 때 1회 호출됨
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출!!!!"); //서버가 실행될 때 1회 호출됨
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 호출!!!!"); //클라이언트가 접속할때마다 호출됨(새로고침할 때도 마찬가지)
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출!!!!"); //서버가 종료될 때 1회 호출됨 (servlet의 내용이 변경된 경우, WAS가 서버를 reload하기 때문에, 내용 바꾸고 새로고침해도 볼 수 있음. 서버를 종료시켜도 한번 호출되지만, 콘솔이 종료된 후에 호출되므로 콘솔에 아래 출력이 표시되지 않음)
	}

}
