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
		
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer job_typenum = new Integer(req.getParameter("job_typenum"));
				
				/***************************2.�}�l�d�߸��****************************************/
				JobService jobTypeSvc = new JobService();
				JobTypeVO jobTypeVO = jobTypeSvc.getOneJobType(job_typenum);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("jobTypeVO", jobTypeVO);
				String url = "/jobType/update_jobType_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/jobType/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { 
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				Integer job_typenum = new Integer(req.getParameter("job_typenum").trim());
				String job_typename = req.getParameter("job_typename");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				
				if (job_typename == null || job_typename.trim().length() == 0) {
					errorMsgs.add("�u�@����: �ФŪť�");
				} else if(!job_typename.trim().matches(enameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�u�@����: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
	            }
				
//				Integer deptno = new Integer(req.getParameter("deptno").trim());
				JobTypeVO jobTypeVO = new JobTypeVO();
				jobTypeVO.setJob_typenum(job_typenum);
				jobTypeVO.setJob_typename(job_typename);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("jobTypeVO", jobTypeVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/jobType/update_jobType_input");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				JobService jobTypeSvc = new JobService();
				jobTypeVO = jobTypeSvc.updateJobType(job_typenum, job_typename);
				
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
//				req.setAttribute("jobTypeVO", jobTypeVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
//				String url = "/emp/listOneEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
//				successView.forward(req, res);
				
//				req.setAttribute("jobTypeVO", jobTypeVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/jobType/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);	

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/jobType/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
				String job_typename = req.getParameter("job_typename");
				String job_typenameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (job_typename == null || job_typename.trim().length() == 0) {
					errorMsgs.add("�u�@����: �ФŪť�");
				} else if(!job_typename.trim().matches(job_typenameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�u�@����: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
	            }
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/jobType/listAllEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				JobService jobTypeSvc = new JobService();
				jobTypeSvc.addJobType(job_typename);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/jobType/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/jobType/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer job_typenum = new Integer(req.getParameter("job_typenum"));
				
				/***************************2.�}�l�R�����***************************************/
				JobService jobTypeSvc = new JobService();
				jobTypeSvc.deleteJobType(job_typenum);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/jobType/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/jobType/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
	}

}
