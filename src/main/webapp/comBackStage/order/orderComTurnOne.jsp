<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.message_detail.model.MessageDetailVO"%>
<%@page import="com.message_detail.model.MessageDetailService"%>
<%@page import="com.order_master.model.OrderMasterVO"%>
<%@ page import="com.product.model.*"%>
<%@ page import="java.util.*"%>

<%@ include file="header.jsp"%>
<%
session.getAttribute("companyMebVO");//讀取登入者的資料
%>
<%
OrderMasterVO orderMasterVO = (OrderMasterVO) request.getAttribute("orderMasterVO");
MessageDetailService messageDetailService = new MessageDetailService();
List<MessageDetailVO> list = messageDetailService.getMessageDetailList(orderMasterVO.getOrder_num());
pageContext.setAttribute("list", list);
%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<!-- Main content -->

	<section class="content">
		<div class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1 class="m-0 aaa"><a href="/mether/comBackStage/order/orderList.jsp">訂單列表</a>>交易流程>網紅編輯</h1>
					</div>
					<!-- /.col -->
					<div class="col-sm-3">
						<!-- 錯誤列表 -->
						<c:if test="${not empty errorMsgs}">
							<font style="color: red">請修正以下錯誤:</font>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color: red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>
					</div>
					<div class="col-sm-3"></div>
				</div>
			</div>
		</div>


		<section class="content">
			<!-- 倒數計時器 -->
			<!-- <div class="row">
          <div class="container time-outbox h1" style="text-align: center;color: red;">
            倒數計時器：00天00分00
          </div>
        </div> -->
			<div class="row p-4">
				<!-- =====進度條===== -->
				<div class="col-sm-12">
					<div class="form-progress">
						<div class="progress" style="width: 500px;">
							<div class="progress-bar bg-success" role="progressbar"
								style="width: 0%" aria-valuenow="25" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
						<div class="form-progress-indicator one active">
							<div class="text-box">製作中</div>
						</div>
						<div class="form-progress-indicator two">
							<div class="text-box">審核中</div>
						</div>
						<div class="form-progress-indicator three">
							<div class="text-box">審核成功</div>
						</div>
						<div class="form-progress-indicator four">
							<div class="text-box">評價中</div>
						</div>
						<div class="form-progress-indicator five">
							<div class="text-box">交易完成</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- 無意義的切版區塊 -->
				<div class="col-sm-2"></div>
				<!-- ===================主內容=================== -->
				<div class="col-sm-8">

					<!-- 主內容標頭 -->
					<div class="container">
					
                    <!-- 標頭 -->
						<div class="row trade-head m-3">
							<p>交易對象：</p>
							<a href="#">
								<p>${kol_account}</p>
							</a>
						</div>
					</div>
					<!--  -->
					<!-- 第一步 -->
					<!--  -->
					<div class="row trade-step2 ">
						<!-- 第一部內容 -->
						<div class="container">
							<div class="card card-tabs">
								<!-- 頁籤按鈕 -->
								<div class="card-header p-0 pt-1">
									<ul class="nav nav-tabs" id="custom-tabs-one-tab"
										role="tablist">
										<li class="nav-item"><a class="nav-link active"
											id="custom-tabs-one-home-tab" data-toggle="pill"
											href="#custom-tabs-one-home" role="tab"
											aria-controls="custom-tabs-one-home" aria-selected="true">交易</a>

										</li>
										<li class="nav-item"><a class="nav-link"
											id="custom-tabs-one-profile-tab" data-toggle="pill"
											href="#custom-tabs-one-profile" role="tab"
											aria-controls="custom-tabs-one-profile" aria-selected="false">留言板</a>
										</li>
									</ul>
								</div>
								<div class="card-body">
									<div class="tab-content" id="custom-tabs-one-tabContent">
										<div class="tab-pane fade active show"
											id="custom-tabs-one-home" role="tabpanel"
											aria-labelledby="custom-tabs-one-home-tab">
											<!-- 交易區塊頁籤 -->
											<div class="card card-warning card-outline">
												<div class="card-header">
													<div class="container h4"
														style="text-align: center; background-color: rgb(222, 239, 222);">
														待網紅編輯</div>
												</div>
												<div class="card-body">
													<div class="row trade-step1 ">
														<div class="container wtforkol-box">
															<h1 class="wtforkol" style="margin: 120px 0">待網紅編輯</h1>
														</div>
													</div>
												</div>
											</div>
										</div>



										<!-- 留言板頁籤 -->
										<div class="tab-pane fade" id="custom-tabs-one-profile"
											role="tabpanel" aria-labelledby="custom-tabs-one-profile-tab">
											
											<c:forEach var="messageDetailVO" items="${list}">

												<div
													class="card ${(messageDetailVO.com_message)!=null?'card-primary':'card-danger'} card-outline">
													<div class="card-header">
														<div class="row">
															<div class="container h4"
																style="text-align: center; background-color: ${(messageDetailVO.com_message)!=null?'rgb(234, 240, 250)':'rgb(250, 235, 234)'}">
																${(messageDetailVO.com_message)!=null?'廠商':'網紅'}</div>
														</div>
														<div class="row">
															<div class="col-sm-2 p-1">
																<h5>標題：</h5>
															</div>
															<div class="col-sm-2 p-1 h5">
																<p>${messageDetailVO.mes_topic}</p>
															</div>
															<div class="col-sm-8 p-1">
																<p class=" float-right">
																	<fmt:formatDate
																		value="${messageDetailVO.mes_date_time}"
																		pattern="yyyy-MM-dd HH:mm" />
																</p>
															</div>
														</div>
													</div>
	<div class="card-body">
		<div class="row">
			<div class="col-sm-6 h5">
				${(messageDetailVO.com_message)!=null?messageDetailVO.com_message:messageDetailVO.kol_message}
			</div>
			<div class="col-sm-6">
			<a href="<%=request.getContextPath()%>/messageViewpic?mes_num=${messageDetailVO.mes_num}"><img src="<%=request.getContextPath()%>/messageViewpic?mes_num=${messageDetailVO.mes_num}"
				alt="" style="max-width: 50px;"></a>
			</div>
		</div>
	</div>
												</div>
											</c:forEach>
											<FORM method="POST" enctype="multipart/form-data"
												ACTION="<%=request.getContextPath()%>/message/comMessage.do">
												<div class="card card-warning card-outline msg-input">
													<div class="card-header">
														<div class="row ">
															<div class="col-sm-6"></div>
															<div class="col-sm-6">
																<div class="btn btn-outline-warning pull-right cln-send">
																	清空重寫</div>
															</div>
														</div>
													</div>
													<div class="card-body">
														<div class="row m-2">
															<label class="col-sm-2 col-form-label text-center">標題：</label>
															<div class="col-sm-10">
																<input type="text" name="mes_topic"
																	class="form-control send-subject mes_topic"
																	placeholder="Subject:">
															</div>
														</div>
														<textarea class="form-control" inputmode="numeric"
															placeholder="請填入文字..." name="message"
															style="height: 80px"></textarea>
														<div class="card-footer">
															<div class="float-left">
																上傳圖片：<input type="file" class="mes_pic" name="mes_pic">
															</div>
															<div class="float-right">
																<input type="hidden" name="order_num"
																	value="${orderMasterVO.order_num}"> <input
																	type="hidden" name="order_status" value="製作中">
																<button class="btn btn-warning msgOKbtn" type="submit">留言</button>
															</div>
														</div>
													</div>
												</div>
											</FORM>
										</div>




									</div>
								</div>

							</div>
						</div>
					</div>
				</di>
			</div>
			<!-- 無意義的切版區塊 -->
			<div class="col-sm-2"></div>
		</section>
	</section>
</div>
<!-- </div> 多的標籤???網頁沒問題就刪掉-->

<%@ include file="footer.jsp"%>

