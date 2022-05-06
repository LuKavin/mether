<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>

<%
ProductVO productVO = (ProductVO) request.getAttribute("productVO");
%>

<%@ include file="header.jsp" %>


		<div class="content-wrapper">
			<section class="content">
			<div class="container">
		<div class="row text-align">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="container h2" style="text-align: center;">修改商品</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
		<br>
		<div class="row justify-content-end">
			<div class="col-sm-2">
				<a class="btn btn-outline-danger"
					href="<%=request.getContextPath()%>/product/product.jsp"> 取消修改
				</a>
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
								<td>更新圖片：</td>
								<td><input type="file" accept="image/*" name="p_file"
									id="p_file" /></td>
							</tr>
							<tr>
								<td>商品名稱</td>
								<td><input type="TEXT" name=product_name size="35"
									value="<%=(productVO == null) ? "" : productVO.getProduct_name()%>" />
								</td>
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
									value="<%=(productVO == null) ? "" : productVO.getProduct_link()%>" />
								</td>
							</tr>
							<tr>
								<td>預估預算:</td>
								<td><input type="TEXT" name="product_budget" size="35"
									value="<%=(productVO == null) ? "" : productVO.getProduct_budget()%>" />
								</td>
							</tr>
							<tr>
								<td>商品數量:</td>
								<td><input type="TEXT" name="product_count" size="35"
									value="<%=(productVO == null) ? "" : productVO.getProduct_count()%>" />
								</td>

							</tr>
							<tr>
								<td>合約內容:</td>
								<td><TEXTAREA name="product_contract" cols="35" rows="3"
										style="resize: none"><%=(productVO == null) ? "" : productVO.getProduct_contract()%></TEXTAREA>
								</td>
							</tr>
							<tr>
								<%
								// 得到今天的日期 java.text.DateFormat df=new
java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
String mintime = df.format(new java.util.Date());
%>
								<td>截止日期:</td>
								<td><input type="date" name="product_deadline" size="35	"
									value="<%=(productVO == null) ? mintime : productVO.getProduct_deadline()%>"
									min="<%=productVO.getProduct_deadline()%>" /></td>
							</tr>
							<tr>
								<td>預設上下架：</td>
								<td><select name="product_state">
										<option value="上架"
											${(productVO.product_state=="上架"
															)?'selected':''}>上架</option>
										<option value="下架"
											${(productVO.product_state=="下架"
															)?'selected':''}>下架</option>
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

					<br> <input type="hidden" name="action" value="update">
					<input type="hidden" name="product_num"
						value="${productVO.product_num}"> <input type="submit"
						class="btn btn-secondary" value="確定修改">
				</FORM>
			</div>
			<div class="col-sm-4">
				<div class="row">
					<div id="preview"
						style="height: 400px; width: 300px; border: 1px solid rgb(202, 201, 201); color: rgb(190, 190, 190);">
						<span class="text"> <!-- 							<h6 style="margin: 130px 30px; text-align: center;">預覽圖</h6> -->
							<img
							src="<%=request.getContextPath()%>/viewpic?id=${productVO.product_num}"
							alt="載入錯誤" class="preview_img">
						</span>
					</div>
				</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
			
			
			
			</section>
		</div>

	

<%@ include file="footer.jsp" %>