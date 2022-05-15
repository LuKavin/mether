package com.productPhoto.model;

import java.io.Serializable;

public class ProductPhotoVO implements Serializable{
	
//	PRODUCT_PHOTONUM int auto_increment not null comment '商品照片編號',
//	PRODUCT_PHOTO longblob comment '商品照片',
//	PRODUCT_NUM int comment '商品編號',
	
	private Integer product_photonum;
	private byte[] product_photo1;
	private byte[] product_photo2;
	private byte[] product_photo3;
	private byte[] product_photo4;
	private byte[] product_photo5;
	private Integer product_num;
	
	
	public byte[] getProduct_photo2() {
		return product_photo2;
	}
	public void setProduct_photo2(byte[] product_photo2) {
		this.product_photo2 = product_photo2;
	}
	public byte[] getProduct_photo3() {
		return product_photo3;
	}
	public void setProduct_photo3(byte[] product_photo3) {
		this.product_photo3 = product_photo3;
	}
	public byte[] getProduct_photo4() {
		return product_photo4;
	}
	public void setProduct_photo4(byte[] product_photo4) {
		this.product_photo4 = product_photo4;
	}
	public byte[] getProduct_photo5() {
		return product_photo5;
	}
	public void setProduct_photo5(byte[] product_photo5) {
		this.product_photo5 = product_photo5;
	}
	public Integer getProduct_photonum() {
		return product_photonum;
	}
	public void setProduct_photonum(Integer product_photonum) {
		this.product_photonum = product_photonum;
	}
	public Integer getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Integer product_num) {
		this.product_num = product_num;
	}
	public byte[] getProduct_photo1() {
		return product_photo1;
	}
	public void setProduct_photo1(byte[] product_photo1) {
		this.product_photo1 = product_photo1;
	}


	

}
