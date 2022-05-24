package com.match_form.controller;

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
import com.jobType.model.JobService;
import com.kolmeb.model.KolMebVO;
import com.match_form.model.MatchService;
import com.productType.model.ProductTypeService;
import com.productType.model.ProductTypeVO;

@WebServlet("/matchform/match.do")
public class MatchFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		KolMebVO kolMebVO = (KolMebVO) req.getSession().getAttribute("kolMebVO");

		if ("update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				Integer product_typenum = new Integer(req.getParameter("product_typenum"));
				String product_typename = req.getParameter("product_typename");
				String product_typenameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (product_typename == null || product_typename.trim().length() == 0) {
					errorMsgs.add("商品類別: 請勿空白");
				} else if (!product_typename.trim().matches(product_typenameReg)) { // 以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("商品類別: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				}

				ProductTypeVO productTypeVO = new ProductTypeVO();
				productTypeVO.setProduct_typename(product_typename);
				productTypeVO.setProduct_typenum(product_typenum);

				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/productType/AllproductType.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				ProductTypeService productTypeService = new ProductTypeService();
				productTypeService.updateProductType(productTypeVO);
				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/productType/AllproductType.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/product/addProduct.jsp");
				failureView.forward(req, res);
			}
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				Integer product_num = new Integer(req.getParameter("product_num"));
			
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/matchform/jobview.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				MatchService matchService = new MatchService();

				matchService.addMatchForm(kolMebVO.getKol_idnum(), product_num);
				
				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/kolBackStage/matchform/jobview.jsp"; 
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/matchform/jobview.jsp");
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
				matchService.deleteMatchForm(kolMebVO.getKol_idnum(), product_num);
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
