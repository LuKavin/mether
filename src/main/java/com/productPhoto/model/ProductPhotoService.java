package com.productPhoto.model;

import java.util.List;



public class ProductPhotoService {

	private ProductPhotoDao_interface dao;

	public ProductPhotoService() {
		dao = new ProductPhotoDao();
	}

	public void addProductPhoto(Integer product_num, byte[] product_photo1, byte[] product_photo2, byte[] product_photo3, byte[] product_photo4, byte[] product_photo5) {

		dao.insert(product_num, product_photo1, product_photo2, product_photo3, product_photo4, product_photo5);

	}

	public ProductPhotoVO getOneProductPhoto(Integer product_photonum) {
		return dao.findByPrimaryKey(product_photonum);
	}

	public List<ProductPhotoVO> getAllPhotoFromProduct(Integer product_num) {
		return dao.getAll(product_num);
	}

}
