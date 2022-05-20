package com.order_master.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.companymeb.model.CompanyMebVO;
import com.order_master.model.OrderMasterService;
import com.order_master.model.OrderMasterVO;
@WebFilter(
urlPatterns = {"/comBackStage/order/order.jsp",
               "/comBackStage/order/orderComTurnOne.jsp",
               "/comBackStage/order/orderComTurnTwo.jsp",
               "/comBackStage/order/orderComTurnThree.jsp",
               "/comBackStage/order/orderComfinal.jsp"})

public class OrderFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		//取得登入者資料
		CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");
		Integer order_num = new Integer(req.getParameter("order_num"));
		OrderMasterService orderMasterService = new OrderMasterService();
		OrderMasterVO orderMasterVO = orderMasterService.getOneOrderMaster(order_num);
		
		
		
		List<String> filterErrorMsgs = new LinkedList<String>();
		req.setAttribute("filterErrorMsgs", filterErrorMsgs);
		
		
		switch (orderMasterVO.getOrder_status()) {
		case "製作中":
			req.getRequestDispatcher("/comBackStage/order/orderComTurnOne.jsp").forward(req, res);
			break;
		case "審核中":
			req.getRequestDispatcher("/comBackStage/order/orderComTurnTwo.jsp").forward(req, res);
			break;
		case "評價中":
			req.getRequestDispatcher("/comBackStage/order/orderComTurnThree.jsp").forward(req, res);
			break;
		case "交易完成":
			req.getRequestDispatcher("/comBackStage/order/orderComfinal.jsp").forward(req, res);
			break;
		default:
			filterErrorMsgs.add("商品狀態 : 結束狀態");
			req.getRequestDispatcher("/comBackStage/order/orderList.jsp").forward(req, res);
			
		}
		
		
		
		
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	public void destroy() {
	}

}
