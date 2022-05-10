package com.email.controller;

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

import com.emailDetail.model.EmailDetailService;
import com.emailDetail.model.EmailDetailVO;
import com.login.LoginVo;
import com.mysql.cj.Session;
import com.product.model.*;
import com.productType.model.ProductTypeService;


@MultipartConfig()
@WebServlet("/email/email.do")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		LoginVo loginVo =(LoginVo)req.getSession().getAttribute("loginVo");
		
		
		if ("showletter".equals(action)) { // 來自listAllEmp.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer email_num = new Integer(req.getParameter("email_num"));
				
				/***************************2.開始查詢資料****************************************/
				EmailDetailService emailDetailService = new EmailDetailService();
				EmailDetailVO emailDetailVO = emailDetailService.getOneLetter(email_num);
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("emailDetailVO", emailDetailVO);
				String url = "/email/letter.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/email/Email.jsp啥");
				failureView.forward(req, res);
			}
		}


        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			EmailDetailService emailDetailService = new EmailDetailService();
			
			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String mem_account = req.getParameter("mem_account");//收件人
				Integer mem_access = emailDetailService.findMemAccess(mem_account);//1=廠商,2=網紅
				if (mem_access == null) {
					errorMsgs.add("帳號輸入錯誤,沒有此會員帳號");
				}
				if (mem_account == null || mem_account.trim().length() == 0) {
					errorMsgs.add("收件人: 請勿空白");
				}
				String email_content = req.getParameter("email_content");
				if (email_content == null || email_content.trim().length() == 0 || "<p><br></p>".equals(email_content)) {
					errorMsgs.add("信件內容: 請勿空白");
				}
				
				Integer email_typenum = 1;//信件類別,先寫死
				
				String email_title = req.getParameter("email_title");
				if (email_title == null || email_title.trim().length() == 0) {
					errorMsgs.add("信件標題: 請勿空白");
				}
				
				EmailDetailVO emailDetailVO =new EmailDetailVO();
				if(mem_access==1) {//1=廠商,2=網紅
				emailDetailVO.setCom_account(mem_account);
				}else if(mem_access==2) {
				emailDetailVO.setKol_account(mem_account);
				}
				emailDetailVO.setEmail_typenum(email_typenum);
				emailDetailVO.setEmail_title(email_title);
				emailDetailVO.setEmail_content(email_content);
				emailDetailVO.setSender(loginVo.getMebAccount());//寄件人
//				emailDetailVO.setSender("tibameKOL");//寄件人登入還沒做好先寫死
				
				
				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("productVO", productVO);
//					fileContent.close();
					RequestDispatcher failureView = req
							.getRequestDispatcher("/email/sendEmail.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				emailDetailService.send(emailDetailVO);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				fileContent.close();
//				req.setAttribute("productVO", productVO);
				String url = "/email/Email.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
//				fileContent.close();
				RequestDispatcher failureView = req
						.getRequestDispatcher("/email/sendEmail.jsp");
				failureView.forward(req, res);
			}
		}
        
		if ("delete".equals(action)) { // 來自listAllEmp.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				String[] email_nums =req.getParameterValues("deletePk");
				
				/***************************2.開始查詢資料****************************************/
				EmailDetailService emailDetailService = new EmailDetailService();
				Integer email_num;
				for(int i=0; i<email_nums.length; i++) {
					email_num = new Integer(email_nums[i]);
					emailDetailService.deleteLetter(email_num);
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String url = "/email/Email.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/email/Email.jsp");
				failureView.forward(req, res);
			}
		}
        
        
        
        
        
        
	}
}
