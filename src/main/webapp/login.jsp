<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp" %>
<%
if(session.getAttribute("loginVo")!=null){
	request.getRequestDispatcher("/logined.jsp").forward(request, response);
};
%>

		<div class="content-wrapper">
			<section class="content">
        <div class="container ">
           <h1 class="text-center">簡易登入器</h1>
          <form action="<%=request.getContextPath()%>/login">
            <div class="row align-items-center justify-content-center">
              <input type="text" name="mebAccount"  placeholder="帳號">
            </div>
            <div class="row align-items-center justify-content-center">
              <input type="text" name="mebPassword" placeholder="密碼">
            </div>
            <div class="row align-items-center justify-content-center">
              <button type="submit">登入</button>
            </div>
          </form>
        </div>
		</section>
		</div>
		
		


<%@ include file="footer.jsp" %>