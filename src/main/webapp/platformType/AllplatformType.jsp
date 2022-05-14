<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.platformType.model.*"%>
<%@ page import="java.util.*"%>

<%
PlatformTypeService platformTypeService = new PlatformTypeService();
List<PlatformTypeVO> list = platformTypeService.getAll();
pageContext.setAttribute("list", list);
%>
<%@ include file="header.jsp"%>
<html lang="en">
<head>
<title>所有平台類型</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
</head>


<body bgcolor='white'>
	<div class="content-wrapper">
		<br>
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="container h2" style="text-align: center;">
					所有平台類型資料</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h6 style="display: inline-block;">新增平台類型</h6>
				<FORM METHOD="post"
					ACTION="<%=request.getContextPath()%>/PlatformTypeServlet"
					style="display: inline-block;">
					<input type="text" name="platform_typename" placeholder="輸入平台類型名稱">
					<input type="hidden" name="action" value="insert"> <input
						type="submit" value="新增">
				</FORM>
			</div>
			<div class="col-sm-2"></div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<c:if test="${not empty errorMsgs}">
						<font style="color: red">請修正以下錯誤:</font>
						<ul>
							<c:forEach var="message" items="${errorMsgs}">
								<li style="color: red">${message}</li>
							</c:forEach>
						</ul>
					</c:if>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>平台類型編號</th>
								<th>平台類型名稱</th>
								<th>修改</th>
								<th>刪除</th>
							</tr>
						</thead>
						<c:forEach var="platformTypeVO" items="${list}">
							<tr>
								<td>${platformTypeVO.platform_typenum}</td>
								<td>${platformTypeVO.platform_typename}</td>
								<td>
									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/PlatformTypeServlet"
										style="margin-bottom: 0px;">
										<input type="submit" value="修改"
											class="btn btn-outline-secondary"> <input
											type="hidden" name="platform_typenum"
											value="${platformTypeVO.platform_typenum}"> <input
											type="hidden" name="action" value="getOne_For_Update">
									</FORM>
								</td>
								<td>
									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/PlatformTypeServlet"
										style="margin-bottom: 0px;">
										<input type="button" value="刪除"
											class="btn btn-outline-secondary" disabled
											data-bs-toggle="button" onclick="return(confirm('確定刪除?'))">
										<input type="hidden" name="platform_typenum"
											value="${platformTypeVO.platform_typenum}"> <input
											type="hidden" name="action" value="delete">
									</FORM>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="col-sm-2"></div>
			</div>
		</div>
</body>

<%@ include file="footer.jsp"%>








</html>