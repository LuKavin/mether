<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.adm_meb.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
AdmMebVO admMebVO = (AdmMebVO) request.getAttribute("admMebVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
<title>���u��� - listOneEmp.jsp</title>

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

	<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>���u��� - ListOneAdmMeb.jsp</h3>
				<h4>
					<a href="select_page.jsp">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>�޲z���s��</th>
			<th>�޲z���m�W</th>
			<th>�޲z���b��</th>
			<th>�޲z���K�X</th>
			<th>�޲z���Ӥ�</th>
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