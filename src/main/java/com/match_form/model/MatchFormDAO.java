package com.match_form.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.product.model.ProductVO;

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


	private static final String INSERT_STMT = "INSERT INTO MATCH_FORM (KOL_IDNUM, PRODUCT_NUM) VALUES (?, ?);";
	private static final String GET_ALL_STMT = "select p.PRODUCT_NUM, p.PRODUCT_INTRODUCE, p.PRODUCT_NAME, p.PRODUCT_LINK  from MATCH_FORM m\n"
			+ "			join PRODUCT p on m.PRODUCT_NUM  = p.PRODUCT_NUM ;";
	private static final String GET_ONE_STMT = "select p.PRODUCT_NUM, p.PRODUCT_INTRODUCE, p.PRODUCT_NAME, p.PRODUCT_BUDGET, m.KOL_IDNUM  from MATCH_FORM m"
			+ " join PRODUCT p on m.PRODUCT_NUM  = p.PRODUCT_NUM "
			+ " where COM_IDNUM = ? ;";
	private static final String DELETE = "Delete from MATCH_FORM where KOL_IDNUM = ? and PRODUCT_NUM = ?;";
	private static final String UPDATE = "UPDATE MATCH_FORM set MATCH_RESULT=? where KOL_IDNUM = ? and PRODUCT_NUM = ?";

	@Override

	public void insert(Integer kol_idnum, Integer product_num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, kol_idnum);
			pstmt.setInt(2, product_num);
			
			
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
	
	
//		while (rs.next()) {
//			Integer order_num = rs.getInt("order_num");
//			String product_name = rs.getString("product_name");
//			Date product_deadline = rs.getDate("product_deadline");
//			String order_status = rs.getString("order_status");
//			Timestamp order_date = rs.getTimestamp("order_date");
//
//			Map map = new HashMap();
//			map.put("order_num", order_num);
//			map.put("product_name", product_name);
//			map.put("product_deadline", product_deadline);
//			map.put("order_status", order_status);
//			map.put("order_date", order_date);
//
//			list.add(map);// 在將map集合對象存入list集合
//		}
//		// Handle any driver errors
//	} catch (SQLException se) {
//		throw new RuntimeException("A database error occured. " + se.getMessage());
//		// Clean up JDBC resources
//	} finally {
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException se) {
//				se.printStackTrace(System.err);
//			}
//		}
//		if (pstmt != null) {
//			try {
//				pstmt.close();
//			} catch (SQLException se) {
//				se.printStackTrace(System.err);
//			}
//		}
//		if (con != null) {
//			try {
//				con.close();
//			} catch (Exception e) {
//				e.printStackTrace(System.err);
//			}
//		}
//	}
//	return list;
//}

	@Override
	public List findByPrimaryKey(Integer com_idnum) {

		List list = new ArrayList();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, com_idnum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				Integer product_num	= rs.getInt("product_num");
				String product_introduce = rs.getString("product_introduce");
				String product_name = rs.getString("product_name");
				Integer product_budget	= rs.getInt("product_budget");
				Integer kol_idnum = rs.getInt("kol_idnum");
				
				Map map = new HashMap();
				map.put("product_num", product_num);
				map.put("product_introduce", product_introduce);
				map.put("product_name", product_name);
				map.put("product_budget", product_budget);
				map.put("kol_idnum", kol_idnum);
				
				list.add(map);

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
	public List<ProductVO> getAll() {
		
		List<ProductVO> list = new ArrayList<>();
		MatchFormVO matchFormVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				ProductVO productVO = new ProductVO();
				
				productVO.setProduct_num(rs.getInt("product_num"));
				productVO.setProduct_introduce(rs.getString("product_introduce"));
				productVO.setProduct_name(rs.getString("product_name"));
				productVO.setProduct_link(rs.getString("product_link"));
				
				list.add(productVO);

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



