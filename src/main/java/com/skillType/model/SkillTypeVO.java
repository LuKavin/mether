package com.skillType.model;

public class SkillTypeVO {
	
	private Integer skill_typenum;
	private String skill_typename;
	
	@Override
	public String toString() {
		return "SkillTypeVO [skill_typenum=" + skill_typenum + ", skill_typename=" + skill_typename + "]";
	}
	public Integer getSkill_typenum() {
		return skill_typenum;
	}
	public void setSkill_typenum(Integer skill_typenum) {
		this.skill_typenum = skill_typenum;
	}
	public String getSkill_typename() {
		return skill_typename;
	}
	public void setSkill_typename(String skill_typename) {
		this.skill_typename = skill_typename;
	}
	
}
