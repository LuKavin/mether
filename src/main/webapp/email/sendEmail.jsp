<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%@ page import="java.util.*"%>

<%
ProductService productService = new ProductService();
List<ProductVO> list = productService.getAll();
pageContext.setAttribute("list", list);
%>

<%@ include file="header.jsp"%>
<div class="content-wrapper">
	<section class="content">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="container h2 jntest" style="text-align: center;">寄信</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-9">
				<div class="card card-warning card-outline">
					<div class="card-header">
						<div class="row ">
							<div class="col-sm-6" style="padding: 10px">
								<i class="fa fa-paper-plane-o" aria-hidden="true"
									style="font-size: 22px;"> 寄信</i>
							</div>
							<div class="col-sm-6">
								<div class="btn btn-outline-warning pull-right cln-send">清空重寫
								</div>
							</div>
						</div>
					</div>

					<div class="card-body">
						<form action="<%=request.getContextPath()%>/email/email.do">
							<div class="row m-2">
								<a href="#"
									class="col-sm-2 col-form-label btn-outline-info text-center">收件者：</a>
								<div class="col-sm-10">
									<input type="text" class="form-control send-to"
										name="mem_account" placeholder="To:">
								</div>
							</div>
							<div class="row m-2">
								<label class="col-sm-2 col-form-label text-center">標題：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control send-subject"
										name="email_title" placeholder="Subject:">
								</div>
							</div>
							<div class="form-group">
								<div id="summernote"></div>
							</div>
							<div class="form-group">
							</div>
							<div class="card-footer">
								<input type="hidden" name="action" value="insert">
								<input type="hidden" name="email_content" class="email_content" value="">
								<div class="float-right">
									<button type="button" class="btn btn-default">
										<i class="fas fa-pencil-alt"></i> Draft
									</button>
									<button type="submit" class="btn btn-warning sendOK">
										<i class="far fa-envelope"></i> Send
									</button>
								</div>
								<button type="reset" class="btn btn-default">
									<i class="fas fa-times"></i> Discard
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>

			<div class="col-md-2">
				<!--==側邊功能列表==-->
				<div class="card">
					<div class="card-header">
						<div class="row justify-content-center">
							<a href="<%=request.getContextPath()%>/email/sendEmail.jsp"
								class="btn btn-warning" style="padding: 5px 30px;"> <i
								class="fa fa-paper-plane-o" aria-hidden="true"> 寄信</i>
							</a>
						</div>
					</div>
					<ul class="nav nav-pills flex-column">
						<li class="nav-item active"><a href="meb_mailinbox.html"
							class="nav-link"> <i class="fas fa-inbox"></i> 收件夾 <span
								class="badge bg-primary float-right">2</span>
						</a></li>
						<li class="nav-item"><a href="#" class="nav-link"> <i
								class="far fa-file-alt"></i> 草稿夾
						</a></li>
						<li class="nav-item"><a href="#" class="nav-link"> <i
								class="far fa-trash-alt"></i> 垃圾桶
						</a></li>
					</ul>
				</div>
				<c:if test="${not empty errorMsgs}">
					<font style="color: red">請修正以下錯誤:</font>
					<ul>
						<c:forEach var="message" items="${errorMsgs}">
							<li style="color: red">${message}</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
		</div>





























	</section>
</div>
</div>
<%@ include file="footer.jsp"%>