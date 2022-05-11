package com.companymeb.model;

import java.util.List;

import com.kolmeb.model.KolMebDAO;
import com.kolmeb.model.KolMebDAO_interface;
import com.kolmeb.model.KolMebVO;


public class CompanyMebService {

	private CompanyMebDAO_interface dao;

	public CompanyMebService() {
		dao = new CompanyMebDAO();
	}
	
	public CompanyMebVO loginmeb(String mem_account, String mem_password) {
		return dao.findAccountPassword(mem_account, mem_password);
	}
	
	public boolean checkCompanyMeb(String com_account) {
		return dao.kolmatch(com_account);
	}
	
	public int addCompanyMeb(CompanyMebVO companyMebVO) {
		return dao.insert(companyMebVO);
	}

	public CompanyMebVO updateCompanyMeb(CompanyMebVO companyMebVO) {
		dao.update(companyMebVO);
		return companyMebVO;
	}
	
	public void deleteCompanyMeb(Integer com_idnum) {
		dao.delete(com_idnum);
	}

	public CompanyMebVO getOneCompanyMeb(Integer com_idnum) {
		return dao.findByPrimaryKey(com_idnum);
	}

	public List<CompanyMebVO> getAll() {
		return dao.getAll();
	}	
}
