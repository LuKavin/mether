package com.message_detail.model;

import java.util.List;

public class MessageDetailService {

	private MessageDetailDAO_interface dao;

	public MessageDetailService() {
		dao = new MessageDetailDAO();
	}

	public void comAddMessage(MessageDetailVO messageDetailVO) {
		dao.comInsert(messageDetailVO);
	}
	public void kolAddMessage(MessageDetailVO messageDetailVO) {
		dao.kolInsert(messageDetailVO);
	}

	public void deleteMessageDetail(Integer mes_num) {
		dao.delete(mes_num);
	}

	public List<MessageDetailVO> getMessageDetailList(Integer mes_num) {
		return dao.findByOrderPK(mes_num);
	}

	public List<MessageDetailVO> getAll() {
		return dao.getAll();
	}
}
