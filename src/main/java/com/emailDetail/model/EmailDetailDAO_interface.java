package com.emailDetail.model;

import java.util.List;


public interface EmailDetailDAO_interface {
	
	public void insert(EmailDetailVO emailDetailVO);
	public EmailDetailVO findByPrimaryKey(Integer email_num);//用mailPK找出VO(一封信)
	public List<EmailDetailVO> findMailBox(String mem_account);//用帳號找出信箱整理出信箱
	public void delete(Integer email_num);
	public List<EmailDetailVO> getAll();
//	public void update(EmailDetailVO emailDetailVO);
	public Integer findAccess(String memAccount);//用會員account找會員權限

}
