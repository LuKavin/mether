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
	
	private static final String INSERT = "INSERT INTO PRODUCT_PHOTO (PRODUCT_NUM, PRODUCT_PHOTO1, PRODUCT_PHOTO2, PRODUCT_PHOTO3, PRODUCT_PHOTO4, PRODUCT_PHOTO5) value (?,?,?,?,?,?);";
	
	private static final String UPDATE_COL_1 = "UPDATE PRODUCT_PHOTO SET PRODUCT_PHOTO1 = ? WHERE PRODUCT_NUM = ?;";
	private static final String UPDATE_COL_2 = "UPDATE PRODUCT_PHOTO SET PRODUCT_PHOTO2 = ? WHERE PRODUCT_NUM = ?;";
	private static final String UPDATE_COL_3 = "UPDATE PRODUCT_PHOTO SET PRODUCT_PHOTO3 = ? WHERE PRODUCT_NUM = ?;";
	private static final String UPDATE_COL_4 = "UPDATE PRODUCT_PHOTO SET PRODUCT_PHOTO4 = ? WHERE PRODUCT_NUM = ?;";
	private static final String UPDATE_COL_5 = "UPDATE PRODUCT_PHOTO SET PRODUCT_PHOTO5 = ? WHERE PRODUCT_NUM = ?;";
	
	private static final String DELETE =  "DELETE FROM PRODUCT_PHOTO WHERE PRODUCT_PHOTONUM = ?;";
	private static final String GET_ONE = "SELECT PRODUCT_PHOTONUM, PRODUCT_PHOTO, PRODUCT_NUM FROM PRODUCT_PHOTO WHERE PRODUCT_PHOTONUM = ?";
	private static final String GET_ALL = "SELECT PRODUCT_PHOTONUM, PRODUCT_PHOTO, PRODUCT_NUM FROM PRODUCT_PHOTO WHERE PRODUCT_NUM = ?;";
	private static final String GET_ALL_FOR_PRO = "SELECT * FROM PRODUCT_PHOTO where PRODUCT_NUM = ?";
	@Override
	public void insert(Integer product_num, byte[] product_photo1, byte[] product_photo2, byte[] product_photo3, byte[] product_photo4, byte[] product_photo5) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, product_num);
			pstmt.setBytes(2, product_photo1);
			pstmt.setBytes(3, product_photo2);
			pstmt.setBytes(4, product_photo3);
			pstmt.setBytes(5, product_photo4);
			pstmt.setBytes(6, product_photo5);
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
				productPhotoVO.setProduct_photo1(rs.getBytes("PRODUCT_PHOTO1"));
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
	public List<ProductPhotoVO> getAll(Integer product_num) {
		List<ProductPhotoVO> list = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(GET_ALL);
//			pstmt.setInt(1, product_num);
//			pstmt.executeUpdate();
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				ProductPhotoVO productPhotoVO = new ProductPhotoVO();
//				productPhotoVO.setProduct_photonum(rs.getInt("PRODUCT_PHOTONUM"));
//				productPhotoVO.setProduct_photo(rs.getBytes("PRODUCT_PHOTO"));
//				productPhotoVO.setProduct_num(rs.getInt("PRODUCT_NUM"));
//				list.add(productPhotoVO);
//			}
//			
//
//		}catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
		
		return list;
	}

	@Override
	public List<ProductPhotoVO> getOneProductAll(Integer product_num) {//找某商品全部的圖片
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductPhotoVO> list = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_FOR_PRO);
			pstmt.setInt(1, product_num);
			pstmt.executeUpdate();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductPhotoVO productPhotoVO = new ProductPhotoVO();
				productPhotoVO.setProduct_photonum(rs.getInt("PRODUCT_PHOTONUM"));
				productPhotoVO.setProduct_photo1(rs.getBytes("PRODUCT_PHOTO1"));
				productPhotoVO.setProduct_photo2(rs.getBytes("PRODUCT_PHOTO2"));
				productPhotoVO.setProduct_photo3(rs.getBytes("PRODUCT_PHOTO3"));
				productPhotoVO.setProduct_photo4(rs.getBytes("PRODUCT_PHOTO4"));
				productPhotoVO.setProduct_photo5(rs.getBytes("PRODUCT_PHOTO5"));
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

	@Override
	public void updateOnePhoto(Integer productNum,byte[] photo, Integer whitchCol) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			switch (whitchCol) {
			case 1:
				pstmt = con.prepareStatement(UPDATE_COL_1);
				break;
			case 2:
				pstmt = con.prepareStatement(UPDATE_COL_2);
				break;
			case 3:
				pstmt = con.prepareStatement(UPDATE_COL_3);
				break;
			case 4:
				pstmt = con.prepareStatement(UPDATE_COL_4);
				break;
			case 5:
				pstmt = con.prepareStatement(UPDATE_COL_5);
			}
			pstmt.setBytes(1, photo);
			pstmt.setInt(2, productNum);
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

	
}
