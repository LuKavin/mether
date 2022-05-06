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
	
	public String findMemAccount(Integer mem_Idnum) {
		return dao.findAccount(mem_Idnum);
	}
	
	public void send(EmailDetailVO emailDetailVO) {
		dao.insert(emailDetailVO);
	}
	
	public List<EmailDetailVO> findMailBox(String recipient, Integer mem_Idnum) {
		return dao.findMailBox(recipient,mem_Idnum);
	}

	public EmailDetailVO updateAdmMeb(Integer skill_typenum, String skill_typename) {
		return null;
	}

	public EmailDetailVO getOneAdmMeb(Integer skill_typenum) {
		return dao.findByPrimaryKey(skill_typenum);
	}

	public List<EmailDetailVO> getAll() {
		return dao.getAll();
	}

}
