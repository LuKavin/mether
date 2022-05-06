package com.emailDetail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.product.model.ProductVO;
import com.productPhoto.model.ProductPhotoVO;
import com.productType.model.ProductTypeVO;


public class EmailDetailDAO implements EmailDetailDAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT = "INSERT INTO `EMAIL_DETAIL` (`COM_IDNUM`, `KOL_IDNUM`, `EMAIL_TYPENUM`, `EMAIL_TITLE`, `EMAIL_CONTENT`, `RECIPIENT`) VALUES (?,?,?,?,?,?);";
	//用帳號找出廠商編號
	private static final String FINDID = "SELECT `COM_IDNUM` FROM COMPANY_MEB where COM_ACCOUNT = ?;";
	//網紅編號找出帳號
	private static final String FINDACCOUNT = "SELECT `KOL_ACCOUNT` FROM KOL_MEB where KOL_IDNUM = ?;";
	//找某某人的信箱
	private static final String FINDMAIL_FOR_COM = "SELECT KOL_IDNUM, ADM_IDNUM, EMAIL_TITLE, EMAIL_CONTENT, EMAIL_DATE FROM EMAIL_DETAIL WHERE COM_IDNUM = ? and RECIPIENT='COM';";
	private static final String FINDMAIL_FOR_KOL = "SELECT COM_IDNUM, ADM_IDNUM, EMAIL_TITLE, EMAIL_CONTENT, EMAIL_DATE FROM EMAIL_DETAIL WHERE KOL_IDNUM = ? and RECIPIENT='KOL';";
	private static final String FINDMAIL_FOR_ADM = "SELECT COM_IDNUM, KOL_IDNUM, EMAIL_TITLE, EMAIL_CONTENT, EMAIL_DATE FROM EMAIL_DETAIL WHERE ADM_IDNUM = ? and RECIPIENT='ADM';";
	
	private static final String GET_ALL = "SELECT PRODUCT_TYPENUM, PRODUCT_TYPENAME FROM PRODUCT_TYPE;";
	private static final String GET_ONE = "SELECT PRODUCT_TYPENUM, PRODUCT_TYPENAME FROM PRODUCT_TYPE WHERE PRODUCT_TYPENUM = ? ;";
	private static final String UPDATE = 
			"update `PRODUCT_TYPE` set `PRODUCT_TYPENAME` = ? where PRODUCT_TYPENUM = ?;"; 

	@Override
	public void insert(EmailDetailVO emailDetailVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			
			pstmt.setInt(1, emailDetailVO.getCom_idnum());
			pstmt.setInt(2, emailDetailVO.getKol_idnum());
			pstmt.setInt(3, emailDetailVO.getEmail_typenum());
			pstmt.setString(4, emailDetailVO.getEmail_title());
			pstmt.setString(5, emailDetailVO.getEmail_content());
			pstmt.setString(6, emailDetailVO.getRecipient());
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
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
	public Integer findID(String memName) {//把收件者的帳號轉換成會員編號
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer memIdnum = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FINDID);
			pstmt.setString(1, memName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memIdnum = rs.getInt("COM_IDNUM");
			}
				

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
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
		return memIdnum;
	}

	


	@Override
	public String findAccount(Integer mem_Idnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String memAccount = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FINDACCOUNT);
			pstmt.setInt(1, mem_Idnum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memAccount = rs.getString("KOL_ACCOUNT");
			}
				

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
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
		return memAccount;
	}



	@Override
	public List<EmailDetailVO> findMailBox(String recipient, Integer mem_Idnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EmailDetailVO> list = new ArrayList<>();
		try {
			con = ds.getConnection();
			if("COM".equals(recipient)) {//找廠商的信箱
				pstmt = con.prepareStatement(FINDMAIL_FOR_COM);
				pstmt.setInt(1, mem_Idnum);
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					EmailDetailVO emailDetailVO = new EmailDetailVO();
					emailDetailVO.setKol_idnum(rs.getInt("KOL_IDNUM"));
					emailDetailVO.setAdm_idnum(rs.getInt("ADM_IDNUM"));
					emailDetailVO.setEmail_title(rs.getString("EMAIL_TITLE"));
					emailDetailVO.setEmail_content(rs.getString("EMAIL_CONTENT"));
					emailDetailVO.setEmail_date(rs.getObject("EMAIL_DATE",Timestamp.class));
					list.add(emailDetailVO);
				}
			}

			

		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
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
		
		return list;
	}



	@Override
	public void update(EmailDetailVO emailDetailVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmailDetailVO findByPrimaryKey(Integer email_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer email_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmailDetailVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
}
