package com.product.model;

import java.util.List;



public class ProductService {

	private ProductDAO_interface dao;

	public ProductService() {
		dao = new ProductDAO();
	}

	public int addProduct(ProductVO productVO) {

		return dao.insert(productVO);

	}

//	public ProductVO updateJobType(Integer job_typenum, String job_typename) {
//
//		ProductVO jobTypeVO = new ProductVO();
//
//		jobTypeVO.setJob_typenum(job_typenum);
//		jobTypeVO.setJob_typename(job_typename);
//		
//		dao.update(jobTypeVO);
//		return jobTypeVO;
//	}
//
//	public void deleteJobType(Integer job_typenum) {
//		dao.delete(job_typenum);
//	}
	
	public void updateProductState(String product_state, Integer product_num) {
		dao.updateState(product_state, product_num);
	}
	
	public void allProductState(String product_state, Integer com_num) {
		dao.allState(product_state, com_num);
	}

	public ProductVO getOneProduct(Integer product_num) {
		return dao.findByPrimaryKey(product_num);
	}

	public List<ProductVO> getAll() {
		return dao.getAll();
	}

}
