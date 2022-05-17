package com.memberphoto.model;

import java.util.*;

public class MemberPhotoService {
	
	private MemberPhotoDAO_interface dao;

	public MemberPhotoService() {
		dao = new MemberPhotoDAO();
	}

	public int addMemberPhoto(MemberPhotoVO memberPhotoVO) {
		return dao.insert(memberPhotoVO);
	}
	
	public void updateMemberPhoto(MemberPhotoVO memberPhotoVO) {
		dao.update(memberPhotoVO);
	}

	public void deleteMemberPhoto(Integer meb_photonum) {
		dao.delete(meb_photonum);
	}

	public MemberPhotoVO getOneMemberPhoto(Integer meb_photonum) {
		return dao.findByPrimaryKey(meb_photonum);
	}

	public List<MemberPhotoVO> getComAll(Integer com_idnum) {
		return dao.getComAll(com_idnum);
	}
	
	public List<MemberPhotoVO> getKolAll(Integer kol_idnum) {
		return dao.getKolAll(kol_idnum);
	}
}

