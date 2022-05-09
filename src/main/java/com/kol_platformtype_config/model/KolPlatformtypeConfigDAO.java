package com.kol_platformtype_config.model;

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

public class KolPlatformtypeConfigDAO implements KolPlatformtypeConfigDAO_interface {

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

	private static final String INSERT_STMT = "INSERT INTO KOL_PLATFORMTYPE_CONFIG (KOL_IDNUM, PLATFORM_TYPENUM) VALUES (?, ?)";
	private static final String GET_ALL_STMT = "SELECT KOL_IDNUM, PLATFORM_TYPENUM FROM KOL_PLATFORMTYPE_CONFIG order by KOL_IDNUM, PLATFORM_TYPENUM";
	private static final String GET_ONE_STMT = "SELECT KOL_IDNUM, PLATFORM_TYPENUM FROM KOL_PLATFORMTYPE_CONFIG where KOL_IDNUM = ? and PLATFORM_TYPENUM = ?";
	private static final String DELETE = "DELETE FROM KOL_PLATFORMTYPE_CONFIG where KOL_IDNUM = ? and PLATFORM_TYPENUM = ?";

	@Override
	public void insert(KolPlatformtypeConfigVO kolPlatformtypeConfigVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, kolPlatformtypeConfigVO.getKol_idnum());
			pstmt.setInt(2, kolPlatformtypeConfigVO.getPlatform_typenum());

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
	public void delete(Integer kol_idnum, Integer platform_typenum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, kol_idnum);
			pstmt.setInt(2, platform_typenum);

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
	public KolPlatformtypeConfigVO findByPrimaryKey(Integer kol_idnum, Integer platform_typenum) {

		KolPlatformtypeConfigVO kolPlatformtypeConfigVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, kol_idnum);
			pstmt.setInt(2, platform_typenum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects

				kolPlatformtypeConfigVO = new KolPlatformtypeConfigVO();
				kolPlatformtypeConfigVO.setKol_idnum(rs.getInt("kol_idnum"));
				kolPlatformtypeConfigVO.setPlatform_typenum(rs.getInt("platform_typenum"));

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
		return kolPlatformtypeConfigVO;
	}

	@Override
	public List<KolPlatformtypeConfigVO> getAll() {
		List<KolPlatformtypeConfigVO> list = new ArrayList<KolPlatformtypeConfigVO>();
		KolPlatformtypeConfigVO kolPlatformtypeConfigVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				kolPlatformtypeConfigVO = new KolPlatformtypeConfigVO();
				kolPlatformtypeConfigVO.setKol_idnum(rs.getInt("kol_idnum"));
				kolPlatformtypeConfigVO.setPlatform_typenum(rs.getInt("platform_typenum"));
				list.add(kolPlatformtypeConfigVO); // Store the row in the list
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