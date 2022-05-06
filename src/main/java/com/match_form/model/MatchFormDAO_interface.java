package com.match_form.model;

import java.util.*;

public interface MatchFormDAO_interface {
	public void insert(MatchFormVO matchFormVO);

	public void update(MatchFormVO matchFormVO);

	public void delete(Integer kol_idnum, Integer product_num);

	public MatchFormVO findByPrimaryKey(Integer kol_idnum, Integer product_num);

	public List<MatchFormVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
