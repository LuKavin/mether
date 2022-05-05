<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.adm_meb.model.*"%>
<%
AdmMebVO admMebVO = (AdmMebVO) request.getAttribute("admMebVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>管理員資料修改 - update_AdmMeb_input.jsp</title>

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
				<h3>管理員資料修改 - update_AdmMeb_input.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料修改:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
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
				<td>管理員編號:<font color=red><b>*</b></font></td>
				<td><%=admMebVO.getAdm_idnum()%></td>
			</tr>
			<tr>
				<td>管理員姓名:</td>
				<td><input type="TEXT" name="adm_name" size="45"
					value="<%=admMebVO.getAdm_name()%>" /></td>
			</tr>
			<tr>
				<td>管理員帳號::</td>
				<td><input type="TEXT" name="adm_account" size="45"
					value="<%=admMebVO.getAdm_account()%>" /></td>
			</tr>
			<tr>
				<td>管理員密碼:</td>
				<td><input type="TEXT" name="adm_password" size="45"
					value="<%=admMebVO.getAdm_password()%>" /></td>
			</tr>
			<tr>
				<td>管理員照片:</td>
				<td><input type="file" name="adm_photo" id="upload"
					onchange="loadImageFile(event)" size="50"
					value="<%=admMebVO.getAdm_photo()%>" />
				</td>
			</tr>
			<tr>
			<td>
			 <img id="image" style="max-width: 70px; min-height: 70px"src="<%=request.getContextPath()%>/ReadAdmMebPhoto?adm_idnum=${admMebVO.adm_idnum}">
			</td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="adm_idnum" value="<%=admMebVO.getAdm_idnum()%>">
		<input type="submit" value="送出修改">
	</FORM>

	<script>
		function loadImageFile(event) {
			var image = document.getElementById('image');
			image.src = URL.createObjectURL(event.target.files[0]);
		};
	</script>
</body>

</html>