package com.order_master.model;

import java.util.List;

public class OrderMasterService {

	private OrderMasterDAO_interface dao;

	public OrderMasterService() {
		dao = new OrderMasterDAO();
	}

	public OrderMasterVO addOrderMaster(Integer product_num, Integer kol_idnum, Integer com_idnum, String order_status,
			Integer order_amount, String com_rate, String kol_rate, Integer com_star, Integer kol_star) {

		OrderMasterVO orderMasterVO = new OrderMasterVO();

		orderMasterVO.setProduct_num(product_num);
		orderMasterVO.setKol_idnum(kol_idnum);
		orderMasterVO.setCom_idnum(com_idnum);
		orderMasterVO.setOrder_status(order_status);
		orderMasterVO.setOrder_amount(order_amount);
		orderMasterVO.setCom_rate(com_rate);
		orderMasterVO.setKol_rate(kol_rate);
		orderMasterVO.setCom_star(com_star);
		orderMasterVO.setKol_star(kol_star);
		dao.insert(orderMasterVO);

		return orderMasterVO;
	}

	public OrderMasterVO updateOrderMaster(Integer order_num, String order_status, String com_rate, String kol_rate,
			Integer com_star, Integer kol_star) {

		OrderMasterVO orderMasterVO = new OrderMasterVO();

		orderMasterVO.setOrder_num(order_num);
		orderMasterVO.setOrder_status(order_status);
		orderMasterVO.setCom_rate(com_rate);
		orderMasterVO.setKol_rate(kol_rate);
		orderMasterVO.setCom_star(com_star);
		orderMasterVO.setKol_star(kol_star);
		dao.update(orderMasterVO);

		return orderMasterVO;
	}

	public void deleteOrderMaster(Integer order_num) {
		dao.delete(order_num);
	}

	public OrderMasterVO getOneOrderMaster(Integer order_num) {
		return dao.findByPrimaryKey(order_num);
	}

	public List<OrderMasterVO> getAll() {
		return dao.getAll();
	}
}
