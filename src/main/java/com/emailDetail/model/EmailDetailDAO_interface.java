package com.emailDetail.model;

import java.util.List;


public interface EmailDetailDAO_interface {
	
	public void insert(EmailDetailVO emailDetailVO);
	public void update(EmailDetailVO emailDetailVO);
	public EmailDetailVO findByPrimaryKey(Integer email_num);//用mailPK找出VO(一封信)
	public Integer findID(String memAccount);//用會員account找帳號的流水號
	public List<EmailDetailVO> findMailBox(String recipient,String mem_Idnum);//用收件者+MEM_IDnum整理出信箱
	public void delete(Integer email_num);
	public List<EmailDetailVO> getAll();

}
