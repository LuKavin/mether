package com.backStage.model;

import java.util.List;

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

	public List getNew() {
		return dao.getNew();
	}
}
