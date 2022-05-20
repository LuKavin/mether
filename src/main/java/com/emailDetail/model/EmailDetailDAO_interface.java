package com.emailDetail.model;

import java.util.List;


public interface EmailDetailDAO_interface {
	
	public EmailDetailVO findByPrimaryKey(Integer email_num);//用mailPK找出VO(一封信)
	public List<EmailDetailVO> findMailBox(String mem_account);//用帳號找出信箱
	public List<EmailDetailVO> findADMBox();//用帳號找出信箱
	public List<EmailDetailVO> findBox(String mem_account, Integer mailType);//用帳號找出垃圾桶 或 草稿夾
	
	public void insert(EmailDetailVO emailDetailVO);//寄信
	public void addDraft(EmailDetailVO emailDetailVO);//加入草稿
	
	
	public void delete(Integer email_num);//刪除信件
	public void toTrashCan(Integer email_num);//移至垃圾信箱
	public void rollBack(Integer email_num, String email_type);//取消刪除
	
	public Integer findAccess(String memAccount);//用會員account找會員權限
	public void errorLetter(String memAccount,Integer memAccess, String wrongAccount);//操作錯誤系統自動寄出信件
	public List<EmailDetailVO> getAll();

}
