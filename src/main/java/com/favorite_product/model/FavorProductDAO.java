package com.favorite_product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.xdevapi.Result;

public class FavorProductDAO implements FavorProductDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO FAVORITE_PRODUCT (FAV_PRODUCTNUM, KOL_IDNUM, PRODUCT_NUM) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT FAV_PRODUCTNUM,KOL_IDNUM,PRODUCT_NUM FROM FAVORITE_PRODUCT order by FAV_PRODUCTNUM";
	private static final String GET_ONE_STMT = "SELECT FAV_PRODUCTNUM,KOL_IDNUM,PRODUCT_NUM FROM FAVORITE_PRODUCT where FAV_PRODUCTNUM = ?";
	private static final String UPDATE = "UPDATE FAVORITE_PRODUCT set FAV_PRODUCTNUM=?, KOL_IDNUM=?, PRODUCT_NUM=? where FAV_PRODUCTNUM = ?";
	private static final String DELETE = "DELETE FROM FAVORITE_PRODUCT where FAV_PRODUCTNUM = ?";

	public void insert(FavorProductVO favorProductVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, favorProductVo.getFav_productnum());
			pstmt.setInt(2, favorProductVo.getKol_idnum());
			pstmt.setInt(3, favorProductVo.getProduct_num());

			pstmt.executeUpdate();

			// catch driver errors
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

	public void update(FavorProductVO favorProductVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, favorProductVO.getFav_productnum());
			pstmt.setInt(2, favorProductVO.getKol_idnum());
			pstmt.setInt(3, favorProductVO.getProduct_num());

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

	public void delete(Integer fav_productnum) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, fav_productnum);

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

	public FavorProductVO findByPrimaryKey(Integer fav_productnum) {

		FavorProductVO favorProductVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, fav_productnum);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				favorProductVO = new FavorProductVO();
				favorProductVO.setFav_productnum(rs.getInt("fav_productnum"));
				favorProductVO.setKol_idnum(rs.getInt("kol_idnum"));
				favorProductVO.setProduct_num(rs.getInt("product_num"));

			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return favorProductVO;
	}

	public List<FavorProductVO> getAll() {

		List<FavorProductVO> list = new ArrayList<FavorProductVO>();
		FavorProductVO favorProductVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				favorProductVO = new FavorProductVO();
				favorProductVO.setFav_productnum(rs.getInt("fav_productnum"));
				favorProductVO.setKol_idnum(rs.getInt("kol_idnum"));
				favorProductVO.setProduct_num(rs.getInt("product_num"));
				list.add(favorProductVO);

			}
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
		return null;
	}
}
