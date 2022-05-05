<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.productType.model.*"%>

<%
ProductTypeVO productTypeVO = (ProductTypeVO) request.getAttribute("productTypeVO");
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>商品類型</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"F
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>


</head>
<body bgcolor='white'>

<div class="container">
	<div class="row">
		<div class="h3 text-center p-2">
			商品類型修改
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-3">
			<div class="h4">
				資料修改:
			</div>
		</div>
		<div class="col-sm-1"></div>
		<div class="col-sm-2">
				<a class="btn btn-outline-danger "
					href="<%=request.getContextPath()%>/productType/AllproductType.jsp" style="display:block"> 取消修改
				</a>
		</div>
		<div class="col-sm-3"></div>
	</div>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color:red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card">
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/producttype/producttype.do" name="form1">
				<table>
					<tr>
						<td>商品類型編號:<font color=red><b></b></font></td>
						<td>${productTypeVO.product_typenum}</td>
						<input type="hidden" name="product_typenum" value="${productTypeVO.product_typenum}">
					</tr>
					<tr>
						<td>商品類型編號:</td>
						<td><input type="TEXT" name="product_typename" size="45" value="${productTypeVO.product_typename}" /></td>
					</tr>
				
				</table>
				<br>
				<input type="hidden" name="action" value="update">
				<input type="submit" value="送出修改" class="btn btn-outline-secondary"></FORM>
			</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</body>
</html>