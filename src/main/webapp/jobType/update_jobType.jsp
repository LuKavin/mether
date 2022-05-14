<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.jobType.model.*"%>

<%
JobTypeVO jobTypeVO = (JobTypeVO) request.getAttribute("jobTypeVO"); //EmpServlet.java (Concroller) �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>
<%-- --<%= empVO==null %>--${empVO==null}--${empVO.deptno} --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�u�@����</title>
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
			�u�@�����ק�
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-3">
			<div class="h4">
				��ƭק�:
			</div>
		</div>
		<div class="col-sm-1"></div>
		<div class="col-sm-2">
				<a class="btn btn-outline-danger "
					href="<%=request.getContextPath()%>/jobType/AlljobType.jsp" style="display:block"> �����ק�
				</a>
		</div>
		<div class="col-sm-3"></div>
	</div>
	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">�Эץ��H�U���~:</font>
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
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/JobtypeServlet" name="form1">
				<table>
					<tr>
						<td>�u�@�����s��:<font color=red><b></b></font></td>
						<td>${jobTypeVO.job_typenum}</td>
						<input type="hidden" name="job_typenum" value="${jobTypeVO.job_typenum}">
					</tr>
					<tr>
						<td>�u�@�����W��:</td>
						<td><input type="TEXT" name="job_typename" size="45" value="${jobTypeVO.job_typename}" /></td>
					</tr>
				
				</table>
				<br>
				<input type="hidden" name="action" value="update">
				<input type="submit" value="�e�X�ק�" class="btn btn-outline-secondary"></FORM>
			</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</body>

</html>