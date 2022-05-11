package com.memberphoto.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.companymeb.model.CompanyMebService;
import com.companymeb.model.CompanyMebVO;
import com.memberphoto.model.MemberPhotoService;
import com.memberphoto.model.MemberPhotoVO;

@WebServlet("/memberphoto/MemberPhoto.do")
public class MemberPhotoServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
	
	
	
	if ("insert".equals(action)) { // 來自.jsp的請求  
		
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			MemberPhotoVO memberPhotoVO = new MemberPhotoVO();
			InputStream fileContent = null;

		try {
			/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/		
//			Byte meb_photo = new Byte(req.getParameter("meb_photo"));
			Integer com_idnum = new Integer(req.getParameter("com_idnum"));
			Integer kol_idnum = new Integer(req.getParameter("kol_idnum"));
Part filePart = req.getPart("p_file"); // Retrieves <input type="file" name="p_file">
		    String partName = filePart.getSubmittedFileName();
		    fileContent = filePart.getInputStream();
		    byte[] buffer =new byte[fileContent.available()];
		    fileContent.read(buffer);//把圖傳進buffer陣列

			memberPhotoVO.setCom_idnum(com_idnum);
			memberPhotoVO.setKol_idnum(kol_idnum);
			if(partName == "") {
				memberPhotoVO.setMeb_photo(null);
		    }else{
		    	memberPhotoVO.setMeb_photo(buffer);
		    }
			
								
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memberPhotoVO", memberPhotoVO);
RequestDispatcher failureView = req.getRequestDispatcher("/companymeb/companyMebJsp2.jsp");
				failureView.forward(req, res);
				return;
			}				
			
			/***************************2.開始新增資料***************************************/
			MemberPhotoService memberPhotoService = new MemberPhotoService();
			int meb_photonum = memberPhotoService.addMemberPhoto(memberPhotoVO);
			memberPhotoVO.setMeb_photonum(meb_photonum);
			req.setAttribute("memberPhotoVO", memberPhotoVO);
			
			/***************************3.新增完成,準備轉交(Send the Success view)***********/
String url = "/companymeb/companyMebJsp3.jsp";
RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);				
			
			/***************************其他可能的錯誤處理**********************************/
            } catch (Exception e) {
            req.setAttribute("memberPhotoVO", memberPhotoVO);
			errorMsgs.add(e.getMessage());
RequestDispatcher failureView = req.getRequestDispatcher("/companymeb/companyMebJsp2.jsp");
			failureView.forward(req, res);
		}
	}
	

	
	}
}