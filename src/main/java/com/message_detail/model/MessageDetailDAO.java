package com.message_detail.model;

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

import com.product.model.ProductVO;

public class MessageDetailDAO implements MessageDetailDAO_interface {

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

	private static final String COM_INSERT = "INSERT INTO MESSAGE_DETAIL (ORDER_NUM, COM_MESSAGE, MES_PIC, MES_TOPIC) VALUES (?, ?, ?, ?)";
	private static final String KOL_INSERT = "INSERT INTO MESSAGE_DETAIL (ORDER_NUM, KOL_MESSAGE, MES_PIC, MES_TOPIC) VALUES (?, ?, ?, ?)";
	
	private static final String GET_ALL_STMT = "SELECT MES_NUM, ORDER_NUM, COM_MESSAGE, KOL_MESSAGE, MES_TOPIC, MES_DATE_TIME FROM MESSAGE_DETAIL order by MES_NUM";
	private static final String GET_ONE_STMT = "SELECT MES_NUM, ORDER_NUM, COM_MESSAGE, KOL_MESSAGE, MES_TOPIC, MES_DATE_TIME FROM MESSAGE_DETAIL where ORDER_NUM = ?";
	private static final String DELETE = "DELETE FROM ADM_MEB where MES_NUM = ?";

	@Override
	public void comInsert(MessageDetailVO messageDetailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(COM_INSERT);

			pstmt.setInt(1, messageDetailVO.getOrder_num());
			pstmt.setString(2, messageDetailVO.getCom_message());
			pstmt.setBytes(3, messageDetailVO.getMes_pic());
			pstmt.setString(4, messageDetailVO.getMes_topic());
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
	public void delete(Integer mes_num) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(DELETE);
//
//			pstmt.setInt(1, mes_num);
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
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

	}

	@Override
	public List<MessageDetailVO> findByOrderPK(Integer order_num) {

		MessageDetailVO messageDetailVO = null;
		List<MessageDetailVO> list = new ArrayList<>();
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
				messageDetailVO = new MessageDetailVO();
				messageDetailVO.setMes_num(rs.getInt("MES_NUM"));
				messageDetailVO.setOrder_num(rs.getInt("ORDER_NUM"));
				messageDetailVO.setCom_message(rs.getString("COM_MESSAGE"));
				messageDetailVO.setKol_message(rs.getString("KOL_MESSAGE"));
				messageDetailVO.setMes_topic(rs.getString("MES_TOPIC"));
				messageDetailVO.setMes_date_time(rs.getTimestamp("MES_DATE_TIME"));
				list.add(messageDetailVO);
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
	public List<MessageDetailVO> getAll() {
		List<MessageDetailVO> list = new ArrayList<MessageDetailVO>();
		MessageDetailVO messageDetailVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				messageDetailVO = new MessageDetailVO();
				messageDetailVO.setMes_num(rs.getInt("mes_num"));
				messageDetailVO.setOrder_num(rs.getInt("order_num"));
				messageDetailVO.setCom_message(rs.getString("com_message"));
				messageDetailVO.setKol_message(rs.getString("kol_message"));
				messageDetailVO.setMes_topic(rs.getString("mes_topic"));
				messageDetailVO.setMes_date_time(rs.getTimestamp("mes_date_time"));
				list.add(messageDetailVO); // Store the row in the list
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
	public void kolInsert(MessageDetailVO messageDetailVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(KOL_INSERT);

			pstmt.setInt(1, messageDetailVO.getOrder_num());
			pstmt.setString(2, messageDetailVO.getKol_message());
			pstmt.setBytes(3, messageDetailVO.getMes_pic());
			pstmt.setString(4, messageDetailVO.getMes_topic());
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
}