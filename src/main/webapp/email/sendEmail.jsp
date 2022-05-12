<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%@ page import="java.util.*"%>

<%
ProductService productService = new ProductService();
List<ProductVO> list = productService.getAll();
String replyAccount = (String) request.getAttribute("replyAccount");
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
										name="mem_account" placeholder="To:" value="${replyAccount}">
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

<%@ include file="footer.jsp"%>