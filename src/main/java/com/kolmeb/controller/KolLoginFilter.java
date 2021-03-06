package com.kolmeb.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(urlPatterns = {"/kolBackStage/kolmeb/kolPhotoIndexJspTwo.jsp",
		                  "/kolBackStage/kolmeb/kolPhotoAddJspTwo.jsp",
		                  "/kolBackStage/kolmeb/kolPhotoUpdateJspTwo.jsp",
		                  "/kolBackStage/kolmeb/kolMebJspThree.jsp",
		                  "/kolBackStage/kolmeb/kolAboutJsp.jsp"})
public class KolLoginFilter implements Filter {

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
			Object account = session.getAttribute("kolMebVO");
			if (account == null) {
				session.setAttribute("location", req.getRequestURI());
				res.sendRedirect(req.getContextPath() + "/login/companyMebJspLogin.jsp");
				return;
			} else {
				chain.doFilter(request, response);
		}
	}
}