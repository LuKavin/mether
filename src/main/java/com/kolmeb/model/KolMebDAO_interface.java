package com.kolmeb.model;

import java.util.*;

import com.companymeb.model.CompanyMebVO;

public interface KolMebDAO_interface {
		public int insert(KolMebVO kolMebVO);
		public void update(KolMebVO kolMebVO);
		public void delete(Integer kol_idnum);
		public KolMebVO findByPrimaryKey(Integer kol_idnum);
		public List<KolMebVO> getAll();
		public boolean commatch(String kol_account);
		public KolMebVO findAccountPassword(String mem_account, String mem_password);
		public void updatepassword(String kol_email, String kol_password);
		public Integer findByKolEmail(String kol_email);
}
