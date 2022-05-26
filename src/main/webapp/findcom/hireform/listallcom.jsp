
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

CompanyMebService companyMebService = new CompanyMebService();
List<CompanyMebVO> list2 = companyMebService.getAll();
pageContext.setAttribute("list2", list2);
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
					<h2>商品</h2>
				</div>
			</div>
			<div class="row g-2 row-bottom-padded-md">
				<div class="col-md-0 mx-auto">
					<ul id="fh5co-gallery-list" style="width: 1200px">
						<c:forEach var="productVO" items="${list}">
							<div class="wrapper" style="margin-bottom:100px">

								<div class="card" style="width: 300px; height: 350px;"
									data-animate-effect="fadeIn">
									<div class="float-middle">
										<img style="margin-left: 30px; margin-top:30px" width="150" height="150" alt=""
											src="<%=request.getContextPath()%>/ReadProductAllPhoto?product_num=${productVO.product_num}">
									</div>

									<div class="card-body">
									<br>
										<h4 class="card-title">代言商品:${productVO.product_name}</h4>
										<h4 class="right">預算:${productVO.product_budget}</h4>
										<p class="card-text">商品敘述:${productVO.product_introduce}</p>
										<span href="#" class="badge badge-pill normal facebook">Facebook</span>
										<span href="#" class="badge badge-pill normal instagram">Instagram</span>
										<span href="#" class="badge badge-pill normal youtube">Youtube</span>
									</div>
									<div class="content-info pt-2 pb-2">
										<div class="rating-wrapper">
											<div class="tasknum">
												<span class="task-num">招募:${productVO.product_count}</span>
												<br> <br>
												<FORM METHOD="post"
													ACTION="<%=request.getContextPath()%>/serch.do">
													<input type="hidden" name="product_num"
														value="${productVO.product_num}"> <input
														type="hidden" name="action" value="getOneProductSearch">
													<input type="submit" value="VIEW JOB">
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
		
		
		
		<div class="container">
			<div class="row">
				<div
					class="col-md-8 col-md-offset-2 text-center fh5co-heading animate-box">
					<h2>廠商</h2>
				</div>
			</div>
			<div class="row g-2 row-bottom-padded-md">
				<div class="col-md-0 mx-auto">
					<ul id="fh5co-gallery-list" style="width: 1200px">
						<c:forEach var="companyMebVO" items="${list2}">
							<div class="wrapper" style="margin-bottom:100px">

								<div class="card" style="width: 300px; height: 350px;"
									data-animate-effect="fadeIn">
									<div class="float-middle">
										<img style="margin-left: 30px; margin-top:30px" width="150" height="150" alt=""
											src="<%=request.getContextPath()%>/ReadMemberPhoto?meb_photonum=${ComPhotoVO.meb_photonum}">
									</div>

									<div class="card-body">
									<br>
									<h4 class="card-title">廠商姓名:${companyMebVO.com_name}</h4>
									<h4 class="card-text">廠商電話:${companyMebVO.com_cellphone}</h4>
									<p class="right">廠商信箱:${companyMebVO.com_email}</p>
									<p class="right">廠商地址:${companyMebVO.com_address}</p>
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
												<input type="hidden" name="com_idnum"
													value="${companyMebVO.com_idnum}"> <input
													type="hidden" name="action" value="getOneComSearch">
												<input type="submit" value="VIEW COM">
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
