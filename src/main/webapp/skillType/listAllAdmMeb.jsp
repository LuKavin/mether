<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.adm_meb.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
AdmMebService admMebSvc = new AdmMebService();
List<AdmMebVO> list = admMebSvc.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>�Ҧ��޲z����� - listAllAdmMeb.jsp</title>

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
	width: 800px;
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

	<h4>�����m�߱ĥ� EL ���g�k����:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>�Ҧ��޲z����� - listAllAdmMeb.jsp</h3>
				<h4>
					<a href="select_page.jsp">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<table>
		<tr>
			<th>�޲z���s��</th>
			<th>�޲z���m�W</th>
			<th>�޲z���b��</th>
			<th>�޲z���K�X</th>
			<th>�޲z���Ӥ�</th>
			<th>�ק�</th>
			<th>�R��</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="admMebVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${admMebVO.adm_idnum}</td>
				<td>${admMebVO.adm_name}</td>
				<td>${admMebVO.adm_account}</td>
				<td>${admMebVO.adm_password}</td>
				<td>
					<img style="max-width: 70px; min-height: 70px"
						src="<%=request.getContextPath()%>/ReadAdmMebPhoto?adm_idnum=${admMebVO.adm_idnum}">
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/adm_meb/adm_meb.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="�ק�"> <input type="hidden"
							name="adm_idnum" value="${admMebVO.adm_idnum}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/adm_meb/adm_meb.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="�R��"> <input type="hidden"
							name="adm_idnum" value="${admMebVO.adm_idnum}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>