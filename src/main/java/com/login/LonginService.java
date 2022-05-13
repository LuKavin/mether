package com.login;

public class LonginService {
	private LoginDao dao;
	public LonginService() {
		dao = new LoginDaoimpl();
	}
	
	public LoginVo login(String account,String password) {
		return dao.login(account, password);
	}
}
