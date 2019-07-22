package com.kitri.dto;

import java.io.Serializable;

public class Product implements Serializable{
	private String proNo;
	private String prodName;
//	transient private int prod_price;//직렬화에서 제외
	private int prodPrice;//직렬화에서 제외
	private String prodDetail;
	private ProductCategory productCategory;
	public Product() {
		super();
	}
	public Product(String prod_no, String prod_name, int prod_price, String prod_detail,
				   ProductCategory productCategory) {
		super();
		this.proNo = prod_no;
		this.prodName = prod_name;
		this.prodPrice = prod_price;
		this.prodDetail = prod_detail;
		this.productCategory = productCategory;
	}
	public String getProdNo() {
		return proNo;
	}
	public void setProdNo(String prod_no) {
		this.proNo = prod_no;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prod_name) {
		this.prodName = prod_name;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prod_price) {
		this.prodPrice = prod_price;
	}
	public String getProdDetail() {
		return prodDetail;
	}
	public void setProdDetail(String prod_detail) {
		this.prodDetail = prod_detail;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	@Override
	public String toString() {
		return "Product [prod_no=" + proNo + ", prod_name=" + prodName + ", prod_price=" + prodPrice
				+ ", prod_detail=" + prodDetail + ", productCategory=" + productCategory + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proNo == null) ? 0 : proNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (proNo == null) {
			if (other.proNo != null)
				return false;
		} else if (!proNo.equals(other.proNo))
			return false;
		return true;
	}



}
