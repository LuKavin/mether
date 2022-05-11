package com.memberphoto.model;

public class MemberPhotoVO implements java.io.Serializable{
	private Integer meb_photonum;
	private byte[] meb_photo;
	private Integer com_idnum;
	private Integer kol_idnum;
	
	public Integer getMeb_photonum() {
		return meb_photonum;
	}
	public void setMeb_photonum(Integer meb_photonum) {
		this.meb_photonum = meb_photonum;
	}
	public byte[] getMeb_photo() {
		return meb_photo;
	}
	public void setMeb_photo(byte[] meb_photo) {
		this.meb_photo = meb_photo;
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
}
