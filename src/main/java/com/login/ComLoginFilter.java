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

import com.companymeb.model.CompanyMebVO;
@WebFilter(
urlPatterns = {"/comBackStage/email/*",
		       "/comBackStage/product/*",
               "/comBackStage/order/*"})
public class ComLoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");
		if(companyMebVO!=null) {
			chain.doFilter(request, response);
		}else {
		    session.setAttribute("preURL", req.getRequestURI()); 
			RequestDispatcher successView = req.getRequestDispatcher("/login/companyMebJspLogin.jsp");
			successView.forward(req, res);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	public void destroy() {
	}

}
