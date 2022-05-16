package com.product.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Collection;
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
import com.productPhoto.model.ProductPhotoService;
import com.productType.model.ProductTypeService;


@MultipartConfig()
@WebServlet("/product/proPhoto.do")
public class ProductPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String updatePc ="";
		
		for(int i = 1; i <= 5; i++) {
			updatePc = "updatePc" + i;
			if (updatePc.equals(action)) {
				
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				String updateFile = "updateFile" + i;
				InputStream fileIs = null;
				try {
					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					Integer product_num = new Integer(req.getParameter("product_num"));
					Part part = req.getPart(updateFile);
					
					fileIs = part.getInputStream();
					byte[] buffer =new byte[fileIs.available()];
					fileIs.read(buffer);
					/***************************2.開始新增資料***************************************/
					ProductPhotoService productPhotoService = new ProductPhotoService();
					productPhotoService.updateOnePhoto(product_num, buffer, i);
					fileIs.close();
					
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					ProductService productService = new ProductService();
					ProductVO productVO = productService.getOneProduct(product_num);
					req.setAttribute("productVO", productVO);
					RequestDispatcher failureView = req
							.getRequestDispatcher("/comBackStage/product/updateProduct.jsp");
					failureView.forward(req, res);
					
					/***************************其他可能的錯誤處理**********************************/
				} catch (Exception e) {
					fileIs.close();
					errorMsgs.add(e.getMessage());
					RequestDispatcher failureView = req
							.getRequestDispatcher("/product/proPhoto.do←← 報錯");
					failureView.forward(req, res);
				}
			}
			
		}
		
			
        
        
        
        
        
        
        
        
        
	}

}
