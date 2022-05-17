package com.companymeb.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.companymeb.model.CompanyMebService;
import com.kolmeb.model.KolMebService;


@WebServlet("/companymeb/ForgetPassword.do")
public class MebMailService extends HttpServlet{
	

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
	    res.setContentType("text/html; charset=UTF-8");
	    
	    String action = req.getParameter("action");
	    String to = req.getParameter("email");
	    String newmethod = genAuthCode();
	    CompanyMebService companyMebService = new CompanyMebService();
	    KolMebService kolMebService = new KolMebService();
	    Integer com_idnum = companyMebService.getOneCompanyEmail(to);
	    Integer kol_idnum = kolMebService.getOneKolEmail(to);
	    
		    
	    if(com_idnum!=null || kol_idnum!=null) {
	    	
	 	   	try {
			   // 設定使用SSL連線至 Gmail smtp Server
			   Properties props = new Properties();
			   props.put("mail.smtp.host", "smtp.gmail.com");
			   props.put("mail.smtp.socketFactory.port", "465");
			   props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			   props.put("mail.smtp.auth", "true");
			   props.put("mail.smtp.port", "465");

			   // ●設定 gmail 的帳號 & 密碼 (將藉由你的Gmail來傳送Email)
			   // ●須將myGmail的【安全性較低的應用程式存取權】打開
			   final String myGmail = "methercomany@gmail.com";
			   final String myGmail_password = "tga101mether";
			   Session session = Session.getInstance(props, new Authenticator() {
				   protected PasswordAuthentication getPasswordAuthentication() {
					   return new PasswordAuthentication(myGmail, myGmail_password);
				   }
			   });

			   Message message = new MimeMessage(session);
			   message.setFrom(new InternetAddress(myGmail));
			   message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			   
			   String subject = "Mether會員新密碼通知";
			   String messageText = "親愛的會員您好:" + "\n" + "本公司將提供一組新的密碼給您，請使用此密碼"+ newmethod +"登入。登入成功後，請記得至會員中心更改密碼喔，謝謝";
			  
			   //設定信中的主旨  
			   message.setSubject(subject);
			   //設定信中的內容 
			   message.setText(messageText);
			   if(com_idnum!=null) 
			    companyMebService.updateCompanyPassword(to, newmethod);
			   
			   if(kol_idnum!=null) 
				kolMebService.updateKolPassword(to, newmethod);
			   
			   Transport.send(message);
			   System.out.println("傳送成功!");
			   String url = "/forgetpassword/companyMebJspForgetPassword2.jsp";
			   RequestDispatcher successView = req.getRequestDispatcher(url);
			   successView.forward(req, res);
			   
		   	 } catch (Exception e){
		   	   System.out.println("傳送失敗!");
		   	   e.printStackTrace();
		   	   RequestDispatcher failureView = req.getRequestDispatcher("/forgetpassword/companyMebJspForgetPasswordError.jsp");
		   	   failureView.forward(req, res);
		   	}
	    }	else {
	    	System.out.println("查無此人!");
	    	RequestDispatcher failureView = req.getRequestDispatcher("/forgetpassword/companyMebJspForgetPasswordError.jsp");
		   	failureView.forward(req, res);
	    }		
	}
	
	
	public static String genAuthCode() {
		//數字: 48~57
		//大寫英文字母: 65~90
		//小寫英文字母: 97~122
		
		int index = 0;
		char code []= new char [62];
		char randomnum [] = new char [8];
		String inputnum = "";
		
		for(int w = 48 ; w < 58; w ++) {
			code[index] = (char) w;
			index++;
		}
		
		for(int e = 65 ; e < 91 ; e++) {
			code[index] = (char) e;
			index++;
		}
		
		for(int r = 97 ; r < 123 ; r++) {
			code[index] = (char) r;
			index++;
		}
		
		for(int t = 0 ; t < randomnum.length ; t++) {
			inputnum += code[(int)(Math.random()*62)];
		}
		
		return inputnum;
		
		
		
		
	}
	
}
