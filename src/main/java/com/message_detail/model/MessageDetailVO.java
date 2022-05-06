package com.message_detail.model;

import java.sql.Timestamp;

public class MessageDetailVO implements java.io.Serializable {
	private Integer mes_num;
	private Integer order_num;
	private String com_message;
	private String kol_message;
	private String mes_topic;
	private Timestamp mes_date_time;
	public Integer getMes_num() {
		return mes_num;
	}
	public void setMes_num(Integer mes_num) {
		this.mes_num = mes_num;
	}
	public Integer getOrder_num() {
		return order_num;
	}
	public void setOrder_num(Integer order_num) {
		this.order_num = order_num;
	}
	public String getCom_message() {
		return com_message;
	}
	public void setCom_message(String com_message) {
		this.com_message = com_message;
	}
	public String getKol_message() {
		return kol_message;
	}
	public void setKol_message(String kol_message) {
		this.kol_message = kol_message;
	}
	public String getMes_topic() {
		return mes_topic;
	}
	public void setMes_topic(String mes_topic) {
		this.mes_topic = mes_topic;
	}
	public Timestamp getMes_date_time() {
		return mes_date_time;
	}
	public void setMes_date_time(Timestamp mes_date_time) {
		this.mes_date_time = mes_date_time;
	}
	

}
