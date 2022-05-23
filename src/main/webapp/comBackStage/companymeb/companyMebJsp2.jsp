<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.companymeb.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
CompanyMebVO companyMebVO = (CompanyMebVO) request.getAttribute("companyMebVO");
%>


<html>
<head>
<title>會員註冊</title>

<link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,600,400italic,700' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Sacramento" rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/animate.css">

<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/icomoon.css">

<!-- Bootstrap  -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/magnific-popup.css">

<!-- Owl Carousel  -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/style.css">

<!-- adminlte style -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/adminlte.min.css">

<!-- Modernizr JS -->
<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/modernizr-2.6.2.min.js"></script>

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
					<div class="col-xs-10 text-right menu-1">
						<ul>
							<li class="active"><a
								href="<%=request.getContextPath()%>/metherIndex.jsp">首頁</a></li>
							<li><a href="about.html">找廠商</a></li>
							<li><a href="services.html">找網紅</a></li>
							<li class="has-dropdown active"><a
								href="<%=request.getContextPath()%>/comBackStage/companymeb/companyMebJsp.jsp">會員中心</a>
								<ul class="dropdown">
									<li><a
										href="<%=request.getContextPath()%>/comBackStage/companymeb/companyMebJsp.jsp">會員註冊</a></li>
									<li><a
										href="<%=request.getContextPath()%>/login/companyMebJspLogin.jsp">會員登入</a></li>
									<li><a href="#">會員中心</a></li>
									<li><a
										href="<%=request.getContextPath()%>/logout/companyMebJspLogout.jsp">會員登出</a></li>
								</ul></li>
							<li><a href="contact.html">關於我們</a></li>
						</ul>
					</div>
				</div>

			</div>
		</nav>

		<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm"
			role="banner"
			style="background-image: url(<%=request.getContextPath()%>/comBackStage/resourceslee/images/img_bg_1.jpg); height: 200px;">
		</header>

<!--========================================body part========================================-->

		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>


		<div class="overlay"></div>
		<div class="fh5co-container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<p></p>
							<h1>會員註冊(廠商)</h1>
							<p></p>
							<form METHOD="post" ACTION="<%=request.getContextPath()%>/companymeb/CompanyMeb.do">
								<div class="row mb-3">
									<label for="V_account" class="col-md-2 col-form-label">廠商帳號:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_account" name="com_account" value="${companyMebVO.com_account}" onkeyup="value=value.replace(/[\W]/g,'')"
											onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_password" class="col-md-2 col-form-label">廠商密碼:</label>
									<div class="col-md-10">
										<input type="password" class="form-control" id="V_password" name="com_password" value="${companyMebVO.com_password}" onkeyup="value=value.replace(/[\W]/g,'')"
											onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_password_confirm" class="col-md-2 col-form-label">確認密碼:</label>
									<div class="col-md-10">
										<input type="password" class="form-control" id="V_password_confirm" onkeyup="V_validate()" required>
										<p id="V_tips"></p>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_companyname" class="col-md-2 col-form-label">廠商名稱:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_companyname" name="com_name" value="${companyMebVO.com_name}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_email" class="col-md-2 col-form-label">廠商信箱:</label>
									<div class="col-md-10">
										<input type="email" class="form-control" id="V_email" name="com_email" value="${companyMebVO.com_email}" required>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<button type="submit" class="btn btn-primary" id="V_member_submit">註冊</button>
									</div>
								</div>
								
								<input type="hidden" name="action" value="insert">

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

<!--========================================footer part========================================-->

		<footer id="fh5co-footer" role="contentinfo">
			<div class="container">

				<div class="row copyright">
					<div class="col-md-12 text-center">
						<p>
							<small class="block">&copy; TGA_101_1 </small>
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
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.min.js"></script>

		<!-- jQuery Easing -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.easing.1.3.js"></script>

		<!-- Bootstrap -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/bootstrap.min.js"></script>

		<!-- Waypoints -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.waypoints.min.js"></script>

		<!-- Carousel -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/owl.carousel.min.js"></script>

		<!-- countTo -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.countTo.js"></script>

		<!-- Stellar -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.stellar.min.js"></script>

		<!-- Magnific Popup -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/jquery.magnific-popup.min.js"></script>
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/magnific-popup-options.js"></script>

		<!-- Main -->
		<script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/main.js"></script>
		
		<!-- js from IW -->
	    <script src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/MemberInfo_IW.js"></script>

</body>
</html>