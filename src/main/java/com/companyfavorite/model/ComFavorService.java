package com.companyfavorite.model;

import java.util.List;

import com.companymeb.model.CompanyMebVO;

public class ComFavorService {
	
	private ComFavorDAO_interface dao;
	
	public ComFavorService() {
		dao = new ComFavorDAO();
	}
	
	public void addCompanyFavorite(Integer com_idnum,Integer kol_idnum) {
		dao.insert(com_idnum,kol_idnum);
	}

	public ComFavorVO updateCompanyFavorite(ComFavorVO comFavorVO) {
		dao.update(comFavorVO);
		return comFavorVO;
	}
	
	public List<CompanyMebVO> FindKolFavorite(Integer kol_idnum) {
			
		return dao.findByPrimarKey(kol_idnum);
	}
	
	public void deleteCompanyFavorite(Integer com_idnum,Integer kol_idnum) {
		dao.delete(com_idnum,kol_idnum);		
	}
	
	public List<ComFavorVO> getAll() {
		return dao.getAll();
	}
	
}
