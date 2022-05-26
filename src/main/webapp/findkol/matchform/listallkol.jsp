
<%@page import="com.kolmeb.model.KolMebService"%>
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
KolMebService kolMebService = new KolMebService();
List<KolMebVO> list = kolMebService.getAll();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html class="no-js">
<head>

<title>搜尋網紅</title>
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
					<h2>網紅</h2>
				</div>
			</div>
			<div class="row g-2 row-bottom-padded-md">
				<div class="col-md-0 mx-auto">
					<ul id="fh5co-gallery-list" style="width: 1200px">
						<c:forEach var="kolMebVO" items="${list}">
							<div class="wrapper" style="margin-bottom: 100px">

								<div class="card" style="width: 300px; height: 350px;"
									data-animate-effect="fadeIn">
									<div class="float-middle">
										<img style="margin-left: 30px; margin-top: 30px" width="150"
											height="150" alt=""
											src="<%=request.getContextPath()%>/ReadProductPhoto?product_photonum=${ProductPhotoVO.product_photonum}">
									</div>

									<div class="card-body">
										<br>
										<h4 class="card-title">網紅名稱:${kolMebVO.kol_name}</h4>
										<h4 class="right">網紅電話:${kolMebVO.kol_phone}</h4>
										<p class="card-text">網紅簡介:${kolMebVO.kol_experience}</p>
										<p class="card-text">網紅網站:${kolMebVO.kol_website}</p>
										<span href="#" class="badge badge-pill normal facebook">Facebook</span>
										<span href="#" class="badge badge-pill normal instagram">Instagram</span>
										<span href="#" class="badge badge-pill normal youtube">Youtube</span>
									</div>
									<div class="content-info pt-2 pb-2">
										<div class="rating-wrapper">
											<div class="tasknum">
												<br> <br>
												<FORM METHOD="post"
													ACTION="<%=request.getContextPath()%>/serch.do">
													<input type="hidden" name="kol_idnum"
														value="${kolMebVO.kol_idnum}"> <input
														type="hidden" name="action" value="getOneKolSearch">
													<input type="submit" value="VIEW PROFILE">
												</FORM>

											</div>
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


	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>


</body>
</html>



<%@ include file="match-footer.jsp"%>
