package com.kolfavorite.model;

import java.util.List;

public class KolFavorService {

	private KolFavorDAO_interface dao;

	public KolFavorService() {
		dao = new KolFavorDAO();
	}

	public void addKolFavorite(KolFavorVO kolFavorVO) {
		dao.insert(kolFavorVO);
	}

public KolFavorVO updateKolFavorite(Integer favorite_idnum, Integer com_idnum, Integer kol_idnum) {
		
		KolFavorVO kolFavorVO = new KolFavorVO(); 
		
		kolFavorVO.setKol_idnum(com_idnum);
		kolFavorVO.setFavorite_idnum(favorite_idnum);
		kolFavorVO.setKol_idnum(kol_idnum);
		
		dao.update(kolFavorVO);
		
		return kolFavorVO;
		
	}
	
	public KolFavorVO deleteKolFavorite(Integer favorite_idnum) {
		return dao.findByPrimarKey(favorite_idnum);		
	}
	
	public List<KolFavorVO> getAll() {
		return dao.getAll();
	}
}
