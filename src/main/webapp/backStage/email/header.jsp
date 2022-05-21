<%@page import="com.companymeb.model.CompanyMebVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.adm_meb.model.AdmMebVO"%>
<%
AdmMebVO admMebVO = (AdmMebVO) session.getAttribute("admMebVO");//讀取登入者的資料
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
	href="<%=request.getContextPath()%>/comBackStage/resources/css/awsome.css"
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
	href="<%=request.getContextPath()%>/comBackStage/resources/summernote/summernote-bs4.min.css">

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
	<!-- Navbar ===================================以下為重複出現部分============================================================================= -->
	<nav class="main-header navbar navbar-expand navbar-white navbar-light">
		<ul class="navbar-nav">
			<!--ＳＩＤＥＢＡＲ漢堡-->
			<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
				href="#" role="button"><i class="fas fa-bars"></i></a></li>
			<li class="nav-item d-none d-sm-inline-block"><a
				href="backStageIndex.jsp" class="nav-link">回首頁點我</a></li>
		</ul>

		<!-- Right navbar links -->
	</nav>
	<!--ＳＩＤＥＢＡＲ-->

	<aside class="main-sidebar sidebar-dark-primary elevation-4">
		<!-- Brand Logo -->
		<a href="backStageIndex.jsp" class="brand-link">
			<span class="brand-text font-weight-light">後台管理系統</span>
		</a>

		<!-- Sidebar -->
		<div class="sidebar">
			<!-- Sidebar user panel (optional)-->
			<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<a href="#" class="d-block">(顯示管理員帳號)</a>
			</div>
			<!-- Sidebar Menu -->
			<nav class="mt-2">
				<ul class="nav nav-pills nav-sidebar flex-column"
					data-widget="treeview" role="menu" data-accordion="false">
					<!-- <i class="nav-icon fas fa-tachometer-alt"></i> -->
					<li class="nav-header" style="font-size: 25px;">會員</li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/backStage/meb_com.jsp" class="nav-link">
							<i class="ion ion-ios-briefcase-outline" style="font-size: 25px;">_</i>
							<p>廠商</p>
					</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/backStage/meb_kol.jsp" class="nav-link">
							<i class="ion ion-ios-personadd-outline" style="font-size: 30px;">_</i>
							<p>網紅</p>
					</a></li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/backStage/meb_blocklist.jsp"
						class="nav-link"> <i class="ion ion-android-cancel"
							style="font-size: 25px;">_</i>
							<p>黑名單</p>
					</a></li>
					<li class="nav-header" style="font-size: 25px;">商品</li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/backStage/meb_product.jsp"
						class="nav-link"> <i class="ion ion-cube"
							style="font-size: 25px;">_</i>
							<p>商品列表</p>
					</a></li>
					<li class="nav-header" style="font-size: 25px;">訂單</li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/backStage/meb_orderlist.jsp"
						class="nav-link"> <i class="ion ion-android-list"
							style="font-size: 25px;">_</i>
							<p>訂單列表</p>
					</a></li>
					<li class="nav-header" style="font-size: 25px;">信箱</li>
					<li class="nav-item"><a href="<%=request.getContextPath()%>/backStage/email/Email.jsp"
						class="nav-link"> <i class="ion ion-ios-email-outline"
							style="font-size: 30px;">_</i>
							<p>我的信箱</p>
					</a></li>
				</ul>
			</nav>
			<!-- /.sidebar-menu -->
		</div>
		<!-- /.sidebar -->
	</aside>
		<!-- ==========================================以上為重複出現部分================================================================-->