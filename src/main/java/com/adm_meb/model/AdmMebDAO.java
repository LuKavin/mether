package com.adm_meb.model;

import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdmMebDAO implements AdmMebDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO ADM_MEB (ADM_ACCOUNT,ADM_PASSWORD,ADM_NAME,ADM_PHOTO) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT ADM_IDNUM,ADM_ACCOUNT,ADM_PASSWORD,ADM_NAME,ADM_PHOTO FROM ADM_MEB order by ADM_IDNUM";
	private static final String GET_ONE_STMT = "SELECT ADM_IDNUM,ADM_ACCOUNT,ADM_PASSWORD,ADM_NAME,ADM_PHOTO FROM ADM_MEB where ADM_IDNUM = ?";
	private static final String DELETE = "DELETE FROM ADM_MEB where ADM_IDNUM = ?";
	private static final String UPDATE = "UPDATE ADM_MEB set ADM_ACCOUNT=?, ADM_PASSWORD=?, ADM_NAME=?, ADM_PHOTO=? where ADM_IDNUM = ?";

	@Override
	public void insert(AdmMebVO admMebVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, admMebVO.getAdm_account());
			pstmt.setString(2, admMebVO.getAdm_password());
			pstmt.setString(3, admMebVO.getAdm_name());
			pstmt.setBytes(4, admMebVO.getAdm_photo());
			
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
	public void update(AdmMebVO admMebVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, admMebVO.getAdm_account());
			pstmt.setString(2, admMebVO.getAdm_password());
			pstmt.setString(3, admMebVO.getAdm_name());
			pstmt.setBytes(4, admMebVO.getAdm_photo());
			pstmt.setInt(5, admMebVO.getAdm_idnum());

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public void delete(Integer adm_idnum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, adm_idnum);

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public AdmMebVO findByPrimaryKey(Integer adm_idnum) {

		AdmMebVO admMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, adm_idnum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects

				admMebVO = new AdmMebVO();
				admMebVO.setAdm_idnum(rs.getInt("adm_idnum"));
				admMebVO.setAdm_account(rs.getString("adm_account"));
				admMebVO.setAdm_password(rs.getString("adm_password"));
				admMebVO.setAdm_name(rs.getString("adm_name"));
				admMebVO.setAdm_photo(rs.getBytes("adm_photo"));
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
		return admMebVO;
	}

	@Override
	public List<AdmMebVO> getAll() {
		List<AdmMebVO> list = new ArrayList<AdmMebVO>();
		AdmMebVO admMebVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				admMebVO = new AdmMebVO();
				admMebVO.setAdm_idnum(rs.getInt("adm_idnum"));
				admMebVO.setAdm_account(rs.getString("adm_account"));
				admMebVO.setAdm_password(rs.getString("adm_password"));
				admMebVO.setAdm_name(rs.getString("adm_name"));
				admMebVO.setAdm_photo(rs.getBytes("adm_photo"));
				list.add(admMebVO); // Store the row in the list
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