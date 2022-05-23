<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.backStage.model.*"%>
<%@ page import="com.companymeb.model.*"%>
<%@ include file="/backStage/header.jsp"%>

<%
CompanyMebService companyMebService = new CompanyMebService();
List<CompanyMebVO> list = companyMebService.getAll();
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

							<label for="inputSkills" class="col-form-label">廠商名稱:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="Name" value="${companyMebVO.com_name}"
									disabled="disabled">
							</div>

							<label for="inputSkills" class="col-form-label">廠商帳號:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="account" value="${companyMebVO.com_account}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">廠商信箱:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="email" value="${companyMebVO.com_email}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">廠商市話:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="phone" value="${companyMebVO.com_phone}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">廠商手機: </label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="cellphone" value="${companyMebVO.com_cellphone}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">廠商地址:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="address" value="${companyMebVO.com_address}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">廠商網址:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="website" value="${companyMebVO.com_website}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">廠商生日:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="birthday" value="${companyMebVO.com_birthday}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">廠商性別:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="gender" value="${companyMebVO.com_gender}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">註冊日期:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="regdate" value="${companyMebVO.com_regdate}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">身分證號:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="id" value="${companyMebVO.com_id}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">銀行帳戶:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="bankaccount"
									value="${companyMebVO.com_bankaccount}" disabled="disabled">
							</div>
						</div>

						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">成立日期:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="founddate" value="${companyMebVO.com_founddate}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">統一編號:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="taxidnum" value="${companyMebVO.com_taxidnum}"
									disabled="disabled">
							</div>
						</div>
					</form>
					<div align="center">
						<a href="javascript:;" onclick="location='/mether/backStage/com/meb_com.jsp'"><input
							type=button value="上一頁" /></a>
					</div>
				</div>
			</div>

		</div>
	</div>

</div>

<%@ include file="/backStage/footer.jsp"%>