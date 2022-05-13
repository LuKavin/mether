package com.memberaccess.model;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemberAccessDAO implements MemberAccessDAO_interface {
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
				"INSERT INTO MEMBER_ACCESS (MEB_ACCESS) VALUES (?)";
		
		private static final String GET_ALL_STMT = 
				"SELECT MEB_ACCESSNUM, MEB_ACCESS FROM MEMBER_ACCESS order by MEB_ACCESSNUM";
		
		private static final String GET_ONE_STMT = 
				"SELECT MEB_ACCESSNUM, MEB_ACCESS FROM MEMBER_ACCESS where MEB_ACCESSNUM = ?";
		
		private static final String DELETE = 
				"DELETE FROM MEMBER_ACCESS where MEB_ACCESSNUM = ?";
		
		private static final String UPDATE =
				"UPDATE MEMBER_ACCESS set MEB_ACCESS=? where MEB_ACCESSNUM = ?";

		
		@Override
		public void insert(MemberAccessVO memberAccessVO) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);
				pstmt.setString(1, memberAccessVO.getMeb_access());
				pstmt.executeUpdate();
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

		}
		

		@Override
		public void update(MemberAccessVO memberAccessVO) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);
				pstmt.setString(1, memberAccessVO.getMeb_access());
				pstmt.setInt(2, memberAccessVO.getMeb_accessnum());
				pstmt.executeUpdate();
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
		}
		

		@Override
		public void delete(Integer meb_accessnum) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);
				pstmt.setInt(1, meb_accessnum);
				pstmt.executeUpdate();
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

		}
		

		@Override
		public MemberAccessVO findByPrimaryKey(Integer meb_accessnum) {
			MemberAccessVO memberAccessVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);
				pstmt.setInt(1, meb_accessnum);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					memberAccessVO = new MemberAccessVO();
					memberAccessVO.setMeb_accessnum(rs.getInt("meb_accessnum"));
					memberAccessVO.setMeb_access(rs.getString("meb_access"));
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
			return memberAccessVO;
		}
		

		@Override
		public List<MemberAccessVO> getAll() {
			List<MemberAccessVO> list = new ArrayList<MemberAccessVO>();
			MemberAccessVO memberAccessVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					memberAccessVO = new MemberAccessVO();
					memberAccessVO.setMeb_accessnum(rs.getInt("meb_accessnum"));
					memberAccessVO.setMeb_access(rs.getString("meb_access"));
					list.add(memberAccessVO); 
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
