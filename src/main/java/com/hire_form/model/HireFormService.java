package com.hire_form.model;

import java.util.List;

public class HireFormService {

	private HireFormDAO_interface dao;

	public HireFormService() {
		dao = new HireFormDAO();
	}

	public HireFormVO addHireForm(Integer kol_idnum, Integer product_num, String hire_result) {

//		HireFormVO hireFormVO = new HireFormVO();
//
//		hireFormVO.setKol_idnum(kol_idnum);
//		hireFormVO.setProduct_num(product_num);
//		hireFormVO.setHire_result(hire_result);
//		dao.insert(Integer kol_idnum, Integer product_num);
//
		return null;
	}

	public HireFormVO updateHireForm(Integer kol_idnum, Integer product_num, String hire_result) {

		HireFormVO hireFormVO = new HireFormVO();

		hireFormVO.setKol_idnum(kol_idnum);
		hireFormVO.setProduct_num(product_num);
		hireFormVO.setHire_result(hire_result);
		dao.update(hireFormVO);

		return hireFormVO;
	}

	public void deleteHireForm(Integer kol_idnum, Integer product_num) {
		dao.delete(kol_idnum, product_num);
	}

	public HireFormVO getOneHireForm(Integer kol_idnum, Integer product_num) {
		return dao.findByPrimaryKey(kol_idnum, product_num);
	}
	
	public String getOne(Integer product_num) {
		return dao.findComName(product_num);
	}

	public List<HireFormVO> getAll() {
		return dao.getAll();
	}
}
