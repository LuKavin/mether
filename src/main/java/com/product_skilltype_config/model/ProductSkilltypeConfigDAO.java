package com.product_skilltype_config.model;

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

public class ProductSkilltypeConfigDAO implements ProductSkilltypeConfigDAO_interface {

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

	private static final String INSERT_STMT = "INSERT INTO PRODUCT_SKILLTYPE_CONFIG (PRODUCT_NUM, SKILL_TYPENUM) VALUES (?, ?)";
	private static final String GET_ALL_STMT = "SELECT PRODUCT_NUM, SKILL_TYPENUM FROM PRODUCT_SKILLTYPE_CONFIG order by PRODUCT_NUM, SKILL_TYPENUM";
	private static final String GET_ONE_STMT = "SELECT PRODUCT_NUM, SKILL_TYPENUM FROM PRODUCT_SKILLTYPE_CONFIG where PRODUCT_NUM = ? and SKILL_TYPENUM = ?";
	private static final String DELETE = "DELETE FROM PRODUCT_SKILLTYPE_CONFIG where PRODUCT_NUM = ? and SKILL_TYPENUM = ?";

	@Override
	public void insert(ProductSkilltypeConfigVO productSkilltypeConfigVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productSkilltypeConfigVO.getProduct_num());
			pstmt.setInt(2, productSkilltypeConfigVO.getSkill_typenum());

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
	public void delete(Integer product_num, Integer skill_typenum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, product_num);
			pstmt.setInt(2, skill_typenum);

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
	public ProductSkilltypeConfigVO findByPrimaryKey(Integer product_num, Integer skill_typenum) {

		ProductSkilltypeConfigVO productSkilltypeConfigVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, product_num);
			pstmt.setInt(2, skill_typenum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects

				productSkilltypeConfigVO = new ProductSkilltypeConfigVO();
				productSkilltypeConfigVO.setProduct_num(rs.getInt("product_num"));
				productSkilltypeConfigVO.setSkill_typenum(rs.getInt("skill_typenum"));

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
		return productSkilltypeConfigVO;
	}

	@Override
	public List<ProductSkilltypeConfigVO> getAll() {
		List<ProductSkilltypeConfigVO> list = new ArrayList<ProductSkilltypeConfigVO>();
		ProductSkilltypeConfigVO productSkilltypeConfigVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				productSkilltypeConfigVO = new ProductSkilltypeConfigVO();
				productSkilltypeConfigVO.setProduct_num(rs.getInt("product_num"));
				productSkilltypeConfigVO.setSkill_typenum(rs.getInt("skill_typenum"));

				list.add(productSkilltypeConfigVO); // Store the row in the list
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