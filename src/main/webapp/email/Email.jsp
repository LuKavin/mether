<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.emailDetail.model.*"%>
<%@ page import="java.util.*"%>

<%
EmailDetailService emailDetailService = new EmailDetailService();
List<EmailDetailVO> list = emailDetailService.findMailBox("COM", "tibameCOM");
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
			<!--==縮排用間隔==-->
			<div class="col-md-9">
				<div class="card card-primary card-outline">
					<div class="card-header">
						<h3 class="card-title">收件夾</h3>
						<div class="card-tools">
							<!-- <div class="input-group input-group-sm">
                    <input type="text" class="form-control" placeholder="Search Mail">
                    <div class="input-group-append">
                      <div class="btn btn-primary">
                        <i class="fas fa-search"></i>
                      </div>
                    </div>
                  </div> -->
						</div>
					</div>
					<div class="card-body p-0">
						<div class="mailbox-controls">
							<!--Ｃｈｅｃｋｂｏｘ-->
							<label class="btn btn-default btn-sm checkbox-toggle "> <input
								type="checkbox" class="checkbox-master">
							</label>
							<!--Ｔｒａｓｈｃａｎ-->
							<label class="btn btn-default btn-sm trashcan"> <i
								class="far fa-trash-alt"></i>
							</label>
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
													<input type="checkbox" value="" id="check1" class="item">
													<label for="check1"></label>
												</div>
											</td>
											<td></td>
											<td class="mailbox-name"><a href="read-mail.html">${emailDetailVO.kol_account}</a></td>
											<td class="mailbox-subject">
												<form action="<%=request.getContextPath()%>/email/email.do">
													<input type="hidden" name="action" value="showletter">
													<input type="hidden" name="email_num" value="${emailDetailVO.email_num}">
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
							class="nav-link"> <i class="fas fa-inbox"></i> 收件夾 <!-- 							<span class="badge bg-primary float-right">2</span> -->
						</a></li>
						<li class="nav-item"><a href="#" class="nav-link"> <i
								class="far fa-file-alt"></i> 草稿夾
						</a></li>
						<li class="nav-item"><a href="#" class="nav-link"> <i
								class="far fa-trash-alt"></i> 垃圾桶
						</a></li>
					</ul>
				</div>
			</div>
		</div>


























	</section>
</div>
<%@ include file="footer.jsp"%>