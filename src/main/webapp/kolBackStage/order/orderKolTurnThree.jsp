<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%@ page import="java.util.*"%>

<%@ include file="header.jsp"%>
<%
ProductService productService = new ProductService();
// CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");//讀取登入者的資料
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
							<a href="/mether/kolBackStage/order/orderList.jsp">訂單列表</a>>交易流程>評價狀態
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
								style="width: 75%" aria-valuenow="25" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
						<div class="form-progress-indicator one active">
							<div class="text-box" style="color: #E0E0E0">製作中</div>
						</div>
						<div class="form-progress-indicator two active">
							<div class="text-box" style="color: #E0E0E0">審核中</div>
						</div>
						<div class="form-progress-indicator three active">
							<div class="text-box" style="color: #E0E0E0">審核成功</div>
						</div>
						<div class="form-progress-indicator four active">
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
								<p>${com_account}</p>
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
										<div class="card card-warning card-outline">
											<div class="card-header">
												<div class="container h4"
													style="text-align: center; background-color: rgb(222, 239, 222);">
													給予廠商評價 <i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
												</div>
											</div>
											<div class="card-body">

												<form
													action="<%=request.getContextPath()%>/order/orderKol.do" class="rateForm">

    <div class="star-rating">
      <div class="star-rating__wrap">
        <input class="star-rating__input" id="star-rating-5" type="radio" name="com_star" value="5" checked="checked">
        <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-5" title="5 out of 5 stars"></label>
        <input class="star-rating__input" id="star-rating-4" type="radio" name="com_star" value="4">
        <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-4" title="4 out of 5 stars"></label>
        <input class="star-rating__input" id="star-rating-3" type="radio" name="com_star" value="3">
        <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-3" title="3 out of 5 stars"></label>
        <input class="star-rating__input" id="star-rating-2" type="radio" name="com_star" value="2">
        <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-2" title="2 out of 5 stars"></label>
        <input class="star-rating__input" id="star-rating-1" type="radio" name="com_star" value="1">
        <label class="star-rating__ico fa fa-star-o fa-lg" for="star-rating-1" title="1 out of 5 stars"></label>
      </div>
    </div>











													<div class="form-group">
														<label>評分留言:</label>
														<div class="input-group">
															<div class="input-group-prepend">
																<span class="input-group-text"> <i
																	class="fa fa-handshake-o" aria-hidden="true"></i>
																</span>
															</div>
															<textarea class="form-control" inputmode="numeric"
																placeholder="請填入文字..." name="com_rate"
																style="height: 80px">請大家多多與他交易～</textarea>
														</div>

													</div>
													<div class="row trade-head m-3">
														<button type="button"
															class="btn  btn-outline-success ml-auto rateBtn">送出評價</button>
													</div>
													<input type="hidden" name="action" value="rateOK">
													<input type="hidden" name="order_num" value="${order_num}">
												</form>

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

