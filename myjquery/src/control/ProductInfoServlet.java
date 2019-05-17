package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.Product;
import com.kitri.exception.NotFoundException;
import com.kitri.service.ProductService;

@WebServlet("/productinfo")
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		Product product = null;
		try {
			product = ProductService.getProductService().findByNo(no);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		
		if(product != null) {
			request.setAttribute("result", product);
		}
		
		String path = "/productinforesult.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}


}
