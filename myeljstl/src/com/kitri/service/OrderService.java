package com.kitri.service;

import java.util.List;

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
	
	
	public List<OrderInfo> findById(String id) {
		return OrderDAO.getOrderDAO().selectById(id);
	}
	
	
	
	
	
	
	
}
