package com.kolmeb.controller;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kolmeb.model.KolMebService;
import com.kolmeb.model.KolMebVO;


@WebServlet("/kolmeb/KolMeb.do")
public class KolMebServlet extends HttpServlet{
	
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
//				List<String> errorMsgs = new LinkedList<String>();
//				req.setAttribute("errorMsgs", errorMsgs);
//					
//				try {
//					/***************************1.接收請求參數****************************************/
//					Integer kol_idnum = new Integer(req.getParameter("kol_idnum").trim());
//						
//					/***************************2.開始查詢資料****************************************/
//					KolMebService kolMebSvc = new KolMebService();
//					KolMebVO kolMebVO = kolMebSvc.getOneKolMeb(kol_idnum);
//										
//					/***************************3.查詢完成,準備轉交(Send the Success view)************/
//					req.setAttribute("kolMebVO", kolMebVO);
//String url = "/update_platformType_input.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url);
//					successView.forward(req, res);
//
//					/***************************其他可能的錯誤處理**********************************/
//					} catch (Exception e) {
//					  errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
//					  RequestDispatcher failureView = req
//.getRequestDispatcher("/listAllEmp.jsp");
//					  failureView.forward(req, res);
//					}
//				}		
		
		
		if ("update".equals(action)) { // 來自kolMebJsp3.jsp的請求
			
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
		
				try {
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					Integer kol_idnum = new Integer(req.getParameter("kol_idnum").trim());
					String kol_account = req.getParameter("kol_account");
					String kol_password = req.getParameter("kol_password");
					String kol_email = req.getParameter("kol_email");
					String kol_phone = req.getParameter("kol_phone");
					String kol_cellphone = req.getParameter("kol_cellphone");
					String kol_address = req.getParameter("kol_address");
					String kol_website = req.getParameter("kol_website");
					java.sql.Date kol_birthday = null;
					try {
						kol_birthday = java.sql.Date.valueOf(req.getParameter("kol_birthday"));
					} catch (IllegalArgumentException e) {
						kol_birthday = new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("請填入日期");
					}
					String kol_gender = req.getParameter("kol_gender");
					String kol_id = req.getParameter("kol_id");
					String kol_bankcode = req.getParameter("kol_bankcode");
					String kol_bankaccount = req.getParameter("kol_bankaccount");
					String kol_name = req.getParameter("kol_name");
					String kol_location = req.getParameter("kol_location");
					String kol_height = req.getParameter("kol_height");
					String kol_weight = req.getParameter("kol_weight");
					String kol_style = req.getParameter("kol_style");
					String kol_experience = req.getParameter("kol_experience");
	
					/*==============================網紅密碼驗證==============================*/
					String kol_passwordReg = "^[(a-zA-Z0-9)]{8,15}$";
					if (kol_password == null || kol_password.trim().length() == 0) {
						errorMsgs.add("網紅密碼: 請勿空白");
					} else if(!kol_password.trim().matches(kol_passwordReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅密碼: 只能是英文字母和數字 , 且長度必需在8到15之間");
		            }
				
					/*==============================網紅信箱驗證==============================*/
					String kol_emailReg = "^[(a-zA-Z0-9@.)]+{50}$";
					if (kol_email == null || kol_email.trim().length() == 0) {
						errorMsgs.add("網紅信箱: 請勿空白");
					} else if(!kol_email.trim().matches(kol_emailReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅信箱: 請勿輸入中文 , 且格式需包含@");
		            }
				
					/*==============================網紅名稱驗證==============================*/
					String kol_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,20}$";
					if (kol_name == null || kol_name.trim().length() == 0) {
						errorMsgs.add("網紅名稱: 請勿空白");
					} else if(!kol_name.trim().matches(kol_nameReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅名稱: 請勿輸入符號 , 且長度必需在20以內");
		            }
					
					/*==============================網紅市話驗證==============================*/
					String kol_phoneReg = "^0[0-9]{8,9}$";
					if (kol_phone == null || kol_phone.trim().length() == 0) {
						errorMsgs.add("網紅市話: 請勿空白");
					} else if(!kol_phone.trim().matches(kol_phoneReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅市話: 只能是數字 , 需輸入區碼且長度必需在9到10之間");
		            }
					
					/*==============================網紅手機驗證==============================*/
					String kol_cellphoneReg = "^09[0-9]{8}$";
					if (kol_cellphone == null || kol_cellphone.trim().length() == 0) {
						errorMsgs.add("網紅手機: 請勿空白");
					} else if(!kol_cellphone.trim().matches(kol_cellphoneReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅手機: 只能是數字 , 且長度必需為10");
		            }
					
					/*==============================網紅地址驗證==============================*/
					String kol_addressReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,50}$";
					if (kol_address == null || kol_address.trim().length() == 0) {
						errorMsgs.add("網紅地址: 請勿空白");
					} else if(!kol_address.trim().matches(kol_addressReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅地址: 請勿輸入符號 , 且長度必需在50以內");
		            }
					
					/*==============================網紅身分證驗證==============================*/
					String kol_idReg = "^[A-Z]{1}[0-9]{9}$";
					if (kol_id == null || kol_id.trim().length() == 0) {
						errorMsgs.add("網紅身分證: 請勿空白");
					} else if(!kol_id.trim().matches(kol_idReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅身分證: 只能是英文字母及數字 , 首字需為英文大寫且長度為10");
		            }
					
					/*==============================網紅銀行代碼驗證==============================*/
					String kol_bankcodeReg = "^[0-9]{1,3}$";
					if (kol_bankcode == null || kol_bankcode.trim().length() == 0) {
						errorMsgs.add("網紅銀行代碼: 請勿空白");
					} else if(!kol_bankcode.trim().matches(kol_bankcodeReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅銀行代碼: 只能是數字 , 且長度為3");
		            }
					
					/*==============================網紅銀行帳號驗證==============================*/
					String kol_bankaccountReg = "^[0-9]{1,20}$";
					if (kol_bankaccount == null || kol_bankaccount.trim().length() == 0) {
						errorMsgs.add("網紅銀行帳號: 請勿空白");
					} else if(!kol_bankaccount.trim().matches(kol_bankaccountReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅銀行帳號: 只能是數字 , 且長度為20以內");
		            }
																			
					KolMebVO kolMebVO = new KolMebVO();
					kolMebVO.setKol_idnum(kol_idnum);
					kolMebVO.setKol_account(kol_account);
					kolMebVO.setKol_password(kol_password);
					kolMebVO.setKol_email(kol_email);
					kolMebVO.setKol_phone(kol_phone);
					kolMebVO.setKol_cellphone(kol_cellphone);
					kolMebVO.setKol_address(kol_address);
					kolMebVO.setKol_website(kol_website);
					kolMebVO.setKol_birthday(kol_birthday);
					kolMebVO.setKol_gender(kol_gender);
					kolMebVO.setKol_id(kol_id);
					kolMebVO.setKol_bankcode(kol_bankcode);
					kolMebVO.setKol_bankaccount(kol_bankaccount);
					kolMebVO.setKol_name(kol_name);
					kolMebVO.setKol_location(kol_location);
					kolMebVO.setKol_height(kol_height);
					kolMebVO.setKol_weight(kol_weight);
					kolMebVO.setKol_style(kol_style);
					kolMebVO.setKol_experience(kol_experience);
					
					if (!errorMsgs.isEmpty()) {
						req.setAttribute("kolMebVO", kolMebVO);
						RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/kolmeb/kolMebJsp3.jsp");
						failureView.forward(req, res);
						return;
					}				
					
					/***************************2.開始修改資料*****************************************/
					KolMebService kolMebSvc = new KolMebService();
					kolMebSvc.updateKolMeb(kolMebVO);
				
					/***************************3.修改完成,準備轉交(Send the Success view)*************/
					req.getSession().setAttribute("kolMebVO", kolMebVO);
					String url = "/metherIndex.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交首頁
					successView.forward(req, res);	

					/***************************其他可能的錯誤處理*************************************/
				} catch (Exception e) {
					errorMsgs.add("修改資料失敗:"+e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/kolmeb/kolMebJsp3.jsp");
					failureView.forward(req, res);
				}
			}	
		
		
		if ("insert".equals(action)) { // 來自kolMebJsp2.jsp的請求  
			
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				KolMebVO kolMebVO = new KolMebVO();
	
				try {
					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					String kol_account = req.getParameter("kol_account");
					String kol_password = req.getParameter("kol_password");
					String kol_email = req.getParameter("kol_email");
//				    String kol_phone = req.getParameter("kol_phone");
//				    String kol_cellphone = req.getParameter("kol_cellphone");
//				    String kol_address = req.getParameter("kol_address");
//				    String kol_website = req.getParameter("kol_website");
//				    java.sql.Date kol_birthday = null;
//				    try {
//					    kol_birthday = java.sql.Date.valueOf(req.getParameter("kol_birthday"));
//				    } catch (IllegalArgumentException e) {
//					    kol_birthday = new java.sql.Date(System.currentTimeMillis());
//					    errorMsgs.add("請填入日期");
//				    }
//				    String kol_gender = req.getParameter("kol_gender");
//				    String kol_id = req.getParameter("kol_id");
//				    String kol_bankcode = req.getParameter("kol_bankcode");
//				    String kol_bankaccount = req.getParameter("kol_bankaccount");
				    String kol_name = req.getParameter("kol_name");
//				    String kol_location = req.getParameter("kol_location");				    
//				    String kol_height = req.getParameter("kol_height");
//				    String kol_weight = req.getParameter("kol_weight");
//				    String kol_style = req.getParameter("kol_style");
//				    String kol_experience = req.getParameter("kol_experience");
				
				
				    /*==============================網紅帳號驗證==============================*/
				    String kol_accountReg = "^[(a-zA-Z0-9)]{6,12}$";
				    if (kol_account == null || kol_account.trim().length() == 0) {
					errorMsgs.add("網紅帳號: 請勿空白");
				    } else if(!kol_account.trim().matches(kol_accountReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("網紅帳號: 只能是英文字母和數字 , 且長度必需在6到12之間");
	                } 
	
					/*==============================網紅密碼驗證==============================*/
					String kol_passwordReg = "^[(a-zA-Z0-9)]{8,15}$";
					if (kol_password == null || kol_password.trim().length() == 0) {
						errorMsgs.add("網紅密碼: 請勿空白");
					} else if(!kol_password.trim().matches(kol_passwordReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅密碼: 只能是英文字母和數字 , 且長度必需在8到15之間");
		            }
				
					/*==============================網紅信箱驗證==============================*/
					String kol_emailReg = "^[(a-zA-Z0-9@.)]+{50}$";
					if (kol_email == null || kol_email.trim().length() == 0) {
						errorMsgs.add("網紅信箱: 請勿空白");
					} else if(!kol_email.trim().matches(kol_emailReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅信箱: 請勿輸入中文 , 且格式需包含@");
		            }
				
					/*==============================網紅名稱驗證==============================*/
					String kol_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,20}$";
					if (kol_name == null || kol_name.trim().length() == 0) {
						errorMsgs.add("網紅名稱: 請勿空白");
					} else if(!kol_name.trim().matches(kol_nameReg)) { //以下練習正則(規)表示式(regular-expression)
						errorMsgs.add("網紅名稱: 請勿輸入符號 , 且長度必需在20以內");
		            }
					
					/*==============================網紅市話驗證==============================*/
//					String kol_phoneReg = "^0[0-9]{8,9}$";
//					if (kol_phone == null || kol_phone.trim().length() == 0) {
//						errorMsgs.add("網紅市話: 請勿空白");
//					} else if(!kol_phone.trim().matches(kol_phoneReg)) { //以下練習正則(規)表示式(regular-expression)
//						errorMsgs.add("網紅市話: 只能是數字 , 需輸入區碼且長度必需在9到10之間");
//		            }
					
					/*==============================網紅手機驗證==============================*/
//					String kol_cellphoneReg = "^09[0-9]{8}$";
//					if (kol_cellphone == null || kol_cellphone.trim().length() == 0) {
//						errorMsgs.add("網紅手機: 請勿空白");
//					} else if(!kol_cellphone.trim().matches(kol_cellphoneReg)) { //以下練習正則(規)表示式(regular-expression)
//						errorMsgs.add("網紅手機: 只能是數字 , 且長度必需為10");
//		            }
					
					/*==============================網紅地址驗證==============================*/
//					String kol_addressReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{1,50}$";
//					if (kol_address == null || kol_address.trim().length() == 0) {
//						errorMsgs.add("網紅地址: 請勿空白");
//					} else if(!kol_address.trim().matches(kol_addressReg)) { //以下練習正則(規)表示式(regular-expression)
//						errorMsgs.add("網紅地址: 請勿輸入符號 , 且長度必需在50以內");
//		            }
					
					/*==============================網紅身分證驗證==============================*/
//					String kol_idReg = "^[A-Z]{1}[0-9]{9}$";
//					if (kol_id == null || kol_id.trim().length() == 0) {
//						errorMsgs.add("網紅身分證: 請勿空白");
//					} else if(!kol_id.trim().matches(kol_idReg)) { //以下練習正則(規)表示式(regular-expression)
//						errorMsgs.add("網紅身分證: 只能是英文字母及數字 , 首字需為英文大寫且長度為10");
//		            }
				
					/*==============================網紅銀行代碼驗證==============================*/
//					String kol_bankcodeReg = "^[0-9]{1,3}$";
//					if (kol_bankcode == null || kol_bankcode.trim().length() == 0) {
//						errorMsgs.add("網紅銀行代碼: 請勿空白");
//					} else if(!kol_bankcode.trim().matches(kol_bankcodeReg)) { //以下練習正則(規)表示式(regular-expression)
//						errorMsgs.add("網紅銀行代碼: 只能是數字 , 且長度為3");
//		            }
					
					/*==============================網紅銀行帳號驗證==============================*/
//					String kol_bankaccountReg = "^[0-9]{1,20}$";
//					if (kol_bankaccount == null || kol_bankaccount.trim().length() == 0) {
//						errorMsgs.add("網紅銀行帳號: 請勿空白");
//					} else if(!kol_bankaccount.trim().matches(kol_bankaccountReg)) { //以下練習正則(規)表示式(regular-expression)
//						errorMsgs.add("網紅銀行帳號: 只能是數字 , 且長度為20以內");
//		            }

				
					kolMebVO.setKol_account(kol_account);
					kolMebVO.setKol_password(kol_password);
					kolMebVO.setKol_email(kol_email);
//				    kolMebVO.setKol_phone(kol_phone);
//				    kolMebVO.setKol_cellphone(kol_cellphone);
//				    kolMebVO.setKol_address(kol_address);
//				    kolMebVO.setKol_website(kol_website);
//				    kolMebVO.setKol_birthday(kol_birthday);
//				    kolMebVO.setKol_gender(kol_gender);
//				    kolMebVO.setKol_id(kol_id);
//				    kolMebVO.setKol_bankcode(kol_bankcode);
//				    kolMebVO.setKol_bankaccount(kol_bankaccount);
					kolMebVO.setKol_name(kol_name);
//				    kolMebVO.setKol_location(kol_location);
//				    kolMebVO.setKol_height(kol_height);
//				    kolMebVO.setKol_weight(kol_weight);
//				    kolMebVO.setKol_style(kol_style);
//				    kolMebVO.setKol_experience(kol_experience);
					
					KolMebService kolMebSvc = new KolMebService();
					kolMebSvc.checkKolMeb(kol_account);
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("kolMebVO", kolMebVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/kolmeb/kolMebJsp2.jsp");
					failureView.forward(req, res);
					return;
				}				
				
					/***************************2.開始新增資料***************************************/
					int kol_idnum = kolMebSvc.addKolMeb(kolMebVO);
					kolMebVO.setKol_idnum(kol_idnum);
					req.setAttribute("kolMebVO", kolMebVO);
					
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					req.getSession().setAttribute("kolMebVO", kolMebVO);
					String url = "/kolBackStage/kolmeb/kolMebJspThree.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
					successView.forward(req, res);				
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					req.setAttribute("kolMebVO", kolMebVO);
					errorMsgs.add(e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/kolmeb/kolMebJsp2.jsp");
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
//				Integer kol_idnum = new Integer(req.getParameter("kol_idnum").trim());
//						
//				/***************************2.開始刪除資料***************************************/
//				KolMebService kolMebSvc = new KolMebService();
//				kolMebSvc.deleteKolMeb(kol_idnum);
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
