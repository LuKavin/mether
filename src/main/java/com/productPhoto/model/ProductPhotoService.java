package com.productPhoto.model;

import java.util.List;



public class ProductPhotoService {

	private ProductPhotoDao_interface dao;

	public ProductPhotoService() {
		dao = new ProductPhotoDao();
	}

	public void addProductPhoto(ProductPhotoVO productPhotoVO) {

		dao.insert(productPhotoVO);

	}

	public ProductPhotoVO getOneProductPhoto(Integer product_photonum) {
		return dao.findByPrimaryKey(product_photonum);
	}

	public List<ProductPhotoVO> getAllPhotoFromProduct(Integer product_num) {
		return dao.getAll(product_num);
	}

}
