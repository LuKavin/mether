package com.hire_form.model;

import java.sql.Timestamp;

public class HireFormVO implements java.io.Serializable {
	private Integer kol_idnum;
	private Integer product_num;
	private Timestamp hire_date_time;
	private String hire_result;

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

	public Timestamp getHire_date_time() {
		return hire_date_time;
	}

	public void setHire_date_time(Timestamp hire_date_time) {
		this.hire_date_time = hire_date_time;
	}

	public String getHire_result() {
		return hire_result;
	}

	public void setHire_result(String hire_result) {
		this.hire_result = hire_result;
	}

}
