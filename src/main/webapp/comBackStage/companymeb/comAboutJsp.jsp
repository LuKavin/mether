<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.companymeb.model.*"%>
<%@ page import="com.memberphoto.model.*"%>
<%@ page import="com.memberphoto.controller.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");
%>

<%
MemberPhotoService memberPhotoService = new MemberPhotoService();
List<MemberPhotoVO> list = memberPhotoService.getComAll(companyMebVO.getCom_idnum());
pageContext.setAttribute("list", list);
%>



<html>
<head>
<title>廠商個人頁面</title>

<link
	href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,600,400italic,700'
	rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Sacramento"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>



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

<!-- Modernizr JS -->
<script
	src="<%=request.getContextPath()%>/comBackStage/resourceslee/js/modernizr-2.6.2.min.js"></script>

<!-- FOR IE9 below -->
<!--[if lt IE 9]>
<script src="<%=request.getContextPath()%>/js/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourceslee/css/comkol_page.css">



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
							<li><a href="contact.html">Contact</a></li>
						</ul>
					</div>
				</div>

			</div>
		</nav>

		<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm"
			role="banner"
			style="background-image:url(<%=request.getContextPath()%>/comBackStage/resourceslee/images/img_bg_1.jpg);">
			<div class="overlay"></div>
			<div class="fh5co-container">
				<div class="row py-3 kol_about">
					<main class="col col-xl-12 col-md-12 col-sm-12 col-12">
						<div class="box shadow-sm p-2 user-profile-box mb-2">
							<div class="profile-card">
								<div class="user-profile-image d-flex text-center">
									<div class="container user-profile-page">
										<div class="row py-lg-5 px-lg-5">
											<div class="col-4 col-md-5">
												<!-- <img src="./images/crycat.png" alt="" class="kol_img"> -->
												<!-- <h2 class="kol_name">屁孩貓</h2>  -->
												<!-- <div class="dropdown matchMe">
												<button class="btn btn-secondary dropdown-toggle matchMe" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
												  我要媒合
												</button>
												<ul class="dropdown-menu matchMe" aria-labelledby="dropdownMenuButton1">
												  <li class="matchMe"><a class="dropdown-item" href="#">廠商的商品1</a></li>
												  <li class="matchMe"><a class="dropdown-item" href="#">廠商的商品2</a></li>
												  <li class="matchMe"><a class="dropdown-item" href="#">廠商的商品3</a></li>
												</ul>
											  </div> -->

												<div class="picturescontrol">
													<div id="carouselExampleControls" class="carousel slide"
														data-bs-ride="carousel">
														<div class="carousel-inner">

															<c:forEach var="memberPhotoVO" items="${list}" varStatus="s">
																<c:if test="${s.index == 0}">
																	<div class="carousel-item active">
																		<div class="rwdimg"
																			style="background-image:url(<%=request.getContextPath()%>/ReadMemberPhoto?meb_photonum=${memberPhotoVO.meb_photonum})">
																		</div>																		
																	</div>
																</c:if>
																<c:if test="${s.index > 0 }">
																	<div class="carousel-item">
																		<div class="rwdimg"
																			style="background-image:url(<%=request.getContextPath()%>/ReadMemberPhoto?meb_photonum=${memberPhotoVO.meb_photonum})">
																		</div>																		
																	</div>
																</c:if>
															</c:forEach>

														</div>
														<button class="carousel-control-prev" type="button"
															data-bs-target="#carouselExampleControls"
															data-bs-slide="prev">
															<span class="carousel-control-prev-icon"
																aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
														</button>

														<button class="carousel-control-next" type="button"
															data-bs-target="#carouselExampleControls"
															data-bs-slide="next">
															<span class="carousel-control-next-icon"
																aria-hidden="true"></span> <span class="visually-hidden">Next</span>
														</button>
													</div>
												</div>

											</div>
											<div class="col-8 col-md-7 kol_about">
												<h2 class="com_name">${companyMebVO.com_name}</h2>
												<div class="com_ratelv content-md">
													<!-- <p>商家評分</p> -->
													<!-- <p class="user-info-rating d-flex align-items-center"> -->
													<!-- <div class="star-rating-s15-wrapper">
													<p class="star-rating-s15 rate-10">
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star" aria-hidden="true"></i>
													<i class="fa fa-star" aria-hidden="true"></i>
													</p>
													</div> -->
													<div class="starcomments">
														<p class="total-rating-out-five">總平均星數:
															${companyMebVO.avg_star}顆星</p>
													</div>
													<div class="comments">
														<p class="total-rating">總評價數:
															${companyMebVO.total_rate}則</p>
													</div>
													<!-- </p> -->
												</div>
												<div class="addfav">
													<button type="button" class="btn btn-dark"
														onclick="followUser('1766');">
														<i class="fa fa-plus"></i>加最愛
													</button>
												</div>
												<div class="dropdown matchMe">
													<button class="btn btn-secondary dropdown-toggle matchMe"
														type="button" id="dropdownMenuButton"
														data-bs-toggle="dropdown" aria-expanded="false">我要媒合</button>
													<ul class="dropdown-menu matchMe"
														aria-labelledby="dropdownMenuButton1">
														<li class="matchMe"><a class="dropdown-item" href="#">廠商的商品1</a></li>
														<li class="matchMe"><a class="dropdown-item" href="#">廠商的商品2</a></li>
														<li class="matchMe"><a class="dropdown-item" href="#">廠商的商品3</a></li>
													</ul>
												</div>
												<!-- <div class="kol_shortinfodiv"><h2 class="kol_shortinfo">關於我</h2></div>																				 -->
												<!-- <div class="kol_worktype">
												<span>工作類型</span>
											</div>
											<div class="kol_about_pill content-md text-left">
												<div>
													<a href="#" class="badge badge-pill normal facebook">Facebook</a>
													<a href="#" class="badge badge-pill normal youtube">Youtube</a>
													<a href="#" class="badge badge-pill normal tiktok">Tiktok</a>
												</div>
											</div>
											<div class="kol_skilltype">
												<span>專長類型</span>
											</div>
											<div class="kol_about_pill content-md text-left">
												<div>
													<a href="#" class="badge badge-pill normal plat game-stream">遊戲實況</a>
													<a href="#" class="badge badge-pill normal plat stream">直播</a>
													<a href="#" class="badge badge-pill normal plat 3c">3C</a>
												</div>
											</div> -->

											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</main>
				</div>
			</div>
		</header>

		<!--========================================body part========================================-->

		<div class="container com_info">
			<div class="row com_info">
				<div class="com_infoTitle">
					<span class="infoTitle">關於我</span>
				</div>
				<div class="info">
					<p class="info">市話：${companyMebVO.com_phone}</p>
					<p class="info">地址：${companyMebVO.com_address}</p>
					<p class="info">成立日期：${companyMebVO.com_founddate}</p>
					<p class="info">統一編號：${companyMebVO.com_taxidnum}</p>
					<p class="info">信箱：${companyMebVO.com_email}</p>
					<p class="info">網址：${companyMebVO.com_website}</p>
				</div>
			</div>
		</div>

		<div class="container com_info">
			<div class="row com_info">
				<div class="com_infoTitle">
					<span class="infoTitle">公司簡介</span>
				</div>

				<div class="info">
					<p class="info">公司介紹：${companyMebVO.com_introduce}</p>
				</div>
			</div>
		</div>

		<!-- <div class="container kol_info">
		<div class="row kol_info">
			<div class="kol_infoTitle">
				<span class="infoTitle">廠商評分</span>
			</div>
		</div>
	</div> -->

		<!--========================================footer part========================================-->

		<footer id="fh5co-footer" role="contentinfo">
			<div class="container">
				<div class="row row-pb-md">
					<!--	<div class="col-md-4 fh5co-widget">
					<h3>The Company</h3>
					<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit. Eos cumque dicta adipisci architecto culpa amet.</p>
					<p><a href="#">Learn More</a></p>
				</div>
				<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
					<ul class="fh5co-footer-links">
						<li><a href="#">About</a></li>
						<li><a href="#">Help</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">Terms</a></li>
						<li><a href="#">Meetups</a></li>
					</ul>
				</div>

				<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
					<ul class="fh5co-footer-links">
						<li><a href="#">Shop</a></li>
						<li><a href="#">Privacy</a></li>
						<li><a href="#">Testimonials</a></li>
						<li><a href="#">Handbook</a></li>
						<li><a href="#">Held Desk</a></li>
					</ul>
				</div>

				<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
					<ul class="fh5co-footer-links">
						<li><a href="#">Find Designers</a></li>
						<li><a href="#">Find Deelopers</a></li>
						<li><a href="#">Teams</a></li>
						<li><a href="#">Advertise</a></li>
						<li><a href="#">API</a></li>
					</ul>
				</div>
			</div> -->

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

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.1/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script> -->
	<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script> -->



</body>
</html>

