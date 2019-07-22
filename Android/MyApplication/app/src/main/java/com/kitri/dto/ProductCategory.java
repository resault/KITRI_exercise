package com.kitri.dto;

import java.io.Serializable;

public class ProductCategory implements Serializable {
	private String cateNo;
	private String cateName;
	public ProductCategory() {
		super();
	}
	public ProductCategory(String cate_no, String cate_name) {
		super();
		this.cateNo = cate_no;
		this.cateName = cate_name;
	}
	public String getCateNo() {
		return cateNo;
	}
	public void setCateNo(String cate_no) {
		this.cateNo = cate_no;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cate_name) {
		this.cateName = cate_name;
	}
	@Override
	public String toString() {
		return "ProductCategory [cate_no=" + cateNo + ", cate_name=" + cateName + "]";
	}


}
