<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>
<%@ page import="java.util.*"%>

<%
ProductService productService = new ProductService();
List<ProductVO> list = productService.getAll();
pageContext.setAttribute("list", list);
%>


<%@ include file="header.jsp" %>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<!-- Main content -->

			<section class="content">
				<div class="row text-align">
					<div class="col-sm-2"></div>
					<div class="col-sm-8">
						<div class="container h2" style="text-align: center;">商品明細</div>
					</div>
					<div class="col-sm-2"></div>
				</div>
				<br>


				<div class="container">
					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-4">
							<div class="row underli">
								<div class="col-sm-4 cce">商品名稱：</div>
								<div class="col-sm-8 cce">${productVO.product_name}</div>
							</div>
							<div class="row underli">
								<div class="col-sm-4 cce">商品介紹：</div>
								<div class="col-sm-8 cce">${productVO.product_introduce}</div>
							</div>
							<div class="row underli">
								<div class="col-sm-4 cce">商品連結：</div>
								<div class="col-sm-8 cce">
									<a href="${productVO.product_link}">${productVO.product_link}</a>
								</div>
							</div>
							<div class="row underli">
								<div class="col-sm-4 cce">預估預算：</div>
								<div class="col-sm-8 cce">${productVO.product_budget}</div>
							</div>
							<div class="row underli">
								<div class="col-sm-4 cce">商品數量：</div>
								<div class="col-sm-8 cce">${productVO.product_count}</div>
							</div>
							<div class="row underli">
								<div class="col-sm-4 cce">合約內容：</div>
								<div class="col-sm-8 cce">${productVO.product_contract}</div>
							</div>
							<div class="row underli">
								<div class="col-sm-4 cce">截止日期：</div>
								<div class="col-sm-8 cce">${productVO.product_deadline}</div>
							</div>
							<div class="row underli">
								<div class="col-sm-4 cce">預設上下架：</div>
								<div class="col-sm-8 cce">${productVO.product_state}</div>
							</div>

							<div class="row underli">
								<div class="col-sm-4 cce">商品種類：</div>
								<div class="col-sm-8 cce">${product_typename}</div>
							</div>
						</div>
						<div class="col-sm-4">
							<c:if test="${productVO.test_pic!=''}">
								<img
									src="<%=request.getContextPath()%>/viewpic?id=${productVO.product_num}"
									alt="" class = "preview_img">
							</c:if>
						</div>
						<div class="col-sm-2"></div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-4"></div>
						<div class="col-sm-4">
							<div class="row  justify-content-center">
								<a class="btn btn-outline-secondary"
									href="<%=request.getContextPath()%>/product/product.jsp">回首頁</a>
							</div>
						</div>
						<div class="col-sm-4"></div>
					</div>
				</div>
			</section>
		</div>
	</div>

<%@ include file="footer.jsp" %>	
	
	