package com.companymeb.model;

import java.util.*;

public interface CompanyMebDAO_interface {
		public int insert(CompanyMebVO companyMebVO);
		public void update(CompanyMebVO companyMebVO);
		public void delete(Integer com_idnum);
		public CompanyMebVO findByPrimaryKey(Integer com_idnum);
		public List<CompanyMebVO> getAll();
		public boolean kolmatch(String com_account);
		public CompanyMebVO findAccountPassword(String mem_account, String mem_password);
}
