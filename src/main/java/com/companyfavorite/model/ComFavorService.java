package com.companyfavorite.model;

import java.util.List;

public class ComFavorService {
	
	private ComFavorDAO_interface dao;
	
	public ComFavorService() {
		dao = new ComFavorDAO();
	}
	
	public void addCompanyFavorite(ComFavorVO comFavorVO) {
		
		dao.insert(comFavorVO);
		
	}

	public ComFavorVO updateCompanyFavorite(Integer favorite_idnum, Integer com_idnum, Integer kol_idnum) {
		
		ComFavorVO comFavorVO = new ComFavorVO(); 
		
		comFavorVO.setCom_idnum(com_idnum);
		comFavorVO.setFavorite_idnum(favorite_idnum);
		comFavorVO.setKol_idnum(kol_idnum);
		
		dao.update(comFavorVO);
		
		return comFavorVO;
		
	}
	
	public ComFavorVO deleteCompanyFavorite(Integer favorite_idnum) {
		return dao.findByPrimarKey(favorite_idnum);		
	}
	
	public List<ComFavorVO> getAll() {
		return dao.getAll();
	}
	
}
