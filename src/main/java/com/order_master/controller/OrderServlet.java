package com.order_master.controller;

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

import com.order_master.model.OrderMasterService;
import com.order_master.model.OrderMasterVO;
import com.product.model.*;
import com.productType.model.ProductTypeService;

@WebServlet("/order/orderCom.do")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		if("checkOK".equals(action)) {
			
//			List<String> errorMsgs = new LinkedList<String>();
//			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				Integer order_num =  new Integer(req.getParameter("order_num"));
		
				/*************************** 2.開始新增資料 ***************************************/
				OrderMasterService orderMasterService =new OrderMasterService();
				//找出該筆VO
				OrderMasterVO orderMasterVO =  orderMasterService.getOneOrderMaster(order_num);
				//更改狀態
				orderMasterVO.setOrder_status("評價中");
				//更新
				orderMasterService.updateOrderMaster(orderMasterVO);
				
				/*************************** 3.新增完成,準備轉交***********/
				req.setAttribute("order_num", order_num);
				req.getRequestDispatcher("/comBackStage/order/orderComTurnThree.jsp").forward(req, res);
				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				RequestDispatcher failureView = req.getRequestDispatcher("登入失敗");
				failureView.forward(req, res);
			}
		}
		
		if("rateOK".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				Integer order_num =  new Integer(req.getParameter("order_num"));
				String kol_rate =  req.getParameter("kol_rate");
				Integer kol_star =  new Integer(req.getParameter("kol_star"));
				/*************************** 2.開始新增資料 ***************************************/
				OrderMasterService orderMasterService =new OrderMasterService();
				//找出該筆VO
				OrderMasterVO orderMasterVO =  orderMasterService.getOneOrderMaster(order_num);
				//更改狀態
				if(orderMasterVO.getCom_star() !=0 && orderMasterVO.getCom_rate() !=null) {
					orderMasterVO.setOrder_status("交易完成");
				}
				orderMasterVO.setKol_rate(kol_rate);
				orderMasterVO.setKol_star(kol_star);
				
				//更新
				orderMasterService.updateOrderMaster(orderMasterVO);
				
				/*************************** 3.新增完成,準備轉交***********/
				req.setAttribute("order_num", order_num);
				req.getRequestDispatcher("/comBackStage/order/orderWaitForRate.jsp").forward(req, res);
				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				RequestDispatcher failureView = req.getRequestDispatcher("登入失敗");
				failureView.forward(req, res);
			}
		}

	}

}
