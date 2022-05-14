package com.platformType.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.platformType.model.PlatformTypeService;
import com.platformType.model.PlatformTypeVO;

@WebServlet("/PlatformTypeServlet")
public class PlatformTypeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

//		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//				String str = req.getParameter("platfrom_typenum");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("請輸入平台編號");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req.getRequestDispatcher("/platformType/AllplatformType.jsp");
//					failureView.forward(req, res);
//					return;// 程式中斷
//				}
//
//				Integer platform_typenum = null;
//				try {
//					platform_typenum = new Integer(str);
//				} catch (Exception e) {
//					errorMsgs.add("平台編號格式不正確");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req.getRequestDispatcher("/platformType/AllplatformType.jsp");
//					failureView.forward(req, res);
//					return;// 程式中斷
//				}
//
//				/*************************** 2.開始查詢資料 *****************************************/
//				PlatformTypeService platformTypeService = new PlatformTypeService();
//				PlatformTypeVO platformTypeVO = platformTypeService.getOnePlatformType(platform_typenum);
//				if (platformTypeVO == null) {
//					errorMsgs.add("查無資料");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req.getRequestDispatcher("/platformType/AllplatformType.jsp");
//					failureView.forward(req, res);
//					return;// 程式中斷
//				}
//
//				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//				req.setAttribute("platformTypeVO", platformTypeVO); // 資料庫取出的empVO物件,存入req
//				String url = "/platformType/AllPlatformType.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//				successView.forward(req, res);
//
//				/*************************** 其他可能的錯誤處理 *************************************/
//			} catch (Exception e) {
//				errorMsgs.add("無法取得資料:" + e.getMessage());
//				RequestDispatcher failureView = req.getRequestDispatcher("/platformType/AllplatformType.jsp");
//				failureView.forward(req, res);
//			}
//		}
//
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ****************************************/
				Integer platform_typenum = new Integer(req.getParameter("platform_typenum"));//form 裡面的name
				/*************************** 2.開始查詢資料 ****************************************/
				PlatformTypeService platformTypeService = new PlatformTypeService();
				PlatformTypeVO platformTypeVO = platformTypeService.getOnePlatformType(platform_typenum);
				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("platformTypeVO", platformTypeVO); // 資料庫取出的empVO物件,存入req
				String url = "/platformType/update_platformType.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/platformType/AllplatformType.jsp");
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
				Integer platform_typenum = new Integer(req.getParameter("platform_typenum").trim());

				String platform_typename = req.getParameter("platform_typename");
				String platform_typenameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (platform_typename == null || platform_typename.trim().length() == 0) {
					errorMsgs.add("平台類別名稱: 請勿空白");
				} else if (!platform_typename.trim().matches(platform_typenameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("平台類別名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}


				PlatformTypeVO platformTypeVO = new PlatformTypeVO();
				platformTypeVO.setPlatform_typenum(platform_typenum);
				platformTypeVO.setPlatform_typename(platform_typename);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("platformTypeVO", platformTypeVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req.getRequestDispatcher("/platformType/update_platformType.jsp");
					failureView.forward(req, res);
					return; // 程式中斷
				}

				/*************************** 2.開始修改資料 *****************************************/
				PlatformTypeService platformTypeService = new PlatformTypeService();
				platformTypeVO = platformTypeService.updatePlatformType(platformTypeVO );

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
//				req.setAttribute("platformTypeVO", platformTypeVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/platformType/AllplatformType.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/platformType/AllplatformType.jsp");
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
				String platform_typename = req.getParameter("platform_typename");
				String platform_typenameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (platform_typename == null || platform_typename.trim().length() == 0) {
					errorMsgs.add("平台類別名稱: 請勿空白");
				} else if (!platform_typename.trim().matches(platform_typenameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("平台類別名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/platformType/AllplatformType.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				
				PlatformTypeService platformTypeService = new PlatformTypeService();
				platformTypeService.addPlatformType(platform_typename);

				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/platformType/AllplatformType.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/platformType/AllplatformType.jsp");
				failureView.forward(req, res);
			}
		}

	}
}
