package com.product.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ProductVO implements Serializable{
	private Integer product_num;
	private Integer product_typenum;
	private String product_name;
	private String product_introduce;
	private String product_link;
	private Integer product_budget;
	private Integer product_count;
	private String product_contract;
	private Date product_deadline;
	private Date product_date;
	private String product_state;
	private byte[] test_pic;
	private Integer com_idnum;
	
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	@Override
	public String toString() {
		return "ProductVO [product_num=" + product_num + ", product_typenum=" + product_typenum + ", product_name="
				+ product_name + ", product_introduce=" + product_introduce + ", product_link=" + product_link
				+ ", product_budget=" + product_budget + ", product_count=" + product_count + ", product_contract="
				+ product_contract + ", product_deadline=" + product_deadline + ", product_date=" + product_date
				+ ", product_state=" + product_state + ", com_idnum=" + com_idnum + "]";
	}
	
	
	public byte[] getTest_pic() {
		return test_pic;
	}


	public void setTest_pic(byte[] test_pic) {
		this.test_pic = test_pic;
	}


	public Integer getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Integer product_num) {
		this.product_num = product_num;
	}
	public Integer getProduct_typenum() {
		return product_typenum;
	}
	public void setProduct_typenum(Integer product_typenum) {
		this.product_typenum = product_typenum;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_introduce() {
		return product_introduce;
	}
	public void setProduct_introduce(String product_introduce) {
		this.product_introduce = product_introduce;
	}
	public String getProduct_link() {
		return product_link;
	}
	public void setProduct_link(String product_link) {
		this.product_link = product_link;
	}
	public Integer getProduct_budget() {
		return product_budget;
	}
	public void setProduct_budget(Integer product_budget) {
		this.product_budget = product_budget;
	}
	public Integer getProduct_count() {
		return product_count;
	}
	public void setProduct_count(Integer product_count) {
		this.product_count = product_count;
	}
	public String getProduct_contract() {
		return product_contract;
	}
	public void setProduct_contract(String product_contract) {
		this.product_contract = product_contract;
	}
	public Date getProduct_deadline() {
		return product_deadline;
	}
	public void setProduct_deadline(Date product_deadline) {
		this.product_deadline = product_deadline;
	}
	public Date getProduct_date() {
		return product_date;
	}
	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}
	public String getProduct_state() {
		return product_state;
	}
	public void setProduct_state(String product_state) {
		this.product_state = product_state;
	}
	public int getCom_idnum() {
		return com_idnum;
	}
	public void setCom_idnum(int com_idnum) {
		this.com_idnum = com_idnum;
	}
	
	

}
