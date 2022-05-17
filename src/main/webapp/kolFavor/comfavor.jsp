<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.companyfavorite.model.*"%>
<%@ page import="com.companymeb.model.*"%>

<%
ComFavorService comFavorService = new ComFavorService();
List<ComFavorVO> list = comFavorService.FindKolFavorite(1);
pageContext.setAttribute("list", list);
%>

<%@ include file="header.jsp"%>
<!-- <script>
	function changeText(){
	var text = document.getElementById("btn").value
	if("加入最愛" == text){
		document.getElementById("btn").value="移除最愛";
	}
	else{
		document.getElementById("btn").value="加入最愛";
	}
}
</script> -->


<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<!-- Main content -->

	<section class="content">



		<div class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1 class="m-0">最愛廠商列表</h1>
					</div>
					<!-- /.col -->
					<div class="col-sm-3">
						<!-- 錯誤列表 -->
						<c:if test="${not empty errorMsgs}">
							<font style="color: red">請修正以下錯誤:</font>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color: red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>
					</div>
					<div class="col-sm-3"></div>
				</div>
			</div>
		</div>

		<section class="content">
			<div class="container-fluid">
				<div class="col-md-12">
					<div class="card card-info">
						<div class="card-body p-0">
							<table class="table sortable table-hover">
								<thead>
									<tr>
										<th>廠商編號</th>
										<th>廠商名稱</th>
										<th>廠商註冊日期</th>
										<th>媒合率</th>
										<th>移除最愛</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="companyMebVO" items="${list}">
										<tr>
											<td>${comFavorVO.com_idnum}</td>
											<td>${companyMebVO.com_account}</td>
											<td>${companyMebVO.com_regdate}</td>
											<td>${companyMebVO.total_rate}</td>
											<td>
												<FORM METHOD="post"
													ACTION="<%=request.getContextPath()%>/comfavor/comfavor.do"
													style="margin-bottom: 0px;">
													<input type="hidden" name="com_idnum" value="${ComFavorVO.com_idnum}">
													<input type="hidden" name="action" value="like">
													<input type="submit" value="加入最愛" class="btn btn-outline-secondary"> 
												</FORM>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	</section>
</div>
</div>

<%@ include file="footer.jsp"%>







