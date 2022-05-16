package com.productPhoto.model;

import java.util.List;

public interface ProductPhotoDao_interface {
    public void insert(Integer product_num, byte[] product_photo1, byte[] product_photo2, byte[] product_photo3, byte[] product_photo4, byte[] product_photo5);
    public void delete(Integer product_photonum);
    public void updateOnePhoto(Integer productNum, byte[] photo, Integer whitchCol);
    public ProductPhotoVO findByPrimaryKey(Integer product_photonum);
    public List<ProductPhotoVO> getAll(Integer product_num);
    public List<ProductPhotoVO> getOneProductAll(Integer product_num);
}
