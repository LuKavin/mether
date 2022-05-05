package com.skillType.model;

import java.util.List;


public interface SkillTypeDAO_interface {
	
	public void insert(SkillTypeVO skillTypeVO);
	public void update(SkillTypeVO skillTypeVO);
	public SkillTypeVO findByPrimaryKey(Integer skill_typenum);
	public List<SkillTypeVO> getAll();

}
