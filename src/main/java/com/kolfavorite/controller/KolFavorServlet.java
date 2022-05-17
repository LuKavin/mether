package com.kolfavorite.controller;

<<<<<<< HEAD
public class KolFavorServlet {

}
=======
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

import com.companyfavorite.model.ComFavorService;
import com.kolfavorite.model.KolFavorService;
import com.kolmeb.model.KolMebVO;

@MultipartConfig()
@WebServlet("/kolfavor/kolfavor.do")
public class KolFavorServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
 
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		KolMebVO kolMebVO = (KolMebVO) req.getSession().getAttribute("kolMebVO");
//		System.out.println(kolMebVO);
		if ("like".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				Integer com_idnum = new Integer(req.getParameter("com_idnum")) ;
//				Integer kol_idnum = new Integer(req.getParameter("kol_idnum")) ;
//				Integer kol_idnum = 1 ;
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/kolFavor/listcom.jsp");
					failureView.forward(req, res); 
					return; // 程式中斷
				}

				/*************************** 2.開始新增資料 ***************************************/
				KolFavorService kolFavorService = new KolFavorService();
				kolFavorService.addKolFavorite(kolMebVO.getKol_idnum(), com_idnum);
				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/kolFavor/listcom.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/kolFavor/listcom.jsp");
				failureView.forward(req, res);
			}
		}

		
		if ("dislike".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.接收請求參數***************************************/
				Integer com_idnum = new Integer(req.getParameter("com_idnum")) ;
//				Integer kol_idnum = new Integer(req.getParameter("kol_idnum")) ;
				/***************************2.開始刪除資料***************************************/
				KolFavorService kolFavorService = new KolFavorService();
				kolFavorService.addKolFavorite(kolMebVO.getKol_idnum(), com_idnum);
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/kolFavor/listcom.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/kolFavor/listcom.jsp");
				failureView.forward(req, res);
			}
		}

	}

}

>>>>>>> alanyu
