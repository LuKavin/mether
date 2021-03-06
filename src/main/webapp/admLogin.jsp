<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
if (session.getAttribute("admMebVo") != null) {
	request.getRequestDispatcher("/backStageIndex.jsp").forward(request, response);
}
;
%>
<html>
<head>
<title>會員登入</title>

<link
	href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,600,400italic,700'
	rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Sacramento"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/animate.css">

<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/icomoon.css">

<!-- Bootstrap  -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/magnific-popup.css">

<!-- Owl Carousel  -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/style.css">

<!-- adminlte style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/adminlte.min.css">

<!-- Modernizr JS -->
<script
	src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/modernizr-2.6.2.min.js"></script>

</head>
<body>

	<!--========================================header part========================================-->

	<div class="fh5co-loader"></div>

	<div id="page">
		<nav class="fh5co-nav" role="navigation">
			<div class="container">
				<div class="row">
					<div class="col-xs-2">
						<div id="fh5co-logo">
							<a href="<%=request.getContextPath()%>/metherIndex.jsp">MetHer<strong>.</strong></a>
						</div>
					</div>
					<div style="margin-left: 450px">
						<ul>
							<li>
								<FORM METHOD="post"
									ACTION="<%=request.getContextPath()%>/serch.do">
									<input type="text" name="search"> <input type="hidden"
										name="action" value="getSearch"> <input type="submit"
										value="送出">
								</FORM>
							</li>

						</ul>
					</div>

					<div class="col-xs-10 text-right menu-1">
						<ul>
							<li class="active"><a
								href="<%=request.getContextPath()%>/metherIndex.jsp">首頁</a></li>
							<li><a
								href="<%=request.getContextPath()%>/findcom/hireform/listallcom.jsp">找廠商</a></li>
							<li><a
								href="<%=request.getContextPath()%>/findkol/matchform/listallkol.jsp">找網紅</a></li>
							<li class="has-dropdown active"><a
								href="<%=request.getContextPath()%>/comBackStage/companymeb/companyMebJsp.jsp">會員中心</a>
								<ul class="dropdown">
									<li><a
										href="<%=request.getContextPath()%>/comBackStage/companymeb/companyMebJsp.jsp">會員註冊</a></li>
									<li><a
										href="<%=request.getContextPath()%>/login/companyMebJspLogin.jsp">會員登入</a></li>
									<li><a
										href="<%=request.getContextPath()%>/comBackStage/companymeb/companyMebJspThree.jsp">會員中心</a></li>
									<li><a
										href="<%=request.getContextPath()%>/logout/companyMebJspLogout.jsp">會員登出</a></li>
								</ul></li>
							<li class="has-dropdown active"><a href="#">聊天室</a>
								<ul class="dropdown">
									<li><a
										href="<%=request.getContextPath()%>/chat/publicChat.jsp"
										target="_blank">公共聊天室</a></li>
									<li><a href="<%=request.getContextPath()%>/chat/index.jsp"
										target="_blank">私人聊天室</a></li>
								</ul></li>
						</ul>
					</div>
				</div>

			</div>
		</nav>

		<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm"
			role="banner"
			style="background-image: url(<%=request.getContextPath()%>/comBackStage/resourceslee/images/img_bg_1.jpg); height: 200px;">
		</header>

		<!-- ----------------------------------------------------------------------------------- -->
		<div>
			<br> <br>
			<section class="content">
				<div class="container ">
					<h1 class="text-center">管理員登入</h1>
					<br>
					<form METHOD="post" action="<%=request.getContextPath()%>/admLogin">
						<input type="hidden" name="action" value="login">
						<div class="row align-items-center justify-content-center">
							<input type="text" name="adm_account" placeholder="帳號">
						</div>
						<br>
						<div class="row align-items-center justify-content-center">
							<input type="password" name="adm_password" placeholder="密碼">
						</div>
						<br>
						<div class="row align-items-center justify-content-center">
							<button type="submit">登入</button>
						</div>
					</form>
				</div>
			</section>
		</div>
		<!-- ----------------------------------------------------------------------------------- -->

		<footer id="fh5co-footer" role="contentinfo">
			<div class="container">

				<div class="row copyright">
					<div class="col-md-12 text-center">
						<p>
							<small class="block">&copy; 2016 Free HTML5. All Rights
								Reserved.</small> <small class="block">Designed by <a
								href="http://freehtml5.co/" target="_blank">FREEHTML5.co</a>
								Demo Images: <a href="http://unsplash.co/" target="_blank">Unsplash</a></small>
						</p>
						<p>
						<ul class="fh5co-social-icons">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
						</ul>
						</p>
					</div>
				</div>

			</div>
		</footer>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	<!--========================================else part========================================-->

	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.min.js"></script>

	<!-- jQuery Easing -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.easing.1.3.js"></script>

	<!-- Bootstrap -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/bootstrap.min.js"></script>

	<!-- Waypoints -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.waypoints.min.js"></script>

	<!-- Carousel -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/owl.carousel.min.js"></script>

	<!-- countTo -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.countTo.js"></script>

	<!-- Stellar -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.stellar.min.js"></script>

	<!-- Magnific Popup -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.magnific-popup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/magnific-popup-options.js"></script>

	<!-- Main -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/main.js"></script>

	<!-- js from IW -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/MemberInfo_IW.js"></script>

</body>
</html>
