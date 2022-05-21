package com.adm_meb.model;

import java.util.List;

public interface AdmMebDAO_interface {
	public void insert(AdmMebVO admMebVO);

	public void update(AdmMebVO admMebVO);

	public void delete(Integer adm_idnum);

	public AdmMebVO findByPrimaryKey(Integer adm_idnum);
	
	public AdmMebVO login(String adm_account, String adm_password);

	public List<AdmMebVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
