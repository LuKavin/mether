package com.skillType.model;

import java.util.List;

public class SkillTypeService {
	
	private SkillTypeDAO_interface dao;
	
	public SkillTypeService() {
		dao = new SkillTypeDAO();
	}
	
	public SkillTypeVO addSkillType(Integer skill_typenum, String skill_typename) {

		SkillTypeVO skillTypeVO = new SkillTypeVO();

		skillTypeVO.setSkill_typenum(skill_typenum);
		skillTypeVO.setSkill_typename(skill_typename);
		dao.insert(skillTypeVO);

		return skillTypeVO;
	}

	public SkillTypeVO updateSkillType(Integer skill_typenum, String skill_typename) {

		SkillTypeVO skillTypeVO = new SkillTypeVO();

		skillTypeVO.setSkill_typenum(skill_typenum);
		skillTypeVO.setSkill_typename(skill_typename);
		dao.update(skillTypeVO);

		return skillTypeVO;
	}

	public SkillTypeVO getOneSkillType(Integer skill_typenum) {
		return dao.findByPrimaryKey(skill_typenum);
	}

	public List<SkillTypeVO> getAll() {
		return dao.getAll();
	}

}
