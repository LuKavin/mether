
<%@page import="com.product.model.ProductVO"%>
<%@page import="com.product.model.ProductService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.companymeb.model.*"%>
<%@page import="com.kolmeb.model.KolMebVO"%>
<%@page import="java.util.List"%>
<%@ page import="com.kolfavorite.model.*"%>
<%-- <%@ include file="header.jsp"%> --%>
<% KolMebVO kolMebVO = (KolMebVO)session.getAttribute("kolMebVO"); %>
<%
ProductService productService = new ProductService();
List<ProductVO> list = productService.getAll();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html class="no-js">
<head>

<title>工作列表</title>

<!--input range-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Ubuntu">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourcesyu/css/search_com.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/10.0.0/css/bootstrap-slider.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/10.0.0/bootstrap-slider.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="https://use.fontawesome.com/fd9dba5260.js"></script>
<script
	src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/search_com.js"></script>
<!---->

<link
	href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,600,400italic,700'
	rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Sacramento"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourcesyu/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourcesyu/css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourcesyu/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourcesyu/css/search_com.css">

<!-- Magnific Popup -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourcesyu/css/magnific-popup.css">

<!-- Owl Carousel  -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourcesyu/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourcesyu/css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/comBackStage/resourcesyu/css/style.css">

<!-- Modernizr JS -->
<script
	src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->

<script
	src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/respond.min.js"></script>

<!--bootstrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!--map-->
<link rel="stylesheet"
	href="https://unpkg.com/leaflet@1.8.0/dist/leaflet.css"
	integrity="sha512-hoalWLoI8r4UszCkZ5kL8vayOGVae1oxXe/2A4AO6J9+580uKHDO3JdHb7NzwwzK5xr/Fs0W40kiNHxM9vyTtQ=="
	crossorigin="" />
<script src="https://unpkg.com/leaflet@1.8.0/dist/leaflet.js"
	integrity="sha512-BB3hKbKWOc9Ez/TAwyWxNXeoV9c1v6FIeYiBieIWkpLjauysF18NzgR1MBNBXf8/KABdlkX68nAhlwcDFLGPCQ=="
	crossorigin=""></script>

</head>
<body>

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
							<li><a href="index.html">首頁</a></li>
							<li><a href="search_com.html">找廠商</a></li>
							<li><a href="search_kol.html">找網紅</a></li>
							<li><a href="services.html">聯絡我們</a></li>
							<li><a href="contact.html">會員中心</a></li>
						</ul>
					</div>
				</div>

			</div>
		</nav>

		<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm"
			role="banner"
			style="background-image:url(<%=request.getContextPath()%>/comBackStage/resourcesyu/images/img_bg_1.jpg);">
			<div class="overlay"></div>
			<div class="fh5co-container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center">
						<div class="display-t">
							<div class="display-tc animate-box" data-animate-effect="fadeIn">
								<h1>Search COM!</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>

		<br> <br>

		<section class="B">
			<div class="search">
				<div class="row">
					<div class="d-grid gap-2 col-2 mx-auto">
						<button type="button" class="btn btn-danger btn-lg" id="make_up">美妝</button>
						<button type="button" class="btn btn-primary btn-lg" id="youtube">Youtube</button>
					</div>
					<div class="d-grid gap-2 col-2 mx-auto">
						<button type="button" class="btn btn-danger btn-lg" id="private">私</button>
						<button type="button" class="btn btn-primary btn-lg"
							id="instagram">Instagram</button>
					</div>
					<div class="d-grid gap-2 col-2 mx-auto">
						<button type="button" class="btn btn-danger btn-lg" id="stream">直播</button>
						<button type="button" class="btn btn-primary btn-lg" id="facebook">Facebook</button>
					</div>
					<div class="d-grid gap-2 col-2 mx-auto">
						<button type="button" class="btn btn-danger btn-lg" id="3c">3c</button>
						<button type="button" class="btn btn-primary btn-lg" id="twitter">Twitter</button>
					</div>
					<div class="d-grid gap-2 col-2 mx-auto">
						<button type="button" class="btn btn-danger btn-lg"
							id="game_stream">遊戲實況</button>
						<button type="button" class="btn btn-primary btn-lg" id="tiktok">Tiktok</button>
					</div>
				</div>

			</div>
		</section>
		<br> <br>

		<div class="wrapper">
			<div class="row">
				<div class="col-12 table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th></th>
								<th></th>
								<th style="font-size: 30px">No.&emsp;&emsp;</th>
								<th style="font-size: 30px">標題&emsp;&emsp;</th>
								<th style="font-size: 30px">產品網址</th>
								<th style="font-size: 30px">工作內容</th>
								<th style="font-size: 30px">工作申請</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>

			</div>
			<div class="row g-2 row-bottom-padded-md">
				<div class="col-md-0 mx-auto">
				
					<c:forEach var="productVO" items="${list}" varStatus="s">
						<%-- <div class="card" style="width: 300px; height: 250px;"
								data-animate-effect="fadeIn">
								<div class="card-body">
								<p class="card-text">廠商簡介</p>
									<span href="#" class="badge badge-pill normal facebook">Facebook</span>
									<span href="#" class="badge badge-pill normal instagram">Instagram</span>
									<span href="#" class="badge badge-pill normal youtube">Youtube</span>
									<span href="#" class="badge badge-pill normal else">...</span>
									<br> <br>
									<p>
										<span class="fa-li"></span><b>Product no.:
											${productVO.product_num}</b>
									</p>
									<p>
										<span class="fa-li"></span>Name: ${productVO.product_name}
									</p>
									<p>
										<span class="fa-li"></span>簡介:${productVO.product_introduce}
									</p>
									<p>
										<span class="fa-li"></span>需求時間:${productVO.product_deadline}
									</p>
									<br>
									<br>
									<br>
									<br>
									<br>
									
									<p><a
										 href="<%=request.getContextPath()%>/kolBackStage/matchform/matchform.jsp"><b>VIEW JOB</b></a></p>
								
									
								</div>
								<br> <br>
							</div>
 --%>
						<tr>
							<td><font style="font-size: 30px">&emsp;&emsp;&emsp;&emsp;${s.index+1}</td>
							<td><font style="font-size: 30px">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${productVO.product_name}</td>
							<td><font style="font-size: 30px">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${productVO.product_introduce}</td>
							<td><font style="font-size: 30px">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${productVO.product_deadline}</td>

								<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/matchform/match.do"
								>
								<td><input style="font-size: 30px; display:inline-block" type="submit"
									value="申請媒合" class="btn btn-primary"> <input
									type="hidden" name="product_num"
									value="${productVO.product_num}"> <input type="hidden"
									name="action" value="insert"></td>
							</FORM>
						

						</tr>


					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/jquery.countTo.js"></script>

	<!-- Stellar -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/jquery.stellar.min.js"></script>
	<!-- Magnific Popup -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/jquery.magnific-popup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/magnific-popup-options.js"></script>

	<!-- Main -->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/main.js"></script>

	<!--map.js-->
	<script
		src="<%=request.getContextPath()%>/comBackStage/resourcesyu/js/map.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.1/dist/umd/popper.min.js"
		integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
		integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
		crossorigin="anonymous"></script>


</body>
</html>



<%-- <%@ include file="footer.jsp"%> --%>
