package com.product.model;

import java.util.List;


public interface ProductDAO_interface {
    public int insert(ProductVO productVO);
//    public void update(ProductVO productVO);
    public void updateState(String product_state, Integer product_num);
    public void allState(String product_state, Integer com_num);
//    public void delete(Integer product_typenum);
    public ProductVO findByPrimaryKey(Integer product_typenum);
    public List<ProductVO> getAll();

}
