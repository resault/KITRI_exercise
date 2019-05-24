package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.PageBean;
import com.kitri.dto.RepBoardDto;
import com.kitri.service.RepBoardService;

@WebServlet("/boardlist")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cp = request.getParameter("currentPage");
		int currentPage = 1;
		if(cp != null) {
			currentPage = Integer.parseInt(cp);
		}
		
		
		int cntPerPage = 5;
		int totalCnt = RepBoardService.getRepBoardService().getTotalCnt(); //총게시글 수
		int cntPerPageGroup=3; //페이지그룹에 보여줄 페이지수
		String url = "boardlist";
		
		PageBean pb = new PageBean(cntPerPage, totalCnt, cntPerPageGroup, url, currentPage);
		
		List<RepBoardDto> list = RepBoardService.getRepBoardService().findByRows(pb.getStartRow(), pb.getEndRow());
		
		request.setAttribute("list", list);
		request.setAttribute("totalPage", pb.getTotalPage());
		request.setAttribute("startPage", pb.getStartPage());
		request.setAttribute("endPage", pb.getEndPage());
		request.setAttribute("pb", pb);
		
		String path = "/boardlistresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		//---------------------------------------------------------------------------------- //총페이지 수 계산
		  
		/*  
		  다시 풀어볼 것!!
		  
		  int cntPerPageGroup = 3; //페이지 그룹에 보여줄 페이지 수
		  int cntPageGroup = totalPage / cntPerPageGroup;
		  int endPage = 0;
		  int startPage = 0;
		  
		  
			for(int i=1; i<=cntPageGroup+1; i++) {
				endPage = i * cntPerPageGroup;
				startPage = 1 + (i-1)*cntPerPageGroup;
		  
				if(endPage+cntPageGroup > totalPage) {
			  		endPage = totalPage; startPage = cntPageGroup * cntPerPageGroup + 1;
			  	}
			  
			  	if(currentPage >= startPage && currentPage <= endPage) {
			  		break;
			  	}			  
		  }
		*/ 

		
	}


}
