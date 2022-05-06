package com.productPhoto.model;

import java.util.List;

public interface ProductPhotoDao_interface {
    public void insert(ProductPhotoVO productPhotoVO);
    public void delete(Integer product_photonum);
    public ProductPhotoVO findByPrimaryKey(Integer product_photonum);
    public List<ProductPhotoVO> getAll(Integer product_num);
}
