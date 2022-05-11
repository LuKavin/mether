package com.memberaccess.model;

import java.util.*;

public interface MemberAccessDAO_interface {
		public void insert(MemberAccessVO memberAccessVO);
		public void update(MemberAccessVO memberAccessVO);
		public void delete(Integer meb_accessnum);
		public MemberAccessVO findByPrimaryKey(Integer meb_accessnum);
		public List<MemberAccessVO> getAll();
}
