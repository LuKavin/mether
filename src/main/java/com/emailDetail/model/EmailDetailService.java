package com.emailDetail.model;

import java.util.List;

public class EmailDetailService {
	
	private EmailDetailDAO_interface dao;
	
	public EmailDetailService() {
		dao = new EmailDetailDAO();
	}
	
	public Integer findMemAccess(String memName) {
		return dao.findAccess(memName);
	}
	
	public void send(EmailDetailVO emailDetailVO) {
		dao.insert(emailDetailVO);
	}
	
	public List<EmailDetailVO> findMailBox(String mem_account) {
		return dao.findMailBox(mem_account);
	}

	public void deleteLetter(Integer email_num) {
		dao.delete(email_num);
	}

	public EmailDetailVO getOneLetter(Integer email_num) {
		return dao.findByPrimaryKey(email_num);
	}

	public List<EmailDetailVO> getAll() {
		return dao.getAll();
	}

}
