<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.emailDetail.model.*"%>
<%@ page import="java.util.*"%>

<%
EmailDetailVO emailDetailVO = (EmailDetailVO) request.getAttribute("emailDetailVO");
%>


<%@ include file="header.jsp"%>
<div class="content-wrapper">
	<section class="content">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="container h2 jntest" style="text-align: center;">
					<i class="fa fa-envelope-o" aria-hidden="true"></i>信件
				</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<!--==縮排用間隔==-->
			<div class="col-md-9">
				<div class="card card-primary card-outline">
					<div class="card-header">
						<div class="row">
							<div class="col-sm-6">
								<h3 class="card-title">
									<i class="fa fa-envelope-open-o" aria-hidden="true"></i>
									${emailDetailVO.kol_account}寄給你
								</h3>
							</div>
							<div class="col-sm-6 text-right">
								<fmt:formatDate value="${emailDetailVO.email_date}"
									pattern="yyyy-MM-dd HH:mm" />
							</div>
						</div>
					</div>
					<div class="card-body p-0">
						<div class="table-responsive mailbox-messages"
							style="height: 300px">
							<div class="text-left h4"
								style="padding: 0 50px; margin: 13px 0 0 0;">${emailDetailVO.email_title}</div>
							<hr>
							<div class="container text-left" style="padding: 0 50px;">${emailDetailVO.email_content}</div>

						</div>
					</div>
					<div class="card-footer">
						<div class="row">
							<form action="<%=request.getContextPath()%>/email/admemail.do">
								<button type="submit" class="btn btn-outline-info btn-lg m-2">
									<i class="fa fa-hand-o-right" aria-hidden="true"></i>回信
								</button>
								<input type="hidden" name="action" value="reply">
								 <input type="hidden" name="replyAccount"value="${emailDetailVO.sender}">
							</form>
							<form action="<%=request.getContextPath()%>/email/admemail.do" class="trashCanForm">
								<button class="btn btn-outline-danger btn-lg m-2 trashCanBtn" type="button">
									<i class="fa fa-trash-o" aria-hidden="true"></i>刪除
								</button>
								<input type="hidden" name="action" value="toTrashCan">
								 <input type="hidden" name="deletePk"value="${emailDetailVO.email_num}">
							</form>
						</div>
					</div>
				</div>
			</div>
			<%@ include file="footer.jsp"%>