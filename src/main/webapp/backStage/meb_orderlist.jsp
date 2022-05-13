<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.backStage.model.*"%>
<%@ page import="com.order_master.model.*"%>
<%@ include file="header.jsp"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
OrderMasterService orderMasterSvc = new OrderMasterService();
List<OrderMasterVO> list = orderMasterSvc.getAll();
pageContext.setAttribute("list", list);
%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">訂單列表</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">■測試用管理員■</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="col-md-12">
				<div class="card card-info">
					<!-- <div class="card-header">
                <h3 class="card-title">Files</h3>
                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                    <i class="fas fa-minus"></i>
                  </button>
                </div>
              </div> -->
					<div class="card-body p-0">
						<table class="table tableID table-hover">
							<thead>
								<tr>
									<th>訂單編號 <i class="fas fa-sort-amount-up"></i>
									</th>
									<th>商品編號 <i class="fas fa-sort-amount-up"></i>
									</th>
									<th>交易狀態 <i class="fas fa-sort-amount-up"></i>
									</th>
									<th>訂單成立日期 <i class="fas fa-sort-amount-up"></i>
									</th>
									<td></td>
								</tr>
							</thead>
							<tbody>
								<%@ include file="page1.file"%>
								<c:forEach var="orderMasterVO" items="${list}"
									begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
									<tr>
										<td>${orderMasterVO.order_num}</td>
										<td>${orderMasterVO.product_num}</td>
										<td>${orderMasterVO.order_status}</td>
										<td>${orderMasterVO.order_date}</td>

										<td class="text-right py-0 align-middle">
											<div class="btn-group" data-display="static">
												<div class="btn btn-info">
													<i class="fas fa-eye">_詳細資料</i>
												</div>
												<div class="btn btn-danger" data-toggle="dropdown">
													<i class="fas fa-cog">_更改狀態</i>
												</div>
												<div class="dropdown-menu dropdown-menu">
													<button class="dropdown-item" type="button">
														<i class="fa fa-thumbs-up fa-2x" aria-hidden="true"></i>
														上架
													</button>
													<button class="dropdown-item" type="button">
														<i class="fa fa-thumbs-down fa-2x" aria-hidden="true"></i>
														下架
													</button>
												</div>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<%@ include file="page2.file"%>
					</div>
				</div>
			</div>
		</div>


	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@ include file="footer.jsp"%>