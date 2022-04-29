<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>

<%
ProductVO productVO = (ProductVO) request.getAttribute("productVO"); %>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>新增成功</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
								rel="stylesheet"
								integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
								crossorigin="anonymous">
							<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
								integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
								crossorigin="anonymous"></script>


<style>
	.underli .cce{
		border-bottom: 1px solid rgb(250, 240, 240);
	}
	img{
	  max-width: 250px;
	  max-height: 300px;
	}

</style>



</head>
<body bgcolor='white'>

	<div class="row text-align">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<div class="container h2" style="text-align: center;">
				新增商品成功！！！
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>
	<br>
	

<div class="container">
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-4">
			<div class="row underli">
				<div class="col-sm-4 cce">商品名稱：</div>
				<div class="col-sm-8 cce">${productVO.product_name}</div>
			</div>
			<div class="row underli">
				<div class="col-sm-4 cce">商品介紹：</div>
				<div class="col-sm-8 cce">${productVO.product_introduce}</div>
			</div>
			<div class="row underli">
				<div class="col-sm-4 cce">商品連結：</div>
				<div class="col-sm-8 cce">${productVO.product_link}</div>
			</div>
			<div class="row underli">
				<div class="col-sm-4 cce">預估預算：</div>
				<div class="col-sm-8 cce">${productVO.product_budget}</div>
			</div>
			<div class="row underli">
				<div class="col-sm-4 cce">商品數量：</div>
				<div class="col-sm-8 cce">${productVO.product_count}</div>
			</div>
			<div class="row underli">
				<div class="col-sm-4 cce">合約內容：</div>
				<div class="col-sm-8 cce">${productVO.product_contract}</div>
			</div>
			<div class="row underli">
				<div class="col-sm-4 cce">截止日期：</div>
				<div class="col-sm-8 cce">${productVO.product_deadline}</div>
			</div>
			<div class="row underli">
				<div class="col-sm-4 cce">預設上下架：</div>
				<div class="col-sm-8 cce">${productVO.product_state}</div>
			</div>
			<div class="row underli">
				<div class="col-sm-4 cce">商品種類：</div>
				<div class="col-sm-8 cce">${productVO.product_typenum}</div>
			</div>
		</div>
		<div class="col-sm-4">
		<c:if test="${productVO.test_pic!=''}">
		<img src="<%=request.getContextPath()%>/viewpic?id=${productVO.product_num}" alt="">
		</c:if>
		</div>
		<div class="col-sm-2"></div>





	</div>
</div>








</body>
</html>