package com.skillType.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class SkillTypeDAO implements SkillTypeDAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO SKILL_TYPE (SKILL_TYPENAME) VALUES (?)";
	private static final String GET_ALL_STMT = "SELECT SKILL_TYPENUM,SKILL_TYPENAME FROM SKILL_TYPE order by SKILL_TYPENUM";
	private static final String GET_ONE_STMT = "SELECT SKILL_TYPENUM,SKILL_TYPENAME FROM SKILL_TYPE where SKILL_TYPENUM = ?";
	private static final String UPDATE = "UPDATE SKILL_TYPE set SKILL_TYPENAME=? where SKILL_TYPENUM = ?";

	@Override
	public void insert(SkillTypeVO skillTypeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, skillTypeVO.getSkill_typename());

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

	@Override
	public void update(SkillTypeVO skillTypeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, skillTypeVO.getSkill_typename());
			pstmt.setInt(2, skillTypeVO.getSkill_typenum());

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


	@Override
	public SkillTypeVO findByPrimaryKey(Integer skill_typenum) {
		SkillTypeVO skillTypeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, skill_typenum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo ???]???????? Domain objects
				
				skillTypeVO = new SkillTypeVO();
				skillTypeVO.setSkill_typenum(rs.getInt("skill_typenum"));
				skillTypeVO.setSkill_typename(rs.getString("skill_typename"));
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
		return skillTypeVO;
	}

	@Override
	public List<SkillTypeVO> getAll() {
		List<SkillTypeVO> list = new ArrayList<SkillTypeVO>();
		SkillTypeVO skillTypeVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO ???]???????? Domain objects
				skillTypeVO = new SkillTypeVO();
				skillTypeVO.setSkill_typenum(rs.getInt("skill_typenum"));
				skillTypeVO.setSkill_typename(rs.getString("skill_typename"));
				list.add(skillTypeVO); // Store the row in the list
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
