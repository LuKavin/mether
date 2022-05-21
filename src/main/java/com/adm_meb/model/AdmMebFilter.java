package com.adm_meb.model;

import java.io.IOException;

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

@WebFilter(urlPatterns = { "/backStage/*" })
public class AdmMebFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		AdmMebVO admMebVO = (AdmMebVO) session.getAttribute("admMebVO");
		if (admMebVO != null) {
			chain.doFilter(request, response);
		} else {
			session.setAttribute("preURL", req.getRequestURI());
			RequestDispatcher successView = req.getRequestDispatcher("admLogin.jsp");
			successView.forward(req, res);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

}
