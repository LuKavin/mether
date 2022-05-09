package com.kol_jobtype_config.model;

import java.util.List;

public class KolJobtypeConfigService {

	private KolJobtypeConfigDAO_interface dao;

	public KolJobtypeConfigService() {
		dao = new KolJobtypeConfigDAO();
	}

	public KolJobtypeConfigVO addKolJobtypeConfig(Integer kol_idnum, Integer job_typenum) {

		KolJobtypeConfigVO kolJobtypeConfigVO = new KolJobtypeConfigVO();

		kolJobtypeConfigVO.setKol_idnum(kol_idnum);
		kolJobtypeConfigVO.setJob_typenum(job_typenum);
		dao.insert(kolJobtypeConfigVO);

		return kolJobtypeConfigVO;
	}

	public void deleteKolJobtypeConfig(Integer kol_idnum, Integer job_typenum) {
		dao.delete(kol_idnum, job_typenum);
	}

	public KolJobtypeConfigVO getOneKolJobtypeConfig(Integer kol_idnum, Integer job_typenum) {
		return dao.findByPrimaryKey(kol_idnum, job_typenum);
	}

	public List<KolJobtypeConfigVO> getAll() {
		return dao.getAll();
	}
}
