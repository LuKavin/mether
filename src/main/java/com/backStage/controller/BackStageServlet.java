package com.backStage.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backStage.model.BackStageService;
import com.companymeb.model.CompanyMebService;
import com.companymeb.model.CompanyMebVO;
import com.kolmeb.model.KolMebService;
import com.kolmeb.model.KolMebVO;

@MultipartConfig
@WebServlet("/backStage/backStage.do")
public class BackStageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOneCom".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ****************************************/
				Integer com_idnum = new Integer(req.getParameter("com_idnum"));

				/*************************** 2.開始查詢資料 ****************************************/
				CompanyMebService companyMebService = new CompanyMebService();
				CompanyMebVO companyMebVO = companyMebService.getOneCompanyMeb(com_idnum);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("companyMebVO", companyMebVO);
				String url = "/backStage/company_profile.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/backStage/meb_com.jsp");
				failureView.forward(req, res);
			}
		}

		if ("getOneKol".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ****************************************/
				Integer kol_idnum = new Integer(req.getParameter("kol_idnum"));

				/*************************** 2.開始查詢資料 ****************************************/
				KolMebService kolMebService = new KolMebService();
				KolMebVO kolMebVO = kolMebService.getOneKolMeb(kol_idnum);

				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("kolMebVO", kolMebVO);
				String url = "/backStage/kol_profile.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/backStage/meb_kol.jsp");
				failureView.forward(req, res);
			}
		}

		if ("ComUpdate4".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				Integer com_idnum = new Integer(req.getParameter("com_idnum"));

				/*************************** 2.開始修改資料 *****************************************/
				BackStageService backStageSvc = new BackStageService();
				backStageSvc.updateComAccess(4, com_idnum);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				String url = "/backStage/meb_com.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/backStage/meb_com.jsp");
				failureView.forward(req, res);
			}
		}
		if ("ComUpdate1".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				Integer com_idnum = new Integer(req.getParameter("com_idnum"));

				/*************************** 2.開始修改資料 *****************************************/
				BackStageService backStageSvc = new BackStageService();
				backStageSvc.updateComAccess(1, com_idnum);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				String url = "/backStage/meb_com.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/backStage/meb_com.jsp");
				failureView.forward(req, res);
			}
		}

		if ("KolUpdate4".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				Integer kol_idnum = new Integer(req.getParameter("kol_idnum"));

				/*************************** 2.開始修改資料 *****************************************/
				BackStageService backStageSvc = new BackStageService();
				backStageSvc.updateKolAccess(4, kol_idnum);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				String url = "/backStage/meb_kol.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/backStage/meb_kol.jsp");
				failureView.forward(req, res);
			}
		}
		if ("KolUpdate2".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				Integer kol_idnum = new Integer(req.getParameter("kol_idnum"));

				/*************************** 2.開始修改資料 *****************************************/
				BackStageService backStageSvc = new BackStageService();
				backStageSvc.updateKolAccess(2, kol_idnum);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				String url = "/backStage/meb_kol.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/backStage/meb_kol.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("OrderUpdateDown".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				Integer order_num = new Integer(req.getParameter("order_num"));

				/*************************** 2.開始修改資料 *****************************************/
				BackStageService backStageSvc = new BackStageService();
				backStageSvc.updateOrderMasterStatus("下架", order_num);

				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				String url = "/backStage/meb_orderlist.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/backStage/meb_orderlist.jsp");
				failureView.forward(req, res);
			}
		}

	}
}
