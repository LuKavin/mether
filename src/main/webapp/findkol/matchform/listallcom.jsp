
<%@page import="com.product.model.ProductVO"%>
<%@page import="com.product.model.ProductService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.companymeb.model.*"%>
<%@page import="com.kolmeb.model.KolMebVO"%>
<%@page import="java.util.List"%>
<%@ page import="com.kolfavorite.model.*"%>
<%@ include file="match-header.jsp"%>
<%
ProductService productService = new ProductService();
List<ProductVO> list = productService.getAll();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html class="no-js">
<head>

<title>搜尋廠商</title>
<body>


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

	<div id="fh5co-gallery">
		<div class="container">
			<div class="row">
				<div
					class="col-md-8 col-md-offset-2 text-center fh5co-heading animate-box">
					<h2>廠商</h2>
				</div>
			</div>
			<div class="row g-2 row-bottom-padded-md">
				<div class="col-md-0 mx-auto">
					<ul id="fh5co-gallery-list">
						<c:forEach var="productVO" items="${list}">
							<div class="card" style="width: 300px; height: 350px;"
								data-animate-effect="fadeIn">
								<a href="./com_about.html"> <img src="<%=request.getContextPath()%>/viewpic?id=${productVO.product_num}"
									class="card-img-top mx-auto" alt="...">
								</a>
								<div class="card-body">
									<h5 class="card-title">廠商商品:${productVO.product_name}</h5>
									<h3 class="right">商品價格:${productVO.product_budget}</h3>
									<p class="card-text">商品敘述:${productVO.product_introduce}</p>
									<span href="#" class="badge badge-pill normal facebook">Facebook</span>
									<span href="#" class="badge badge-pill normal instagram">Instagram</span>
									<span href="#" class="badge badge-pill normal youtube">Youtube</span>
								</div>
								<div class="content-info pt-2 pb-2">
									<div class="rating-wrapper">
										<div class="tasknum">
											<span class="task-num">招募:${productVO.product_count}</span>
											<br>
											<br>
											<span> <a
											href="<%=request.getContextPath()%>/kolBackStage/matchform/about.jsp?product_num=${productVO.product_num}"><b>VIEW
													JOB</b></a></span> 
										</div>
									</div>
								</div>
							</div>

						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<%-- <div id="fh5co-gallery">
		<div class="container card-cont">
			<div class="row card-row">
				<div
					class="col-md-8 col-md-offset-2 text-center fh5co-heading animate-box fadeInUp animated-fast">
					<h2>網紅</h2>
				</div>
			</div>
			<div class="row row-bottom-padded-md">
				<div class="col-md-11 mx-auto">
					<ul id="fh5co-gallery-list">
						<c:forEach var="companyMebVO" items="${list}">

							<div class="card" style="width: 300px; height: 450px;border:1px solid; ">
								<a href="about.html"> <img src="./images/crycat.png"
									class="card-img-top mx-auto" alt="...">
								</a>
								<div class="card-body">
									<p class="card-text">廠商簡介</p>
									<span href="#" class="badge badge-pill normal facebook">Facebook</span>
									<span href="#" class="badge badge-pill normal instagram">Instagram</span>
									<span href="#" class="badge badge-pill normal youtube">Youtube</span>
									<span href="#" class="badge badge-pill normal else">...</span>

									<tr>

										<td><b>Meb no.:${companyMebVO.com_idnum}</b></td>
										<td>Email: ${companyMebVO.com_email}</td>
										<td>Website:${companyMebVO.com_website}</td>
										<td>Phone:${companyMebVO.com_phone}</td>
										<td><a
											href="<%=request.getContextPath()%>/kolBackStage/matchform/jobview.jsp"><b>VIEW
													JOB</b></a></td>

									</tr>


								</div>
								<br> <br>
							</div>
				</div>


				</c:forEach>
				</ul>
			</div>
		</div>
	</div> --%>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>


</body>
</html>



<%@ include file="match-footer.jsp"%>
