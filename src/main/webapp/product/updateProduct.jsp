<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>

<%
ProductVO productVO = (ProductVO) request.getAttribute("productVO");
%>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>修改商品</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: auto;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}

.preview_img {
	max-width: 280px;
	max-height: 300px;
}

.sizeholder {
	width: 100%;
	overflow: auto;
}
</style>

</head>

<body bgcolor='white'>





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
			<div class="col-sm-2">
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
			<div class="col-sm-4">
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
							<tr>
								<td>商品種類：</td>
								<td><select name="product_typenum">
										<option value="1" selected>1</option>
								</select></td>
								<!-- 		<input type="TEXT" name="job" size="60" -->
								<%--
													value="<%= (productVO==null)? "" : productVO.getProduct_state()%>" />
												--%>
							</tr>


							<%-- <jsp:useBean id="deptSvc" scope="page"
												class="com.dept.model.DeptService" /> --%>
							<!-- 	<tr> -->
							<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
							<!-- 		<td><select size="1" name="deptno"> -->
							<%-- <c:forEach var="deptVO" items="${deptSvc.all}"> --%>
							<%-- <option value="${deptVO.deptno}"
													${(empVO.deptno==deptVO.deptno)? 'selected' :'' }>${deptVO.dname}
													--%>
							<%-- </c:forEach> --%>
							<!-- 		</select></td> -->
							<!-- 	</tr> -->

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

	<!-- data:image/jpg;base64; -->




	<script>
		document
				.addEventListener(
						"DOMContentLoaded",
						function() {

							document
									.querySelector("#p_file")
									.addEventListener(
											"change",
											function(e) {
												if (this.files.length > 0) {
													preview_img(this.files[0]);
												} else {
													document
															.querySelector("#preview .text").innerText = "預覽圖";
												}

											})

							//函式：接收一個file(圖片)參數，將接收的(圖片)顯示在預覽圖上
							function preview_img(file) {
								var reader = new FileReader();
								reader.readAsDataURL(file)
								reader
										.addEventListener(
												"load",
												function() {
													let db64 = 'data:image/jpg;base64';
													let rr = reader.result;
													var post = `<img src="\${rr}" alt="載入錯誤" class = "preview_img">`;
													document
															.querySelector("#preview .text").innerText = "";//先清空
													if (document
															.querySelector("#preview img") != null) {
														document.querySelector(
																"#preview>img")
																.remove();
													}
													document
															.querySelector(
																	"#preview")
															.insertAdjacentHTML(
																	"beforeend",
																	post);
													console
															.log(document
																	.querySelector("#preview img"));
												})

							}

						})
	</script>

</body>

</html>