package com.message_photo.model;

import java.util.List;

public class MessagePhotoService {

	private MessagePhotoDAO_interface dao;

	public MessagePhotoService() {
		dao = new MessagePhotoDAO();
	}

	public MessagePhotoVO addMessagePhoto(Integer mes_num, byte[] com_photo, byte[] kol_photo) {

		MessagePhotoVO messagePhotoVO = new MessagePhotoVO();

		messagePhotoVO.setMes_num(mes_num);
		messagePhotoVO.setCom_photo(com_photo);
		messagePhotoVO.setKol_photo(kol_photo);
		dao.insert(messagePhotoVO);

		return messagePhotoVO;
	}

	public void deleteMessagePhoto(Integer mes_photonum) {
		dao.delete(mes_photonum);
	}

	public MessagePhotoVO getOneMessagePhoto(Integer mes_photonum) {
		return dao.findByPrimaryKey(mes_photonum);
	}

	public List<MessagePhotoVO> getAll() {
		return dao.getAll();
	}
}
