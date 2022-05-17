package com.kolmeb.model;

import java.util.*;

import com.companymeb.model.CompanyMebVO;

public class KolMebService {
	
	private KolMebDAO_interface dao;
	
	public KolMebService() {
		dao = new KolMebDAO();
	}
	
	public KolMebVO loginmeb(String mem_account, String mem_password) {
		return dao.findAccountPassword(mem_account, mem_password);
	}
	
	public boolean checkKolMeb(String kol_account) {
		return dao.commatch(kol_account);
	}
	
	public int addKolMeb(KolMebVO kolMebVO) {
		return dao.insert(kolMebVO);
	}

	public KolMebVO updateKolMeb(KolMebVO kolMebVO) {
		dao.update(kolMebVO);
		return kolMebVO;
	}
	
	public void deleteKolMeb(Integer kol_idnum) {
		dao.delete(kol_idnum);
	}

	public KolMebVO getOneKolMeb(Integer kol_idnum) {
		return dao.findByPrimaryKey(kol_idnum);
	}

	public List<KolMebVO> getAll() {
		return dao.getAll();
	}
	
	public void updateKolPassword(String kol_email, String kol_password) {
		dao.updatepassword(kol_email,kol_password);
	}
	
	public Integer getOneKolEmail(String kol_email) {
		return dao.findByKolEmail(kol_email);
	}
}
