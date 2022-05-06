package com.productPhoto.model;

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


//
//
//此Dao尚未做任何測試
//
//

public class ProductPhotoDao implements ProductPhotoDao_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT = "INSERT INTO PRODUCT_PHOTO (PRODUCT_PHOTO) value (?);";
	private static final String DELETE =  "DELETE FROM PRODUCT_PHOTO WHERE PRODUCT_PHOTONUM = ?;";
	private static final String GET_ONE = "SELECT PRODUCT_PHOTONUM, PRODUCT_PHOTO, PRODUCT_NUM FROM PRODUCT_PHOTO WHERE PRODUCT_PHOTONUM = ?";
	private static final String GET_ALL_FORMEM = "SELECT PRODUCT_PHOTONUM, PRODUCT_PHOTO, PRODUCT_NUM FROM PRODUCT_PHOTO WHERE PRODUCT_NUM = ?;";
	@Override
	public void insert(ProductPhotoVO productPhotoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			pstmt.setBytes(1, productPhotoVO.getProduct_photo());

			pstmt.executeUpdate();
			

		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void delete(Integer product_photonum) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, product_photonum);

			pstmt.executeUpdate();
			

		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public ProductPhotoVO findByPrimaryKey(Integer product_photonum) {//根據圖片流水號找一張圖
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductPhotoVO productPhotoVO = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE);
			pstmt.setInt(1, product_photonum);
			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productPhotoVO = new ProductPhotoVO();
				productPhotoVO.setProduct_photonum(rs.getInt("PRODUCT_PHOTONUM"));
				productPhotoVO.setProduct_photo(rs.getBytes("PRODUCT_PHOTO"));
				productPhotoVO.setProduct_num(rs.getInt("PRODUCT_NUM"));
			}
			

		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		
		return productPhotoVO;
	}
	@Override
	public List<ProductPhotoVO> getAll(Integer product_num) {//找某商品全部的圖片
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductPhotoVO> list = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_FORMEM);
			pstmt.setInt(1, product_num);
			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductPhotoVO productPhotoVO = new ProductPhotoVO();
				productPhotoVO.setProduct_photonum(rs.getInt("PRODUCT_PHOTONUM"));
				productPhotoVO.setProduct_photo(rs.getBytes("PRODUCT_PHOTO"));
				productPhotoVO.setProduct_num(rs.getInt("PRODUCT_NUM"));
				list.add(productPhotoVO);
			}
			

		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		
		return list;
	} 

	
}
