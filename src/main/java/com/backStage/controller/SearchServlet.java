package com.backStage.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@MultipartConfig
@WebServlet("/serch.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		// 網紅搜尋
		if ("getSearch".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 ****************************************/
				String search = new String(req.getParameter("search"));
				/*************************** 2.開始查詢資料 ****************************************/
				BackStageService backStageMebService = new BackStageService();
				List list = backStageMebService.getKolSearch(search);
				List list1 = backStageMebService.getComSearch(search);
				List list2 = backStageMebService.getProductSearch(search);
				/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
				req.setAttribute("list", list);
				req.setAttribute("list1", list1);
				req.setAttribute("list2", list2);
				if (!list.isEmpty() || !list1.isEmpty() || !list2.isEmpty()) {
					String url = "/search/Search.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
				} else if (list.isEmpty() && list1.isEmpty() && list2.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/search/SearchFail.jsp");
					failureView.forward(req, res);
				}

				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/search/SearchFail.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
