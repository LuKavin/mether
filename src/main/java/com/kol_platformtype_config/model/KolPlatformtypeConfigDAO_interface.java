package com.kol_platformtype_config.model;

import java.util.List;

public interface KolPlatformtypeConfigDAO_interface {
	public void insert(KolPlatformtypeConfigVO kolPlatformtypeConfigVO);

	public void delete(Integer kol_idnum, Integer platform_typenum);

	public KolPlatformtypeConfigVO findByPrimaryKey(Integer kol_idnum, Integer platform_typenum);

	public List<KolPlatformtypeConfigVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
