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
<title>�u�@���O</title>

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
	<tr><td>
		 <h3>�u�@���O�ק�</h3>
<!-- 		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4> -->
	</td></tr>
</table>

<h3>��ƭק�:</h3>
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/jobType/jobType.do" name="form1">
<table>
	<tr>
		<td>�u�@�����s��:<font color=red><b></b></font></td>
		<td><%=jobTypeVO.getJob_typenum()%></td>
		<input type="hidden" name="job_typenum" value="<%=jobTypeVO.getJob_typenum()%>">
	</tr>
	<tr>
		<td>�u�@�����s��:</td>
		<td><input type="TEXT" name="job_typename" size="45" value="<%=jobTypeVO.getJob_typename()%>" /></td>
	</tr>

<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" /> --%>
<!-- 	<tr> -->
<!-- 		<td>����:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%>
<%-- 				<option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)?'selected':'' } >${deptVO.dname} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="submit" value="�e�X�ק�"></FORM>
</body>




</html>