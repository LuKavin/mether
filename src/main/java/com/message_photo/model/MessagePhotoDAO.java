package com.message_photo.model;

import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MessagePhotoDAO implements MessagePhotoDAO_interface {

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

	private static final String INSERT_STMT = "INSERT INTO MESSAGE_PHOTO (MES_NUM, COM_PHOTO, KOL_PHOTO) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT MES_PHOTONUM, MES_NUM, COM_PHOTO, KOL_PHOTO FROM MESSAGE_PHOTO order by MES_PHOTONUM";
	private static final String GET_ONE_STMT = "SELECT MES_PHOTONUM, MES_NUM, COM_PHOTO, KOL_PHOTO FROM MESSAGE_PHOTO where MES_PHOTONUM = ?";
	private static final String DELETE = "DELETE FROM MESSAGE_PHOTO where MES_PHOTONUM = ?";

	@Override
	public void insert(MessagePhotoVO messagePhotoVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, messagePhotoVO.getMes_num());
			pstmt.setBytes(2, messagePhotoVO.getCom_photo());
			pstmt.setBytes(3, messagePhotoVO.getKol_photo());
			
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
	public void delete(Integer mes_photonum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mes_photonum);

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
	public MessagePhotoVO findByPrimaryKey(Integer mes_photonum) {

		MessagePhotoVO messagePhotoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mes_photonum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects

				messagePhotoVO = new MessagePhotoVO();
				messagePhotoVO.setMes_photonum(rs.getInt("mes_photonum"));
				messagePhotoVO.setMes_num(rs.getInt("mes_num"));
				messagePhotoVO.setCom_photo(rs.getBytes("com_photo"));
				messagePhotoVO.setKol_photo(rs.getBytes("kol_photo"));
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
		return messagePhotoVO;
	}

	@Override
	public List<MessagePhotoVO> getAll() {
		List<MessagePhotoVO> list = new ArrayList<MessagePhotoVO>();
		MessagePhotoVO messagePhotoVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				messagePhotoVO = new MessagePhotoVO();
				messagePhotoVO.setMes_photonum(rs.getInt("mes_photonum"));
				messagePhotoVO.setMes_num(rs.getInt("mes_num"));
				messagePhotoVO.setCom_photo(rs.getBytes("com_photo"));
				messagePhotoVO.setKol_photo(rs.getBytes("kol_photo"));
				list.add(messagePhotoVO); // Store the row in the list
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