package com.kol_skilltype_config.model;

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

public class KolSkilltypeConfigDAO implements KolSkilltypeConfigDAO_interface {

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

	private static final String INSERT_STMT = "INSERT INTO KOL_SKILLTYPE_CONFIG (KOL_IDNUM, SKILL_TYPENUM) VALUES (?, ?)";
	private static final String GET_ALL_STMT = "SELECT KOL_IDNUM, SKILL_TYPENUM FROM KOL_SKILLTYPE_CONFIG order by KOL_IDNUM, SKILL_TYPENUM";
	private static final String GET_ONE_STMT = "SELECT KOL_IDNUM, SKILL_TYPENUM FROM KOL_SKILLTYPE_CONFIG where KOL_IDNUM = ? and SKILL_TYPENUM = ?";
	private static final String DELETE = "DELETE FROM KOL_SKILLTYPE_CONFIG where KOL_IDNUM = ? and SKILL_TYPENUM = ?";

	@Override
	public void insert(KolSkilltypeConfigVO kolSkilltypeConfigVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, kolSkilltypeConfigVO.getKol_idnum());
			pstmt.setInt(2, kolSkilltypeConfigVO.getSkill_typenum());

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
	public void delete(Integer kol_idnum, Integer skill_typenum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, kol_idnum);
			pstmt.setInt(2, skill_typenum);

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
	public KolSkilltypeConfigVO findByPrimaryKey(Integer kol_idnum, Integer skill_typenum) {

		KolSkilltypeConfigVO kolSkilltypeConfigVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, kol_idnum);
			pstmt.setInt(2, skill_typenum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects

				kolSkilltypeConfigVO = new KolSkilltypeConfigVO();
				kolSkilltypeConfigVO.setKol_idnum(rs.getInt("kol_idnum"));
				kolSkilltypeConfigVO.setSkill_typenum(rs.getInt("skill_typenum"));

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
		return kolSkilltypeConfigVO;
	}

	@Override
	public List<KolSkilltypeConfigVO> getAll() {
		List<KolSkilltypeConfigVO> list = new ArrayList<KolSkilltypeConfigVO>();
		KolSkilltypeConfigVO kolSkilltypeConfigVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				kolSkilltypeConfigVO = new KolSkilltypeConfigVO();
				kolSkilltypeConfigVO.setKol_idnum(rs.getInt("kol_idnum"));
				kolSkilltypeConfigVO.setSkill_typenum(rs.getInt("skill_typenum"));

				list.add(kolSkilltypeConfigVO); // Store the row in the list
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