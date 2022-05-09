package com.product_platformtype_config.model;

import java.util.List;

public class ProductPlatformtypeConfigService {

	private ProductPlatformtypeConfigDAO_interface dao;

	public ProductPlatformtypeConfigService() {
		dao = new ProductPlatformtypeConfigDAO();
	}

	public ProductPlatformtypeConfigVO addProductPlatformtypeConfig(Integer product_num, Integer platform_typenum) {

		ProductPlatformtypeConfigVO ProductPlatformtypeConfigVO = new ProductPlatformtypeConfigVO();

		ProductPlatformtypeConfigVO.setProduct_num(product_num);
		ProductPlatformtypeConfigVO.setPlatform_typenum(platform_typenum);
		dao.insert(ProductPlatformtypeConfigVO);

		return ProductPlatformtypeConfigVO;
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
