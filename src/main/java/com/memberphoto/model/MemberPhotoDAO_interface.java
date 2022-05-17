package com.memberphoto.model;

import java.util.*;

public interface MemberPhotoDAO_interface {
	public int insert(MemberPhotoVO memberPhotoVO);
	public void update(MemberPhotoVO memberPhotoVO);
	public void delete(Integer meb_photonum); 
	public MemberPhotoVO findByPrimaryKey(Integer meb_photonum);
	public List<MemberPhotoVO> getComAll(Integer com_idnum);
	public List<MemberPhotoVO> getKolAll(Integer kol_idnum);
}
