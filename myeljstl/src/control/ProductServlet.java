package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.dto.Product;
import com.kitri.service.ProductService;

@WebServlet("/productlist")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = ProductService.getProductService().findAll();
		
		if(list != null) {
			request.setAttribute("result", list);
		} else {
			// 상품 목록이 없을 때
		}
				
		String path = "productlistresult.jsp";
		
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

	
}
