package com.memberaccess.model;

import java.util.*;


public class MemberAccessService {
	
	private MemberAccessDAO_interface dao;

	public MemberAccessService() {
		dao = new MemberAccessDAO();
	}
	
	public MemberAccessVO addMemberAccess(MemberAccessVO memberAccessVO) {
		dao.insert(memberAccessVO);
		return memberAccessVO;
	}
	
	public MemberAccessVO updateMemberAccess(MemberAccessVO memberAccessVO) {
		dao.update(memberAccessVO);
		return memberAccessVO;
	}

	public void deleteMemberAccess(Integer meb_accessnum) {
		dao.delete(meb_accessnum);
	}

	public MemberAccessVO getOneMemberAccess(Integer meb_accessnum) {
		return dao.findByPrimaryKey(meb_accessnum);
	}

	public List<MemberAccessVO> getAll() {
		return dao.getAll();
	}
}