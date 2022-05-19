package com.order_master.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.product.model.*;
import com.productType.model.ProductTypeService;

@WebServlet("/order/order.do")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		String preURL =(String)session.getAttribute("preURL");

		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		
		//如果點登出鍵進來這
		if("signOut".equals(action)) {
			req.getSession().invalidate();
			String url = "/login.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			return;
		}

		try {
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String mebAccount = req.getParameter("mebAccount");
			String mebPassword = req.getParameter("mebPassword");
			/*************************** 2.開始新增資料 ***************************************/
//			LonginService longinService = new LonginService();
//			LoginVo loginVo = longinService.login(mebAccount, mebPassword);//去資料庫確認帳號密碼，並把找到的使用者資料存VO
			
			
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//			req.getSession().setAttribute("companyMebVO", loginVo);
	        if (preURL != null) {
	            session.removeAttribute("preURL");   //*工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
	            res.sendRedirect(preURL);            
	            return;
	        }else {
	            session.removeAttribute("preURL");   
	            res.sendRedirect("/mether/login.jsp");            
	            return;
	        }
			/*************************** 其他可能的錯誤處理 **********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher failureView = req.getRequestDispatcher("登入失敗");
			failureView.forward(req, res);
		}

	}

}
