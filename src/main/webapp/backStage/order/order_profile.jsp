<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.backStage.model.*"%>
<%@ page import="com.kolmeb.model.*"%>
<%@ include file="/backStage/header.jsp"%>

<%
List list = (List) request.getAttribute("list");
pageContext.setAttribute("list", list);
%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h3 class="m-0" style="font-size: 44px; font-weight: 700;">基本資料</h3>
				</div>

			</div>
		</div>
		<!-- /.container-fluid -->
	</div>

	<!-- Main content -->

	<div class="container-fluid">
		<div class="card-body">
			<div class="tab-content">

				<div class="tab-pane active" id="settings">
					<form class="form-horizontal">
						<div class="form-group row">

							<label for="inputSkills" class="col-form-label">訂單編號:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="Name" value="${list[0].order_num}"
									disabled="disabled">
							</div>

							<label for="inputSkills" class="col-form-label">訂單狀態:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="account" value="${list[0].order_status}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">成立日期:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="email" value="${list[0].order_date}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">商品名稱:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="phone" value="${list[0].product_name}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">商品期限: </label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="cellphone" value="${list[0].product_deadline}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">網紅名稱:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="address" value="${list[0].kol_name}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">廠商名稱: </label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="cellphone" value="${list[0].com_name}"
									disabled="disabled">
							</div>
						</div>

					</form>
					<div align="center">
						<a href="javascript:;"
							onclick="location='/mether/backStage/order/meb_orderlist.jsp'"><input
							type=button value="上一頁" /></a>
					</div>
				</div>
			</div>

		</div>
	</div>

</div>

<%@ include file="/backStage/footer.jsp"%>