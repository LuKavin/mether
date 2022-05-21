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
urlPatterns = {"/kolBackStage/order/order.jsp",
               "/kolBackStage/order/orderComTurnOne.jsp",
               "/kolBackStage/order/orderComTurnTwo.jsp",
               "/kolBackStage/order/orderComTurnThree.jsp",
               "/kolBackStage/order/orderComfinal.jsp"
})

public class OrderFilterForKol implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		//取得登入者資料
		CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");
		
		Integer order_num = new Integer(req.getParameter("order_num"));//根據點擊的訂單抓出PK
		
		OrderMasterService orderMasterService = new OrderMasterService();
		
		OrderMasterVO orderMasterVO = orderMasterService.getOneOrderMaster(order_num);//取得該訂單資訊
		String com_account = orderMasterService.getComAccount(order_num);//取得該訂單廠商帳號
		String kol_account = orderMasterService.getKolAccount(order_num);//取得該訂單網紅帳號
		req.setAttribute("order_num", order_num);
		req.setAttribute("com_account", com_account);
		req.setAttribute("kol_account", kol_account);
		
		
		List<String> filterErrorMsgs = new LinkedList<String>();
		req.setAttribute("filterErrorMsgs", filterErrorMsgs);
		
		
		switch (orderMasterVO.getOrder_status()) {
		case "製作中":
			req.getRequestDispatcher("/kolBackStage/order/orderKolTurnOne.jsp").forward(req, res);
			break;
		case "審核中":
			req.getRequestDispatcher("/kolBackStage/order/orderKolTurnTwo.jsp").forward(req, res);
			break;
		case "評價中":
			if(orderMasterVO.getCom_rate()!=null && orderMasterVO.getCom_star()!=0) {
				req.getRequestDispatcher("/kolBackStage/order/orderWaitForRate.jsp").forward(req, res);
			}else {
				req.getRequestDispatcher("/kolBackStage/order/orderKolTurnThree.jsp").forward(req, res);
			}
			break;
		case "交易完成":
			req.getRequestDispatcher("/kolBackStage/order/orderKolfinal.jsp").forward(req, res);
			break;
		default:
			
			req.getRequestDispatcher("/kolBackStage/order/order.jsp").forward(req, res);
			
		}
		
		
		
		
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	public void destroy() {
	}

}
