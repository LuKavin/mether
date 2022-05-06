package com.kolfavorite.model;

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

public class KolFavorDAO implements KolFavorDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
				e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = "INSERT INTO `KOL_FAVORITE` (`FAVORTIE_IDNUM`, `COM_IDNUM`, `KOL_IDNUM`)"
			+ "VALUES (?,?,?)";
	private static final String GET_ALL_STMT = "SELECT favorite_idnum, com_idnum, kol_idnum  FROM PRODUCT";
	private static final String GET_ONE_STMT = "SELECT * FROM KOL_FAVORITE where favorite_idnum = ?";
	private static final String DELETE = "DELETE FROM KOL_FAVORITE where favorite_idnum = ?";
	private static final String UPDATE = "UPDATE KOL_FAVORITE SET favorite_idnum = ? where favorite_idnum = ?";
	
//	public static void main(String[] args) {
//		
//		ComFavorDAO test = new ComFavorDAO();
//		
//		test.insert("美妝","2","3");
//	}
//		

	public void insert(KolFavorVO kolFavorVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int favorite_idnum = -1;

		try {
			con = ds.getConnection();
			String columns[] = { "favorite_idnum" };
			pstmt = con.prepareStatement(INSERT_STMT, columns);

			pstmt.setInt(1, kolFavorVO.getFavorite_idnum());
			pstmt.setInt(2, kolFavorVO.getCom_idnum());
			pstmt.setInt(3, kolFavorVO.getKol_idnum());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();// ���@�˥�ResultSet
			if (rs.next()) {
				favorite_idnum = rs.getInt(1);// ���o�۰ʽs���A�H�K����s�W��FK����LTABLE
			}

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

	public void update(KolFavorVO kolFavorVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, kolFavorVO.getFavorite_idnum());
			pstmt.setInt(2, kolFavorVO.getCom_idnum());
			pstmt.setInt(3, kolFavorVO.getKol_idnum());

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

	@Override
	public void delete(Integer Favorite_IdNum) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, Favorite_IdNum);

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public KolFavorVO findByPrimarKey(Integer favorite_idnum) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		KolFavorVO kolFavorVO =null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			
			pstmt = con.prepareStatement(GET_ONE_STMT);
			rs = pstmt.getResultSet();
			pstmt.setInt(1, favorite_idnum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				kolFavorVO = new KolFavorVO();
				kolFavorVO.setFavorite_idnum(kolFavorVO.getFavorite_idnum());
				kolFavorVO.setCom_idnum(kolFavorVO.getCom_idnum());
				kolFavorVO.setKol_idnum(kolFavorVO.getKol_idnum());
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return kolFavorVO;
	}

	@Override
	public List<KolFavorVO> getAll() {
		List<KolFavorVO> list = new ArrayList<KolFavorVO>();
		KolFavorVO kolFavorVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
//				System.out.println("���]��");
				kolFavorVO = new KolFavorVO();
				kolFavorVO.setFavorite_idnum(rs.getInt("favorite_idnum"));
				kolFavorVO.setCom_idnum(rs.getInt("com_idnum"));
				kolFavorVO.setKol_idnum(rs.getInt("kol_idnum"));
				list.add(kolFavorVO);
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
