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

	private static final String INSERT = "INSERT INTO `EMAIL_DETAIL` (`COM_ACCOUNT`, `KOL_ACCOUNT`, `EMAIL_TYPENUM`, `EMAIL_TITLE`, `EMAIL_CONTENT`, `SENDER`) VALUES (?,?,?,?,?,?);";
	// 帳號+找垃圾信箱
	private static final String FIND_TRASHCAN_BOX= "SELECT EMAIL_TITLE, EMAIL_CONTENT, EMAIL_DATE, EMAIL_NUM, SENDER FROM EMAIL_DETAIL WHERE (COM_ACCOUNT = ? and EMAIL_TYPENUM = 3) or (KOL_ACCOUNT = ? and EMAIL_TYPENUM = 3) or (ADM_ACCOUNT = ? and EMAIL_TYPENUM = 3)";
	// 帳號+找信箱
	private static final String FIND_MAIL_BOX= "SELECT EMAIL_TITLE, EMAIL_CONTENT, EMAIL_DATE, EMAIL_NUM, SENDER FROM EMAIL_DETAIL WHERE (COM_ACCOUNT = ? and EMAIL_TYPENUM in(1,4)) or (KOL_ACCOUNT = ? and EMAIL_TYPENUM in(1,4)) or (ADM_ACCOUNT = ? and EMAIL_TYPENUM in(1,4))";
	// 用編號找一封信
	private static final String GET_A_LETTER = "SELECT * FROM EMAIL_DETAIL WHERE EMAIL_NUM =?;";
	//刪除信件
	private static final String DELETE = "DELETE FROM EMAIL_DETAIL WHERE EMAIL_NUM = ?";
	//移至垃圾桶
	private static final String TRASH_CAN = "UPDATE EMAIL_DETAIL SET EMAIL_TYPENUM = 3  where EMAIL_NUM = ?;";
	// 用帳號找出會員權限
	private static final String FIND_ACCESS = "SELECT MEB_ACCESSNUM ACCESSNUM FROM COMPANY_MEB where COM_ACCOUNT=? union all SELECT MEB_ACCESSNUM FROM KOL_MEB where KOL_ACCOUNT=?";
	//出現例外時，系統自動寄出信件
	private static final String EXCEPTION_LETTER_COM = "INSERT INTO `EMAIL_DETAIL` (COM_ACCOUNT, `EMAIL_TYPENUM`, `EMAIL_TITLE`, `EMAIL_CONTENT`, `SENDER`) VALUES (?, 4, '寄件失敗',?, 'ADM');";
	private static final String EXCEPTION_LETTER_KOL = "INSERT INTO `EMAIL_DETAIL` (KOL_ACCOUNT, `EMAIL_TYPENUM`, `EMAIL_TITLE`, `EMAIL_CONTENT`, `SENDER`) VALUES (?, 4, '寄件失敗',?, 'ADM');";

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
			pstmt.setString(6, emailDetailVO.getSender());
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
	public List<EmailDetailVO> findTrashCanBox(String mem_account) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EmailDetailVO> list = new ArrayList<>();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_TRASHCAN_BOX);
			pstmt.setString(1, mem_account);
			pstmt.setString(2, mem_account);
			pstmt.setString(3, mem_account);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmailDetailVO emailDetailVO = new EmailDetailVO();
				emailDetailVO.setEmail_title(rs.getString("EMAIL_TITLE"));
				emailDetailVO.setEmail_content(rs.getString("EMAIL_CONTENT"));
				emailDetailVO.setEmail_num(rs.getInt("EMAIL_NUM"));
				emailDetailVO.setSender(rs.getString("SENDER"));
				emailDetailVO.setEmail_date(rs.getObject("EMAIL_DATE", Timestamp.class));
				list.add(emailDetailVO);
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
				emailDetailVO.setSender(rs.getString("SENDER"));
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
	
	
	@Override
	public Integer findAccess(String memName) {// 把收件者的帳號轉換成會員編號
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Integer accessNum = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_ACCESS);
			pstmt.setString(1, memName);
			pstmt.setString(2, memName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				accessNum = rs.getInt("ACCESSNUM");
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
		return accessNum;
	}



	@Override
	public void toTrashCan(Integer email_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(TRASH_CAN);
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
	public void errorLetter(String memAccount, Integer memAccess, String wrongAccount) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String errorContent = "<p><span style=\"font-size: 24px;\"><font color=\"#ff0000\">寄件失敗：</font></span></p><p><span style=\"font-size: 18px;\"><font color=\"#000000\" style=\"background-color: rgb(255, 255, 0);\">&nbsp; &nbsp; &nbsp;"+wrongAccount+"&nbsp; &nbsp; &nbsp;</font><u style=\"font-style: italic;\">無此使用者，請再次確認收件人帳號</u></span></p>";
		try {

			con = ds.getConnection();
			if(memAccess==1) {
				pstmt = con.prepareStatement(EXCEPTION_LETTER_COM);
			}else if(memAccess==2) {
				pstmt = con.prepareStatement(EXCEPTION_LETTER_KOL);
			}

			pstmt.setString(1, memAccount);
			pstmt.setString(2, errorContent);
			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("EmailDetailDao.java errorLetter方法例外！");
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
	public List<EmailDetailVO> findMailBox(String mem_account) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EmailDetailVO> list = new ArrayList<>();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_MAIL_BOX);
			pstmt.setString(1, mem_account);
			pstmt.setString(2, mem_account);
			pstmt.setString(3, mem_account);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmailDetailVO emailDetailVO = new EmailDetailVO();
				emailDetailVO.setEmail_title(rs.getString("EMAIL_TITLE"));
				emailDetailVO.setEmail_content(rs.getString("EMAIL_CONTENT"));
				emailDetailVO.setEmail_num(rs.getInt("EMAIL_NUM"));
				emailDetailVO.setSender(rs.getString("SENDER"));
				emailDetailVO.setEmail_date(rs.getObject("EMAIL_DATE", Timestamp.class));
				list.add(emailDetailVO);
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
	
	

}
