package com.jobType.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobType.model.JobService;
import com.jobType.model.JobTypeVO;


@WebServlet("/JobtypeServlet")
public class JobTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer job_typenum = new Integer(req.getParameter("job_typenum"));
				
				/***************************2.開始查詢資料****************************************/
				JobService jobTypeSvc = new JobService();
				JobTypeVO jobTypeVO = jobTypeSvc.getOneJobType(job_typenum);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("jobTypeVO", jobTypeVO);
				String url = "/jobType/update_jobType_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/jobType/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { 
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer job_typenum = new Integer(req.getParameter("job_typenum").trim());
				String job_typename = req.getParameter("job_typename");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				
				if (job_typename == null || job_typename.trim().length() == 0) {
					errorMsgs.add("工作類型: 請勿空白");
				} else if(!job_typename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("工作類型: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
//				Integer deptno = new Integer(req.getParameter("deptno").trim());
				JobTypeVO jobTypeVO = new JobTypeVO();
				jobTypeVO.setJob_typenum(job_typenum);
				jobTypeVO.setJob_typename(job_typename);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("jobTypeVO", jobTypeVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/jobType/update_jobType_input");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				JobService jobTypeSvc = new JobService();
				jobTypeVO = jobTypeSvc.updateJobType(job_typenum, job_typename);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
//				req.setAttribute("jobTypeVO", jobTypeVO); // 資料庫update成功後,正確的的empVO物件,存入req
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
//				successView.forward(req, res);
				
//				req.setAttribute("jobTypeVO", jobTypeVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/jobType/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);	

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/jobType/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String job_typename = req.getParameter("job_typename");
				String job_typenameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (job_typename == null || job_typename.trim().length() == 0) {
					errorMsgs.add("工作類型: 請勿空白");
				} else if(!job_typename.trim().matches(job_typenameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("工作類型: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/jobType/listAllEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				JobService jobTypeSvc = new JobService();
				jobTypeSvc.addJobType(job_typename);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/jobType/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/jobType/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.接收請求參數***************************************/
				Integer job_typenum = new Integer(req.getParameter("job_typenum"));
				
				/***************************2.開始刪除資料***************************************/
				JobService jobTypeSvc = new JobService();
				jobTypeSvc.deleteJobType(job_typenum);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/jobType/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/jobType/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
	}

}
