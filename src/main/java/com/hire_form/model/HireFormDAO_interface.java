package com.hire_form.model;

import java.util.List;

public interface HireFormDAO_interface {
	public void insert(HireFormVO hireFormVO);

	public void update(HireFormVO hireFormVO);

	public void delete(Integer kol_idnum, Integer product_num);

	public HireFormVO findByPrimaryKey(Integer kol_idnum, Integer product_num);

	public List<HireFormVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
