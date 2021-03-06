<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>

<%
ProductVO productVO = (ProductVO) request.getAttribute("productVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>


<%@ include file="header.jsp"%>


<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<!-- Main content -->

	<section class="content">
		<div class="container">
			<div class="row text-align">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div class="container h2 jntest" style="text-align: center;">新增商品</div>
				</div>
				<div class="col-sm-2"></div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-1">
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
				<div class="col-sm-5">
					<FORM METHOD="POST" enctype="multipart/form-data"
						ACTION="<%=request.getContextPath()%>/product/product.do">
						<div class="sizeholder">
							<table>
								<tr>
									<div style="height:0;overflow:hidden;">
										<input type="file" name="updateFile1" class="updateFile1">
										<input type="file" name="updateFile2" class="updateFile2">
										<input type="file" name="updateFile3" class="updateFile3">
										<input type="file" name="updateFile4" class="updateFile4">
										<input type="file" name="updateFile5" class="updateFile5">

									</div>
								</tr>
								<tr>
									<td>商品名稱</td>
									<td><input type="TEXT" name=product_name size="35"
										value="<%=(productVO == null) ? "" : productVO.getProduct_name()%>" /></td>
								</tr>
								<tr>
									<td>商品介紹:</td>
									<td><TEXTAREA name="product_introduce" cols="35" rows="3"
											style="resize: none"><%=(productVO == null) ? "" : productVO.getProduct_introduce()%></TEXTAREA>
									</td>
								</tr>
								<tr>
									<td>商品連結:</td>
									<td><input type="TEXT" name="product_link" size="35"
										value="<%=(productVO == null) ? "" : productVO.getProduct_link()%>" /></td>
								</tr>
								<tr>
									<td>預估預算:</td>
									<td><input type="TEXT" name="product_budget" size="35"
										value="${(productVO == null)?'':productVO.product_budget}" /></td>
								</tr>
								<tr>
									<td>商品數量:</td>
									<td><input type="TEXT" name="product_count" size="35"
										value="${(productVO == null)?'':productVO.product_count}" /></td>

								</tr>
								<tr>
									<td>合約內容:</td>
									<td><TEXTAREA name="product_contract" cols="35" rows="3"
											style="resize: none"><%=(productVO == null) ? "" : productVO.getProduct_contract()%></TEXTAREA>
									</td>
								</tr>
								<tr>
									<%
									// 得到今天的日期
									java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
									String mintime = df.format(new java.util.Date());
									%>
									<td>截止日期:</td>
									<td><input type="date" name="product_deadline" size="35	"
										value="<%=(productVO == null) ? mintime : productVO.getProduct_deadline()%>"
										min="<%=mintime%>" /></td>
								</tr>
								<tr>
									<td>預設上下架：</td>
									<td><select name="product_state">
											<option value="上架"
												${(productVO.product_state=="上架")? 'selected':'' }>上架</option>
											<option value="下架"
												${(productVO.product_state=="下架")? 'selected':'' }>下架</option>
									</select></td>
								</tr>

								<jsp:useBean id="productTypeService" scope="page"
									class="com.productType.model.ProductTypeService" />
								<tr>
									<td>商品種類:</td>
									<td><select size="1" name="product_typenum">
											<c:forEach var="productTypeVO"
												items="${productTypeService.all}">
												<option value="${productTypeVO.product_typenum}"
													${(productVO.product_typenum==productTypeVO.product_typenum)? 'selected':'' }>${productTypeVO.product_typename}
											</c:forEach>
									</select></td>
								</tr>
							</table>

						</div>

						<br> <input type="hidden" name="action" value="insert">
						<input type="submit" class="btn btn-secondary" value="新增商品">
					</FORM>
				</div>
				<div class="col-sm-4">
					<div>
						<div id="pw" class="container"
							style="border: 1px solid rgb(202, 201, 201); background: url() no-repeat;">

							<div class="row ">
								<div class="editBg ">
									<p class="h3" style="margin: 130px 0;">點擊編輯</p>

								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="col-sm-2"></div>
			</div>
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<div class="row  justify-content-center">
						<a class="btn btn-outline-secondary"
							href="<%=request.getContextPath()%>/comBackStage/product/product.jsp">回首頁</a>
					</div>
				</div>
				<div class="col-sm-4"></div>
			</div>
		</div>

	</section>
</div>
</div>
<div class="overlay">
	<article>
		<div class="row">
			<div class="col-sm-6">
				<h1>修改圖片</h1>
			</div>
			<div class="col-sm-6">
				<button type="button"
					class="btn_modal_close float-sm-right btn btn-lg btn-outline-danger">X</button>
			</div>
		</div>
		<form action="">
			<div class="row ">
				<div id="updatePreview" class="container picBox boxBg1"
					style="border: 1px solid rgb(202, 201, 201); margin: 10px 10px 10px 35px">
					<div class="row ">
						<div class="upadteEditBg ueb1 ">
							<p class="updateP">edit</p>
						</div>
					</div>
				</div>


				<div id="updatePreview" class="container picBox boxBg2"
					style="border: 1px solid rgb(202, 201, 201);">
					<div class="row ">
						<div class="upadteEditBg ueb2 ">
							<p class="updateP">edit</p>
						</div>
					</div>
				</div>


				<div id="updatePreview" class="container picBox boxBg3"
					style="border: 1px solid rgb(202, 201, 201);">
					<div class="row ">
						<div class="upadteEditBg ueb3 ">
							<p class="updateP">edit</p>
						</div>
					</div>
				</div>

				<div id="updatePreview" class="container picBox boxBg4"
					style="border: 1px solid rgb(202, 201, 201);">
					<div class="row ">
						<div class="upadteEditBg ueb4 ">
							<p class="updateP">edit</p>
						</div>
					</div>
				</div>

				<div id="updatePreview" class="container picBox boxBg5"
					style="border: 1px solid rgb(202, 201, 201);">
					<div class="row ">
						<div class="upadteEditBg ueb5 ">
							<p class="updateP">edit</p>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6"></div>
				<div class="col-sm-6">
					<button type="button"
						class="btn float-sm-right btn-outline-secondary updateImgOK"
						style="margin: 15px">送出</button>
				</div>
			</div>
		</form>

	</article>
</div>


<%@ include file="footer.jsp"%>


