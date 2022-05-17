package com.kolfavorite.model;

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

public class KolFavorDAO implements KolFavorDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO `KOL_FAVORITE` (`COM_IDNUM`, `KOL_IDNUM`)" + "VALUES (?,?)";
	private static final String GET_ALL_STMT = "SELECT COM_IDNUM, COM_NAME, COM_EMAIL, COM_PHONE,  COM_WEBSITE "
			+ "FROM COMPANY_MEB ;";
	private static final String GET_ONE_STMT = "SELECT k.COM_IDNUM, c.COM_NAME, c.COM_EMAIL, c.COM_PHONE,  c.COM_WEBSITE \n"
			+ "FROM COMPANY_MEB c JOIN KOL_FAVORITE k ON c.COM_IDNUM  = k.COM_IDNUM where \n" + "k.KOL_IDNUM = ? ;";
	private static final String DELETE = "DELETE FROM KOL_FAVORITE where kol_idnum = ? and com_idnum  = ? ";

//	public static void main(String[] args) {
//		
//		ComFavorDAO test = new ComFavorDAO();
//		
//		test.insert("美妝","2","3");
//	}
//		

	public void insert(Integer kol_idnum, Integer com_idnum) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int favorite_idnum = -1;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, kol_idnum);
			pstmt.setInt(2, com_idnum);

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

	public void update(KolFavorVO kolFavorVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
//			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, kolFavorVO.getFavorite_idnum());
			pstmt.setInt(2, kolFavorVO.getCom_idnum());
			pstmt.setInt(3, kolFavorVO.getKol_idnum());

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
	public void delete(Integer kol_idnum, Integer com_idnum) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, kol_idnum);
			pstmt.setInt(2, com_idnum);

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

			pstmt = con.prepareStatement(GET_ONE_STMT);
			rs = pstmt.getResultSet();
			pstmt.setInt(1, kol_idnum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CompanyMebVO companyMebVO = new CompanyMebVO();
				companyMebVO.setCom_idnum(rs.getInt("COM_IDNUM"));
				companyMebVO.setCom_name(rs.getString(2));
				companyMebVO.setCom_email(rs.getString(3));
				companyMebVO.setCom_phone(rs.getString(4));
				companyMebVO.setCom_website(rs.getString(5));
				
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
	public List<CompanyMebVO> getAll() {
		List<CompanyMebVO> list = new ArrayList<CompanyMebVO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
//				System.out.println("���]��");
				CompanyMebVO companyMebVO = new CompanyMebVO();
				companyMebVO.setCom_idnum(rs.getInt("COM_IDNUM"));
				companyMebVO.setCom_name(rs.getString(2));
				companyMebVO.setCom_email(rs.getString(3));
				companyMebVO.setCom_phone(rs.getString(4));
				companyMebVO.setCom_website(rs.getString(5));
				
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

}
