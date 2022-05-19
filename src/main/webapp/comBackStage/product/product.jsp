<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%@ page import="java.util.*"%>

<%@ include file="header.jsp" %>
<%
ProductService productService = new ProductService();
// CompanyMebVO companyMebVO = (CompanyMebVO) session.getAttribute("companyMebVO");//讀取登入者的資料
List<ProductVO> list = productService.getComAllProduct(companyMebVO.getCom_idnum());
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
								<h1 class="m-0 aaa">商品列表</h1>
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
							<div class="col-sm-3">

								<a class="btn btn-warning"
									href="<%=request.getContextPath()%>/comBackStage/product/addProduct.jsp"><i
									class="fa fa-cube" aria-hidden="true"></i>新增商品+</a>
							</div>
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
												<th>商品編號</th>
												<th>商品名稱</th>
												<th>商品數量</th>
												<th>商品期限</th>
												<th>商品狀態</th>
												<td>
													<FORM METHOD="post"
														ACTION="<%=request.getContextPath()%>/product/product.do"
														style="width: 150px; display: inline">
														<input type="hidden" name="action" value="allState">
														<input type="hidden" name="state" value="up"> <input
															type="hidden" name="com_idnum" value="${companyMebVO.com_idnum}">
														<button class="btn btn-outline-info">
															<i class="fa fa-thumbs-up fa-fw" aria-hidden="true"></i><i>_全部上架</i>
														</button>
													</FORM>

													<FORM METHOD="post"
														ACTION="<%=request.getContextPath()%>/product/product.do"
														style="width: 150px; display: inline">
														<input type="hidden" name="action" value="allState">
														<input type="hidden" name="state" value="down"> <input
															type="hidden" name="com_idnum" value="${companyMebVO.com_idnum}">
														<button class="btn btn-outline-danger">
															<i class="fa fa-thumbs-down fa-fw" aria-hidden="true"></i><i>_全部下架</i>
														</button>
													</FORM>
												</td>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="productVO" items="${list}">
												<tr>
													<td>${productVO.product_num}</td>
													<td>${productVO.product_name}</td>
													<td>${productVO.product_count}</td>
													<td>${productVO.product_deadline}</td>
													<td>${(productVO.product_state=="上架")?'<p>上架</p>':'<p style="color:red">下架</p>'}</td>
													<td>
														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>/product/product.do"
															style="width: 150px; display: inline">
															<input type="hidden" name="action"
																value="getOne_For_Update"> <input type="hidden"
																name="product_num" value="${productVO.product_num}">
															<button class="btn btn-info" type="submit">
																<i class="fas fa-eye"></i><i>查看/修改</i>
															</button>
														</FORM>
														<button class="btn btn-danger" data-toggle="dropdown">
															<i class="fas fa-cog"></i><i>_更改狀態</i>
														</button>
														<div class="dropdown-menu dropdown-menu-left">
															<FORM METHOD="post"
																ACTION="<%=request.getContextPath()%>/product/product.do">
																<input type="hidden" name="action" value="changeProStUp">
																<input type="hidden" name="product_num"
																	value="${productVO.product_num}">
																<button class="dropdown-item" type="submit">
																	<i class="fa fa-thumbs-up fa-2x" aria-hidden="true"></i>上架
																</button>
															</form>
															<FORM METHOD="post"
																ACTION="<%=request.getContextPath()%>/product/product.do">
																<input type="hidden" name="action"
																	value="changeProStDown"> <input type="hidden"
																	name="product_num" value="${productVO.product_num}">
																<button class="dropdown-item" type="submit">
																	<i class="fa fa-thumbs-down fa-2x" aria-hidden="true"></i>下架
																</button>
															</form>
														</div>
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
	
<%@ include file="footer.jsp" %>
	
	
	
	
	
	
	
