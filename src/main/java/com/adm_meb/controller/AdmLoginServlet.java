package com.adm_meb.controller;

import java.io.IOException;
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

import com.adm_meb.model.AdmMebService;
import com.adm_meb.model.AdmMebVO;

@MultipartConfig
@WebServlet("/admLogin")
public class AdmLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		String preURL = (String) session.getAttribute("preURL");

		if ("login".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				String adm_account = req.getParameter("adm_account");
				String adm_password = req.getParameter("adm_password");

				AdmMebService admMebSvc = new AdmMebService();
				AdmMebVO admMebVO = admMebSvc.login(adm_account, adm_password);

				if (admMebVO != null) {
					req.getSession().setAttribute("admMebVO", admMebVO);
					String url = "/backStage/backStageIndex.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
					return;
				}

				throw new Exception();

			} catch (Exception e) {
				errorMsgs.add("會員登入失敗，請重新輸入");
				RequestDispatcher failureView = req.getRequestDispatcher("admLogin.jsp");
				failureView.forward(req, res);
			}
		}

		if ("logout".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				if ((session.getAttribute("admMebVO")) != null) {
					String url = "admLogin.jsp";
					session.invalidate();
					RequestDispatcher successView = req.getRequestDispatcher(url);
					successView.forward(req, res);
					return;
				}
			} catch (Exception e) {
				errorMsgs.add("會員登出失敗，請重新操作");
			}
		}

	}
}
