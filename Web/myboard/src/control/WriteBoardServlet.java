package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.RepBoardDto;
import com.kitri.exception.AddException;
import com.kitri.service.RepBoardService;

@WebServlet("/writeboard")
public class WriteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = -1;
				
		try {
			request.setCharacterEncoding("UTF-8");
			
			String subject = request.getParameter("subject");
			String writer = request.getParameter("writer");
			String contents = request.getParameter("contents");
			String password = request.getParameter("password");
			
			RepBoardDto repBoardDto = new RepBoardDto(subject, writer, contents, password);
			RepBoardService.getRepBoardService().write(repBoardDto);
			result = 1;
			
		} catch (AddException e) {
			e.printStackTrace();
			result = -1;
		}
		
		String path = "writeresult.jsp";
		request.setAttribute("result", result);

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

}
