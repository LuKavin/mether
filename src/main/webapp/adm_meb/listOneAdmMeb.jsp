<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.adm_meb.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
AdmMebVO admMebVO = (AdmMebVO) request.getAttribute("admMebVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>

	<h4>此頁暫練習採用 Script 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>員工資料 - ListOneAdmMeb.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>管理員編號</th>
			<th>管理員姓名</th>
			<th>管理員帳號</th>
			<th>管理員密碼</th>
			<th>管理員照片</th>
		</tr>
		<tr>
				<td>${admMebVO.adm_idnum}</td>
				<td>${admMebVO.adm_name}</td>
				<td>${admMebVO.adm_account}</td>
				<td>${admMebVO.adm_password}</td>
				<td>
					<img style="max-width: 70px; min-height: 70px"
						src="<%=request.getContextPath()%>/ReadAdmMebPhoto?adm_idnum=${admMebVO.adm_idnum}">
				</td>
		</tr>
	</table>

</body>
</html>