package com.product_platformtype_config.model;

import java.util.List;

public class ProductPlatformtypeConfigService {

	private ProductPlatformtypeConfigDAO_interface dao;

	public ProductPlatformtypeConfigService() {
		dao = new ProductPlatformtypeConfigDAO();
	}

	public ProductPlatformtypeConfigVO addProductPlatformtypeConfig(Integer product_num, Integer platform_typenum) {

		ProductPlatformtypeConfigVO productPlatformtypeConfigVO = new ProductPlatformtypeConfigVO();

		productPlatformtypeConfigVO.setProduct_num(product_num);
		productPlatformtypeConfigVO.setPlatform_typenum(platform_typenum);
		dao.insert(productPlatformtypeConfigVO);

		return productPlatformtypeConfigVO;
	}

	public void deleteProductPlatformtypeConfig(Integer product_num, Integer platform_typenum) {
		dao.delete(product_num, platform_typenum);
	}

	public ProductPlatformtypeConfigVO getOneProductPlatformtypeConfig(Integer product_num, Integer platform_typenum) {
		return dao.findByPrimaryKey(product_num, platform_typenum);
	}

	public List<ProductPlatformtypeConfigVO> getAll() {
		return dao.getAll();
	}
}
