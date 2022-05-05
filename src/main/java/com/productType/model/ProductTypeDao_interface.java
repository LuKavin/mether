package com.productType.model;

import java.util.List;


public interface ProductTypeDao_interface {
    public void insert(String product_typename);
    public void update(ProductTypeVO productTypeVO);
    public void delete(Integer product_typenum);
    public ProductTypeVO findByPrimaryKey(Integer product_typenum);
    public List<ProductTypeVO> getAll();
}
