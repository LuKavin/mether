<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.login.*"%>
<%@ page import="com.emailDetail.model.*"%>
<%@ page import="java.util.*"%>

<%@ include file="header.jsp"%>
<%
EmailDetailService emailDetailService = new EmailDetailService();
//CcompanyMebVO companyMebVO = (CcompanyMebVO) session.getAttribute("companyMebVO");這段有寫在header.jsp上
List<EmailDetailVO> list = emailDetailService.findBox(companyMebVO.getCom_account(),2);
pageContext.setAttribute("list", list);
%>

<div class="content-wrapper">
	<section class="content">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="container h2 jntest" style="text-align: center;">草稿夾</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<!--==縮排用間隔==-->
			<div class="col-md-9">
				<div class="card card-success  card-outline">
					<div class="card-header">
						<div class="row m-2">
							<i class="fa fa-envelope-open-o" aria-hidden="true"
								style="font-size: 22px;"> <span style="color:orange">${companyMebVO.com_account}</span> 的草稿夾</i>
						</div>
					</div>
					<div class="card-body p-0">
						<div class="mailbox-controls">
							<div class="row align-items-center">
								<label class="btn btn-default btn-lg checkbox-toggle"
									style="display: inline; padding: 8px 12px; height: 38px; width: 48px; margin: 0 15px;">
									<input type="checkbox" class="checkbox-master "
									style="width: 20px; height: 20px;">
								</label>
								<form METHOD="post" action="<%=request.getContextPath()%>/email/email.do"
									class="trashCanForm" style="margin: 0;" >
									<button class="btn btn-default btn-lg trashCanBtn"
										type="button" style="display: inline;">
										<i class="far fa-trash-alt"></i>
									</button>
									<input type="hidden" name="action" value="toTrashCan">
								</form>
							</div>
						</div>

						<div class="table-responsive mailbox-messages">
							<table class="table table-hover table-striped mailtable">
								<thead>
									<tr>
										<td></td>
										<td class="star"></td>
										<td class="name"><b></b></td>
										<td class="subject"><b>信件標題</b></td>
										<td class="attachment"></td>
										<td class="date"><b>日期</b></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="emailDetailVO" items="${list}">
										<tr>
											<td>
												<div class="icheck-primary">
													<input type="checkbox" value="" id="check1"
														class="item checkdelete" name="checkdelete"
														style="width: 20px; height: 20px;"> <label
														for="check1"></label>
												</div>
											</td>
											<td></td>
											<td class="mailbox-name">
												</td>
											<td class="mailbox-subject">
												<form METHOD="post" action="<%=request.getContextPath()%>/email/email.do">
													<input type="hidden" name="action" value="draftSend">
													<input type="hidden" name="email_num" class="email_num"
														value="${emailDetailVO.email_num}">
													<button type="submit" class="btn btn-link btn-sm">
														<b>${emailDetailVO.email_title}</b>
													</button>

												</form>
											</td>
											<td class="mailbox-attachment"></td>
											<td class="mailbox-date"><fmt:formatDate
													value="${emailDetailVO.email_date}"
													pattern="yyyy-MM-dd HH:mm" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<%@ include file="footer.jsp"%>