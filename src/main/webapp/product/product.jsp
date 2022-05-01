<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%@ page import="java.util.*"%>

<%
ProductService productService = new ProductService();
List<ProductVO> list = productService.getAll();
pageContext.setAttribute("list", list);
%>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>商品列表</title>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- jncss -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/awsome.css">
<!-- bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

</head>

<body bgcolor='white'>
	<div class="content-wrapper" style="margin: 60px 160px">
		<div class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1 class="m-0">商品列表</h1>
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
							href="<%=request.getContextPath()%>/product/addProduct.jsp"><i class="fa fa-cube" aria-hidden="true"></i>新增商品+</a>
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
													<input type="hidden" name="state" value="up">
													<input type="hidden" name="com_idnum" value="1">
												<button	class="btn btn-outline-info"> <i class="fa fa-thumbs-up fa-fw" aria-hidden="true"></i><i>_全部上架</i>
												</button>
											</FORM>
											
																						<FORM METHOD="post"
													ACTION="<%=request.getContextPath()%>/product/product.do"
													style="width: 150px; display: inline">
													<input type="hidden" name="action" value="allState">
													<input type="hidden" name="state" value="down">
													<input type="hidden" name="com_idnum" value="1">
												<button	class="btn btn-outline-danger"> <i class="fa fa-thumbs-down fa-fw" aria-hidden="true"></i><i>_全部下架</i>
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
														value="getOne_For_Update">
													<input type="hidden"
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
														<input type="hidden" name="action" value="changeProStDown">
														<input type="hidden" name="product_num"
															value="${productVO.product_num}">
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
	</div>






	<!-- jquery -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
		integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"
		integrity="sha512-BHDCWLtdp0XpAFccP2NifCbJfYoYhsRSZOUM3KnAxy2b/Ay3Bn91frud+3A95brA4wDWV3yEOZrJqgV8aZRXUQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/3.2.0/js/adminlte.min.js"
		integrity="sha512-KBeR1NhClUySj9xBB0+KRqYLPkM6VvXiiWaSz/8LCQNdRpUm38SWUrj0ccNDNSkwCD9qPA4KobLliG26yPppJA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/resources/js/awsome.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/sort.js"></script>


</body>

</html>