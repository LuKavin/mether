package com.message_photo.model;

public class MessagePhotoVO implements java.io.Serializable {
	private Integer mes_photonum;
	private Integer mes_num;
	private byte[] com_photo;
	private byte[] kol_photo;
	
	public Integer getMes_photonum() {
		return mes_photonum;
	}
	public void setMes_photonum(Integer mes_photonum) {
		this.mes_photonum = mes_photonum;
	}
	public Integer getMes_num() {
		return mes_num;
	}
	public void setMes_num(Integer mes_num) {
		this.mes_num = mes_num;
	}
	public byte[] getCom_photo() {
		return com_photo;
	}
	public void setCom_photo(byte[] com_photo) {
		this.com_photo = com_photo;
	}
	public byte[] getKol_photo() {
		return kol_photo;
	}
	public void setKol_photo(byte[] kol_photo) {
		this.kol_photo = kol_photo;
	}


}
