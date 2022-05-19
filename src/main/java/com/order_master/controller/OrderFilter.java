//package com.order_master.controller;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.companymeb.model.CompanyMebVO;
//import com.order_master.model.OrderMasterService;
////@WebFilter(
////urlPatterns = {"/comBackStage/email/*", "/comBackStage/product/*"}
////)
//public class OrderFilter implements Filter {
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//		HttpSession session = req.getSession();
//		//取得登入者資料
//		CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");
//		String order_num = req.getParameter("ORDER_NUM");
//		OrderMasterService orderMasterService = new OrderMasterService();
//		orderMasterService.
//		
//		
//		
//		
//		
//		
//		
//		
//	}
//
//	public void init(FilterConfig fConfig) throws ServletException {
//	}
//	public void destroy() {
//	}
//
//}
