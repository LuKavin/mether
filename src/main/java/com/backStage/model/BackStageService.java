package com.backStage.model;

import java.util.List;

import com.companymeb.model.CompanyMebVO;
import com.kolmeb.model.KolMebVO;

public class BackStageService {

	private BackStageDAO_interface dao;

	public BackStageService() {
		dao = new BackStageDAO();
	}

	public Integer companyMebcount() {
		return dao.companyMebcount();
	}

	public Integer kolMebcount() {
		return dao.kolMebcount();
	}

	public Integer orderMastercount() {
		return dao.orderMastercount();
	}

	public List getOrderMasterNew() {
		return dao.getOrderMasterNew();
	}

	public void updateComAccess(Integer meb_accessnum, Integer com_idnum) {
		dao.updateComAccess(meb_accessnum, com_idnum);
	}

	public void updateKolAccess(Integer meb_accessnum, Integer kol_idnum) {
		dao.updateKolAccess(meb_accessnum, kol_idnum);
	}

	public void updateOrderMasterStatus(String order_status, Integer order_num) {
		dao.updateOrderMasterStatus(order_status, order_num);
	}

	public List getComAccess4() {
		return dao.getComAccess4();
	}

	public List getComAccess1() {
		return dao.getComAccess1();
	}

	public List getKolAccess4() {
		return dao.getKolAccess4();
	}

	public List getKolAccess2() {
		return dao.getKolAccess2();
	}
}
