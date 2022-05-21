<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<%@ page import="com.adm_meb.model.*"%>
<%
AdmMebVO admMebVO = (AdmMebVO) request.getAttribute("admMebVO");
%>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>後台管理系統</title>


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
	href="<%=request.getContextPath()%>/resources/css/awsome.css">
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

</head>
<!-- ============================================================================================================================================================ -->

<body class="hold-transition sidebar-mini layout-fixed">

	<!-- Navbar ===================================以下為重複出現部分============================================================================= -->
	<nav class="main-header navbar navbar-expand navbar-white navbar-light">
		<ul class="navbar-nav">
			<!--ＳＩＤＥＢＡＲ漢堡-->

			<li class="nav-item d-none d-sm-inline-block"><a
				href="/mether/backStage/backStageIndex.jsp" class="nav-link">回首頁點我</a></li>
		</ul>

		<!-- Right navbar links -->
		<li class="nav-item">管理員${admMebVO.adm_name}</li>
		<ul class="navbar-nav ml-auto">

			<li class="nav-item">
				<form METHOD="post" action="<%=request.getContextPath()%>/admLogin">
					<input type="hidden" name="action" value="logout">
					<div class="row align-items-center justify-content-center">
						<button type="submit">登出</button>
					</div>
				</form>
			</li>
		</ul>
	</nav>
	<!--ＳＩＤＥＢＡＲ-->

	<aside class="main-sidebar sidebar-dark-primary elevation-4">
		<!-- Brand Logo -->
		<a href="/mether/backStage/backStageIndex.jsp" class="brand-link">
			<span class="brand-text font-weight-light">後台管理系統</span>
		</a>

		<!-- Sidebar -->
		<div class="sidebar">
			<!-- Sidebar user panel (optional)-->

			<!-- Sidebar Menu -->
			<nav class="mt-2">
				<ul class="nav nav-pills nav-sidebar flex-column"
					data-widget="treeview" role="menu" data-accordion="false">
					<!-- <i class="nav-icon fas fa-tachometer-alt"></i> -->
					<li class="nav-header" style="font-size: 25px;">會員</li>
					<li class="nav-item"><a
						href="/mether/backStage/com/meb_com.jsp" class="nav-link"> <i
							class="ion ion-ios-briefcase-outline" style="font-size: 25px;">_</i>
							<p>廠商</p>
					</a></li>
					<li class="nav-item"><a
						href="/mether/backStage/kol/meb_kol.jsp" class="nav-link"> <i
							class="ion ion-ios-personadd-outline" style="font-size: 30px;">_</i>
							<p>網紅</p>
					</a></li>
					<li class="nav-item"><a
						href="/mether/backStage/block/com_blocklist.jsp" class="nav-link">
							<i class="ion ion-android-cancel" style="font-size: 25px;">_</i>
							<p>廠商黑名單</p>
					</a></li>
										<li class="nav-item"><a
						href="/mether/backStage/block/kol_blocklist.jsp" class="nav-link">
							<i class="ion ion-android-cancel" style="font-size: 25px;">_</i>
							<p>網紅黑名單</p>
					</a></li>
					<li class="nav-header" style="font-size: 25px;">商品</li>
					<li class="nav-item"><a href="/mether/productType/AllproductType.jsp"
						class="nav-link"> <i class="ion ion-cube"
							style="font-size: 25px;">_</i>
							<p>商品列表</p>
					</a></li>
					<li class="nav-header" style="font-size: 25px;">訂單</li>
					<li class="nav-item"><a
						href="/mether/backStage/order/meb_orderlist.jsp" class="nav-link">
							<i class="ion ion-android-list" style="font-size: 25px;">_</i>
							<p>訂單列表</p>
					</a></li>
					<li class="nav-header" style="font-size: 25px;">類型配置</li>
					<li class="nav-item"><a
						href="/mether/platformType/AllplatformType.jsp" class="nav-link">
							<i class="ion ion-android-list" style="font-size: 25px;">_</i>
							<p>平台列表</p>
					</a></li>

					<li class="nav-item"><a href="/mether/jobType/AlljobType.jsp"
						class="nav-link"> <i class="ion ion-android-list"
							style="font-size: 25px;">_</i>
							<p>工作列表</p>
					</a></li>

					<li class="nav-item"><a href="/mether/skillType/AllskillType.jsp"
						class="nav-link"> <i class="ion ion-android-list"
							style="font-size: 25px;">_</i>
							<p>技能列表</p>
					</a></li>

					<li class="nav-header" style="font-size: 25px;">信箱</li>
					<li class="nav-item"><a href="meb_mailinbox.jsp"
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
	<!-- /.sidebar-menu ===========================以上為重複出現部分================================================================-->