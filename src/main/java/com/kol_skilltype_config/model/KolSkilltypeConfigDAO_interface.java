package com.kol_skilltype_config.model;

import java.util.List;

public interface KolSkilltypeConfigDAO_interface {
	public void insert(KolSkilltypeConfigVO kolSkilltypeConfigVO);

	public void delete(Integer kol_idnum, Integer skill_typenum);

	public KolSkilltypeConfigVO findByPrimaryKey(Integer kol_idnum, Integer skill_typenum);

	public List<KolSkilltypeConfigVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
