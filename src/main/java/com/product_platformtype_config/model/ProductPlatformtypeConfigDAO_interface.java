package com.product_platformtype_config.model;

import java.util.List;

public interface ProductPlatformtypeConfigDAO_interface {
	public void insert(ProductPlatformtypeConfigVO productPlatformtypeConfigVO);

	public void delete(Integer product_num, Integer platform_typenum);

	public ProductPlatformtypeConfigVO findByPrimaryKey(Integer product_num, Integer platform_typenum);

	public List<ProductPlatformtypeConfigVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
