<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kolmeb.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
KolMebVO kolMebVO = (KolMebVO) session.getAttribute("kolMebVO");
pageContext.setAttribute("kolMebVO", kolMebVO);
%>

<html>
<head>
<title>會員資料修改</title>

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
							<h1>會員資料修改(網紅)</h1>
							<p></p>
							<form METHOD="post" ACTION="<%=request.getContextPath()%>/kolmeb/KolMeb.do">

								<div class="row mb-3">
									<label for="K_password" class="col-md-2 col-form-label">網紅密碼:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="password" class="form-control" id="K_password" name="kol_password" value="${kolMebVO.kol_password}" onkeyup="value=value.replace(/[\W]/g,'')"
											onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_password_confirm" class="col-md-2 col-form-label">確認密碼:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="password" class="form-control" id="K_password_confirm" name="kol_password" onkeyup="KC_validate()" value="${kolMebVO.kol_password}" required>
										<p id="K_tips"></p>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_membername" class="col-md-2 col-form-label">網紅名稱:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_membername" name="kol_name" value="${kolMebVO.kol_name}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_memberid" class="col-md-2 col-form-label">網紅身分證:&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_memberid" name="kol_id" value="${kolMebVO.kol_id}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_membertel" class="col-md-2 col-form-label">網紅市話:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="tel" class="form-control" id="K_membertel" name="kol_phone" value="${kolMebVO.kol_phone}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_cellphone" class="col-md-2 col-form-label">網紅手機:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="tel" class="form-control" id="K_cellphone" name="kol_cellphone" value="${kolMebVO.kol_cellphone}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_bank" class="col-md-2 col-form-label">網紅銀行代碼:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_bank" name="kol_bankcode" onkeyup="this.value=this.value.replace(/\D/g,'')"
											onafterpaste="this.value=this.value.replace(/\D/g,'')" value="${kolMebVO.kol_bankcode}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_banknumber" class="col-md-2 col-form-label">網紅銀行帳戶:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_banknumber" name="kol_bankaccount" onkeyup="this.value=this.value.replace(/\D/g,'')"
											onafterpaste="this.value=this.value.replace(/\D/g,'')" value="${kolMebVO.kol_bankaccount}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_email" class="col-md-2 col-form-label">網紅信箱:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="email" class="form-control" id="K_email" name="kol_email" value="${kolMebVO.kol_email}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_gender" class="col-md-2 col-form-label">網紅性別:&emsp;&emsp;</label>
									<div class="col-md-10" style="text-align: left;">
										<input type="radio" id="K_gender" name="kol_gender" value="male">男性
										<input type="radio" id="K_gender" name="kol_gender" value="female">女性
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_birthday" class="col-md-2 col-form-label">網紅生日:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="date" class="form-control" id="K_birthday" name="kol_birthday" value="${kolMebVO.kol_birthday}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_location" class="col-md-2 col-form-label">網紅地區:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_location" name="kol_location" value="${kolMebVO.kol_location}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_height" class="col-md-2 col-form-label">網紅身高:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_height" name="kol_height" value="${kolMebVO.kol_height}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_weight" class="col-md-2 col-form-label">網紅體重:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_weight" name="kol_weight" value="${kolMebVO.kol_weight}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_style" class="col-md-2 col-form-label">網紅個人風格:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_style" name="kol_style" value="${kolMebVO.kol_style}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_experience" class="col-md-2 col-form-label">網紅過往經歷:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_experience" name="kol_experience" value="${kolMebVO.kol_experience}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_address" class="col-md-2 col-form-label">網紅地址:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_address" name="kol_address" value="${kolMebVO.kol_address}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="K_website" class="col-md-2 col-form-label">網紅網址:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="K_website" name="kol_website" value="${kolMebVO.kol_website}" required>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<button type="submit" class="btn btn-primary" id="K_member_save">儲存</button>
									</div>
								</div>
								
								<input type="hidden" name="action" value="update">
								<input type="hidden" name="kol_idnum" value="<%=kolMebVO.getKol_idnum()%>">

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