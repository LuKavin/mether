package com.favorite_product.model;

import java.io.Serializable;

public class FavorProductVO implements Serializable {
	private Integer fav_productnum;
	private Integer kol_idnum;
	private Integer product_num;

	@Override
	public String toString() {
		return "FavorProductVo [fav_productnum=" + fav_productnum + ", kol_idnum=" + kol_idnum + ", product_num="
				+ product_num + "]";
	}

	public Integer getFav_productnum() {
		return fav_productnum;
	}

	public void setFav_productnum(Integer fav_productnum) {
		this.fav_productnum = fav_productnum;
	}

	public Integer getKol_idnum() {
		return kol_idnum;
	}

	public void setKol_idnum(Integer kol_idnum) {
		this.kol_idnum = kol_idnum;
	}

	public Integer getProduct_num() {
		return product_num;
	}

	public void setProduct_num(Integer product_num) {
		this.product_num = product_num;
	}

}
