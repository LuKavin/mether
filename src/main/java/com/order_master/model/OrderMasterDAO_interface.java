package com.order_master.model;

import java.util.List;

public interface OrderMasterDAO_interface {
	public void insert(OrderMasterVO orderMasterVO);

	public void update(OrderMasterVO orderMasterVO);

	public void delete(Integer order_num);

	public OrderMasterVO findByPrimaryKey(Integer order_num);

	public List<OrderMasterVO> getMebAll(Integer com_idnum, Integer mem_access);
	
	public String findComAccount(Integer order_num);
	
	public String findKolAccount(Integer order_num);

	public List<OrderMasterVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
