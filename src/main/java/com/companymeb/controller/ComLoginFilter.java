package com.companymeb.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(urlPatterns = {"/comBackStage/companymeb/companyPhotoIndexJspTwo.jsp",
						  "/comBackStage/companymeb/companyPhotoAddJspTwo.jsp",
						  "/comBackStage/companymeb/companyPhotoUpdateJspTwo.jsp",
						  "/comBackStage/companymeb/companyMebJspThree.jsp",
						  "/comBackStage/companymeb/comAboutJsp.jsp"})
public class ComLoginFilter implements Filter {

		private FilterConfig config;

		public void init(FilterConfig config) {
			this.config = config;
		}

		public void destroy() {
			config = null;
		}

		public void doFilter(ServletRequest request, ServletResponse response, 
				FilterChain chain) throws ServletException, IOException {

			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			// 【取得 session】
			HttpSession session = req.getSession();
			// 【從 session 判斷此user是否登入過】
			Object companyMebVO = session.getAttribute("companyMebVO");
			Object kolMebVO = session.getAttribute("kolMebVO");
			if (companyMebVO == null) {
				if(kolMebVO != null) {
					System.out.println("in");					
					req.getRequestDispatcher("/kolBackStage/kolmeb/kolMebJspThree.jsp").forward(req, res);
					return;					
				}
				session.setAttribute("location", req.getRequestURI());
				res.sendRedirect(req.getContextPath() + "/login/companyMebJspLogin.jsp");
				return;
			} else {
				chain.doFilter(request, response);
		}
	}
}