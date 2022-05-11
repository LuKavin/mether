package com.memberphoto.model;

import java.util.*;

public interface MemberPhotoDAO_interface {
	public int insert(MemberPhotoVO memberPhotoVO);
	public MemberPhotoVO findByPrimaryKey(Integer meb_photonum);
	public List<MemberPhotoVO> getAll();
}
