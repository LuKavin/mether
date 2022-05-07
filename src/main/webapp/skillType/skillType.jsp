<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.platformType.model.*"%>
<%@ page import="java.util.*"%>

<% 
PlatformTypeService platformTypeService = new PlatformTypeService();
List<PlatformTypeVO> list = platformTypeService.getAll();
pageContext.setAttribute("list", list);
%>
<%@ include file="header.jsp" %>
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
			<div class="col-sm-4">
				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">選擇類型</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="#">工作類型</a></li>
						<li><a class="dropdown-item" href="#">專長類型</a></li>
						<li><a class="dropdown-item" href="#">平台類型</a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-4">
				<h6 style="display: inline-block;">新增平台類型</h6>
				<FORM METHOD="post"
					ACTION="<%=request.getContextPath()%>/platformType/platformType.do"
					style="display: inline-block;">
					<input type="text" name="job_typename" placeholder="輸入新平台類型名稱">
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
							</tr>
						</thead>
						<c:forEach var="platformTypeVO" items="${list}">
							<tr>
								<td>${platformVO.platform_typenum}</td>
								<td>${platformVO.platform_typename}</td>
								<td>
									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/platformType/platformType.do"
										style="margin-bottom: 0px;">
										<input type="submit" value="修改"
											class="btn btn-outline-secondary"> <input
											type="hidden" name="job_typenum"
											value="${jobTypeVO.job_typenum}"> <input
											type="hidden" name="action" value="getOne_For_Update">
									</FORM>
								</td>
								<td>
									
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="col-sm-2"></div>
			</div>
		</div>
</body>
		
<%@ include file="footer.jsp" %>

	
	
	
	
	
	
