package com.backStage.model;

import java.util.List;

public interface BackStageDAO_interface {
	public Integer companyMebcount();

	public Integer kolMebcount();

	public Integer orderMastercount();

	public List getOrderMasterNew();

	public List getComAccess1();

	public List getComAccess4();

	public List getKolAccess2();

	public List getKolAccess4();

	public void updateComAccess(Integer meb_accessnum, Integer com_idnum);

	public void updateKolAccess(Integer meb_accessnum, Integer kol_idnum);

	public void updateOrderMasterStatus(String order_status, Integer order_num);

	public List getKolPhoto();

	public List getKolSearch(String search);

	public List getComSearch(String search);

	public List getProductSearch(String search);

	public List getAllOrderMaster(Integer order_number);

}
