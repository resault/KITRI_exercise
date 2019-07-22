package com.kitri.dto;

public class ProductCategory {

	private String cateNo;
	private String cateName;

	public ProductCategory() {
		super();
	}

	public ProductCategory(String cateNo, String cateName) {
		super();
		this.cateNo = cateNo;
		this.cateName = cateName;
	}

	public String getCateNo() {
		return cateNo;
	}

	public void setCateNo(String cateNo) {
		this.cateNo = cateNo;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public String toString() {
		return "ProductCategory [cateNo=" + cateNo + ", cateName=" + cateName + "]";
	}

}
