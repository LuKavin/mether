package com.product_jobtype_config.model;

import java.util.List;

public class ProductJobtypeConfigService {

	private ProductJobtypeConfigDAO_interface dao;

	public ProductJobtypeConfigService() {
		dao = new ProductJobtypeConfigDAO();
	}

	public ProductJobtypeConfigVO addProductJobtypeConfig(Integer product_num, Integer job_typenum) {

		ProductJobtypeConfigVO productJobtypeConfigVO = new ProductJobtypeConfigVO();

		productJobtypeConfigVO.setProduct_num(product_num);
		productJobtypeConfigVO.setJob_typenum(job_typenum);
		dao.insert(productJobtypeConfigVO);

		return productJobtypeConfigVO;
	}

	public void deleteProductJobtypeConfig(Integer product_num, Integer job_typenum) {
		dao.delete(product_num, job_typenum);
	}

	public ProductJobtypeConfigVO getOneProductJobtypeConfig(Integer product_num, Integer job_typenum) {
		return dao.findByPrimaryKey(product_num, job_typenum);
	}

	public List<ProductJobtypeConfigVO> getAll() {
		return dao.getAll();
	}
}
