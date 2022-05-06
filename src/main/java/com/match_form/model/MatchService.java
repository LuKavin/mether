package com.match_form.model;

import java.sql.Timestamp;
import java.util.List;

public class MatchService {

	private MatchFormDAO_interface dao;

	public MatchService() {
		dao = new MatchFormDAO();
	}

	public MatchFormVO addAdmMeb(Integer kol_idnum, Integer product_num, String match_result) {

		MatchFormVO matchFormVO = new MatchFormVO();

		matchFormVO.setKol_idnum(kol_idnum);
		matchFormVO.setProduct_num(product_num);
		matchFormVO.setMatch_result(match_result);
		dao.insert(matchFormVO);

		return matchFormVO;
	}

	public MatchFormVO updateAdmMeb(Integer kol_idnum, Integer product_num, String match_result) {

		MatchFormVO matchFormVO = new MatchFormVO();

		matchFormVO.setKol_idnum(kol_idnum);
		matchFormVO.setProduct_num(product_num);
		matchFormVO.setMatch_result(match_result);
		dao.update(matchFormVO);

		return matchFormVO;
	}

	public void deleteAdmMeb(Integer kol_idnum, Integer product_num) {
		dao.delete(kol_idnum, product_num);
	}

	public MatchFormVO getOneAdmMeb(Integer kol_idnum, Integer product_num) {
		return dao.findByPrimaryKey(kol_idnum, product_num);
	}

	public List<MatchFormVO> getAll() {
		return dao.getAll();
	}
}
