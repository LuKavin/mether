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
import javax.servlet.http.Part;

import com.emailDetail.model.EmailDetailService;
import com.emailDetail.model.EmailDetailVO;
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
		
		if ("showletter".equals(action)) { // 來自listAllEmp.jsp的請求
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
				String url = "/email/letter.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/email/Email.jsp啥");
				failureView.forward(req, res);
			}
		}
//		
//		
//		if ("update".equals(action)) { 
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//			InputStream fileContent = null;
//
//			try {
//				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//				String product_name = req.getParameter("product_name");
//				String product_typenameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (product_name == null || product_name.trim().length() == 0) {
//					errorMsgs.add("商品名稱: 請勿空白");
//				} else if(!product_name.trim().matches(product_typenameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
//				String product_introduce = req.getParameter("product_introduce");
//				if (product_introduce == null || product_introduce.trim().length() == 0) {
//					errorMsgs.add("商品介紹: 請勿空白");
//				}
//				String product_link = req.getParameter("product_link").trim();
//				String product_linkReg = "((http://|ftp://|https://|www))(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";
//				if (!product_link.trim().matches(product_linkReg)) {
//					errorMsgs.add("網址格式錯誤");
//	            }
//				String numberReg = "^[(0-9)]{2,10}$";
//				Integer product_budget = null;
//				try {
//					product_budget = new Integer(req.getParameter("product_budget").trim());
//				} catch (Exception e) {
//					errorMsgs.add("預估預算格式不正確");
//				}
//				if (product_budget == null) {
//					errorMsgs.add("預估預算: 請勿空白");
//				}
//				Integer product_count = null;
//				try {
//					product_count = new Integer(req.getParameter("product_count").trim());
//				} catch (Exception e) {
//					errorMsgs.add("商品數量格式不正確");
//				}
//				if (product_count == null) {
//					errorMsgs.add("商品數量: 請勿空白");
//				}
//				String product_contract = req.getParameter("product_contract");
//				if (product_contract == null || product_contract.trim().length() == 0) {
//					errorMsgs.add("合約內容: 請勿空白");
//				}
//				java.sql.Date product_deadline = null;
//				try {
//					product_deadline = java.sql.Date.valueOf(req.getParameter("product_deadline").trim());
//				} catch (IllegalArgumentException e) {
//					product_deadline=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請填入日期!");
//				}
//				String product_state = req.getParameter("product_state");
//				Integer product_typenum = new Integer(req.getParameter("product_typenum"));
//				Integer product_num = new Integer(req.getParameter("product_num"));
//				
////				測試上傳圖片
//			    Part filePart = req.getPart("p_file"); // Retrieves <input type="file" name="p_file">
//			    String partName = filePart.getSubmittedFileName();
//			    fileContent = filePart.getInputStream();
//			    byte[] buffer =new byte[fileContent.available()];
//			    fileContent.read(buffer);//把圖傳進buffer陣列
//
//			    
//				
//			    ProductVO productVO =new ProductVO();
//				productVO.setProduct_name(product_name);
//				productVO.setProduct_introduce(product_introduce);
//				productVO.setProduct_link(product_link);
//				productVO.setProduct_budget(product_budget);
//				productVO.setProduct_count(product_count);
//				productVO.setProduct_contract(product_contract);
//				productVO.setProduct_deadline(product_deadline);
//				productVO.setProduct_state(product_state);
//				productVO.setProduct_typenum(product_typenum);
//				productVO.setProduct_num(product_num);
//
//			    if(partName == "") {
//			    	productVO.setTest_pic(null);
//			    }else{
//			    	productVO.setTest_pic(buffer);
//			    }
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("productVO", productVO);
//					fileContent.close();
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/product/updateProduct.jsp");
//					failureView.forward(req, res);
//					return;
//				}
//				
//				/***************************2.開始新增資料***************************************/
//				ProductService productService = new ProductService();
//				ProductTypeService productTypeService = new ProductTypeService();
//				productVO = productService.updateProduct(productVO);
//				String product_typename = productTypeService.getOneProductType(product_typenum).getProduct_typename();
//				System.out.println(product_typename);
//				
//				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				fileContent.close();
//				req.setAttribute("productVO", productVO);
//				req.setAttribute("product_typename", product_typename);
//				String url = "/product/successView.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);				
//				
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add(e.getMessage());
//				fileContent.close();
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/product/updateProduct.jsp");
//				failureView.forward(req, res);
//			}
//		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			EmailDetailService emailDetailService = new EmailDetailService();

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String mem_account = req.getParameter("mem_account");//收件人
				if (mem_account == null || mem_account.trim().length() == 0) {
					errorMsgs.add("收件人: 請勿空白");
				}else if(mem_account == null) {
					errorMsgs.add("沒有此收件人或帳號輸入錯誤");
				}
				String email_content = req.getParameter("email_content");//收件人
				
				Integer email_typenum = 1;//信件類別,先寫死
				
				String email_title = req.getParameter("email_title");
				if (email_title == null || email_title.trim().length() == 0) {
					errorMsgs.add("信件標題: 請勿空白");
				}
				
				EmailDetailVO emailDetailVO =new EmailDetailVO();
				emailDetailVO.setCom_account(mem_account);
				emailDetailVO.setEmail_typenum(email_typenum);
				emailDetailVO.setEmail_title(email_title);
				emailDetailVO.setEmail_content(email_content);//信件內容先寫死
				emailDetailVO.setRecipient("COM");//收件人,先寫死
				
				emailDetailVO.setKol_account("tibamekol");//寄件人先寫死
				
				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("productVO", productVO);
//					fileContent.close();
					RequestDispatcher failureView = req
							.getRequestDispatcher("/email/sendEmail.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				emailDetailService.send(emailDetailVO);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				fileContent.close();
//				req.setAttribute("productVO", productVO);
				String url = "/email/Email.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
//				fileContent.close();
				RequestDispatcher failureView = req
						.getRequestDispatcher("/email/sendEmail.jsp");
				failureView.forward(req, res);
			}
		}
        
        
        
	}

}
