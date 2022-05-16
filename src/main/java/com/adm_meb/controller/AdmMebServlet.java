package com.adm_meb.controller;

import java.io.*;

import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.adm_meb.model.*;
import com.adm_meb.model.AdmMebService;
import com.adm_meb.model.AdmMebVO;
@MultipartConfig
public class AdmMebServlet extends HttpServlet { 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String str = req.getParameter("adm_idnum");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入管理員編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/adm_meb/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				Integer adm_idnum = null;
				try {
					adm_idnum = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("管理員編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/adm_meb/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 2.開始查詢資料 *****************************************/
				AdmMebService admMebSvc = new AdmMebService();
				AdmMebVO admMebVO = admMebSvc.getOneAdmMeb(adm_idnum);
				if (admMebVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/adm_meb/select_page.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("admMebVO", admMebVO); // 資料庫取出的empVO物件,存入req
				String url = "/adm_meb/listOneAdmMeb.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/select_page.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/*************************** 1.接收請求參數 ****************************************/
				Integer adm_idnum = new Integer(req.getParameter("adm_idnum"));

				/*************************** 2.開始查詢資料 ****************************************/
				AdmMebService admMebSvc = new AdmMebService();
				AdmMebVO admMebVO = admMebSvc.getOneAdmMeb(adm_idnum);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("admMebVO", admMebVO); // 資料庫取出的empVO物件,存入req
				String url = "/adm_meb/update_AdmMeb_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/adm_meb/listAllAdmMeb.jsp?adm_idnum=");
				failureView.forward(req, res);
			}
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				Integer adm_idnum = new Integer(req.getParameter("adm_idnum").trim());

				String adm_name = req.getParameter("adm_name");
				String adm_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (adm_name == null || adm_name.trim().length() == 0) {
					errorMsgs.add("管理員姓名: 請勿空白");
				} else if (!adm_name.trim().matches(adm_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("管理員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				String adm_account = req.getParameter("adm_account").trim();
				if (adm_account == null || adm_account.trim().length() == 0) {
					errorMsgs.add("帳號請勿空白");
				}
				
				String adm_password = req.getParameter("adm_password").trim();
				if (adm_password == null || adm_password.trim().length() == 0) {
					errorMsgs.add("密碼請勿空白");
				}
				
				Part part = req.getPart("adm_photo");
				InputStream in = part.getInputStream();
				AdmMebService admMebSvc = new AdmMebService();
				byte[] adm_photo = null;
				if (in.available() > 0) {
					adm_photo = new byte[in.available()];
					in.read(adm_photo);
				} else {
					AdmMebVO admMebVO = admMebSvc.getOneAdmMeb(adm_idnum);
					adm_photo = admMebVO.getAdm_photo();
				}

				AdmMebVO admMebVO = new AdmMebVO();
				admMebVO.setAdm_idnum(adm_idnum);
				admMebVO.setAdm_name(adm_name);
				admMebVO.setAdm_account(adm_account);
				admMebVO.setAdm_password(adm_password);
				admMebVO.setAdm_photo(adm_photo);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("admMebVO", admMebVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/adm_meb/update_Adm_Meb_input.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				AdmMebService adm_MebSvc = new AdmMebService();
				admMebVO = adm_MebSvc.updateAdmMeb(adm_idnum, adm_account, adm_password, adm_name, adm_photo);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("admMebVO", admMebVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/adm_meb/listOneAdmMeb.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/adm_meb/update_AdmMeb_input.jsp");
				failureView.forward(req, res);
			}
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

				String adm_name = req.getParameter("adm_name");
				String adm_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (adm_name == null || adm_name.trim().length() == 0) {
					errorMsgs.add("管理員姓名: 請勿空白");
				} else if (!adm_name.trim().matches(adm_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("管理員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				String adm_account = req.getParameter("adm_account").trim();
				if (adm_account == null || adm_account.trim().length() == 0) {
					errorMsgs.add("帳號請勿空白");
				}
				
				String adm_password = req.getParameter("adm_password").trim();
				if (adm_password == null || adm_password.trim().length() == 0) {
					errorMsgs.add("密碼請勿空白");
				}
				
				Part part = req.getPart("adm_photo");
				InputStream in = part.getInputStream();
				byte[] adm_photo = new byte[in.available()];
				in.read(adm_photo);

				AdmMebVO admMebVO = new AdmMebVO();
				admMebVO.setAdm_name(adm_name);
				admMebVO.setAdm_account(adm_account);
				admMebVO.setAdm_password(adm_password);
				admMebVO.setAdm_photo(adm_photo);
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("admMebVO", admMebVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/adm_meb/addAdmMeb.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				AdmMebService admMebSvc = new AdmMebService();
				admMebVO = admMebSvc.addAdmMeb(adm_account, adm_password, adm_name, adm_photo);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/adm_meb/listAllAdmMeb.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/adm_meb/addAdmMeb.jsp");
				failureView.forward(req, res);
			}
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ***************************************/
				Integer adm_idnum = new Integer(req.getParameter("adm_idnum"));

				/*************************** 2.開始刪除資料 ***************************************/
				AdmMebService admMebSvc = new AdmMebService();
				admMebSvc.deleteAdmMeb(adm_idnum);

				/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
				String url = "/adm_meb/listAllAdmMeb.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/adm_meb/listAllAdmMeb.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
