package com.kolfavorite.model;

import java.util.List;

import com.companymeb.model.CompanyMebVO;
import com.kolmeb.model.KolMebVO;

public class KolFavorService {

	private KolFavorDAO_interface dao;

	public KolFavorService() {
		dao = new KolFavorDAO();
	}

	public void addKolFavorite(Integer kol_idnum,Integer com_idnum) {
		dao.insert(kol_idnum,com_idnum);
	}

	
	public List FindKolFavorite(Integer kol_idnum) {
		
		return dao.findKolFavorite(kol_idnum);
	}
	
	public void deleteKolFavorite(Integer kol_idnum,Integer com_idnum) {
		dao.delete(kol_idnum,com_idnum);		
	}
	
	public List<CompanyMebVO> getAll() {
		return dao.getAll();
	}
}
