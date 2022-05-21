<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.backStage.model.*"%>
<%@ page import="com.kolmeb.model.*"%>
<%@ include file="/backStage/header.jsp"%>

<%
KolMebService kolMebService = new KolMebService();
List<KolMebVO> list = kolMebService.getAll();
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
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#"><i
								class="fa fa-home" aria-hidden="true" style="font-size: large"></i></a></li>
						<li class="breadcrumb-item active">(顯示管理員帳號)</li>
					</ol>
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

							<label for="inputSkills" class="col-form-label">網紅名稱:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="Name" value="${kolMebVO.kol_name}"
									disabled="disabled">
							</div>

							<label for="inputSkills" class="col-form-label">網紅帳號:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="account" value="${kolMebVO.kol_account}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">網紅信箱:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="email" value="${kolMebVO.kol_email}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">網紅市話:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="phone" value="${kolMebVO.kol_phone}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">網紅手機: </label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="cellphone" value="${kolMebVO.kol_cellphone}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">網紅地址:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="address" value="${kolMebVO.kol_address}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">網紅網址:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="website" value="${kolMebVO.kol_website}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">網紅生日:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="birthday" value="${kolMebVO.kol_birthday}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">網紅性別:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="gender" value="${kolMebVO.kol_gender}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">註冊日期:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="regdate" value="${kolMebVO.kol_regdate}"
									disabled="disabled">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">身分證號:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="id" value="${kolMebVO.kol_id}" disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">銀行帳戶:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="bankaccount" value="${kolMebVO.kol_bankaccount}"
									disabled="disabled">
							</div>
						</div>

						<div class="form-group row">
							<label for="inputSkills" class="col-form-label">網紅身高:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="founddate" value="${kolMebVO.kol_height}"
									disabled="disabled">
							</div>
							<label for="inputSkills" class="col-form-label">網紅體重:</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="inputSkills"
									placeholder="taxidnum" value="${kolMebVO.kol_weight}"
									disabled="disabled">
							</div>
						</div>
					</form>
					<div align="center">
						<a href="javascript:;" onclick="location='/mether/backStage/kol/meb_kol.jsp'"><input
							type=button value="上一頁" /></a>
					</div>
				</div>
			</div>

		</div>
	</div>

</div>

<%@ include file="/backStage/footer.jsp"%>