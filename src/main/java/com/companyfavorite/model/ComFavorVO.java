package com.companyfavorite.model;

import java.io.Serializable;

public class ComFavorVO implements Serializable {
	private Integer favorite_idnum;
	private Integer com_idnum;
	private Integer kol_idnum;

	public Integer getFavorite_idnum() {
		return favorite_idnum;
	}

	public void setFavorite_idnum(Integer favorite_idnum) {
		this.favorite_idnum = favorite_idnum;
	}

	public Integer getCom_idnum() {
		return com_idnum;
	}

	public void setCom_idnum(Integer com_idnum) {
		this.com_idnum = com_idnum;
	}

	public Integer getKol_idnum() {
		return kol_idnum;
	}

	public void setKol_idnum(Integer kol_idnum) {
		this.kol_idnum = kol_idnum;
	}

	@Override
	public String toString() {
		return "ComFavorVo [favorite_idnum=" + favorite_idnum + ", com_idnum=" + com_idnum + ", kol_idnum=" + kol_idnum
				+ "]";
	}
}
