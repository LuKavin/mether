package com.kol_skilltype_config.model;

import java.util.List;

public class KolSkilltypeConfigService {

	private KolSkilltypeConfigDAO_interface dao;

	public KolSkilltypeConfigService() {
		dao = new KolSkilltypeConfigDAO();
	}

	public KolSkilltypeConfigVO addKolSkilltypeConfig(Integer kol_idnum, Integer skill_typenum) {

		KolSkilltypeConfigVO kolSkilltypeConfigVO = new KolSkilltypeConfigVO();

		kolSkilltypeConfigVO.setKol_idnum(kol_idnum);
		kolSkilltypeConfigVO.setSkill_typenum(skill_typenum);
		dao.insert(kolSkilltypeConfigVO);

		return kolSkilltypeConfigVO;
	}

	public void deleteKolSkilltypeConfig(Integer kol_idnum, Integer skill_typenum) {
		dao.delete(kol_idnum, skill_typenum);
	}

	public KolSkilltypeConfigVO getOneKolSkilltypeConfig(Integer kol_idnum, Integer skill_typenum) {
		return dao.findByPrimaryKey(kol_idnum, skill_typenum);
	}

	public List<KolSkilltypeConfigVO> getAll() {
		return dao.getAll();
	}
}
