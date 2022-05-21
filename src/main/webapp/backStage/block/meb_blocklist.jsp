<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.backStage.model.*"%>
<%@ include file="/backStage/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">黑名單</h1>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="row">
				會員列表> <a href="#" data-toggle="dropdown"> </i>黑名單</i>
				</a>
				<div class="dropdown-menu dropdown-menu">
					<a href="/mether/backStage/com/meb_com.jsp" class="dropdown-item"
						type="button"> 廠商 </a> <a href="/mether/backStage/kol/meb_kol.jsp"
						class="dropdown-item" type="button"> 網紅 </a> <a
						href="/mether/backStage/block/meb_blocklist.jsp"
						class="dropdown-item bg-danger text-white" type="button"> 黑名單
					</a>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-12">
					<div class="card card-info">
						<div class="card-body p-0">
							<table class="table tableID table-hover">
								<thead>
									<tr>
										<th>編號 <i class="fas fa-sort-amount-up"></i>
										</th>
										<th>名稱 <i class="fas fa-sort-amount-up"></i>
										</th>
										<th>接案數量 <i class="fas fa-sort-amount-up"></i>
										</th>
										<th>媒合率 <i class="fas fa-sort-amount-up"></i>
										</th>
									<tr></tr>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>000001</td>
										<td>克偉國際</td>
										<td>15</td>
										<td>200%</td>
										<td class="text-right py-0 align-middle">
											<!--靠右對齊-->
											<div class="btn-group" data-display="static">
												<!--按鈕-->
												<div class="btn btn-info">
													<i class="fas fa-eye">_詳細資料</i>
												</div>
												<div class="btn btn-danger" data-toggle="dropdown">
													<i class="fas fa-cog"></i>_更改權限</i>
												</div>
												<div class="dropdown-menu dropdown-menu">
													<button class="dropdown-item" type="button">
														<i class="fa fa-smile-o fa-2x" aria-hidden="true"></i>
														帳號啟用
													</button>
													<button class="dropdown-item" type="button">
														<i class="fa fa-frown-o fa-2x" aria-hidden="true"></i>
														帳號停用
													</button>
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>000003</td>
										<td>克偉國際</td>
										<td>08</td>
										<td>200%</td>
										<td class="text-right py-0 align-middle">
											<!--靠右對齊-->
											<div class="btn-group" data-display="static">
												<!--按鈕-->
												<div class="btn btn-info">
													<i class="fas fa-eye">_詳細資料</i>
												</div>
												<div class="btn btn-danger" data-toggle="dropdown">
													<i class="fas fa-cog"></i>_更改權限</i>
												</div>
												<div class="dropdown-menu dropdown-menu">
													<button class="dropdown-item" type="button">
														<i class="fa fa-smile-o fa-2x" aria-hidden="true"></i>
														帳號啟用
													</button>
													<button class="dropdown-item" type="button">
														<i class="fa fa-frown-o fa-2x" aria-hidden="true"></i>
														帳號停用
													</button>
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>000007</td>
										<td>克偉國際</td>
										<td>12</td>
										<td>200%</td>
										<td class="text-right py-0 align-middle">
											<!--靠右對齊-->
											<div class="btn-group" data-display="static">
												<!--按鈕-->
												<div class="btn btn-info">
													<i class="fas fa-eye">_詳細資料</i>
												</div>
												<div class="btn btn-danger" data-toggle="dropdown">
													<i class="fas fa-cog"></i>_更改權限</i>
												</div>
												<div class="dropdown-menu dropdown-menu">
													<button class="dropdown-item" type="button">
														<i class="fa fa-smile-o fa-2x" aria-hidden="true"></i>
														帳號啟用
													</button>
													<button class="dropdown-item" type="button">
														<i class="fa fa-frown-o fa-2x" aria-hidden="true"></i>
														帳號停用
													</button>
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>000002</td>
										<td>克偉國際</td>
										<td>01</td>
										<td>200%</td>
										<td class="text-right py-0 align-middle">
											<!--靠右對齊-->
											<div class="btn-group" data-display="static">
												<!--按鈕-->
												<div class="btn btn-info">
													<i class="fas fa-eye">_詳細資料</i>
												</div>
												<div class="btn btn-danger" data-toggle="dropdown">
													<i class="fas fa-cog"></i>_更改權限</i>
												</div>
												<div class="dropdown-menu dropdown-menu">
													<button class="dropdown-item" type="button">
														<i class="fa fa-smile-o fa-2x" aria-hidden="true"></i>
														帳號啟用
													</button>
													<button class="dropdown-item" type="button">
														<i class="fa fa-frown-o fa-2x" aria-hidden="true"></i>
														帳號停用
													</button>
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>000011</td>
										<td>克偉國際</td>
										<td>07</td>
										<td>220%</td>
										<td class="text-right py-0 align-middle">
											<!--靠右對齊-->
											<div class="btn-group" data-display="static">
												<!--按鈕-->
												<div class="btn btn-info">
													<i class="fas fa-eye">_詳細資料</i>
												</div>
												<div class="btn btn-danger" data-toggle="dropdown">
													<i class="fas fa-cog"></i>_更改權限</i>
												</div>
												<div class="dropdown-menu dropdown-menu">
													<button class="dropdown-item" type="button">
														<i class="fa fa-smile-o fa-2x" aria-hidden="true"></i>
														帳號啟用
													</button>
													<button class="dropdown-item" type="button">
														<i class="fa fa-frown-o fa-2x" aria-hidden="true"></i>
														帳號停用
													</button>
												</div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
<!-- /.content -->
<!-- /.content-wrapper -->

<%@ include file="/backStage/footer.jsp"%>