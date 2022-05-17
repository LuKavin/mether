package com.kolmeb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.companymeb.model.CompanyMebVO;


public class KolMebDAO implements KolMebDAO_interface{

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	private static final String KOLLOGIN_STMT = 
			"SELECT * FROM KOL_MEB WHERE KOL_ACCOUNT = ? and KOL_PASSWORD = ?";
	
	private static final String COMACCOUNT_STMT = 
			"SELECT COM_ACCOUNT FROM COMPANY_MEB WHERE COM_ACCOUNT = ?";
	
	private static final String INSERT_STMT = 
			"INSERT INTO KOL_MEB (KOL_ACCOUNT, KOL_PASSWORD, KOL_EMAIL, KOL_NAME) VALUES(?, ?, ?, ?)";
	
//	private static final String INSERT_STMT = 
//			"INSERT INTO KOL_MEB (KOL_ACCOUNT, KOL_PASSWORD, KOL_EMAIL, KOL_PHONE, "
//			+ "KOL_CELLPHONE, KOL_ADDRESS, KOL_WEBSITE, KOL_BIRTHDAY, KOL_GENDER, "
//			+ "KOL_REGDATE, KOL_ID, KOL_BANKCODE, KOL_BANKACCOUNT, KOL_NAME, KOL_LOCATION,"
//			+ "KOL_HEIGHT, KOL_WEIGHT, KOL_STYLE, KOL_EXPERIENCE, MEB_ACCESSNUM, AVG_STAR, "
//			+ "TOTAL_RATE, TOTAL_STAR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String GET_ALL_STMT = 
			"SELECT KOL_IDNUM, KOL_ACCOUNT, KOL_PASSWORD, KOL_EMAIL, KOL_PHONE, "
			+ "KOL_CELLPHONE, KOL_ADDRESS, KOL_WEBSITE, KOL_BIRTHDAY, KOL_GENDER, "
			+ "KOL_REGDATE, KOL_ID, KOL_BANKCODE, KOL_BANKACCOUNT, KOL_NAME, "
			+ "KOL_LOCATION, KOL_HEIGHT, KOL_WEIGHT, KOL_STYLE, KOL_EXPERIENCE, MEB_ACCESSNUM, AVG_STAR, "
			+ "TOTAL_RATE, TOTAL_STAR FROM KOL_MEB order by KOL_IDNUM";
	
	private static final String GET_ONE_STMT = 
			"SELECT KOL_IDNUM, KOL_ACCOUNT, KOL_PASSWORD, KOL_EMAIL, KOL_PHONE, "
			+ "KOL_CELLPHONE, KOL_ADDRESS, KOL_WEBSITE, KOL_BIRTHDAY, KOL_GENDER, "
			+ "KOL_REGDATE, KOL_ID, KOL_BANKCODE, KOL_BANKACCOUNT, KOL_NAME, "
			+ "KOL_LOCATION, KOL_HEIGHT, KOL_WEIGHT, KOL_STYLE, KOL_EXPERIENCE, MEB_ACCESSNUM, AVG_STAR, "
			+ "TOTAL_RATE, TOTAL_STAR FROM KOL_MEB where KOL_IDNUM = ?";
	
	private static final String DELETE = 
			"DELETE FROM KOL_MEB where KOL_IDNUM = ?";
	
	private static final String UPDATE = 
			"UPDATE KOL_MEB set KOL_PASSWORD=?, KOL_EMAIL=?, KOL_PHONE=?, KOL_CELLPHONE=?, KOL_ADDRESS=?, "
			+ "KOL_WEBSITE=?, KOL_BIRTHDAY=?, KOL_GENDER=?, KOL_ID=?, KOL_BANKCODE=?, KOL_BANKACCOUNT=?, KOL_NAME=?, "
			+ "KOL_LOCATION=?, KOL_HEIGHT=?, KOL_WEIGHT=?, KOL_STYLE=?, KOL_EXPERIENCE=? where KOL_IDNUM = ?";
	
	private static final String UPDATE_KPASSWORD =
			"UPDATE KOL_MEB set KOL_PASSWORD = ? WHERE KOL_EMAIL=?";
	
	private static final String SELECT_KOLEMIAL = 
			"SELECT KOL_IDNUM FROM KOL_MEB WHERE KOL_EMAIL = ?";
	
	
	
	@Override
	public void updatepassword(String kol_email, String kol_password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_KPASSWORD);
			pstmt.setString(1, kol_password);
			pstmt.setString(2, kol_email);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured."
					+ se.getMessage());
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
	public Integer findByKolEmail(String kol_email) {
		Integer kol_idnum = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_KOLEMIAL);
			pstmt.setString(1, kol_email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				kol_idnum = rs.getInt("kol_idnum");				
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured."
					+ se.getMessage());
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
		return kol_idnum;
	}


	@Override
	public KolMebVO findAccountPassword(String mem_account, String mem_password) {
		KolMebVO kolMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(KOLLOGIN_STMT);
			pstmt.setString(1, mem_account);
			pstmt.setString(2, mem_password);
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
				}
		} catch (SQLException se) {
			se.printStackTrace();
			throw new RuntimeException("A database error occured." + se.getMessage());
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
		return kolMebVO;
	}


	@Override
	public boolean commatch(String kol_account) {
		KolMebVO kolMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = true;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(COMACCOUNT_STMT);
			pstmt.setString(1, kol_account);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getRow() != 0) {
					throw new Exception();
					}
				}
			}catch (SQLException se) {throw new RuntimeException("A database error occured." + se.getMessage());
			
			}catch (Exception e) {
				check = false;
				throw new RuntimeException("此帳號已有人使用");
			
			}finally {
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
			return check;
		}
	

	@Override
	public int insert(KolMebVO kolMebVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int kol_idnum;
		try {
			con = ds.getConnection();
			int[] col = {1}; // 說明第幾個欄位為流水號，1代表此table中第一個欄位為流水號(kol_idnum)
			pstmt = con.prepareStatement(INSERT_STMT,col); // 執行SQL指令時，同時要告知第幾個欄位為流水號
			pstmt.setString(1, kolMebVO.getKol_account());
			pstmt.setString(2, kolMebVO.getKol_password());
			pstmt.setString(3, kolMebVO.getKol_email());
//			pstmt.setString(4, kolMebVO.getKol_phone());
//			pstmt.setString(5, kolMebVO.getKol_cellphone());
//			pstmt.setString(6, kolMebVO.getKol_address());
//			pstmt.setString(7, kolMebVO.getKol_website());
//			pstmt.setDate(8, kolMebVO.getKol_birthday());
//			pstmt.setString(9, kolMebVO.getKol_gender());
//			pstmt.setDate(10, kolMebVO.getKol_regdate());
//			pstmt.setString(11, kolMebVO.getKol_id());
//			pstmt.setString(12, kolMebVO.getKol_bankcode());
//			pstmt.setString(13, kolMebVO.getKol_bankaccount());
			pstmt.setString(4, kolMebVO.getKol_name());
//			pstmt.setString(15, kolMebVO.getKol_location());
//			pstmt.setString(16, kolMebVO.getKol_height());
//			pstmt.setString(17, kolMebVO.getKol_weight());
//			pstmt.setString(18, kolMebVO.getKol_style());
//			pstmt.setString(19, kolMebVO.getKol_experience());
//			pstmt.setInt(20, kolMebVO.getMeb_accessnum());
//			pstmt.setInt(21, kolMebVO.getAvg_star());
//			pstmt.setInt(22, kolMebVO.getTotal_rate());
//			pstmt.setInt(23, kolMebVO.getTotal_star());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys(); // 把拿到的流水號裝到rs裡面
			rs.next(); // 游標指進來table才能找資料
			kol_idnum = rs.getInt(1); // 取得那筆資料的第一個欄位(為流水號)
		}catch(SQLException se) {
			throw new RuntimeException("此帳號已有人使用");
		}finally {
			if(pstmt!=null) {
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
		return kol_idnum;
	}

	@Override
	public void update(KolMebVO kolMebVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, kolMebVO.getKol_password());
			pstmt.setString(2, kolMebVO.getKol_email());
			pstmt.setString(3, kolMebVO.getKol_phone());
			pstmt.setString(4, kolMebVO.getKol_cellphone());
			pstmt.setString(5, kolMebVO.getKol_address());
			pstmt.setString(6, kolMebVO.getKol_website());
			pstmt.setDate(7, kolMebVO.getKol_birthday());
			pstmt.setString(8, kolMebVO.getKol_gender());
			pstmt.setString(9, kolMebVO.getKol_id());
			pstmt.setString(10, kolMebVO.getKol_bankcode());
			pstmt.setString(11, kolMebVO.getKol_bankaccount());
			pstmt.setString(12, kolMebVO.getKol_name());
			pstmt.setString(13, kolMebVO.getKol_location());
			pstmt.setString(14, kolMebVO.getKol_height());
			pstmt.setString(15, kolMebVO.getKol_weight());
			pstmt.setString(16, kolMebVO.getKol_style());
			pstmt.setString(17, kolMebVO.getKol_experience());
			pstmt.setInt(18, kolMebVO.getKol_idnum());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured."
					+ se.getMessage());
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
	public void delete(Integer kol_idnum) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, kol_idnum);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured."
					+ se.getMessage());
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
	public KolMebVO findByPrimaryKey(Integer kol_idnum) {
		KolMebVO kolMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, kol_idnum);
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
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured."
					+ se.getMessage());
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
		return kolMebVO;
	}

	@Override
	public List<KolMebVO> getAll() {
		List<KolMebVO> list = new ArrayList<KolMebVO>();
		KolMebVO kolMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
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
			throw new RuntimeException("A database error occured."
					+ se.getMessage());
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
