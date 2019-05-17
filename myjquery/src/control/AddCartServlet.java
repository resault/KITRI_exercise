package control;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.dto.Product;

@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodNum = request.getParameter("no");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		HttpSession session = request.getSession();
		
		Map<Product, Integer> cart = (Map) session.getAttribute("cart");	//이건 왜 노란줄 뜨지?
		if(cart == null) {
			cart = new HashMap<Product, Integer>();
			session.setAttribute("cart", cart);
		}
		Product p = new Product();
		p.setProdNo(prodNum);
		
		//장바구니에 해당상품이 존재하는지 확인
		Integer inte = cart.get(p);
		if(inte != null) {//존재하면 수량 합산
			quantity += inte.intValue();
		}
		cart.put(p, quantity);//장바구니에 상품, 수량 추가
		
		String path = "/addcartresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
//		System.out.println("장바구니 내용");
//		Set<Product> keys = cart.keySet();
//		for(Product key : keys) {
//			int q = cart.get(key);
//			System.out.println("상품번호 : " + key.getProdNo() + ", 수량 : " + q);
//		}
	}

}
