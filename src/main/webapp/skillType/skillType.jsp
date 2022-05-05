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

<html>

<head>
<title>所有工作類型</title>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- jncss -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/awsome.css">
<!-- bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

</head>

<body bgcolor='white'>
	<div class="container">
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
					ACTION="<%=request.getContextPath()%>/jobType/jobType.do"
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
										ACTION="<%=request.getContextPath()%>/jobType/jobType.do"
										style="margin-bottom: 0px;">
										<input type="submit" value="修改"
											class="btn btn-outline-secondary"> <input
											type="hidden" name="job_typenum"
											value="${jobTypeVO.job_typenum}"> <input
											type="hidden" name="action" value="getOne_For_Update">
									</FORM>
								</td>
								<td>
									<FORM METHOD="post"
										ACTION="<%=request.getContextPath()%>/jobType/jobType.do"
										style="margin-bottom: 0px;">
										<input type="submit" value="刪除"
											class="btn btn-outline-secondary"
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
		<!-- jquery -->
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
			integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
			crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"
			integrity="sha512-BHDCWLtdp0XpAFccP2NifCbJfYoYhsRSZOUM3KnAxy2b/Ay3Bn91frud+3A95brA4wDWV3yEOZrJqgV8aZRXUQ=="
			crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/3.2.0/js/adminlte.min.js"
			integrity="sha512-KBeR1NhClUySj9xBB0+KRqYLPkM6VvXiiWaSz/8LCQNdRpUm38SWUrj0ccNDNSkwCD9qPA4KobLliG26yPppJA=="
			crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
			crossorigin="anonymous"></script>
		<script src="<%=request.getContextPath()%>/resources/js/awsome.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/sort.js"></script>
</body>

</html>