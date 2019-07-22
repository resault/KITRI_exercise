package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitri.dto.Product;
import com.kitri.service.ProductService;

@WebServlet("/productlistjson")
public class ProductListJSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
	public ProductListJSONServlet() {
		service = ProductService.getProductService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = service.findAll();
		//request.setAttribute("productlist", list);
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(list);
		request.setAttribute("productlist", result);
		
		String path = "productlistjsonresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
