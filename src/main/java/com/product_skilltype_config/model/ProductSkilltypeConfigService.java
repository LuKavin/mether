package com.product_skilltype_config.model;

import java.util.List;

public class ProductSkilltypeConfigService {

	private ProductSkilltypeConfigDAO_interface dao;

	public ProductSkilltypeConfigService() {
		dao = new ProductSkilltypeConfigDAO();
	}

	public ProductSkilltypeConfigVO addProductSkilltypeConfig(Integer product_num, Integer skill_typenum) {

		ProductSkilltypeConfigVO productSkilltypeConfigVO = new ProductSkilltypeConfigVO();

		productSkilltypeConfigVO.setProduct_num(product_num);
		productSkilltypeConfigVO.setSkill_typenum(skill_typenum);
		dao.insert(productSkilltypeConfigVO);

		return productSkilltypeConfigVO;
	}

	public void deleteProductSkilltypeConfig(Integer product_num, Integer skill_typenum) {
		dao.delete(product_num, skill_typenum);
	}

	public ProductSkilltypeConfigVO getOneProductSkilltypeConfig(Integer product_num, Integer skill_typenum) {
		return dao.findByPrimaryKey(product_num, skill_typenum);
	}

	public List<ProductSkilltypeConfigVO> getAll() {
		return dao.getAll();
	}
}
