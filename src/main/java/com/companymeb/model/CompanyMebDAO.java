package com.companymeb.model;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class CompanyMebDAO implements CompanyMebDAO_interface{

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private static final String COMLOGIN_STMT = 
			"SELECT * FROM COMPANY_MEB WHERE COM_ACCOUNT = ? and COM_PASSWORD = ?";
		
	private static final String KOLACCOUNT_STMT = 
			"SELECT KOL_ACCOUNT FROM KOL_MEB WHERE KOL_ACCOUNT = ?";
	
	private static final String INSERT_STMT = 
			"INSERT INTO COMPANY_MEB (COM_ACCOUNT, COM_PASSWORD, COM_EMAIL, COM_NAME) VALUES(?, ?, ?, ?)";
	
//	private static final String INSERT_STMT = 
//			"INSERT INTO COMPANY_MEB (COM_ACCOUNT, COM_PASSWORD, COM_EMAIL, COM_PHONE, "
//			+ "COM_CELLPHONE, COM_ADDRESS, COM_WEBSITE, COM_BIRTHDAY, COM_GENDER, "
//			+ "COM_REGDATE, COM_ID, COM_BANKCODE, COM_BANKACCOUNT, COM_NAME, "
//			+ "COM_INTRODUCE, COM_FOUNDDATE, COM_TAXIDNUM, MEB_ACCESSNUM, AVG_STAR, "
//			+ "TOTAL_RATE, TOTAL_STAR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String GET_ALL_STMT = 
			"SELECT COM_IDNUM, COM_ACCOUNT, COM_PASSWORD, COM_EMAIL, COM_PHONE, "
			+ "COM_CELLPHONE, COM_ADDRESS, COM_WEBSITE, COM_BIRTHDAY, COM_GENDER, "
			+ "COM_REGDATE, COM_ID, COM_BANKCODE, COM_BANKACCOUNT, COM_NAME, "
			+ "COM_INTRODUCE, COM_FOUNDDATE, COM_TAXIDNUM, MEB_ACCESSNUM, AVG_STAR, "
			+ "TOTAL_RATE, TOTAL_STAR FROM COMPANY_MEB order by COM_IDNUM";
	
	private static final String GET_ONE_STMT = 
			"SELECT COM_IDNUM, COM_ACCOUNT, COM_PASSWORD, COM_EMAIL, COM_PHONE, "
			+ "COM_CELLPHONE, COM_ADDRESS, COM_WEBSITE, COM_BIRTHDAY, COM_GENDER, "
			+ "COM_REGDATE, COM_ID, COM_BANKCODE, COM_BANKACCOUNT, COM_NAME, "
			+ "COM_INTRODUCE, COM_FOUNDDATE, COM_TAXIDNUM, MEB_ACCESSNUM, AVG_STAR, "
			+ "TOTAL_RATE, TOTAL_STAR FROM COMPANY_MEB where COM_IDNUM = ?";
	
	private static final String DELETE = 
			"DELETE FROM COMPANY_MEB where COM_IDNUM = ?";
	
	private static final String UPDATE = 
			"UPDATE COMPANY_MEB set COM_PASSWORD=?, COM_EMAIL=?, COM_PHONE=?, COM_CELLPHONE=?, COM_ADDRESS=?, "
			+ "COM_WEBSITE=?, COM_BIRTHDAY=?, COM_GENDER=?, COM_ID=?, COM_BANKCODE=?, COM_BANKACCOUNT=?, COM_NAME=?, "
			+ "COM_INTRODUCE=?, COM_FOUNDDATE=?, COM_TAXIDNUM=? where COM_IDNUM = ?";
	
	private static final String UPDATE_CPASSWORD =
			"UPDATE COMPANY_MEB set COM_PASSWORD = ? WHERE COM_EMAIL=?";
	
	private static final String SELECT_COMEMIAL = 
			"SELECT COM_IDNUM FROM COMPANY_MEB WHERE COM_EMAIL = ?";
	
	
	
	@Override
	public Integer findByComEmail(String com_email) {
		Integer com_idnum = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_COMEMIAL);
			pstmt.setString(1, com_email);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				com_idnum = rs.getInt("com_idnum");				
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
		return com_idnum;
	}


	@Override
	public void updatepassword(String com_email, String com_password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_CPASSWORD);
			pstmt.setString(1, com_password);
			pstmt.setString(2, com_email);
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
	public CompanyMebVO findAccountPassword(String mem_account, String mem_password) {
		CompanyMebVO companyMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(COMLOGIN_STMT);
			pstmt.setString(1, mem_account);
			pstmt.setString(2, mem_password);
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
		return companyMebVO;
	}


	@Override
	public boolean kolmatch(String com_account) {
		CompanyMebVO companyMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = true;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(KOLACCOUNT_STMT);
			pstmt.setString(1, com_account);
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
	public int insert(CompanyMebVO companyMebVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int com_idnum;
		try {
			con = ds.getConnection();
			int[] col = {1}; // 說明第幾個欄位為流水號，1代表此table中第一個欄位為流水號(com_idnum)
			pstmt = con.prepareStatement(INSERT_STMT,col); // 執行SQL指令時，同時要告知第幾個欄位為流水號
			pstmt.setString(1, companyMebVO.getCom_account());
			pstmt.setString(2, companyMebVO.getCom_password());
			pstmt.setString(3, companyMebVO.getCom_email());
//			pstmt.setString(4, companyMebVO.getCom_phone());
//			pstmt.setString(5, companyMebVO.getCom_cellphone());
//			pstmt.setString(6, companyMebVO.getCom_address());
//			pstmt.setString(7, companyMebVO.getCom_website());
//			pstmt.setDate(8, companyMebVO.getCom_birthday());
//			pstmt.setString(9, companyMebVO.getCom_gender());
//			pstmt.setDate(10, companyMebVO.getCom_regdate());
//			pstmt.setString(11, companyMebVO.getCom_id());
//			pstmt.setString(12, companyMebVO.getCom_bankcode());
//			pstmt.setString(13, companyMebVO.getCom_bankaccount());
			pstmt.setString(4, companyMebVO.getCom_name());
//			pstmt.setString(15, companyMebVO.getCom_introduce());
//			pstmt.setDate(16, companyMebVO.getCom_founddate());
//			pstmt.setString(17, companyMebVO.getCom_taxidnum());
//			pstmt.setInt(18, companyMebVO.getMeb_accessnum());
//			pstmt.setInt(19, companyMebVO.getAvg_star());
//			pstmt.setInt(20, companyMebVO.getTotal_rate());
//			pstmt.setInt(21, companyMebVO.getTotal_star());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys(); // 把拿到的流水號裝到rs裡面
			rs.next(); // 游標指進來table才能找資料
			com_idnum = rs.getInt(1); // 取得那筆資料的第一個欄位(為流水號)
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
		return com_idnum;
	}
	
	@Override
	public void update(CompanyMebVO companyMebVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
//			pstmt.setString(1, companyMebVO.getCom_account());
			pstmt.setString(1, companyMebVO.getCom_password());
			pstmt.setString(2, companyMebVO.getCom_email());
			pstmt.setString(3, companyMebVO.getCom_phone());
			pstmt.setString(4, companyMebVO.getCom_cellphone());
			pstmt.setString(5, companyMebVO.getCom_address());
			pstmt.setString(6, companyMebVO.getCom_website());
			pstmt.setDate(7, companyMebVO.getCom_birthday());
			pstmt.setString(8, companyMebVO.getCom_gender());
//			pstmt.setDate(9, companyMebVO.getCom_regdate());
			pstmt.setString(9, companyMebVO.getCom_id());
			pstmt.setString(10, companyMebVO.getCom_bankcode());
			pstmt.setString(11, companyMebVO.getCom_bankaccount());
			pstmt.setString(12, companyMebVO.getCom_name());
			pstmt.setString(13, companyMebVO.getCom_introduce());
			pstmt.setDate(14, companyMebVO.getCom_founddate());
			pstmt.setString(15, companyMebVO.getCom_taxidnum());
			pstmt.setInt(16, companyMebVO.getCom_idnum());
//			pstmt.setInt(18, companyMebVO.getMeb_accessnum());
//			pstmt.setInt(19, companyMebVO.getAvg_star());
//			pstmt.setInt(20, companyMebVO.getTotal_rate());
//			pstmt.setInt(21, companyMebVO.getTotal_star());
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
	public void delete(Integer com_idnum) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, com_idnum);
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
	public CompanyMebVO findByPrimaryKey(Integer com_idnum) {
		CompanyMebVO companyMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, com_idnum);
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
		return companyMebVO;
	}
	
	@Override
	public List<CompanyMebVO> getAll() {
		List<CompanyMebVO> list = new ArrayList<CompanyMebVO>();
		CompanyMebVO companyMebVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
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
