<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kolmeb.model.*"%>
<%@ page import="com.companymeb.model.*"%>
<%
KolMebVO kolMebVO = (KolMebVO) session.getAttribute("kolMebVO");
CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<style type="text/css">
html, body {
	font: 15px verdana, Times New Roman, arial, helvetica, sans-serif,
		Microsoft JhengHei;
	width: 90%;
	height: 90%;
	background: #ffb7dd;
}

#userName {
	position: absolute;
	top: 50%;
	left: 50%;
	height: 30px;
	width: 250px;
	margin: -50px 121px 0 -130px;
}

#outPopUp {
	position: absolute;
	width: 500px;
	height: 300px;
	z-index: 15;
	top: 50%;
	left: 50%;
	margin: -200px 250px 0 -250px;
}

.button {
	background-color: #ff44aa;
	color: #ffffff;
	border-radius: 5px;
	position: absolute;
	width: 100px;
	height: 40px;
	top: 50%;
	left: 50%;
	top: 50%;
	left: 50%;
	margin: 20px 200px 0 -50px;
}
</style>
<title>Join Us</title>
</head>
<body>
	<div id="outPopUp">
		<h1 align="center">歡迎來到MetHer私人聊天室</h1>
		<form id="myForm" action="<%=request.getContextPath()%>/chat/chat.do"
			method="POST">
			<input id="userName" name="userName" class="text-field" type="text"
				placeholder="尚未註冊的會員請先註冊再使用此功能" readonly="readonly"
				<c:if test="${not empty kolMebVO.kol_name}">value='${kolMebVO.kol_name}'</c:if>
				<c:if test="${not empty companyMebVO.com_name}">value='${companyMebVO.com_name}'</c:if> />
			<input type="submit" id="send" class="button" value="點擊開始聊天"
				onclick="sendName();" />
		</form>

	</div>

</body>
<script>
	var inputUserName = document.getElementById("userName");
	inputUserName.focus();

	function sendName() {
		var userName = inputUserName.value.trim();
		if (userName === "") {
			alert("Input a user name");
			inputUserName.focus();
			return;
		} else {
			document.getElementById("myForm").submit();
		}
	}
</script>

</html>