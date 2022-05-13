<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp" %>
<%

%>

		<div class="content-wrapper">
			<section class="content">
        <div class="container ">
        <h1 class="text-center">此帳號已登入</h1>
          <form action="<%=request.getContextPath()%>/login">
            <div class="row align-items-center justify-content-center">
              <input type="hidden" name="action" value="signOut">
              <button type="submit">點我登出</button>
            </div>
          </form>
        </div>
		</section>
		</div>
		
		


<%@ include file="footer.jsp" %>