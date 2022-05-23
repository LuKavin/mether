package com.match_form.model;

import java.util.List;

import com.product.model.ProductVO;

public class MatchService {

	private MatchFormDAO_interface dao;

	public MatchService() {
		dao = new MatchFormDAO();
	}

	public List <MatchFormVO> addMatchForm(Integer kol_idnum) {

		return dao.insert(kol_idnum);

	}

	public MatchFormVO updateMatchForm(Integer kol_idnum, Integer product_num, String match_result) {

		MatchFormVO matchFormVO = new MatchFormVO();

		matchFormVO.setKol_idnum(kol_idnum);
		matchFormVO.setProduct_num(product_num);
		matchFormVO.setMatch_result(match_result);
		dao.update(matchFormVO);

		return matchFormVO;
	}

	public void deleteMatchForm(Integer kol_idnum, Integer product_num) {
		dao.delete(kol_idnum, product_num);
	}

	public List<ProductVO> getOneMatchForm(Integer kol_idnum) {
		return dao.findByPrimaryKey(kol_idnum);
	}

	public List<MatchFormVO> getAll() {
		return dao.getAll();
	}
}
