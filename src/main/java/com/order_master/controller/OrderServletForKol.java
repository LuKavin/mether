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

@MultipartConfig()
@WebServlet("/order/orderKol.do")
public class OrderServletForKol extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if("rateOK".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				Integer order_num =  new Integer(req.getParameter("order_num"));
				String com_rate =  req.getParameter("com_rate");
				Integer com_star =  new Integer(req.getParameter("com_star"));
				/*************************** 2.開始新增資料 ***************************************/
				OrderMasterService orderMasterService =new OrderMasterService();
				//找出該筆VO
				OrderMasterVO orderMasterVO =  orderMasterService.getOneOrderMaster(order_num);
				//更改狀態
				if(orderMasterVO.getKol_star() !=0 && orderMasterVO.getKol_rate() !=null) {
					orderMasterVO.setOrder_status("交易完成");
				}
				orderMasterVO.setCom_rate(com_rate);
				orderMasterVO.setCom_star(com_star);
				
				//更新
				orderMasterService.updateOrderMaster(orderMasterVO);
				
				/*************************** 3.新增完成,準備轉交***********/
				req.setAttribute("order_num", order_num);
				req.getRequestDispatcher("/kolBackStage/order/orderWaitForRate.jsp").forward(req, res);
				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				RequestDispatcher failureView = req.getRequestDispatcher("登入失敗");
				failureView.forward(req, res);
			}
		}
		
		if("orderContentOK".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
				Integer order_num =  new Integer(req.getParameter("order_num"));
				String orderLink =  req.getParameter("orderLink");
				if(orderLink==null || orderLink.trim().isEmpty()) {
					errorMsgs.add("網址列請勿空白");
				}
				if (!orderLink.trim().matches(orderLink)) {
					errorMsgs.add("網址格式錯誤");
	            }
				String orderContent =  req.getParameter("orderContent");
				
				Part orderFile =  req.getPart("orderFile");
				InputStream is = orderFile.getInputStream();
				byte[] fileByte = new byte[is.available()];
				is.read(fileByte);
				
				/*************************** 2.開始新增資料 ***************************************/
				OrderMasterService orderMasterService =new OrderMasterService();
				//找出該筆VO
				OrderMasterVO orderMasterVO =  orderMasterService.getOneOrderMaster(order_num);
				//更改狀態
				orderMasterVO.setOrder_status("審核中");
				orderMasterVO.setOrder_content(orderContent);
				orderMasterVO.setOrder_link(orderLink);
				orderMasterVO.setOrder_pic(fileByte);
				//更新
				orderMasterService.updateOrderMaster(orderMasterVO);
				/*************************** 3.新增完成,準備轉交***********/
				req.setAttribute("order_num", order_num);
				req.getRequestDispatcher("/kolBackStage/order/orderKolTurnTwo.jsp").forward(req, res);
				/*************************** 其他可能的錯誤處理 **********************************/
			} catch (Exception e) {
				RequestDispatcher failureView = req.getRequestDispatcher("登入失敗");
				failureView.forward(req, res);
			}
		}
	}

}
