package com.kol_platformtype_config.model;

import java.util.List;

public class KolPlatformtypeConfigService {

	private KolPlatformtypeConfigDAO_interface dao;

	public KolPlatformtypeConfigService() {
		dao = new KolPlatformtypeConfigDAO();
	}

	public KolPlatformtypeConfigVO addKolPlatformtypeConfig(Integer kol_idnum, Integer platform_typenum) {

		KolPlatformtypeConfigVO kolPlatformtypeConfigVO = new KolPlatformtypeConfigVO();

		kolPlatformtypeConfigVO.setKol_idnum(kol_idnum);
		kolPlatformtypeConfigVO.setPlatform_typenum(platform_typenum);
		dao.insert(kolPlatformtypeConfigVO);

		return kolPlatformtypeConfigVO;
	}

	public void deleteKolPlatformtypeConfig(Integer kol_idnum, Integer platform_typenum) {
		dao.delete(kol_idnum, platform_typenum);
	}

	public KolPlatformtypeConfigVO getOneKolPlatformtypeConfig(Integer kol_idnum, Integer platform_typenum) {
		return dao.findByPrimaryKey(kol_idnum, platform_typenum);
	}

	public List<KolPlatformtypeConfigVO> getAll() {
		return dao.getAll();
	}
}
