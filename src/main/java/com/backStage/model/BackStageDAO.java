package com.backStage.model;

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

public class BackStageDAO implements BackStageDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String GET_COMPANYMEB_COUNT = "SELECT COUNT(*) FROM COMPANY_MEB where MEB_ACCESSNUM = 1";
	private static final String GET_KOLMEB_COUNT = "SELECT COUNT(*) FROM KOL_MEB where MEB_ACCESSNUM = 2";
	private static final String GET_ORDERMASTER_COUNT = "SELECT COUNT(*) FROM ORDER_MASTER where ORDER_STATUS != \"已完成\"";
	private static final String GET_ORDERMASTER_NEW = "SELECT o.ORDER_NUM, p.PRODUCT_NAME, p.PRODUCT_DEADLINE, o.ORDER_DATE, o.ORDER_STATUS FROM ORDER_MASTER o join PRODUCT p on o.PRODUCT_NUM = p.PRODUCT_NUM order by o.ORDER_NUM desc LIMIT 6";

	// 廠商數量
	public Integer companyMebcount() {
		Integer count = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_COMPANYMEB_COUNT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}

	// 網紅數量
	public Integer kolMebcount() {
		Integer count = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_KOLMEB_COUNT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}

	// 訂單數量
	public Integer orderMastercount() {
		Integer count = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ORDERMASTER_COUNT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}

	// 最新訂單
	public List getNew() {
		List list = new ArrayList();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ORDERMASTER_NEW);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Integer order_num = rs.getInt("order_num");
				String product_name = rs.getString("product_name");
				Date product_deadline = rs.getDate("product_deadline");
				String order_status = rs.getString("order_status");
				Timestamp order_date = rs.getTimestamp("order_date");

				Map map = new HashMap();
				map.put("order_num", order_num);
				map.put("product_name", product_name);
				map.put("product_deadline", product_deadline);
				map.put("order_status", order_status);
				map.put("order_date", order_date);

				list.add(map);// 在將map集合對象存入list集合
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