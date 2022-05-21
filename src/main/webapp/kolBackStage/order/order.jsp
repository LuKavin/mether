<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%@ page import="java.util.*"%>

<%@ include file="header.jsp"%>
<%
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
						<h1 class="m-0 aaa"><a href="/mether/kolBackStage/order/orderList.jsp">訂單列表</a></h1>
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
								style="width: 100%" aria-valuenow="25" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
						<div class="form-progress-indicator one active">
							<div class="text-box" style="color:#E0E0E0">製作中</div>
						</div>
						<div class="form-progress-indicator two active">
							<div class="text-box" style="color:#E0E0E0">審核中</div>
						</div>
						<div class="form-progress-indicator three active">
							<div class="text-box" style="color:#E0E0E0">審核成功</div>
						</div>
						<div class="form-progress-indicator four active">
							<div class="text-box" style="color:#E0E0E0">評價中</div>
						</div>
						<div class="form-progress-indicator five active">
							<div class="text-box" style="color:#E0E0E0">交易完成</div>
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
								<p>xxx</p>
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

													<div class="card-body">
													<div class="row trade-step1 ">
														<div class="container" style="background-color: rgb(239, 211, 239)">
															<h1 class="wtforkol" style="margin: 120px 0; color:red">交易結束</h1>
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

<%@ include file="footer.jsp"%>

