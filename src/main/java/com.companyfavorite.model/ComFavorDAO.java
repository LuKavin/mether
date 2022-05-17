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
	private static final String GET_ALL_STMT = "SELECT k.COM_IDNUM, c.COM_NAME, c.COM_EMAIL, c.COM_PHONE,  c.COM_WEBSITE "
			+ "			FROM COMPANY_MEB c JOIN KOL_FAVORITE k ON c.COM_IDNUM  = k.COM_IDNUM where "
			+ "			k.KOL_IDNUM = ? ";
	private static final String UPDATE = "UPDATE COMPANY_FAVORITE SET favorite_idnum = ? where favorite_idnum = ?";
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
			pstmt = con.prepareStatement(UPDATE);

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
			System.out.println("12345");

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
	public List<CompanyMebVO> findByPrimarKey(Integer kol_idnum) {
		// TODO Auto-generated method stub
		List<CompanyMebVO> list = new ArrayList<CompanyMebVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();

			pstmt = con.prepareStatement(GET_ALL_STMT);
			pstmt.setInt(1, kol_idnum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CompanyMebVO companyMebVO = new CompanyMebVO();
				companyMebVO.setCom_idnum(rs.getInt("COM_IDNUM"));
				companyMebVO.setCom_name(rs.getString(2));
				companyMebVO.setCom_email(rs.getString(3));
				companyMebVO.setCom_phone(rs.getString(4));
				companyMebVO.setCom_website(rs.getString(5));
//				c.COM_IDNUM, c.COM_NAME, c.COM_EMAIL, c.COM_PHONE,  c.COM_WEBSITE

				list.add(companyMebVO);
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
	public List<ComFavorVO> getAll() {
		List<ComFavorVO> list = new ArrayList<ComFavorVO>();
		ComFavorVO comFavorVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
//				System.out.println("���]��");
				comFavorVO = new ComFavorVO();
				comFavorVO.setFavorite_idnum(rs.getInt("favorite_idnum"));
				comFavorVO.setCom_idnum(rs.getInt("com_idnum"));
				comFavorVO.setKol_idnum(rs.getInt("kol_idnum"));
				list.add(comFavorVO);
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
