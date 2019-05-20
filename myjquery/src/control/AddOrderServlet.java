package control;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.*;
import com.kitri.exception.AddException;
import com.kitri.service.OrderService;

@WebServlet("/addorder")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//장바구니 정보가 주문테이블에 저장
		OrderInfo info = new OrderInfo();

		HttpSession session = request.getSession();
		
		Customer c = new Customer();
		c.setId((String) session.getAttribute("loginInfo")); 
		info.setCustomer(c); // 주문자 ID 설정
		
		//장바구니 상품번호, 수량 >>> OrderLine에 설정
		Map<Product, Integer> cart = (Map) session.getAttribute("cart");
		List<OrderLine> lines = new ArrayList<OrderLine>();
		
		for(Product p : cart.keySet()) {
			String no = p.getProdNo();
			int quantity = (Integer) cart.get(p);
			OrderLine line = new OrderLine();
			
			line.setProduct(p);
			line.setOrder_quantity(quantity);

			lines.add(line);
		}
		info.setLines(lines);
		
		String result = "";
		try {
			OrderService.getOrderService().addOrder(info);
			session.removeAttribute("cart"); //장바구니 비우기
			result = "1";
		} catch (AddException e) {
			e.printStackTrace();
			result = "-1";
		}
		
		String path = "/addorderresult.jsp";
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}


}
