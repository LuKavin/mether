<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM AdmMeb: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM AdmMeb: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM AdmMeb: Home</p>

<h3>��Ƭd��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllAdmMeb.jsp'>List</a> all AdmMebs.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="adm_meb.do" >
        <b>��J�޲z���s�� (�p1):</b>
        <input type="text" name="adm_idnum">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="admMebSvc" scope="page" class="com.adm_meb.model.AdmMebService" />
   
  <li>
     <FORM METHOD="post" ACTION="adm_meb.do" >
       <b>��ܺ޲z���s��:</b>
       <select size="1" name="adm_idnum">
         <c:forEach var="admMebVO" items="${admMebSvc.all}" > 
          <option value="${admMebVO.adm_idnum}">${admMebVO.adm_idnum}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="adm_meb.do" >
       <b>��ܺ޲z���m�W:</b>
       <select size="1" name="adm_idnum">
         <c:forEach var="admMebVO" items="${admMebSvc.all}" > 
          <option value="${admMebVO.adm_idnum}">${admMebVO.adm_name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>


<h3>���u�޲z</h3>

<ul>
  <li><a href='addAdmMeb.jsp'>Add</a> a new AdmMeb.</li>
</ul>

</body>
</html>