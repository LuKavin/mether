package com.emailDetail.model;

import java.sql.Timestamp;

public class EmailDetailVO {
	
//	EMAIL_NUM int auto_increment not null comment '信件編號',
//	COM_account int not null comment '廠商編號',
//	KOL_account int not null comment '網紅編號',
//	EMAIL_TYPENUM int not null comment '信件類別編號',
//	EMAIL_TITLE varchar(50) comment '信件標題',
//	EMAIL_CONTENT varchar(1000) comment '信件內容',
//	EMAIL_DATE datetime default(NOW()) comment '信件日期',
//	ADM_account int not null comment'管理員編號',
	
	private Integer email_num;
	private String com_account;
	private String kol_account;
	private String adm_account;
	private Integer email_typenum;
	private String email_title;
	private String email_content;
	private Timestamp email_date;
	private String sender;
	public Integer getEmail_num() {
		return email_num;
	}
	public void setEmail_num(Integer email_num) {
		this.email_num = email_num;
	}
	public String getCom_account() {
		return com_account;
	}
	public void setCom_account(String com_account) {
		this.com_account = com_account;
	}
	public String getKol_account() {
		return kol_account;
	}
	public void setKol_account(String kol_account) {
		this.kol_account = kol_account;
	}
	public String getAdm_account() {
		return adm_account;
	}
	public void setAdm_account(String adm_account) {
		this.adm_account = adm_account;
	}
	public Integer getEmail_typenum() {
		return email_typenum;
	}
	public void setEmail_typenum(Integer email_typenum) {
		this.email_typenum = email_typenum;
	}
	public String getEmail_title() {
		return email_title;
	}
	public void setEmail_title(String email_title) {
		this.email_title = email_title;
	}
	public String getEmail_content() {
		return email_content;
	}
	public void setEmail_content(String email_content) {
		this.email_content = email_content;
	}
	public Timestamp getEmail_date() {
		return email_date;
	}
	public void setEmail_date(Timestamp email_date) {
		this.email_date = email_date;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	
	
}
