package com.order_master.model;

import java.sql.Timestamp;

public class OrderMasterVO implements java.io.Serializable {
	private Integer order_num;
	private Integer product_num;
	private Integer kol_idnum;
	private Integer com_idnum;
	private String order_status;
	private Timestamp order_date;
	private Integer order_amount;
	private String com_rate;
	private String kol_rate;
	private Integer com_star;
	private Integer kol_star;
	private byte[] order_pic;
	private String order_content;
	private String order_link;
	
	

	public byte[] getOrder_pic() {
		return order_pic;
	}

	public void setOrder_pic(byte[] order_pic) {
		this.order_pic = order_pic;
	}

	public String getOrder_content() {
		return order_content;
	}

	public void setOrder_content(String order_content) {
		this.order_content = order_content;
	}

	public String getOrder_link() {
		return order_link;
	}

	public void setOrder_link(String order_link) {
		this.order_link = order_link;
	}

	public Integer getOrder_num() {
		return order_num;
	}

	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}

	public Integer getProduct_num() {
		return product_num;
	}

	public void setProduct_num(Integer product_num) {
		this.product_num = product_num;
	}

	public Integer getKol_idnum() {
		return kol_idnum;
	}

	public void setKol_idnum(Integer kol_idnum) {
		this.kol_idnum = kol_idnum;
	}

	public Integer getCom_idnum() {
		return com_idnum;
	}

	public void setCom_idnum(Integer com_idnum) {
		this.com_idnum = com_idnum;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Timestamp getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	public Integer getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(Integer order_amount) {
		this.order_amount = order_amount;
	}

	public String getCom_rate() {
		return com_rate;
	}

	public void setCom_rate(String com_rate) {
		this.com_rate = com_rate;
	}

	public String getKol_rate() {
		return kol_rate;
	}

	public void setKol_rate(String kol_rate) {
		this.kol_rate = kol_rate;
	}

	public Integer getCom_star() {
		return com_star;
	}

	public void setCom_star(Integer com_star) {
		this.com_star = com_star;
	}

	public Integer getKol_star() {
		return kol_star;
	}

	public void setKol_star(Integer kol_star) {
		this.kol_star = kol_star;
	}

}
