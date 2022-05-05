package com.productType.model;

import java.util.List;



public class ProductTypeService {

	private ProductTypeDao_interface dao;

	public ProductTypeService() {
		dao = new ProductTypeDao();
	}

	public void addProductType(String product_typename) {

		dao.insert(product_typename);

	}

	public void updateProductType(ProductTypeVO productTypeVO) {

		dao.update(productTypeVO);
	}
	
	public ProductTypeVO getOneProductType(Integer product_typenum) {
		return dao.findByPrimaryKey(product_typenum);
	}

	public List<ProductTypeVO> getAll() {
		return dao.getAll();
	}

}
