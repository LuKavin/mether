package com.emailDetail.model;

import java.sql.Timestamp;

public class EmailDetailVO {
	
//	EMAIL_NUM int auto_increment not null comment '信件編號',
//	COM_IDNUM int not null comment '廠商編號',
//	KOL_IDNUM int not null comment '網紅編號',
//	EMAIL_TYPENUM int not null comment '信件類別編號',
//	EMAIL_TITLE varchar(50) comment '信件標題',
//	EMAIL_CONTENT varchar(1000) comment '信件內容',
//	EMAIL_DATE datetime default(NOW()) comment '信件日期',
//	ADM_IDNUM int not null comment'管理員編號',
	
	private Integer email_num;
	private Integer com_idnum;
	private Integer kol_idnum;
	private Integer adm_idnum;
	private Integer email_typenum;
	private String email_title;
	private String email_content;
	private Timestamp email_date;
	private String recipient;
	
	
	
	@Override
	public String toString() {
		return "EmailDetailVO [email_num=" + email_num + ", com_idnum=" + com_idnum + ", kol_idnum=" + kol_idnum
				+ ", adm_idnum=" + adm_idnum + ", email_typenum=" + email_typenum + ", email_title=" + email_title
				+ ", email_content=" + email_content + ", email_date=" + email_date + "]";
	}
	public Integer getEmail_num() {
		return email_num;
	}
	public void setEmail_num(Integer email_num) {
		this.email_num = email_num;
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
	public Integer getAdm_idnum() {
		return adm_idnum;
	}
	public void setAdm_idnum(Integer adm_idnum) {
		this.adm_idnum = adm_idnum;
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
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
}
