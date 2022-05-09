package com.favorite_product.model;

import java.util.List;

public interface FavorProductDAO_interface {
	public void insert(FavorProductVO favorProductVO);
	
	public void update(FavorProductVO favorProductVO);
	
	public void delete(Integer fav_productnum);
	
	public FavorProductVO findByPrimaryKey(Integer fav_productnum);
	
	public List<FavorProductVO> getAll();
}
