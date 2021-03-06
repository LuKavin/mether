package com.adm_meb.model;

import java.util.List;

public class AdmMebService {

	private AdmMebDAO_interface dao;

	public AdmMebService() {
		dao = new AdmMebDAO();
	}

	public AdmMebVO addAdmMeb(String adm_account, String adm_password, String adm_name) {

		AdmMebVO admMebVO = new AdmMebVO();

		admMebVO.setAdm_account(adm_account);
		admMebVO.setAdm_password(adm_password);
		admMebVO.setAdm_name(adm_name);
		dao.insert(admMebVO);

		return admMebVO;
	}

	public AdmMebVO updateAdmMeb(Integer adm_idnum, String adm_account, String adm_password, String adm_name) {

		AdmMebVO admMebVO = new AdmMebVO();

		admMebVO.setAdm_idnum(adm_idnum);
		admMebVO.setAdm_account(adm_account);
		admMebVO.setAdm_password(adm_password);
		admMebVO.setAdm_name(adm_name);
		dao.update(admMebVO);

		return admMebVO;
	}

	public void deleteAdmMeb(Integer adm_idnum) {
		dao.delete(adm_idnum);
	}

	public AdmMebVO getOneAdmMeb(Integer adm_idnum) {
		return dao.findByPrimaryKey(adm_idnum);
	}

	public List<AdmMebVO> getAll() {
		return dao.getAll();
	}

	public AdmMebVO login(String adm_account, String adm_password) {
		return dao.login(adm_account, adm_password);
	}
}
