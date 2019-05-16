package com.kitri.dto;

public class Product {

	private String prodNo;
	private String prodName;
	private int prodPrice;
	private String prodDetail;
	private ProductCategory productCategory;

	public Product() {
		super();
	}

	public Product(String prodNo, String prodName, int prodPrice, String prodDetail, String prodCATE,
			ProductCategory productCategory) {
		super();
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodDetail = prodDetail;
		this.productCategory = productCategory;
	}

	public String getProdNo() {
		return prodNo;
	}

	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdDetail() {
		return prodDetail;
	}

	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [prodNo=" + prodNo + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodDetail="
				+ prodDetail + ", productCategory=" + productCategory + "]";
	}

}
