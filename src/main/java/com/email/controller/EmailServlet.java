package com.email.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
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
import javax.servlet.http.Part;

import com.companymeb.model.CompanyMebVO;
import com.emailDetail.model.EmailDetailService;
import com.emailDetail.model.EmailDetailVO;
import com.mysql.cj.Session;
import com.product.model.*;
import com.productType.model.ProductTypeService;


@MultipartConfig()
@WebServlet("/email/email.do")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		CompanyMebVO companyMebVO =(CompanyMebVO)req.getSession().getAttribute("companyMebVO");//登入者的資料
		
		if ("rollBack".equals(action)) { // 回信
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				String[] email_nums =req.getParameterValues("rollBackPk");
				String[] email_types =req.getParameterValues("rollBackType");
				
				/***************************2.開始查詢資料****************************************/
				EmailDetailService emailDetailService = new EmailDetailService();
				Integer email_num;
				String email_type = null;
				for(int i=0; i<email_nums.length; i++) {
					email_num = new Integer(email_nums[i]);
					email_type = email_types[i];
//					System.out.println("email_num="+email_num+"|"+"email_type="+email_type);
					emailDetailService.rollBackLetter(email_num, email_type);
				}
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String url = "/comBackStage/email/trashCan.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/comBackStage/email/trashCan.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("reply".equals(action)) { // 回信
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				String replyAccount = req.getParameter("replyAccount");
				/***************************2.開始查詢資料****************************************/
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("replyAccount", replyAccount);
				String url = "/comBackStage/email/sendEmail.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得修改的資料:");
				RequestDispatcher failureView = req
						.getRequestDispatcher("/comBackStage/email/Email.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("draftSend".equals(action)) { // 回信
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer email_num = new Integer(req.getParameter("email_num"));
				/***************************2.開始查詢資料****************************************/
				EmailDetailService emailDetailService = new EmailDetailService();
				EmailDetailVO emailDetailVO = emailDetailService.getOneLetter(email_num);
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("emailDetailVO", emailDetailVO);
				String url = "/comBackStage/email/sendEmail.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得修改的資料:");
				RequestDispatcher failureView = req
						.getRequestDispatcher("/comBackStage/email/Email.jsp啥");
				failureView.forward(req, res);
			}
		}
		
		if ("showletter".equals(action)) { 
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer email_num = new Integer(req.getParameter("email_num"));
				
				/***************************2.開始查詢資料****************************************/
				EmailDetailService emailDetailService = new EmailDetailService();
				EmailDetailVO emailDetailVO = emailDetailService.getOneLetter(email_num);
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("emailDetailVO", emailDetailVO);
				String url = "/comBackStage/email/letter.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得修改的資料:");
				RequestDispatcher failureView = req
						.getRequestDispatcher("/comBackStage/email/Email.jsp啥");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { 
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			EmailDetailService emailDetailService = new EmailDetailService();
			String mem_account =null;//catch會用到因此拉到外面來
			
			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				mem_account = req.getParameter("mem_account");//收件人
				Integer mem_access = emailDetailService.findMemAccess(mem_account);//判斷收件者的類型1=廠商,2=網紅
				if (mem_account == null || mem_account.trim().length() == 0) {
					errorMsgs.add("收件人: 請勿空白");
				}else if(mem_access == null) {
					throw new EmailAccountException();//當無此收件者時拋出自訂例外
				}
				String email_content = req.getParameter("email_content");
				if (email_content == null || email_content.trim().length() == 0 || "<p><br></p>".equals(email_content)) {
					errorMsgs.add("信件內容: 請勿空白");
				}
				Integer email_typenum = 1;//信件類別,一般寄信為普通信件=1
				String email_title = req.getParameter("email_title");
				if (email_title == null || email_title.trim().length() == 0) {
					errorMsgs.add("信件標題: 請勿空白");
				}
				
				EmailDetailVO emailDetailVO =new EmailDetailVO();
				if(mem_access==1) {//根據收件者類型新增1=廠商,2=網紅
				emailDetailVO.setCom_account(mem_account);
				}else if(mem_access==2) {
				emailDetailVO.setKol_account(mem_account);
				}
				emailDetailVO.setEmail_typenum(email_typenum);
				emailDetailVO.setEmail_title(email_title);
				emailDetailVO.setEmail_content(email_content);
				emailDetailVO.setSender(companyMebVO.getCom_account());//寄件人
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/comBackStage/email/sendEmail.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				emailDetailService.send(emailDetailVO);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/comBackStage/email/Email.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (EmailAccountException e) {//當無此收件者。管理員寄一封寄件失敗信件
				//傳入三個參數:寄件失敗者的帳號,寄件者會員權限,輸入錯誤的帳號
				emailDetailService.sendErrorLetter(companyMebVO.getCom_account(),companyMebVO.getMeb_accessnum(),mem_account);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/comBackStage/email/Email.jsp");
				failureView.forward(req, res);
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/comBackStage/email/sendEmail.jsp");
				failureView.forward(req, res);
			}
		}
        
        if ("draft".equals(action)) { 
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			EmailDetailService emailDetailService = new EmailDetailService();
			
			try {
				/***********************1.接收請求參數 - 只是加入草稿因此沒有太多資料驗證*************************/
				/***********************如果使用者存入全部空白的草稿會在前端進行錯誤處理**************************/
				String mem_account = companyMebVO.getCom_account();//收件人,草稿信收件人為自己
				Integer mem_access = emailDetailService.findMemAccess(mem_account);//判斷收件者的類型1=廠商,2=網紅
				String email_content = req.getParameter("draftContent");
				Integer email_typenum = 2;//信件類別,加入草稿為草稿信件=2
				String email_title = req.getParameter("draftTitle");
				if(email_title.equals("")) {
					email_title ="未命名草稿";
				}
				EmailDetailVO emailDetailVO =new EmailDetailVO();
				if(mem_access==1) {//根據收件者類型新增1=廠商,2=網紅
				emailDetailVO.setCom_account(mem_account);
				}else if(mem_access==2) {
				emailDetailVO.setKol_account(mem_account);
				}
				emailDetailVO.setEmail_typenum(email_typenum);
				emailDetailVO.setEmail_title(email_title);
				emailDetailVO.setEmail_content(email_content);
				
				/***************************2.開始新增資料***************************************/
				emailDetailService.addDraft(emailDetailVO);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/comBackStage/email/Email.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); 
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/comBackStage/email/sendEmail.jsp");
				failureView.forward(req, res);
			}
		}
        
		if ("delete".equals(action)) { 
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				String[] email_nums =req.getParameterValues("deletePk");
				
				/***************************2.開始查詢資料****************************************/
				EmailDetailService emailDetailService = new EmailDetailService();
				Integer email_num;
				for(int i=0; i<email_nums.length; i++) {
					email_num = new Integer(email_nums[i]);
					emailDetailService.deleteLetter(email_num);
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String url = "/comBackStage/email/trashCan.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/comBackStage/email/trashCan.jsp");
				failureView.forward(req, res);
			}
		}
		
		if ("toTrashCan".equals(action)) { 
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				String[] email_nums =req.getParameterValues("deletePk");
				
				/***************************2.開始查詢資料****************************************/
				EmailDetailService emailDetailService = new EmailDetailService();
				Integer email_num;
				for(int i=0; i<email_nums.length; i++) {
					email_num = new Integer(email_nums[i]);
					emailDetailService.trashCanLetter(email_num);
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String url = "/comBackStage/email/Email.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/comBackStage/email/Email.jsp");
				failureView.forward(req, res);
			}
		}
        
        
        
        
        
        
	}
}
