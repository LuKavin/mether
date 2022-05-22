package com.message_detail.model;

import java.util.List;

public interface MessageDetailDAO_interface {
	public void comInsert(MessageDetailVO messageDetailVO);
	public void kolInsert(MessageDetailVO messageDetailVO);

	public void delete(Integer mes_num);

	public List<MessageDetailVO> findByOrderPK(Integer mes_num);

	public List<MessageDetailVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
