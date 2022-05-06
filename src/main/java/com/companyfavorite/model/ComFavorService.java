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

	public ComFavorVO updateCompanyFavorite(Integer favorite_IdNum, Integer com_IdNum, Integer kol_IdNum) {
		
		ComFavorVO comFavorVO = new ComFavorVO(); 
		
		comFavorVO.setCom_idnum(com_IdNum);
		comFavorVO.setFavorite_idnum(favorite_IdNum);
		comFavorVO.setKol_idnum(kol_IdNum);
		
		dao.update(comFavorVO);
		
		return comFavorVO;
		
	}
	
	public ComFavorVO deleteCompanyFavorite(Integer favorite_IdNum) {
		return dao.findByPrimarKey(favorite_IdNum);		
	}
	
	public List<ComFavorVO> getAll() {
		return dao.getAll();
	}
	
}
