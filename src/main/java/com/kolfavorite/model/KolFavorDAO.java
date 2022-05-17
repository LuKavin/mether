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

<<<<<<< HEAD
=======
import com.companymeb.model.CompanyMebVO;

>>>>>>> alanyu
public class KolFavorDAO implements KolFavorDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
<<<<<<< HEAD
				e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = "INSERT INTO `KOL_FAVORITE` (`FAVORTIE_IDNUM`, `COM_IDNUM`, `KOL_IDNUM`)"
			+ "VALUES (?,?,?)";
	private static final String GET_ALL_STMT = "SELECT favorite_idnum, com_idnum, kol_idnum  FROM PRODUCT";
	private static final String GET_ONE_STMT = "SELECT * FROM KOL_FAVORITE where favorite_idnum = ?";
	private static final String DELETE = "DELETE FROM KOL_FAVORITE where favorite_idnum = ?";
	private static final String UPDATE = "UPDATE KOL_FAVORITE SET favorite_idnum = ? where favorite_idnum = ?";
	
=======
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO `KOL_FAVORITE` (`COM_IDNUM`, `KOL_IDNUM`)" + "VALUES (?,?)";
	private static final String GET_ALL_STMT = "SELECT COM_IDNUM, COM_NAME, COM_EMAIL, COM_PHONE,  COM_WEBSITE "
			+ "FROM COMPANY_MEB ;";
	private static final String GET_ONE_STMT = "SELECT k.COM_IDNUM, c.COM_NAME, c.COM_EMAIL, c.COM_PHONE,  c.COM_WEBSITE \n"
			+ "FROM COMPANY_MEB c JOIN KOL_FAVORITE k ON c.COM_IDNUM  = k.COM_IDNUM where \n" + "k.KOL_IDNUM = ? ;";
	private static final String DELETE = "DELETE FROM KOL_FAVORITE where kol_idnum = ? and com_idnum  = ? ";

>>>>>>> alanyu
//	public static void main(String[] args) {
//		
//		ComFavorDAO test = new ComFavorDAO();
//		
//		test.insert("美妝","2","3");
//	}
//		

<<<<<<< HEAD
	public void insert(KolFavorVO kolFavorVO) {
=======
	public void insert(Integer kol_idnum, Integer com_idnum) {
>>>>>>> alanyu

		Connection con = null;
		PreparedStatement pstmt = null;
		int favorite_idnum = -1;

		try {
			con = ds.getConnection();
<<<<<<< HEAD
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
=======
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, kol_idnum);
			pstmt.setInt(2, com_idnum);

			pstmt.executeUpdate();
>>>>>>> alanyu

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
<<<<<<< HEAD
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
=======

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
//			pstmt = con.prepareStatement(UPDATE);
>>>>>>> alanyu

			pstmt.setInt(1, kolFavorVO.getFavorite_idnum());
			pstmt.setInt(2, kolFavorVO.getCom_idnum());
			pstmt.setInt(3, kolFavorVO.getKol_idnum());

			pstmt.executeUpdate();
<<<<<<< HEAD
			
=======

>>>>>>> alanyu
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
<<<<<<< HEAD
		
	}

	@Override
	public void delete(Integer Favorite_IdNum) {
=======

	}

	@Override
	public void delete(Integer kol_idnum, Integer com_idnum) {
>>>>>>> alanyu
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

<<<<<<< HEAD
			pstmt.setInt(1, Favorite_IdNum);
=======
			pstmt.setInt(1, kol_idnum);
			pstmt.setInt(2, com_idnum);
>>>>>>> alanyu

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
<<<<<<< HEAD
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
=======
			throw new RuntimeException("A database error occured. " + se.getMessage());
>>>>>>> alanyu
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
<<<<<<< HEAD
	public KolFavorVO findByPrimarKey(Integer favorite_idnum) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		KolFavorVO kolFavorVO =null;
=======
	public List<CompanyMebVO> findByPrimarKey(Integer kol_idnum) {
		// TODO Auto-generated method stub
		List<CompanyMebVO> list = new ArrayList<CompanyMebVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
>>>>>>> alanyu
		ResultSet rs = null;

		try {

			con = ds.getConnection();
<<<<<<< HEAD
			
			pstmt = con.prepareStatement(GET_ONE_STMT);
			rs = pstmt.getResultSet();
			pstmt.setInt(1, favorite_idnum);
=======

			pstmt = con.prepareStatement(GET_ONE_STMT);
			rs = pstmt.getResultSet();
			pstmt.setInt(1, kol_idnum);
>>>>>>> alanyu

			rs = pstmt.executeQuery();

			while (rs.next()) {
<<<<<<< HEAD
				kolFavorVO = new KolFavorVO();
				kolFavorVO.setFavorite_idnum(kolFavorVO.getFavorite_idnum());
				kolFavorVO.setCom_idnum(kolFavorVO.getCom_idnum());
				kolFavorVO.setKol_idnum(kolFavorVO.getKol_idnum());
=======
				CompanyMebVO companyMebVO = new CompanyMebVO();
				companyMebVO.setCom_idnum(rs.getInt("COM_IDNUM"));
				companyMebVO.setCom_name(rs.getString(2));
				companyMebVO.setCom_email(rs.getString(3));
				companyMebVO.setCom_phone(rs.getString(4));
				companyMebVO.setCom_website(rs.getString(5));
				
				list.add(companyMebVO);
>>>>>>> alanyu
			}

			// Handle any driver errors
		} catch (SQLException se) {
<<<<<<< HEAD
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
=======
			throw new RuntimeException("A database error occured. " + se.getMessage());
>>>>>>> alanyu
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
<<<<<<< HEAD
		return kolFavorVO;
	}

	@Override
	public List<KolFavorVO> getAll() {
		List<KolFavorVO> list = new ArrayList<KolFavorVO>();
		KolFavorVO kolFavorVO = null;
		
=======
		return list;
	}

	@Override
	public List<CompanyMebVO> getAll() {
		List<CompanyMebVO> list = new ArrayList<CompanyMebVO>();

>>>>>>> alanyu
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
//				System.out.println("���]��");
<<<<<<< HEAD
				kolFavorVO = new KolFavorVO();
				kolFavorVO.setFavorite_idnum(rs.getInt("favorite_idnum"));
				kolFavorVO.setCom_idnum(rs.getInt("com_idnum"));
				kolFavorVO.setKol_idnum(rs.getInt("kol_idnum"));
				list.add(kolFavorVO);
=======
				CompanyMebVO companyMebVO = new CompanyMebVO();
				companyMebVO.setCom_idnum(rs.getInt("COM_IDNUM"));
				companyMebVO.setCom_name(rs.getString(2));
				companyMebVO.setCom_email(rs.getString(3));
				companyMebVO.setCom_phone(rs.getString(4));
				companyMebVO.setCom_website(rs.getString(5));
				
				list.add(companyMebVO);
>>>>>>> alanyu
			}

			// Handle any driver errors
		} catch (SQLException se) {
<<<<<<< HEAD
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
=======
			throw new RuntimeException("A database error occured. " + se.getMessage());
>>>>>>> alanyu
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
<<<<<<< HEAD
			
=======

>>>>>>> alanyu
}
