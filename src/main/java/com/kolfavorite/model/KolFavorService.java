package com.kolfavorite.model;

import java.util.List;

<<<<<<< HEAD
=======
import com.companymeb.model.CompanyMebVO;
import com.kolmeb.model.KolMebVO;

>>>>>>> alanyu
public class KolFavorService {

	private KolFavorDAO_interface dao;

	public KolFavorService() {
		dao = new KolFavorDAO();
	}

<<<<<<< HEAD
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
=======
	public void addKolFavorite(Integer kol_idnum,Integer com_idnum) {
		dao.insert(kol_idnum,com_idnum);
	}

	
	public List<CompanyMebVO> FindKolFavorite(Integer kol_idnum) {
		
		return dao.findByPrimarKey(kol_idnum);
	}
	
	public void deleteKolFavorite(Integer kol_idnum,Integer com_idnum) {
		dao.delete(kol_idnum,com_idnum);		
	}
	
	public List<CompanyMebVO> getAll() {
>>>>>>> alanyu
		return dao.getAll();
	}
}
