package movie;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int cnt;
	int sumScore;


	@Override
	public void init() throws ServletException {
		cnt = 0;
		sumScore = 0;
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int score = Integer.parseInt(request.getParameter("star"));
		cnt ++;
		sumScore += score;
		
		
		request.setAttribute("cnt", cnt);
		request.setAttribute("sumScore", sumScore);
		
		String path = "/movie/score.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}


}
