package com.productType.controller;

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
import com.productType.model.*;


@MultipartConfig()
@WebServlet("/producttype/producttype.do")
public class ProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
//		if ("changeProStUp".equals(action)) { // 來自addEmp.jsp的請求  
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//
//			try {
//				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//				Integer product_num = new Integer(req.getParameter("product_num"));
//				/***************************2.開始新增資料***************************************/
//				ProductService productService = new ProductService();
//				productService.updateProductState("上架", product_num);
//				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				String url = "/product/product.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);
//				successView.forward(req, res);				
//				
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add(e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/product/product.jsp");
//				failureView.forward(req, res);
//			}
//		}
//			
//			if ("changeProStDown".equals(action)) { // 來自addEmp.jsp的請求  
//				
//				List<String> errorMsgs = new LinkedList<String>();
//				req.setAttribute("errorMsgs", errorMsgs);
//
//				try {
//					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//					Integer product_num = new Integer(req.getParameter("product_num"));
//					/***************************2.開始新增資料***************************************/
//					ProductService productService = new ProductService();
//					productService.updateProductState("下架", product_num);
//					/***************************3.新增完成,準備轉交(Send the Success view)***********/
//					String url = "/product/product.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//					successView.forward(req, res);				
//					
//					/***************************其他可能的錯誤處理**********************************/
//				} catch (Exception e) {
//					errorMsgs.add(e.getMessage());
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/product/product.jsp");
//					failureView.forward(req, res);
//				}
//			}
//			
//			
//			if ("allState".equals(action)) { // 來自addEmp.jsp的請求  
//				
//				List<String> errorMsgs = new LinkedList<String>();
//				req.setAttribute("errorMsgs", errorMsgs);
//
//				try {
//					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//					String product_state = req.getParameter("state");
//					Integer com_idnum = new Integer(req.getParameter("com_idnum"));
//					String state = null;
//					if("up".equals(product_state)) {
//						state="上架";
//					}else if("down".equals(product_state)) {
//						state="下架";
//					}else {
//						errorMsgs.add("操作錯誤！");
//					}
//					/***************************2.開始新增資料***************************************/
//					ProductService productService = new ProductService();
//					productService.allProductState(state, com_idnum);
//					/***************************3.新增完成,準備轉交(Send the Success view)***********/
//					String url = "/product/product.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//					successView.forward(req, res);				
//					
//					/***************************其他可能的錯誤處理**********************************/
//				} catch (Exception e) {
//					errorMsgs.add(e.getMessage());
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/product/product.jsp");
//					failureView.forward(req, res);
//				}
//			}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer product_typenum = new Integer(req.getParameter("product_typenum"));
				
				/***************************2.開始查詢資料****************************************/
				ProductTypeService productTypeService = new ProductTypeService();
				ProductTypeVO productTypeVO = productTypeService.getOneProductType(product_typenum);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("productTypeVO", productTypeVO);
				String url = "/productType/update_productType.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/productType/AllproductType.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { 
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				Integer product_typenum = new Integer(req.getParameter("product_typenum"));
				String product_typename = req.getParameter("product_typename");
				String product_typenameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (product_typename == null || product_typename.trim().length() == 0) {
					errorMsgs.add("商品類別: 請勿空白");
				} else if(!product_typename.trim().matches(product_typenameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("商品類別: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				ProductTypeVO productTypeVO = new ProductTypeVO();
				productTypeVO.setProduct_typename(product_typename);
				productTypeVO.setProduct_typenum(product_typenum);
				
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/productType/AllproductType.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				ProductTypeService productTypeService = new ProductTypeService();
				productTypeService.updateProductType(productTypeVO);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/productType/AllproductType.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/product/addProduct.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String product_typename = req.getParameter("product_typename");
				String product_typenameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (product_typename == null || product_typename.trim().length() == 0) {
					errorMsgs.add("商品類別: 請勿空白");
				} else if(!product_typename.trim().matches(product_typenameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("商品類別: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/productType/AllproductType.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				ProductTypeService productTypeService = new ProductTypeService();
				productTypeService.addProductType(product_typename);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/productType/AllproductType.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/product/addProduct.jsp");
				failureView.forward(req, res);
			}
		}
		
		
//		if ("delete".equals(action)) { // 來自listAllEmp.jsp
//
//			List<String> errorMsgs = new LinkedList<String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//	
//			try {
//				/***************************1.接收請求參數***************************************/
//				Integer job_typenum = new Integer(req.getParameter("job_typenum"));
//				
//				/***************************2.開始刪除資料***************************************/
//				JobService jobTypeSvc = new JobService();
//				jobTypeSvc.deleteJobType(job_typenum);
//				
//				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
//				String url = "/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
//				successView.forward(req, res);
//				
//				/***************************其他可能的錯誤處理**********************************/
//			} catch (Exception e) {
//				errorMsgs.add("刪除資料失敗:"+e.getMessage());
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/listAllEmp.jsp");
//				failureView.forward(req, res);
//			}
//		}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}

}
