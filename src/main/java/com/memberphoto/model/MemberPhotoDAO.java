package com.memberphoto.model;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberPhotoDAO implements MemberPhotoDAO_interface{

		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}

		private static final String INSERT_STMT = 
				"INSERT INTO MEMBER_PHOTO (MEB_PHOTO, COM_IDNUM, KOL_IDNUM) VALUES (?, ?, ?)";
		
		private static final String GET_ALL_STMT = 
				"SELECT MEB_PHOTONUM, MEB_PHOTO, COM_IDNUM, KOL_IDNUM FROM MEMBER_PHOTO order by MEB_PHOTONUM";
		
		private static final String GET_ONE_STMT = 
				"SELECT MEB_PHOTONUM, MEB_PHOTO, COM_IDNUM, KOL_IDNUM FROM MEMBER_PHOTO where MEB_PHOTONUM = ?";
		
		private static final String DELETE = 
				"DELETE FROM MEMBER_PHOTO where MEB_PHOTONUM = ?";

		
		@Override
		public int insert(MemberPhotoVO memberPhotoVO) {
			Connection con = null;
			PreparedStatement pstmt = null;
			int meb_photonum;
			try {
				con = ds.getConnection();
				int[] col = {1};
				pstmt = con.prepareStatement(INSERT_STMT,col);
				pstmt.setBytes(1, memberPhotoVO.getMeb_photo());
				pstmt.setInt(2, memberPhotoVO.getCom_idnum());
				pstmt.setInt(3, memberPhotoVO.getKol_idnum());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				meb_photonum = rs.getInt(1);
			} catch (SQLException se) {
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
			return meb_photonum;
		}
		

//		@Override
//		public void delete(Integer meb_photonum) {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			try {
//				con = ds.getConnection();
//				pstmt = con.prepareStatement(DELETE);
//				pstmt.setInt(1, meb_photonum);
//				pstmt.executeUpdate();
//			} catch (SQLException se) {
//				throw new RuntimeException("A database error occured." + se.getMessage());
//			} finally {
//				if (pstmt != null) {
//					try {
//						pstmt.close();
//					} catch (SQLException se) {
//						se.printStackTrace(System.err);
//					}
//				}
//				if (con != null) {
//					try {
//						con.close();
//					} catch (Exception e) {
//						e.printStackTrace(System.err);
//					}
//				}
//			}
//
//		}
		

		@Override
		public MemberPhotoVO findByPrimaryKey(Integer meb_photonum) {
			MemberPhotoVO memberPhotoVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);
				pstmt.setInt(1, meb_photonum);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					memberPhotoVO = new MemberPhotoVO();
					memberPhotoVO.setMeb_photonum(rs.getInt("meb_photonum"));
					memberPhotoVO.setMeb_photo(rs.getBytes("meb_photo"));
					memberPhotoVO.setCom_idnum(rs.getInt("com_idnum"));
					memberPhotoVO.setKol_idnum(rs.getInt("kol_idnum"));
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
			return memberPhotoVO;
		}


		@Override
		public List<MemberPhotoVO> getAll() {
			List<MemberPhotoVO> list = new ArrayList<MemberPhotoVO>();
			MemberPhotoVO memberPhotoVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					memberPhotoVO = new MemberPhotoVO();
					memberPhotoVO.setMeb_photonum(rs.getInt("meb_photonum"));
					memberPhotoVO.setMeb_photo(rs.getBytes("meb_photo"));
					memberPhotoVO.setCom_idnum(rs.getInt("com_idnum"));
					memberPhotoVO.setKol_idnum(rs.getInt("kol_idnum"));
					list.add(memberPhotoVO); 
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
}
