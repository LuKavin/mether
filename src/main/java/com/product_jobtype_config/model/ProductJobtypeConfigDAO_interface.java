package com.product_jobtype_config.model;

import java.util.List;

public interface ProductJobtypeConfigDAO_interface {
	public void insert(ProductJobtypeConfigVO productJobtypeConfigVO);

	public void delete(Integer product_num, Integer job_typenum);

	public ProductJobtypeConfigVO findByPrimaryKey(Integer product_num, Integer job_typenum);

	public List<ProductJobtypeConfigVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
