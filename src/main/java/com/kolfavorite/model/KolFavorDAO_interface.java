package com.kolfavorite.model;

import java.util.*;

public interface KolFavorDAO_interface {

	public void insert(KolFavorVO kolFavorVO);

	public void update(KolFavorVO kolFavorVO);

	public void delete(Integer favorite_idnum);

	public KolFavorVO findByPrimarKey(Integer favorite_idnum);

	public List<KolFavorVO> getAll();

	

}
