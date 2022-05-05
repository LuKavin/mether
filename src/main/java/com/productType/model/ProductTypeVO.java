package com.productType.model;

import java.io.Serializable;

public class ProductTypeVO implements Serializable{
	private Integer product_typenum;
	private String product_typename;
	public Integer getProduct_typenum() {
		return product_typenum;
	}
	public void setProduct_typenum(Integer product_typenum) {
		this.product_typenum = product_typenum;
	}
	public String getProduct_typename() {
		return product_typename;
	}
	public void setProduct_typename(String product_typename) {
		this.product_typename = product_typename;
	}
	

	

}
