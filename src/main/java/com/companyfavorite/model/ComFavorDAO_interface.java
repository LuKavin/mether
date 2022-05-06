package com.companyfavorite.model;

import java.util.List;

public interface ComFavorDAO_interface {
	
	public void insert(ComFavorVO comFavorVO);

	public void update(ComFavorVO comFavor);

	public void delete(Integer Favorite_idnum);

	public ComFavorVO findByPrimarKey(Integer Favorite_idnum);

	public List<ComFavorVO> getAll();
}
