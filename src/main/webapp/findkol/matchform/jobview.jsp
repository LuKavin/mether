
<%@page import="com.product.model.ProductVO"%>
<%@page import="com.product.model.ProductService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.companymeb.model.*"%>
<%@page import="com.kolmeb.model.KolMebVO"%>
<%@page import="java.util.List"%>
<%@ page import="com.kolfavorite.model.*"%>
<%@ include file="header.jsp"%>

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
				</div>

			</div>
		</nav>


		<div class="content-wrapper">
			<div class="row">
				<div class="col-12 table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>No.</th>
								<th>標題</th>
								<th>產品介紹</th>
								<th>工作內容</th>
								<th>工作申請</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="productVO" items="${list}" varStatus="s">
								<FORM METHOD="post"
									ACTION="<%=request.getContextPath()%>/matchform/match.do">
								<tr>
									<td>${s.index+1}</td>
									<td>${productVO.product_name}</td>
									<td>${productVO.product_introduce}</td>
									<td>${productVO.product_deadline}</td>



									<td><input 
										type="submit" value="申請媒合" class="btn btn-primary"> <input
										type="hidden" name="product_num"
										value="${productVO.product_num}"> <input type="hidden"
										name="action" value="insert"></td>


								</tr>
								</FORM>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>



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



<%@ include file="footer.jsp"%>
