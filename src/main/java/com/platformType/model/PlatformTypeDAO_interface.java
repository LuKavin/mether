package com.platformType.model;

import java.util.List;


public interface PlatformTypeDAO_interface {
	
	public void insert(PlatformTypeVO platformTypeVO);
	public void update(PlatformTypeVO platformTypeVO);
	public PlatformTypeVO findByPrimaryKey(Integer platform_typenum);
	public List<PlatformTypeVO> getAll();

}
