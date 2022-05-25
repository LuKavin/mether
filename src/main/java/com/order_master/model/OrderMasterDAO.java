package com.order_master.model;

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

public class OrderMasterDAO implements OrderMasterDAO_interface {

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

	private static final String INSERT_STMT = "INSERT INTO ORDER_MASTER (PRODUCT_NUM, KOL_IDNUM, COM_IDNUM, ORDER_STATUS, ORDER_AMOUNT) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT ORDER_NUM, PRODUCT_NUM, KOL_IDNUM, COM_IDNUM, ORDER_STATUS, ORDER_DATE, ORDER_AMOUNT, COM_RATE, KOL_RATE, COM_STAR, KOL_STAR FROM ORDER_MASTER order by ORDER_NUM";
	
	private static final String GET_COM_ORDER_LIST = "SELECT ORDER_NUM, PRODUCT_NUM, KOL_IDNUM, COM_IDNUM, ORDER_STATUS, ORDER_DATE, ORDER_AMOUNT, COM_RATE, KOL_RATE, COM_STAR, KOL_STAR FROM ORDER_MASTER where COM_IDNUM = ?";
	private static final String GET_KOL_ORDER_LIST = "SELECT ORDER_NUM, PRODUCT_NUM, KOL_IDNUM, COM_IDNUM, ORDER_STATUS, ORDER_DATE, ORDER_AMOUNT, COM_RATE, KOL_RATE, COM_STAR, KOL_STAR FROM ORDER_MASTER where KOL_IDNUM = ?";
	
	private static final String GET_KOL_ACCOUNT = "SELECT k.KOL_ACCOUNT FROM KOL_MEB k join ORDER_MASTER o on (k.KOL_IDNUM = o.KOL_IDNUM) and o.ORDER_NUM = ?";
	private static final String GET_COM_ACCOUNT = "SELECT c.COM_ACCOUNT FROM COMPANY_MEB c join ORDER_MASTER o on (c.COM_IDNUM = o.COM_IDNUM) and o.ORDER_NUM = ?";
	
	private static final String GET_ONE_STMT = "SELECT ORDER_NUM, PRODUCT_NUM, KOL_IDNUM, COM_IDNUM, ORDER_STATUS, ORDER_DATE, ORDER_AMOUNT, COM_RATE, KOL_RATE, COM_STAR, KOL_STAR, ORDER_LINK, ORDER_CONTENT, ORDER_PIC FROM ORDER_MASTER where ORDER_NUM = ?";
	private static final String DELETE = "DELETE FROM ORDER_MASTER where ORDER_NUM = ?";
	private static final String UPDATE = "UPDATE ORDER_MASTER set ORDER_STATUS=?, COM_RATE=?, KOL_RATE=?, COM_STAR=?, KOL_STAR=?, ORDER_LINK=?, ORDER_CONTENT=?, ORDER_PIC=? where ORDER_NUM = ?";

	@Override
	public void insert(OrderMasterVO orderMasterVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, orderMasterVO.getProduct_num());
			pstmt.setInt(2, orderMasterVO.getKol_idnum());
			pstmt.setInt(3, orderMasterVO.getCom_idnum());
			pstmt.setString(4, orderMasterVO.getOrder_status());
			pstmt.setInt(5, orderMasterVO.getOrder_amount());

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
	public void update(OrderMasterVO orderMasterVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, orderMasterVO.getOrder_status());
			pstmt.setString(2, orderMasterVO.getCom_rate());
			pstmt.setString(3, orderMasterVO.getKol_rate());
			pstmt.setInt(4, orderMasterVO.getCom_star());
			pstmt.setInt(5, orderMasterVO.getKol_star());
			pstmt.setString(6, orderMasterVO.getOrder_link());
			pstmt.setString(7, orderMasterVO.getOrder_content());
			pstmt.setBytes(8, orderMasterVO.getOrder_pic());
			pstmt.setInt(9, orderMasterVO.getOrder_num());

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
	public void delete(Integer order_num) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, order_num);

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
	public OrderMasterVO findByPrimaryKey(Integer order_num) {

		OrderMasterVO orderMasterVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, order_num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects

				orderMasterVO = new OrderMasterVO();
				orderMasterVO.setOrder_num(rs.getInt("order_num"));
				orderMasterVO.setProduct_num(rs.getInt("product_num"));
				orderMasterVO.setKol_idnum(rs.getInt("kol_idnum"));
				orderMasterVO.setCom_idnum(rs.getInt("com_idnum"));
				orderMasterVO.setOrder_status(rs.getString("order_status"));
				orderMasterVO.setOrder_date(rs.getTimestamp("order_date"));
				orderMasterVO.setOrder_amount(rs.getInt("order_amount"));
				orderMasterVO.setCom_rate(rs.getString("com_rate"));
				orderMasterVO.setKol_rate(rs.getString("kol_rate"));
				orderMasterVO.setCom_star(rs.getInt("com_star"));
				orderMasterVO.setKol_star(rs.getInt("kol_star"));
				orderMasterVO.setOrder_link(rs.getString("order_link"));
				orderMasterVO.setOrder_content(rs.getString("order_content"));
				orderMasterVO.setOrder_pic(rs.getBytes("order_pic"));

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
		return orderMasterVO;
	}

	@Override
	public List<OrderMasterVO> getAll() {
		List<OrderMasterVO> list = new ArrayList<OrderMasterVO>();
		OrderMasterVO orderMasterVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				orderMasterVO = new OrderMasterVO();
				orderMasterVO.setOrder_num(rs.getInt("order_num"));
				orderMasterVO.setProduct_num(rs.getInt("product_num"));
				orderMasterVO.setKol_idnum(rs.getInt("kol_idnum"));
				orderMasterVO.setCom_idnum(rs.getInt("com_idnum"));
				orderMasterVO.setOrder_status(rs.getString("order_status"));
				orderMasterVO.setOrder_date(rs.getTimestamp("order_date"));
				orderMasterVO.setOrder_amount(rs.getInt("order_amount"));
				orderMasterVO.setCom_rate(rs.getString("com_rate"));
				orderMasterVO.setKol_rate(rs.getString("kol_rate"));
				orderMasterVO.setCom_star(rs.getInt("com_star"));
				orderMasterVO.setKol_star(rs.getInt("kol_star"));
				list.add(orderMasterVO); // Store the row in the list
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
	public List<OrderMasterVO> getMebAll(Integer mem_idnum, Integer mem_access) {
		List<OrderMasterVO> list = new ArrayList<OrderMasterVO>();
		OrderMasterVO orderMasterVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			switch (mem_access) {
			case 1:
				pstmt = con.prepareStatement(GET_COM_ORDER_LIST);
				break;
			case 2:
				pstmt = con.prepareStatement(GET_KOL_ORDER_LIST);
				break;
			}
			pstmt.setInt(1, mem_idnum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderMasterVO = new OrderMasterVO();
				orderMasterVO.setOrder_num(rs.getInt("order_num"));
				orderMasterVO.setProduct_num(rs.getInt("product_num"));
				orderMasterVO.setKol_idnum(rs.getInt("kol_idnum"));
				orderMasterVO.setCom_idnum(rs.getInt("com_idnum"));
				orderMasterVO.setOrder_status(rs.getString("order_status"));
				orderMasterVO.setOrder_date(rs.getTimestamp("order_date"));
				orderMasterVO.setOrder_amount(rs.getInt("order_amount"));
				orderMasterVO.setCom_rate(rs.getString("com_rate"));
				orderMasterVO.setKol_rate(rs.getString("kol_rate"));
				orderMasterVO.setCom_star(rs.getInt("com_star"));
				orderMasterVO.setKol_star(rs.getInt("kol_star"));
				list.add(orderMasterVO); // Store the row in the list
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
	public String findComAccount(Integer order_num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String com_account = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_COM_ACCOUNT);
			pstmt.setInt(1, order_num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				com_account = rs.getString(1);

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
		return com_account;
	}
	
	@Override
	public String findKolAccount(Integer order_num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String kol_account = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_KOL_ACCOUNT);
			pstmt.setInt(1, order_num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				kol_account = rs.getString(1);

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
		return kol_account;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}