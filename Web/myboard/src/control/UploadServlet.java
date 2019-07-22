package control;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MultipartRequest mr = new MultipartRequest(request, "E:\\my");
		MultipartRequest mr;
		String saveDirectory = "E:\\my";
		int maxPostSize = 100*1024; 
		String encoding = "UTF-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();	//FileRenamePolicy를 구현한 하위클래스를 만들어서 중복파일명을 다른 방식으로 처리할 수도 있음
		
		//파일 크기 설정
		//mr = new MultipartRequest(request, saveDirectory, maxPostSize);
		
		// 한글 인코딩 설정
		//mr = new MultipartRequest(request, saveDirectory, encoding);
		
		// 중복 파일명 처리
		//mr = new MultipartRequest(request, saveDirectory, maxPostSize, policy);
		
		//파일경로, 파일크기, 인코딩, 중복 파일명 처리
		mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
		
		
		String a = mr.getParameter("a");
		File f1 = mr.getFile("f1");
//		System.out.println("a=" + a);
//		System.out.println("fileName=" + f1.getName());
		String path = "/uploadresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
