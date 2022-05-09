package com.favorite_product.model;

import java.util.List;

public class FavorProductService {

	private FavorProductDAO_interface dao;

	public FavorProductService() {
		dao = new FavorProductDAO();
	}

	public FavorProductVO addFavorProduct(Integer fav_productnum, Integer kol_idnum, Integer product_num) {

		FavorProductVO favorProductVO = new FavorProductVO();

		favorProductVO.setFav_productnum(fav_productnum);
		favorProductVO.setKol_idnum(kol_idnum);
		favorProductVO.setProduct_num(product_num);
		dao.insert(favorProductVO);

		return favorProductVO;
	}

	public FavorProductVO updateFavorProduct(Integer fav_productnum, Integer kol_idnum, Integer product_num) {

		FavorProductVO favorProductVO = new FavorProductVO();

		favorProductVO.setFav_productnum(fav_productnum);
		favorProductVO.setKol_idnum(kol_idnum);
		favorProductVO.setProduct_num(product_num);
		dao.insert(favorProductVO);

		return favorProductVO;
	}

	public void deleteFavorProduct(Integer fav_productnum) {
		dao.delete(fav_productnum);
	}
	
	public FavorProductVO getOneFavorProduct(Integer fav_productnum, Integer kol_idnum, Integer product_num) {
		return dao.findByPrimaryKey(fav_productnum);
	}
	
	public List<FavorProductVO> getAll() {
		return dao.getAll();
	}
	
}
