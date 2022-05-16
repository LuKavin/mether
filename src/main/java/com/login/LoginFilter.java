package com.login;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
@WebFilter(
urlPatterns = {"/comBackStage/email/*"}
)
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		LoginVo loginVo = (LoginVo) session.getAttribute("loginVo");
		if(loginVo!=null) {
			chain.doFilter(request, response);
		}else {
		    session.setAttribute("preURL", req.getRequestURI()); 
			RequestDispatcher successView = req.getRequestDispatcher("/login.jsp");
			successView.forward(req, res);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	public void destroy() {
	}

}
