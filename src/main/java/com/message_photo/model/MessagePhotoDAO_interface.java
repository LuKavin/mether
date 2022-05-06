package com.message_photo.model;

import java.util.*;

public interface MessagePhotoDAO_interface {
	public void insert(MessagePhotoVO messagePhotoVO);

	public void delete(Integer mes_photonum);

	public MessagePhotoVO findByPrimaryKey(Integer mes_photonum);

	public List<MessagePhotoVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<AdmMebVO> getAll(Map<String, String[]> map); 
}
