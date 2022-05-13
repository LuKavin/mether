package com.login;

import java.io.Serializable;

public class LoginVo implements Serializable{
	private Integer mebIdNum;
	private String mebEmail;
	private String mebAccount;
	private String mebPassword;
	private String mebName;
	private Integer mebAccess;
	@Override
	public String toString() {
		return "LoginVo [mebIdNum=" + mebIdNum + ", mebEmail=" + mebEmail + ", mebAccount=" + mebAccount
				+ ", mebPassword=" + mebPassword + ", mebName=" + mebName + "]";
	}
	
	public Integer getMebAccess() {
		return mebAccess;
	}

	public void setMebAccess(Integer mebAccess) {
		this.mebAccess = mebAccess;
	}

	public Integer getMebIdNum() {
		return mebIdNum;
	}
	public void setMebIdNum(Integer mebIdNum) {
		this.mebIdNum = mebIdNum;
	}
	public String getMebEmail() {
		return mebEmail;
	}
	public void setMebEmail(String mebEmail) {
		this.mebEmail = mebEmail;
	}
	public String getMebAccount() {
		return mebAccount;
	}
	public void setMebAccount(String mebAccount) {
		this.mebAccount = mebAccount;
	}
	public String getMebPassword() {
		return mebPassword;
	}
	public void setMebPassword(String mebPassword) {
		this.mebPassword = mebPassword;
	}
	public String getMebName() {
		return mebName;
	}
	public void setMebName(String mebName) {
		this.mebName = mebName;
	}

}
