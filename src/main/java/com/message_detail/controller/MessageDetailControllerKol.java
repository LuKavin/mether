package com.message_detail.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.companymeb.model.CompanyMebService;
import com.companymeb.model.CompanyMebVO;
import com.kolmeb.model.KolMebVO;
import com.memberphoto.model.MemberPhotoService;
import com.memberphoto.model.MemberPhotoVO;
import com.message_detail.model.MessageDetailService;
import com.message_detail.model.MessageDetailVO;
import com.order_master.model.OrderMasterService;
import com.order_master.model.OrderMasterVO;

@WebServlet("/message/kolMessage.do")
@MultipartConfig()
public class MessageDetailControllerKol extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		String order_status = "";

		try {
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer order_num = new Integer(req.getParameter("order_num"));
			order_status = req.getParameter("order_status");
			Part part = req.getPart("mes_pic");
			long checkFile = part.getSize();
			String message = req.getParameter("message");
			if (message == null || message.trim().length() == 0) {
				errorMsgs.add("留言內容: 請勿空白");
			}
			String mes_topic = req.getParameter("mes_topic");
			if (mes_topic == null || mes_topic.trim().length() == 0) {
				errorMsgs.add("留言標題: 請勿空白");
			}
			InputStream in = part.getInputStream();
			byte[] mes_pic = new byte[in.available()];
			in.read(mes_pic);
			
			OrderMasterService orderMasterService = new OrderMasterService();
			OrderMasterVO orderMasterVO = orderMasterService.getOneOrderMaster(order_num);//取得該訂單資訊
			String com_account = orderMasterService.getComAccount(order_num);//取得該訂單廠商帳號
			String kol_account = orderMasterService.getKolAccount(order_num);//取得該訂單網紅帳號
			req.setAttribute("com_account", com_account);
			req.setAttribute("kol_account", kol_account);
			req.setAttribute("orderMasterVO", orderMasterVO);
			req.setAttribute("order_num", order_num);

			if (!errorMsgs.isEmpty()) {
				if("製作中".equals(order_status)) {
					req.getRequestDispatcher("/kolBackStage/order/orderKolTurnOne.jsp").forward(req, res);
				}else if("審核中".equals(order_status)) {
					req.getRequestDispatcher("/kolBackStage/order/orderKolTurnTwo.jsp").forward(req, res);
				}
				return;
			}

			MessageDetailVO messageDetailVO = new MessageDetailVO();
			messageDetailVO.setKol_message(message);
			messageDetailVO.setMes_topic(mes_topic);
			messageDetailVO.setOrder_num(order_num);
			if(checkFile>0) {//判斷是否有上傳圖片
				messageDetailVO.setMes_pic(mes_pic);
			}

			/*************************** 2.開始新增資料 ***************************************/
			MessageDetailService messageDetailService = new MessageDetailService();
			messageDetailService.kolAddMessage(messageDetailVO);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/

			if("製作中".equals(order_status)) {
				req.getRequestDispatcher("/kolBackStage/order/orderKolTurnOne.jsp").forward(req, res); // 新增成功後轉交companyPhotoIndexJsp2.jsp
			}else if("審核中".equals(order_status)) {
				req.getRequestDispatcher("/kolBackStage/order/orderKolTurnTwo.jsp").forward(req, res); // 新增成功後轉交companyPhotoIndexJsp2.jsp
			}

			/*************************** 其他可能的錯誤處理 **********************************/
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			if("製作中".equals(order_status)) {
				req.getRequestDispatcher("/kolBackStage/order/orderKolTurnOne.jsp").forward(req, res);
			}else if("審核中".equals(order_status)) {
				req.getRequestDispatcher("/kolBackStage/order/orderKolTurnTwo.jsp").forward(req, res);
			}
		}

	}
}