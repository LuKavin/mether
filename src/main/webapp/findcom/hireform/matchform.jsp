<%@ page import="com.match_form.model.MatchFormVO"%>
<%@ page import="com.match_form.model.MatchService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.*"%>
<%@ page import="com.companymeb.model.*"%>
<%@ page import="com.kolmeb.model.KolMebVO"%>
<%@ page import="com.match_form.*"%>
<%@ page import="com.product.model.*"%>

<%@page import="com.kolmeb.model.KolMebVO"%>
<%
KolMebVO kolMebVO = (KolMebVO) session.getAttribute("kolMebVO");//讀取登入者的資料
%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>後台管理系統</title>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- jncss -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/kolBackStage/resources/css/awsome.css"
	type="text/css">
<!-- bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<!-- admin-lte -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/3.2.0/css/adminlte.min.css"
	integrity="sha512-IuO+tczf4J43RzbCMEFggCWW5JuX78IrCJRFFBoQEXNvGI6gkUw4OjuwMidiS4Lm9Q2lILzpJwZuMWuSEeT9UQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- summer note -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/kolBackStage/resources/summernote/summernote-bs4.min.css">

<style>
.preview_img {
	max-width: 280px;
	max-height: 300px;
}
</style>


</head>
<!-- ============================================================================================================================================================ -->
<!---->
<!---->
<!---->
<!---->
<!---->
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<!--===========================================以下為重複出現部分============================================================================= -->

		<!--ＮＡＶＢＡＲ-->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<ul class="navbar-nav">
				<!--ＳＩＤＥＢＡＲ漢堡-->
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
			</ul>

		</nav>
		<!--ＳＩＤＥＢＡＲ-->

		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="index.html" class="brand-link"> <!--         <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" -->
				<!--           style="opacity: .8"> --> <span
				class="brand-text font-weight-light">後台管理系統</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar user panel (optional)-->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<div class="image">
						<!--             <img src="dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image"> -->
					</div>
					<div class="info">
						<a href="#" class="d-block">${kolMebVO.kol_account} 你好。</a>
					</div>
				</div>
				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- <i class="nav-icon fas fa-tachometer-alt"></i> -->
						<li class="nav-header" style="font-size: 25px;"><a
							href="<%=request.getContextPath()%>/kolBackStage/order/orderList.jsp"
							class="nav-link">

								<p>
									<i class="ion ion-android-list" style="font-size: 31px;"></i>
									訂單列表
								</p>
						</a></li>

<!-- 						<li class="nav-header" style="font-size: 25px;"><a -->
<!-- 							href="meb_kol.html" class="nav-link"> -->
<!-- 								<p> -->
<!-- 									<i class="fa fa-address-book" aria-hidden="true"></i> 應徵列表 -->
<!-- 								</p> -->
<!-- 						</a></li> -->

						<li class="nav-header" style="font-size: 25px;"><a
							href="<%=request.getContextPath()%>/findcom/hireform/matchform.jsp" class="nav-link">
								<p>
									<i class="fa fa-handshake-o" aria-hidden="true"></i> 媒合列表
								</p>
						</a></li>

						<li class="nav-header" style="font-size: 25px;"><a
							href="<%=request.getContextPath()%>/kolBackStage/kolmeb/kolMebJspThree.jsp" class="nav-link">
								<p>
									<i class="fas fa-address-card"></i> 資料修改
								</p>
						</a></li>

						<li class="nav-header" style="font-size: 25px;"><a
							href="<%=request.getContextPath()%>/kolFavor/kolfavor.jsp" class="nav-link">
								<p>
									<i class="fa fa-heart" aria-hidden="true"></i> 我的最愛
								</p>
						</a></li>

						<li class="nav-header" style="font-size: 25px;"><a
							href="<%=request.getContextPath()%>/kolBackStage/email/Email.jsp"
							class="nav-link">
								<p>
									<i class="fa fa-envelope" aria-hidden="true"></i> 信箱
								</p>
						</a></li>
						
						<li class="nav-header" style="font-size: 25px; margin-top:40px"><a
							href="<%=request.getContextPath()%>/metherIndex.jsp"
							class="nav-link">
								<p>
									<i class="fa fa-home" aria-hidden="true" style="font-size: 31px;"></i> 回首頁
								</p>
						</a></li>

					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>





<%
MatchService matchService = new MatchService();
List <ProductVO> list = matchService.getOneMatchForm(kolMebVO.getKol_idnum());
pageContext.setAttribute("list", list);
%>

<body bgcolor='white'>
	<div class="content-wrapper">




		<div class="row">
			<div class="col-12 table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>No.</th>
							<th>標題</th>
							<th>商品金額</th>
							<th>工作內容</th>
							<th>工作申請</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="productVO" items="${list}" varStatus="s"> 
							<tr>
								<td>${s.index+1}</td>
								<td>${productVO.product_name}</td>
								<td>${productVO.product_budget}</td>
								<td>${productVO.product_introduce}</td>
								
								
								<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/matchform/match.do"
										style="margin-bottom: 0px;">
								<td>
								<input type="submit" value="移除申請" class="btn btn-block btn-danger">
								<input type="hidden" name="product_num"	value="${productVO.product_num}">
								<input type="hidden" name="action" value="delete">
								</td>
								</FORM>
								
							</tr>
						 </c:forEach> 
					</tbody>
				</table>
			</div>

		</div>
	</div>

</body>


<%@ include file="footer.jsp"%>