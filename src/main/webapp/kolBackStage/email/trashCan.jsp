<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.login.*"%>
<%@ page import="com.emailDetail.model.*"%>
<%@ page import="java.util.*"%>

<%@ include file="header.jsp"%>
<%
EmailDetailService emailDetailService = new EmailDetailService();
//KolMebVO kolMebVO = (KolMebVO) session.getAttribute("kolMebVO");//讀取登入者的資料 這段有寫在header.jsp上
List<EmailDetailVO> list = emailDetailService.findBox(kolMebVO.getKol_account(),3);
pageContext.setAttribute("list", list);
%>

<div class="content-wrapper">
	<section class="content">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="container h2 jntest" style="text-align: center;">垃圾桶</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<!--==縮排用間隔==-->
			<div class="col-md-9">
				<div class="card card-danger card-outline">
					<div class="card-header">
						<div class="row m-2">
							<i class="fa fa-envelope-open-o" aria-hidden="true"
								style="font-size: 22px;"> <span style="color:orange">${kolMebVO.kol_account}</span> 的垃圾信</i>
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
								<form METHOD="post" action="<%=request.getContextPath()%>/email/kolEmail.do"
									class="deleteForm" style="margin: 0;">
									<button class="btn btn-default btn-lg deleteBtn" type="button"
										style="display: inline;">
										<i class="far fa-trash-alt"></i>
									</button>
									<input type="hidden" name="action" value="delete">
								</form>
								<form METHOD="post" action="<%=request.getContextPath()%>/email/kolEmail.do"
									class="rollBackForm" style="margin: 0;">
									<button class="btn btn-default btn-lg rollBackBtn" type="button"
										style="display: inline;">
										<i class="fa fa-reply-all" aria-hidden="true"></i>
									</button>
									<input type="hidden" name="action" value="rollBack">
								</form>
							</div>
						</div>

						<div class="table-responsive mailbox-messages">
							<table class="table table-hover table-striped mailtable">
								<thead>
									<tr>
										<td></td>
										<td class="star"></td>
										<td class="name"><b>寄件者</b></td>
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
														<input type="hidden" name="emailType" class="emailType" value="${emailDetailVO.email_typenum}">
												</div>
											</td>
											<td></td>
											<td class="mailbox-name">
												<form METHOD="post" action="<%=request.getContextPath()%>/email/kolEmail.do">
													<button type="submit" class="btn btn-link btn-sm ">${(emailDetailVO.sender==null)?"<p style='color:green'>草稿</p>":emailDetailVO.sender}</button>
													<input type="hidden" name="action" value="reply"> <input
														type="hidden" name="replyAccount" class="sender"
														value="${(emailDetailVO.sender==null)?'draft':emailDetailVO.sender}">
												</form></td>
											<td class="mailbox-subject">
												<form METHOD="post" action="<%=request.getContextPath()%>/email/kolEmail.do">
													<input type="hidden" name="action" value="showletter">
													<input type="hidden" name="email_num" class="email_num"
														value="${emailDetailVO.email_num}">
													<button type="submit" class="btn btn-link btn-sm">
														<b style="${(emailDetailVO.sender=='ADM')?'background:rgb(233, 191, 191)':''}">${emailDetailVO.email_title}</b>
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