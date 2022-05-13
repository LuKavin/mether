<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.backStage.model.*"%>
<%@ include file="header.jsp"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>
<%
BackStageService backStageSvc = new BackStageService();
Integer orderMastercount = backStageSvc.orderMastercount();
List list = backStageSvc.getNew();
pageContext.setAttribute("orderMastercount", orderMastercount);
pageContext.setAttribute("list", list);
Integer companyMebcount = backStageSvc.companyMebcount();
pageContext.setAttribute("companyMebcount", companyMebcount);
Integer kolMebcount = backStageSvc.kolMebcount();
pageContext.setAttribute("kolMebcount", kolMebcount);
%>


<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>後台管理系統</title>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">系統首頁</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">■測試用管理員■</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-purple">
						<div class="inner">
							<h3>訂單數量</h3>
							<p>${orderMastercount}筆訂單</p>
						</div>
						<div class="icon">
							<i class="ion ion-clipboard"></i>
						</div>
						<a href="meb_orderlist.jsp" class="small-box-footer">More info
							<i class="fas fa-arrow-circle-right"></i>
						</a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-success">
						<div class="inner">
							<h3>廠商數量</h3>
							<p>${companyMebcount}人</p>
						</div>
						<div class="icon">
							<i class="ion ion-briefcase"></i>
						</div>
						<a href="meb_com.jsp" class="small-box-footer">More info <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-pink">
						<div class="inner">
							<h3>網紅數量</h3>
							<p>${kolMebcount}人</p>
						</div>
						<div class="icon">
							<i class="ion ion-person-add"></i>
						</div>
						<a href="meb_kol.jsp" class="small-box-footer">More info <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
			</div>
			<div class="row">
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-warning">
						<div class="inner">
							<h3>媒合成功率</h3>
							<p>87 %</p>
						</div>
						<div class="icon">
							<i class="ion ion-pie-graph"></i>
						</div>
						<a href="#" class="small-box-footer">More info <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-orange">
						<div class="inner">
							<h3>總瀏覽量</h3>
							<p>187 瀏覽</p>
						</div>
						<div class="icon">
							<i class="ion ion-ios-eye"></i>
						</div>
						<a href="#" class="small-box-footer">More info <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-cyan">
						<div class="inner">
							<h3>我的信箱</h3>
							<p>817 封信</p>
						</div>
						<div class="icon">
							<i class="ion ion-ios-email-outline"></i>
						</div>
						<a href="meb_mailinbox.jsp" class="small-box-footer">More info
							<i class="fas fa-arrow-circle-right"></i>
						</a>
					</div>
				</div>
				<!-- ./col -->
			</div>
			<div class="row">
				<!-- 最新訂單 -->
				<div class="col-md-6 small-box">
					<div class="row">
						<h3 class="m-0">
							最新訂單
							</h1>
					</div>
					<div class="invoice p-3 mb-3">
						<div class="row">
							<div class="col-12 table-responsive">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>訂單編號</th>
											<th>商品名稱</th>
											<th>商品期限</th>
											<th>訂單狀態</th>
											<th>訂單日期</th>
										</tr>
									</thead>

									<tbody>
										<%@ include file="page1.file"%>
										<c:forEach var="orderMasterVO" items="${list}"
											begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
											<tr>
												<td>${orderMasterVO.order_num}</td>
												<td>${orderMasterVO.product_name}</td>
												<td>${orderMasterVO.product_deadline}</td>
												<td>${orderMasterVO.order_status}</td>
												<td>${orderMasterVO.order_date}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<%@ include file="page2.file"%>
							</div>
						</div>
					</div>
				</div>
				<!-- 最新用戶 -->

				<div class="col-md-6 small-box">
					<div class="row">
						<h3 class="m-0">
							最新用戶
							</h1>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="card card-widget widget-user shadow-lg">
								<div class="widget-user-header text-white"
									style="background: url('dist/img/photo2.png') center center;">
								</div>
								<div class="widget-user-image">
									<img class="img-circle" src="dist/img/user6-128x128.jpg"
										alt="User Avatar">
								</div>
								<div class="card-footer">
									<p class="widget-user-username text-center">Pokemon</p>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="card card-widget widget-user shadow-lg">
								<div class="widget-user-header text-white"
									style="background: url('dist/img/photo1.png') center center;">
								</div>
								<div class="widget-user-image">
									<img class="img-circle" src="dist/img/user3-128x128.jpg"
										alt="User Avatar">
								</div>
								<div class="card-footer">
									<p class="widget-user-username text-center">Pokemon</p>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="card card-widget widget-user shadow-lg">
								<div class="widget-user-header text-white"
									style="background: url('dist/img/photo4.jpg') center center;">
								</div>
								<div class="widget-user-image">
									<img class="img-circle" src="dist/img/user1-128x128.jpg"
										alt="User Avatar">
								</div>
								<div class="card-footer">
									<p class="widget-user-username text-center">Pokemon</p>
								</div>
							</div>
						</div>


					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="card card-widget widget-user shadow-lg">
								<div class="widget-user-header text-white"
									style="background: url('dist/img/photo3.jpg') center center;">
								</div>
								<div class="widget-user-image">
									<img class="img-circle" src="dist/img/user7-128x128.jpg"
										alt="User Avatar">
								</div>
								<div class="card-footer">
									<p class="widget-user-username text-center">Pokemon</p>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="card card-widget widget-user shadow-lg">
								<div class="widget-user-header text-white"
									style="background: url('dist/img/avatar5.png') center center;">
								</div>
								<div class="widget-user-image">
									<img class="img-circle" src="dist/img/user5-128x128.jpg"
										alt="User Avatar">
								</div>
								<div class="card-footer">
									<p class="widget-user-username text-center">Pokemon</p>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="card card-widget widget-user shadow-lg">
								<div class="widget-user-header text-white"
									style="background: url('dist/img/prod-2.jpg') center center;">
								</div>
								<div class="widget-user-image">
									<img class="img-circle" src="dist/img/user8-128x128.jpg"
										alt="User Avatar">
								</div>
								<div class="card-footer">
									<p class="widget-user-username text-center">Pokemon</p>
								</div>
							</div>
						</div>


					</div>


				</div>

			</div>
		</div>
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<%@ include file="footer.jsp"%>