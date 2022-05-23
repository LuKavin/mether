package com.kolfavorite.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.companymeb.model.CompanyMebVO;
import com.google.gson.Gson;
import com.kolfavorite.model.KolFavorVO;
import com.kolmeb.model.KolMebVO;

@WebServlet("/getComMebInfo.do")
public class getMebinfo extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	Connection con;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
//			TestVO testVO = new TestVO();
//			List<TestVO> testVOs = new ArrayList<>();
			
			List list = new ArrayList<>();
			String INSERT_STMT = "INSERT INTO `KOL_FAVORITE` (`COM_IDNUM`, `KOL_IDNUM`)" + "VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(INSERT_STMT);
			
//			ps.setInt(1, kol_idnum);
//			ps.setInt(2, com_idnum);
			String status =  request.getParameter("status");
			System.out.println(status);
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
//				KolMebVO.setKol_idnum(rs.getInt("KOL_IDNUM"));
//				companyMebVO.setCom_idnum(rs.getInt("COM_IDNUM"));
//				companyMebVO.setCom_name(rs.getString("COM_NAME"));
//				companyMebVO.setCom_email(rs.getString("COM_EMAIL"));
//				companyMebVO.setCom_phone(rs.getString("COM_PHONE"));
//				companyMebVO.setCom_website(rs.getString("COM_WEBSITE"));
				
			}
			Gson gson = new Gson();
//			String json = gson.toJson(companyMebVO);
//			out.print(json);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			DataSource dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/DBmether");
			con = dataSource.getConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (NamingException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void destroy() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}
