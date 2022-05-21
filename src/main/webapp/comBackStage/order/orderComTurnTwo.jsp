<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%@ page import="java.util.*"%>

<%@ include file="header.jsp"%>
<%
ProductService productService = new ProductService(); // CompanyMebVO companyMebVO=(CompanyMebVO)
session.getAttribute("companyMebVO");//讀取登入者的資料 List<ProductVO> list =
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
						<h1 class="m-0 aaa">
							<a href="/mether/comBackStage/order/orderList.jsp">訂單列表</a>>交易流程>廠商審核
						</h1>
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
								style="width: 25%" aria-valuenow="25" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
						<div class="form-progress-indicator one active">
							<div class="text-box" style="color: #E0E0E0">製作中</div>
						</div>
						<div class="form-progress-indicator two active">
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
							<div class="btn btn-danger ml-auto">取消交易</div>
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
														檢視作品</div>
												</div>
												<div class="card-body">


													<div class="card-body">
														<div class="form-group">
															<label>細項:</label>
															<div class="input-group">
																<div class="input-group-prepend">
																	<span class="input-group-text"> <i
																		class="fa fa-file-powerpoint-o" aria-hidden="true"></i></span>
																</div>
																<input type="text" class="form-control"
																	inputmode="numeric">
															</div>

														</div>
														<div class="form-group">
															<div class="input-group">
																<div class="input-group-prepend">
																	<span class="input-group-text"><i
																		class="far fa-calendar-alt"></i></span>
																</div>
																<input type="text" class="form-control"
																	inputmode="numeric">
															</div>
														</div>
														<form action="<%=request.getContextPath()%>/order/orderCom.do" class="checkOKForm">
															<div class="row trade-head m-3">
																<button type="button" class="btn  btn-outline-success ml-auto checkOK">
																		審核完成
																</button>
															</div>
															<input type="hidden" name="action" value="checkOK">
															<input type="hidden" name="order_num" value="${order_num}">
														</form>
													</div>
												</div>
											</div>
										</div>
										<!-- 留言板頁籤 -->
										<div class="tab-pane fade" id="custom-tabs-one-profile"
											role="tabpanel" aria-labelledby="custom-tabs-one-profile-tab">
											<div class="card card-warning card-outline">
												<div class="card-header">
													<div class="row">
														<div class="container h4"
															style="text-align: center; background-color: rgb(234, 240, 250);">
															留言者對象：顯示廠商/網紅</div>
													</div>
													<div class="row">
														<div class="col-sm-2 p-1">
															<h5>標題：</h5>
														</div>
														<p>！！！動態抓出→標題←區塊！！！</p>
													</div>
												</div>
												<div class="card-body">！！！動態抓出→內容←區塊！！！</div>
											</div>
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
															<input type="email"
																class="form-control send-subject msg_title"
																placeholder="Subject:">
														</div>
													</div>
													<div class="form-group">
														<div id="summernote"></div>
													</div>
													<div class="card-footer">
														<div class="float-right">
															<button class="btn btn-warning msg-ok" type="submit">留言</button>
														</div>
													</div>
												</div>
											</div>
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