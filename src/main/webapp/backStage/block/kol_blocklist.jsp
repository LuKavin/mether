<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.backStage.model.*"%>
<%@ page import="com.kolmeb.model.*"%>
<%@ page import="com.companymeb.model.*"%>
<%@ include file="/backStage/header.jsp"%>
<%
BackStageService backStageSvc = new BackStageService();
List list = backStageSvc.getKolAccess4();
pageContext.setAttribute("list", list);
%>

<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">網紅黑名單</h1>
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
				會員列表> <a href="#" data-toggle="dropdown"> </i>網紅</i>
				</a>
				<div class="dropdown-menu dropdown-menu">
					<a href="/mether/backStage/com/meb_com.jsp" class="dropdown-item" type="button"> 廠商 </a>
					<a href="/mether/backStage/kol/meb_kol.jsp" class="dropdown-item"
						type="button"> 網紅 </a>
						<a href="/mether/backStage/block/com_blocklist.jsp"
						class="dropdown-item" type="button"> 廠商黑名單 </a>
						<a href="/mether/backStage/block/kol_blocklist.jsp"
						class="dropdown-item bg-danger text-white" type="button"> 網紅黑名單 </a>
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
										<th>網紅編號 <i class="fas fa-sort-amount-up"></i>
										</th>
										<th>網紅名稱 <i class="fas fa-sort-amount-up"></i>
										</th>
										<th>網紅註冊日期 <i class="fas fa-sort-amount-up"></i>
										</th>
										<th>目前權限代碼 <i class="fas fa-sort-amount-up"></i>
										</th>
									<tr></tr>
									</tr>
								</thead>
								<tbody>
									<%@ include file="/backStage/page1.file"%>
									<c:forEach var="kolMebVO" items="${list}"
										begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
										<tr>
											<td>${kolMebVO.kol_idnum}</td>
											<td>${kolMebVO.kol_name}</td>
											<td>${kolMebVO.kol_regdate}</td>
											<td>${kolMebVO.meb_accessnum}</td>

											<td class="text-right py-0 align-middle">
												<!--靠右對齊-->
												<div class="btn-group" data-display="static">
													<!--按鈕-->
													<div class="btn btn-info">
														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>/backStage/backStage.do"
															style="width: 150px; display: inline">
															<input type="hidden" name="action" value="getOneKol4">
															<input type="hidden" name="kol_idnum"
																value="${kolMebVO.kol_idnum}">
															<button class="btn btn-info" type="submit">
																<i class="fas fa-eye">_詳細資料</i>
															</button>
														</FORM>
													</div>
													<div class="btn btn-danger" data-toggle="dropdown">
														<i class="fas fa-cog">_更改權限</i>
													</div>
													<div class="dropdown-menu dropdown-menu">
														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>/backStage/backStage.do">
															<input type="hidden" name="action" value="KolUpdate2">
															<input type="hidden" name="kol_idnum"
																value="${kolMebVO.kol_idnum}">
															<button class="dropdown-item" type="submit">
																<i class="fa fa-smile-o fa-2x" aria-hidden="true"></i>
																帳號啟用
															</button>
														</form>

													</div>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<%@ include file="/backStage/page2.file"%>
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