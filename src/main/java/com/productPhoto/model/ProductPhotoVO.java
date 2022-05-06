package com.productPhoto.model;

import java.io.Serializable;

public class ProductPhotoVO implements Serializable{
	
//	PRODUCT_PHOTONUM int auto_increment not null comment '商品照片編號',
//	PRODUCT_PHOTO longblob comment '商品照片',
//	PRODUCT_NUM int comment '商品編號',
	
	private Integer product_photonum;
	private byte[] product_photo;
	private Integer product_num;
	public Integer getProduct_photonum() {
		return product_photonum;
	}
	public void setProduct_photonum(Integer product_photonum) {
		this.product_photonum = product_photonum;
	}
	public byte[] getProduct_photo() {
		return product_photo;
	}
	public void setProduct_photo(byte[] product_photo) {
		this.product_photo = product_photo;
	}
	public Integer getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Integer product_num) {
		this.product_num = product_num;
	}


	

}
