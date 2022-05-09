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

public class EmailDetailDAO implements EmailDetailDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT = "INSERT INTO `EMAIL_DETAIL` (`COM_ACCOUNT`, `KOL_ACCOUNT`, `EMAIL_TYPENUM`, `EMAIL_TITLE`, `EMAIL_CONTENT`, `RECIPIENT`) VALUES (?,?,?,?,?,?);";
	// 用帳號找出廠商編號
	private static final String FINDID = "SELECT `COM_ACCOUNT` FROM COMPANY_MEB where COM_ACCOUNT = ?;";
	// 找某某人的信箱
	private static final String FINDMAIL_FOR_COM = "SELECT KOL_ACCOUNT, ADM_ACCOUNT, EMAIL_TITLE, EMAIL_CONTENT, EMAIL_DATE, EMAIL_NUM FROM EMAIL_DETAIL WHERE COM_ACCOUNT = ? and RECIPIENT='COM';";
	private static final String FINDMAIL_FOR_KOL = "SELECT COM_ACCOUNT, ADM_ACCOUNT, EMAIL_TITLE, EMAIL_CONTENT, EMAIL_DATE, EMAIL_NUM FROM EMAIL_DETAIL WHERE KOL_ACCOUNT = ? and RECIPIENT='KOL';";
	private static final String FINDMAIL_FOR_ADM = "SELECT COM_ACCOUNT, KOL_ACCOUNT, EMAIL_TITLE, EMAIL_CONTENT, EMAIL_DATE, EMAIL_NUM FROM EMAIL_DETAIL WHERE ADM_ACCOUNT = ? and RECIPIENT='ADM';";
	// 用編號找一封信
	private static final String GET_A_LETTER = "SELECT * FROM EMAIL_DETAIL WHERE EMAIL_NUM =?;";
	private static final String DELETE = "DELETE FROM EMAIL_DETAIL WHERE EMAIL_NUM = ?";

	@Override
	public void insert(EmailDetailVO emailDetailVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);

			pstmt.setString(1, emailDetailVO.getCom_account());
			pstmt.setString(2, emailDetailVO.getKol_account());
			pstmt.setInt(3, emailDetailVO.getEmail_typenum());
			pstmt.setString(4, emailDetailVO.getEmail_title());
			pstmt.setString(5, emailDetailVO.getEmail_content());
			pstmt.setString(6, emailDetailVO.getRecipient());
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("格式錯誤'或'沒有此帳號密碼");
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
	public Integer findID(String memName) {// 把收件者的帳號轉換成會員編號
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer memACCOUNT = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FINDID);
			pstmt.setString(1, memName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memACCOUNT = rs.getInt("COM_ACCOUNT");
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return memACCOUNT;
	}

	@Override
	public List<EmailDetailVO> findMailBox(String recipient, String mem_account) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EmailDetailVO> list = new ArrayList<>();
		try {
			con = ds.getConnection();
			if ("COM".equals(recipient)) {// 找廠商的信箱
				pstmt = con.prepareStatement(FINDMAIL_FOR_COM);
				pstmt.setString(1, mem_account);

				rs = pstmt.executeQuery();
				while (rs.next()) {
					EmailDetailVO emailDetailVO = new EmailDetailVO();
					emailDetailVO.setKol_account(rs.getString("KOL_ACCOUNT"));
					emailDetailVO.setAdm_account(rs.getString("ADM_ACCOUNT"));
					emailDetailVO.setEmail_title(rs.getString("EMAIL_TITLE"));
					emailDetailVO.setEmail_content(rs.getString("EMAIL_CONTENT"));
					emailDetailVO.setEmail_num(rs.getInt("EMAIL_NUM"));
					emailDetailVO.setEmail_date(rs.getObject("EMAIL_DATE", Timestamp.class));
					list.add(emailDetailVO);
				}
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmailDetailVO emailDetailVO= null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_A_LETTER);
			pstmt.setInt(1, email_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				emailDetailVO = new EmailDetailVO();
				emailDetailVO.setCom_account(rs.getString("COM_ACCOUNT"));
				emailDetailVO.setKol_account(rs.getString("KOL_ACCOUNT"));
				emailDetailVO.setAdm_account(rs.getString("ADM_ACCOUNT"));
				emailDetailVO.setEmail_title(rs.getString("EMAIL_TITLE"));
				emailDetailVO.setEmail_content(rs.getString("EMAIL_CONTENT"));
				emailDetailVO.setEmail_num(rs.getInt("EMAIL_NUM"));
				emailDetailVO.setEmail_date(rs.getObject("EMAIL_DATE",Timestamp.class));
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
		
		return emailDetailVO;
	}

	@Override
	public void delete(Integer email_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, email_num);
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public List<EmailDetailVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
