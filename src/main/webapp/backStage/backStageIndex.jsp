<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.backStage.model.*"%>
<%@ include file="header.jsp"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>
<%
BackStageService backStageSvc = new BackStageService();
List list = backStageSvc.getOrderMasterNew();
pageContext.setAttribute("list", list);
List list1 = backStageSvc.getKolPhoto();
pageContext.setAttribute("list1", list1);
Integer orderMastercount = backStageSvc.orderMastercount();
pageContext.setAttribute("orderMastercount", orderMastercount);
Integer companyMebcount = backStageSvc.companyMebcount();
pageContext.setAttribute("companyMebcount", companyMebcount);
Integer kolMebcount = backStageSvc.kolMebcount();
pageContext.setAttribute("kolMebcount", kolMebcount);
%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">系統首頁</h1>
				</div>
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
						<a href="/mether/backStage/order/meb_orderlist.jsp"
							class="small-box-footer">More info <i
							class="fas fa-arrow-circle-right"></i>
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
						<a href="/mether/backStage/com/meb_com.jsp"
							class="small-box-footer">More info <i
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
						<a href="/mether/backStage/kol/meb_kol.jsp"
							class="small-box-footer">More info <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
			</div>
			<!-- 最新訂單 -->

			<div class="row">
				<h3 class="m-0">最新訂單</h3>
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

			<!-- 最新用戶 -->
			<div class="row">
				<h3 class="m-0">最新用戶</h3>
			</div>
			<div class="invoice p-3 mb-3">
				<div class="row">
					<div class="col-12 table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>會員帳號</th>
									<th>會員名稱</th>
									<th>會員照片</th>
									<th>註冊時間</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="KolPhotoVO" items="${list1}"
									begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
									<tr>
										<td>${KolPhotoVO.kol_account}</td>
										<td>${KolPhotoVO.kol_name}</td>
										<td><img class="img-circle"
											style="max-width: 70px; min-height: 70px"
											src="<%=request.getContextPath()%>/ReadMemberPhoto?meb_photonum=${KolPhotoVO.meb_photonum}"
											alt="User Avatar"></td>
										<td>${KolPhotoVO.kol_regdate}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<%@ include file="footer.jsp"%>