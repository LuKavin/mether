package com.product_skilltype_config.model;

import java.util.List;

public interface ProductSkilltypeConfigDAO_interface {
	public void insert(ProductSkilltypeConfigVO productSkilltypeConfigVO);

	public void delete(Integer product_num, Integer skill_typenum);

	public ProductSkilltypeConfigVO findByPrimaryKey(Integer product_num, Integer skill_typenum);

	public List<ProductSkilltypeConfigVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
