package com.productType.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.jobType.model.JobTypeVO;

public class ProductTypeDao implements ProductTypeDao_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT = "INSERT INTO `PRODUCT_TYPE` (`PRODUCT_TYPENAME`) VALUES (?);";
	private static final String GET_ALL = "SELECT PRODUCT_TYPENUM, PRODUCT_TYPENAME FROM PRODUCT_TYPE;";
	private static final String GET_ONE = "SELECT PRODUCT_TYPENUM, PRODUCT_TYPENAME FROM PRODUCT_TYPE WHERE PRODUCT_TYPENUM = ? ;";
	private static final String UPDATE = 
			"update `PRODUCT_TYPE` set `PRODUCT_TYPENAME` = ? where PRODUCT_TYPENUM = ?;"; 

	@Override
	public void insert(String product_typename) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1, product_typename);

			pstmt.executeUpdate();
			

			// Handle any SQL errors
		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void update(ProductTypeVO productTypeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, productTypeVO.getProduct_typename());
			pstmt.setInt(2, productTypeVO.getProduct_typenum());

			pstmt.executeUpdate();
			

			// Handle any SQL errors
		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void delete(Integer product_typenum) {
		
	}

	@Override
	public ProductTypeVO findByPrimaryKey(Integer product_typenum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductTypeVO productTypeVO = new ProductTypeVO();
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE);
			pstmt.setInt(1, product_typenum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productTypeVO.setProduct_typenum(rs.getInt("product_typenum"));
				productTypeVO.setProduct_typename(rs.getString("product_typename"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
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
		return productTypeVO;
	}

		
	

	@Override
	public List<ProductTypeVO> getAll() {
		List<ProductTypeVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductTypeVO productTypeVO = new ProductTypeVO();
				productTypeVO.setProduct_typenum(rs.getInt("product_typenum"));
				productTypeVO.setProduct_typename(rs.getString("product_typename"));
				list.add(productTypeVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
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
		return list;
	}

}
