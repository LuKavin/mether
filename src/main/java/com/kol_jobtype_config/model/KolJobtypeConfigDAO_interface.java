package com.kol_jobtype_config.model;

import java.util.List;

public interface KolJobtypeConfigDAO_interface {
	public void insert(KolJobtypeConfigVO kolJobtypeConfigVO);

	public void delete(Integer kol_idnum, Integer job_typenum);

	public KolJobtypeConfigVO findByPrimaryKey(Integer kol_idnum, Integer job_typenum);

	public List<KolJobtypeConfigVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
