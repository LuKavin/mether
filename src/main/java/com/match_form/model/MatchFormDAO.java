package com.match_form.model;

import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MatchFormDAO implements MatchFormDAO_interface {

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

	private static final String INSERT_STMT = "INSERT INTO MATCH_FORM (KOL_IDNUM, PRODUCT_NUM, MATCH_RESULT) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT KOL_IDNUM, PRODUCT_NUM, MATCH_DATE_TIME, MATCH_RESULT FROM MATCH_FORM order by KOL_IDNUM, PRODUCT_NUM";
	private static final String GET_ONE_STMT = "SELECT KOL_IDNUM, PRODUCT_NUM, MATCH_DATE_TIME, MATCH_RESULT FROM MATCH_FORM where KOL_IDNUM = ? and PRODUCT_NUM = ?";
	private static final String DELETE = "DELETE FROM MATCH_FORM where KOL_IDNUM = ? and PRODUCT_NUM = ?";
	private static final String UPDATE = "UPDATE MATCH_FORM set MATCH_RESULT=? where KOL_IDNUM = ? and PRODUCT_NUM = ?";

	@Override
	public void insert(MatchFormVO matchFormVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, matchFormVO.getKol_idnum());
			pstmt.setInt(2, matchFormVO.getProduct_num());
			pstmt.setString(3, matchFormVO.getMatch_result());
			
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
	public void update(MatchFormVO matchFormVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, matchFormVO.getMatch_result());
			pstmt.setInt(2, matchFormVO.getKol_idnum());
			pstmt.setInt(3, matchFormVO.getProduct_num());

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
	public void delete(Integer kol_idnum, Integer product_num) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, kol_idnum);
			pstmt.setInt(2, product_num);

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
	public MatchFormVO findByPrimaryKey(Integer kol_idnum, Integer product_num) {

		MatchFormVO matchFormVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, kol_idnum);
			pstmt.setInt(2, product_num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects

				matchFormVO = new MatchFormVO();
				matchFormVO.setKol_idnum(rs.getInt("kol_idnum"));
				matchFormVO.setProduct_num(rs.getInt("product_num"));
				matchFormVO.setMatch_date_time(rs.getTimestamp("match_date_time"));
				matchFormVO.setMatch_result(rs.getString("match_result"));

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
		return matchFormVO;
	}

	@Override
	public List<MatchFormVO> getAll() {
		List<MatchFormVO> list = new ArrayList<MatchFormVO>();
		MatchFormVO matchFormVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				matchFormVO = new MatchFormVO();
				matchFormVO.setKol_idnum(rs.getInt("kol_idnum"));
				matchFormVO.setProduct_num(rs.getInt("product_num"));
				matchFormVO.setMatch_date_time(rs.getTimestamp("match_date_time"));
				matchFormVO.setMatch_result(rs.getString("match_result"));
				list.add(matchFormVO); // Store the row in the list
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