<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.companymeb.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");
pageContext.setAttribute("companyMebVO", companyMebVO);
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
							<a href="index.html">MetHer<strong>.</strong></a>
						</div>
					</div>
					<div class="col-xs-10 text-right menu-1">
						<ul>
							<li><a href="index.html">Home</a></li>
							<li><a href="about.html">Story</a></li>
							<li class="has-dropdown"><a href="services.html">Services</a>
								<ul class="dropdown">
									<li><a href="#">Web Design</a></li>
									<li><a href="#">eCommerce</a></li>
									<li><a href="#">Branding</a></li>
									<li><a href="#">API</a></li>
								</ul></li>
							<li class="has-dropdown active"><a href="<%=request.getContextPath()%>/comBackStage/companymeb/companyMebJsp.jsp">會員中心</a>
								<ul class="dropdown">
									<li><a href="<%=request.getContextPath()%>/comBackStage/companymeb/companyMebJsp.jsp">會員註冊</a></li>
									<li><a href="<%=request.getContextPath()%>/login/companyMebJspLogin.jsp">會員登入</a></li>
									<li><a href="#">會員中心</a></li>
									<li><a href="<%=request.getContextPath()%>/logout/companyMebJspLogout.jsp">會員登出</a></li>
								</ul></li>
							<li><a href="contact.html">Contact</a></li>
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
							<h1>會員資料修改(廠商)</h1>
							<p></p>
							<form METHOD="post" ACTION="<%=request.getContextPath()%>/companymeb/CompanyMeb.do">
							
								<div class="row mb-3">
									<label for="V_password" class="col-md-2 col-form-label">廠商密碼:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="password" class="form-control" id="V_password" name="com_password" onkeyup="value=value.replace(/[\W]/g,'')"
											onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" value="${companyMebVO.com_password}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_password_confirm" class="col-md-2 col-form-label">確認密碼:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="password" class="form-control" id="V_password_confirm" name="com_password" onkeyup="VC_validate()" value="${companyMebVO.com_password}" required>
										<p id="V_tips"></p>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_companyname" class="col-md-2 col-form-label">廠商名稱:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_companyname" name="com_name" value="${companyMebVO.com_name}"	required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_birthday" class="col-md-2 col-form-label">廠商生日:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="date" class="form-control" id="V_birthday" name="com_birthday" value="${companyMebVO.com_birthday}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_memberid" class="col-md-2 col-form-label">廠商身分證:&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_memberid" name="com_id" value="${companyMebVO.com_id}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_membertel" class="col-md-2 col-form-label">廠商市話:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="tel" class="form-control" id="V_membertel" name="com_phone" value="${companyMebVO.com_phone}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_cellphone" class="col-md-2 col-form-label">廠商手機:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="tel" class="form-control" id="V_cellphone" name="com_cellphone" value="${companyMebVO.com_cellphone}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_bank" class="col-md-2 col-form-label">廠商銀行代碼:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_bank" name="com_bankcode" value="${companyMebVO.com_bankcode}" onkeyup="this.value=this.value.replace(/\D/g,'')"
											onafterpaste="this.value=this.value.replace(/\D/g,'')" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_banknumber" class="col-md-2 col-form-label">廠商銀行帳戶:</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_banknumber" name="com_bankaccount" value="${companyMebVO.com_bankaccount}" onkeyup="this.value=this.value.replace(/\D/g,'')"
											onafterpaste="this.value=this.value.replace(/\D/g,'')" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_email" class="col-md-2 col-form-label">廠商信箱:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="email" class="form-control" id="V_email" name="com_email" value="${companyMebVO.com_email}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_gender" class="col-md-2 col-form-label">廠商性別:&emsp;&emsp;</label>
									<div class="col-md-10" style="text-align: left;">
										<input type="radio" id="V_gender" name="com_gender" value="male">男性
										<input type="radio" id="V_gender" name="com_gender" value="female">女性
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_taxnumber" class="col-md-2 col-form-label">統一編號:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_taxnumber" name="com_taxidnum" value="${companyMebVO.com_taxidnum}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_company_found_date"
										class="col-md-2 col-form-label">廠商成立日期: </label>
									<div class="col-md-10">
										<input type="date" class="form-control" id="V_company_found_date" name="com_founddate" value="${companyMebVO.com_founddate}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_companyaddress" class="col-md-2 col-form-label">廠商地址:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_companyaddress" name="com_address" value="${companyMebVO.com_address}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_companywebsite" class="col-md-2 col-form-label">廠商網址:&emsp;&emsp;</label>
									<div class="col-md-10">
										<input type="text" class="form-control" id="V_companywebsite" name="com_website" value="${companyMebVO.com_website}" required>
									</div>
								</div>

								<div class="row mb-3">
									<label for="V_introduce" class="col-md-2 col-form-label">廠商介紹:&emsp;&emsp;</label>
									<div class="col-md-10">
									
										<textarea id="V_introduce" name="com_introduce" class="form-control"  required>${companyMebVO.com_introduce}</textarea>
										<!-- <input type="textarea" class="form-control" id="V_introduce" required> -->
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<button type="submit" class="btn btn-primary" id="V_member_save">儲存</button>
									</div>
								</div>
								
								<input type="hidden" name="action" value="update">
								<input type="hidden" name="com_idnum" value="<%=companyMebVO.getCom_idnum()%>">

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