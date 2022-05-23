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

import com.companymeb.model.CompanyMebVO;
import com.kolmeb.model.KolMebVO;

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
	private static final String GET_ORDERMASTER_COUNT = "SELECT COUNT(*) FROM ORDER_MASTER where ORDER_STATUS != \"已完成\" and ORDER_STATUS != \"下架\"";
	private static final String GET_ORDERMASTER_NEW = "SELECT o.ORDER_NUM, p.PRODUCT_NAME, p.PRODUCT_DEADLINE, o.ORDER_DATE, o.ORDER_STATUS FROM ORDER_MASTER o join PRODUCT p on o.PRODUCT_NUM = p.PRODUCT_NUM order by o.ORDER_NUM desc LIMIT 6";
	private static final String SET_COM_ACCESS = "UPDATE COMPANY_MEB SET MEB_ACCESSNUM = ? where COM_IDNUM = ?";
	private static final String SET_KOL_ACCESS = "UPDATE KOL_MEB SET MEB_ACCESSNUM = ? where KOL_IDNUM = ?";
	private static final String SET_ORDERMASTER_STATUS = "UPDATE ORDER_MASTER SET ORDER_STATUS = ? where ORDER_NUM = ?";
	private static final String GET_ALLCOM_STMT4 = "SELECT COM_IDNUM, COM_ACCOUNT, COM_PASSWORD, COM_EMAIL, COM_PHONE, COM_CELLPHONE, COM_ADDRESS, COM_WEBSITE, COM_BIRTHDAY, COM_GENDER, COM_REGDATE, COM_ID, COM_BANKCODE, COM_BANKACCOUNT, COM_NAME, COM_INTRODUCE, COM_FOUNDDATE, COM_TAXIDNUM, MEB_ACCESSNUM, AVG_STAR, TOTAL_RATE, TOTAL_STAR FROM COMPANY_MEB where MEB_ACCESSNUM = 4";
	private static final String GET_ALLCOM_STMT1 = "SELECT COM_IDNUM, COM_ACCOUNT, COM_PASSWORD, COM_EMAIL, COM_PHONE, COM_CELLPHONE, COM_ADDRESS, COM_WEBSITE, COM_BIRTHDAY, COM_GENDER, COM_REGDATE, COM_ID, COM_BANKCODE, COM_BANKACCOUNT, COM_NAME, COM_INTRODUCE, COM_FOUNDDATE, COM_TAXIDNUM, MEB_ACCESSNUM, AVG_STAR, TOTAL_RATE, TOTAL_STAR FROM COMPANY_MEB where MEB_ACCESSNUM = 1";
	private static final String GET_ALLKOL_STMT4 = "SELECT KOL_IDNUM, KOL_ACCOUNT, KOL_PASSWORD, KOL_EMAIL, KOL_PHONE, KOL_CELLPHONE, KOL_ADDRESS, KOL_WEBSITE, KOL_BIRTHDAY, KOL_GENDER, KOL_REGDATE, KOL_ID, KOL_BANKCODE, KOL_BANKACCOUNT, KOL_NAME, KOL_LOCATION, KOL_HEIGHT, KOL_WEIGHT, KOL_STYLE, KOL_EXPERIENCE, MEB_ACCESSNUM, AVG_STAR, TOTAL_RATE, TOTAL_STAR FROM KOL_MEB where MEB_ACCESSNUM = 4";
	private static final String GET_ALLKOL_STMT2 = "SELECT KOL_IDNUM, KOL_ACCOUNT, KOL_PASSWORD, KOL_EMAIL, KOL_PHONE, KOL_CELLPHONE, KOL_ADDRESS, KOL_WEBSITE, KOL_BIRTHDAY, KOL_GENDER, KOL_REGDATE, KOL_ID, KOL_BANKCODE, KOL_BANKACCOUNT, KOL_NAME, KOL_LOCATION, KOL_HEIGHT, KOL_WEIGHT, KOL_STYLE, KOL_EXPERIENCE, MEB_ACCESSNUM, AVG_STAR, TOTAL_RATE, TOTAL_STAR FROM KOL_MEB where MEB_ACCESSNUM = 2";
	private static final String GET_KOL_PHOTO = "SELECT k.KOL_IDNUM, k.KOL_NAME, m.MEB_PHOTONUM, m.MEB_PHOTO FROM MEMBER_PHOTO m join KOL_MEB k on m.KOL_IDNUM = k.KOL_IDNUM";
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
	public List getOrderMasterNew() {
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

	// 更新廠商權限
	@Override
	public void updateComAccess(Integer meb_accessnum, Integer com_idnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();

			pstmt = con.prepareStatement(SET_COM_ACCESS);
			rs = pstmt.getResultSet();
			pstmt.setInt(1, meb_accessnum);
			pstmt.setInt(2, com_idnum);
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

	// 更新網紅權限
	@Override
	public void updateKolAccess(Integer meb_accessnum, Integer kol_idnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();

			pstmt = con.prepareStatement(SET_KOL_ACCESS);
			rs = pstmt.getResultSet();
			pstmt.setInt(1, meb_accessnum);
			pstmt.setInt(2, kol_idnum);
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

	// 訂單下架
	public void updateOrderMasterStatus(String order_status, Integer order_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();

			pstmt = con.prepareStatement(SET_ORDERMASTER_STATUS);
			rs = pstmt.getResultSet();
			pstmt.setString(1, order_status);
			pstmt.setInt(2, order_num);
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

	// 被停權的廠商
	@Override
	public List getComAccess4() {
		List list = new ArrayList();
		CompanyMebVO companyMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALLCOM_STMT4);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				companyMebVO = new CompanyMebVO();
				companyMebVO.setCom_idnum(rs.getInt("com_idnum"));
				companyMebVO.setCom_account(rs.getString("com_account"));
				companyMebVO.setCom_password(rs.getString("com_password"));
				companyMebVO.setCom_email(rs.getString("com_email"));
				companyMebVO.setCom_phone(rs.getString("com_phone"));
				companyMebVO.setCom_cellphone(rs.getString("com_cellphone"));
				companyMebVO.setCom_address(rs.getString("com_address"));
				companyMebVO.setCom_website(rs.getString("com_website"));
				companyMebVO.setCom_birthday(rs.getDate("com_birthday"));
				companyMebVO.setCom_gender(rs.getString("com_gender"));
				companyMebVO.setCom_regdate(rs.getDate("com_regdate"));
				companyMebVO.setCom_id(rs.getString("com_id"));
				companyMebVO.setCom_bankcode(rs.getString("com_bankcode"));
				companyMebVO.setCom_bankaccount(rs.getString("com_bankaccount"));
				companyMebVO.setCom_name(rs.getString("com_name"));
				companyMebVO.setCom_introduce(rs.getString("com_introduce"));
				companyMebVO.setCom_founddate(rs.getDate("com_founddate"));
				companyMebVO.setCom_taxidnum(rs.getString("com_taxidnum"));
				companyMebVO.setMeb_accessnum(rs.getInt("meb_accessnum"));
				companyMebVO.setAvg_star(rs.getInt("avg_star"));
				companyMebVO.setTotal_rate(rs.getInt("total_rate"));
				companyMebVO.setTotal_star(rs.getInt("total_star"));
				list.add(companyMebVO);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
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

	// 沒停權的廠商
	@Override
	public List getComAccess1() {
		List list = new ArrayList();
		CompanyMebVO companyMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALLCOM_STMT1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				companyMebVO = new CompanyMebVO();
				companyMebVO.setCom_idnum(rs.getInt("com_idnum"));
				companyMebVO.setCom_account(rs.getString("com_account"));
				companyMebVO.setCom_password(rs.getString("com_password"));
				companyMebVO.setCom_email(rs.getString("com_email"));
				companyMebVO.setCom_phone(rs.getString("com_phone"));
				companyMebVO.setCom_cellphone(rs.getString("com_cellphone"));
				companyMebVO.setCom_address(rs.getString("com_address"));
				companyMebVO.setCom_website(rs.getString("com_website"));
				companyMebVO.setCom_birthday(rs.getDate("com_birthday"));
				companyMebVO.setCom_gender(rs.getString("com_gender"));
				companyMebVO.setCom_regdate(rs.getDate("com_regdate"));
				companyMebVO.setCom_id(rs.getString("com_id"));
				companyMebVO.setCom_bankcode(rs.getString("com_bankcode"));
				companyMebVO.setCom_bankaccount(rs.getString("com_bankaccount"));
				companyMebVO.setCom_name(rs.getString("com_name"));
				companyMebVO.setCom_introduce(rs.getString("com_introduce"));
				companyMebVO.setCom_founddate(rs.getDate("com_founddate"));
				companyMebVO.setCom_taxidnum(rs.getString("com_taxidnum"));
				companyMebVO.setMeb_accessnum(rs.getInt("meb_accessnum"));
				companyMebVO.setAvg_star(rs.getInt("avg_star"));
				companyMebVO.setTotal_rate(rs.getInt("total_rate"));
				companyMebVO.setTotal_star(rs.getInt("total_star"));
				list.add(companyMebVO);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
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

	// 被停權的網紅
	@Override
	public List getKolAccess4() {
		List list = new ArrayList();
		KolMebVO kolMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALLKOL_STMT4);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kolMebVO = new KolMebVO();
				kolMebVO.setKol_idnum(rs.getInt("kol_idnum"));
				kolMebVO.setKol_account(rs.getString("kol_account"));
				kolMebVO.setKol_password(rs.getString("kol_password"));
				kolMebVO.setKol_email(rs.getString("kol_email"));
				kolMebVO.setKol_phone(rs.getString("kol_phone"));
				kolMebVO.setKol_cellphone(rs.getString("kol_cellphone"));
				kolMebVO.setKol_address(rs.getString("kol_address"));
				kolMebVO.setKol_website(rs.getString("kol_website"));
				kolMebVO.setKol_birthday(rs.getDate("kol_birthday"));
				kolMebVO.setKol_gender(rs.getString("kol_gender"));
				kolMebVO.setKol_regdate(rs.getDate("kol_regdate"));
				kolMebVO.setKol_id(rs.getString("kol_id"));
				kolMebVO.setKol_bankcode(rs.getString("kol_bankcode"));
				kolMebVO.setKol_bankaccount(rs.getString("kol_bankaccount"));
				kolMebVO.setKol_name(rs.getString("kol_name"));
				kolMebVO.setKol_location(rs.getString("kol_location"));
				kolMebVO.setKol_height(rs.getString("kol_height"));
				kolMebVO.setKol_weight(rs.getString("kol_weight"));
				kolMebVO.setKol_style(rs.getString("kol_style"));
				kolMebVO.setKol_experience(rs.getString("kol_experience"));
				kolMebVO.setMeb_accessnum(rs.getInt("meb_accessnum"));
				kolMebVO.setAvg_star(rs.getInt("avg_star"));
				kolMebVO.setTotal_rate(rs.getInt("total_rate"));
				kolMebVO.setTotal_star(rs.getInt("total_star"));
				list.add(kolMebVO);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
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

	// 沒停權的網紅
	@Override
	public List getKolAccess2() {
		List list = new ArrayList();
		KolMebVO kolMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALLKOL_STMT2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kolMebVO = new KolMebVO();
				kolMebVO.setKol_idnum(rs.getInt("kol_idnum"));
				kolMebVO.setKol_account(rs.getString("kol_account"));
				kolMebVO.setKol_password(rs.getString("kol_password"));
				kolMebVO.setKol_email(rs.getString("kol_email"));
				kolMebVO.setKol_phone(rs.getString("kol_phone"));
				kolMebVO.setKol_cellphone(rs.getString("kol_cellphone"));
				kolMebVO.setKol_address(rs.getString("kol_address"));
				kolMebVO.setKol_website(rs.getString("kol_website"));
				kolMebVO.setKol_birthday(rs.getDate("kol_birthday"));
				kolMebVO.setKol_gender(rs.getString("kol_gender"));
				kolMebVO.setKol_regdate(rs.getDate("kol_regdate"));
				kolMebVO.setKol_id(rs.getString("kol_id"));
				kolMebVO.setKol_bankcode(rs.getString("kol_bankcode"));
				kolMebVO.setKol_bankaccount(rs.getString("kol_bankaccount"));
				kolMebVO.setKol_name(rs.getString("kol_name"));
				kolMebVO.setKol_location(rs.getString("kol_location"));
				kolMebVO.setKol_height(rs.getString("kol_height"));
				kolMebVO.setKol_weight(rs.getString("kol_weight"));
				kolMebVO.setKol_style(rs.getString("kol_style"));
				kolMebVO.setKol_experience(rs.getString("kol_experience"));
				kolMebVO.setMeb_accessnum(rs.getInt("meb_accessnum"));
				kolMebVO.setAvg_star(rs.getInt("avg_star"));
				kolMebVO.setTotal_rate(rs.getInt("total_rate"));
				kolMebVO.setTotal_star(rs.getInt("total_star"));
				list.add(kolMebVO);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
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

	// 網紅照片
	public List getKolPhoto() {
		List list = new ArrayList();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_KOL_PHOTO);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				Integer kol_idnum = rs.getInt("kol_idnum");
				String kol_name = rs.getString("kol_name");
				Integer meb_photonum = rs.getInt("meb_photonum");
				byte[] meb_photo = rs.getBytes("meb_photo");

				Map map = new HashMap();
				map.put("kol_idnum", kol_idnum);
				map.put("kol_name", kol_name);
				map.put("meb_photonum", meb_photonum);
				map.put("meb_photo", meb_photo);
				
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
