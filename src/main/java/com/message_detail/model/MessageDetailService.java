package com.message_detail.model;

import java.util.List;

public class MessageDetailService {

	private MessageDetailDAO_interface dao;

	public MessageDetailService() {
		dao = new MessageDetailDAO();
	}

	public MessageDetailVO addAdmMeb(Integer order_num, String com_message, String kol_message, String mes_topic) {

		MessageDetailVO messageDetailVO = new MessageDetailVO();

		messageDetailVO.setOrder_num(order_num);
		messageDetailVO.setCom_message(com_message);
		messageDetailVO.setKol_message(kol_message);
		messageDetailVO.setMes_topic(mes_topic);
		dao.insert(messageDetailVO);

		return messageDetailVO;
	}

	public void deleteAdmMeb(Integer mes_num) {
		dao.delete(mes_num);
	}

	public MessageDetailVO getOneAdmMeb(Integer mes_num) {
		return dao.findByPrimaryKey(mes_num);
	}

	public List<MessageDetailVO> getAll() {
		return dao.getAll();
	}
}
