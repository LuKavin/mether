package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.product.model.ProductVO;

public class LoginDaoimpl implements LoginDao{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String FIND_COM_MEB = 
			"select * from COMPANY_MEB c where c.COM_ACCOUNT =?and c.COM_PASSWORD=?;";
	private static final String FIND_KOL_MEB = 
			"select * from     KOL_MEB c where c.KOL_ACCOUNT =?and c.KOL_PASSWORD=?;";
	@Override
	public LoginVo login(String account, String password) {
		LoginVo loginVo = null;
		try {
			loginVo = loginCom(account,password);
			if(loginVo == null) {//廠商找不到資料的話去網紅那邊找
				loginVo = loginKol(account,password);
			}
			if(loginVo == null) {//都找不到資料丟出登入錯誤例外
				throw new RuntimeException();
			}
		} catch (Exception e) {
			throw new RuntimeException("登入失敗,帳號或密碼錯誤在Dao");
		}
		return loginVo;
	}
	
	
	public LoginVo loginCom(String account, String password){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LoginVo loginVo = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_COM_MEB);
			pstmt.setString(1, account);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			while(rs.next()) {
					loginVo = new LoginVo();
					loginVo.setMebIdNum(rs.getInt("COM_IDNUM"));
					loginVo.setMebEmail(rs.getString("COM_EMAIL"));
					loginVo.setMebAccount(rs.getString("COM_ACCOUNT"));
					loginVo.setMebPassword(rs.getString("COM_PASSWORD"));
					loginVo.setMebName(rs.getString("COM_NAME"));
					loginVo.setMebAccess(rs.getInt("MEB_ACCESSNUM"));
			}
		} catch (Exception se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return loginVo;
	}
	
	public LoginVo loginKol(String account, String password){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LoginVo loginVo = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_KOL_MEB);
			pstmt.setString(1, account);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			while(rs.next()) {
					loginVo = new LoginVo();
					loginVo.setMebIdNum(rs.getInt("KOL_IDNUM"));
					loginVo.setMebEmail(rs.getString("KOL_EMAIL"));
					loginVo.setMebAccount(rs.getString("KOL_ACCOUNT"));
					loginVo.setMebPassword(rs.getString("KOL_PASSWORD"));
					loginVo.setMebName(rs.getString("KOL_NAME"));
					loginVo.setMebAccess(rs.getInt("MEB_ACCESSNUM"));
			}
		} catch (Exception se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return loginVo;
	}


}
