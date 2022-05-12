package com.emailDetail.model;

import java.util.List;

public class EmailDetailService {
	
	private EmailDetailDAO_interface dao;
	
	//建構子
	public EmailDetailService() {
		dao = new EmailDetailDAO();
	}
	
	//判斷收件者的會員權限(廠商or網宏)
	public Integer findMemAccess(String memName) {
		return dao.findAccess(memName);
	}
	
	//寄信
	public void send(EmailDetailVO emailDetailVO) {
		dao.insert(emailDetailVO);
	}
	
	//找一組信箱
	public List<EmailDetailVO> findMailBox(String mem_account) {
		return dao.findMailBox(mem_account);
	}
	//垃圾信,信箱
	public List<EmailDetailVO> findTrashCanMailBox(String mem_account) {
		return dao.findTrashCanBox(mem_account);
	}
	
	//刪除信件
	public void deleteLetter(Integer email_num) {
		dao.delete(email_num);
	}
	
	//至垃圾桶
	public void trashCanLetter(Integer email_num) {
		dao.toTrashCan(email_num);
	}
	
	//顯示一封信
	public EmailDetailVO getOneLetter(Integer email_num) {
		return dao.findByPrimaryKey(email_num);
	}
	
	//寄件失敗系統寄出失敗信
	public void sendErrorLetter(String memAccount,Integer memAccess,String wrongAccount) {
		dao.errorLetter(memAccount, memAccess, wrongAccount);
	}
	
	//????
	public List<EmailDetailVO> getAll() {
		return dao.getAll();
	}

}
