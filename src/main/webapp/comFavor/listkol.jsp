<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.kolmeb.model.KolMebVO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.companyfavorite.model.*"%>
<%@ page import="com.companymeb.model.*"%>

<%
KolMebVO kolMebVO = (KolMebVO) session.getAttribute("kolMebVO");
CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");


ComFavorService comFavorService = new ComFavorService();
List list = comFavorService.getAll();
/* List<KolMebVO> list = comFavorService.getAll(); */
/* kolMebVO.getKol_idnum() */
pageContext.setAttribute("list", list);
%>


<%@ include file="header.jsp"%>



<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>網紅列表</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Contacts</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<section class="content">

		<div class="card card-solid">
			<div class="card-body pb-0">
				<div class="row">
					<c:forEach var="kolMebVO" items="${list}">
						<div
							class="col-12 col-sm-6 col-md-4 d-flex align-items-stretch flex-column">
							<div class="card bg-light d-flex flex-fill">
								<div class="card-header text-muted border-bottom-0"></div>
								<div class="card-body pt-0">

									<div class="row">
										<div class="col-12 text-center">

											<img  style="max-width: 150px; min-height: 150px" alt="user-avatar"
												class="img-circle img-fluid"
												src="<%=request.getContextPath()%>/ReadKolMemberPhoto?kol_idnum=${kolMebVO.kol_idnum}">

										</div>
										<div>
											<div class="col-12">
												<h2 class="lead">
													<b>${kolMebVO.kol_name}</b>
												</h2>

												<ul class="ml-4 mb-0 fa-ul text-muted">
													<li class="small"><span class="fa-li"><i
															class="fas fa-id-card"></i></span>Meb no.: ${kolMebVO.kol_idnum}</li>
													<li class="small"><span class="fa-li"><i
															class="far fa-envelope"></i></span>Email: ${kolMebVO.kol_email}</li>
													<li class="small"><span class="fa-li"><i
															class="fas fa-lg fa-building"></i></span>Website:
														${kolMebVO.kol_website}</li>
													<li class="small"><span class="fa-li"><i
															class="fas fa-lg fa-phone"></i></span>Company Phone:
														${kolMebVO.kol_phone}</li>
												</ul>
											</div>

										</div>

									</div>
								</div>
								<div class="card-footer">
									<div class="text-right">
										<FORM METHOD="post"
											ACTION="<%=request.getContextPath()%>/comfavor/comfavor.do"
											style="margin-bottom: 0px;">
											<a href="#" class="btn btn-sm bg-teal"> <i
												class="fas fa-comments"></i>
											</a> <a href="#" class="btn btn-sm btn-primary"> <i
												class="fas fa-user"></i> View Profile
											</a> <input type="submit" value="新增最愛"
												class="btn btn-outline-secondary" data-bs-toggle="button">
											<input type="hidden" name="kol_idnum"
												value="${kolMebVO.kol_idnum}"> <input type="hidden"
												name="action" value="like">

										</FORM>

									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="card-footer">
				<nav aria-label="Contacts Page Navigation">
					<ul class="pagination justify-content-center m-0">
						<li class="page-item active"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">5</a></li>
						<li class="page-item"><a class="page-link" href="#">6</a></li>
						<li class="page-item"><a class="page-link" href="#">7</a></li>
						<li class="page-item"><a class="page-link" href="#">8</a></li>
					</ul>
				</nav>
			</div>

		</div>

	</section>
</div>

<%@ include file="footer.jsp"%>







