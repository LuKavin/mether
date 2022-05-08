package com.emailDetail.model;

import java.util.List;

public class EmailDetailService {
	
	private EmailDetailDAO_interface dao;
	
	public EmailDetailService() {
		dao = new EmailDetailDAO();
	}
	
	public Integer findMemIdnum(String memName) {
		return dao.findID(memName);
	}
	
	public void send(EmailDetailVO emailDetailVO) {
		dao.insert(emailDetailVO);
	}
	
	public List<EmailDetailVO> findMailBox(String recipient, String mem_account) {
		return dao.findMailBox(recipient,mem_account);
	}

	public EmailDetailVO updateAdmMeb(Integer skill_typenum, String skill_typename) {
		return null;
	}

	public EmailDetailVO getOneLetter(Integer email_num) {
		return dao.findByPrimaryKey(email_num);
	}

	public List<EmailDetailVO> getAll() {
		return dao.getAll();
	}

}
