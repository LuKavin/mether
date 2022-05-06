package com.hire_form.model;

import java.sql.Timestamp;
import java.util.List;

public class HireFormService {

	private HireFormDAO_interface dao;

	public HireFormService() {
		dao = new HireFormDAO();
	}

	public HireFormVO addAdmMeb(Integer kol_idnum, Integer product_num, String hire_result) {

		HireFormVO hireFormVO = new HireFormVO();

		hireFormVO.setKol_idnum(kol_idnum);
		hireFormVO.setProduct_num(product_num);
		hireFormVO.setHire_result(hire_result);
		dao.insert(hireFormVO);

		return hireFormVO;
	}

	public HireFormVO updateAdmMeb(Integer kol_idnum, Integer product_num, String hire_result) {

		HireFormVO hireFormVO = new HireFormVO();

		hireFormVO.setKol_idnum(kol_idnum);
		hireFormVO.setProduct_num(product_num);
		hireFormVO.setHire_result(hire_result);
		dao.update(hireFormVO);

		return hireFormVO;
	}

	public void deleteAdmMeb(Integer kol_idnum, Integer product_num) {
		dao.delete(kol_idnum, product_num);
	}

	public HireFormVO getOneAdmMeb(Integer kol_idnum, Integer product_num) {
		return dao.findByPrimaryKey(kol_idnum, product_num);
	}

	public List<HireFormVO> getAll() {
		return dao.getAll();
	}
}
