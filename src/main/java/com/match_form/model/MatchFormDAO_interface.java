package com.match_form.model;

import java.util.List;

import com.product.model.ProductVO;

public interface MatchFormDAO_interface {
	public void insert(Integer kol_idnum, Integer product_num);

	public void update(MatchFormVO matchFormVO);

	public void delete(Integer kol_idnum, Integer product_num);

	public List<ProductVO> findByPrimaryKey(Integer kol_idnum);
	

	public List<ProductVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 

}
