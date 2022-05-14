package com.platformType.model;

import java.util.List;

import com.skillType.model.SkillTypeVO;

public class PlatformTypeService {
	
	private PlatformTypeDAO_interface dao;
	
	public  PlatformTypeService() {
		dao = new PlatformTypeDAO();
	}
	
	public PlatformTypeVO addPlatformType(String platform_typename) {

		PlatformTypeVO platformTypeVO = new PlatformTypeVO();

		platformTypeVO.setPlatform_typename(platform_typename);
		dao.insert(platformTypeVO);

		return platformTypeVO;
	}

	public PlatformTypeVO updatePlatformType(PlatformTypeVO platformTypeVO ) {

		dao.update(platformTypeVO);

		return platformTypeVO;
	}

	public PlatformTypeVO getOnePlatformType(Integer platform_typenum) {
		return dao.findByPrimaryKey(platform_typenum);
	}

	public List<PlatformTypeVO> getAll() {
		return dao.getAll();
	}

}
