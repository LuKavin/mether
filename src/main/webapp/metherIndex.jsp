<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.backStage.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>
<%
BackStageService backStageSvc = new BackStageService();
List list = backStageSvc.getKolPhoto();
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>MetHer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
<meta name="author" content="FREEHTML5.CO" />

<!-- 
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE 
	DESIGNED & DEVELOPED by FREEHTML5.CO
		
	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	 -->

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<link
	href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,600,400italic,700'
	rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Sacramento"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/magnific-popup.css">

<!-- Owl Carousel  -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">

<!-- Modernizr JS -->
<script
	src="<%=request.getContextPath()%>/resources/js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
<style type="text/css"></style>
</head>
<body>

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
							<li class="has-dropdown active"><a
								href="<%=request.getContextPath()%>/index.html">聊天室</a>
								<ul class="dropdown">
									<li><a href="<%=request.getContextPath()%>/index.html">公共聊天室</a></li>
									<li><a href="<%=request.getContextPath()%>/index.jsp">私人聊天室</a></li>
								</ul></li>
						</ul>
					</div>
				</div>

			</div>
		</nav>

		<header id="fh5co-header" class="fh5co-cover" role="banner"
			style="background-image: url(<%=request.getContextPath()%>/resources/images/img_bg_1.jpg);"
			data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center">
						<div class="display-t">
							<div class="display-tc animate-box" data-animate-effect="fadeIn">
								<h1>Welcome</h1>
								<h2>MetHer網紅廠商媒合平台</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>

		<div id="fh5co-couple">
			<div class="container">
				<div class="row">
					<div
						class="col-md-8 col-md-offset-2 text-center fh5co-heading animate-box">
						<h2>Hello!</h2>
						<h3>歡迎使用MetHer</h3>
					</div>
				</div>
				<div class="couple-wrap animate-box">
					<div class="couple-half">
						<div class="groom">
							<img
								src="<%=request.getContextPath()%>/resources/images/Test_COM_Pic_2.png"
								alt="groom" class="img-responsive">
						</div>
						<div class="desc-groom">
							<h3>網站緣起</h3>
							<p>隨著網路的普及化，越來越多年輕人在網路上經營個人的事業或副業，許多初來乍到的網紅才剛踏入這個產業，需要更多的工作機會和曝光率，我們提供一個平台，讓不知道如何尋找代言人的廠商，和需要工作的網紅，有一個互相選擇合作的機會。
							</p>
						</div>
					</div>
					<p class="heart text-center">
						<i class="icon-heart2"></i>
					</p>
					<div class="couple-half">
						<div class="bride">
							<img
								src="<%=request.getContextPath()%>/resources/images/Test_KOL_Pic_1.png"
								alt="groom" class="img-responsive">
						</div>
						<div class="desc-bride">
							<h3>平台簡介</h3>
							<p>這是一個廠商網紅互相媒合的平台，我們提供完整的廠商資訊，讓網紅在尋找工作時，能看到廠商透明化的資訊背景，透過本平台放心交易，同時廠商也能根據網紅提供的資訊，選擇適合自己產品的代言人，讓雙方使用者各取所需。
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="fh5co-couple-story">
			<div class="container">
				<div class="row">
					<div
						class="col-md-8 col-md-offset-2 text-center fh5co-heading animate-box">
						<h2>網站特色</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 col-md-offset-0">
						<ul class="timeline animate-box">
							<li class="animate-box">
								<div class="timeline-badge"
									style="background-image: url(<%=request.getContextPath()%>/resources/images/hb1.png);"></div>
								<div class="timeline-panel">
									<div class="timeline-heading">
										<h3 class="timeline-title">精準配對工作</h3>
										<span class="date">搜尋及推薦專屬工作與網美</span>
									</div>

								</div>
							</li>
							<li class="timeline-inverted animate-box">
								<div class="timeline-badge"
									style="background-image: url(<%=request.getContextPath()%>/resources/images/hb2.png);"></div>
								<div class="timeline-panel">
									<div class="timeline-heading">
										<h3 class="timeline-title">秒速邀約聯絡</h3>
										<span class="date">內建溝通系統掌握合作進度</span>
									</div>
								</div>
							</li>
							<li class="animate-box">
								<div class="timeline-badge"
									style="background-image: url(<%=request.getContextPath()%>/resources/images/hb3.png);"></div>
								<div class="timeline-panel">
									<div class="timeline-heading">
										<h3 class="timeline-title">詳盡商家網美資訊</h3>
										<span class="date">不同專長網美及多元品牌商家</span>
									</div>
								</div>
							</li>
							<li class="timeline-inverted animate-box">
								<div class="timeline-badge"
									style="background-image: url(<%=request.getContextPath()%>/resources/images/hb4.png);"></div>
								<div class="timeline-panel">
									<div class="timeline-heading">
										<h3 class="timeline-title">安全服務</h3>
										<span class="date">商家及網美皆通過審核官方</span>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div id="fh5co-gallery" class="fh5co-section-gray">
			<div class="container">
				<div class="row">
					<div
						class="col-md-8 col-md-offset-2 text-center fh5co-heading animate-box">

						<h2>精選網紅!</h2>

					</div>
				</div>
				<div class="row row-bottom-padded-md">
					<div class="col-md-12">
						<ul id="fh5co-gallery-list">

							<%@ include file="page1.file"%>
							<c:forEach var="KolPhotoVO" items="${list}"
								begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">

								<li class="one-third animate-box" data-animate-effect="fadeIn"
									style="background-image: url(<%=request.getContextPath()%>/ReadMemberPhoto?meb_photonum=${KolPhotoVO.meb_photonum});"><a
									href="<%=request.getContextPath()%>/resources/images/et1.jpg"
									class="color-2">
										<div class="case-studies-summary">
											<h2>${KolPhotoVO.kol_name}</h2>
										</div>
								</a></li>

							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>

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

	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script
		src="<%=request.getContextPath()%>/resources/js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.countTo.js"></script>

	<!-- Stellar -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.stellar.min.js"></script>
	<!-- Magnific Popup -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.magnific-popup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/magnific-popup-options.js"></script>

	<!-- // <script src="https://cdnjs.cloudflare.com/ajax/libs/prism/0.0.1/prism.min.js"></script> -->
	<script
		src="<%=request.getContextPath()%>/resources/js/simplyCountdown.js"></script>
	<!-- Main -->
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>

</body>
</html>

