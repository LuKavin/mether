package com.hire_form.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.companymeb.model.CompanyMebVO;
import com.kolmeb.model.KolMebVO;
import com.match_form.model.MatchService;
import com.order_master.model.OrderMasterService;
import com.productType.model.ProductTypeService;
import com.productType.model.ProductTypeVO;

@WebServlet("/hireform/hire.do")
public class HireFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		CompanyMebVO companyMebVO = (CompanyMebVO) req.getSession().getAttribute("companyMebVO");
		
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				Integer product_num = new Integer(req.getParameter("product_num"));
				Integer kol_idnum = new Integer(req.getParameter("kol_idnum"));
				String order_status = "製作中";
				Integer order_amount = 500; 

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("comBackStage/hireform/applyjob.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				OrderMasterService orderMasterService = new OrderMasterService();
				orderMasterService.addOrderMaster(product_num, kol_idnum, companyMebVO.getCom_idnum(), order_status,order_amount );
				MatchService matchService = new MatchService();
				matchService.deleteMatchForm(kol_idnum, product_num);
				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "comBackStage/hireform/applyjob.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				System.out.println("noooooooooooo");
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("comBackStage/hireform/applyjob.jsp");
				failureView.forward(req, res);
			}
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ***************************************/
				Integer product_num = new Integer(req.getParameter("product_num"));

				/*************************** 2.開始刪除資料 ***************************************/
				MatchService matchService = new MatchService();
//				matchService.deleteMatchForm(kolMebVO.getKol_idnum(), product_num);
				/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
				String url = "/comBackStage/matchform/matchform.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				System.out.println("nooooooooo");
				errorMsgs.add("刪除資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/comBackStage/matchform/matchform.jsp");
				failureView.forward(req, res);
			}
		}

	}
}
