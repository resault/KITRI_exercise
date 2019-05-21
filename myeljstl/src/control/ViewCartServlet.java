package control;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.Product;
import com.kitri.exception.NotFoundException;
import com.kitri.service.ProductService;

@WebServlet("/viewcart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<Product, Integer> cart = (Map) session.getAttribute("cart");
		Map<Product, Integer> rc = new HashMap<Product, Integer>();
		
		
		if(cart != null) {
			Set<Product> keys = cart.keySet();
			for(Product product : keys) {
				String no = product.getProdNo();
				try {
					Product p = ProductService.getProductService().findByNo(no);
					int quantity = cart.get(product);
					rc.put(p, quantity);
				} catch (NotFoundException e) {
					
				}
			}
		}
		request.setAttribute("rcart", rc);
		String path = "/viewcartresult.jsp";
		
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
