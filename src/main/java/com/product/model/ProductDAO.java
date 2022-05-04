package com.product.model;

import java.util.*;
import java.sql.*;
import java.sql.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class ProductDAO implements ProductDAO_interface{

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBmether");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO `PRODUCT` (`PRODUCT_TYPENUM`, `PRODUCT_NAME`, `PRODUCT_INTRODUCE`, `PRODUCT_LINK`, `PRODUCT_BUDGET`, `PRODUCT_COUNT`, `PRODUCT_CONTRACT`, `PRODUCT_DEADLINE`,`PRODUCT_STATE`,`COM_IDNUM`,`TEST_PIC`)" 
			+"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = 
		"SELECT product_num, product_typenum, product_name, product_introduce, product_link, product_budget, product_count, product_contract, product_deadline, product_date, product_state, test_pic, com_idnum  FROM PRODUCT";
	private static final String GET_ONE_STMT = 
		"SELECT product_num, product_typenum, product_name, product_introduce, product_link, product_budget, product_count, product_contract, product_deadline, product_date, product_state, test_pic, com_idnum  FROM PRODUCT where product_num = ?";
//	private static final String DELETE = 
//		"DELETE FROM JOB_TYPE where job_typenum = ?";
	private static final String UPDATE = 
			"update `PRODUCT` set `PRODUCT_TYPENUM` = ?, `PRODUCT_NAME` = ?, `PRODUCT_INTRODUCE` = ?, `PRODUCT_LINK` = ?, `PRODUCT_BUDGET` = ?, `PRODUCT_COUNT` = ?, `PRODUCT_CONTRACT` = ?, `PRODUCT_DEADLINE` = ?, `TEST_PIC` = ?, `PRODUCT_STATE` = ? where product_num = ?;"; 
	private static final String UPDATE2 = 
			"update `PRODUCT` set `PRODUCT_TYPENUM` = ?, `PRODUCT_NAME` = ?, `PRODUCT_INTRODUCE` = ?, `PRODUCT_LINK` = ?, `PRODUCT_BUDGET` = ?, `PRODUCT_COUNT` = ?, `PRODUCT_CONTRACT` = ?, `PRODUCT_DEADLINE` = ?, `PRODUCT_STATE` = ? where product_num = ?;"; 
	private static final String UPDATESTATE = 
			"UPDATE PRODUCT SET product_state = ? where product_num = ?";
	private static final String AllSTATE = 
			"UPDATE PRODUCT SET product_state = ? where COM_IDNUM = ?";
	


	@Override
	public int insert(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		int product_num = -1;

		try {
			con = ds.getConnection();
			String columns[] = { "product_num" };
			pstmt = con.prepareStatement(INSERT_STMT,columns);

			pstmt.setInt(1, productVO.getProduct_typenum());
			pstmt.setString(2, productVO.getProduct_name());
			pstmt.setString(3, productVO.getProduct_introduce());
			pstmt.setString(4, productVO.getProduct_link());
			pstmt.setInt(5, productVO.getProduct_budget());
			pstmt.setInt(6, productVO.getProduct_count());
			pstmt.setString(7, productVO.getProduct_contract());
			pstmt.setDate(8, productVO.getProduct_deadline());
			pstmt.setString(9, productVO.getProduct_state());
			pstmt.setInt(10, productVO.getCom_idnum());
			pstmt.setBytes(11, productVO.getTest_pic());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
			product_num = rs.getInt(1);
			}
			

			// Handle any SQL errors
		}catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return product_num;
	}
	
	
	@Override
	public void updateState(String product_state, Integer product_num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(UPDATESTATE);
			rs = pstmt.getResultSet();
			pstmt.setString(1, product_state);
			pstmt.setInt(2, product_num);
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void allState(String product_state, Integer com_num) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(AllSTATE);
			rs = pstmt.getResultSet();
			pstmt.setString(1, product_state);
			pstmt.setInt(2, com_num);
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void update(ProductVO productVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			con = ds.getConnection();
			//判斷updateProduct.jsp是否有要update照片
			if(productVO.getTest_pic()!=null) {
			pstmt = con.prepareStatement(UPDATE);//選擇沒有update照片的SQL
			pstmt.setInt(1, productVO.getProduct_typenum());
			pstmt.setString(2, productVO.getProduct_name());
			pstmt.setString(3, productVO.getProduct_introduce());
			pstmt.setString(4, productVO.getProduct_link());
			pstmt.setInt(5, productVO.getProduct_budget());
			pstmt.setInt(6, productVO.getProduct_count());
			pstmt.setString(7, productVO.getProduct_contract());
			pstmt.setDate(8, productVO.getProduct_deadline());
			pstmt.setBytes(9, productVO.getTest_pic());
			pstmt.setString(10, productVO.getProduct_state());
			pstmt.setInt(11, productVO.getProduct_num());
			
			
			}else if(productVO.getTest_pic()==null){
			pstmt = con.prepareStatement(UPDATE2);//有修改照片的SQL
			pstmt.setInt(1, productVO.getProduct_typenum());
			pstmt.setString(2, productVO.getProduct_name());
			pstmt.setString(3, productVO.getProduct_introduce());
			pstmt.setString(4, productVO.getProduct_link());
			pstmt.setInt(5, productVO.getProduct_budget());
			pstmt.setInt(6, productVO.getProduct_count());
			pstmt.setString(7, productVO.getProduct_contract());
			pstmt.setDate(8, productVO.getProduct_deadline());
			pstmt.setString(9, productVO.getProduct_state());
			pstmt.setInt(10, productVO.getProduct_num());
			}

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

	
//	@Override
//	public void delete(Integer jobTypeNum) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(DELETE);
//
//			pstmt.setInt(1, jobTypeNum);
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}

	@Override
	public ProductVO findByPrimaryKey(Integer product_typenum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ProductVO productVO =null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setInt(1, product_typenum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				productVO = new ProductVO();
				productVO.setProduct_name(rs.getString("product_name"));
				productVO.setProduct_introduce(rs.getString("product_introduce"));
				productVO.setProduct_link(rs.getString("product_link"));
				productVO.setProduct_budget(rs.getInt("product_budget"));
				productVO.setProduct_count(rs.getInt("product_count"));
				productVO.setProduct_contract(rs.getString("product_contract"));
				productVO.setProduct_deadline(rs.getObject("product_deadline",java.sql.Date.class));
				productVO.setProduct_state(rs.getString("product_state"));
				productVO.setProduct_typenum(rs.getInt("product_typenum"));
				productVO.setProduct_num(rs.getInt("product_num"));
			    productVO.setTest_pic(rs.getBytes("test_pic"));
				productVO.setCom_idnum(rs.getInt("com_idnum"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return productVO;
	}

	@Override
	public List<ProductVO> getAll() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO productVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productVO = new ProductVO();
				productVO.setProduct_name(rs.getString("product_name"));
				productVO.setProduct_introduce(rs.getString("product_introduce"));
				productVO.setProduct_link(rs.getString("product_link"));
				productVO.setProduct_budget(rs.getInt("product_budget"));
				productVO.setProduct_count(rs.getInt("product_count"));
				productVO.setProduct_contract(rs.getString("product_contract"));
				productVO.setProduct_deadline(rs.getObject("product_deadline",java.sql.Date.class));
				productVO.setProduct_state(rs.getString("product_state"));
				productVO.setProduct_typenum(rs.getInt("product_typenum"));
				productVO.setProduct_num(rs.getInt("product_num"));
			    productVO.setTest_pic(rs.getBytes("test_pic"));
				productVO.setCom_idnum(rs.getInt("com_idnum"));
				list.add(productVO);
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
