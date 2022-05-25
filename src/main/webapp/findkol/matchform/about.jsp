
<%@page import="com.hire_form.model.HireFormService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="match-header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%@ page import="com.kolmeb.model.KolMebVO"%>
<%@ page import="java.util.*"%>
<%
Integer product_num = new Integer(request.getParameter("product_num"));
KolMebVO kolMebVO = (KolMebVO) session.getAttribute("kolMebVO");

HireFormService hireFormService = new HireFormService();
String com_name = hireFormService.getOne(product_num);

ProductService productService = new ProductService();
ProductVO productVO = productService.getOneProduct(product_num);

pageContext.setAttribute("productVO", productVO);
pageContext.setAttribute("com_name", com_name);
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
<title>網紅</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
<meta name="author" content="FREEHTML5.CO" />

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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


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
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">

<!-- Owl Carousel  -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">

<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
<link rel="stylesheet" href="css/kol_page.css">
<script src="./js/addfavorite.js"></script>

</head>
<body>

	<div class="fh5co-loader"></div>

	<div id="page">

		<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm"
			role="banner"
			style="background-image:url(<%=request.getContextPath()%>/comBackStage/resourcesyu/images/img_bg_1.jpg);">
			<div class="overlay"></div>
			<div class="fh5co-container">
				<div class="row py-3 kol_about">
					<main class="col col-xl-12 col-md-12 col-sm-12 col-12">
						<div class="box shadow-sm p-2 user-profile-box mb-2">
							<div class="profile-card">
								<div class="user-profile-image d-flex text-center">
									<div class="container user-profile-page">
										<div class="row py-lg-5 px-lg-5">
											<div class="col-2">
												<br> <br> <br> <br> <br> <br>
												<br> <br> <img
													<%-- src="<%=request.getContextPath()%>/viewpic?id=${productVO.product_num}" --%>
													class="kol_img">
											</div>

											<div class="col-3 ">

												<br> <br> <br> <br> <br> <br>
												<br> <br>
												<h1 style="color: white; font-size: 30px;">${com_name}</h1>
												<br>
												<!-- <button type="button" class="btn btn-block btn-info">Info</button> -->

												<br>
												<div class="container kol_info">
													<div class="row kol_info">
														<div>

															<p style="color: white; font-size: 20px;">
																<b>基本資料</b>
															</p>
															<br>
															<p style="color: white; font-size: 15px;">商品名稱:${producxtVO.product_name}</p>
															<p style="color: white; font-size: 15px;">商品介紹:${productVO.product_introduce}</p>
															<p style="color: white; font-size: 15px;">商品期限:${productVO.product_deadline}</p>
															<p style="color: white; font-size: 15px;">招募人數:${productVO.product_count}</p>


															<FORM METHOD="post"
																ACTION="<%=request.getContextPath()%>/matchform/match.do">
																<button class="btn btn-outline-secondary matchMe"
																	type="submit" aria-expanded="false" onclick="return(confirm('確認申請'))">
																	<p style="color: white; font-size: 20px; margin: 0">我要媒合</p>
																</button>
																<input type="hidden" name="product_num"
																	value="${productVO.product_num}"> <input
																	type="hidden" name="action" value="insert">
															</FORM>









														</div>
													</div>
												</div>
											</div>

											<div class="col-7 kol_about">
												<br> <br> <br> <br> <br> <br>
												<br> <br>
												<div class="kol_aboutme"
													style="font-size: 30px; color: white; border: 2px #ccc solid; padding: 10px;">關於我</div>

												<div class="kol_worktype">
													<br> <span style="color: white; font-size: 20px;">合作計畫</span>
													<p style="color: white; font-size: 15px;">${productVO.product_contract}</p>
													<p style="color: white; font-size: 15px;">商品連結:</p>
													<a href="${productVO.product_link}"></a>

												</div>
												<div class="kol_about_pill content-md text-left ">
													<div>
														<a href="#" class="badge badge-pill normal facebook">Facebook</a>
														<a href="#" class="badge badge-pill normal youtube">Youtube</a>
														<a href="#" class="badge badge-pill normal tiktok">Tiktok</a>
													</div>
												</div>
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
		<br> <br> <br>


		<footer id="fh5co-footer" role="contentinfo">
			<div class="container">
				<div class="row row-pb-md"></div>
		</footer>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->

	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>

	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>

	<!-- Main -->
	<script src="js/main.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.1/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script> -->
	<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script> -->

</body>
</html>
<%@ include file="match-footer.jsp"%>
