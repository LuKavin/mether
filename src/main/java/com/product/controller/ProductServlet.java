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
import com.productType.model.ProductTypeService;


@MultipartConfig()
@WebServlet("/product/product.do")
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
		
		if ("changeProStUp".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				Integer product_num = new Integer(req.getParameter("product_num"));
				/***************************2.開始新增資料***************************************/
				ProductService productService = new ProductService();
				productService.updateProductState("上架", product_num);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/product/product.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/product/product.jsp");
				failureView.forward(req, res);
			}
		}
			
			if ("changeProStDown".equals(action)) { // 來自addEmp.jsp的請求  
				
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);

				try {
					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					Integer product_num = new Integer(req.getParameter("product_num"));
					/***************************2.開始新增資料***************************************/
					ProductService productService = new ProductService();
					productService.updateProductState("下架", product_num);
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					String url = "/product/product.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
					successView.forward(req, res);				
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add(e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/product/product.jsp");
					failureView.forward(req, res);
				}
			}
			
			
			if ("allState".equals(action)) { // 來自addEmp.jsp的請求  
				
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);

				try {
					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					String product_state = req.getParameter("state");
					Integer com_idnum = new Integer(req.getParameter("com_idnum"));
					String state = null;
					if("up".equals(product_state)) {
						state="上架";
					}else if("down".equals(product_state)) {
						state="下架";
					}else {
						errorMsgs.add("操作錯誤！");
					}
					/***************************2.開始新增資料***************************************/
					ProductService productService = new ProductService();
					productService.allProductState(state, com_idnum);
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					String url = "/product/product.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
					successView.forward(req, res);				
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					errorMsgs.add(e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/product/product.jsp");
					failureView.forward(req, res);
				}
			}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer product_num = new Integer(req.getParameter("product_num"));
				
				/***************************2.開始查詢資料****************************************/
				ProductService productService = new ProductService();
				ProductVO productVO = productService.getOneProduct(product_num);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("productVO", productVO);
				String url = "/product/updateProduct.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/product/product.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { 
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			InputStream fileContent = null;

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String product_name = req.getParameter("product_name");
				String product_typenameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (product_name == null || product_name.trim().length() == 0) {
					errorMsgs.add("商品名稱: 請勿空白");
				} else if(!product_name.trim().matches(product_typenameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				String product_introduce = req.getParameter("product_introduce");
				if (product_introduce == null || product_introduce.trim().length() == 0) {
					errorMsgs.add("商品介紹: 請勿空白");
				}
				String product_link = req.getParameter("product_link").trim();
				String product_linkReg = "((http://|ftp://|https://|www))(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";
				if (!product_link.trim().matches(product_linkReg)) {
					errorMsgs.add("網址格式錯誤");
	            }
				String numberReg = "^[(0-9)]{2,10}$";
				Integer product_budget = null;
				try {
					product_budget = new Integer(req.getParameter("product_budget").trim());
				} catch (Exception e) {
					errorMsgs.add("預估預算格式不正確");
				}
				if (product_budget == null) {
					errorMsgs.add("預估預算: 請勿空白");
				}
				Integer product_count = null;
				try {
					product_count = new Integer(req.getParameter("product_count").trim());
				} catch (Exception e) {
					errorMsgs.add("商品數量格式不正確");
				}
				if (product_count == null) {
					errorMsgs.add("商品數量: 請勿空白");
				}
				String product_contract = req.getParameter("product_contract");
				if (product_contract == null || product_contract.trim().length() == 0) {
					errorMsgs.add("合約內容: 請勿空白");
				}
				java.sql.Date product_deadline = null;
				try {
					product_deadline = java.sql.Date.valueOf(req.getParameter("product_deadline").trim());
				} catch (IllegalArgumentException e) {
					product_deadline=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請填入日期!");
				}
				String product_state = req.getParameter("product_state");
				Integer product_typenum = new Integer(req.getParameter("product_typenum"));
				Integer product_num = new Integer(req.getParameter("product_num"));
				
//				測試上傳圖片
			    Part filePart = req.getPart("p_file"); // Retrieves <input type="file" name="p_file">
			    String partName = filePart.getSubmittedFileName();
			    fileContent = filePart.getInputStream();
			    byte[] buffer =new byte[fileContent.available()];
			    fileContent.read(buffer);//把圖傳進buffer陣列

			    
				
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
				productVO.setProduct_num(product_num);

			    if(partName == "") {
			    	productVO.setTest_pic(null);
			    }else{
			    	productVO.setTest_pic(buffer);
			    }
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("productVO", productVO);
					fileContent.close();
					RequestDispatcher failureView = req
							.getRequestDispatcher("/product/updateProduct.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				ProductService productService = new ProductService();
				ProductTypeService productTypeService = new ProductTypeService();
				productVO = productService.updateProduct(productVO);
				String product_typename = productTypeService.getOneProductType(product_typenum).getProduct_typename();
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				fileContent.close();
				req.setAttribute("productVO", productVO);
				req.setAttribute("product_typename", product_typename);
				String url = "/product/successView.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				fileContent.close();
				RequestDispatcher failureView = req
						.getRequestDispatcher("/product/updateProduct.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			InputStream fileContent = null;

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
				String product_name = req.getParameter("product_name");
				String product_typenameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (product_name == null || product_name.trim().length() == 0) {
					errorMsgs.add("商品名稱: 請勿空白");
				} else if(!product_name.trim().matches(product_typenameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				String product_introduce = req.getParameter("product_introduce");
				if (product_introduce == null || product_introduce.trim().length() == 0) {
					errorMsgs.add("商品介紹: 請勿空白");
				}
				String product_link = req.getParameter("product_link");
				String product_linkReg = "((http://|ftp://|https://|www))(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";
				if (!product_link.trim().matches(product_linkReg)) {
					errorMsgs.add("網址格式錯誤");
	            }
				String numberReg = "^[(0-9)]{2,10}$";
				Integer product_budget = null;
				try {
					product_budget = new Integer(req.getParameter("product_budget").trim());
				} catch (Exception e) {
					errorMsgs.add("預估預算格式不正確");
				}
//				if (product_budget == null) {
//					errorMsgs.add("預估預算: 請勿空白");
//				}
				Integer product_count = null;
				try {
					product_count = new Integer(req.getParameter("product_count").trim());
				} catch (Exception e) {
					errorMsgs.add("商品數量格式不正確");
				}
//				if (product_count == null) {
//					errorMsgs.add("商品數量: 請勿空白");
//				}
				String product_contract = req.getParameter("product_contract");
				if (product_contract == null || product_contract.trim().length() == 0) {
					errorMsgs.add("合約內容: 請勿空白");
				}
				java.sql.Date product_deadline = null;
				try {
					product_deadline = java.sql.Date.valueOf(req.getParameter("product_deadline").trim());
				} catch (IllegalArgumentException e) {
					product_deadline=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請填入日期!");
				}
				String product_state = req.getParameter("product_state");
				Integer product_typenum = new Integer(req.getParameter("product_typenum"));
				
//				測試上傳圖片
			    Part filePart = req.getPart("p_file"); // Retrieves <input type="file" name="file">
			    fileContent = filePart.getInputStream();
			    byte[] buffer =new byte[fileContent.available()];
			    fileContent.read(buffer);//把圖傳進buffer陣列

			    
				
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
				
				/***************************2.開始新增資料***************************************/
				ProductService productService = new ProductService();
				int product_num = productService.addProduct(productVO);
				productVO.setProduct_num(product_num);
				ProductTypeService productTypeService = new ProductTypeService();
				String product_typename = productTypeService.getOneProductType(product_typenum).getProduct_typename();
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				fileContent.close();
				
				req.setAttribute("productVO", productVO);
				req.setAttribute("product_typename", product_typename);
				String url = "/product/successView.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				fileContent.close();
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
