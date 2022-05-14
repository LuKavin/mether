<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.jobType.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
JobService jobTypeSvc = new JobService();
List<JobTypeVO> list = jobTypeSvc.getAll();
pageContext.setAttribute("list", list);
%>

<%-- <jsp:useBean id="deptSvc" scope="page" class="com.jobType.model.JobService" /> --%>
<%@ include file="header.jsp"%>
<html>

<head>
<title>所有工作類型</title>


<body bgcolor='white'>
	<div class="content-wrapper">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="container h2" style="text-align: center;">
					所有工作類型資料</div>
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
				<h6 style="display: inline-block;">新增工作類型</h6>
				<FORM METHOD="post"
					ACTION="<%=request.getContextPath()%>/JobtypeServlet"
					style="display: inline-block;">
					<input type="text" name="job_typename" placeholder="輸入新工作類型名稱">
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
								<th>工作類型編號</th>
								<th>工作類型名稱</th>
								<th>修改</th>
								<th>刪除</th>
							</tr>
						</thead>
						<c:forEach var="jobTypeVO" items="${list}">
							<tr>
								<td>${jobTypeVO.job_typenum}</td>
								<td>${jobTypeVO.job_typename}</td>
								<td>
									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/JobtypeServlet"
										style="margin-bottom: 0px;">
										<input type="submit" value="修改"
											class="btn btn-outline-secondary">
										<input type="hidden" name="job_typenum"	value="${jobTypeVO.job_typenum}">
										<input type="hidden" name="action" value="getOne_For_Update">
									</FORM>
								</td>
								<td>
									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/JobtypeServlet"
										style="margin-bottom: 0px;">
										<input type="submit" value="刪除"
											class="btn btn-outline-secondary" disabled
											data-bs-toggle="button"
											onclick="return(confirm('確定刪除?'))"> <input
											type="hidden" name="job_typenum"
											value="${jobTypeVO.job_typenum}"> <input
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