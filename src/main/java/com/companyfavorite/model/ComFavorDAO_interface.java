package com.companyfavorite.model;

import java.util.List;

import com.companymeb.model.CompanyMebVO;

public interface ComFavorDAO_interface {
	
	public void insert(Integer com_idnum,Integer kol_idnum);

	public void update(ComFavorVO comFavorVO);

	public void delete(Integer com_idnum,Integer kol_idnum);

	public List<CompanyMebVO> findByPrimarKey(Integer favorite_idnum);

	public List<ComFavorVO> getAll();
}
