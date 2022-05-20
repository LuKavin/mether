<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ include file="header.jsp"%>
<%@page import="com.order_master.model.*"%>
<%
// CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");//讀取登入者的資料,header有寫這段
OrderMasterService orderMasterService = new OrderMasterService();
List<OrderMasterVO> list = orderMasterService.getMeBAllOrderList(companyMebVO.getCom_idnum());
pageContext.setAttribute("list", list);
%>



<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<!-- Main content -->

	<section class="content">
		<div class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1 class="m-0 aaa">訂單列表</h1>
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
							<table class="table table-hover sortable">
								<thead>
									<tr>
										<th>訂單編號</th>
										<th>商品編號</th>
										<th>日期</th>
										<th>交易狀態</th>
										<td></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="orderMasterVO" items="${list}">
										<tr>
											<td>${orderMasterVO.order_num}</td>
											<td>${orderMasterVO.product_num}</td>
											<td><fmt:formatDate value="${orderMasterVO.order_date}" pattern="yyyy-MM-dd HH:mm" /></td>
											<td>${(orderMasterVO.kol_rate!=null && orderMasterVO.order_status!='交易完成')?"待對方評價":orderMasterVO.order_status}</td>
											
											<td>
												<FORM METHOD="post"
													ACTION="<%=request.getContextPath()%>/comBackStage/order/order.jsp"
													style="width: 150px; display: inline">
<!-- 													<input type="hidden" name="action" value="getOneOrder"> -->
													<input type="hidden" name="order_num" value="${orderMasterVO.order_num}">
													<button class="btn btn-info" type="submit">
													<i class="fa fa-angle-double-right" aria-hidden="true"></i><i>交易流程</i>
													</button>
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







