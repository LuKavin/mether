package com.companymeb.controller;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.companymeb.model.CompanyMebService;
import com.companymeb.model.CompanyMebVO;
import com.kolmeb.model.KolMebService;
import com.kolmeb.model.KolMebVO;


@WebServlet("/companymeb/CompanyMeb.do")
public class CompanyMebServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
//if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			try {
//				/***************************1.接收請求參數****************************************/
//				Integer com_idnum = new Integer(req.getParameter("com_idnum").trim());
//				
//				/***************************2.開始查詢資料****************************************/
//				CompanyMebService companyMebSvc = new CompanyMebService();
//				CompanyMebVO companyMebVO = companyMebSvc.getOneCompanyMeb(com_idnum);
//								
//				/***************************3.查詢完成,準備轉交(Send the Success view)************/
//				req.setAttribute("companyMebVO", companyMebVO);
//String url = "/update_platformType_input.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);
//				successView.forward(req, res);
//
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
//				RequestDispatcher failureView = req
//.getRequestDispatcher("/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
		
		
		
	if ("login".equals(action)) { // 來自companyMebJspLogin.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數*****************************************/
				String mem_account = req.getParameter("mem_account");
				String mem_password = req.getParameter("mem_password");
								
				/***************************2.開始驗證資料,驗證成功準備轉交****************************/
				CompanyMebService companyMebSvc = new CompanyMebService();
				CompanyMebVO companyMebVO = companyMebSvc.loginmeb(mem_account, mem_password);
				 
				if(companyMebVO != null) {
					req.getSession().setAttribute("companyMebVO", companyMebVO);
				String url = "/metherIndex.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交首頁
					successView.forward(req, res);
					return;
				}
			
				KolMebService kolMebSvc = new KolMebService();
				KolMebVO kolMebVO = kolMebSvc.loginmeb(mem_account, mem_password);
				
				if(kolMebVO != null) {
					req.getSession().setAttribute("kolMebVO", kolMebVO);
				String url = "/metherIndex.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交首頁
					successView.forward(req, res);
					return;
				}
				
				throw new Exception();

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("會員登入失敗，請重新輸入");
				RequestDispatcher failureView = req.getRequestDispatcher("/login/companyMebJspLogin.jsp");
				failureView.forward(req, res);
			}
		}
	
	
//	if ("logout".equals(action)) { 
//		
//			List<String> errorMsgs = new LinkedList<String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//		
//			try {
//				HttpSession session = req.getSession();
//				session.invalidate();
//				res.sendRedirect("/companyMebJspLogout2.jsp");
//								
//				} catch (Exception e) {
//				errorMsgs.add("會員登出失敗，請重新操作");
//			}
//		}
	
	
	if ("logout".equals(action)) { 
	
		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		HttpSession session = req.getSession();
		
		try {
			if((session.getAttribute("companyMebVO")) != null) {
			String url = "/logout/companyMebJspLogout2.jsp";
			session.invalidate();
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			return;
			}
	
			if((session.getAttribute("kolMebVO")) != null) {
			String url = "/logout/companyMebJspLogout2.jsp";
			session.invalidate();
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			return;
			}
		
			RequestDispatcher failureView = req.getRequestDispatcher("/logout/companyMebJspLogoutfail.jsp");
			failureView.forward(req, res);
						
			} catch (Exception e) {
			errorMsgs.add("會員登出失敗，請重新操作");
			}
		}
		
		
	if ("update".equals(action)) { // 來自companyMebJsp3.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer com_idnum = new Integer(req.getParameter("com_idnum").trim());
				String com_account = req.getParameter("com_account");
				String com_password = req.getParameter("com_password");
				String com_email = req.getParameter("com_email");
				String com_phone = req.getParameter("com_phone");
				String com_cellphone = req.getParameter("com_cellphone");
				String com_address = req.getParameter("com_address");
				String com_website = req.getParameter("com_website");
				java.sql.Date com_birthday = null;
				try {
					com_birthday = java.sql.Date.valueOf(req.getParameter("com_birthday"));
				} catch (IllegalArgumentException e) {
					com_birthday = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請填入日期");
				}
				String com_gender = req.getParameter("com_gender");
				String com_id = req.getParameter("com_id");
				String com_bankcode = req.getParameter("com_bankcode");
				String com_bankaccount = req.getParameter("com_bankaccount");
				String com_name = req.getParameter("com_name");
				String com_introduce = req.getParameter("com_introduce");
				java.sql.Date com_founddate = null;
				try {
					com_founddate = java.sql.Date.valueOf(req.getParameter("com_founddate"));
				} catch (IllegalArgumentException e) {
					com_founddate = new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請填入日期");
				}
				String com_taxidnum = req.getParameter("com_taxidnum");
				
				/*==============================廠商密碼驗證==============================*/
				String com_passwordReg = "^[(a-zA-Z0-9)]{8,15}$";
				if (com_password == null || com_password.trim().length() == 0) {
					errorMsgs.add("廠商密碼: 請勿空白");
				} else if(!com_password.trim().matches(com_passwordReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商密碼: 只能是英文字母和數字 , 且長度必需在8到15之間");
	            }
				
				/*==============================廠商信箱驗證==============================*/
				String com_emailReg = "^[(a-zA-Z0-9@.)]+{50}$";
				if (com_email == null || com_email.trim().length() == 0) {
					errorMsgs.add("廠商信箱: 請勿空白");
				} else if(!com_email.trim().matches(com_emailReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商信箱: 請勿輸入中文 , 且格式需包含@");
	            }
				
				/*==============================廠商名稱驗證==============================*/
				String com_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,20}$";
				if (com_name == null || com_name.trim().length() == 0) {
					errorMsgs.add("廠商名稱: 請勿空白");
				} else if(!com_name.trim().matches(com_nameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商名稱: 請勿輸入符號 , 且長度必需在20以內");
	            }
				
				/*==============================廠商市話驗證==============================*/
				String com_phoneReg = "^0[0-9]{8,9}$";
				if (com_phone == null || com_phone.trim().length() == 0) {
					errorMsgs.add("廠商市話: 請勿空白");
				} else if(!com_phone.trim().matches(com_phoneReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商市話: 只能是數字 , 需輸入區碼且長度必需在9到10之間");
	            }
				
				/*==============================廠商手機驗證==============================*/
				String com_cellphoneReg = "^09[0-9]{8}$";
				if (com_cellphone == null || com_cellphone.trim().length() == 0) {
					errorMsgs.add("廠商手機: 請勿空白");
				} else if(!com_cellphone.trim().matches(com_cellphoneReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商手機: 只能是數字 , 且長度必需為10");
	            }
				
				/*==============================廠商地址驗證==============================*/
				String com_addressReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,50}$";
				if (com_address == null || com_address.trim().length() == 0) {
					errorMsgs.add("廠商地址: 請勿空白");
				} else if(!com_address.trim().matches(com_addressReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商地址: 請勿輸入符號 , 且長度必需在50以內");
	            }
				
				/*==============================廠商身分證驗證==============================*/
				String com_idReg = "^[A-Z]{1}[0-9]{9}$";
				if (com_id == null || com_id.trim().length() == 0) {
					errorMsgs.add("廠商身分證: 請勿空白");
				} else if(!com_id.trim().matches(com_idReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商身分證: 只能是英文字母及數字 , 首字需為英文大寫且長度為10");
	            }
				
				/*==============================廠商銀行代碼驗證==============================*/
				String com_bankcodeReg = "^[0-9]{1,3}$";
				if (com_bankcode == null || com_bankcode.trim().length() == 0) {
					errorMsgs.add("廠商銀行代碼: 請勿空白");
				} else if(!com_bankcode.trim().matches(com_bankcodeReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商銀行代碼: 只能是數字 , 且長度為3");
	            }
				
				/*==============================廠商銀行帳號驗證==============================*/
				String com_bankaccountReg = "^[0-9]{1,20}$";
				if (com_bankaccount == null || com_bankaccount.trim().length() == 0) {
					errorMsgs.add("廠商銀行帳號: 請勿空白");
				} else if(!com_bankaccount.trim().matches(com_bankaccountReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商銀行帳號: 只能是數字 , 且長度為20以內");
	            }
								
				/*==============================廠商統一編號驗證==============================*/
				String com_taxidnumReg = "^[0-9]{1,12}$";
				if (com_taxidnum == null || com_taxidnum.trim().length() == 0) {
					errorMsgs.add("廠商統一編號: 請勿空白");
				} else if(!com_taxidnum.trim().matches(com_taxidnumReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商統一編號: 只能是數字 , 且長度為12以內");
	            }
				
				CompanyMebVO companyMebVO = new CompanyMebVO();
				companyMebVO.setCom_idnum(com_idnum);
				companyMebVO.setCom_account(com_account);
				companyMebVO.setCom_password(com_password);
				companyMebVO.setCom_email(com_email);
				companyMebVO.setCom_phone(com_phone);
				companyMebVO.setCom_cellphone(com_cellphone);
				companyMebVO.setCom_address(com_address);
				companyMebVO.setCom_website(com_website);
				companyMebVO.setCom_birthday(com_birthday);
				companyMebVO.setCom_gender(com_gender);
				companyMebVO.setCom_id(com_id);
				companyMebVO.setCom_bankcode(com_bankcode);
				companyMebVO.setCom_bankaccount(com_bankaccount);
				companyMebVO.setCom_name(com_name);
				companyMebVO.setCom_introduce(com_introduce);
				companyMebVO.setCom_founddate(com_founddate);
				companyMebVO.setCom_taxidnum(com_taxidnum);
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("companyMebVO", companyMebVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/comBackStage/companymeb/companyMebJspTwo.jsp");
					failureView.forward(req, res);
					return;
				}				
				
				/***************************2.開始修改資料*****************************************/
				CompanyMebService companyMebSvc = new CompanyMebService();
				companyMebSvc.updateCompanyMeb(companyMebVO);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.getSession().setAttribute("companyMebVO", companyMebVO);

				String url = "/comBackStage/companymeb/companyMebJspThree.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交首頁
				successView.forward(req, res);	

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/comBackStage/companymeb/companyMebJspTwo.jsp");
				failureView.forward(req, res);
			}
		}
	

	if ("insert".equals(action)) { // 來自companyMebJsp2.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			CompanyMebVO companyMebVO = new CompanyMebVO();

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String com_account = req.getParameter("com_account");		
				String com_password = req.getParameter("com_password");
				String com_email = req.getParameter("com_email");
//				String com_phone = req.getParameter("com_phone");
//				String com_cellphone = req.getParameter("com_cellphone");
//				String com_address = req.getParameter("com_address");
//				String com_website = req.getParameter("com_website");
//				java.sql.Date com_birthday = null;
//				try {
//					com_birthday = java.sql.Date.valueOf(req.getParameter("com_birthday"));
//				} catch (IllegalArgumentException e) {
//					com_birthday = new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請填入日期");
//				}
//				String com_gender = req.getParameter("com_gender");
//				String com_id = req.getParameter("com_id");
//				String com_bankcode = req.getParameter("com_bankcode");
//				String com_bankaccount = req.getParameter("com_bankaccount");
				String com_name = req.getParameter("com_name");
//				String com_introduce = req.getParameter("com_introduce");
//				java.sql.Date com_founddate = null;
//				try {
//					com_founddate = java.sql.Date.valueOf(req.getParameter("com_founddate"));
//				} catch (IllegalArgumentException e) {
//					com_founddate = new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請填入日期");
//				}
//				String com_taxidnum = req.getParameter("com_taxidnum");
				
				
				/*==============================廠商帳號驗證==============================*/
				String com_accountReg = "^[(a-zA-Z0-9)]{6,12}$";
				if (com_account == null || com_account.trim().length() == 0) {
					errorMsgs.add("廠商帳號: 請勿空白");
				} else if(!com_account.trim().matches(com_accountReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商帳號: 只能是英文字母和數字 , 且長度必需在6到12之間");
	            } 

				/*==============================廠商密碼驗證==============================*/
				String com_passwordReg = "^[(a-zA-Z0-9)]{8,15}$";
				if (com_password == null || com_password.trim().length() == 0) {
					errorMsgs.add("廠商密碼: 請勿空白");
				} else if(!com_password.trim().matches(com_passwordReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商密碼: 只能是英文字母和數字 , 且長度必需在8到15之間");
	            }

				/*==============================廠商信箱驗證==============================*/
				String com_emailReg = "^[(a-zA-Z0-9@.)]+{50}$";
				if (com_email == null || com_email.trim().length() == 0) {
					errorMsgs.add("廠商信箱: 請勿空白");
				} else if(!com_email.trim().matches(com_emailReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商信箱: 請勿輸入中文 , 且格式需包含@");
	            }
				
				/*==============================廠商名稱驗證==============================*/
				String com_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,20}$";
				if (com_name == null || com_name.trim().length() == 0) {
					errorMsgs.add("廠商名稱: 請勿空白");
				} else if(!com_name.trim().matches(com_nameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("廠商名稱: 請勿輸入符號 , 且長度必需在20以內");
	            }
				
				/*==============================廠商市話驗證==============================*/
//				String com_phoneReg = "^0[0-9]{8,9}$";
//				if (com_phone == null || com_phone.trim().length() == 0) {
//					errorMsgs.add("廠商市話: 請勿空白");
//				} else if(!com_phone.trim().matches(com_phoneReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("廠商市話: 只能是數字 , 需輸入區碼且長度必需在9到10之間");
//	            }

				
				/*==============================廠商手機驗證==============================*/
//				String com_cellphoneReg = "^09[0-9]{8}$";
//				if (com_cellphone == null || com_cellphone.trim().length() == 0) {
//					errorMsgs.add("廠商手機: 請勿空白");
//				} else if(!com_cellphone.trim().matches(com_cellphoneReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("廠商手機: 只能是數字 , 且長度必需為10");
//	            }

				
				/*==============================廠商地址驗證==============================*/
//				String com_addressReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{50}$";
//				if (com_address == null || com_address.trim().length() == 0) {
//					errorMsgs.add("廠商地址: 請勿空白");
//				} else if(!com_address.trim().matches(com_addressReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("廠商地址: 只能是中文、英文字母及數字");
//	            }

				
				/*==============================廠商身分證驗證==============================*/
//				String com_idReg = "^[A-Z]{1}[0-9]{9}$";
//				if (com_id == null || com_id.trim().length() == 0) {
//					errorMsgs.add("廠商身分證: 請勿空白");
//				} else if(!com_id.trim().matches(com_idReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("廠商身分證: 只能是英文字母及數字 , 首字需為英文大寫且長度為10");
//	            }

				
				/*==============================廠商銀行代碼驗證==============================*/
//				String com_bankcodeReg = "^[0-9]{3}$";
//				if (com_bankcode == null || com_bankcode.trim().length() == 0) {
//					errorMsgs.add("廠商銀行代碼: 請勿空白");
//				} else if(!com_bankcode.trim().matches(com_bankcodeReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("廠商銀行代碼: 只能是數字 , 且長度為3");
//	            }

				
				/*==============================廠商銀行帳號驗證==============================*/
//				String com_bankaccountReg = "^[0-9]{20}$";
//				if (com_bankaccount == null || com_bankaccount.trim().length() == 0) {
//					errorMsgs.add("廠商銀行帳號: 請勿空白");
//				} else if(!com_bankaccount.trim().matches(com_bankaccountReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("廠商銀行帳號: 只能是數字 , 且長度為20以內");
//	            }

				
				/*==============================廠商介紹驗證==============================*/
//				String com_introduceReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1000}$";
//				if (com_introduce == null || com_introduce.trim().length() == 0) {
//					errorMsgs.add("廠商介紹: 請勿空白");
//				} else if(!com_introduce.trim().matches(com_introduceReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("廠商介紹: 只能是中文、英文字母及數字 , 且長度為1000以內");
//	            }

				
				/*==============================廠商統一編號驗證==============================*/
//				String com_taxidnumReg = "^[0-9]{12}$";
//				if (com_taxidnum == null || com_taxidnum.trim().length() == 0) {
//					errorMsgs.add("廠商統一編號: 請勿空白");
//				} else if(!com_taxidnum.trim().matches(com_taxidnumReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("廠商統一編號: 只能是數字 , 且長度為12以內");
//	            }

				
				companyMebVO.setCom_account(com_account);
				companyMebVO.setCom_password(com_password);
				companyMebVO.setCom_email(com_email);
//				companyMebVO.setCom_phone(com_phone);
//				companyMebVO.setCom_cellphone(com_cellphone);
//				companyMebVO.setCom_address(com_address);
//				companyMebVO.setCom_website(com_website);
//				companyMebVO.setCom_birthday(com_birthday);
//				companyMebVO.setCom_gender(com_gender);
//				companyMebVO.setCom_id(com_id);
//				companyMebVO.setCom_bankcode(com_bankcode);
//				companyMebVO.setCom_bankaccount(com_bankaccount);
				companyMebVO.setCom_name(com_name);
//				companyMebVO.setCom_introduce(com_introduce);
//				companyMebVO.setCom_founddate(com_founddate);
//				companyMebVO.setCom_taxidnum(com_taxidnum);
				
				CompanyMebService companyMebSvc = new CompanyMebService();
				companyMebSvc.checkCompanyMeb(com_account);
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("companyMebVO", companyMebVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/comBackStage/companymeb/companyMebJsp2.jsp");
					failureView.forward(req, res);
					return;
				}				
				
				/***************************2.開始新增資料***************************************/
				int com_idnum = companyMebSvc.addCompanyMeb(companyMebVO);
				companyMebVO.setCom_idnum(com_idnum);
				req.setAttribute("companyMebVO", companyMebVO);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				req.getSession().setAttribute("companyMebVO", companyMebVO);
				String url = "/comBackStage/companymeb/companyMebJspThree.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
	            } catch (Exception e) {
	            req.setAttribute("companyMebVO", companyMebVO);
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/comBackStage/companymeb/companyMebJsp2.jsp");
				failureView.forward(req, res);
			}
		}
		
		
//if ("delete".equals(action)) { // 來自listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//			try {
//				/***************************1.接收請求參數***************************************/
//				Integer com_idnum = new Integer(req.getParameter("com_idnum").trim());
//				
//				/***************************2.開始刪除資料***************************************/
//				CompanyMebService companyMebSvc = new CompanyMebService();
//				companyMebSvc.deleteCompanyMeb(com_idnum);
//				
//				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
//String url = "/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//				successView.forward(req, res);
//				
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("刪除資料失敗:"+e.getMessage());
//				RequestDispatcher failureView = req
//.getRequestDispatcher("/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
	}

}
