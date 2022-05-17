package com.kolfavorite.model;

import java.util.List;

import com.companymeb.model.CompanyMebVO;

public interface KolFavorDAO_interface {

	public void insert(Integer kol_idnum, Integer com_idnum);

//	public void update(KolFavorVO kolFavorVO);

	public void delete(Integer kol_idnum, Integer com_idnum);

	public List<CompanyMebVO>  findByPrimarKey(Integer favorite_idnum);

	public List<CompanyMebVO> getAll();

	

}
