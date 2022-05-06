package com.match_form.model;

import java.sql.Timestamp;

public class MatchFormVO implements java.io.Serializable {
	private Integer kol_idnum;
	private Integer product_num;
	private Timestamp match_date_time;
	private String match_result;
	
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
	public Timestamp getMatch_date_time() {
		return match_date_time;
	}
	public void setMatch_date_time(Timestamp match_date_time) {
		this.match_date_time = match_date_time;
	}
	public String getMatch_result() {
		return match_result;
	}
	public void setMatch_result(String match_result) {
		this.match_result = match_result;
	}
	
}
