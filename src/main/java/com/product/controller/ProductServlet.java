package com.product.controller;

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
import javax.servlet.http.Part;

import com.product.model.*;


@MultipartConfig()
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		if ("changeProStUp".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
				Integer product_num = new Integer(req.getParameter("product_num"));
				/***************************2.�}�l�s�W���***************************************/
				ProductService productService = new ProductService();
				productService.updateProductState("�W�[", product_num);
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/index.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/index.jsp");
				failureView.forward(req, res);
			}
		}
			
			if ("changeProStDown".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
				
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);

				try {
					/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
					Integer product_num = new Integer(req.getParameter("product_num"));
					/***************************2.�}�l�s�W���***************************************/
					ProductService productService = new ProductService();
					productService.updateProductState("�U�[", product_num);
					/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
					String url = "/index.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
					successView.forward(req, res);				
					
					/***************************��L�i�઺���~�B�z**********************************/
				} catch (Exception e) {
					errorMsgs.add(e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/index.jsp");
					failureView.forward(req, res);
				}
			}
			
			
			if ("allState".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
				
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);

				try {
					/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
					String product_state = req.getParameter("state");
					Integer com_idnum = new Integer(req.getParameter("com_idnum"));
					String state = null;
					if("up".equals(product_state)) {
						state="�W�[";
					}else if("down".equals(product_state)) {
						state="�U�[";
					}else {
						errorMsgs.add("�ާ@���~�I");
					}
					/***************************2.�}�l�s�W���***************************************/
					ProductService productService = new ProductService();
					productService.allProductState(state, com_idnum);
					/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
					String url = "/index.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
					successView.forward(req, res);				
					
					/***************************��L�i�઺���~�B�z**********************************/
				} catch (Exception e) {
					errorMsgs.add(e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/index.jsp");
					failureView.forward(req, res);
				}
			}
		
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer product_num = new Integer(req.getParameter("product_num"));
				
				/***************************2.�}�l�d�߸��****************************************/
				ProductService productService = new ProductService();
				ProductVO productVO = productService.getOneProduct(product_num);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("productVO", productVO);
				String url = "/update_jobType_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
//		if ("update".equals(action)) { 
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//		
//			try {
//				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
//				Integer job_typenum = new Integer(req.getParameter("job_typenum").trim());
//				String job_typename = req.getParameter("job_typename");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				
//				if (job_typename == null || job_typename.trim().length() == 0) {
//					errorMsgs.add("�u�@����: �ФŪť�");
//				} else if(!job_typename.trim().matches(enameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					errorMsgs.add("�u�@����: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
//	            }
//				
////				Integer deptno = new Integer(req.getParameter("deptno").trim());
//				JobTypeVO jobTypeVO = new JobTypeVO();
//				jobTypeVO.setJob_typenum(job_typenum);
//				jobTypeVO.setJob_typename(job_typename);
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("jobTypeVO", jobTypeVO); // �t����J�榡���~��empVO����,�]�s�Jreq
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/update_jobType_input");
//					failureView.forward(req, res);
//					return; //�{�����_
//				}
//				
//				/***************************2.�}�l�ק���*****************************************/
//				JobService jobTypeSvc = new JobService();
//				jobTypeVO = jobTypeSvc.updateJobType(job_typenum, job_typename);
//				
//				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
////				req.setAttribute("jobTypeVO", jobTypeVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
////				String url = "/emp/listOneEmp.jsp";
////				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
////				successView.forward(req, res);
//				
////				req.setAttribute("jobTypeVO", jobTypeVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
//				String url = "/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
//				successView.forward(req, res);	
//
//				/***************************��L�i�઺���~�B�z*************************************/
//			} catch (Exception e) {
//				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}

        if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			InputStream fileContent = null;

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
				String product_name = req.getParameter("product_name");
				String job_typenameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (product_name == null || product_name.trim().length() == 0) {
					errorMsgs.add("�ӫ~�W��: �ФŪť�");
				} else if(!product_name.trim().matches(job_typenameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�ӫ~�W��: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
	            }
				String product_introduce = req.getParameter("product_introduce");
				if (product_introduce == null || product_introduce.trim().length() == 0) {
					errorMsgs.add("�ӫ~����: �ФŪť�");
				}
				String product_link = req.getParameter("product_link");
				String numberReg = "^[(0-9)]{2,10}$";
				Integer product_budget = null;
				try {
					product_budget = new Integer(req.getParameter("product_budget").trim());
				} catch (Exception e) {
					errorMsgs.add("�w���w��榡�����T");
				}
				if (product_budget == null) {
					errorMsgs.add("�w���w��: �ФŪť�");
				}
				Integer product_count = null;
				try {
					product_count = new Integer(req.getParameter("product_count").trim());
				} catch (Exception e) {
					errorMsgs.add("�ӫ~�ƶq�榡�����T");
				}
				if (product_count == null) {
					errorMsgs.add("�ӫ~�ƶq: �ФŪť�");
				}
				String product_contract = req.getParameter("product_contract");
				if (product_contract == null || product_contract.trim().length() == 0) {
					errorMsgs.add("�X�����e: �ФŪť�");
				}
				java.sql.Date product_deadline = null;
				try {
					product_deadline = java.sql.Date.valueOf(req.getParameter("product_deadline").trim());
				} catch (IllegalArgumentException e) {
					product_deadline=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�ж�J���!");
				}
				String product_state = req.getParameter("product_state");
				Integer product_typenum = new Integer(req.getParameter("product_typenum"));
				
//				���դW�ǹϤ�
			    Part filePart = req.getPart("p_file"); // Retrieves <input type="file" name="file">
			    fileContent = filePart.getInputStream();
			    byte[] buffer =new byte[fileContent.available()];
			    fileContent.read(buffer);//��϶Ƕibuffer�}�C

			    
				
			    ProductVO productVO =new ProductVO();
				productVO.setProduct_name(product_name);
				productVO.setProduct_introduce(product_introduce);
				productVO.setProduct_link(product_link);
				productVO.setProduct_budget(product_budget);
				productVO.setProduct_count(product_count);
				productVO.setProduct_contract(product_contract);
				productVO.setProduct_deadline(product_deadline);
				productVO.setProduct_state(product_state);
				productVO.setProduct_typenum(product_typenum);
			    if(filePart != null) {
			    	productVO.setTest_pic(buffer);
			    }
				productVO.setCom_idnum(1);
				
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("productVO", productVO);
					fileContent.close();
					RequestDispatcher failureView = req
							.getRequestDispatcher("/product/addProduct.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				ProductService productService = new ProductService();
				int product_num = productService.addProduct(productVO);
				productVO.setProduct_num(product_num);
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				fileContent.close();
				
				req.setAttribute("productVO", productVO);
				String url = "/product/successView.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				fileContent.close();
				RequestDispatcher failureView = req
						.getRequestDispatcher("/product/addProduct.jsp");
				failureView.forward(req, res);
			}
		}
		
		
//		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//			try {
//				/***************************1.�����ШD�Ѽ�***************************************/
//				Integer job_typenum = new Integer(req.getParameter("job_typenum"));
//				
//				/***************************2.�}�l�R�����***************************************/
//				JobService jobTypeSvc = new JobService();
//				jobTypeSvc.deleteJobType(job_typenum);
//				
//				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
//				String url = "/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
//				successView.forward(req, res);
//				
//				/***************************��L�i�઺���~�B�z**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("�R����ƥ���:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}

}
