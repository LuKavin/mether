package com.companyfavorite.model;

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

public class ComFavorDAO implements ComFavorDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/dbmether?serverTimezone=Asia/Taipei";
//	String userid = "root";
//	String passwd = "2xlxdddu";

	private static final String INSERT_STMT = "INSERT INTO `COMPANY_FAVORITE` (`FAVORTIE_IDNUM`, `COM_IDNUM`, `KOL_IDNUM`)"
			+ "VALUES (?,?,?)";
	private static final String GET_ALL_STMT = "SELECT favorite_idnum, com_idnum, kol_idnum  FROM PRODUCT";
	private static final String GET_ONE_STMT = "SELECT * FROM COMPANY_FAVORITE where favorite_idnum = ?";
	private static final String DELETE = "DELETE FROM COMPANY_FAVORITE where favorite_idnum = ?";
	private static final String UPDATE = "UPDATE COMPANY_FAVORITE SET favorite_idnum = ? where favorite_idnum = ?";
	
//	public static void main(String[] args) {
//		
//		ComFavorDAO test = new ComFavorDAO();
//		
//		test.insert("美妝","2","3");
//	}
//		

	public void insert(ComFavorVO comFavorVo) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int favorite_idnum = -1;

		try {
			con = ds.getConnection();
			String columns[] = { "favorite_idnum" };
			pstmt = con.prepareStatement(INSERT_STMT, columns);

			pstmt.setInt(1, comFavorVo.getFavorite_idnum());
			pstmt.setInt(2, comFavorVo.getCom_idnum());
			pstmt.setInt(3, comFavorVo.getKol_idnum());

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

	public void update(ComFavorVO comFavorVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, comFavorVO.getFavorite_idnum());
			pstmt.setInt(2, comFavorVO.getCom_idnum());
			pstmt.setInt(3, comFavorVO.getKol_idnum());

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
	public void delete(Integer favorite_idnum) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, favorite_idnum);

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
	public ComFavorVO findByPrimarKey(Integer favorite_idnum) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ComFavorVO comFavorVO =null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			
			pstmt = con.prepareStatement(GET_ONE_STMT);
			rs = pstmt.getResultSet();
			pstmt.setInt(1, favorite_idnum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				comFavorVO = new ComFavorVO();
				comFavorVO.setFavorite_idnum(comFavorVO.getFavorite_idnum());
				comFavorVO.setCom_idnum(comFavorVO.getCom_idnum());
				comFavorVO.setKol_idnum(comFavorVO.getKol_idnum());
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
		return comFavorVO;
	}

	@Override
	public List<ComFavorVO> getAll() {
		List<ComFavorVO> list = new ArrayList<ComFavorVO>();
		ComFavorVO comFavorVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
//				System.out.println("���]��");
				comFavorVO = new ComFavorVO();
				comFavorVO.setFavorite_idnum(rs.getInt("favorite_idnum"));
				comFavorVO.setCom_idnum(rs.getInt("com_idnum"));
				comFavorVO.setKol_idnum(rs.getInt("kol_idnum"));
				list.add(comFavorVO);
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
