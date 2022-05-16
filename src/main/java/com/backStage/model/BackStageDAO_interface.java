package com.backStage.model;

import java.util.List;

public interface BackStageDAO_interface {
	public Integer companyMebcount();

	public Integer kolMebcount();

	public Integer orderMastercount();

	public List getOrderMasterNew();

	public void updateComAccess(Integer meb_accessnum, Integer com_idnum);

	public void updateKolAccess(Integer meb_accessnum, Integer kol_idnum);
	
	public void updateOrderMasterStatus(String order_status, Integer order_num);
}
