package com.kitri.service;

import java.util.List;

import com.kitri.dao.ProductDAO;
import com.kitri.dto.Product;

public class ProductService {

	///// singletone //////
	private static ProductService productService;
	
	static {
		productService = new ProductService();
	}
	
	private ProductService () {}
	
	public static ProductService getProductService() {
		return productService;
	}
	
	
	///// method /////
	
	// 전체 상품 조회
	public List<Product> findAll() {
		return ProductDAO.getProductDAO().selectAll();
	}
	
	
	// 선택 상품 상세정보
	public Product findByNo(String no) {
		return ProductDAO.getProductDAO().SelectByNo(no);
	}
	
	



	
}
