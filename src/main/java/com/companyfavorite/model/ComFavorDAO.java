package com.companyfavorite.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.companymeb.model.CompanyMebVO;
import com.kolmeb.model.KolMebVO;

public class ComFavorDAO implements ComFavorDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO `COMPANY_FAVORITE` (`COM_IDNUM`, `KOL_IDNUM`)"
			+ "VALUES (?,?)";
	private static final String GET_ALL_STMT = "SELECT KOL_IDNUM, KOL_NAME, KOL_EMAIL, KOL_PHONE,  KOL_WEBSITE "
			+ "FROM KOL_MEB ;";
	private static final String GET_ONE_STMT = "SELECT c.KOL_IDNUM, k.KOL_NAME, k.KOL_EMAIL, k.KOL_PHONE,  k.KOL_WEBSITE "
			+ "FROM KOL_MEB k JOIN COMPANY_FAVORITE c ON k.KOL_IDNUM  = c.KOL_IDNUM where "
			+ "c.COM_IDNUM = ? ;";
	private static final String DELETE = "DELETE FROM COMPANY_FAVORITE where com_idnum  = ? and kol_idnum = ? ";

	public void insert(Integer com_idnum, Integer kol_idnum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, com_idnum);
			pstmt.setInt(2, kol_idnum);

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
	}

	public void update(ComFavorVO comFavorVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
//			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, comFavorVO.getFavorite_idnum());
			pstmt.setInt(2, comFavorVO.getCom_idnum());
			pstmt.setInt(3, comFavorVO.getKol_idnum());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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

	}

	@Override
	public void delete(Integer com_idnum, Integer kol_idnum) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, com_idnum);
			pstmt.setInt(2, kol_idnum);

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
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
	}

	@Override
	public List<KolMebVO> findByPrimarKey(Integer com_idnum) {
		// TODO Auto-generated method stub
		List<KolMebVO> list = new ArrayList<KolMebVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();

			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, com_idnum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				KolMebVO kolMebVO = new KolMebVO();
				kolMebVO.setKol_idnum(rs.getInt("KOL_IDNUM"));
				kolMebVO.setKol_name(rs.getString(2));
				kolMebVO.setKol_email(rs.getString(3));
				kolMebVO.setKol_cellphone(rs.getString(4));
				kolMebVO.setKol_website(rs.getString(5));
				
				
//				CompanyMebVO companyMebVO = new CompanyMebVO();
//				companyMebVO.setCom_idnum(rs.getInt("COM_IDNUM"));
//				companyMebVO.setCom_name(rs.getString(2));
//				companyMebVO.setCom_email(rs.getString(3));
//				companyMebVO.setCom_phone(rs.getString(4));
//				companyMebVO.setCom_website(rs.getString(5));
//				c.COM_IDNUM, c.COM_NAME, c.COM_EMAIL, c.COM_PHONE,  c.COM_WEBSITE
				list.add(kolMebVO);
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return list;
	}

	@Override
	public List<KolMebVO> getAll() {
		List<KolMebVO> list = new ArrayList<KolMebVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				KolMebVO kolMebVO = new KolMebVO();
				kolMebVO.setKol_idnum(rs.getInt("KOL_IDNUM"));
				kolMebVO.setKol_name(rs.getString(2));
				kolMebVO.setKol_email(rs.getString(3));
				kolMebVO.setKol_cellphone(rs.getString(4));
				kolMebVO.setKol_website(rs.getString(5));
				list.add(kolMebVO);
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return list;
	}

}
