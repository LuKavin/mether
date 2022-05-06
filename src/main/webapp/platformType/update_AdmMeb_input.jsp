<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.adm_meb.model.*"%>
<%
AdmMebVO admMebVO = (AdmMebVO) request.getAttribute("admMebVO"); //EmpServlet.java (Concroller) �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>�޲z����ƭק� - update_AdmMeb_input.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>�޲z����ƭק� - update_AdmMeb_input.jsp</h3>
				<h4>
					<a href="select_page.jsp">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>��ƭק�:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="adm_meb.do" name="form1"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>�޲z���s��:<font color=red><b>*</b></font></td>
				<td><%=admMebVO.getAdm_idnum()%></td>
			</tr>
			<tr>
				<td>�޲z���m�W:</td>
				<td><input type="TEXT" name="adm_name" size="45"
					value="<%=admMebVO.getAdm_name()%>" /></td>
			</tr>
			<tr>
				<td>�޲z���b��::</td>
				<td><input type="TEXT" name="adm_account" size="45"
					value="<%=admMebVO.getAdm_account()%>" /></td>
			</tr>
			<tr>
				<td>�޲z���K�X:</td>
				<td><input type="TEXT" name="adm_password" size="45"
					value="<%=admMebVO.getAdm_password()%>" /></td>
			</tr>
			<tr>
				<td>�޲z���Ӥ�:</td>
				<td><input type="file" name="adm_photo" id="upload"
					onchange="loadImageFile(event)" size="50"
					value="<%=admMebVO.getAdm_photo()%>" />
				</td>
			</tr>
			<tr>
			<td>
			 <img id="image" style="max-width: 70px; min-height: 70px"src="">
			</td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="adm_idnum" value="<%=admMebVO.getAdm_idnum()%>">
		<input type="submit" value="�e�X�ק�">
	</FORM>

	<script>
		function loadImageFile(event) {
			var image = document.getElementById('image');
			image.src = URL.createObjectURL(event.target.files[0]);
		};
	</script>
</body>

</html>