package com.memberphoto.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.companymeb.model.CompanyMebService;
import com.companymeb.model.CompanyMebVO;
import com.kolmeb.model.KolMebVO;
import com.memberphoto.model.MemberPhotoService;
import com.memberphoto.model.MemberPhotoVO;

@WebServlet("/memberphoto/MemberPhoto.do")
@MultipartConfig()
public class MemberPhotoServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
	

		if ("insert".equals(action)) { // 來自companyPhotoAddJsp2.jsp的請求  
			
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				MemberPhotoVO memberPhotoVO = new MemberPhotoVO();
	
			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/					
				HttpSession session = req.getSession();
				CompanyMebVO mebVO = (CompanyMebVO) session.getAttribute("companyMebVO");
				Integer com_idnum = mebVO.getCom_idnum();
				Part part = req.getPart("meb_photo");
				InputStream in = part.getInputStream();
				byte[] meb_photo = new byte[in.available()];
				in.read(meb_photo);
				
				memberPhotoVO.setCom_idnum(com_idnum);
				memberPhotoVO.setMeb_photo(meb_photo);
							 		
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberPhotoVO", memberPhotoVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/comBackStage/companymeb/companyPhotoIndexJspTwo.jsp");
					failureView.forward(req, res);
					return;
				}				
				
				/***************************2.開始新增資料***************************************/
				MemberPhotoService memberPhotoService = new MemberPhotoService();
				int meb_photonum = memberPhotoService.addMemberPhoto(memberPhotoVO);
				memberPhotoVO.setMeb_photonum(meb_photonum);
				req.setAttribute("memberPhotoVO", memberPhotoVO);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/comBackStage/companymeb/companyPhotoIndexJspTwo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交companyPhotoIndexJspTwo.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
	            } catch (Exception e) {
	            req.setAttribute("memberPhotoVO", memberPhotoVO);
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/comBackStage/companymeb/companyPhotoIndexJspTwo.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // 來自companyPhotoIndexJsp.jsp的請求  
			
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
	
				try {
					/*************************** 1.接收請求參數 ***************************************/
					Integer meb_photonum = new Integer(req.getParameter("meb_photonum"));
	
					/*************************** 2.開始刪除資料 ***************************************/
					MemberPhotoService memberPhotoService = new MemberPhotoService();
					memberPhotoService.deleteMemberPhoto(meb_photonum);
	
					/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
					String url = "/comBackStage/companymeb/companyPhotoIndexJspTwo.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
	
					/*************************** 其他可能的錯誤處理 **********************************/
				} catch (Exception e) {
					errorMsgs.add("刪除資料失敗:" + e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/comBackStage/companymeb/companyPhotoIndexJspTwo.jsp");
					failureView.forward(req, res);
			}
		}
		
		
		
		
		if ("update".equals(action)) { // 來自companyPhotoUpdateJsp.jsp的請求  
				
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				MemberPhotoVO memberPhotoVO = new MemberPhotoVO();
				MemberPhotoService memberPhotoService = new MemberPhotoService();
	
				try {
					/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
					Integer meb_photonum = new Integer(req.getParameter("meb_photonum"));
					Part part = req.getPart("meb_photo");
					InputStream in = part.getInputStream();
					byte[] meb_photo = null;
					if (in.available() > 0) {
						meb_photo = new byte[in.available()];
						in.read(meb_photo);
					} else {
						memberPhotoVO = memberPhotoService.getOneMemberPhoto(meb_photonum);
						meb_photo = memberPhotoVO.getMeb_photo();
					}
	
					memberPhotoVO.setMeb_photonum(meb_photonum);
					memberPhotoVO.setMeb_photo(meb_photo);

					if (!errorMsgs.isEmpty()) {
						req.setAttribute("memberPhotoVO", memberPhotoVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req.getRequestDispatcher("/comBackStage/companymeb/companyPhotoUpdateJsp2.jsp");
						failureView.forward(req, res);
						return; // 程式中斷
					}
	
					/*************************** 2.開始修改資料 *****************************************/
					memberPhotoService.updateMemberPhoto(memberPhotoVO);
					
	
					/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
					req.setAttribute("memberPhotoVO", memberPhotoVO); // 資料庫update成功後,正確的的empVO物件,存入req
					String url = "/comBackStage/companymeb/companyPhotoIndexJspTwo.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
					successView.forward(req, res);
	
					/*************************** 其他可能的錯誤處理 *************************************/
				 } 	catch (Exception e) {
					 e.printStackTrace();
					errorMsgs.add("修改資料失敗:" + e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/comBackStage/companymeb/companyPhotoIndexJspTwo.jsp");
					failureView.forward(req, res);
				}
			}
		
		if ("getOne_For_Update".equals(action)) { // 來自companyPhotoUpdateJsp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			MemberPhotoVO memberPhotoVO = new MemberPhotoVO();
			MemberPhotoService memberPhotoService = new MemberPhotoService();

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				Integer meb_photonum = new Integer(req.getParameter("meb_photonum"));
				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("meb_photonum", meb_photonum); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/comBackStage/companymeb/companyPhotoUpdateJspTwo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			 } 	catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/comBackStage/companymeb/companyPhotoIndexJspTwo.jsp");
				failureView.forward(req, res);
			}
		}
		
		
//==========================================網紅的insert, delete, update, getOne_For_Update==================================
		
		if ("insert_kol".equals(action)) { // 來自kolPhotoAddJsp2.jsp的請求  
			
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				MemberPhotoVO memberPhotoVO = new MemberPhotoVO();
	
			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/	
				HttpSession session = req.getSession();
				KolMebVO mebVO = (KolMebVO) session.getAttribute("kolMebVO");
				Integer kol_idnum = mebVO.getKol_idnum();
				Part part = req.getPart("meb_photo");
				InputStream in = part.getInputStream();
				byte[] meb_photo = new byte[in.available()];
				in.read(meb_photo);
				
				memberPhotoVO.setKol_idnum(kol_idnum);
				memberPhotoVO.setMeb_photo(meb_photo);
							 		
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberPhotoVO", memberPhotoVO);
					RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/kolmeb/kolPhotoAddJspTwo.jsp");
					failureView.forward(req, res);
					return;
				}				
				
				/***************************2.開始新增資料***************************************/
				MemberPhotoService memberPhotoService = new MemberPhotoService();
				int meb_photonum = memberPhotoService.addMemberPhoto(memberPhotoVO);
				memberPhotoVO.setMeb_photonum(meb_photonum);
				req.setAttribute("memberPhotoVO", memberPhotoVO);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/kolBackStage/kolmeb/kolPhotoIndexJspTwo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交kolPhotoIndexJsp2.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
	            } catch (Exception e) {
	            req.setAttribute("memberPhotoVO", memberPhotoVO);
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/kolmeb/kolPhotoAddJspTwo.jsp");
				failureView.forward(req, res);
			}
		}
	
	
		if ("delete_kol".equals(action)) { // 來自companyPhotoIndexJsp.jsp的請求  
		
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
	
				try {
					/*************************** 1.接收請求參數 ***************************************/
					Integer meb_photonum = new Integer(req.getParameter("meb_photonum"));
	
					/*************************** 2.開始刪除資料 ***************************************/
					MemberPhotoService memberPhotoService = new MemberPhotoService();
					memberPhotoService.deleteMemberPhoto(meb_photonum);
	
					/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
					String url = "/kolBackStage/kolmeb/kolPhotoIndexJspTwo.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
	
					/*************************** 其他可能的錯誤處理 **********************************/
				} catch (Exception e) {
					errorMsgs.add("刪除資料失敗:" + e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/kolmeb/kolPhotoIndexJspTwo.jsp");
					failureView.forward(req, res);
			}
		}
		
		
		
		
		if ("update_kol".equals(action)) { // 來自kolPhotoUpdateJsp.jsp的請求  
				
				List<String> errorMsgs = new LinkedList<String>();
				req.setAttribute("errorMsgs", errorMsgs);
				MemberPhotoVO memberPhotoVO = new MemberPhotoVO();
				MemberPhotoService memberPhotoService = new MemberPhotoService();
	
				try {
					/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
					Integer meb_photonum = new Integer(req.getParameter("meb_photonum"));
					Part part = req.getPart("meb_photo");
					InputStream in = part.getInputStream();
					byte[] meb_photo = null;
					if (in.available() > 0) {
						meb_photo = new byte[in.available()];
						in.read(meb_photo);
					} else {
						memberPhotoVO = memberPhotoService.getOneMemberPhoto(meb_photonum);
						meb_photo = memberPhotoVO.getMeb_photo();
					}
	
					memberPhotoVO.setMeb_photonum(meb_photonum);
					memberPhotoVO.setMeb_photo(meb_photo);
	
					if (!errorMsgs.isEmpty()) {
						req.setAttribute("memberPhotoVO", memberPhotoVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/kolmeb/kolPhotoUpdateJspTwo.jsp");
						failureView.forward(req, res);
						return; // 程式中斷
					}
	
					/*************************** 2.開始修改資料 *****************************************/
					memberPhotoService.updateMemberPhoto(memberPhotoVO);
					
	
					/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
					req.setAttribute("memberPhotoVO", memberPhotoVO); // 資料庫update成功後,正確的的empVO物件,存入req
					String url = "/kolBackStage/kolmeb/kolPhotoIndexJspTwo.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
					successView.forward(req, res);
	
					/*************************** 其他可能的錯誤處理 *************************************/
				 } 	catch (Exception e) {
					errorMsgs.add("修改資料失敗:" + e.getMessage());
					RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/kolmeb/kolPhotoIndexJspTwo.jsp");
					failureView.forward(req, res);
				}
			}
		
		if ("getOne_For_Update_kol".equals(action)) { // 來自companyPhotoUpdateJsp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			MemberPhotoVO memberPhotoVO = new MemberPhotoVO();
			MemberPhotoService memberPhotoService = new MemberPhotoService();
	
			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				Integer meb_photonum = new Integer(req.getParameter("meb_photonum"));
				/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
				req.setAttribute("meb_photonum", meb_photonum); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/kolBackStage/kolmeb/kolPhotoUpdateJspTwo.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
	
				/*************************** 其他可能的錯誤處理 *************************************/
			 } 	catch (Exception e) {
				errorMsgs.add("修改資料失敗:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/kolBackStage/kolmeb/kolPhotoIndexJspTwo.jsp");
				failureView.forward(req, res);
			}
		}
		
	}
}