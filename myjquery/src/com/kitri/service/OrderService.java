package com.kitri.service;

import com.kitri.dao.OrderDAO;
import com.kitri.dto.OrderInfo;
import com.kitri.exception.AddException;

public class OrderService {

	/////// single tone
	private static OrderService orderService;
	
	static {
		orderService = new OrderService();
	}
	
	private OrderService() {}
	
	public static OrderService getOrderService() {
		return orderService;
	}


	/////// method
	
	public void addOrder(OrderInfo info) throws AddException{

		OrderDAO.getOrderDAO().insert(info);
		
	}
}
